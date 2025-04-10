package cap5.exercs;

/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since:
@Artefato: ArrayDeString.java
Atividades do capítulo 5 - Tipos de Dados e Operadores
Livro: Java para Iniciantes - Herbert Schildt
@description:
    Exemplo de array de String.
    Demonstra o uso de arrays de String.
    Mostra como alterar o valor de um elemento do array.
    Mostra como imprimir os elementos do array.
    Mostra como criar um array de String com inicialização direta.
    Mostra como criar um array de String com inicialização indireta.
    Mostra como acessar os elementos do array de String.
    Mostra como modificar os elementos do array de String.
*/
public class ArrayDeString {
    // Demostracao de um array de String
    public static void main(String[] args) {
        //String strs[] = new String[5];
        String strs[] = {"This", "is", "a", "test.", "ok"};
        System.out.println("Original array:");
        for (String s : strs)
            System.out.print(s + " " + "\n");
        // Change a String
        strs[1] = "was";
        strs[3] = "test, too! ";
        System.out.println("Modified array:");
        for (String s : strs)
            System.out.print(s + " ");
    }
}
