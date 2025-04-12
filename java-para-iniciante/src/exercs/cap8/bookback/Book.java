package exercs.cap8.bookback;

class Book {
    private String title;
    private String author;
    private int sices;

    // Métodos getters e setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSices() {
        return sices;
    }

    public void setSices(int sices) {
        this.sices = sices;
    }
    // Construtor
    Book(String t, String a, int d) {
        title =t;
        author =a;
        sices =d;
    }

    void show() {
        System.out.println("Título: " + title);
        System.out.println("Autor: " + author);
        System.out.println("Data lancamento: " + sices);
    }
}