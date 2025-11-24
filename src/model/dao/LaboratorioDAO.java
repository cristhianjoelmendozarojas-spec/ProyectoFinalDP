package model.dao;

import model.db.ConexionBD;
import model.entities.Laboratorio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaboratorioDAO {

    public List<Laboratorio> listarTodos() {
        List<Laboratorio> lista = new ArrayList<>();
        String sql = "Select * from vista_listar_laboratorios";
        try (Connection con = ConexionBD.getInstancia().getConexion();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Laboratorio(
                    rs.getInt("id_laboratorio"),
                    rs.getString("nombre"),
                    rs.getInt("capacidad"),
                    rs.getString("estado")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
