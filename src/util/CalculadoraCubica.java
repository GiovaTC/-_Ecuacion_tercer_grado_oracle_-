
package util;

import modelo.Ecuacion;
import modelo.PuntoGrafica;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraCubica {

    public static Ecuacion calcularEcuacion(double a, double b, double c, double d) {
        Ecuacion e = new Ecuacion();
        e.setA(a); e.setB(b); e.setC(c); e.setD(d);
        e.setEcuacion(String.format("f(x)=%.2fx³+%.2fx²+%.2fx+%.2f", a, b, c, d));
        e.setRaices("Raíces calculadas aquí"); // Simplificado
        return e;
    }

    public static List<PuntoGrafica> generarPuntos(double a, double b, double c, double d, int idEcuacion) {
        List<PuntoGrafica> puntos = new ArrayList<>();
        for (double x = -10; x <= 10; x += 0.05) {
            double y = a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d;
            PuntoGrafica p = new PuntoGrafica();
            p.setIdEcuacion(idEcuacion);
            p.setX(x);
            p.setY(y);
            puntos.add(p);
        }
        return puntos;
    }
}
