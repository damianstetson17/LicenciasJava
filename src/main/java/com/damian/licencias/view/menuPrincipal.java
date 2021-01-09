
package com.damian.licencias.view;


public class menuPrincipal extends javax.swing.JFrame {

    public menuPrincipal() {
        initComponents();
        
         this.setTitle("Menu Principal");
        this.setResizable(false);
        this.setSize(430,330);
        this.setLocationRelativeTo(null);
       
        
        this.setVisible(true);
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonSalir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 90, 40));

        jMenu1.setText("Cargar");

        jMenuItem1.setText("Empleado");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Dias Correspondientes");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Feriado");
        jMenu1.add(jMenuItem3);

        jMenu6.setText("Licencia");

        jMenuItem5.setText("Por cantidad de días");
        jMenu6.add(jMenuItem5);

        jMenuItem6.setText("Por días remanentes");
        jMenu6.add(jMenuItem6);

        jMenuItem4.setText("Insertar licencia antigua");
        jMenu6.add(jMenuItem4);

        jMenu1.add(jMenu6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem7.setText("Empleado");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Días Correspondientes");
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Feriado");
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("Licencia");
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu7.setText("Borrar");

        jMenuItem11.setText("Empleado");
        jMenu7.add(jMenuItem11);

        jMenuItem12.setText("Días Correspondientes");
        jMenu7.add(jMenuItem12);

        jMenuItem13.setText("Feriado");
        jMenu7.add(jMenuItem13);

        jMenuItem14.setText("Licencia");
        jMenu7.add(jMenuItem14);

        jMenuBar1.add(jMenu7);

        jMenu4.setText("Listados");

        jMenuItem15.setText("Listado de empleado");
        jMenu4.add(jMenuItem15);

        jMenuItem16.setText("Listado de licencias");
        jMenu4.add(jMenuItem16);

        jMenuItem17.setText("Listado de feriados");
        jMenu4.add(jMenuItem17);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Importar/Exportar");

        jMenu8.setText("Importar");

        jMenuItem18.setText("Empleados de excel");
        jMenu8.add(jMenuItem18);

        jMenu5.add(jMenu8);

        jMenu9.setText("Exportar");
        jMenu5.add(jMenu9);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
