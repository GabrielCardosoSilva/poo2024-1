package entities;

public class MensagemParaTodos extends Mensagem{
    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
    }

    @Override
    public String getTextoCompletoAExibir() {
        return (isAnonima() == true) ? "Mensagem para todos. Texto: %s".formatted(getTexto()) : "Mensagem de %s para todos.  Texto: %s".formatted(getEmailRemetente(), getTexto());
    }
}
