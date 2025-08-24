package exercs.cap15;

import java.awt.*;

// Exemplo simples de um applet Java que demonstra o uso da API Applet.
// Note que applets são obsoletos e não são mais suportados em muitos navegadores.
public class AppletAPI extends java.applet.Applet {

    @Override
    public void init() {
        // Inicialização do applet
        System.out.println("Applet iniciado!");
    }

    @Override
    public void start() {
        // Código a ser executado quando o applet é iniciado
        System.out.println("Applet em execução!");
    }

    @Override
    public void stop() {
        // Código a ser executado quando o applet é parado
        System.out.println("Applet parado!");
    }

    @Override
    public void destroy() {
        // Código a ser executado quando o applet é destruído
        System.out.println("Applet destruído!");
    }

    public void paint(Graphics g) {
        // Desenhar algo no applet
        g.drawString("Olá, Applet!", 20, 20);
    }
}
