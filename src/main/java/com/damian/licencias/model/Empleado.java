package com.damian.licencias.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Damian
 */
public class Empleado implements Comparable<Empleado>{
    private int nroLegajo;
    private String nombreApellido;
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
        this.nombreApellido = nombreYApellido;
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
    
    public void addLicencia(Licencia licNew){
        this.licencias.add(licNew);
        Collections.sort(this.licencias);
    }
    
    //search methods
    
    public DiasCorrespondiente buscarDiasCorrespondiente(Calendar fechadiasBuscados){
        DiasCorrespondiente diasBuscados = null;
        for(DiasCorrespondiente d : this.diasCorrespondientes){
            //si los anios coinciden
            if(d.getFechaAnio().get(Calendar.YEAR) == fechadiasBuscados.get(Calendar.YEAR)){
                diasBuscados = d;
                break;
            }
        }
        return diasBuscados;
    }
    
    public Licencia buscarLicencia (Calendar fechaLicBuscada){
        Licencia licBuscada = null;
        for(Licencia l : this.licencias){
            if(l.getFechaInicio().get(Calendar.YEAR) == fechaLicBuscada.get(Calendar.YEAR)){
                licBuscada = l;
                break;
            }
        }
        return licBuscada;
    }
    
    //compareTo de antiguedad mas vieja a mas nueva

    @Override
    public int compareTo(Empleado e) {
         return this.getAntiguedad().getTime().compareTo(e.getAntiguedad().getTime()); 
    }
}
