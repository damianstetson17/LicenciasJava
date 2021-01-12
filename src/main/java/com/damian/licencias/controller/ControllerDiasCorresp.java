/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damian.licencias.controller;

import com.damian.licencias.JpaController.Conexion;
import com.damian.licencias.JpaController.DiasCorrespondienteJpaController;
import com.damian.licencias.model.DiasCorrespondiente;

/**
 *
 * @author piotr
 */
public class ControllerDiasCorresp {
     
    private final DiasCorrespondienteJpaController DiasCorrControlador;
     
    public ControllerDiasCorresp(){
        this.DiasCorrControlador= new DiasCorrespondienteJpaController(Conexion.getEmf());
    }
    
    public void crearDiasCorresp(DiasCorrespondiente diasAAgregar) throws Exception{
        //DiasCorrespondiente diasCorresDuplicado= this.buscarDiasCorresp(diasAAgregar);
       // if(diasCorresDuplicado==null){
            DiasCorrControlador.create(diasAAgregar);
        //}else{
       //     throw new Exception("Ya existe un departamento con ese dominio");
        //}
    }
    
    
}
