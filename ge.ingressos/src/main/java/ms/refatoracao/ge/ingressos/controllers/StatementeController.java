package ms.refatoracao.ge.ingressos.controllers;

// src/main/java/ms/refagoracao/ge/ingressos/controllers/StatementController.java

import ms.refatoracao.ge.ingressos.model.entities.dto.InvoiceDTO;
import ms.refatoracao.ge.ingressos.model.entities.dto.PlayDTO;
import ms.refatoracao.ge.ingressos.model.entities.dto.StatementRequestDTO;
import ms.refatoracao.ge.ingressos.services.StatementService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/statement")
class StatementController {

    private final StatementService statementService;

    public StatementController(StatementService statementService) {
        this.statementService = statementService;
    }

    @PostMapping
    public String getStatement(@RequestBody StatementRequestDTO request) {;
        return statementService.createStatement(request.getInvoice(), request.getPlays());    }
}