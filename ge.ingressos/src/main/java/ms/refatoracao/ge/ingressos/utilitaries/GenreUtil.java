package ms.refatoracao.ge.ingressos.utilitaries;

import ms.refatoracao.ge.ingressos.model.entities.dtos.PlayDTO;

/*
@auth: Simone
Esta classe verifica o genero de peça e calcula a audiencia para cada genero
 */
public final class GenreUtil {
    
    private GenreUtil() {
        throw new UnsupportedOperationException("Classe utilitária não pode ser instanciada");
    }

    // Verifica se o tipo de peça é comédia
    public static boolean isComedy(PlayDTO playDTO) {
        return "comedy".equals(playDTO.getType());
    }

    // Calcula o valor da apresentação baseado no tipo e público
    public static int calculateAmount(PlayDTO playDTO, int audience) {
        return switch (playDTO.getType()) {
            case "tragedy" -> calculateTragedy(audience);
            case "comedy" -> calculateComedy(audience);
            default -> throw new IllegalArgumentException("Tipo desconhecido: " + playDTO.getType());
        };
    }

    // Calcula valor para tragédia
    private static int calculateTragedy(int audience) {
        int amount = 40000;
        if (audience > 30) {
            amount += 1000 * (audience - 30);
        }
        return amount;
    }

    // Calcula valor para comédia
    private static int calculateComedy(int audience) {
        int amount = 30000;
        if (audience > 20) {
            amount += 10000 + 500 * (audience - 20);
        }
        amount += 300 * audience;
        return amount;
    }

}
