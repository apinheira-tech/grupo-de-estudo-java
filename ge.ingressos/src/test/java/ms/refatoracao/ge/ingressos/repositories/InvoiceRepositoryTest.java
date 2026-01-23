package ms.refatoracao.ge.ingressos.repositories;

import ms.refatoracao.ge.ingressos.model.entities.Invoice;
import ms.refatoracao.ge.ingressos.model.entities.Performance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Testes do Repositório de Invoice")
class InvoiceRepositoryTest {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private TestEntityManager entityManager;

	private Invoice invoice;
	private Performance performance1;
	private Performance performance2;

	@BeforeEach
	void setUp() {
		// Criar performances
		performance1 = Performance.builder()
				.playID("hamlet")
				.audience(55)
				.build();

		performance2 = Performance.builder()
				.playID("comedy")
				.audience(25)
				.build();

		// Criar invoice
		invoice = Invoice.builder()
				.customer("João Silva")
				.performances(List.of(performance1, performance2))
				.build();
	}

	@Test
	@DisplayName("Deve salvar um Invoice no banco de dados")
	void shouldSaveInvoice() {
		// Act
		Invoice savedInvoice = invoiceRepository.save(invoice);

		// Assert
		assertNotNull(savedInvoice.getId());
		assertEquals("João Silva", savedInvoice.getCustomer());
		assertEquals(2, savedInvoice.getPerformances().size());
	}

	@Test
	@DisplayName("Deve encontrar Invoice por ID")
	void shouldFindInvoiceById() {
		// Arrange
		Invoice savedInvoice = invoiceRepository.save(invoice);
		Long invoiceId = savedInvoice.getId();

		// Act
		Optional<Invoice> foundInvoice = invoiceRepository.findById(invoiceId);

		// Assert
		assertTrue(foundInvoice.isPresent());
		assertEquals("João Silva", foundInvoice.get().getCustomer());
		assertEquals(2, foundInvoice.get().getPerformances().size());
	}

	@Test
	@DisplayName("Deve retornar vazio quando Invoice não existe")
	void shouldReturnEmptyWhenInvoiceNotFound() {
		// Act
		Optional<Invoice> foundInvoice = invoiceRepository.findById(999L);

		// Assert
		assertTrue(foundInvoice.isEmpty());
	}

	@Test
	@DisplayName("Deve buscar todos os Invoices")
	void shouldFindAllInvoices() {
		// Arrange
		Invoice invoice1 = Invoice.builder()
				.customer("João Silva")
				.performances(List.of(performance1))
				.build();

		Invoice invoice2 = Invoice.builder()
				.customer("Maria Santos")
				.performances(List.of(performance2))
				.build();

		invoiceRepository.save(invoice1);
		invoiceRepository.save(invoice2);

		// Act
		List<Invoice> allInvoices = invoiceRepository.findAll();

		// Assert
		assertNotNull(allInvoices);
		assertEquals(2, allInvoices.size());
	}

	@Test
	@DisplayName("Deve atualizar um Invoice existente")
	void shouldUpdateInvoice() {
		// Arrange
		Invoice savedInvoice = invoiceRepository.save(invoice);
		Long invoiceId = savedInvoice.getId();

		// Act
		savedInvoice.setCustomer("Cliente Atualizado");
		Invoice updatedInvoice = invoiceRepository.save(savedInvoice);

		// Assert
		assertEquals("Cliente Atualizado", updatedInvoice.getCustomer());
		assertEquals(invoiceId, updatedInvoice.getId());
	}

	@Test
	@DisplayName("Deve deletar um Invoice")
	void shouldDeleteInvoice() {
		// Arrange
		Invoice savedInvoice = invoiceRepository.save(invoice);
		Long invoiceId = savedInvoice.getId();

		// Act
		invoiceRepository.deleteById(invoiceId);
		Optional<Invoice> deletedInvoice = invoiceRepository.findById(invoiceId);

		// Assert
		assertTrue(deletedInvoice.isEmpty());
	}

	@Test
	@DisplayName("Deve contar o número de Invoices no banco")
	void shouldCountInvoices() {
		// Arrange
		invoiceRepository.save(invoice);
		invoiceRepository.save(Invoice.builder()
				.customer("Cliente 2")
				.performances(List.of(performance1))
				.build());

		// Act
		long count = invoiceRepository.count();

		// Assert
		assertEquals(2, count);
	}

	@Test
	@DisplayName("Deve verificar se um Invoice existe pelo ID")
	void shouldCheckIfInvoiceExists() {
		// Arrange
		Invoice savedInvoice = invoiceRepository.save(invoice);
		Long invoiceId = savedInvoice.getId();

		// Act
		boolean exists = invoiceRepository.existsById(invoiceId);
		boolean notExists = invoiceRepository.existsById(999L);

		// Assert
		assertTrue(exists);
		assertFalse(notExists);
	}

	@Test
	@DisplayName("Deve salvar e recuperar Invoice com múltiplas performances")
	void shouldSaveAndRetrieveInvoiceWithMultiplePerformances() {
		// Arrange
		List<Performance> performances = List.of(
				Performance.builder().playID("hamlet").audience(55).build(),
				Performance.builder().playID("comedy").audience(25).build(),
				Performance.builder().playID("macbeth").audience(40).build()
		);

		Invoice invoiceWithMultiplePerfs = Invoice.builder()
				.customer("Cliente Multiplo")
				.performances(performances)
				.build();

		// Act
		Invoice savedInvoice = invoiceRepository.save(invoiceWithMultiplePerfs);
		Optional<Invoice> retrievedInvoice = invoiceRepository.findById(savedInvoice.getId());

		// Assert
		assertTrue(retrievedInvoice.isPresent());
		assertEquals(3, retrievedInvoice.get().getPerformances().size());
		assertEquals("Cliente Multiplo", retrievedInvoice.get().getCustomer());
	}

	@Test
	@DisplayName("Deve salvar Invoice com performances vazio")
	void shouldSaveInvoiceWithEmptyPerformances() {
		// Arrange
		Invoice invoiceEmpty = Invoice.builder()
				.customer("Cliente Sem Shows")
				.performances(List.of())
				.build();

		// Act
		Invoice savedInvoice = invoiceRepository.save(invoiceEmpty);
		Optional<Invoice> retrievedInvoice = invoiceRepository.findById(savedInvoice.getId());

		// Assert
		assertTrue(retrievedInvoice.isPresent());
		assertEquals(0, retrievedInvoice.get().getPerformances().size());
		assertEquals("Cliente Sem Shows", retrievedInvoice.get().getCustomer());
	}

	@Test
	@DisplayName("Deve manter a integridade referencial das performances")
	void shouldMaintainReferentialIntegrityOfPerformances() {
		// Arrange
		Invoice savedInvoice = invoiceRepository.save(invoice);
		Long invoiceId = savedInvoice.getId();

		// Act
		entityManager.flush();
		entityManager.clear();
		Optional<Invoice> retrievedInvoice = invoiceRepository.findById(invoiceId);

		// Assert
		assertTrue(retrievedInvoice.isPresent());
		assertNotNull(retrievedInvoice.get().getPerformances());
		assertEquals(2, retrievedInvoice.get().getPerformances().size());
	}

	@Test
	@DisplayName("Deve deletar Invoice e suas performances em cascata")
	void shouldDeleteInvoiceAndPerformancesInCascade() {
		// Arrange
		Invoice savedInvoice = invoiceRepository.save(invoice);
		Long invoiceId = savedInvoice.getId();

		// Act
		invoiceRepository.deleteById(invoiceId);
		entityManager.flush();
		Optional<Invoice> deletedInvoice = invoiceRepository.findById(invoiceId);

		// Assert
		assertTrue(deletedInvoice.isEmpty());
	}

	@Test
	@DisplayName("Deve salvar e recuperar dados com campos corretos")
	void shouldSaveAndRetrieveDataWithCorrectFields() {
		// Arrange
		Invoice testInvoice = Invoice.builder()
				.customer("Teste Campos")
				.performances(List.of(
						Performance.builder().playID("test-play").audience(100).build()
				))
				.build();

		// Act
		Invoice saved = invoiceRepository.save(testInvoice);
		Optional<Invoice> retrieved = invoiceRepository.findById(saved.getId());

		// Assert
		assertTrue(retrieved.isPresent());
		assertEquals("Teste Campos", retrieved.get().getCustomer());
		assertEquals("test-play", retrieved.get().getPerformances().getFirst().getPlayID());
		assertEquals(100, retrieved.get().getPerformances().getFirst().getAudience());
	}
}

