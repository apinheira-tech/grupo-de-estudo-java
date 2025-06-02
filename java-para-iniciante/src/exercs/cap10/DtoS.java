package exercs.cap10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since: 18/05/2025 (Dt de quando implementei essa classe no GE)
@Artefato: DtoS.java
Atividades do capítulo 10 - Usando I/O
Livro: Java para Iniciantes - Herbert Schildt
@description: Exemplificando o conceito de I/O (Entrada/Saída) em Java.
                Esta é a classe DtoS, que lê um arquivo de texto e exibe seu conteúdo no console.
                Métodos: Não possui métodos próprios, mas utiliza BufferedReader para ler o arquivo.
                Atributos: Não possui atributos próprios, mas usa uma variável String para armazenar cada linha lida do arquivo.
                Exceções: Trata IOException para lidar com erros de entrada/saída.
*/
public class DtoS {
    public static void main(String[] args) {

        String s;

        try(BufferedReader br = new BufferedReader(new FileReader("Test.txt"))){
            while ((s = br.readLine()) != null){
                System.out.println(s);
            }

        }catch (IOException e){
            System.out.println("I/O Exception");
        }
    }
}