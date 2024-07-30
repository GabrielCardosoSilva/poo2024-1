package entities;

import exception.AmigoJaExisteException;
import exception.AmigoNaoEncontradoException;
import exception.ListaNulaException;

import java.util.*;

public class SistemaAmigoMap {
    private List<Mensagem> mensagems;
    private Map<String ,Amigo> amigos;

    public SistemaAmigoMap(){
        mensagems = new ArrayList<>();
        amigos = new HashMap<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException{
        if(!this.amigos.containsKey(emailAmigo)){
            this.amigos.put(emailAmigo, new Amigo(nomeAmigo, emailAmigo));
        }
        else {
            throw new AmigoJaExisteException("Ja existe essa pessoa no sistema!");
        }
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoNaoEncontradoException {
        Amigo a = this.amigos.get(emailAmigo);
        if(a==null){
            throw new AmigoNaoEncontradoException("Amigo não encontrado");
        }
        else {
            return a;
        }
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        mensagems.add(new MensagemParaTodos(texto, emailRemetente, ehAnonima));
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        mensagems.add(new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima));
    }

    public void sortear() {
        Map<String, Amigo> amigosNaoSorteados = new HashMap<>(this.amigos);
        List<String> chavesNaoSorteadas = new ArrayList<>(amigosNaoSorteados.keySet());
        Collections.shuffle(chavesNaoSorteadas);

        for (String chave : this.amigos.keySet()) {
            Amigo amigoAtual = this.amigos.get(chave);

            // Encontrar um amigo diferente para o sorteio
            String chaveSorteada;
            do {
                chaveSorteada = chavesNaoSorteadas.remove(0);
            } while (chave.equals(chaveSorteada) && !chavesNaoSorteadas.isEmpty());

            Amigo amigoSorteado = amigosNaoSorteados.get(chaveSorteada);
            amigoAtual.setEmailAmigoSorteado(amigoSorteado.getEmail());
            amigosNaoSorteados.remove(chaveSorteada);
        }
    }
    public List<Mensagem> pesquisaMensagensAnonimas() throws ListaNulaException {
        List<Mensagem> listaAnonima = new ArrayList<>();
        for(Mensagem x: mensagems){
            if(x.isAnonima()){
                listaAnonima.add(x);
            }
        }if (listaAnonima.isEmpty()) {
            throw new ListaNulaException("Não foi registrada nenhuma mensagem anônima");
        } else {
            return listaAnonima;
        }
    }

    public List<Mensagem> pesquisaTodasAsMensagens() throws ListaNulaException{
        if(mensagems.isEmpty()){
            throw new ListaNulaException("Nenhuma mensagem foi registrada");
        } else {
            return mensagems;
        }
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoNaoEncontradoException{
        boolean confirma = false;
        for(String x: this.amigos.keySet()){
            if(amigos.get(x).getEmail().equalsIgnoreCase(emailDaPessoa)){
                amigos.get(x).setEmailAmigoSorteado(emailAmigoSorteado);
                confirma = true;
            }
        }
        if(!confirma){
            throw new AmigoNaoEncontradoException("A pessoa mencionada não foi cadastrada");
        }
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa){
        for(String x: this.amigos.keySet()){
            if(amigos.get(x).getEmail().equalsIgnoreCase(emailDaPessoa)){
                return amigos.get(x).getEmailAmigoSorteado();
            }
        }
        throw new AmigoNaoEncontradoException("Pessoa não encontrada");
    }
    public Map<String, Amigo> getListaAmigos(){
        return this.amigos;
    }
}
