import java.util.*;

public interface Loanable {

    // Presta il prodotto all'utente
    void presta(Utente utente);

    // Restituisce il prodotto
    void restituisci();

    // Permette alla Library di sapere se il prodotto è in prestito
    Prestito getPrestito();
}
