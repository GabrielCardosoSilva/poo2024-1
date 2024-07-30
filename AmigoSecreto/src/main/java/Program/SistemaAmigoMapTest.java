package Program;

import entities.Mensagem;
import entities.SistemaAmigoMap;
import exception.AmigoJaExisteException;

public class SistemaAmigoMapTest {
    public static void main(String[] args) throws AmigoJaExisteException {


        SistemaAmigoMap sistema = new SistemaAmigoMap();

        sistema.cadastraAmigo("José", "jose@gmail.com");
        sistema.cadastraAmigo("Maria", "maria@gmail.com");

        sistema.configuraAmigoSecretoDe("jose@gmail.com", "maria@gmail.com");
        sistema.configuraAmigoSecretoDe("maria@gmail.com", "jose@gmail.com");

        sistema.enviarMensagemParaAlguem("vai corinthians", "maria@gmail.com", "jose@gmail.com", true);

        sistema.enviarMensagemParaTodos("VAI CORINTHIANS", "maria@gmail.com", true);

        for (Mensagem x : sistema.pesquisaMensagensAnonimas()) {
            System.out.println(x.getTextoCompletoAExibir());
        }

        String amigoSecreto = sistema.pesquisaAmigoSecretoDe("jose@gmail.com");
        if (amigoSecreto.equals("maria@gmail.com")) {
            System.out.println("ok");
        } else {
            System.out.println("ERRO");
        }

    }
}
