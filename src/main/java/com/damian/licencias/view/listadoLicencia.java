package com.damian.licencias.view;

import com.damian.licencias.controller.LicenciaController;
import com.damian.licencias.model.DiasTomados;
import com.damian.licencias.model.Empleado;
import com.damian.licencias.model.Licencia;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class listadoLicencia extends javax.swing.JFrame {
    private LicenciaController controlador;
   
    public listadoLicencia(LicenciaController control) {
        initComponents();
        this.controlador=control;
        this.setTitle("Listado Licencia de un Empleado");
        this.setResizable(false);
        this.setSize(650,520);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
 
    //cargar tabla
    private void cargarTablaLicenciaEmp(Empleado emple) {

        List<Licencia> licencias = emple.getLicencias();

        String matriz[][] = new String[licencias.size()][1];
        
        if (!licencias.isEmpty()) {
            int i = 0;
            for (Licencia l : licencias) {
                    Calendar c1 = l.getFechaInicio();
                    Calendar c2 = l.getFechaFin();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    matriz[i][0] = String.valueOf(c1.get(Calendar.YEAR));
                    matriz[i][1] = String.valueOf(c2.get(Calendar.YEAR));
                    for(DiasTomados dias : l.getDiasTomados()){
                        Calendar c3 = dias.getAnioDiasCorresp().getFechaAnio();
                        matriz[i][2] = String.valueOf(c3.get(Calendar.YEAR));
                        matriz[i][3] = String.valueOf(dias.getAnioDiasCorresp().getDias()+dias.getCantidadDias());
                        matriz[i][4] = String.valueOf(dias.getCantidadDias());
                        matriz[i][5] = String.valueOf(dias.getAnioDiasCorresp().getDias());
                        i++;
                    }
                    i++;
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLicencia = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNroLegajo = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        botonSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaLicencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha Inicio", "Fecha Fin", "Año", "Cantidad Disponibles", "Usufructuó", "Días Remanentes"
            }
        ));
        jScrollPane1.setViewportView(tablaLicencia);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 580, 210));

        jLabel1.setText("Listado Licencias tomadas del empleado:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 290, 30));

        jLabel2.setText("Nro Legajo Empleado:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 130, 30));
        getContentPane().add(textNroLegajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 110, 30));

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 70, 30));

        jLabel3.setText("Listado licencias de un empleado:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 250, 30));

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 80, 40));

        jButton1.setText("Cargar nueva licencia");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 170, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose();
        //llamar a la ventana anterior
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        //cuando se apreta buscar se toma el nrolegajo del textfield y se busca al empleado y llama a cargar tabla de licencias
        if(!textNroLegajo.getText().equals("")){
            Empleado emple=controlador.buscarEmpleado(Integer.parseInt(textNroLegajo.getText()));
            if(emple != null){
                this.cargarTablaLicenciaEmp(emple);
            }else{
                 JOptionPane.showMessageDialog(null, "No se encontró el empleado a listar sus licencias.");
            }
        }else{
             JOptionPane.showMessageDialog(null, "Debe completar todos los campos para continuar.");
        }        
    }//GEN-LAST:event_botonBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLicencia;
    private javax.swing.JTextField textNroLegajo;
    // End of variables declaration//GEN-END:variables
}
