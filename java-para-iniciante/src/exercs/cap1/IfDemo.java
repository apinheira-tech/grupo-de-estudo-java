package exercs.cap1;

/*
@Description: Demostração de uso do IF
Atividades do capítulo 1 - Estruturas de Controle com If
Livro: Java para Iniciantes - Herbert Schildt
@Author: Simone
    - Grupo de Estudos sobre Java
 */
public class IfDemo {
    public static void main(String[] args) {
        int a, b, c;
        a = 2;
        b = 3;

        if (a < b) {
            System.out.println("A é menor que B");
        }

        if (a == b) {
            System.out.println("A é igual a B");
        } else {
            System.out.println("A é diferente de B");
        }
        System.out.println();
        c = a - b; // C contem -1

        System.out.println("C contem - 1");
        if (c >= 0) {
            System.out.println("C é positivo");
        } else { // if(c < 0)
            System.out.println("C é negativo");
        }
        System.out.println();
        c = b - a; // agora C contem 1

        System.out.println("C contem 1");
        if (c >= 0) {
            System.out.println("C é positivo");
        } else { // if(c < 0)
            System.out.println("C é negativo");
        }
    }
}
