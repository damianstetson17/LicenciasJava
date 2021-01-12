/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damian.licencias.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author piotr
 */
@Entity
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int nroLegajo;
    
    private String nombreApellido;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar antiguedad;
    
    private boolean estado;
    
    @ManyToOne
    @JoinColumn(name = "fk_diaCorresp", nullable = true, updatable = true)
    private DiasCorrespondiente diasCorrespondientes;
    
    @ManyToOne
    @JoinColumn(name = "fk_licencia", nullable = true, updatable = true)
    private Licencia licencias;
    
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.damian.licencias.model.Empleado[ id=" + id + " ]";
    }

    public Empleado() {
    }
    
    /**
     * constructor
     * @param nroLegajo
     * @param nombreYApellido
     * @param antiguedad
     * @param estado
     */
    public Empleado(int nroLegajo, String nombreYApellido, Calendar antiguedad, boolean estado) {
        this.nroLegajo = nroLegajo;
        this.nombreApellido = nombreYApellido;
        this.antiguedad = antiguedad;
        this.estado = estado;
    }
    
    //setters y getters
    public int getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(int nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public Calendar getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Calendar antiguedad) {
        this.antiguedad = antiguedad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public DiasCorrespondiente getDiasCorrespondientes() {
        return diasCorrespondientes;
    }

    public void setDiasCorrespondientes(DiasCorrespondiente diasCorrespondientes) {
        this.diasCorrespondientes = diasCorrespondientes;
    }

    public Licencia getLicencias() {
        return licencias;
    }

    public void setLicencias(Licencia licencias) {
        this.licencias = licencias;
    }
    
    
}
