package com.damian.licencias.view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class cargarEmpleado extends javax.swing.JFrame {

   
    public cargarEmpleado() {
        initComponents();
        this.setTitle("Cargar Empleado");
        this.setResizable(false);
        this.setSize(580,440);
        this.setLocationRelativeTo(null);
        cargarTablaEmpleado();
        
        
        
        this.setVisible(true);
    }

     /*
    cargar tabla
    */
    private void cargarTablaEmpleado() {

        List<Empleado> empleados = controladorEmp.buscarTurnosAtenderEmpleado(emp);

        String matriz[][] = new String[empleados.size()][1];
        
        if (!empleados.isEmpty()) {
            int i = 0;
            for (Empleado e : empleados) {
                if (e.algo no existe)) {
                    matriz[i][0] = f.fecha;
                    matriz[i][1] = f.fecha;
                    matriz[i][2] = f.fecha;
                    i++;
                }
            }
            tablaEmpleado.setModel(new DefaultTableModel(
                    matriz,
                    new String[]{
                        "Nombre ", "Nro Legajo", "Antiguedad"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(null, "No posee turnos para atender");
            tablaEmpleado.setModel(new DefaultTableModel(
                    null,
                    new String[]{
                        "Nombre ", "Nro Legajo", "Antiguedad"
                    }
            ));
           
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleado = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        botonCargar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        textNroLegajo = new javax.swing.JTextField();
        jDateChooserAntiguedadEmple = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Nombre ", "Nro Legajo", "Antiguedad"
            }
        ));
        jScrollPane1.setViewportView(tablaEmpleado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 250, 250));

        jLabel1.setText("Empleados existentes:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 170, 30));

        botonCargar.setText("Cargar Empleado");
        botonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 130, 40));

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 130, 40));

        jLabel2.setText("Cargar Empleado:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 170, 30));

        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 70, 30));

        jLabel4.setText("Nro Legajo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 90, 30));

        jLabel5.setText("Antiguedad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 90, 30));
        getContentPane().add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 30));
        getContentPane().add(textNroLegajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 130, 30));
        getContentPane().add(jDateChooserAntiguedadEmple, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 130, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
        //llamar a la ventana anterior
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCargarActionPerformed

    private void elegirAntiguedadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_elegirAntiguedadMouseClicked
        //aca poner codigo de que hacer cuandos se hace click en la antiguedad

    }//GEN-LAST:event_elegirAntiguedadMouseClicked

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonCargar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooserAntiguedadEmple;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleado;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textNroLegajo;
    // End of variables declaration//GEN-END:variables
}
