package ms.refatoracao.ge.ingressos.controllers;

import ms.refatoracao.ge.ingressos.model.entities.dto.InvoiceDTO;
import ms.refatoracao.ge.ingressos.model.entities.dto.PerformanceDTO;
import ms.refatoracao.ge.ingressos.model.entities.dto.PlayDTO;
import ms.refatoracao.ge.ingressos.model.entities.dto.StatementRequestDTO;
import ms.refatoracao.ge.ingressos.services.StatementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;

@WebMvcTest(StatementController.class)
@DisplayName("Testes de Integração do Controller de Extrato")
class StatementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatementService statementService;

    @Autowired
    private ObjectMapper objectMapper;

    private StatementRequestDTO requestDTO;

    @BeforeEach
    void setUp() {
        PlayDTO play = PlayDTO.builder()
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

        requestDTO = new StatementRequestDTO();
        requestDTO.setInvoice(invoice);
        requestDTO.setPlays(Map.of("hamlet", play));
    }

    @Test
    @DisplayName("Deve retornar 200 OK ao gerar extrato válido")
    void shouldReturn200OnValidRequest() throws Exception {
        // Arrange
        String mockStatement = "Serviço de Extrato para João Silva\n Hamlet: $650.00 (55 seats)\nO valor devido é: $650.00\nVocê ganhou 25 creditos\n";

        // Mock do serviço
        org.mockito.Mockito.when(statementService.createStatement(
                org.mockito.ArgumentMatchers.any(InvoiceDTO.class),
                org.mockito.ArgumentMatchers.anyMap()
        )).thenReturn(mockStatement);

        // Act & Assert
        mockMvc.perform(post("/api/statement")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("João Silva")))
                .andExpect(content().string(containsString("Hamlet")))
                .andExpect(content().string(containsString("creditos")));
    }

    @Test
    @DisplayName("Deve retornar 400 para requisição com body vazio")
    void shouldReturn400ForEmptyBody() throws Exception {
        // Act & Assert
        mockMvc.perform(post("/api/statement")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Deve processar requisição com múltiplas apresentações")
    void shouldProcessRequestWithMultiplePerformances() throws Exception {
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

        StatementRequestDTO multiRequest = new StatementRequestDTO();
        multiRequest.setInvoice(invoice);
        multiRequest.setPlays(Map.of(
                "hamlet", tragedy,
                "comedy", comedy
        ));

        String mockStatement = "Serviço de Extrato para Cliente Multiplo\n Hamlet: $650.00 (55 seats)\n Comedy Play: $500.00 (25 seats)\nO valor devido é: $1,150.00\nVocê ganhou 30 creditos\n";

        org.mockito.Mockito.when(statementService.createStatement(
                org.mockito.ArgumentMatchers.any(InvoiceDTO.class),
                org.mockito.ArgumentMatchers.anyMap()
        )).thenReturn(mockStatement);

        // Act & Assert
        mockMvc.perform(post("/api/statement")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(multiRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Cliente Multiplo")))
                .andExpect(content().string(containsString("Hamlet")))
                .andExpect(content().string(containsString("Comedy Play")));
    }

    @Test
    @DisplayName("Deve retornar 415 para content-type inválido")
    void shouldReturn415ForInvalidContentType() throws Exception {
        // Act & Assert
        mockMvc.perform(post("/api/statement")
                .contentType(MediaType.TEXT_PLAIN)
                .content("invalid"))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    @DisplayName("Deve processar requisição com invoice null")
    void shouldHandleNullInvoice() throws Exception {
        // Arrange
        StatementRequestDTO invalidRequest = new StatementRequestDTO();
        invalidRequest.setInvoice(null);
        invalidRequest.setPlays(Map.of());

        // Act & Assert
        mockMvc.perform(post("/api/statement")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest());
    }
}

