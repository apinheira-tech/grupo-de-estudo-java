package ms.refatoracao.ge.ingressos.services;

import ms.refatoracao.ge.ingressos.model.entities.dto.InvoiceDTO;
import ms.refatoracao.ge.ingressos.model.entities.dto.PerformanceDTO;
import ms.refatoracao.ge.ingressos.model.entities.dto.PlayDTO;
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
        PlayDTO hamletPlay = PlayDTO.builder()
                .name("Hamlet")
                .type("tragedy")
                .build();

        PerformanceDTO performance = PerformanceDTO.builder()
                .playID("hamlet")
                .audience(55)
                .build();

        InvoiceDTO invoice = InvoiceDTO.builder()
                .customer("João Silva")
                .performances(List.of(performance))
                .build();

        Map<String, PlayDTO> plays = Map.of("hamlet", hamletPlay);

        // Act
        String result = statementService.createStatement(invoice, plays);

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
        PlayDTO comedyPlay = PlayDTO.builder()
                .name("As You Like It")
                .type("comedy")
                .build();

        PerformanceDTO performance = PerformanceDTO.builder()
                .playID("comedy")
                .audience(25)
                .build();

        InvoiceDTO invoice = InvoiceDTO.builder()
                .customer("Maria Santos")
                .performances(List.of(performance))
                .build();

        Map<String, PlayDTO> plays = Map.of("comedy", comedyPlay);

        // Act
        String result = statementService.createStatement(invoice, plays);

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
        PlayDTO unknownPlay = PlayDTO.builder()
                .name("Unknown")
                .type("unknown")
                .build();

        PerformanceDTO performance = PerformanceDTO.builder()
                .playID("unknown")
                .audience(50)
                .build();

        InvoiceDTO invoice = InvoiceDTO.builder()
                .customer("Test Customer")
                .performances(List.of(performance))
                .build();

        Map<String, PlayDTO> plays = Map.of("unknown", unknownPlay);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            statementService.createStatement(invoice, plays);
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

        List<PerformanceDTO> performances = List.of(
                PerformanceDTO.builder().playID("hamlet").audience(55).build(),
                PerformanceDTO.builder().playID("comedy").audience(25).build()
        );

        InvoiceDTO invoice = InvoiceDTO.builder()
                .customer("Cliente Multiplo")
                .performances(performances)
                .build();

        Map<String, PlayDTO> plays = Map.of(
                "hamlet", tragedy,
                "comedy", comedy
        );

        // Act
        String result = statementService.createStatement(invoice, plays);

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

        PerformanceDTO performance = PerformanceDTO.builder()
                .playID("hamlet")
                .audience(55)
                .build();

        InvoiceDTO invoice = InvoiceDTO.builder()
                .customer("Test")
                .performances(List.of(performance))
                .build();

        Map<String, PlayDTO> plays = Map.of("hamlet", tragedy);

        // Act
        String result = statementService.createStatement(invoice, plays);

        // Assert - Verifica se o valor foi calculado corretamente (650.00 = 65000/100)
        assertTrue(result.contains("$650.00"));
    }

    @Test
    @DisplayName("Deve gerar extrato vazio para cliente sem apresentações")
    void shouldGenerateEmptyStatementForCustomerWithoutPerformances() {
        // Arrange
        InvoiceDTO invoice = InvoiceDTO.builder()
                .customer("Cliente Sem Shows")
                .performances(List.of())
                .build();

        Map<String, PlayDTO> plays = Map.of();

        // Act
        String result = statementService.createStatement(invoice, plays);

        // Assert
        assertNotNull(result);
        assertTrue(result.contains("Cliente Sem Shows"));
        assertTrue(result.contains("$0.00"));
        assertTrue(result.contains("0 creditos"));
    }
}

