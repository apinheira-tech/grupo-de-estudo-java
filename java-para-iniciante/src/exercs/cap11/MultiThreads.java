package exercs.cap11;

/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since: 31/05/2025 (Dt de quando implementei essa classe no GE)
@Artefato: MultiThreads.java
Atividades do capítulo 10 - Threads
Livro: Java para Iniciantes - Herbert Schildt
@description: Exemplificando o conceito de Threads em Java.
                   Esta é a classe MultiThreads, que demonstra a criação e execução de múltiplas threads.
                   Métodos: Não possui métodos próprios, mas implementa a interface Runnable para definir o comportamento da thread.
                   Atributos: Possui um atributo Thread para representar a thread em execução.
                   Exceções: Trata InterruptedException durante a execução da thread.
*/

// Criando Vários Threads
public class MultiThreads implements Runnable  {
    Thread thrd;

    // Constrói nova Thread com o nome
    MultiThreads(String name) {
        thrd = new Thread(this, name);
        thrd.start(); // Inicia a Thread
    }
    // Começa a execução da nova Thread
    public void run() {
        System.out.println(thrd.getName() + " starting.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + thrd.getName() + ", count is " + count);
            }
        } catch (InterruptedException e) {
            System.out.println(thrd.getName() + " interrupted.");
        }
        System.out.println(thrd.getName() + " terminating.");
    }
}

class UseMultiThreads {
    public static void main(String[] args) {
        System.out.println("Main thread starting.");

        // Cria e inicia três Threads
        MultiThreads mt1 = new MultiThreads("Child #1");
        MultiThreads mt2 = new MultiThreads("Child #2");
        MultiThreads mt3 = new MultiThreads("Child #3");

       for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        }

        // Aguarda a finalização das Threads
        /* try {
            mt1.thrd.join();
            mt2.thrd.join();
            mt3.thrd.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        } */

        System.out.println("Main thread ending.");
    }
}
