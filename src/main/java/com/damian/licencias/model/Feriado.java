/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damian.licencias.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author piotr
 */
@Entity
public class Feriado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String descripcion;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fechaFeriado;
    
    private boolean estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feriado)) {
            return false;
        }
        Feriado other = (Feriado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.damian.licencias.model.Feriado[ id=" + id + " ]";
    }

    public Feriado() {
    }
    
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
    
    //compareTo de fecha mas vieja a mas nueva
    public int compareTo(Feriado o) {
         return this.fechaFeriado.getTime().compareTo(o.getFechaFeriado().getTime()); 
    }

    //setters y getters
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
    
    
}
