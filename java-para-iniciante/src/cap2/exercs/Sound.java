package cap2.exercs;


public class Sound {
    public Sound() {
    }

    public static void main(String[] args) {
        double distP = 7920.0;
        double distM = distP / 3.281;
        System.out.println("Distancia por pés: " + distP + " Testo qualquer");
        System.out.printf("\nDistancia por pés: %.3f", distP);
        System.out.printf("\nDistancia por metro: %.2f", distM);
    }
}
