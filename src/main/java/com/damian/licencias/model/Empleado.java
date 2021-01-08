package com.damian.licencias.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Damian
 */
public class Empleado {
    private int nroLegajo;
    private String nombreYApellido;
    private Calendar antiguedad;
    private boolean estado;
    private List<DiasCorrespondiente> diasCorrespondientes = new ArrayList<>();
    private List<Licencia> licencias = new ArrayList<>();

    /**
     * constructor
     * @param nroLegajo
     * @param nombreYApellido
     * @param antiguedad
     * @param estado
     */
    public Empleado(int nroLegajo, String nombreYApellido, Calendar antiguedad, boolean estado) {
        this.nroLegajo = nroLegajo;
        this.nombreYApellido = nombreYApellido;
        this.antiguedad = antiguedad;
        this.estado = estado;
    }
    
    //getters & setters

    public int getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(int nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
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

    public List<DiasCorrespondiente> getDiasCorrespondientes() {
        return diasCorrespondientes;
    }

    public void setDiasCorrespondientes(List<DiasCorrespondiente> diasCorrespondientes) {
        this.diasCorrespondientes = diasCorrespondientes;
    }

    public List<Licencia> getLicencias() {
        return licencias;
    }

    public void setLicencias(List<Licencia> licencias) {
        this.licencias = licencias;
    }
    
    //add methods
    public void addDiasCorrespondiente(DiasCorrespondiente diasNew){
        this.diasCorrespondientes.add(diasNew);
        Collections.sort(this.diasCorrespondientes);
    }
    
}
