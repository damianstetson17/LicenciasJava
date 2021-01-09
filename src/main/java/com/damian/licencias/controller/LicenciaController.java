package com.damian.licencias.controller;

import com.damian.licencias.model.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static java.util.Objects.isNull;

/**
 *
 * @author Damian
 */
public class LicenciaController {
    private List<Empleado> empleados = new ArrayList<>();
    private List<Feriado> feriados = new ArrayList<>();

    //getters & setters
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Feriado> getFeriados() {
        return feriados;
    }

    public void setFeriados(List<Feriado> feriados) {
        this.feriados = feriados;
    }

    //FERIADO
    public Feriado buscarFeriado(Calendar fechaFeridadoBusc){
        System.out.println(("\t└->LLAMADO AL MÓDULO BUSCAR FERIADO"));
        Feriado feriadoBuscado = null;
        for(Feriado f : this.feriados){
            if(f.getFechaFeriado().get(Calendar.YEAR) == fechaFeridadoBusc.get(Calendar.YEAR)){
                feriadoBuscado=f;
                break;
            }
        }
        System.out.println("\t\t└>Retorno feriado buscado '"+feriadoBuscado+"'");
        return feriadoBuscado;
    }
    
    public void addFeriado(Feriado feriadoNew) throws Exception{
        System.out.println("\t└->LLAMADO AL MÓDULO CREAR FERIADO");
        Feriado feriadoDupli = this.buscarFeriado(feriadoNew.getFechaFeriado());
        if(isNull(feriadoDupli)){
            this.feriados.add(feriadoNew);
            System.out.println("\t\t└>Se insertó el feriado '"+feriadoNew.getFechaFeriado()+"'");
        }else{
            throw new Exception("Ya existe un feriado con la fecha '"
                                + feriadoNew.getFechaFeriado()+"'");
        }
    }
    
    public void delFeriado(Calendar dechaFeriadoDel)throws Exception{
        System.out.println("\t└->LLAMADO AL MÓDULO BAJA FERIADO");
        Feriado feriadoExis = this.buscarFeriado(dechaFeriadoDel);
        if(feriadoExis != null){
            feriadoExis.setEstado(false);
            System.out.println("\t\t└> Se cambió el estado del feriado '"+
                    feriadoExis.getFechaFeriado().getTime() + "'");
        }else{
            throw new Exception("No se encontró un feriado con la fecha '"
                                + dechaFeriadoDel+"'");
        }
    }
    
    //PERSONA
    public Empleado buscarEmpleado(int nroLegajoBuscado){
        System.out.println(("\t└->LLAMADO AL MÓDULO BUSCAR EMPLEADO"));
        Empleado empleadoBuscado = null;
        for(Empleado e : this.empleados){
            if(e.getNroLegajo() == nroLegajoBuscado){
                empleadoBuscado=e;
                break;
            }
        }
        System.out.println("\t\t└>Retorno el empelado buscado '"+empleadoBuscado+"'");
        return empleadoBuscado;
    }
    
    public void addEmpleado(Empleado empleadoNew) throws Exception{
        System.out.println("\t└->LLAMADO AL MÓDULO CREAR EMPLEADO");
        Empleado empleadoDupli = this.buscarEmpleado(empleadoNew.getNroLegajo());
        if(isNull(empleadoDupli)){
            this.empleados.add(empleadoNew);
            System.out.println("\t\t└>Se insertó el empleado '"+empleadoNew+"'");
        }else{
            throw new Exception("Ya existe un empleado con el nro de legajo '"
                                + empleadoNew.getNroLegajo()+"'");
        }
    }
    public void modEmpleado (Empleado empleMod)throws Exception{
        System.out.println("\t└->LLAMADO AL MÓDULO MODIFICAR EMPLEADO");
        Empleado empleadoExis = this.buscarEmpleado(empleMod.getNroLegajo());
         if(empleadoExis != null){
            empleadoExis.setNroLegajo(empleMod.getNroLegajo());
            empleadoExis.setNombreApellido(empleMod.getNombreApellido());
            empleadoExis.setAntiguedad(empleMod.getAntiguedad());
            empleadoExis.setEstado(empleMod.isEstado());
            
            /*not implemented the modif of list licencias and diascorresp,
            they have their own methods*/
                    
            System.out.println("\t\t└> Se cambió el estado del empleado '"+
                    empleadoExis.isEstado() + "'");
        }else{
            throw new Exception("No se econtró un empleado con el nro de legajo '"
                                + empleMod.getNroLegajo()+"' a modificar");
        }
    }
    
    public void delEmpleado(int nroLegajoEmpleDel) throws Exception{
        System.out.println("\t└->LLAMADO AL MÓDULO BAJA EMPLEADO");
        Empleado empleadoExis = this.buscarEmpleado(nroLegajoEmpleDel);
        if(empleadoExis != null){
            empleadoExis.setEstado(false);
            System.out.println("\t\t└> Se cambió el estado del empleado '"+
                    empleadoExis.isEstado() + "'");
        }else{
            throw new Exception("No se econtró un empleado con el nro de legajo '"
                                + nroLegajoEmpleDel+"' a borrar");
        }
    }
    
    //DIAS CORRESPONDIENTES DE EMPLEADO
    public void generarDiasCorrespondientesEmpleado(int nroLegajoEmpleado, DiasCorrespondiente diasAgregar) throws Exception{
       System.out.println("\t└->LLAMADO AL MÓDULO GENERAR DIAS CORRESPONDIENTES EMPLEADO");
        Empleado empleAgregarDias = this.buscarEmpleado(nroLegajoEmpleado);
        if(empleAgregarDias != null){//si existe el empleado
            DiasCorrespondiente diasDuplicado = empleAgregarDias.buscarDiasCorrespondiente(diasAgregar.getFechaAnio());
            if(isNull(diasDuplicado)){//si ya no existe dias asociados de ese anio
                empleAgregarDias.addDiasCorrespondiente(diasAgregar);
                System.out.println("\t\t└> Se agregaron al empleado legajo nro '"+
                    empleAgregarDias.getNroLegajo()+ "'" + "'"+diasAgregar.getDias()+
                    "' días del año '"+diasAgregar.getFechaAnio().getTime()+"'");
            }else{
                throw new Exception("El empleado con el nro de legajo '"
                                + nroLegajoEmpleado+"' ya posee días correspondientes"
                                + " asociados al año '"+diasAgregar.getFechaAnio().getTime()
                                +"' (Posee '"+diasDuplicado.getDias()+"' días del año");
            }
        }else{
            throw new Exception("No se econtró un empleado con el nro de legajo '"
                                + nroLegajoEmpleado+"' a agregar días correspondientes");
        }
    }
    
    public void bajaDiasCorrespondientesEmpleado(int nroLegajoEmpleado, DiasCorrespondiente diasBaja) throws Exception{
        Empleado empleBajaDias = this.buscarEmpleado(nroLegajoEmpleado);
        if(empleBajaDias != null){//si existe el empleado
            DiasCorrespondiente diasBajaBusc = empleBajaDias.buscarDiasCorrespondiente(diasBaja.getFechaAnio());
            if(!isNull(diasBajaBusc)){//si existe dias asociados de ese anio
                diasBajaBusc.setEstado(false);
                System.out.println("\t\t└> Se cambió el estado del dia correspondiente '"+
                    diasBajaBusc.getFechaAnio().getTime() + "' a '"+diasBajaBusc.isEstado()+"'");
            }else{
                throw new Exception("El empleado con el nro de legajo '"
                                + nroLegajoEmpleado+"' no posee días correspondientes"
                                + " asociados al año '"+diasBajaBusc.getFechaAnio().getTime()
                                +"' (Posee '"+diasBajaBusc.getDias()+"' días del año");
            }
        }else{
            throw new Exception("No se econtró un empleado con el nro de legajo '"
                                + nroLegajoEmpleado+"' a dar de baja los días correspondientes");
        }
    }
    
    //
    
}
