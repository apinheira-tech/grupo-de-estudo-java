package ms.refagoracao.ge.ingressos.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.Message;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngressoModel {

    /*@NotBlank(message = "O nome do ingresso é obrigatório")*/
    private String name;
    /*@NotBlank(message = "O tipo do ingresso é obrigatório")*/
    private String type;

    /*public record IngressoModel(String name, String type) {}*/
}
