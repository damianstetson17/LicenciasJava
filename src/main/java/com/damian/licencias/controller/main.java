package com.damian.licencias.controller;

import com.damian.licencias.JpaController.Conexion;
import com.damian.licencias.view.menuPrincipal;


public class main {
    public static void main(String[] args) {
        
        LicenciaController controlador = new LicenciaController(new Conexion());
        menuPrincipal menuPrin = new menuPrincipal(controlador);
        
        /*ControllerDiasCorresp controladorDias = new ControllerDiasCorresp();
        ControllerEmpleado controladorEmp = new ControllerEmpleado();
        Calendar FechaAnio = Calendar.getInstance();
        int cantDias = 15;
        boolean estado = true;
        DiasCorrespondiente dias = new DiasCorrespondiente(FechaAnio,cantDias,estado);
        
        int nroLegajo= 123;
        String nombreYApellido= "anchi";
        Calendar antiguedad= Calendar.getInstance();
        Empleado emp = new Empleado(nroLegajo,nombreYApellido,antiguedad,true);
        try {
            
            System.out.println("id de dias " +dias.getId());
            controladorDias.crearDiasCorresp(dias);
            controladorEmp.crearEmpleado(emp);
        } catch (Exception ex) {
           System.out.print(ex.getMessage());
        }*/
        
    }
}
