package com.damian.licencias.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
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
public class Licencia implements Serializable, Comparable<Licencia>{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fechaInico = Calendar.getInstance(); 
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fechaFin = Calendar.getInstance();
    
    private int  cantDiasPedidos;
    
    //@ManyToOne
    @OneToMany
    @JoinColumn(name = "fk_diaTomado", nullable = false, updatable = true)
    //private DiasTomados diasTomados;
    private List<DiasTomados> diasTomados;
    
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
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.damian.licencias.model.Licencia[ id=" + id + " ]";
    }

    public Licencia() {
    }

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

    //compareTo de fecha mas vieja a mas nueva
    @Override
    public int compareTo(Licencia o) {
         return this.fechaInico.getTime().compareTo(o.getFechaInicio().getTime()); 
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

    public List<DiasTomados> getDiasTomados() {
        return diasTomados;
    }

    public void setDiasTomados(List<DiasTomados> diasTomados) {
        this.diasTomados = diasTomados;
    }
    
}
