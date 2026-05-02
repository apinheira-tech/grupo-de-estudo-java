package ms.refatoracao.ge.ingressos.controllers;

import ms.refatoracao.ge.ingressos.model.entities.dtos.StatementRequestDTO;
import ms.refatoracao.ge.ingressos.services.StatementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/statement")
public class StatementeController {

    private final StatementService statementService;

    public StatementeController(StatementService statementService) {
        this.statementService = statementService;
    }

    @PostMapping
    public ResponseEntity<String> getStatement(@Valid @RequestBody StatementRequestDTO request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(statementService.createStatement(request.getInvoice(), request.getPlays()));
    }
}
