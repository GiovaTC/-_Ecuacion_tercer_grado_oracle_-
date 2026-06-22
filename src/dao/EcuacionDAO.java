package dao;

import conexion.ConexionOracle;
import modelo.Ecuacion;
import modelo.PuntoGrafica;

import java.sql.*;
import java.util.List;

public class EcuacionDAO {

    public int guardarEcuacion(Ecuacion ecuacion) throws SQLException {
        String sql = "INSERT INTO ECUACION_CUBICA_O(A,B,C,D,ECUACION,RAICES) VALUES((?,?,?,?,?,?)";
        try (Connection conn = ConexionOracle.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDouble(1, ecuacion.getA());
            ps.setDouble(2, ecuacion.getB());
            ps.setDouble(3, ecuacion.getC());
            ps.setDouble(4, ecuacion.getD());
            ps.setString(5, ecuacion.getEcuacion());
            ps.setString(6, ecuacion.getRaices());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }

    public void guardarPuntos(int idEcuacion, List<PuntoGrafica> puntos) throws SQLException {
        String sql = "INSERT INTO PUNTOS_GRAFICA(ID_ECUACION,X,Y) VALUES (?,?,?)";
        try (Connection conn = ConexionOracle.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (PuntoGrafica p : puntos) {
                ps.setInt(1, idEcuacion);
                ps.setDouble(2, p.getX());
                ps.setDouble(3, p.getY());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }
}   
