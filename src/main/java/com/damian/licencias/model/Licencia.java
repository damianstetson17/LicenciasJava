package com.damian.licencias.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Damian
 */
public class Licencia {
    private Calendar fechaInico; 
    private Calendar fechaFin;
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

    public Calendar getFechaInico() {
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
}
