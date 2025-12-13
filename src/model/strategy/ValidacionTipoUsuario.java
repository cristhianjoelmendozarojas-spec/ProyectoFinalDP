
package model.strategy;

import model.dao.UsuarioDAO;
import model.entities.Reserva;

public class ValidacionTipoUsuario implements ValidacionStrategy {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private String mensaje;
    private String tipoUsuarioActual; // Tipo del usuario que intenta modificar

    public ValidacionTipoUsuario(String tipoUsuarioActual) {
        this.tipoUsuarioActual = tipoUsuarioActual;
    }

    @Override
    public boolean validar(Reserva reserva) {
        // Solo Docente puede modificar reservas
        if (!"DOCENTE".equalsIgnoreCase(tipoUsuarioActual)) {
            mensaje = "Solo usuarios tipo Docente pueden modificar reservas";
            return false;
        }

        // verificar que la reserva original sea de un estudiante
        String tipoReserva = usuarioDAO.obtenerTipoUsuario(reserva.getIdUsuario());
        if (!"ESTUDIANTE".equalsIgnoreCase(tipoReserva)) {
            mensaje = "No se pueden modificar reservas de este usuario";
            return false;
        }

        return true;
    }

    @Override
    public String getMensajeError() {
        return mensaje;
    }
}

