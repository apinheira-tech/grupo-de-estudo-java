package ms.refatoracao.ge.ingressos.model.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayDTO {
    @NotBlank(message = "O campo name é obrigatório")
    private String name;

    @NotBlank(message = "O campo type é obrigatório")
    private String type;
}
