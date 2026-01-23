package ms.refatoracao.ge.ingressos.model.entities.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class InvoiceDTO {
    private String customer;
    private List<PerformanceDTO> performances;
}
