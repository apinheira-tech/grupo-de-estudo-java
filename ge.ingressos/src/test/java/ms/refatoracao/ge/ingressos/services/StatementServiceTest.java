package ms.refatoracao.ge.ingressos.services;

import ms.refatoracao.ge.ingressos.model.entities.dtos.InvoiceDTO;
import ms.refatoracao.ge.ingressos.model.entities.dtos.PerformanceDTO;
import ms.refatoracao.ge.ingressos.model.entities.dtos.PlayDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Testes do Serviço de Extrato")
class StatementServiceTest {

    private StatementService statementService;

    @BeforeEach
    void setUp() {
        statementService = new StatementService();
    }

    @Test
    @DisplayName("Deve gerar extrato com apresentações de tragédia")
    void shouldGenerateStatementWithTragedy() {
        // Arrange
        PlayDTO hamletPlayDTO = PlayDTO.builder()
                .name("Hamlet")
                .type("tragedy")
                .build();

        PerformanceDTO performanceDTO = PerformanceDTO.builder()
                .playID("hamlet")
                .audience(55)
                .build();

        InvoiceDTO invoiceDTO = InvoiceDTO.builder()
                .customer("João Silva")
                .performanceDTOS(List.of(performanceDTO))
                .build();

        Map<String, PlayDTO> plays = Map.of("hamlet", hamletPlayDTO);

        // Act
        String result = statementService.createStatement(invoiceDTO, plays);

        // Assert
        assertNotNull(result);
        assertTrue(result.contains("João Silva"));
        assertTrue(result.contains("Hamlet"));
        assertTrue(result.contains("55 seats"));
    }

    @Test
    @DisplayName("Deve gerar extrato com apresentações de comédia")
    void shouldGenerateStatementWithComedy() {
        // Arrange
        PlayDTO comedyPlayDTO = PlayDTO.builder()
                .name("As You Like It")
                .type("comedy")
                .build();

        PerformanceDTO performanceDTO = PerformanceDTO.builder()
                .playID("comedy")
                .audience(25)
                .build();

        InvoiceDTO invoiceDTO = InvoiceDTO.builder()
                .customer("Maria Santos")
                .performanceDTOS(List.of(performanceDTO))
                .build();

        Map<String, PlayDTO> plays = Map.of("comedy", comedyPlayDTO);

        // Act
        String result = statementService.createStatement(invoiceDTO, plays);

        // Assert
        assertNotNull(result);
        assertTrue(result.contains("Maria Santos"));
        assertTrue(result.contains("As You Like It"));
        assertTrue(result.contains("25 seats"));
    }

    @Test
    @DisplayName("Deve lançar exceção para tipo de peça desconhecido")
    void shouldThrowExceptionForUnknownPlayType() {
        // Arrange
        PlayDTO unknownPlayDTO = PlayDTO.builder()
                .name("Unknown")
                .type("unknown")
                .build();

        PerformanceDTO performanceDTO = PerformanceDTO.builder()
                .playID("unknown")
                .audience(50)
                .build();

        InvoiceDTO invoiceDTO = InvoiceDTO.builder()
                .customer("Test Customer")
                .performanceDTOS(List.of(performanceDTO))
                .build();

        Map<String, PlayDTO> plays = Map.of("unknown", unknownPlayDTO);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            statementService.createStatement(invoiceDTO, plays);
        });
    }

    @Test
    @DisplayName("Deve calcular múltiplas apresentações corretamente")
    void shouldCalculateMultiplePerformances() {
        // Arrange
        PlayDTO tragedy = PlayDTO.builder()
                .name("Hamlet")
                .type("tragedy")
                .build();

        PlayDTO comedy = PlayDTO.builder()
                .name("Comedy Play")
                .type("comedy")
                .build();

        List<PerformanceDTO> performanceDTOS = List.of(
                PerformanceDTO.builder().playID("hamlet").audience(55).build(),
                PerformanceDTO.builder().playID("comedy").audience(25).build()
        );

        InvoiceDTO invoiceDTO = InvoiceDTO.builder()
                .customer("Cliente Multiplo")
                .performanceDTOS(performanceDTOS)
                .build();

        Map<String, PlayDTO> plays = Map.of(
                "hamlet", tragedy,
                "comedy", comedy
        );

        // Act
        String result = statementService.createStatement(invoiceDTO, plays);

        // Assert
        assertNotNull(result);
        assertTrue(result.contains("Cliente Multiplo"));
        assertTrue(result.contains("Hamlet"));
        assertTrue(result.contains("Comedy Play"));
        assertTrue(result.contains("creditos"));
    }

    @Test
    @DisplayName("Deve calcular corretamente o valor para tragédia com audience > 30")
    void shouldCalculateCorrectAmountForTragedyWithHighAudience() {
        // Arrange: 40000 + 1000 * (55 - 30) = 65000
        PlayDTO tragedy = PlayDTO.builder()
                .name("Hamlet")
                .type("tragedy")
                .build();

        PerformanceDTO performanceDTO = PerformanceDTO.builder()
                .playID("hamlet")
                .audience(55)
                .build();

        InvoiceDTO invoiceDTO = InvoiceDTO.builder()
                .customer("Test")
                .performanceDTOS(List.of(performanceDTO))
                .build();

        Map<String, PlayDTO> plays = Map.of("hamlet", tragedy);

        // Act
        String result = statementService.createStatement(invoiceDTO, plays);

        // Assert - Verifica se o valor foi calculado corretamente (650.00 = 65000/100)
        assertTrue(result.contains("$650.00"));
    }

    @Test
    @DisplayName("Deve gerar extrato vazio para cliente sem apresentações")
    void shouldGenerateEmptyStatementForCustomerWithoutPerformances() {
        // Arrange
        InvoiceDTO invoiceDTO = InvoiceDTO.builder()
                .customer("Cliente Sem Shows")
                .performanceDTOS(List.of())
                .build();

        Map<String, PlayDTO> plays = Map.of();

        // Act
        String result = statementService.createStatement(invoiceDTO, plays);

        // Assert
        assertNotNull(result);
        assertTrue(result.contains("Cliente Sem Shows"));
        assertTrue(result.contains("$0.00"));
        assertTrue(result.contains("0 creditos"));
    }
}

