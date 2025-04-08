package cap7.exercs;

/*
@author: Simone
@Code: esta eh a superclasse
Este método abstract
 */

public abstract class Pessoa {
    // Atributo da superclasses
    protected String nome;

    // Construtor da superclasse
    public Pessoa (String nome) {
        this.nome = nome;
        System.out.println(" Construtor de Pessoa(Superclasse) Chamado.. ");
    }
    // Método da Superclasse
    public void comer() {
        System.out.println(nome + " esta comendo.. ");
    }
    // Método da Superclasse
    public void informacoes () {
        System.out.println(" Informações blbla ... ");
    }

    // Metodo específico da subclasses, que eh referente as caracteerísticas que
    // sou esta pessoa possui
    public abstract void cantar();

    public void falar (){
        System.out.println(" Pessoa fala Tupi, Portugues e Japones ... ");
    }
}

