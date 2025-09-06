package ms.refatoracao.ge.ingressos.model.entities.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayDTO {
    private String name;
    private String type;
}
