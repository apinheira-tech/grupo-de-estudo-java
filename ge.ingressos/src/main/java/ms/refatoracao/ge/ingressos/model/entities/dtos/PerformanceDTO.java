package ms.refatoracao.ge.ingressos.model.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceDTO {
    @NotBlank(message = "O campo playID é obrigatório")
    @JsonProperty("playID")
    private String playID;

    @Positive(message = "A audiência deve ser maior que zero")
    private int audience;
}
