package exercs.cap13;

/*
 *
@author: Simone, Ricardo e William (Grupo de Estudos sobre Java)
@version: 1.0
@since: 15/06/2025 (Dt de quando implementei essa classe no GE)
@Artefato: FlighSched.java
Atividades do capítulo 13 - Generics
Livro: Java para Iniciantes - Herbert Schildt
@description:  Implementação de uma classe genérica FlighSched que representa um voo com origem e destino.
               Classe FlighSched que representa um voo com origem e destino genéricos.
               Utiliza Generics para permitir diferentes tipos de origem e destino.
 */
public class FlighSched <T, U extends Number>  {
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
        // FlighSched<String, String> voo = new FlighSched<>("São Paulo", "Rio de Janeiro");
        FlighSched<String, Integer> voo = new FlighSched<>("GRU - São Paulo", 1130);

        System.out.println("Origem: " + voo.getOrigem());
        System.out.println("Destino: " + voo.getDestino());

        //voo.setDestino("Belo Horizonte");
        //System.out.println("Novo destino: " + voo.getDestino());

        //voo.setDestino("Curitiba");
        //System.out.println("Destino 2: " + voo.getDestino());
        voo.setDestino(1130);
        System.out.println("Destino 1 alterado- Novo Destino: " + voo.getDestino());

        voo.setOrigem("Belo Horizonte");
        System.out.println("Origem alterada- Nova Origem: " + voo.getOrigem());

    }

}
