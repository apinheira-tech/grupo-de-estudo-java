package exercs.cap2;

/*
@Description: Exercicio que calcula a distancia em pés e metros
Atividades do capítulo 2 - Introdução a tipos de dados e Operadores
Livro: Java para Iniciantes - Herbert Schildt
@Author: Grupo de Estudos sobre Java
*/
public class Sound {
    public Sound() {
    }

    public static void main(String[] args) {
        double distP = 7920.0;
        double distM = distP / 3.281;
        System.out.println("Distancia por pés: " + distP + " Testo qualquer");
        System.out.printf("\nDistancia por pés: %.3f", distP);
        System.out.printf("\nDistancia por metro: %.2f", distM);
    }
}
