<<<<<<< HEAD:ge.ingressos/src/main/java/ms/refatoracao/ge/ingressos/model/entities/dto/InvoiceDTO.java
package ms.refatoracao.ge.ingressos.model.entities.dto;
=======
package ms.refagoracao.ge.ingressos.model.dto;
>>>>>>> 7e838a34861fadada3fdce1ab80c828fdfc29cd7:ge.ingressos/src/main/java/ms/refagoracao/ge/ingressos/model/dto/InvoiceDTO.java

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class InvoiceDTO {
    private String customer;
    private List<PerformanceDTO> performances;
}
