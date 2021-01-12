/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damian.licencias.controller;

import com.damian.licencias.JpaController.Conexion;
import com.damian.licencias.model.DiasCorrespondiente;
import com.damian.licencias.model.Empleado;
import java.util.Calendar;


public class main {
    public static void main(String[] args) {
        
        new Conexion();
        ControllerDiasCorresp controladorDias = new ControllerDiasCorresp();
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
        }
    }
}
