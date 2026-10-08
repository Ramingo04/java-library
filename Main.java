import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // ==========================================
        // CREAZIONE LIBRARY
        // ==========================================

        Library library = new Library();

        // ==========================================
        // CREAZIONE DEI PRODOTTI
        // ==========================================

        PaperBook book1 = new PaperBook(
                "ISBN-001",
                "Il Signore degli Anelli",
                "Bompiani",
                "Tolkien"
        );

        PaperBook book2 = new PaperBook(
                "ISBN-002",
                "Lo Hobbit",
                "Bompiani",
                "Tolkien"
        );

        PaperJournal journal1 = new PaperJournal(
                "ISSN-001",
                "Scientific Journal",
                "Science Editore",
                "Rossi"
        );

        PaperJournal journal2 = new PaperJournal(
                "ISSN-002",
                "Computer Science Journal",
                "Tech Editore",
                "Bianchi"
        );

        MovieRecord movie1 = new MovieRecord(
                "ISAN-001",
                "Inception",
                "Warner Bros",
                "Christopher Nolan"
        );

        MovieRecord movie2 = new MovieRecord(
                "ISAN-002",
                "Interstellar",
                "Warner Bros",
                "Christopher Nolan"
        );

        // ==========================================
        // INSERIMENTO NELLA LIBRARY
        // ==========================================

        library.add(book1);
        library.add(book2);

        library.add(journal1);
        library.add(journal2);

        library.add(movie1);
        library.add(movie2);

        // ==========================================
        // CREAZIONE UTENTI
        // ==========================================

        Utente u1 = new Utente(
                "Mario Rossi",
                "mario@email.it",
                "RSSMRA01A01H501A"
        );

        Utente u2 = new Utente(
                "Luca Bianchi",
                "luca@email.it",
                "BNCLCU02B02H501B"
        );

        Utente u3 = new Utente(
                "Anna Verdi",
                "anna@email.it",
                "VRDNNA03C03H501C"
        );

        // ==========================================
        // CONSULTAZIONE DI PRODOTTI
        // ==========================================

        // PaperBook è Readable
        library.consulta(book1, u1);

        // PaperJournal è Readable
        library.consulta(journal1, u2);

        // MovieRecord NON è Readable:
        // non può essere consultato.
        library.consulta(movie1, u3);

        // ==========================================
        // PRESTITO DI PRODOTTI
        // ==========================================

        // PaperBook è Loanable
        library.presta(book2, u1);

        // MovieRecord è Loanable
        library.presta(movie1, u3);

        // PaperJournal NON è Loanable:
        // non può essere prestato.
        library.presta(journal2, u2);

        // ==========================================
        // STAMPA DI TUTTA LA LIBRARY
        // ==========================================

        System.out.println("\n===== CONTENUTO LIBRARY =====");
        library.stampa();

        // ==========================================
        // RICERCA PER CHIAVE
        // ==========================================

        System.out.println("\n===== RICERCA PER CHIAVE =====");

        Product trovato = library.cercaPerChiave("ISBN-001");

        if (trovato != null) {
            System.out.println("Prodotto trovato:");
            System.out.println(trovato);
        } else {
            System.out.println("Prodotto non trovato.");
        }

        // ==========================================
        // RICERCA PER AUTORE
        // ==========================================

        System.out.println("\n===== RICERCA PER AUTORE =====");

        ArrayList<Product> libriTolkien =
                library.cercaPerAutore("Tolkien");

        for (Product p : libriTolkien) {
            System.out.println(p);
        }

        // ==========================================
        // PRODOTTI ATTUALMENTE IN PRESTITO
        // ==========================================

        System.out.println("\n===== PRODOTTI IN PRESTITO =====");

        ArrayList<Product> inPrestito =
                library.getProdottiInPrestito();

        for (Product p : inPrestito) {
            System.out.println(p);
        }

        // ==========================================
        // RESTITUZIONE DEI PRODOTTI CONSULTATI
        // ==========================================

        System.out.println("\n===== FINE GIORNATA =====");

        library.restituisciTuttiConsultati();

        // ==========================================
        // SOLLECITI
        // ==========================================

        System.out.println("\n===== SOLLECITI =====");

        library.inviaSolleciti(inPrestito);
    }
}
