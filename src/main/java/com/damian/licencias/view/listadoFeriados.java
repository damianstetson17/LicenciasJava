
package com.damian.licencias.view;

import com.damian.licencias.controller.LicenciaController;
import com.damian.licencias.model.Feriado;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class listadoFeriados extends javax.swing.JFrame {
    private LicenciaController controlador;
   
    public listadoFeriados(LicenciaController control) {
        initComponents();
        this.controlador= control;
        this.setTitle("Listado feriados de un año");
        this.setResizable(false);
        this.setSize(650,520);
        this.setLocationRelativeTo(null);
        
        this.setVisible(true);
    }

    
    /*
    cargar tabla
    */
    private void cargarTablaFeriados(int anoFeriado) {

        List<Feriado> feriados = controladorbuscarFeriadoPorAno(anoFeriado);

        String matriz[][] = new String[feriados.size()][3];
        
        if (!feriados.isEmpty()) {
            int i = 0;
            for (Feriado f: feriados) {
                Calendar c1 = f.getFechaFeriado();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    matriz[i][0] = sdf.format(c1.getTime());
                    matriz[i][1] = f.getDescripcion();
                    matriz[i][2] = String.valueOf(f.isEstado());
                    i++;
            }
            tablaFeriados.setModel(new DefaultTableModel(
                    matriz,
                    new String[]{
                        "Fecha", "Descripcion", "Estado"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(null, "No existen feriados cargados");
            tablaFeriados.setModel(new DefaultTableModel(
                    null,
                    new String[]{
                       "Fecha", "Descripcion", "Estado"
                    }
            ));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        anoFeriado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFeriados = new javax.swing.JTable();
        botonBuscar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Año a buscar:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 31));
        getContentPane().add(anoFeriado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 90, 30));

        jLabel2.setText("Listado de Feriados de un año:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 250, 30));

        tablaFeriados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Fecha", "Descripcion", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tablaFeriados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 350, 220));

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 90, 30));

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 80, 40));

        jButton1.setText("Cargar nuevo Feriado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 150, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose();
        menuPrincipal volveramenu = new menuPrincipal(controlador);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        cargarFeriado iracargar=new cargarFeriado(controlador);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        if(!anoFeriado.getText().equals("")){
            int anoabuscar = Integer.parseInt(anoFeriado.getText());
            Feriado feriadoabuscar = controlador.buscarFeriadoPorAno(anoabuscar);
            
            cargarTablaFeriados(feriadoabuscar);
            this.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "debe ingresar un año a buscar");
        }
           
    }//GEN-LAST:event_botonBuscarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anoFeriado;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFeriados;
    // End of variables declaration//GEN-END:variables
}
