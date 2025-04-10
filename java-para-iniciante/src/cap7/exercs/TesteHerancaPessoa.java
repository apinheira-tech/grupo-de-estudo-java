package cap7.exercs;

/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since:
@Artefato: TesteHerancaPessoa.java
Atividades do capítulo 7 - Herança
Livro: Java para Iniciantes - Herbert Schildt
@description: Exemplificando o conceito de Herança. Esta eh a subclasse,
               que herda os métodos e atributos da superclasse Pessoa
               E implementa o método abstrato cantar da superclasse
            Métodos: Não possui método, porém pode herdar métodos da superclasse
            Atributos: não possui atributos, porém pode herdar atributos da superclasse
            Contudo tem instancias de objetos da subclasse e da superclasse
*/
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
