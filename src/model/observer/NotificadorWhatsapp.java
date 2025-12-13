package model.observer;

import controller.UsuarioController;
import model.entities.Reserva;
import model.entities.Usuario;
import javax.swing.JOptionPane;

public class NotificadorWhatsapp implements Observador {

    private UsuarioController usuarioController;

    public NotificadorWhatsapp() {
        this.usuarioController = new UsuarioController();
    }

    @Override
    public void onReservaCreada(Reserva reserva) {

        Usuario usuario = usuarioController.obtenerPorId(reserva.getIdUsuario());

        if (usuario != null) {
            String mensaje = String.format(
                "Reserva Confirmada - ReserLab\n\n" +
                "Hola %s\n\n" +
                "Tu reserva fue confirmada:\n" +
                "Laboratorio: %d\n" +
                "Fecha: %s\n" +
                "Hora: %s - %s\n\n" +
                "Gracias por usar el sistema",
                usuario.getNombre(),
                reserva.getIdLaboratorio(),
                reserva.getFecha(),
                reserva.getHoraInicio(),
                reserva.getHoraFin()
            );

            System.out.println("WHATSAPP ENVIADO");
            System.out.println("Para: " + usuario.getNombre());
            System.out.println("Mensaje: " + mensaje);

            JOptionPane.showMessageDialog(
                null,
                "Notificación enviada por WhatsApp",
                "Notificación WhatsApp",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
