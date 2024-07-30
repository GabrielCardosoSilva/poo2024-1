
package Program;

import entities.*;
import exception.AmigoJaExisteException;
import exception.ListaNulaException;

import java.util.HashMap;
import java.util.Map;

public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigoMap sistema = new SistemaAmigoMap();

        try {
            // Cadastro de amigos
            sistema.cadastraAmigo("José", "jose@gmail.com");
            sistema.cadastraAmigo("Maria", "maria@gmail.com");

            // Configuração de amigos secretos
            sistema.configuraAmigoSecretoDe("jose@gmail.com", "maria@gmail.com");
            sistema.configuraAmigoSecretoDe("maria@gmail.com", "jose@gmail.com");

            // Envio de mensagens
            sistema.enviarMensagemParaAlguem("vai corinthians", "maria@gmail.com", "jose@gmail.com", true);
            sistema.enviarMensagemParaTodos("VAI CORINTHIANS", "maria@gmail.com", true);

            // Pesquisa de mensagens anônimas
            for (Mensagem mensagem : sistema.pesquisaMensagensAnonimas()) {
                System.out.println(mensagem.getTextoCompletoAExibir());
            }

            // Verificação de amigo secreto
            String amigoSecreto = sistema.pesquisaAmigoSecretoDe("jose@gmail.com");
            if (amigoSecreto.equals("maria@gmail.com")) {
                System.out.println("ok");
            } else {
                System.out.println("ERRO");
            }
        } catch (AmigoJaExisteException | ListaNulaException e) {
            e.printStackTrace();
        }
    }
}
