import java.time.LocalDate;

public class PaperBook extends Paper implements Loanable, Readable {

    private String isbn;

    private Prestito prestito;

    private Utente utenteConsultazione;

    public PaperBook(String isbn, String title, String editor, String autore) {

        super(title, editor, autore);

        this.isbn = isbn;
        this.prestito = null;
        this.utenteConsultazione = null;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String getChiaveCategoria() {
        return isbn;
    }

    // ==============================
    // METODI DELL'INTERFACCIA LOANABLE
    // ==============================

    @Override
    public void presta(Utente utente) {

        // Quando prestiamo il prodotto creiamo il Prestito
        // con utente + data odierna.
        this.prestito = new Prestito(utente, LocalDate.now());
    }

    @Override
    public void restituisci() {

        // Il prodotto non è più in prestito
        this.prestito = null;
    }

    @Override
    public Prestito getPrestito() {
        return prestito;
    }

    // ==============================
    // METODI DELL'INTERFACCIA READABLE
    // ==============================

    @Override
    public void consulta(Utente utente) {

        // Salviamo l'utente che sta consultando il prodotto
        this.utenteConsultazione = utente;
    }

    @Override
    public void restituisciConsultazione() {

        // Nessun utente sta più consultando il prodotto
        this.utenteConsultazione = null;
    }

    @Override
    public Utente getUtenteConsultazione() {
        return utenteConsultazione;
    }
}
