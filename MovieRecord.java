import java.time.LocalDate;

public class MovieRecord extends Product implements Loanable {

    private String isan;

    private Prestito prestito;

    public MovieRecord(String isan, String title, String editor, String autore) {

        super(title, editor, autore);

        this.isan = isan;
        this.prestito = null;
    }

    public String getIsan() {
        return isan;
    }

    @Override
    public String getChiaveCategoria() {
        return isan;
    }

    @Override
    public void presta(Utente utente) {

        this.prestito = new Prestito(utente, LocalDate.now());
    }

    @Override
    public void restituisci() {

        this.prestito = null;
    }

    @Override
    public Prestito getPrestito() {
        return prestito;
    }
}
