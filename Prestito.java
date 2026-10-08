import java.time.LocalDate;

public class Prestito {

    private Utente utente;
    private LocalDate dataInizio;

    public Prestito(Utente utente, LocalDate dataInizio) {
        this.utente = utente;
        this.dataInizio = dataInizio;
    }

    public Utente getUtente() {
        return utente;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "utente=" + utente +
                ", dataInizio=" + dataInizio +
                '}';
    }
}
