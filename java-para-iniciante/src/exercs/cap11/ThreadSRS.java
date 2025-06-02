package exercs.cap11;

/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since: 31/05/2025 (Dt de quando implementei essa classe no GE)
@Artefato: ThreadSRS.java
Atividades do capítulo 11 - Threads e Concorrência
Livro: Java para Iniciantes - Herbert Schildt
@description: Exemplificando o conceito de Threads em Java.
                Esta é a classe ThreadSRS, que implementa a interface Runnable para definir o comportamento da thread.
                Métodos: Implementa o método run() para definir o que a thread fará quando for executada.
                Atributos: Possui um atributo Thread para representar a thread em execução, além de atributos para controlar suspensão e parada da thread.
                Exceções: Trata InterruptedException durante a execução da thread.

*/
public class ThreadSRS implements Runnable{
    Thread thrd;

    // Suspede a thread quando igual a true
    boolean suspended;
    // Encerra a thread quando igual a true
    boolean stopped;
    // Constrói uma nova Thread com o nome
    ThreadSRS(String name) {
        thrd = new Thread(this, name);
        suspended = false;
        stopped = false;
        thrd.start(); // Inicia a Thread
    }

    // Começa a execução da nova Thread
    @Override
    public void run() {
        System.out.println(thrd.getName() + " starting.");
        try {
            for (int count = 1; count < 1000; count++) {
                System.out.println(count + "");
                // Se a Thread estiver suspensa, espera até que seja retomada
                if ((count%10) == 0) {
                    System.out.println();
                    Thread.sleep(250);
                }
                synchronized(this) {
                    while (suspended) {
                        wait();
                    }
                    if (stopped) {
                        break; // Sai do loop se a Thread estiver parada
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(thrd.getName() + " interrupted.");
        }
            System.out.println(thrd.getName() + " existing.");
    }
    // Encerra a Thread
    synchronized void mystop() {
        stopped = true;
        // o código a seguir assegura que uma thread suspensa possa
        // ser encerrada
        suspended = false;
        // Garante que a Thread não esteja suspensa
        notify(); // Notifica a Thread para que ela possa sair do loop
    }
    // Suspende a Thread
    synchronized void mysuspend() {
        suspended = true;
    }

    // Retoma a Thread
    synchronized void myresume() {
        suspended = false;
        notify(); // Notifica a Thread para que ela possa continuar
    }
}

class Suspend {
    public static void main(String[] args) {
        ThreadSRS obj = new ThreadSRS("My Thread");
        try {
            Thread.sleep(1000); // Aguarda 1 segundo

            obj.mysuspend(); // Suspende a Thread
            System.out.println("Suspending thread.");
            Thread.sleep(1000); // Aguarda 1 segundo

            obj.myresume(); // Retoma a Thread
            System.out.println("Resuming thread.");
            Thread.sleep(1000); // Aguarda 1 segundo

            obj.mysuspend(); // Encerra a Thread
            System.out.println("Stopping thread.");
            Thread.sleep(1000); // Aguarda 1 segundo

            obj.myresume(); // Retoma a Thread
            System.out.println("Resuming thread.");
            Thread.sleep(1000); // Aguarda 1 segundo

            obj.myresume(); // Encerra a Thread
            System.out.println("Stopping thread.");
            Thread.sleep(1000); // Aguarda 1 segundo

            obj.myresume(); // Retoma a Thread
            System.out.println("Resuming thread.");
            Thread.sleep(1000); // Aguarda 1 segundo

            obj.mysuspend();
            System.out.println("Stopping thread.");
            obj.mystop(); // Encerra a Thread

        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        try {
            obj.thrd.join(); // Aguarda a finalização da Thread
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");

        }
    }
}

