package exercs.cap5;
/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since:
@Artefato: ShowBitsDemos.java
Atividades do capítulo 5 - Tipos de Dados e Operadores
Livro: Java para Iniciantes - Herbert Schildt
@description:
    Mostra como:
     - criar um objeto ShowBits.
     - usar o método show() para exibir o valor em binário.
     - usar o operador & para exibir o valor em binário.
     - usar o operador >>> para exibir o valor em binário.
     - usar o operador << para exibir o valor em binário.
     - usar o operador | para exibir o valor em binário.
     - usar o operador ^ para exibir o valor em binário.
*/
public class ShowBitsDemos {
    public static void main(String[] args) {
        ShowBits b = new ShowBits(8);
        ShowBits i = new ShowBits(32);
        ShowBits l = new ShowBits(64);

        System.out.println("123 em binário com 8 bits: ");
        b.show(123);

        System.out.println("\n87987 em binário com 32 bits: ");
        i.show(87987);

        System.out.println("\n237658768 em binário com 64 bits: ");
        l.show(237658768);

        System.out.println("\nBaixo byte de 87987 em binário em 8 bits: ");
        b.show(87987);
    }
}

class ShowBits {
    private int numBits;

    public ShowBits(int numBits) {
        this.numBits = numBits;
    }
    public void show(long val) {
        long mask = 1L << (numBits - 1);
        int spacer = 0;

        for (int i = 1; i <= numBits; i++) {
            if ((val & mask) != 0) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
            mask >>>= 1;

            if (++spacer == 8) {
                System.out.print(" ");
                spacer = 0;
            }
        }
        System.out.println();
    }
}

/*
class ShowBits {
    private int numBits;
    private int val;

    public ShowBits(int numBits) {
        this.numBits = numBits;
        val = 0;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void show() {
        for (int i = numBits - 1; i >= 0; i--) {
            System.out.print(((val >> i) & 1) == 1 ? "1" : "0");
        }
        System.out.println();
    }
}
 */
