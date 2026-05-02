package ms.refatoracao.ge.ingressos.model.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatementRequestDTO {
    @Valid
    private InvoiceDTO invoice;

    @NotEmpty(message = "O campo plays não pode estar vazio")
    private Map<String, PlayDTO> plays;
}