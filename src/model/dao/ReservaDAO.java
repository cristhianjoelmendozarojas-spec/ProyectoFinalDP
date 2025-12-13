package model.dao;

import model.db.ConexionBD;
import model.entities.Reserva;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public boolean realizarReserva(Reserva r) {
        String sql = "INSERT INTO reservas(id_usuario, id_laboratorio, fecha, hora_inicio, hora_fin, estado) "
                + "VALUES(?,?,?,?,?,'Confirmada')";

        // Obtener conexión actual
        try (Connection con = ConexionBD.getInstancia().getConexion(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, r.getIdUsuario());
            pst.setInt(2, r.getIdLaboratorio());
            pst.setDate(3, java.sql.Date.valueOf(r.getFecha()));
            pst.setTime(4, java.sql.Time.valueOf(r.getHoraInicio()));
            pst.setTime(5, java.sql.Time.valueOf(r.getHoraFin()));

            int filasAfectadas = pst.executeUpdate();
            System.out.println("Reserva insertada. Filas afectadas: " + filasAfectadas);
            return filasAfectadas > 0;

        } catch (Exception e) {
            System.err.println("Error en realizarReserva: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarReserva(Reserva r) {
        String sql = "UPDATE reservas SET fecha=?, hora_inicio=?, hora_fin=? WHERE id_reserva=?";
        try (Connection con = ConexionBD.getInstancia().getConexion(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setDate(1, java.sql.Date.valueOf(r.getFecha()));
            pst.setTime(2, java.sql.Time.valueOf(r.getHoraInicio()));
            pst.setTime(3, java.sql.Time.valueOf(r.getHoraFin()));
            pst.setInt(4, r.getIdReserva());

            int filas = pst.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Reserva> obtenerReservasPorLaboratorioYFecha(int idLaboratorio, LocalDate fecha) throws SQLException {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservas WHERE id_laboratorio = ? AND fecha = ? AND estado = 'Confirmada'";

        // Obtener conexión actual
        try (Connection con = ConexionBD.getInstancia().getConexion(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idLaboratorio);
            pst.setDate(2, java.sql.Date.valueOf(fecha));

            System.out.println("Buscando reservas para lab " + idLaboratorio + " en fecha " + fecha);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("id_reserva"));
                reserva.setIdUsuario(rs.getString("id_usuario"));
                reserva.setIdLaboratorio(rs.getInt("id_laboratorio"));
                reserva.setFecha(rs.getDate("fecha").toLocalDate());
                reserva.setHoraInicio(rs.getTime("hora_inicio").toLocalTime());
                reserva.setHoraFin(rs.getTime("hora_fin").toLocalTime());
                reserva.setEstado(rs.getString("estado"));
                reservas.add(reserva);
            }

            System.out.println("Reservas encontradas: " + reservas.size());

        } catch (SQLException e) {
            System.err.println("Error en obtenerReservasPorLaboratorioYFecha: " + e.getMessage());
            throw e;
        }
        return reservas;
    }

    public Reserva obtenerReservaActiva(int idLaboratorio, String idUsuario, LocalDate fecha) {
        String sql = "SELECT * FROM reservas WHERE id_laboratorio = ? AND id_usuario = ? AND fecha = ? AND estado = 'Confirmada'";

        try (Connection con = ConexionBD.getInstancia().getConexion(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idLaboratorio);
            pst.setString(2, idUsuario);
            pst.setDate(3, java.sql.Date.valueOf(fecha));

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Reserva r = new Reserva();
                r.setIdReserva(rs.getInt("id_reserva"));
                r.setIdUsuario(rs.getString("id_usuario"));
                r.setIdLaboratorio(rs.getInt("id_laboratorio"));
                r.setFecha(rs.getDate("fecha").toLocalDate());
                r.setHoraInicio(rs.getTime("hora_inicio").toLocalTime());
                r.setHoraFin(rs.getTime("hora_fin").toLocalTime());
                r.setEstado(rs.getString("estado"));
                return r;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
