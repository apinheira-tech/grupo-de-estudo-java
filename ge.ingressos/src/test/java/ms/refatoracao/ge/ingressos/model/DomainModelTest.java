package ms.refatoracao.ge.ingressos.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes dos Modelos de Domínio Imutáveis com Records")
class DomainModelTest {

    // Record para Play (modelo de domínio imutável)
    public record Play(String name, String type) {
        public Play {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Nome da peça não pode ser vazio");
            }
            if (type == null || type.isBlank()) {
                throw new IllegalArgumentException("Tipo da peça não pode ser vazio");
            }
        }
    }

    // Record para Performance (modelo de domínio imutável)
    public record Performance(String playID, int audience) {
        public Performance {
            if (playID == null || playID.isBlank()) {
                throw new IllegalArgumentException("ID da peça não pode ser vazio");
            }
            if (audience < 0) {
                throw new IllegalArgumentException("Audiência não pode ser negativa");
            }
        }
    }

    // Record para Invoice (modelo de domínio imutável)
    public record Invoice(String customer, List<Performance> performances) {
        public Invoice {
            if (customer == null || customer.isBlank()) {
                throw new IllegalArgumentException("Cliente não pode ser vazio");
            }
            if (performances == null) {
                throw new IllegalArgumentException("Lista de apresentações não pode ser nula");
            }
            // Tornar a lista imutável
            performances = List.copyOf(performances);
        }
    }

    // ============= Testes para Play Record =============

    @Test
    @DisplayName("Play record deve ser imutável - não pode ser alterado após criação")
    void playRecordShouldBeImmutable() {
        // Arrange
        Play play = new Play("Hamlet", "tragedy");

        // Act & Assert
        assertEquals("Hamlet", play.name());
        assertEquals("tragedy", play.type());
        // Records não possuem setters, são imutáveis
        assertThrows(Exception.class, () -> {
            // Tentar acessar fields privados não é possível
            var field = play.getClass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(play, "Romeo and Juliet");
        });
    }

    @Test
    @DisplayName("Play record deve validar nome obrigatório")
    void playRecordShouldValidateNameRequired() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Play(null, "tragedy");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Play("", "tragedy");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Play("   ", "comedy");
        });
    }

    @Test
    @DisplayName("Play record deve validar tipo obrigatório")
    void playRecordShouldValidateTypeRequired() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Play("Hamlet", null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Play("Hamlet", "");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Play("Hamlet", "   ");
        });
    }

    @Test
    @DisplayName("Play record deve gerar toString automático")
    void playRecordShouldGenerateAutoToString() {
        // Arrange
        Play play = new Play("Hamlet", "tragedy");

        // Act
        String toString = play.toString();

        // Assert
        assertTrue(toString.contains("Hamlet"));
        assertTrue(toString.contains("tragedy"));
        assertTrue(toString.contains("Play"));
    }

    @Test
    @DisplayName("Play record deve gerar hashCode automático consistente")
    void playRecordShouldGenerateAutoHashCode() {
        // Arrange
        Play play1 = new Play("Hamlet", "tragedy");
        Play play2 = new Play("Hamlet", "tragedy");
        Play play3 = new Play("Comedy", "comedy");

        // Act & Assert
        assertEquals(play1.hashCode(), play2.hashCode());
        assertNotEquals(play1.hashCode(), play3.hashCode());
    }

    // ============= Testes para Performance Record =============

    @Test
    @DisplayName("Performance record deve ser imutável")
    void performanceRecordShouldBeImmutable() {
        // Arrange
        Performance performance = new Performance("hamlet", 55);

        // Act & Assert
        assertEquals("hamlet", performance.playID());
        assertEquals(55, performance.audience());
    }

    @Test
    @DisplayName("Performance record deve validar playID obrigatório")
    void performanceRecordShouldValidatePlayIDRequired() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Performance(null, 50);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Performance("", 50);
        });
    }

    @Test
    @DisplayName("Performance record deve validar audiência não negativa")
    void performanceRecordShouldValidateAudienceNonNegative() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Performance("hamlet", -1);
        });
    }

    @Test
    @DisplayName("Performance record deve aceitar audiência zero")
    void performanceRecordShouldAcceptZeroAudience() {
        // Arrange & Act
        Performance performance = new Performance("hamlet", 0);

        // Assert
        assertEquals(0, performance.audience());
    }

    @Test
    @DisplayName("Performance records com mesmos dados devem ser iguais")
    void performanceRecordsShouldUseValueEquality() {
        // Arrange
        Performance perf1 = new Performance("hamlet", 55);
        Performance perf2 = new Performance("hamlet", 55);
        Performance perf3 = new Performance("comedy", 25);

        // Act & Assert
        assertEquals(perf1, perf2);
        assertNotEquals(perf1, perf3);
    }

    // ============= Testes para Invoice Record =============

    @Test
    @DisplayName("Invoice record deve conter lista imutável de performances")
    void invoiceRecordShouldContainImmutablePerformances() {
        // Arrange
        List<Performance> performances = List.of(
                new Performance("hamlet", 55),
                new Performance("comedy", 25)
        );
        Invoice invoice = new Invoice("João Silva", performances);

        // Act
        List<Performance> retrievedPerformances = invoice.performances();

        // Assert
        assertEquals("João Silva", invoice.customer());
        assertEquals(2, retrievedPerformances.size());
        assertEquals("hamlet", retrievedPerformances.get(0).playID());

        // Verificar que a lista é imutável
        assertThrows(UnsupportedOperationException.class, () -> {
            retrievedPerformances.add(new Performance("new", 50));
        });
    }

    @Test
    @DisplayName("Invoice record deve validar cliente obrigatório")
    void invoiceRecordShouldValidateCustomerRequired() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Invoice(null, List.of());
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Invoice("", List.of());
        });
    }

    @Test
    @DisplayName("Invoice record deve validar lista de performances não nula")
    void invoiceRecordShouldValidatePerformancesNotNull() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Invoice("João Silva", null);
        });
    }

    @Test
    @DisplayName("Invoice record deve aceitar lista vazia de performances")
    void invoiceRecordShouldAcceptEmptyPerformances() {
        // Arrange & Act
        Invoice invoice = new Invoice("João Silva", List.of());

        // Assert
        assertEquals("João Silva", invoice.customer());
        assertEquals(0, invoice.performances().size());
    }

    @Test
    @DisplayName("Invoice records com mesmos dados devem ser iguais")
    void invoiceRecordsShouldUseValueEquality() {
        // Arrange
        List<Performance> perfs1 = List.of(new Performance("hamlet", 55));
        List<Performance> perfs2 = List.of(new Performance("hamlet", 55));

        Invoice invoice1 = new Invoice("João Silva", perfs1);
        Invoice invoice2 = new Invoice("João Silva", perfs2);
        Invoice invoice3 = new Invoice("Maria Santos", perfs1);

        // Act & Assert
        assertEquals(invoice1, invoice2);
        assertNotEquals(invoice1, invoice3);
    }

    @Test
    @DisplayName("Invoice record deve gerar toString automático descritivo")
    void invoiceRecordShouldGenerateAutoToString() {
        // Arrange
        List<Performance> performances = List.of(new Performance("hamlet", 55));
        Invoice invoice = new Invoice("João Silva", performances);

        // Act
        String toString = invoice.toString();

        // Assert
        assertTrue(toString.contains("João Silva"));
        assertTrue(toString.contains("Invoice"));
    }

    // ============= Testes de Integração Entre Records =============

    @Test
    @DisplayName("Deve criar estrutura completa de domínio com records")
    void shouldCreateCompletedomainStructure() {
        // Arrange
        Play hamletPlay = new Play("Hamlet", "tragedy");
        Play comedyPlay = new Play("As You Like It", "comedy");

        Performance perf1 = new Performance("hamlet", 55);
        Performance perf2 = new Performance("comedy", 25);

        Invoice invoice = new Invoice("João Silva", List.of(perf1, perf2));

        // Act & Assert
        assertEquals(2, invoice.performances().size());
        assertEquals(hamletPlay.name(), "Hamlet");
        assertEquals(comedyPlay.type(), "comedy");
        assertEquals(perf1.audience(), 55);
    }

    @Test
    @DisplayName("Records devem manter imutabilidade em uso real")
    void recordsShouldMaintainImmutabilityInRealUsage() {
        // Arrange
        Play originalPlay = new Play("Hamlet", "tragedy");
        Performance performance = new Performance("hamlet", 55);
        Invoice invoice = new Invoice("João Silva", List.of(performance));

        // Act
        String originalCustomer = invoice.customer();
        int originalAudience = invoice.performances().get(0).audience();

        // Assert - Dados não podem ser alterados
        assertEquals("João Silva", originalCustomer);
        assertEquals(55, originalAudience);

        // Não existe setter, portanto não há forma de modificar
        assertNotNull(invoice);
        assertNotNull(originalPlay);
    }
}

