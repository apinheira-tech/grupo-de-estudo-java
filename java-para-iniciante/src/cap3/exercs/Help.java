package cap3.exercs;

import java.io.IOException;
import java.util.Scanner;

public class Help {
    public Help() {
    }

    public static void main(String[] args) {
        new Scanner(System.in);
        System.out.println("Escolha uma opção de HelpOn\n1. IF\n2. Switch\nX. Saída\nDigite sua escolha:\n");

        try {
            char opt = (char)System.in.read();
            switch (opt) {
                case '\u0001':
                    System.out.println("A sua opção de HelpOn é:\n1. IF\n");
                    break;
                case '\u0002':
                    System.out.println("A sua opção de HelpOn é:\n2. Switch\n");
                    break;
                case 'X':
                    System.out.println("Digite sua opção de saída do HelpOn\nX. Saída\n");
                default:
                    System.out.println("Opção invalida");
            }
        } catch (IOException var3) {
            IOException e = var3;
            e.printStackTrace();
        }

    }
}
