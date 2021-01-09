
package com.damian.licencias.view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class cargarDiasCorrespon extends javax.swing.JFrame {

    
    public cargarDiasCorrespon() {
        initComponents();
        
         this.setTitle("Cargar Dias Correspondientes");
        this.setResizable(false);
        this.setSize(630,460);
        this.setLocationRelativeTo(null);
        
        
        
        this.setVisible(true);
    }

    /*
    cargar tabla
    */
    private void cargarTablaCantDias() {

        List<DiasCorrespondiente> diascorresp = controladorEmp.buscarTurnosAtenderEmpleado(emp);

        String matriz[][] = new String[empleados.size()][1];
        
        if (!diascorresp.isEmpty()) {
            int i = 0;
            for (DiasCorrespondiente d : diascorresp) {
                if (d.algo no existe)) {
                    matriz[i][0] = d.fecha;
                    matriz[i][1] = d.fecha;
                    matriz[i][2] = d.fecha;
                    i++;
                }
            }
            tablaCantDias.setModel(new DefaultTableModel(
                    matriz,
                    new String[]{
                        "Año", "Dias disponibles", "Estado"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(null, "No posee turnos para atender");
            tablaCantDias.setModel(new DefaultTableModel(
                    null,
                    new String[]{
                       "Año", "Dias disponibles", "Estado"
                    }
            ));
           
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCantDias = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        botonCargarDias = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textNroLegajo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TextAño = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textCantDiasAño = new javax.swing.JTextField();
        Activo = new java.awt.Checkbox();
        botonBuscarEmp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaCantDias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Año", "Dias disponibles", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tablaCantDias);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 270, 241));

        jLabel1.setText("Dias disponibles del Empleado:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 180, 30));

        botonCargarDias.setText("Cargar dias ");
        botonCargarDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarDiasActionPerformed(evt);
            }
        });
        getContentPane().add(botonCargarDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 373, 110, 40));

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 130, 40));

        jLabel2.setText("Cargar Dias Correspondientes:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 180, 30));

        jLabel3.setText("Nro Legajo empleado a cargar dias:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 200, 40));
        getContentPane().add(textNroLegajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 100, 30));

        jLabel4.setText("Año del dia correspondiente:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 170, 40));
        getContentPane().add(TextAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 100, 30));

        jLabel5.setText("Cantidad de días que corresponden:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 200, 30));
        getContentPane().add(textCantDiasAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 100, 30));

        Activo.setLabel("Activo");
        Activo.setState(true);
        getContentPane().add(Activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 100, 30));

        botonBuscarEmp.setText("Buscar Empleado");
        botonBuscarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarEmpActionPerformed(evt);
            }
        });
        getContentPane().add(botonBuscarEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 160, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
        //llamar a la ventana anterior
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonCargarDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarDiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCargarDiasActionPerformed

    private void botonBuscarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarEmpActionPerformed
        // cuando se busca al emp ahi se carga su tabla
                cargarTablaCantDias();

    }//GEN-LAST:event_botonBuscarEmpActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox Activo;
    private javax.swing.JTextField TextAño;
    private javax.swing.JButton botonBuscarEmp;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonCargarDias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCantDias;
    private javax.swing.JTextField textCantDiasAño;
    private javax.swing.JTextField textNroLegajo;
    // End of variables declaration//GEN-END:variables
}
