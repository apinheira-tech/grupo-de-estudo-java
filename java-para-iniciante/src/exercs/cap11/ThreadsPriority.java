package exercs.cap11;

/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since: 31/05/2025 (Dt de quando implementei essa classe no GE)
@Artefato: ThreadsPriority.java
Atividades do capítulo 11 - Threads
Livro: Java para Iniciantes - Herbert Schildt
@description: Exemplificando o conceito de Threads em Java.
                Esta é a classe ThreadsPriority, que implementa a interface Runnable para definir o comportamento da thread.
                Métodos: Implementa o método run() para definir o que a thread fará quando for executada.
                Atributos: Possui um atributo Thread para representar a thread em execução e um contador para contar iterações.
                Exceções: Trata InterruptedException durante a execução da thread.

*/
// Demonstra as prioridades de threads
class ThreadsPriority implements Runnable {
    int count;
    Thread thrd;

    static boolean stop = false;
    static String currentName = " ";

    // Constrói uma nova Thread com o nome
    // Constroi a nova Thread. Observe que esse constrtutor não
    // inicia realmente a execução da Thread.

    ThreadsPriority(String name) {
        thrd = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    // Começa a execução da nova Thread
    @Override
    public void run() {
        System.out.println(thrd.getName() + " starting.");

        // Enquanto stop for false, incrementa count
        do {
            count++;

            if (currentName.compareTo(thrd.getName()) != 0) {
                // Se o nome da Thread atual for diferente do nome da Thread que está executando
                // então interrompe a Thread atual
                currentName = thrd.getName();
                System.out.println("In " + currentName);
            }

            // Incrementa Thread a alcança 10.000.000 interromp
            // todas as outras Threads
        } while (stop == false && count < 100000000);
        stop = true;

        System.out.println("\n" + thrd.getName() + " terminating. Count is " + count);
    }
}

class PriorityDemo {
    public static void main(String[] args) {
        // Cria três Threads
        ThreadsPriority mt1 = new ThreadsPriority("Low Priority");
        ThreadsPriority mt2 = new ThreadsPriority("Medium Priority");
        ThreadsPriority mt3 = new ThreadsPriority("High Priority");

        // Define as prioridades das Threads
        mt1.thrd.setPriority(Thread.MIN_PRIORITY); // 1
        mt2.thrd.setPriority(Thread.NORM_PRIORITY); // 5
        mt3.thrd.setPriority(Thread.MAX_PRIORITY); // 10

        // Inicia as Threads
        mt1.thrd.start();
        mt2.thrd.start();
        mt3.thrd.start();

        // Aguarda a finalização das Threads
        try {
            mt1.thrd.join();
            mt2.thrd.join();
            mt3.thrd.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("\nLow priority thread count: " + mt1.count);
        System.out.println("Medium priority thread count: " + mt2.count);
        System.out.println("High priority thread count: " + mt3.count);
    }
}