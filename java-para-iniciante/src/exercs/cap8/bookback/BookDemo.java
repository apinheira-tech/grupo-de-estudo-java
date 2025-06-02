package exercs.cap8.bookback;

/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since: 12/04/2025 (Dt de quando implementei essa classe no GE)
@Artefato: BookDemo.java
Atividades do capítulo 8 - Packages e Interfaces
Livro: Java para Iniciantes - Herbert Schildt
@description: Exemplificando o conceito de Packages e Interfaces.
                Esta eh a classe BookDemo, que demonstra o uso da classe Book.
                Cria um array de objetos Book e exibe os detalhes de cada livro.
                Métodos: Tem o método main que cria e exibe os livros.
                Atributos: Não possui atributos próprios, mas utiliza a classe Book.

*/

public class BookDemo {
    public static void main(String[] args) {
        // Criação de um objeto Book
        Book books[] = new Book[5];

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

            /*problema causado pela importação da biblioteca Book do java
            import java.awt.print.Book;

            na linha 8, faltou a declaração de array em book
            * */
        }
    }
}
