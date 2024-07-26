package Program;

import entities.Amigo;
import entities.Mensagem;
import entities.SistemaAmigo;
//gggg
import java.util.List;
import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[]args){
        Scanner resp = new Scanner(System.in);

        SistemaAmigo sistemaAmigo = new SistemaAmigo();

        System.out.print("Digite a quantidade de pessoas que irão participar do AMIGO SECRETO: ");
        int quantidade = Integer.parseInt(resp.nextLine());


        for(int k = 1; k <= quantidade; k++){
            System.out.println("\nParticipante #" + k);
            System.out.print("Digite o nome: ");
            String nome = resp.nextLine();

            System.out.print("Digite o email: ");
            String email = resp.nextLine();

            sistemaAmigo.cadastraAmigo(nome, email);
        }

        sistemaAmigo.sortear();
        for (Amigo a : sistemaAmigo.getListaAmigos()){
            String emailAmigoSorteado = sistemaAmigo.pesquisaAmigoSecretoDe(a.getEmail());
            System.out.println(a.getNome() + " tirou " + emailAmigoSorteado);
        }

        System.out.print("Deseja enviar alguma mensagem para todos? (s ou n): ");
        String resposta = resp.nextLine();

        if(resposta.equalsIgnoreCase("s")){
            System.out.print("Digite o nome do remetente: ");
            String remetente = resp.nextLine();

            System.out.print("Digite a mensagem: ");
            String mensagem = resp.nextLine();

            System.out.print("A mensagem deve ser passada de forma anônima? (s ou n)");
            String respostaAnonima = resp.nextLine();

            if(respostaAnonima.equalsIgnoreCase("s")){
                sistemaAmigo.enviarMensagemParaTodos(mensagem, remetente, true);
            }else{
                sistemaAmigo.enviarMensagemParaTodos(mensagem, remetente, false);
            }
            List<Mensagem> mensagens = (sistemaAmigo.pesquisaTodasAsMensagens());
            for(Mensagem m : mensagens){
                System.out.println(m.getTextoCompletoAExibir());
            }

            System.out.println("\n Programa finalizado");
        }else{
            System.out.println("Programa finalizado");
            resp.close();
        }

    }
}