public abstract class Product {

    private int id;
    private String title;
    private String editor;
    private String autore;

    public Product(String title, String editor, String autore) {

        // La traccia dice che il titolo non può essere vuoto
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Il titolo non può essere vuoto");
        }

        this.title = title;
        this.editor = editor;
        this.autore = autore;

        // All'inizio l'ID vale 0.
        // Sarà Library ad assegnarlo.
        this.id = 0;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getEditor() {
        return editor;
    }

    public String getAutore() {
        return autore;
    }

    // Non serve che sia pubblico:
    // viene usato da Library quando inserisce il prodotto.
    void setId(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("L'ID deve essere maggiore di zero");
        }

        this.id = id;
    }

    /*
     * Ogni sottoclasse deve fornire la propria chiave:
     * PaperBook -> ISBN
     * PaperJournal -> ISSN
     * MovieRecord -> ISAN
     */
    public abstract String getChiaveCategoria();

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", editor='" + editor + '\'' +
                ", autore='" + autore + '\'' +
                ", chiave='" + getChiaveCategoria() + '\'' +
                '}';
    }
}
