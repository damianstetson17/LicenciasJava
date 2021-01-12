/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damian.licencias.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author piotr
 */
@Entity
public class DiasTomados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int cantidadDias;
    
    @OneToOne
    private DiasCorrespondiente anioDiasCorresp;
    
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
        if (!(object instanceof DiasTomados)) {
            return false;
        }
        DiasTomados other = (DiasTomados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.damian.licencias.model.DiasTomados[ id=" + id + " ]";
    }

    public DiasTomados() {
    }
    
    /**
     *constructor
     * @param cantidadDias
     * @param anioDiasCorresp
     */
    public DiasTomados(int cantidadDias, DiasCorrespondiente anioDiasCorresp) {
        this.cantidadDias = cantidadDias;
        this.anioDiasCorresp = anioDiasCorresp;
    }

    //compareTo de fecha mas vieja a mas nueva
    public int compareTo(DiasTomados o) {
        return this.getAnioDiasCorresp().getFechaAnio().getTime().compareTo(o.getAnioDiasCorresp().getFechaAnio().getTime());
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public DiasCorrespondiente getAnioDiasCorresp() {
        return anioDiasCorresp;
    }

    public void setAnioDiasCorresp(DiasCorrespondiente anioDiasCorresp) {
        this.anioDiasCorresp = anioDiasCorresp;
    }
    
}
