package exercs.cap14;

public class NumericFunc {
    public static void main(String[] args) {
        // Exemplo de uso da função isEven
        System.out.println("Is 4 even? " + isEven(4)); // true
        System.out.println("Is 5 even? " + isEven(5)); // false

        // Exemplo de uso da função isOdd
        System.out.println("Is 3 odd? " + isOdd(3)); // true
        System.out.println("Is 6 odd? " + isOdd(6)); // false
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
