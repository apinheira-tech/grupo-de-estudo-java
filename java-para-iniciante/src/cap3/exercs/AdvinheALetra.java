package cap3.exercs;

import java.io.IOException;

public class AdvinheALetra {
    public AdvinheALetra() {
    }

    public static void main(String[] args) throws IOException {
        char letraCorreta = 107;
        boolean acertou = false;
        System.out.println("Bem-vindo ao jogo Adivinhe a Letra !\nEu estou pensando em uma letra entre A e Z.\nSystem.out.println(\"Tente adivinhar qual é!\n");

        while(true) {
            while(!acertou) {
                System.out.print("Digite seu palpite: ");
                char palpite = (char)System.in.read();
                System.in.read();
                System.in.read();
                palpite = Character.toLowerCase(palpite);
                if (palpite == letraCorreta) {
                    acertou = true;
                    System.out.println("Parabéns! Você acertou!");
                } else if (palpite >= 'a' && palpite <= 'z') {
                    if (palpite < letraCorreta) {
                        System.out.println("A letra correta está depois do seu palpite no alfabeto.");
                    } else {
                        System.out.println("A letra correta está antes do seu palpite no alfabeto.");
                    }
                } else {
                    System.out.println("Por favor, digite uma letra válida entre A e Z.");
                }
            }

            return;
        }
    }
}
