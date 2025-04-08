package cap1.exercs;

/*
@Description: Demostração de uso do for
Atividades do capítulo 1 - Estruturas de Controle com For
Livro: Java para Iniciantes - Herbert Schildt
@Author: Grupo de Estudos sobre Java
 */
public class ForDemo {
    public static void main(String[] args) {
        int count;

        // O loop for é usado para repetir um bloco de código um número específico de vezes.
        for (count = 0; count < 5; count++) {
            System.out.println("Este é um contador: " + count);
        }
        System.out.println("Feito o loop for!");
    }
}
