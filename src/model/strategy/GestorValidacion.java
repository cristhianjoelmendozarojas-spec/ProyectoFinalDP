package model.strategy;

import model.entities.Reserva;
import java.util.ArrayList;
import java.util.List;

public class GestorValidacion {

    private List<ValidacionStrategy> validadores;

    public GestorValidacion() {
        this.validadores = new ArrayList<>();
        inicializarValidadores();
    }

    private void inicializarValidadores() {

        validadores.add(new ValidacionDisponibilidad());
        validadores.add(new ValidacionDuracion());

     }

    public boolean validarReserva(Reserva reserva) {
        System.out.println("Ejecutando validaciones esenciales...");

        for (ValidacionStrategy validador : validadores) {
            if (!validador.validar(reserva)) {
                System.out.println("Falló: " + validador.getMensajeError());
                return false;
            }
            System.out.println("Pasó: " + validador.getClass().getSimpleName());
        }
        return true;
    }
    
    public boolean validarReservaModificacion(Reserva reserva, String tipoUsuarioActual) {
    ValidacionTipoUsuario validador = new ValidacionTipoUsuario(tipoUsuarioActual);
    return validador.validar(reserva);
}

}
