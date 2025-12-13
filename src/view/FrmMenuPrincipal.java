package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import model.entities.Usuario;

public class FrmMenuPrincipal extends javax.swing.JFrame {
    
    private controller.LaboratorioController controller =
            new controller.LaboratorioController();

    private Usuario usuario;

    public FrmMenuPrincipal() {
       initComponents();
        configurarVista();
        ocultarDatosUsuario();
        cargarLaboratorios();

    }

   public FrmMenuPrincipal(Usuario usuario) {
        this();
        this.usuario = usuario;
        mostrarDatosUsuario();
    }
   
   private void configurarVista() {
        PanelGrid.setLayout(new GridLayout(0, 5, 10, 10));
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void ocultarDatosUsuario() {
        labnombres.setVisible(false);
        labtipo.setVisible(false);
        btnperfil.setVisible(false);
    }

    private void mostrarDatosUsuario() {
        labnombres.setVisible(true);
        labtipo.setVisible(true);
        btnperfil.setVisible(true);

        labnombres.setText(usuario.getNombre());
        labtipo.setText(usuario.getTipo());
    }

    /*METODO PARA MOSTRAR LABORATORIOS*/
  public void cargarLaboratorios() {
final FrmMenuPrincipal menuPrincipal = this;

    PanelGrid.removeAll();

    java.util.List<model.entities.Laboratorio> lista = controller.obtenerLaboratorios();
   

    for (model.entities.Laboratorio lab : lista) {

        javax.swing.JPanel tarjeta = new javax.swing.JPanel();
        tarjeta.setLayout(new java.awt.BorderLayout());
        tarjeta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tarjeta.setOpaque(true);
        tarjeta.setBackground(Color.WHITE);

        javax.swing.JLabel lblIcono = new javax.swing.JLabel();

        try {
            javax.swing.ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("/img/lab.png"));
            java.awt.Image img = icono.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
            lblIcono.setIcon(new javax.swing.ImageIcon(img));
            lblIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        } catch (Exception e) {
            System.out.println("⚠️ No se pudo cargar el icono, usando emoji: " + e.getMessage());
            lblIcono.setText("💻");
            lblIcono.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
            lblIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        }

        javax.swing.JLabel lblNombre = new javax.swing.JLabel(
            "<html><center><b>" + lab.getNombre() + "</b></center></html>"
        );
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.JLabel lblCap = new javax.swing.JLabel(
            "Capacidad: " + lab.getCapacidad()
        );
        lblCap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.JLabel lblestado = new javax.swing.JLabel(
            lab.getEstado() + " "
        );
        lblestado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        if ("Ocupado".equalsIgnoreCase(lab.getEstado())) {
            tarjeta.setBackground(new java.awt.Color(255, 204, 203));
            lblNombre.setForeground(Color.GRAY);
            lblCap.setForeground(Color.GRAY);
            lblestado.setForeground(Color.gray);
        }

        javax.swing.JPanel panelTexto = new javax.swing.JPanel();
        panelTexto.setLayout(new java.awt.GridLayout(4, 1));
        panelTexto.add(lblNombre);
        panelTexto.add(lblCap);
        panelTexto.add(lblestado);
        panelTexto.setOpaque(false);

        tarjeta.add(lblIcono, java.awt.BorderLayout.NORTH);
        tarjeta.add(panelTexto, java.awt.BorderLayout.CENTER);

        tarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {

        boolean esDocente = usuario != null && "Docente".equalsIgnoreCase(usuario.getTipo());

        // Permitimos reservar solo si está disponible o si el usuario es docente
        if ("Disponible".equalsIgnoreCase(lab.getEstado()) || esDocente) {
            Object[] opciones = {"Reservar", "Cancelar"};

            int opcion = javax.swing.JOptionPane.showOptionDialog(
                    null,
                    "¿Desea reservar/modificar el laboratorio " + lab.getNombre() + "?",
                    "Reservar",
                    javax.swing.JOptionPane.YES_NO_OPTION,
                    javax.swing.JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            if (opcion == 0) {
                if (usuario == null) {
                    FrmLogin ventana02 = new FrmLogin(lab, menuPrincipal);
                    ventana02.setVisible(true);
                    ventana02.setLocationRelativeTo(null);

                } else {
                    FrmReserva ventana03 = new FrmReserva(usuario, lab, menuPrincipal);
                    ventana03.setVisible(true);
                    ventana03.setLocationRelativeTo(null);
                }
            }
        }
    }
});

        PanelGrid.add(tarjeta);
    }

    PanelGrid.revalidate();
    PanelGrid.repaint();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
  public static void main(String[] args) {

    try {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception e) {
        // Se ignora si no se puede aplicar el LookAndFeel
    }

    java.awt.EventQueue.invokeLater(() -> {
        new FrmMenuPrincipal().setVisible(true);
    });
}

 


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelGrid = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnperfil = new javax.swing.JButton();
        labtipo = new javax.swing.JLabel();
        labnombres = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        PanelGrid.setName(""); // NOI18N

        javax.swing.GroupLayout PanelGridLayout = new javax.swing.GroupLayout(PanelGrid);
        PanelGrid.setLayout(PanelGridLayout);
        PanelGridLayout.setHorizontalGroup(
            PanelGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelGridLayout.setVerticalGroup(
            PanelGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(23, 85, 166));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(23, 85, 166));
        jPanel1.setBorder(null);

        btnperfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perfil.png"))); // NOI18N

        labtipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labtipo.setForeground(new java.awt.Color(255, 255, 255));
        labtipo.setText("Tipo");

        labnombres.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labnombres.setForeground(new java.awt.Color(255, 255, 255));
        labnombres.setText("Nombres");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/semestre (1).png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnperfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labtipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labnombres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labnombres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labtipo)
                        .addGap(14, 14, 14)))
                .addGap(207, 207, 207)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Reserva de Laboratorios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 519, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(PanelGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelGrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelGrid;
    private javax.swing.JButton btnperfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labnombres;
    private javax.swing.JLabel labtipo;
    // End of variables declaration//GEN-END:variables
}

