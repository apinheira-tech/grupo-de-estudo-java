package exercs.cap9;
/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since: 03/05/2025 (Dt de quando implementei essa classe no GE)
@Artefato: ExDemo.java
Atividades do capítulo 9 - Tratamento de Exceções
Livro: Java para Iniciantes - Herbert Schildt
@description:  Exemplificando o conceito de Tratamento de Exceções.
                Esta é a classe ExDemo, que demonstra o uso de tratamento de exceções em Java.
                Métodos: Não possui métodos próprios, mas pode conter métodos para demonstrar o tratamento de exceções.
                Atributos: Não possui atributos próprios, mas pode ser usada para encapsular lógica de tratamento de exceções.
                DEMONSTRA O TRATAMENTO DE EXCEÇÕES
                Exemplo de execeção simples
*/
public class ExDemo {
    public static void main(String[] args) {
        // int[] numbers = {1, 2, 3, 4, 5};
        int nums[] = new int [4];
        // Exemplo de tratamento de exceção com array

        try {
            System.out.println("Before exception is generated. ");
            nums[7] = 10;
            // Tentando acessar um índice fora dos limites do array
            System.out.println(nums[10]);
            System.out.println("This won't be displayed. ");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Tratamento da exceção
            System.out.println("Erro: Índice fora dos limites do array. | Index out-of-bounds. ");
        }
        System.out.println("Programa continua após o tratamento da exceção. | After catch statement. ");
    }
}
