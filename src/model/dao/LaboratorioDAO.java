package model.dao;

import model.db.ConexionBD;
import model.entities.Laboratorio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaboratorioDAO {

    public List<Laboratorio> obtenerLaboratorios() {
        List<Laboratorio> laboratorios = new ArrayList<>();
        String sql = "SELECT * FROM vista_listar_laboratorios";

        try (Connection con = ConexionBD.getInstancia().getConexion(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Laboratorio lab = new Laboratorio();
                lab.setId(rs.getInt("id_laboratorio"));
                lab.setNombre(rs.getString("nombre"));
                lab.setCapacidad(rs.getInt("capacidad"));
                lab.setEstado(rs.getString("estado"));

                laboratorios.add(lab);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laboratorios;
    }

    public Laboratorio obtenerLaboratorioPorId(int idLaboratorio) throws SQLException {
        String sql = "SELECT * FROM vista_listar_laboratorios WHERE id_laboratorio = ?";

        try (Connection con = ConexionBD.getInstancia().getConexion(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idLaboratorio);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Laboratorio lab = new Laboratorio();
                lab.setId(rs.getInt("id_laboratorio"));
                lab.setNombre(rs.getString("nombre"));
                lab.setCapacidad(rs.getInt("capacidad"));
                lab.setEstado(rs.getString("estado"));

                return lab;
            }
        }
        return null;
    }
}
