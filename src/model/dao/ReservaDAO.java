package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.db.ConexionBD;
import model.entities.Reserva;

public class ReservaDAO {

    public boolean realizarReserva(Reserva r) {
        String sql = "INSERT INTO reservas(id_usuario, id_laboratorio, fecha, hora_inicio, hora_fin, estado) "
                + "VALUES(?,?,?,?,?,'Confirmada')";

        try (Connection con = ConexionBD.getInstancia().getConexion(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, r.getIdUsuario());
            pst.setInt(2, r.getIdLaboratorio());
            pst.setDate(3, java.sql.Date.valueOf(r.getFecha()));
            pst.setTime(4, java.sql.Time.valueOf(r.getHoraInicio()));
            pst.setTime(5, java.sql.Time.valueOf(r.getHoraFin()));

            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
