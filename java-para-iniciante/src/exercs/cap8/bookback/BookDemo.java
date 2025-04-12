package exercs.cap8.bookback;

import java.awt.print.Book;

public class BookDemo {
    public static void main(String[] args) {
        // Criação de um objeto Book
        Book books = new Book[5];

        books[0] = new Book("Java: Como Programar", "Deitel", 2000);
        books[1] = new Book("Java Para Iniciantes", "Schild", 2014);
        books[2] = new Book("Java: A Linguagem", "Gosling", 2015);
        books[3] = new Book("Desbravando Java e Orientacao a Objetos", "Guilherme Silveira", 2016);
        books[4] = new Book( "Java Efetivo", "Bloch", 2018);

        // Exibição dos detalhes do livro
        for (int i = 0; i < books.length; i++) {
            books[i].show();
            /*System.out.println("Título: " + books[i].getTitle());
            System.out.println("Autor: " + books[i].getAuthor());
            System.out.println("Ano: " + books[i].getYear());
            System.out.println();
            books[i].show();*/
        }
    }
}
