package com.damian.licencias.view;

import com.damian.licencias.controller.LicenciaController;
import com.damian.licencias.model.Licencia;
import javax.swing.JOptionPane;

public class cargarLicenciaAuto extends javax.swing.JFrame {
    private LicenciaController controlador;
    
    public cargarLicenciaAuto(LicenciaController control) {
        this.controlador = control;
        initComponents();
        this.setTitle("Cargar Licencia");
        this.setResizable(false);
        this.setSize(509,516);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel2 = new javax.swing.JLabel();
        textNroLegajo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        labelFechaFin = new javax.swing.JLabel();
        botonCargarLicencia = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textCantDiasPedidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nro Legajo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 30));

        jCalendar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCalendar1MouseClicked(evt);
            }
        });
        getContentPane().add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 370, 200));

        jLabel2.setText("Fecha Inicio:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, 30));
        getContentPane().add(textNroLegajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 120, 30));

        jLabel3.setText("Fecha Fin:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 70, 30));
        getContentPane().add(labelFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 100, 30));

        botonCargarLicencia.setText("Cargar Licencia");
        botonCargarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarLicenciaActionPerformed(evt);
            }
        });
        getContentPane().add(botonCargarLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 130, 40));

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 100, 40));

        jLabel4.setText("Cantidad dias solicitados:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 150, 30));
        getContentPane().add(textCantDiasPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 100, 30));

        jLabel5.setText("Cargar nueva licencia:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose();
        //llamar a la ventana anterior
    }//GEN-LAST:event_botonSalirActionPerformed

    private void jCalendar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCalendar1MouseClicked
        // aca poner que hacer cuando se hace click en la fecha
    }//GEN-LAST:event_jCalendar1MouseClicked

    private void botonCargarLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarLicenciaActionPerformed
        // al finalizar mostrar en el label labelFechaFin.settext
        if(!(textNroLegajo.getText().equals("") || textCantDiasPedidos.getText().equals(""))){
            try {
                JOptionPane.showMessageDialog(null, "la fecha es:"+jCalendar1.getCalendar());
                Licencia newLicencia = new Licencia(jCalendar1.getCalendar(),Integer.parseInt(textCantDiasPedidos.getText()));
                JOptionPane.showMessageDialog(null, "cree la lic, al legajo:"+textNroLegajo.getText());
                
                controlador.generarLicenciaAuto(Integer.parseInt(textNroLegajo.getText()), newLicencia);
                JOptionPane.showMessageDialog(null, "Se cargó la licencia al empleado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos para continuar");
        }
    }//GEN-LAST:event_botonCargarLicenciaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCargarLicencia;
    private javax.swing.JButton botonSalir;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelFechaFin;
    private javax.swing.JTextField textCantDiasPedidos;
    private javax.swing.JTextField textNroLegajo;
    // End of variables declaration//GEN-END:variables
}
