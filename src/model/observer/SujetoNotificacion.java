package model.observer;

import model.entities.Reserva;
import java.util.ArrayList;
import java.util.List;

public class SujetoNotificacion {

    private List<Observador> observadores;

    public SujetoNotificacion() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarReservaCreada(Reserva reserva, boolean email, boolean whatsapp) {
        System.out.println("📢 Notificando observadores...");
        for (Observador observador : observadores) {
            if (email && observador instanceof NotificadorEmail) {
                observador.onReservaCreada(reserva);
            }
            if (whatsapp && observador instanceof NotificadorWhatsapp) {
                observador.onReservaCreada(reserva);
            }
        }
    }
}
