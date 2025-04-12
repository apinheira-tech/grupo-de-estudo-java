package exercs.cap6;

import org.w3c.dom.ls.LSOutput;

/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since:
@Artefato: PessoaAfro.java
Atividades do capítulo 6 - Métodos e Classes
Livro: Java para Iniciantes - Herbert Schildt
@description: Exemplificando o conceito de Herança.
              Classe PessoaAfro que herda da classe Pessoa.
*/
public class PessoaAfro extends Pessoa {
    // atributos especificos
    private String blackPower;
    // instaciar
    Pessoa pa = new PessoaAfro("Simone", 32, "Superior Completo", "Sim");

    // Construtor
    public PessoaAfro(String nome, int idade, String escolaridade, String blackPower) {
        super(nome, idade, escolaridade);
        this.blackPower = blackPower;
        System.out.println("Construtor de PessoaAfro(Superclasse) Chamado.. "
                + pa.getNome() + pa.getIdade() + pa.getEscolaridade());
    }
}