package exercs.cap9;

/*[
    * 9.1 - Exceções não tratadas
    * Deica a JVM tratar o erro
 */
public class NotHandled {
    public static void main(String[] args) {
        // int nums[] = {1, 2, 3, 4, 5};
        // forma implementada pelo livro Java para iniciantes
        int nums[] = new int[4];
        System.out.println("Before exception is generated.");

        // Gera uma exceção de índice fora dos limites do array
        nums[7] = 10; // Tentando acessar um índice fora dos limites do array

    }
}
