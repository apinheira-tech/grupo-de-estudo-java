package exercs.cap4;

/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since: 2023-10-01
@Artefato: Pessoa.java
Atividades do capítulo 4 - Introdução a classes, objetos e métodos
Livro: Java para Iniciantes - Herbert Schildt
@description: Esta classe representa uma pessoa com atributos (variáveis) e métodos (comportamento e características).
E que demonstra os conceitos de encapsulamento, herança, polimorfismo e abstração.
*/
// ABSTRAÇÃO: Representa uma pessoa com atributos (variáveis) e métodos (comportamento e características).
public class Pessoa {
    // ENCAPSULAMENTO: Atributos privados para proteger os dados.
    // Atributos(Variáveis de instância/propriedades/Dados Privados, acesso controlado) =>
    // ex.: get.nome ou get.metodo(s)

    private String nome;
    private int idade;
    private String cpf;

    // CONSTRUTOR: Método construtor para inicializar os atributos da classe.
    public Pessoa(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    // ENCAPSULAMENTO: Métodos públicos (getters e setters) para acessar e modificar os atributos.
    // Getter para o atributo nome - Interfaces Controladas
    public String getNome() { return nome;     }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade;     }

    public void setIdade(int idade) {   this.idade = idade;     }

    public String getCpf() { return cpf;     }

    public void setCpf(String cpf) { this.cpf = cpf;     }

    // MÉTODOS: Métodos públicos para acessar e modificar os atributos da classe.
    public void imprimirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
    }

    // DESTRUTOR: Método destrutor para liberar recursos, se
    //  necessário. (Não é comum em Java, mas pode ser implementado com finalize())
    public void fechado() {
        // Código para liberar recursos, se necessário
        System.out.println("Limpando recurso de memória no GC - Objeto Pessoa sendo removido da memória  " + nome);
        // cleanable.clean();
        // super.clone();
    }

    // HERANÇA: Classe Pessoa pode ser estendida por outras classes. Exemplo do
    // que herda da superClasse, dependendo da literatura também conhecido como Classe: Mãe/Pai.

    public static class Estudante extends Pessoa {
        private String curso;

        public Estudante(String nome, int idade, String cpf, String curso) {
            super(nome, idade, cpf);
            this.curso = curso;
        }

        public String getCurso() { return curso; }
        // public void setCurso(String curso) { this.curso = curso; }

        // POLIMORFISMO: Sobrescrita de método para fornecer uma implementação específica para a classe Estudante.
        // Subrescrita de método com o uso de Override, para indicar que o método em uma subclasse está
        //  sobrescrevendo um método de uma superclasse.
        @Override
        public void imprimirInfo() {
            super.imprimirInfo();
            System.out.println("O nome do curso eh Matrícula: " + curso);
        }
    }
    // Exemplo de uso da classe Pessoa e Estudante na classe principal (main).
    public static void main(String[] args) {
        // Criando um objeto da classe Pessoa
        Pessoa pessoa = new Pessoa("João", 30, "123.456.789-00");
        pessoa.imprimirInfo();

        // POLIMORFISMO
        // Criando um objeto da classe Estudante
        Estudante estudante = new Estudante("Maria", 20, "987.654.321-00", "Engenharia");
        estudante.imprimirInfo(); //chama o método imprimirInfo sobrescrito da classe Estudante

        // Liberando recursos (opcional)
        pessoa.fechado();
        estudante.fechado();

        // ENCAPSULAMENTO: Acessando atributos diretamente (não recomendado)
        // objeto 1 do Tipo Pessoa: Maria
        /*
        pessoa.setNome("Maria");
        pessoa.setIdade(25);
        pessoa.setCpf("987.654.321-00");
        System.out.println("As informacoes da pessoa 1 são " + pessoa.getNome() + getIdade() + getCpf());

        // objeto 2 do Tipo Estudante: João
        estudante.setNome("João");
        estudante.setIdade(30);
        estudante.setCpf("123.456.789-00");
        System.out.println("As informacoes do estudante 2 são " + estudante.getNome() + getIdade() + getCpf());

        // Acessando atributos diretamente (não recomendado)
        // objeto 1 do Tipo Pessoa: Maria
        pessoa.setNome("Ana");
        pessoa.setIdade(35);
        pessoa.setCpf("111.222.333-44");
        pessoa.setCurso("Matemática");
        System.out.println("As informacoes da pessoa 1 são " + pessoa.getNome() + getIdade() + getCpf() + getCurso());





         */
    }

}
