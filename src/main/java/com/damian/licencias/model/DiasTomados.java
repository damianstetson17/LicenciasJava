package com.damian.licencias.model;

/**
 *
 * @author Damian
 */
public class DiasTomados implements Comparable<DiasTomados>{
    private int cantidadDias;
    private DiasCorrespondiente anioDiasCorresp;

    /**
     *constructor
     * @param cantidadDias
     * @param anioDiasCorresp
     */
    public DiasTomados(int cantidadDias, DiasCorrespondiente anioDiasCorresp) {
        this.cantidadDias = cantidadDias;
        this.anioDiasCorresp = anioDiasCorresp;
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
    
    //compareTo de fecha mas vieja a mas nueva

    @Override
    public int compareTo(DiasTomados o) {
        return this.getAnioDiasCorresp().getFechaAnio().getTime().compareTo(o.getAnioDiasCorresp().getFechaAnio().getTime());
    }
}
