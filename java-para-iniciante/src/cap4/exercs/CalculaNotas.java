package cap4.exercs;

/*
@author: Simone
@version: 1.0
@since: 2023-10-01
@description: Esta classe contém um método que calcula a média de notas de um aluno.
Classe que demonstra uma função com Retorno (Return) para calcular a média de notas.
 */
public class CalculaNotas {
    // Método para calcular a média entre 3 notas
    /*
    public double mediaAluno(double nota1, double nota2, double nota3) {
        // Calcula a média
        double media = (nota1 + nota2 + nota3) / 3;
        // Retorna a média
        return media;
    } */
    public String mediaAluno(double nota1, double nota2, double nota3) {
        // Calcula a média
        double media = (nota1 + nota2 + nota3) / 3.0;
        // Retorna a média
        // return String.format("A média é: %.2f", media);
        if (media >= 7.0) {
            // Forma moderna com java 21
            // return String.format("A média é: %.2f - Aprovado", media);
            // } else if (media >= 5) {
            // return String.format("A média é: %.2f - Recuperação", media);
            // } else {
            // return String.format("A média é: %.2f - Reprovado", media); }
            // Forma antiga
        return "\n APROVADO(A) " + String.format("%.1f", media);
        } else {
            return "\n REPROVADO(A) " + String.format("%.2f", media);
        }
    }
    // Método principal para testar a classe
    public static void main(String[] args) {
        // Cria uma instância ( NEW )  da classe CalculaNotas
        CalculaNotas resultado = new CalculaNotas();
        // Chama o método mediaAluno com notas de exemplo
        // atribui a var: restFinal, do objeto chamado: resultado e passamos como atributos os valores das notas
        String restFinal = resultado.mediaAluno(4.5, 7.5, 9.5);
        // Exibe o resultado
        System.out.println(restFinal);
    }
}
