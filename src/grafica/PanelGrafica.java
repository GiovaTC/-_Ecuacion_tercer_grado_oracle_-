
package grafica;

import modelo.PuntoGrafica;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelGrafica extends JPanel {
    private List<PuntoGrafica> puntos;

    public void setPuntos(List<PuntoGrafica> puntos) {
        this.puntos = puntos;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (puntos == null || puntos.isEmpty()) return;

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);

        int width = getWidth();
        int height = getHeight();

        // Dibujar ejes
        g2.drawLine(0, height / 2, width, height / 2); // eje X
        g2.drawLine(width / 2, 0, width / 2, height); // eje Y

        // Escala
        double escalaX = width / 20.0;   // -10 a 10
        double escalaY = height / 20.0;  // -10 a 10

        // Dibujar curva
        g2.setColor(Color.BLUE);
        for (int i = 1; i < puntos.size(); i++) {
            int x1 = (int) (width / 2 + puntos.get(i - 1).getX() * escalaX);
            int y1 = (int) (height / 2 - puntos.get(i - 1).getY() * escalaY);
            int x2 = (int) (width / 2 + puntos.get(i).getX() * escalaX);
            int y2 = (int) (height / 2 - puntos.get(i).getY() * escalaY);
            g2.drawLine(x1, y1, x2, y2);
        }
    }
}
