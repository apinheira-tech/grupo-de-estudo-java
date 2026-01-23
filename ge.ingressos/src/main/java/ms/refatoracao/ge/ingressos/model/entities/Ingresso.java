package ms.refatoracao.ge.ingressos.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ingresso {

    @NotBlank(message = "O nome do ingresso é obrigatório")
    private String name;
    @NotBlank(message = "O tipo do ingresso é obrigatório")
    private String type;

}
