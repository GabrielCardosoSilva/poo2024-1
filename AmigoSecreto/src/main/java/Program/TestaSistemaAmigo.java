package Program;

import entities.*;

public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();
        //3a
        sistema.cadastraAmigo("José", "jose@gmail.com");
        sistema.cadastraAmigo("Maria", "maria@gmail.com");
        //3b
        sistema.configuraAmigoSecretoDe("jose@gmail.com", "maria@gmail.com");
        sistema.configuraAmigoSecretoDe("maria@gmail.com", "jose@gmail.com");
        //3c
        sistema.enviarMensagemParaAlguem("vai corinthians","maria@gmail.com","jose@gmail.com", true);
        //3d
        sistema.enviarMensagemParaTodos("VAI COTINTHIANS", "maria@gmail.com",true);
        //3e
        for(Mensagem x: sistema.pesquisaMensagensAnonimas()){
            System.out.println(x.getTextoCompletoAExibir());
        }
        //3f
        String amigoSecreto = sistema.pesquisaAmigoSecretoDe("jose@gmail.com");
        if(amigoSecreto.equals("maria@gmail.com")){
            System.out.println("ok");
        } else {
            System.out.println("ERRO");
        }

    }
}
