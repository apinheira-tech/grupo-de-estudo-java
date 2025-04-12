package exercs.cap6;
/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since:
@Artefato: Pessoa.java
Atividades do capítulo 6 - Métodos e Classes
Livro: Java para Iniciantes - Herbert Schildt
@description: Exemplo de uma classe simples com atributos privados.
              Exemplificando o conceito de Herança.
*/
public class Pessoa {
    private String nome;
    private int idade;
    private String escolaridade;
    // Métodos getters e setters
    // Construtor
    public Pessoa(String nome, int idade, String escolaridade) {
        this.nome = nome;
        this.idade = idade;
        this.escolaridade = escolaridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }
}
