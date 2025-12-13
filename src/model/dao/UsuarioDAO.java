package model.dao;

import java.sql.*;
import model.db.ConexionBD;
import model.entities.Usuario;

public class UsuarioDAO {

    public Usuario login(String idUsuario, String clave) {

        Usuario usuario = null;

        String sql = """
            SELECT id_usuario, nombre, email, tipo
            FROM usuarios
            WHERE id_usuario = ? AND clave = ?
        """;

        try (
                Connection cn = ConexionBD.getInstancia().getConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, idUsuario);
            ps.setString(2, clave);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                        rs.getString("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("tipo")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return usuario;
    }

    public Usuario obtenerUsuarioPorId(String idUsuario) {

        Usuario usuario = null;

        String sql = """
        SELECT id_usuario, nombre, email, tipo
        FROM usuarios
        WHERE id_usuario = ?
    """;

        try (
                Connection cn = ConexionBD.getInstancia().getConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                        rs.getString("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("tipo")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return usuario;
    }
    
    public String obtenerTipoUsuario(String idUsuario) {
    String tipo = null;
    String sql = "SELECT tipo FROM usuarios WHERE id_usuario = ?";

    try (Connection cn = ConexionBD.getInstancia().getConexion();
         PreparedStatement ps = cn.prepareStatement(sql)) {

        ps.setString(1, idUsuario);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            tipo = rs.getString("tipo");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return tipo;
}


}
