/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damian.licencias.model;

import java.util.Calendar;

/**
 *
 * @author Damian
 */
public class Feriado implements Comparable<Feriado>{
    private String descripcion;
    private Calendar fechaFeriado;
    private boolean estado;
    /**
     * constructor
     * @param descripcion
     * @param fechaFeriado
     */
    public Feriado(String descripcion, Calendar fechaFeriado) {
        this.descripcion = descripcion;
        this.fechaFeriado = fechaFeriado;
        this.estado = true;
    }

    //getters & setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Calendar getFechaFeriado() {
        return fechaFeriado;
    }

    public void setFechaFeriado(Calendar fechaFeriado) {
        this.fechaFeriado = fechaFeriado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    //compareTo de fecha mas vieja a mas nueva

    @Override
    public int compareTo(Feriado o) {
         return this.fechaFeriado.getTime().compareTo(o.getFechaFeriado().getTime()); 
    }
}
