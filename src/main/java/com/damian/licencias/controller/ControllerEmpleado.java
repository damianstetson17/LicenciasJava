/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damian.licencias.controller;

import com.damian.licencias.JpaController.Conexion;
import com.damian.licencias.JpaController.EmpleadoJpaController;
import com.damian.licencias.model.DiasCorrespondiente;
import com.damian.licencias.model.Empleado;

/**
 *
 * @author piotr
 */
public class ControllerEmpleado {
     private final EmpleadoJpaController empleadoControlador;
     
    public ControllerEmpleado(){
        this.empleadoControlador= new EmpleadoJpaController(Conexion.getEmf());
    }
    
    public void crearEmpleado(Empleado empleadoAAgregar) throws Exception{
        //DiasCorrespondiente diasCorresDuplicado= this.buscarDiasCorresp(diasAAgregar);
       // if(diasCorresDuplicado==null){
            empleadoControlador.create(empleadoAAgregar);
        //}else{
       //     throw new Exception("Ya existe un departamento con ese dominio");
        //}
    }
    
    
}
