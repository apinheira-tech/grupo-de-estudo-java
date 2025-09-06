package ms.refatoracao.ge.ingressos.model.entities;

// src/main/java/ms/refagoracao/ge/ingressos/model/Performance.java
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String playID;
    private int audience;
}