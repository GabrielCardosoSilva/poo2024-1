package entities;

import java.util.Objects;

public class MensagemParaAlguem extends Mensagem{

    private String emailDestinatario;
    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        return (isAnonima() == true) ? "Mensagem  para %s. Texto: %s".formatted(getEmailDestinatario(), getTexto()) : "Mensagem de: %s para %s. Texto:  %s".formatted(getEmailRemetente(), getEmailDestinatario(), getTexto());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MensagemParaAlguem that)) return false;
        return Objects.equals(getEmailDestinatario(), that.getEmailDestinatario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmailDestinatario());
    }
}
