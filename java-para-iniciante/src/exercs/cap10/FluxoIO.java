package exercs.cap10;

import java.io.InputStream;
import java.io.OutputStream;
/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since: 18/05/2025 (Dt de quando implementei essa classe no GE)
@Artefato: FluxoIO.java
Atividades do capítulo 10 - Usando I/O
Livro: Java para Iniciantes - Herbert Schildt
@description: Exemplificando o conceito de I/O (Entrada/Saída) em Java.
                  Esta é a classe FluxoIO, que demonstra o uso de fluxo de entrada e saída padrão em Java.
                  Métodos: Não possui métodos próprios, mas pode ser usada para ler dados do teclado e escrever na tela.
                  Atributos: Não possui atributos próprios, mas utiliza InputStream e OutputStream para manipular entrada e saída.
                    Exceções: Não trata exceções diretamente, mas pode ser estendida para incluir tratamento de erros de I/O.
*/
public class FluxoIO {
    public static void main(String[] args) {
        // Fluxo de entrada padrão (Teclado / Input / Read / Console)
        InputStream entrada = System.in;
        System.out.println("Digite seu nome: ");

        System.out.println("Olá, " + entrada + "! Seja bem-vindo!");

        // Fluxo de saída padrão (Tela / Output / Print)
        OutputStream saida = System.out;


    }
}
