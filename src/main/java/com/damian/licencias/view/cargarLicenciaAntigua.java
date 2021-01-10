
package com.damian.licencias.view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class cargarLicenciaAntigua extends javax.swing.JFrame {

   
    public cargarLicenciaAntigua() {
        initComponents();
    
     this.setTitle("Cargar Licencia antigua");
        this.setResizable(false);
        this.setSize(775,620);
        this.setLocationRelativeTo(null);
        
        
        
        this.setVisible(true);
    
    }
     /*
    cargar tabla
    
    private void cargarTablaLicencia() {

        List<DiasCorrespondiente> diascorresp = controladorEmp.buscarTurnosAtenderEmpleado(emp);

        String matriz[][] = new String[empleados.size()][1];
        
        if (!diascorresp.isEmpty()) {
            int i = 0;
            for (DiasCorrespondiente d : diascorresp) {
                if (d.algo no existe)) {
                    matriz[i][0] = d.fecha;
                    matriz[i][1] = d.fecha;
                    matriz[i][2] = d.fecha;
                    matriz[i][3] = d.fecha;
                    matriz[i][4] = d.fecha;
                    matriz[i][5] = d.fecha;
                    i++;
                }
            }
            tablaLicencia.setModel(new DefaultTableModel(
                    matriz,
                    new String[]{
                        "Fecha Inicio", "Fecha Fin", "Año", "Cantidad Disponibles", "Usufructuó", "Dias Remanentes"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(null, "No posee turnos para atender");
            tablaLicencia.setModel(new DefaultTableModel(
                    null,
                    new String[]{
                       "Fecha Inicio", "Fecha Fin", "Año", "Cantidad Disponibles", "Usufructuó", "Dias Remanentes"
                    }
            ));
           
        }
    }

     /*
    cargar tabla
    
    private void cargartablaDiasCorrespondienteEmpleado() {

        List<DiasCorrespondiente> diascorresp = controladorEmp.buscarTurnosAtenderEmpleado(emp);

        String matriz[][] = new String[empleados.size()][1];
        
        if (!diascorresp.isEmpty()) {
            int i = 0;
            for (DiasCorrespondiente d : diascorresp) {
                if (d.algo no existe)) {
                    matriz[i][0] = d.fecha;
                    matriz[i][1] = d.fecha;
                    i++;
                }
            }
            tablaDiasCorrespondienteEmpleado.setModel(new DefaultTableModel(
                    matriz,
                    new String[]{
                        "Año", "Dias Disponibles"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(null, "No posee turnos para atender");
            tablaDiasCorrespondienteEmpleado.setModel(new DefaultTableModel(
                    null,
                    new String[]{
                       "Año", "Dias Disponibles"
                    }
            ));
           
        }
    }
   */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDiasCorrespondienteEmpleado = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNroLegajo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textCantDiasdeAno = new javax.swing.JTextField();
        botonBuscarEmpleado = new javax.swing.JButton();
        botonOcuparDias = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaLicencia = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        botonGenerarLicencia = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonQuitarDiasLic = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaDiasCorrespondienteEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Año", "Dias Disponibles"
            }
        ));
        tablaDiasCorrespondienteEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDiasCorrespondienteEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDiasCorrespondienteEmpleado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 290, 180));

        jLabel1.setText("Todos los días correspondientes existentes del empleado:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 34, 320, 40));

        jLabel2.setText("Nro Legajo empleado:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 130, 30));
        getContentPane().add(textNroLegajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 100, 30));

        jLabel3.setText("Cargar Licencia antigua:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 260, 40));

        jLabel4.setText("Cantidad de dias de año seleccionado:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 200, 30));
        getContentPane().add(textCantDiasdeAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 80, 30));

        botonBuscarEmpleado.setText("Buscar Empleado");
        botonBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarEmpleadoActionPerformed(evt);
            }
        });
        getContentPane().add(botonBuscarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 130, 30));

        botonOcuparDias.setText("Ocupar días");
        botonOcuparDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOcuparDiasActionPerformed(evt);
            }
        });
        getContentPane().add(botonOcuparDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 120, 30));

        tablaLicencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha Inicio", "Fecha Fin", "Año", "Cantidad Disponibles", "Usufructuó", "Dias Remanentes"
            }
        ));
        tablaLicencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaLicenciaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaLicencia);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 570, 220));

        jLabel5.setText("Licencia a generar:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 320, 40));

        botonGenerarLicencia.setText("Generar Licencia");
        getContentPane().add(botonGenerarLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 600, 130, 50));

        botonSalir.setText("Cancelar");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 600, 130, 50));

        botonQuitarDiasLic.setText("Quitar días de la licencia");
        botonQuitarDiasLic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarDiasLicActionPerformed(evt);
            }
        });
        getContentPane().add(botonQuitarDiasLic, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 170, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaDiasCorrespondienteEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDiasCorrespondienteEmpleadoMouseClicked
        // poner el codigo de cuandos e hace click se busca el objeto y se le restan los dias de ese año
    }//GEN-LAST:event_tablaDiasCorrespondienteEmpleadoMouseClicked

    private void botonBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarEmpleadoActionPerformed
        // TODO add your handling code here:
     //   cargartablaDiasCorrespondienteEmpleado();
    }//GEN-LAST:event_botonBuscarEmpleadoActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose();
        // llamar a ventana menu
    }//GEN-LAST:event_botonSalirActionPerformed

    private void tablaLicenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaLicenciaMouseClicked
        // aca se selecciona el objeto se lo busca y borra los dias seleccionados
        int row = tablaLicencia.rowAtPoint(evt.getPoint());
        if (row >= 0) {

            String año = tablaLicencia.getValueAt(row, 0).toString();
            

        }
    }//GEN-LAST:event_tablaLicenciaMouseClicked

    private void botonOcuparDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOcuparDiasActionPerformed
        // TODO add your handling code here:
       // cargarTablaLicencia();
         this.setVisible(true);
    }//GEN-LAST:event_botonOcuparDiasActionPerformed

    private void botonQuitarDiasLicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarDiasLicActionPerformed
        // 
    }//GEN-LAST:event_botonQuitarDiasLicActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarEmpleado;
    private javax.swing.JButton botonGenerarLicencia;
    private javax.swing.JButton botonOcuparDias;
    private javax.swing.JButton botonQuitarDiasLic;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaDiasCorrespondienteEmpleado;
    private javax.swing.JTable tablaLicencia;
    private javax.swing.JTextField textCantDiasdeAno;
    private javax.swing.JTextField textNroLegajo;
    // End of variables declaration//GEN-END:variables
}
