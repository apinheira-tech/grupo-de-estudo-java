package ms.refatoracao.ge.ingressos.repositories;
// src/main/java/ms/refagoracao/ge/ingressos/repository/InvoiceRepository.java

import ms.refagoracao.ge.ingressos.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}