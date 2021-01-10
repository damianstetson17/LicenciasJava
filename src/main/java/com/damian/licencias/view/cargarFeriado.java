
package com.damian.licencias.view;

import com.damian.licencias.controller.LicenciaController;
import com.damian.licencias.model.Feriado;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class cargarFeriado extends javax.swing.JFrame {
    private LicenciaController controlador;

    public cargarFeriado(LicenciaController control ) {
        initComponents();
        this.controlador= control;
        this.setTitle("Cargar Feriado");
        this.setResizable(false);
        this.setSize(685,530);
        this.setLocationRelativeTo(null);
        cargarTablaFeriado();
        
        this.setVisible(true);
    }

    /*
    cargar tabla
    */
    private void cargarTablaFeriado() {

        List<Feriado> feriados = this.controlador.getFeriados();

        String matriz[][] = new String[feriados.size()][2];
        
        if (!feriados.isEmpty()) {
            int i = 0;
            for (Feriado f : feriados) {
                Calendar c1 = f.getFechaFeriado();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    matriz[i][0] = sdf.format(c1.getTime());
                    matriz[i][1] = f.getDescripcion();
                    i++;
                
            }
            tablaFeriados.setModel(new DefaultTableModel(
                    matriz,
                    new String[]{
                         "Fecha", "Descripcion"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(null, "No existen feriados cargados");
            tablaFeriados.setModel(new DefaultTableModel(
                    null,
                    new String[]{
                         "Fecha", "Descripcion"
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
        jLabel4 = new javax.swing.JLabel();
        textDescripcion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Seleccione la fecha del día feriado:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 211, 31));

        calendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calendarioMouseClicked(evt);
            }
        });
        getContentPane().add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 360, 200));

        jLabel2.setText("Se creara el feriado con la fecha:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 200, 40));
        getContentPane().add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 100, 40));

        tablaFeriados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Fecha", "Descripcion"
            }
        ));
        jScrollPane1.setViewportView(tablaFeriados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 220, 210));

        jLabel3.setText("Feriados existentes:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 170, 30));

        BotonCargar.setText("Cargar Feriado");
        BotonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCargarActionPerformed(evt);
            }
        });
        getContentPane().add(BotonCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 130, 40));

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 120, 40));

        jLabel4.setText("Descripcion: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 110, 30));

        textDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDescripcionActionPerformed(evt);
            }
        });
        getContentPane().add(textDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 120, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
         menuPrincipal iramenu = new menuPrincipal(controlador);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void BotonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCargarActionPerformed
        if(calendario.getDate() == null && textDescripcion.getText().equals("")){
            JOptionPane.showMessageDialog(null, "debe completar todos los campos");
        }else{
            try {
                Date  fecha=calendario.getDate();
                DateFormat f=new SimpleDateFormat("dd-MM-yyyy");
                String fecha2=f.format(fecha);
                Calendar cal = Calendar.getInstance();
                cal.setTime(f.parse(fecha2));
               if( controlador.buscarFeriado(cal)!= null){
                    JOptionPane.showMessageDialog(null, "El feriado ingresado ya existe");
               }else{
                   
                   Feriado feriadoCreado = new Feriado(textDescripcion.getText(),cal);
                   controlador.addFeriado(feriadoCreado);
                   cargarTablaFeriado();
                   this.setVisible(true);
               }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Error al tomar la fecha, error de parse");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al agregar el nuevo feriado");
            } 
        }
    }//GEN-LAST:event_BotonCargarActionPerformed

    private void calendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarioMouseClicked
        
        try { 
            Date  fecha=calendario.getDate();
            DateFormat f=new SimpleDateFormat("dd-MM-yyyy");
            String fecha2=f.format(fecha);
            Calendar cal = Calendar.getInstance();
            cal.setTime(f.parse(fecha2));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFeriado= sdf.format(cal.getTime());
            labelFecha.setText(fechaFeriado);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error al tomar la fecha, error de parse");
        }
       
    }//GEN-LAST:event_calendarioMouseClicked

    private void textDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDescripcionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCargar;
    private javax.swing.JButton botonCancelar;
    private com.toedter.calendar.JCalendar calendario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JTable tablaFeriados;
    private javax.swing.JTextField textDescripcion;
    // End of variables declaration//GEN-END:variables
}
