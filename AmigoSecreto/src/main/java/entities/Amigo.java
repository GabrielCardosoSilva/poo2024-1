package entities;

import java.util.Objects;

public class Amigo {
    private String nome;
    private String email;
    private String emailAmigoSorteado;

    public Amigo(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.emailAmigoSorteado = emailAmigoSorteado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAmigoSorteado() {
        return emailAmigoSorteado;
    }

    public void setEmailAmigoSorteado(String emailAmigoSorteado) {
        this.emailAmigoSorteado = emailAmigoSorteado;
    }

    @Override
    public String toString() {
        return "Amigo{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", emailAmigoSorteado='" + emailAmigoSorteado + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Amigo amigo)) return false;
        return Objects.equals(getNome(), amigo.getNome()) && Objects.equals(getEmail(), amigo.getEmail()) && Objects.equals(getEmailAmigoSorteado(), amigo.getEmailAmigoSorteado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getEmail(), getEmailAmigoSorteado());
    }
}
