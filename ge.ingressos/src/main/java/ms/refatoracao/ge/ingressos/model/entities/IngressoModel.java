package ms.refagoracao.ge.ingressos.model.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngressoModel {

    @NotBlank(message = "O nome do ingresso é obrigatório")
    private String name;
    @NotBlank(message = "O tipo do ingresso é obrigatório")
    private String type;

}
