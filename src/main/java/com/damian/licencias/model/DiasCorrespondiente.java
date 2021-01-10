package com.damian.licencias.model;

import java.util.Calendar;

/**
 *
 * @author Damian
 */
public class DiasCorrespondiente implements Comparable<DiasCorrespondiente> {

    private Calendar fechaAnio;
    private int dias;
    private boolean estado;
    
    /**
     *constructor
     * @param FechaAnio
     * @param cantDias
     * @param estado
     */
    public DiasCorrespondiente(Calendar FechaAnio, int cantDias, boolean estado){
        this.fechaAnio = FechaAnio;
        this.dias = cantDias;
        this.setEstado(estado);   
    }

    public Calendar getFechaAnio() {
        return fechaAnio;
    }

    public void setFechaAnio(Calendar fechaAnio) {
        this.fechaAnio = fechaAnio;
    }

    public int getDias() {
        return dias;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        if(this.dias == 0)
        {
            this.estado=false;
        }else{
            this.estado=true;
        }
    }
    
    //compareTo de fecha mas vieja a mas nueva

    @Override
    public int compareTo(DiasCorrespondiente o) {
         return this.fechaAnio.getTime().compareTo(o.fechaAnio.getTime()); 
    }
    
}
