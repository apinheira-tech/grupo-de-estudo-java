package exercs.cap8.bookback;

/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since: 12/04/2025 (Dt de quando implementei essa classe no GE)
@Artefato: Book.java
Atividades do capítulo 8 - Packages e Interfaces
Livro: Java para Iniciantes - Herbert Schildt
@description: Exemplificando o conceito de Packages e Interfaces.
                Esta eh a classe Book, que representa um livro.
                Possui atributos como título, autor e data de lançamento.
                Métodos: Tem métodos getters e setters para acessar e modificar os atributos.
                Atributos: tem os atributos title, author e sices (data de lançamento).
*/
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