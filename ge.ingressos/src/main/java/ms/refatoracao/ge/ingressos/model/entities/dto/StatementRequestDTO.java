package ms.refatoracao.ge.ingressos.model.entities.dto;

import lombok.Data;

import java.util.Map;

@Data
public class StatementRequestDTO {
    private InvoiceDTO invoice;
    private Map<String, PlayDTO> plays;
}