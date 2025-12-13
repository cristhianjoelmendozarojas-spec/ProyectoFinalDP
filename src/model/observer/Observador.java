package model.observer;

import model.entities.Reserva;

public interface Observador {

    void onReservaCreada(Reserva reserva);
}
