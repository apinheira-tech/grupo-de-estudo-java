package exercs.cap15;

import exercs.cap15.swing.AnimalGeneric;

/*
    * Exemplo de uso do operador instanceof para verificar o tipo de um
    * objeto
 */
class AnimalN {
    private final String name;

    public AnimalN(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Dog extends AnimalGeneric {
    public Dog(String name) {
        super(name);
    }

    public void bark() {
        System.out.println("Au au!");
    }
}

public class AnimalTest {
    public static void main(String[] args) {
        AnimalGeneric animalGeneric = new exercs.cap15.swing.DogN("Rex");

        // Verifica se é instância de Animal
        System.out.println(animalGeneric instanceof AnimalGeneric); // true

        // Verifica se é instância de Dog
        System.out.println(animalGeneric instanceof exercs.cap15.swing.DogN);    // true

        // Se for um Dog, podemos fazer o casting e chamar métodos específicos
        if (animalGeneric instanceof exercs.cap15.swing.DogN) {
            exercs.cap15.swing.DogN dog = (exercs.cap15.swing.DogN) animalGeneric;
            dog.bark();
        }
    }
}