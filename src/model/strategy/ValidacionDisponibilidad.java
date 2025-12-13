package model.strategy;

import model.dao.ReservaDAO;
import model.entities.Reserva;
import java.sql.SQLException;
import java.util.List;

public class ValidacionDisponibilidad implements ValidacionStrategy {

    private ReservaDAO reservaDAO;

    public ValidacionDisponibilidad() {
        this.reservaDAO = new ReservaDAO();
    }

    @Override
    public boolean validar(Reserva reserva) {
        try {
            System.out.println("Validando disponibilidad para lab: " + reserva.getIdLaboratorio());

            List<Reserva> reservasExistentes = reservaDAO.obtenerReservasPorLaboratorioYFecha(
                    reserva.getIdLaboratorio(), reserva.getFecha());

            System.out.println("Comparando con " + reservasExistentes.size() + " reservas existentes");

            for (Reserva existente : reservasExistentes) {
                if (haySuperposicion(existente, reserva)) {
                    System.out.println("Superposición encontrada con reserva ID: " + existente.getIdReserva());
                    return false;
                }
            }

            System.out.println("Laboratorio disponible en el horario seleccionado");
            return true;

        } catch (SQLException e) {
            System.err.println("Error de BD en validación de disponibilidad: " + e.getMessage());
            // En caso de error de BD, asumimos que NO está disponible por seguridad
            return false;
        } catch (Exception e) {
            System.err.println("Error inesperado en validación de disponibilidad: " + e.getMessage());
            return false;
        }
    }

    private boolean haySuperposicion(Reserva existente, Reserva nueva) {
        boolean superpone = !(nueva.getHoraFin().compareTo(existente.getHoraInicio()) <= 0
                || nueva.getHoraInicio().compareTo(existente.getHoraFin()) >= 0);

        if (superpone) {
            System.out.println("Superposición: Nueva " + nueva.getHoraInicio() + "-" + nueva.getHoraFin()
                    + " vs Existente " + existente.getHoraInicio() + "-" + existente.getHoraFin());
        }

        return superpone;
    }

    @Override
    public String getMensajeError() {
        return "El laboratorio no está disponible en el horario seleccionado";
    }
}
