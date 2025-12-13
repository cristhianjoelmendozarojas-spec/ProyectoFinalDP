package model.observer;

import controller.UsuarioController;
import model.entities.Reserva;
import model.entities.Usuario;
import javax.swing.JOptionPane;

public class NotificadorEmail implements Observador {

    private UsuarioController usuarioController;

    public NotificadorEmail() {
        this.usuarioController = new UsuarioController();
    }

    @Override
    public void onReservaCreada(Reserva reserva) {

        Usuario usuario = usuarioController.obtenerPorId(reserva.getIdUsuario());

        if (usuario == null) {
            return;
        }

        String mensaje
                = "Reserva Confirmada\n\n"
                + "Estimado " + usuario.getNombre() + ",\n\n"
                + "Su reserva ha sido confirmada:\n"
                + "Laboratorio: " + reserva.getIdLaboratorio() + "\n"
                + "Fecha: " + reserva.getFecha() + "\n"
                + "Hora: " + reserva.getHoraInicio() + " - " + reserva.getHoraFin() + "\n\n"
                + "Gracias por usar ReserLab.";

        System.out.println("EMAIL ENVIADO");
        System.out.println("Para: " + usuario.getEmail());
        System.out.println(mensaje);

        JOptionPane.showMessageDialog(
                null,
                "Notificación enviada por email a: " + usuario.getEmail(),
                "Notificación Email",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
