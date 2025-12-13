package model.strategy;

import model.entities.Reserva;
import java.time.Duration;

public class ValidacionDuracion implements ValidacionStrategy {

    @Override
    public boolean validar(Reserva reserva) {
        Duration duracion = Duration.between(reserva.getHoraInicio(), reserva.getHoraFin());
        long minutos = duracion.toMinutes();

      return minutos >= 30 && minutos <= 240;
    }

    @Override
    public String getMensajeError() {
        return "La duración debe ser entre 30 minutos y 4 horas";
    }
}
