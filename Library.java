import java.time.LocalDate;
import java.util.ArrayList;

public class Library {

    private ArrayList<Product> prodotti;
    private int counterID;

    public Library() {

        prodotti = new ArrayList<>();

        // Il primo ID deve essere maggiore di zero
        counterID = 1;
    }

    // ==================================================
    // AGGIUNTA
    // ==================================================

    /*
     * Traccia:
     * "aggiunta (add) di un nuovo prodotto"
     *
     * e:
     * "Library lo assegnerà ... usando counterID++"
     */
    public void add(Product prodotto) {

        // 1. assegno l'ID
        prodotto.setId(counterID++);

        // 2. inserisco il prodotto nell'ArrayList
        prodotti.add(prodotto);
    }

    // ==================================================
    // RIMOZIONE
    // ==================================================

    /*
     * Traccia:
     * "rimozione (remove) di un prodotto"
     */
    public boolean remove(Product prodotto) {

        return prodotti.remove(prodotto);
    }

    // ==================================================
    // STAMPA DI TUTTA LA LIBRARY
    // ==================================================

    /*
     * Traccia:
     * "stampa di tutto il contenuto"
     */
    public void stampa() {

        for (Product p : prodotti) {
            System.out.println(p);
        }
    }

    // ==================================================
    // RICERCA PER CHIAVE
    // ==================================================

    /*
     * Traccia:
     * "cercare un prodotto per chiave di categoria"
     *
     * Ogni prodotto restituisce la propria chiave:
     * PaperBook    -> ISBN
     * PaperJournal -> ISSN
     * MovieRecord  -> ISAN
     */
    public Product cercaPerChiave(String chiave) {

        for (Product p : prodotti) {

            if (p.getChiaveCategoria().equals(chiave)) {
                return p;
            }
        }

        // Nessun prodotto trovato
        return null;
    }

    // ==================================================
    // RICERCA PER AUTORE
    // ==================================================

    /*
     * Traccia:
     * "ottenere la lista dei prodotti fornendo come input un autore"
     */
    public ArrayList<Product> cercaPerAutore(String autore) {

        ArrayList<Product> risultati = new ArrayList<>();

        for (Product p : prodotti) {

            if (p.getAutore().equals(autore)) {
                risultati.add(p);
            }
        }

        return risultati;
    }

    // ==================================================
    // CONSULTAZIONE
    // ==================================================

    /*
     * La traccia dice che la biblioteca può far consultare
     * un prodotto in base alle sue caratteristiche.
     *
     * Qui controlliamo se il prodotto è Readable.
     */
    public void consulta(Product prodotto, Utente utente) {

        if (prodotto instanceof Readable) {

            Readable r = (Readable) prodotto;

            r.consulta(utente);

            System.out.println(
                "Consultazione iniziata: " + prodotto.getTitle()
            );
        }
    }

    // ==================================================
    // PRESTITO
    // ==================================================

    /*
     * Stesso ragionamento:
     * se il prodotto è Loanable possiamo prestarlo.
     */
    public void presta(Product prodotto, Utente utente) {

        if (prodotto instanceof Loanable) {

            Loanable l = (Loanable) prodotto;

            l.presta(utente);

            System.out.println(
                "Prestito effettuato: " + prodotto.getTitle()
            );
        }
    }

    // ==================================================
    // RESTITUZIONE DEI PRODOTTI CONSULTATI
    // ==================================================

    /*
     * Traccia:
     *
     * "deve poter chiedere la restituzione di tutti i prodotti
     * attualmente consultati"
     *
     * "deve avere un metodo per verificare se ci sono dei
     * prodotti attualmente consultati"
     *
     * "se ci sono deve richiedere l'immediata restituzione
     * resettando l'attributo Utente"
     */
    public void restituisciTuttiConsultati() {

        boolean trovati = false;

        for (Product p : prodotti) {

            // Controllo se il prodotto è consultabile
            if (p instanceof Readable) {

                Readable r = (Readable) p;

                // Se c'è un utente, qualcuno lo sta consultando
                if (r.getUtenteConsultazione() != null) {

                    trovati = true;

                    // Richiesta di restituzione
                    System.out.println(
                        "Richiesta restituzione: " + p
                    );

                    // Resettiamo l'utente
                    r.restituisciConsultazione();
                }
            }
        }

        if (!trovati) {
            System.out.println(
                "Non ci sono prodotti attualmente consultati."
            );
        }
    }

    // ==================================================
    // PRODOTTI ATTUALMENTE IN PRESTITO
    // ==================================================

    /*
     * Traccia:
     * "ottenere la lista dei prodotti attualmente in prestito"
     */
    public ArrayList<Product> getProdottiInPrestito() {

        ArrayList<Product> risultati = new ArrayList<>();

        for (Product p : prodotti) {

            if (p instanceof Loanable) {

                Loanable l = (Loanable) p;

                // Prestito diverso da null = prodotto in prestito
                if (l.getPrestito() != null) {
                    risultati.add(p);
                }
            }
        }

        return risultati;
    }

    // ==================================================
    // INVIO EMAIL
    // ==================================================

    /*
     * Traccia:
     *
     * "dato la lista di prodotti in prestito mandi un'email
     * a ogni utente che trattiene un prodotto da più di un mese"
     *
     * Per email si intende:
     * "la stampa a video con 'Invio email' più
     * le caratteristiche dell'utente"
     */
    public void inviaSolleciti(ArrayList<Product> prodottiInPrestito) {

        LocalDate oggi = LocalDate.now();

        for (Product p : prodottiInPrestito) {

            if (p instanceof Loanable) {

                Loanable l = (Loanable) p;

                Prestito prestito = l.getPrestito();

                if (prestito != null) {

                    LocalDate scadenzaUnMese =
                            prestito.getDataInizio().plusMonths(1);

                    /*
                     * "da più di un mese"
                     *
                     * Se la data limite è prima di oggi,
                     * è passato più di un mese.
                     */
                    if (scadenzaUnMese.isBefore(oggi)) {

                        System.out.println("Invio email");
                        System.out.println(
                            prestito.getUtente()
                        );
                    }
                }
            }
        }
    }
}
