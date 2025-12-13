package model.strategy;

import model.entities.Reserva;

public interface ValidacionStrategy {

    boolean validar(Reserva reserva);

    String getMensajeError();
}
