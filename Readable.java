public interface Readable {

    // Inizia la consultazione
    void consulta(Utente utente);

    // Termina la consultazione
    void restituisciConsultazione();

    // Permette alla Library di sapere chi sta consultando
    Utente getUtenteConsultazione();
}
