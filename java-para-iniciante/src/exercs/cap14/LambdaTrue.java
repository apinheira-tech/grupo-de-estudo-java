package exercs.cap14;


//import java.util.function.Predicate;

import java.util.function.Predicate;

public class LambdaTrue {

    public static void main(String[] args) {
        /*
        Com IF
        */
        Predicate<Integer> TrueLambda = n -> {
            if (n >= 10 && n <= 20) {
                System.out.println("O Retorno é true: n é maior ou igual a 10 e menor ou igual a 20");
                return true;

            } else {
                System.out.println("O Retorno é false: n é menor que 10 ou maior que 20");
                return false;

            }
        };
        System.out.println("Testando a lógica com IF " + TrueLambda.test(2));
    }



}