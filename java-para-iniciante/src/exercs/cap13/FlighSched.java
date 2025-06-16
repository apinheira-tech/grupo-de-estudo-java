package exercs.cap13;

public class FlighSched <T, U>  {
    private T origem;
    private U destino;

    /*
     * Construtor da classe FlighSched.
     */
    public FlighSched(T origem, U destino) {
        this.origem = origem;
        this.destino = destino;
    }

    /*
     * Gets dos atributos origem e destino.
     */
    public T getOrigem() {
        return origem;
    }

    /*
     * Sets dos atributos origem e destino.
     */
    public void setOrigem(T origem) {
        this.origem = origem;
    }

    public U getDestino() {
        return destino;
    }

    public void setDestino(U destino) {
        this.destino = destino;
    }

    public static void main(String[] args) {
        // Exemplo de uso da classe FlighSched, como Generics
        FlighSched<String, String> voo = new FlighSched<>("São Paulo", "Rio de Janeiro");

        System.out.println("Origem: " + voo.getOrigem());
        System.out.println("Destino: " + voo.getDestino());

        voo.setDestino("Belo Horizonte");
        System.out.println("Novo destino: " + voo.getDestino());

        voo.setDestino("Curitiba");
        System.out.println("Destino 2: " + voo.getDestino());

    }

}
