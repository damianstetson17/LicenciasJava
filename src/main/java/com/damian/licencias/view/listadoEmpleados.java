package com.damian.licencias.view;

import com.damian.licencias.controller.LicenciaController;
import com.damian.licencias.model.Empleado;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class listadoEmpleados extends javax.swing.JFrame {
    private LicenciaController controlador;
    
    public listadoEmpleados(LicenciaController control ) {
        initComponents();
        this.controlador= control;
        this.setTitle("Listado de Empleados");
        this.setResizable(false);
        this.setSize(588,500);
        this.setLocationRelativeTo(null);
        cargartablaEmpleados();
        this.setVisible(true);
    }

    //cargar tabla
    private void cargartablaEmpleados() {

        List<Empleado> empleados = controlador.getEmpleados();

        String matriz[][] = new String[empleados.size()][4];
        
        if (!empleados.isEmpty()) {
            int i = 0;
            for (Empleado e : empleados) {
                Calendar c1 = e.getAntiguedad();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                matriz[i][0] =String.valueOf(e.getNroLegajo());
                matriz[i][1] = e.getNombreApellido();
                matriz[i][2] = sdf.format(c1.getTime());
                matriz[i][3] = String.valueOf(e.isEstado());
                 i++;
                
            }
            tablaEmpleados.setModel(new DefaultTableModel(
                    matriz,
                    new String[]{
                       "Nro Legajo", "Nombre y Apellido", "Antiguedad", "Activo"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(null, "No existen empleados cargados");
            tablaEmpleados.setModel(new DefaultTableModel(
                    null,
                    new String[]{
                      "Nro Legajo", "Nombre y Apellido", "Antiguedad", "Activo"
                    }
            ));  
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        botonSalir = new javax.swing.JButton();
        botonCargarEmpleado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nro Legajo", "Nombre y Apellido", "Antiguedad", "Activo"
            }
        ));
        jScrollPane1.setViewportView(tablaEmpleados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 510, 300));

        jLabel1.setText("Listado de empleados:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 240, 30));

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 413, 90, 40));

        botonCargarEmpleado.setText("Cargar nuevo empleado");
        botonCargarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarEmpleadoActionPerformed(evt);
            }
        });
        getContentPane().add(botonCargarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 200, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose();
        menuPrincipal iramenu = new menuPrincipal(controlador);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonCargarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarEmpleadoActionPerformed
        dispose();
        cargarEmpleado iracargar=new cargarEmpleado(controlador);
    }//GEN-LAST:event_botonCargarEmpleadoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCargarEmpleado;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}
