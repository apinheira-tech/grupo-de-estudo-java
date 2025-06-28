package exercs.cap14;

/*
Expressão Lambda de bloco
Uma lambda de bloco que encontra o menor fator positivo de um valor inteiro.
de um valor inteiro.
 */
public class NumericFunc {
    public static void main(String[] args) {
        // Esta lambda de bloco retorna o menor fator positivo de um valor
        NumericFuncDefault smallestFactor = (n) -> {
            int result = 1;
            // Obtem o valor absoluto de n
            // n = Math.abs(n);
            n = n < 0 ? -n : n; // Se n for negativo, torna-o positivo
            for (int i = 2; i <= n / i; i++) {
                if (n % i == 0) {
                    result = i;
                    break;
                }
            }
            // return result == 0 ? n : result;
            return result;
        };

        System.out.println("Menor fator positivo de 12: " + smallestFactor.func(12));
        System.out.println("Menor fator positivo de 11: " + smallestFactor.func(11));


    }
}
interface NumericFuncDefault  {
    // A interface funcional deve ter um único método abstrato
    int func(int n);
}
