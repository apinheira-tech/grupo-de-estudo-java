package exercs.cap11;

/*
@author: Simone (Grupo de Estudos sobre Java)
@version: 1.0
@since: 31/05/2025 (Dt de quando implementei essa classe no GE)
@Artefato: MyThread.java
Atividades do capítulo 11 - Threads
Livro: Java para Iniciantes - Herbert Schildt
@description: Exemplificando o conceito de Threads em Java.
                    Esta é a classe MyThread, que implementa a interface Runnable para definir o comportamento da thread.
                    Métodos: Implementa o método run() para definir o que a thread fará quando for executada.
                    Atributos: Possui um atributo Thread para representar a thread em execução.
                    Exceções: Trata InterruptedException durante a execução da thread.
                    Esta classe demonstra a criação e execução de uma thread simples.
*/


class MyThread implements Runnable {

    //String thrdName;
    Thread thrd;

    // Controi a nova Thread com o nome
    MyThread(String name) {
        //thrdName = name;
        // Cria uma nova Thread e passa a si mesmo como alvo
        // A Thread e nomeada quando eh criada
        thrd = new Thread(this, name);
        // Thread inicializada - começa a executar a thread
        thrd.start();
    }

    // Comeca a execução da nova Thread
    @Override
    public void run() {
        //System.out.println(thrdName + " starting.");
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

class UseThreads {
    public static void main(String[] args) {
        System.out.println("Main thread starting.");

        // A Thread começa quando é criada
        MyThread mt = new MyThread("Child #1");

        // Na segunda implementação, ele retira estas duas implementações (43 e 44)
        Thread newThrd = new Thread(mt);
        newThrd.start();

        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        }
        System.out.println("Main thread ending.");
    }
}