package ms.refagoracao.ge.ingressos.model.dto;

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