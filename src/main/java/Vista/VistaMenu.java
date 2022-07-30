package Vista;

public class VistaMenu extends javax.swing.JFrame {

    vistaGestorCandidato vistaCandidato;
    vistaControlVotante vistaVotante;
    vistaElecciones vistaElecciones;

    public VistaMenu() {
        initComponents();
        this.vistaCandidato = new vistaGestorCandidato(this);
        this.vistaVotante = new vistaControlVotante(this);
        this.vistaElecciones = new vistaElecciones(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        botonGestorCandidato = new javax.swing.JButton();
        botonRegistrarVotante = new javax.swing.JButton();
        botonVotar = new javax.swing.JButton();
        botonGestorEleccion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));

        labelTitulo.setBackground(new java.awt.Color(153, 204, 255));
        labelTitulo.setFont(new java.awt.Font("Swis721 Ex BT", 1, 14)); // NOI18N
        labelTitulo.setText("SISTEMA DE VOTACIONES DE COLOMBIA");
        labelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        botonGestorCandidato.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonGestorCandidato.setText("CONTROL CANDIDATO");
        botonGestorCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestorCandidatoActionPerformed(evt);
            }
        });

        botonRegistrarVotante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonRegistrarVotante.setText("REGISTRAR VOTANTE");
        botonRegistrarVotante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarVotanteActionPerformed(evt);
            }
        });

        botonVotar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonVotar.setText("VOTAR");
        botonVotar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVotarActionPerformed(evt);
            }
        });

        botonGestorEleccion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonGestorEleccion.setText("CONTROL ELECCIONES");
        botonGestorEleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestorEleccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonGestorCandidato)
                            .addComponent(botonGestorEleccion))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonVotar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonRegistrarVotante, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGestorCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRegistrarVotante, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonVotar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGestorEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegistrarVotanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarVotanteActionPerformed
        this.setVisible(true);
        this.vistaVotante.setVisible(true);
    }//GEN-LAST:event_botonRegistrarVotanteActionPerformed

    private void botonGestorCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestorCandidatoActionPerformed
        this.setVisible(true);
        this.vistaCandidato.setVisible(true);
    }//GEN-LAST:event_botonGestorCandidatoActionPerformed

    private void botonVotarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVotarActionPerformed
        
    }//GEN-LAST:event_botonVotarActionPerformed

    private void botonGestorEleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestorEleccionActionPerformed
        this.setVisible(true);
        this.vistaElecciones.setVisible(true);
    }//GEN-LAST:event_botonGestorEleccionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGestorCandidato;
    private javax.swing.JButton botonGestorEleccion;
    private javax.swing.JButton botonRegistrarVotante;
    private javax.swing.JButton botonVotar;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
