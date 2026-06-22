
package vista;

import grafica.PanelGrafica;
import modelo.PuntoGrafica;
import servicio.EcuacionService;
import util.CalculadoraCubica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class FrmPrincipal extends JFrame {
    private JTextField txtA, txtB, txtC, txtD;
    private JButton btnCalcular;
    private PanelGrafica panelGrafica;

    public FrmPrincipal() {
        setTitle("Ecuación Cúbica");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txtA = new JTextField(5);
        txtB = new JTextField(5);
        txtC = new JTextField(5);
        txtD = new JTextField(5);
        btnCalcular = new JButton("Calcular");
        panelGrafica = new PanelGrafica();

        JPanel panelInputs = new JPanel();
        panelInputs.add(new JLabel("a:")); panelInputs.add(txtA);
        panelInputs.add(new JLabel("b:")); panelInputs.add(txtB);
        panelInputs.add(new JLabel("c:")); panelInputs.add(txtC);
        panelInputs.add(new JLabel("d:")); panelInputs.add(txtD);
        panelInputs.add(btnCalcular);

        add(panelInputs, BorderLayout.NORTH);
        add(panelGrafica, BorderLayout.CENTER);

        btnCalcular.addActionListener((ActionEvent e) -> {
            try {
                double a = Double.parseDouble(txtA.getText());
                double b = Double.parseDouble(txtB.getText());
                double c = Double.parseDouble(txtC.getText());
                double d = Double.parseDouble(txtD.getText());

                EcuacionService service = new EcuacionService();
                service.procesarEcuacion(a, b, c, d);

                List<PuntoGrafica> puntos = CalculadoraCubica.generarPuntos(a, b, c, d, 0);
                panelGrafica.setPuntos(puntos);

                JOptionPane.showMessageDialog(this, "Ecuación calculada y guardada en Oracle");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmPrincipal().setVisible(true));
    }
}
