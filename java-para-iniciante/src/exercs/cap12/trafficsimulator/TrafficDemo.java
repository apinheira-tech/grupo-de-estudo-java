package exercs.cap12.trafficsimulator;

/**
     * Classe de demostracao
     */
    
    public class TrafficDemo {
        public static void main(String[] args) {
            TrafficSimulator ts = new TrafficSimulator(ColorEnum.GREEN);
            for (int i = 0; i < 9; i++) {
                ts.waitForChange(); // Espera por uma mudança de cor
                System.out.println("Cor atual: " + ts.getColor()); // Exibe a cor atual
            }
            ts.cancel(); // Interrompe a simulação
        }
    }
