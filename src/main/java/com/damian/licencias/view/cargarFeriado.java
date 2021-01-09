
package com.damian.licencias.view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class cargarFeriado extends javax.swing.JFrame {

    
    public cargarFeriado() {
        initComponents();
        this.setTitle("Cargar Feriado");
        this.setResizable(false);
        this.setSize(580,440);
        this.setLocationRelativeTo(null);
        cargarTablaFeriado();
        
        
        
          this.setVisible(true);
    }

    /*
    cargar tabla
    */
    private void cargarTablaFeriado() {

        List<Feriado> feriados = controladorEmp.buscarTurnosAtenderEmpleado(emp);

        String matriz[][] = new String[feriados.size()][1];
        
        if (!feriados.isEmpty()) {
            int i = 0;
            for (Feriado f : feriados) {
                if (f.algo no existe)) {
                    matriz[i][0] = f.fecha;
                    i++;
                }
            }
            tablaFeriados.setModel(new DefaultTableModel(
                    matriz,
                    new String[]{
                        "Feriados:"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(null, "No posee turnos para atender");
            tablaFeriados.setModel(new DefaultTableModel(
                    null,
                    new String[]{
                        "Feriados:"
                    }
            ));
           
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JCalendar();
        jLabel2 = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFeriados = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        BotonCargar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Seleccione la fecha del día feriado:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 211, 31));

        calendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calendarioMouseClicked(evt);
            }
        });
        getContentPane().add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 250, 180));

        jLabel2.setText("Se creara el feriado con la fecha:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 180, 40));
        getContentPane().add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 100, 30));

        tablaFeriados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Feriados:"
            }
        ));
        jScrollPane1.setViewportView(tablaFeriados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 220, 210));

        jLabel3.setText("Feriados existentes:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 170, 30));

        BotonCargar.setText("Cargar Feriado");
        BotonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCargarActionPerformed(evt);
            }
        });
        getContentPane().add(BotonCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 130, 40));

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
        //llamar a la ventana atras o salir
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void BotonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCargarActionPerformed
        //una vez finalizado y cargado el feriado mostrar en el labelfecha
        labelFecha.setText("fechaferiado");
        
    }//GEN-LAST:event_BotonCargarActionPerformed

    private void calendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarioMouseClicked
        //poner el codigo de cuando la persona hace click en la fecha
    }//GEN-LAST:event_calendarioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCargar;
    private javax.swing.JButton botonCancelar;
    private com.toedter.calendar.JCalendar calendario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JTable tablaFeriados;
    // End of variables declaration//GEN-END:variables
}
