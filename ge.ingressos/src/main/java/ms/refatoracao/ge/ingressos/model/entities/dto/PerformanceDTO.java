package ms.refatoracao.ge.ingressos.model.entities.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PerformanceDTO {
    private String playID;
    /* Audiencia= Numero de ingressos*/
    private int audience;
    /*private int numGuest;*/
}

/*public record IngressoModel(String name, String type) {} proprio para usar no DTO */