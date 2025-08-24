package exercs.cap15.swing;

/*  Classe base Animal.
    Possui um atributo name e um método getName().
    Classe Dog e Cat estendem Animal e possuem métodos específicos (bark e meow).
 */

import exercs.cap15.swing.AnimalGeneric;

public class AnimalTeste {
    /*
        Método que verifica o tipo do animal e executa ações específicas.
     */
     public static String verificaTipoAnimal(AnimalGeneric animal) {

        if (animal == null) {
            return "Animal inválido";
        }
        StringBuilder resultado = new StringBuilder();
        resultado.append("Nome: ").append(animal.getName()).append("\n");

        if (animal instanceof DogN) {
            DogN dog = (DogN) animal;
            dog.bark();
            resultado.append("É um cachorro");
        } else if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.meow();
            resultado.append("É um gato");
        } else {
            resultado.append("É um animal não específico");
        }

        return resultado.toString();
    }

    public static void main(String[] args) {
        // Cenário positivo - Dog
        System.out.println("=== Teste com Dog ===");
        System.out.println(verificaTipoAnimal(new DogN("Rex")));

        // Cenário positivo - Cat
        System.out.println("\n=== Teste com Cat ===");
        System.out.println(verificaTipoAnimal(new Cat("Felix")));

        // Cenário com animal genérico
        System.out.println("\n=== Teste com Animal genérico ===");
        System.out.println(verificaTipoAnimal(new AnimalGeneric("Genérico")));

        // Cenário negativo - null
        System.out.println("\n=== Teste com null ===");
        System.out.println(verificaTipoAnimal(null));
    }
}

