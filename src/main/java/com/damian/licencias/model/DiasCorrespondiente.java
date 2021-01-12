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


@Entity
public class DiasCorrespondiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fechaAnio;
    
    private int dias;
    
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
        if (!(object instanceof DiasCorrespondiente)) {
            return false;
        }
        DiasCorrespondiente other = (DiasCorrespondiente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.damian.licencias.model.DiasCorrespondiente[ id=" + id + " ]";
    }

    public DiasCorrespondiente() {
    }

     /**
     *constructor
     * @param FechaAnio
     * @param cantDias
     * @param estado
     */
    public DiasCorrespondiente(Calendar FechaAnio, int cantDias, boolean estado){
        this.fechaAnio = FechaAnio;
        this.dias = cantDias;
        this.estado = estado;   
    }
    
    //setters y getters
    public Calendar getFechaAnio() {
        return fechaAnio;
    }

    public void setFechaAnio(Calendar fechaAnio) {
        this.fechaAnio = fechaAnio;
    }

    public int getDias() {
        return dias;
    }

    public boolean isEstado() {
        return estado;
    }
    
    public void setDias(int dias) {
        this.dias = dias;
        //Si se queda sin dias se actualiza el estado
        if(this.dias == 0)
        {
            this.setEstado(false);
        }else{
            this.setEstado(true);
        }
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    //compareTo de fecha mas vieja a mas nueva
    public int compareTo(DiasCorrespondiente o) {
         return this.fechaAnio.getTime().compareTo(o.fechaAnio.getTime()); 
    }
    
}
