public class Utente {

    private String nome;
    private String email;
    private String codiceFiscale;

    public Utente(String nome, String email, String codiceFiscale) {
        this.nome = nome;
        this.email = email;
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                '}';
    }
}
