package exercs.cap5;
/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since:
@Artefato: MatBidimensional.java
Atividades do capítulo 5 - Tipos de Dados e Operadores
Livro: Java para Iniciantes - Herbert Schildt
@description:
    Exemplo de matriz bidimensional.
    Demonstra o uso de matrizes bidimensionais.
    Mostra como preencher a matriz com números aleatórios.
*/
// Explicação de uma matriz Bidimensiona
public class MatBidimensional {
    public static void main(String[] args) {
        int linha, coluna;
        int tabela[][] = new int[3][4]; // 3 linhas e 4 colunas

        // Preenchendo a matriz
        for (linha = 0; linha < 3; linha++) {
            for (coluna = 0; coluna < 4; coluna++) {
                // tabela[linha][coluna] = linha + coluna;
                //tabela[linha][coluna] = (int) (Math.random() * 100); // Preenchendo com números aleatórios
                tabela[linha][coluna] = (linha * 4) + coluna + 1;
            }
        }

        // Exibindo a matriz
        System.out.println("Matriz Bidimensional - Tabela: ");
        for (linha = 0; linha < 3; linha++) {
            for (coluna = 0; coluna < 4; coluna++) {
                System.out.print(tabela[linha][coluna] + "\t");
            }
            System.out.println(); // Pular linha - Quebra de linha após cada linha da matriz
        }
        System.out.println("Fim da matriz");

    }
}
