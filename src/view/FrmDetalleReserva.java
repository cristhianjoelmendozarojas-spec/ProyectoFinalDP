package view;

import controller.GestorReservas;
import controller.LaboratorioController;
import model.entities.Reserva;
import model.observer.SujetoNotificacion;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;

public class FrmDetalleReserva extends javax.swing.JFrame {

    private final Reserva reserva;
    private final FrmMenuPrincipal menuPrincipal;

    private JTextArea txtDetalles;
    private JCheckBox chkEmail;
    private JCheckBox chkWhatsapp;
    
    public FrmDetalleReserva(
            Reserva reserva,
            FrmMenuPrincipal menuPrincipal
    ) {
        this.reserva = reserva;
        this.menuPrincipal = menuPrincipal;

        initComponents();
        setLocationRelativeTo(null);
        mostrarDetalles();
    }

    private void initComponents() {

         setTitle("Confirmar Reserva - ReserLab");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        JLabel lblTitulo = new JLabel("Reserva Validada Correctamente");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        txtDetalles = new JTextArea();
        txtDetalles.setEditable(false);
        txtDetalles.setLineWrap(true);
        txtDetalles.setWrapStyleWord(true);

        chkEmail = new JCheckBox("Recibir notificación por Email", true);
        chkWhatsapp = new JCheckBox("Recibir notificación por WhatsApp", true);

        JButton btnConfirmar = new JButton("Confirmar Reserva");
        JButton btnCancelar = new JButton("Cancelar");

        btnConfirmar.addActionListener(e -> confirmarReserva());
        btnCancelar.addActionListener(e -> dispose());

        JPanel panelSuperior = new JPanel();
        panelSuperior.add(lblTitulo);

        JScrollPane scroll = new JScrollPane(txtDetalles);
        scroll.setPreferredSize(new Dimension(400, 250));

        JPanel panelNotificaciones = new JPanel(new GridLayout(2, 1));
        panelNotificaciones.setBorder(BorderFactory.createTitledBorder("Métodos de Notificación"));
        panelNotificaciones.add(chkEmail);
        panelNotificaciones.add(chkWhatsapp);

        JPanel panelCentral = new JPanel(new BorderLayout(10, 10));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCentral.add(scroll, BorderLayout.CENTER);
        panelCentral.add(panelNotificaciones, BorderLayout.SOUTH);

        JPanel panelInferior = new JPanel();
        panelInferior.add(btnConfirmar);
        panelInferior.add(btnCancelar);

        setLayout(new BorderLayout(10, 10));
        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        pack();
    }

    private void mostrarDetalles() {
        String texto =
                "DETALLES DE LA RESERVA\n\n" +
                "Laboratorio: " + reserva.getIdLaboratorio() + "\n" +
                "Fecha: " + reserva.getFecha() + "\n" +
                "Hora inicio: " + reserva.getHoraInicio() + "\n" +
                "Hora fin: " + reserva.getHoraFin() + "\n" +
                "Duración: " + calcularDuracion() + "\n" +
                "Usuario: " + reserva.getIdUsuario();

        txtDetalles.setText(texto);
    }

    private String calcularDuracion() {
        Duration d = Duration.between(reserva.getHoraInicio(), reserva.getHoraFin());
        return d.toHours() + " h " + (d.toMinutes() % 60) + " min";
    }

    private void confirmarReserva() {
        GestorReservas gestor = GestorReservas.getInstancia();

        boolean exito = gestor.confirmarReserva(reserva, chkEmail.isSelected(), chkWhatsapp.isSelected());

        if (exito) {
            JOptionPane.showMessageDialog(this, "Reserva confirmada y notificaciones enviadas.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            if (menuPrincipal != null) {
                menuPrincipal.cargarLaboratorios();
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al confirmar la reserva.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /* @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
*/
    

       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
   
}
