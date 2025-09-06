package ms.refatoracao.ge.ingressos.services;
import ms.refatoracao.ge.ingressos.model.entities.dto.InvoiceDTO;
import ms.refatoracao.ge.ingressos.model.entities.dto.PlayDTO;
import org.springframework.stereotype.Service;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

@Service
public class StatementService {

    public String createStatement(InvoiceDTO invoice, Map<String, PlayDTO> plays) {
        var totalAmount = 0;
        var volumeCredits = 0;
        var result = new StringBuilder("Serviço de Extrato para " + invoice.getCustomer() + "\n");

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        for (var perf : invoice.getPerformances()) {
            var play = plays.get(perf.getPlayID());
            var thisAmount = calculateAmount(play, perf.getAudience());

            // Soma créditos por volume
            volumeCredits += Math.max(perf.getAudience() - 30, 0);

            // Crédito extra para comédia
            if ("comedy".equals(play.getType())) {
                volumeCredits += Math.floor(perf.getAudience() / 5);
            }

            result.append(String.format(" %s: %s (%d seats)\n",
                    play.getName(),
                    formatter.format(thisAmount / 100.0),
                    perf.getAudience()));

            totalAmount += thisAmount;
        }

        result.append(String.format("O valor devido é: %s\n", formatter.format(totalAmount / 100.0)));
        result.append(String.format("Você ganhou %d creditos\n", volumeCredits));

        return result.toString();
    }

    private int calculateAmount(PlayDTO play, int audience) {
        return switch (play.getType()) {
            case "tragedy" -> {
                int amount = 40000;
                if (audience > 30) {
                    amount += 1000 * (audience - 30);
                }
                yield amount;
            }
            case "comedy" -> {
                int amount = 30000;
                if (audience > 20) {
                    amount += 10000 + 500 * (audience - 20);
                }
                amount += 300 * audience;
                yield amount;
            }
            default -> throw new IllegalArgumentException("Tipo desconhecido: " + play.getType());
        };
    }
}
