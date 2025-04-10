package cap7.exercs;
/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since:
@Artefato: PessoaN.java
Atividades do capítulo 7 - Herança
Livro: Java para Iniciantes - Herbert Schildt
@description: Exemplificando o conceito de Herança. Esta eh a subclasse
               Esta classe herda os métodos e atributos da superclasse Pessoa
               Implementa o método abstrato cantar da superclasse
               Métodos: Tem métodos específicos, como : falar, informacoes e comer, que não são
               da superclasse.
               Atributos: tem o atributo etnia, que não é da superclasse
*/

// Classe filha (ou subclasse): PessoaN
public class PessoaN extends Pessoa{

    private String etnia;

    // Construtor da SubClasse que chama o construtor da Superclasse
    public PessoaN (String nome, String etnia){
        super(nome);
        this.etnia = etnia;
        System.out.println(" Construtor da subclasse (PessoaN) chamado.. ");
    }
    // Metodo específico da subclasses, que eh referente as caracteerísticas que
    // sou esta pessoa possui
    // Implmentação do método abstrato cantar da superclasse
    @Override
    public void cantar () {
        System.out.println(nome + " estah catando..");
        // usar o super() para acessar o Método Comer da superclasse, que agora é abstrata
        // chamada de metodo sobreposto, Precisa ser o mesmo método, neste caso teria que ter o
        // método informções na superclasse e na subclasse
        super.informacoes();
        System.out.println(" Construtor usando o super para o metodo da super classe, chamado.. ");
    }
    // esta anotation indica explicidademente a sobreposição
    @Override
    public void falar (){
        System.out.println(" Pessoas Portugues e canta ... ");
    }


}
