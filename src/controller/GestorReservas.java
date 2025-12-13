package controller;

import java.time.LocalDate;
import model.dao.ReservaDAO;
import model.entities.Reserva;
import model.strategy.GestorValidacion;
import model.observer.*;

public class GestorReservas {

    private static GestorReservas instancia;
    private final ReservaDAO reservaDAO;
    private final GestorValidacion gestorValidacion;
    private final SujetoNotificacion sujetoNotificacion;

    // Singleton
    private GestorReservas() {
        reservaDAO = new ReservaDAO();
        gestorValidacion = new GestorValidacion();
        sujetoNotificacion = new SujetoNotificacion();
        configurarNotificadores();
    }

    public static GestorReservas getInstancia() {
        if (instancia == null) {
            instancia = new GestorReservas();
        }
        return instancia;
    }

    // Observer
    private void configurarNotificadores() {
        sujetoNotificacion.agregarObservador(new NotificadorEmail());
        sujetoNotificacion.agregarObservador(new NotificadorWhatsapp());
    }

    // Strategy
    public boolean realizarReserva(Reserva reserva) {
        return gestorValidacion.validarReserva(reserva);
    }

    // Persistencia + Observer
    public boolean confirmarReserva(
            Reserva reserva,
            boolean notificarEmail,
            boolean notificarWhatsapp
    ) {

        boolean exito = reservaDAO.realizarReserva(reserva);

        if (exito && (notificarEmail || notificarWhatsapp)) {
            sujetoNotificacion.notificarReservaCreada(
                    reserva,
                    notificarEmail,
                    notificarWhatsapp
            );
        }

        return exito;
    }

    // Acceso al sujeto
    public SujetoNotificacion getSujetoNotificacion() {
        return sujetoNotificacion;
    }

    public boolean actualizarReserva(Reserva r) {
        return new ReservaDAO().actualizarReserva(r);
    }

    public Reserva getReservaActiva(int idLaboratorio, String idUsuario, LocalDate fecha) {
        return reservaDAO.obtenerReservaActiva(idLaboratorio, idUsuario, fecha);
    }

}
