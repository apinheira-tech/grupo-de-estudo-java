package ge.apinheira;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GerenciadorUsuario {
    private List<Usuario> user = new ArrayList<>();
    private int proximoId = 1;
    // Chapéu de funcionalidade (comportamento): Adicionar novo usuário
    public Object adicionarUsuario(String nome, String email, String tipo) {
        // Nova funcionalidade: Validação por email
        /*if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        */
        // Criar uma classe separada para validação de email seria mais adequado: emailJaExiste.jva
        // Verificar se o email já está cadastrado
        if (emailJaExiste.equals(email)) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        // Nova Funcionalidade:  gerar ID automatico e adcionar usuário à lista
        // Lógica para adicionar o usuário
        Usuario userNew = new Usuario(nome, email, tipo);
        user.add(userNew);
        proximoId++;
        return userNew;

        // Nova funcionalidade: validação de Log => RegistrarLog.java
        registrarLog("USUARIO_ADC: " + nome + ", Email: " + email + ", Tipo: " + tipo);

        for (Usuario u : user) {
            if (u.getEmail() != null && u.getEmail().equals(email)) {
                return Optional.of(u);
            }
        }
        // REFATORAR Usando return user.stream()...
        // REFATORAR e fazer os testes unitários

        return Optional.empty();

    // Método Refatorado (passar para classe futuramente, seguindo as
    // boas práticas de separação de responsabilidades)
    // Extrair lógica complexa e comportamental para tratar se email ja existe
    boolean emailJaExiste(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return user.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(email));

    }
    // registrarLog
        void registrarLog(String evento, Usuario usuario) {

        }
            // Lógica para registrar o log (pode ser em arquivo, banco de dados,
    // Chapéu DE ADIÇÃO: Nova funcionalidade solicitada
    // Refatoração para classes externas - add responsabilidade única

    }
}
