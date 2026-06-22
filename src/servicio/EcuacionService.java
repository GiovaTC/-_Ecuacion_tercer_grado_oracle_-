package servicio;

import dao.EcuacionDAO;
import modelo.Ecuacion;
import modelo.PuntoGrafica;
import util.CalculadoraCubica;

import java.sql.SQLException;
import java.util.List;

public class EcuacionService {
    private final EcuacionDAO dao = new EcuacionDAO();

    public void procesarEcuacion(double a, double b, double c, double d) throws SQLException {
        Ecuacion ecuacion = CalculadoraCubica.calcularEcuacion(a, b, c, d);
        int id = dao.guardarEcuacion(ecuacion);

        List<PuntoGrafica> puntos = CalculadoraCubica.generarPuntos(a,b,c,d,id);
        dao.guardarPuntos(id, puntos);
    }
}
