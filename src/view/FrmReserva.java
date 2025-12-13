package view;

import controller.GestorReservas;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.entities.*;
import model.observer.SujetoNotificacion;
import view.FrmDetalleReserva;
import view.FrmMenuPrincipal;

public class FrmReserva extends javax.swing.JFrame {
    
    private Laboratorio laboratorio;
    private Usuario usuario;
    private FrmMenuPrincipal menuPrincipal;
    private SujetoNotificacion sujetoNotificacion;
    private Reserva reservaExistente;
    private List<String> horarios = new ArrayList<>();
    
    public FrmReserva(Usuario usuario, Laboratorio laboratorio, FrmMenuPrincipal menuPrincipal) {
        initComponents();
        this.usuario = usuario;
        this.laboratorio = laboratorio;
        this.menuPrincipal = menuPrincipal;
        this.sujetoNotificacion = new SujetoNotificacion();
        this.reservaExistente = reservaExistente;

        // Mostrar laboratorio
        jLabel5.setText(laboratorio.getNombre());
        jLabel6.setText(String.valueOf(laboratorio.getCapacidad()));
        jLabel7.setText(laboratorio.getEstado());
        jLabel11.setText(String.valueOf(laboratorio.getId()));
        jLabel11.setVisible(false);

        // Configurar horas
        cbHoraInicio.addActionListener(e -> actualizarHorasFin());
        cargarHorasReserva();
        actualizarHorasFin();
        setLocationRelativeTo(null);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbHoraInicio = new javax.swing.JComboBox<>();
        cbHoraFin = new javax.swing.JComboBox<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel10 = new javax.swing.JLabel();
        btnGuardarReserva = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RESERVA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel1.setText("Seleccione Fecha:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel2.setText("Capacidad:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel3.setText("Estado:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel4.setText("Laboratorio:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel8.setText("Hora Inicio:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel9.setText("Hora Fin:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, -1, -1));

        getContentPane().add(cbHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 105, -1));

        getContentPane().add(cbHoraFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 105, -1));
        getContentPane().add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 137, 579, -1));

        jLabel10.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel10.setText("Reserva minima 01 hora - maxima 04 Horas");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        btnGuardarReserva.setBackground(new java.awt.Color(23, 85, 166));
        btnGuardarReserva.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btnGuardarReserva.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarReserva.setText("Guardar Reserva");
        btnGuardarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarReservaActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 120, 30));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 135, -1));

        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        btncancelar.setBackground(new java.awt.Color(23, 85, 166));
        btncancelar.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 400, 120, 30));

        jPanel2.setBackground(new java.awt.Color(23, 85, 166));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarReservaActionPerformed
try {
    if (usuario == null || laboratorio == null) {
        JOptionPane.showMessageDialog(this, "Sesión inválida.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jDateChooser1.getDate() == null) {
        JOptionPane.showMessageDialog(this, "Seleccione una fecha válida.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String idUsuario = usuario.getIdUsuario();
    int idLab = laboratorio.getId();
    LocalDate fecha = jDateChooser1.getDate().toInstant()
            .atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    LocalTime horaInicio = LocalTime.parse(cbHoraInicio.getSelectedItem().toString());
    LocalTime horaFin = LocalTime.parse(cbHoraFin.getSelectedItem().toString());

    GestorReservas gestor = GestorReservas.getInstancia();

    Reserva reservaExistente = gestor.getReservaActiva(idLab, idUsuario, fecha);

    Reserva r;
    boolean exito;

    if (reservaExistente != null) {
        if ("Estudiante".equalsIgnoreCase(usuario.getTipo())) {
            JOptionPane.showMessageDialog(this,
                    "No puede modificar esta reserva.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if ("Docente".equalsIgnoreCase(usuario.getTipo())) {
            r = reservaExistente;
            r.setFecha(fecha);
            r.setHoraInicio(horaInicio);
            r.setHoraFin(horaFin);
            r.setIdUsuario(idUsuario);
            exito = gestor.actualizarReserva(r);
        } else {
            JOptionPane.showMessageDialog(this,
                    "No puede modificar esta reserva.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
    } else {
        r = new Reserva(idUsuario, idLab, fecha, horaInicio, horaFin);
        exito = gestor.realizarReserva(r);
    }

    if (exito) {
        FrmDetalleReserva detalle = new FrmDetalleReserva(r, menuPrincipal);
        detalle.setVisible(true);
        dispose();
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo procesar la reserva\n Horas se cruzan con otra reserva.", "Error", JOptionPane.ERROR_MESSAGE);
    }

} catch (Exception ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "Ocurrió un error al procesar la reserva", "Error", JOptionPane.ERROR_MESSAGE);


}

    }
    private void cargarHorasReserva() {
        cbHoraInicio.removeAllItems();
        horarios.clear();
        int inicio = 7 * 60 + 30;
        int fin = 23 * 60 + 30;
        for (int t = inicio; t <= fin; t += 30) {
            int h = t / 60;
            int m = t % 60;
            String tiempo = String.format("%02d:%02d", h, m);
            horarios.add(tiempo);
            cbHoraInicio.addItem(tiempo);
        }
    }
    
    private void actualizarHorasFin() {
        cbHoraFin.removeAllItems();
        int posInicio = cbHoraInicio.getSelectedIndex();
        
        if (posInicio == -1) {
            return;
        }
        
        int minPos = posInicio + 2;
        int maxPos = posInicio + 8;
        maxPos = Math.min(maxPos, horarios.size() - 1);
        for (int i = minPos; i <= maxPos; i++) {
            cbHoraFin.addItem(horarios.get(i));
        }

    }//GEN-LAST:event_btnGuardarReservaActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btncancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarReserva;
    private javax.swing.JButton btncancelar;
    private javax.swing.JComboBox<String> cbHoraFin;
    private javax.swing.JComboBox<String> cbHoraInicio;
    private javax.swing.Box.Filler filler1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
