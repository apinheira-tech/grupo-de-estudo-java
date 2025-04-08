package cap7.exercs;

// Classe para testar a herança
public class TesteHerancaPessoa {
    public static void main(String[] args) {
        // Criar objeto da subclasse
        PessoaN filhaUm = new PessoaN("Joana","blabla");
        PessoaN filhoDois = new PessoaN("Josafá", "xpto");
        // Acesso ao atributos herdade da superclasse
        filhaUm.nome = "Maria";
        // Metodo comer superclasse - chamar o metodo herdado
        filhaUm.comer();
        // Metodo cantar na subclasse - chama o metodo
        filhaUm.cantar();

        filhoDois.nome = "João";
        System.out.println(filhoDois.nome);
    }
}
