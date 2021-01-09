package com.damian.licencias.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Damian
 */
public class Licencia implements Comparable<Licencia>{
    private Calendar fechaInico = Calendar.getInstance(); 
    private Calendar fechaFin = Calendar.getInstance();
    private int  cantDiasPedidos;
    private List<DiasTomados> diasTomados = new ArrayList<>();

    /**
     *constructor
     * @param fechaInico
     * @param cantDiasPedidos
     */
    public Licencia(Calendar fechaInico, int cantDiasPedidos) {
        this.fechaInico = fechaInico;
        this.cantDiasPedidos = cantDiasPedidos;
    }

    public Calendar getFechaInicio() {
        return fechaInico;
    }

    public void setFechaInico(Calendar fechaInico) {
        this.fechaInico = fechaInico;
    }

    public Calendar getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCantDiasPedidos() {
        return cantDiasPedidos;
    }

    public void setCantDiasPedidos(int cantDiasPedidos) {
        this.cantDiasPedidos = cantDiasPedidos;
    }

    public List<DiasTomados> getDiasTomados() {
        return diasTomados;
    }

    public void setDiasTomados(List<DiasTomados> diasTomados) {
        this.diasTomados = diasTomados;
    }
    
    //add methods
    public void addDiasTomados(DiasTomados diasTomadosNew){
        this.diasTomados.add(diasTomadosNew);
        Collections.sort(this.diasTomados);
    }
    
    //search method
    public DiasTomados buscarDiasTomados(DiasTomados diasTomados){
        DiasTomados diasTomadosBuscados = null;
        for(DiasTomados diasT : this.diasTomados){
            if(diasT.getAnioDiasCorresp().getFechaAnio().get(Calendar.YEAR)
                    == diasTomados.getAnioDiasCorresp().getFechaAnio().get(Calendar.YEAR)){
                diasTomadosBuscados = diasT;
                break;
            }
        }
        return diasTomadosBuscados;
    }
    //compareTo de fecha mas vieja a mas nueva

    @Override
    public int compareTo(Licencia o) {
         return this.fechaInico.getTime().compareTo(o.getFechaInicio().getTime()); 
    }
}
