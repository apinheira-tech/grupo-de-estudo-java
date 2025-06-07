package exercs.cap12.trafficsimulator;

/*
    * TrafficSimulator.java
    *
    * This class represents a traffic simulator that manages the state of a traffic light.
    * It uses a thread to simulate the changing of the traffic light color.
    * Semágoro computadorizado.
    * @author: Simone - @apinheira-tech
 */
public class TrafficSimulator implements Runnable{
    // Contém a thread que executa a simulação do semáforo.
    private Thread thrd;
    // Contém a cor atual do semáforo.
    private ColorEnum color;
    // Configura com True para interromper a simulação.
    private boolean stop = false;

    // True quando o sinal mudou
    private boolean changed = false;

    TrafficSimulator(ColorEnum init) {
        color = init;
        thrd = new Thread(this);
        thrd.start();
    }
    TrafficSimulator() {
        color = ColorEnum.RED; // Inicia com o semáforo vermelho
        thrd = new Thread(this);
        thrd.start();
    }

    // Inicia a simulação do semáforo.
    public void run() {
        while (!stop) {
            try {
          /*      // Verde por 10 segundos
                Thread.sleep(1000); // Espera 1 segundo
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }*/
            // Muda a cor do semáforo
            switch (color) {
                case RED:
                    // RED por 12 segundos
                    Thread.sleep(12000); // Espera 12 segundos
                    break;
                case GREEN:
                    Thread.sleep(10000); // VERDE Espera 10 segundos
                    break;
                case YELLOW:
                    Thread.sleep(2000); // AMARELO Espera 2 segundos
                    break;
            }
                changeColor();
           /* changed = true; // Indica que a cor mudou*/
        } catch (InterruptedException exc) {
                //System.out.println("Thread interrupted: " + e.getMessage());
                System.out.println("Thread Interrompida: " + exc);
            }
                   }
    }

    // Muda a cor do semáforo
    synchronized void changeColor() {
        // Muda a cor do semáforo
        switch (color) {
            case RED:
                color = ColorEnum.GREEN; // Muda para verde
                break;
            case GREEN:
                color = ColorEnum.YELLOW; // Muda para amarelo
                break;
            case YELLOW:
                color = ColorEnum.RED; // Muda para vermelho
                break;
        }
        changed = true; // Indica que a cor mudou
        notify(); // Notifica qualquer thread esperando a mudança
    }

    /*
    * Retorna a cor atual do semáforo.
    * Espera até uma mudança de sinal ocorrer.
    */
    synchronized void waitForChange() {
        while (!changed) {
            try {
                wait(); // Espera até que a cor mude
                changed = false;
            } catch (InterruptedException exc) {
                System.out.println("Thread interrupted: " + exc.getMessage());
            }
        }
        // Retorna a cor atual do semáforo
        synchronized ColorEnum getColor(){
            return color;
        }
        /*changed = false; // Reseta o estado de mudança*/

        /*
        * Interrompe a simulação do semáforo.
         */
        synchronized void cancel() {
            stop = true; // Define a flag de parada como verdadeira
        }
    }
    /**
     * Classe de demostracao
     */
    /
    public static class TrafficDemo {
        public static void main(String[] args) {
            TrafficSimulator ts = new TrafficSimulator(ColorEnum.GREEN);
            for (int i = 0; i < 9; i++) {
                ts.waitForChange(); // Espera por uma mudança de cor
                System.out.println("Cor atual: " + ts.getColor()); // Exibe a cor atual
            }
            ts.cancel(); // Interrompe a simulação
        }
    }
}
