package entities;
//gg
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagems;
    private List<Amigo> amigos;

    public SistemaAmigo(){
        mensagems = new ArrayList<>();
        amigos = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo){
        this.amigos.add(new Amigo(nomeAmigo,emailAmigo));
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoNaoEncontradoException{
        for(Amigo x: amigos){
            if(x.getEmail().equalsIgnoreCase(emailAmigo)){
                return x;
            }
        }
        throw new AmigoNaoEncontradoException("Amigo não encontrado");
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        mensagems.add(new MensagemParaTodos(texto, emailRemetente, ehAnonima));
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
            mensagems.add(new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima));
    }

    public void sortear() {
        List<Amigo> amigosNaoSorteados = new ArrayList<>(this.amigos);
        Collections.shuffle(amigosNaoSorteados);

        for (Amigo amigo : this.amigos) {
            int posicaoDaListaSorteada = (int) (Math.random() * amigosNaoSorteados.size());
            while (amigo.getEmail().equals(amigosNaoSorteados.get(posicaoDaListaSorteada).getEmail())) {
                posicaoDaListaSorteada = (int) (Math.random() * amigosNaoSorteados.size());
            }
            Amigo amigoSorteado = amigosNaoSorteados.get(posicaoDaListaSorteada);
            amigo.setEmailAmigoSorteado(amigoSorteado.getEmail());
            amigosNaoSorteados.remove(posicaoDaListaSorteada);
        }
    }
    public List<Mensagem> pesquisaMensagensAnonimas() throws ListaNulaException{
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
        for(Amigo x: this.amigos){
            if(x.getEmail().equalsIgnoreCase(emailDaPessoa)){
                x.setEmailAmigoSorteado(emailAmigoSorteado);
                confirma = true;
            }
        }
        if(!confirma){
            throw new AmigoNaoEncontradoException("A pessoa mencionada não foi cadastrada");
        }
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa){
        for(Amigo x: this.amigos){
            if(x.getEmail().equalsIgnoreCase(emailDaPessoa)){
                return x.getEmailAmigoSorteado();
            }
        }
        throw new AmigoNaoEncontradoException("Pessoa não encontrada");
    }
    public List<Amigo> getListaAmigos(){
        return this.amigos;
    }

}
