package ms.refatoracao.ge.ingressos.services;

import ms.refatoracao.ge.ingressos.model.entities.dtos.InvoiceDTO;
import ms.refatoracao.ge.ingressos.model.entities.dtos.PlayDTO;
import ms.refatoracao.ge.ingressos.utilitaries.GenreUtil;
import org.springframework.stereotype.Service;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

/*import static ms.refatoracao.ge.ingressos.utilitaries.GenreUtil.*;*/

@Service
public class StatementService {

    public String createStatement(InvoiceDTO invoice, Map<String, PlayDTO> plays) {
        validateInputs(invoice, plays);

        var totalAmount = 0;
        var volumeCredits = 0;
        var result = new StringBuilder("Serviço de Extrato para " + invoice.getCustomer() + "\n");

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        for (var perf : invoice.getPerformanceDTOS()) {
            var play = plays.get(perf.getPlayID());
            if (play == null) {
                throw new IllegalArgumentException("Play ID não encontrado para o ID: " + perf.getPlayID());
            }

            int amount = GenreUtil.calculateAmount(play, perf.getAudience());

            // Soma créditos por volume
            // 1 crédito por cada 10 espectadores acima de 30
            volumeCredits += Math.max(perf.getAudience() - 30, 0);

            // Crédito extra para comédia
            if (GenreUtil.isComedy(play)) {
                volumeCredits += Math.floor((double) perf.getAudience() / 5);
            }

            result.append(String.format(" %s: %s (%d seats)\n",
                    play.getName(),
                    formatter.format(amount / 100.0),
                    perf.getAudience()));

            totalAmount += amount;
        }

        result.append(String.format("O valor devido é: %s\n", formatter.format(totalAmount / 100.0)));
        result.append(String.format("Você ganhou %d creditos\n", volumeCredits));

        return result.toString();
    }

    private void validateInputs(InvoiceDTO invoice, Map<String, PlayDTO> plays) {
        if (invoice == null) {
            throw new IllegalArgumentException("Invoice não pode ser nulo");
        }
        if (plays == null || plays.isEmpty()) {
            throw new IllegalArgumentException("Mapa de plays não pode estar vazio");
        }
        if (invoice.getPerformanceDTOS() == null || invoice.getPerformanceDTOS().isEmpty()) {
            throw new IllegalArgumentException("Lista de performances não pode estar vazia");
        }
    }

}
/*public String price () {

double basePrice = 100.0;
        int quantity = 600;*//*
  double basePrice = anOrder.basePrice();
        return basePrice > 1000;

        // Methodo, tratar para cada tipo de ingresso e atribuir os impostos, descontos e fretes (caso haja)

        return anOnder.basePrice() > 1000;

    }
        function price(order) {
// preço é igual ao preço base – desconto por
// quantidade (quantity discount) + frete (shipping)
return order.quantity * order.itemPrice -
Math.max(0, order.quantity - 500) * order.itemPrice * 0.05 +
Math.min(order.quantity * order.itemPrice * 0.1, 100); *//*
}
    */