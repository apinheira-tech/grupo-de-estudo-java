package cap7.exercs;

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
