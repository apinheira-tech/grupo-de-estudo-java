package ms.refatoracao.ge.ingressos.model.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.Valid;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {
    @NotBlank(message = "O campo customer é obrigatório")
    private String customer;

    @JsonProperty("performances")
    @Valid
    private List<PerformanceDTO> performanceDTOS;
}
