public class PaperJournal extends Paper implements Readable {

    private String issn;

    private Utente utenteConsultazione;

    public PaperJournal(String issn, String title, String editor, String autore) {

        super(title, editor, autore);

        this.issn = issn;
        this.utenteConsultazione = null;
    }

    public String getIssn() {
        return issn;
    }

    @Override
    public String getChiaveCategoria() {
        return issn;
    }

    @Override
    public void consulta(Utente utente) {

        this.utenteConsultazione = utente;
    }

    @Override
    public void restituisciConsultazione() {

        this.utenteConsultazione = null;
    }

    @Override
    public Utente getUtenteConsultazione() {
        return utenteConsultazione;
    }
}
