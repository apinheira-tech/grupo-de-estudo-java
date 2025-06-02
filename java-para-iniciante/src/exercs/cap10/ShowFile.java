package exercs.cap10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since: 18/05/2025 (Dt de quando implementei essa classe no GE)
@Artefato: ShowFile.java
Atividades do capítulo 10 - Usando I/O
Livro: Java para Iniciantes - Herbert Schildt
@description: Exemplificando o conceito de I/O (Entrada/Saída) em Java.
                    Esta é a classe ShowFile, que lê um arquivo de texto byte a byte e exibe seu conteúdo no console.
                    Métodos: Não possui métodos próprios, mas utiliza FileInputStream para ler o arquivo.
                    Atributos: Não possui atributos próprios, mas usa uma variável int para armazenar cada byte lido do arquivo.
                    Exceções: Trata FileNotFoundException e IOException para lidar com erros de entrada/saída.
    */
public class ShowFile {

        public static void main(String[] args) {

            int i;
            FileInputStream fin;

            if (args.length != 1) {
                System.out.println("Usage:ShowFile");
                return;
            }
            Path path = Paths.get(args[0]);
            if (!Files.exists(path)) {
                // sendo o o toAbsolutePath() um método da classe Path que retorna o caminho absoluto do arquivo
                // caso o arquivo não exista, o método toAbsolutePath() retorna o caminho absoluto do arquivo
                // que não existe
                // e esta disponível apartir do java 7
                System.out.println("File not found: " + path.toAbsolutePath());
                return;
            }

            try {
                fin = new FileInputStream(args[0]);
            } catch (FileNotFoundException e) {
                System.out.println("file not found");
                return;
            }
            //Opção sem Finally
            try {
                do {
                    // o método read() lê o arquivo byte a byte
                    // e retorna o valor lido
                    // porém nao armazena o valor lido na variável i, pois i é o contato e fin é o arquivo em si
                    // leitura por byte usa ASCII e não armazena o valor lido
                    // podemos fazer um exericicio de conversão de byte para char
                    // e para armazenar o valor lido/contido no arquivo em uma variável
                    i = fin.read();
                    if (i != -1) {
                        System.out.print((char) i);
                    }
                } while (i != -1);

            } catch (IOException e) {
                System.out.println("Error Reading File");
            }
            try {
                fin.close();

            } catch (IOException e) {
                System.out.println("Error closing File");
            }
        }
}
