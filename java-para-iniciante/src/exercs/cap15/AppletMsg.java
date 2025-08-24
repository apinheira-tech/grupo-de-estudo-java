package exercs.cap15;

import java.applet.Applet;
import java.awt.*;

public class AppletMsg extends Applet {
    public void paint(Graphics g) {
        g.drawString("Olá, este é um Applet simples!", 20, 20);
    }

   /* <applet>
        <param name="message" value="Bem-vindo ao Applet!">
        <param name="width" value="300">
        <param name="height" value="200">
        <param name="bgcolor" value="lightblue">
    </applet>*/
}
