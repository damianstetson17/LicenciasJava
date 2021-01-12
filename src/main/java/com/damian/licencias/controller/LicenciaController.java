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

    /**
     *  Buscar un feriado según una fecha.
     * @param fechaFeridadoBusc
     * @return feriadoBuscado
     */
    public Feriado buscarFeriado(Calendar fechaFeridadoBusc){
        System.out.println(("\t>>LLAMADO AL MÓDULO BUSCAR FERIADO"));
        Feriado feriadoBuscado = null;
        for(Feriado f : this.feriados){
            if((f.getFechaFeriado().get(Calendar.YEAR) == fechaFeridadoBusc.get(Calendar.YEAR))
                    &&((f.getFechaFeriado().get(Calendar.DAY_OF_YEAR) == fechaFeridadoBusc.get(Calendar.DAY_OF_YEAR)))
                    &&((f.getFechaFeriado().get(Calendar.MONTH) == fechaFeridadoBusc.get(Calendar.MONTH)))){
                feriadoBuscado=f;
                break;
            }
        }
        return feriadoBuscado;
    }
    
    /**
     * Agregar un feriado a la lista de feriados.
     * @param feriadoNew
     * @throws Exception
     */
    public void addFeriado(Feriado feriadoNew) throws Exception{
        System.out.println("\t>>LLAMADO AL MÓDULO CREAR FERIADO");
        Feriado feriadoDupli = this.buscarFeriado(feriadoNew.getFechaFeriado());
        if(isNull(feriadoDupli)){
            this.feriados.add(feriadoNew);
            System.out.println("\t\t>Se insertó el feriado '"+feriadoNew.getFechaFeriado().getTime()+"'");
        }else{
            throw new Exception("Ya existe un feriado con la fecha '"
                                + feriadoNew.getFechaFeriado().getTime()+"'");
        }
    }
    
    /**
     * Cambia el atributo "estado" de un feriado a false.
     * @param dechaFeriadoDel
     * @throws Exception
     */
    public void delFeriado(Calendar dechaFeriadoDel)throws Exception{
        System.out.println("\t>>LLAMADO AL MÓDULO BAJA FERIADO");
        Feriado feriadoExis = this.buscarFeriado(dechaFeriadoDel);
        if(feriadoExis != null){
            feriadoExis.setEstado(false);
            System.out.println("\t\t> Se cambió el estado del feriado '"+
                    feriadoExis.getFechaFeriado().getTime() + "'");
        }else{
            throw new Exception("No se encontró un feriado con la fecha '"
                                + dechaFeriadoDel+"'");
        }
    }
    
    //PERSONA

    /**
     * Busca un empleado por un número de legajo.
     * @param nroLegajoBuscado
     * @return empleadoBuscado
     */
    public Empleado buscarEmpleado(int nroLegajoBuscado){
        System.out.println(("\t>>LLAMADO AL MÓDULO BUSCAR EMPLEADO"));
        Empleado empleadoBuscado = null;
        for(Empleado e : this.empleados){
            if(e.getNroLegajo() == nroLegajoBuscado){
                empleadoBuscado=e;
                break;
            }
        }
        return empleadoBuscado;
    }
    
    /**
     * Agregar un empleado a la lista de empleados.
     * @param empleadoNew
     * @throws Exception
     */
    public void addEmpleado(Empleado empleadoNew) throws Exception{
        System.out.println("\t>>LLAMADO AL MÓDULO CREAR EMPLEADO");
        Empleado empleadoDupli = this.buscarEmpleado(empleadoNew.getNroLegajo());
        if(isNull(empleadoDupli)){
            this.empleados.add(empleadoNew);
            System.out.println("\t\t>Se insertó el empleado con el legajo '"+empleadoNew.getNroLegajo()+"'");
        }else{
            throw new Exception("Ya existe un empleado con el nro de legajo '"
                                + empleadoNew.getNroLegajo()+"'");
        }
    }
    
    /**
     * Modificar los atributos: "nro legajo","nombre y apellido","antiguedad"
     * y "estado".
     * @param empleMod
     * @throws Exception
     */
    public void modEmpleado (Empleado empleMod)throws Exception{
        System.out.println("\t>>LLAMADO AL MÓDULO MODIFICAR EMPLEADO");
        Empleado empleadoExis = this.buscarEmpleado(empleMod.getNroLegajo());
         if(empleadoExis != null){
            empleadoExis.setNroLegajo(empleMod.getNroLegajo());
            empleadoExis.setNombreApellido(empleMod.getNombreApellido());
            empleadoExis.setAntiguedad(empleMod.getAntiguedad());
            empleadoExis.setEstado(empleMod.isEstado());
            
            /*not implemented the modif of list licencias and diascorresp,
            they have their own methods*/
                    
            System.out.println("\t\t> Se cambió el estado del empleado '"+
                    empleadoExis.isEstado() + "'");
        }else{
            throw new Exception("No se econtró un empleado con el nro de legajo '"
                                + empleMod.getNroLegajo()+"' a modificar");
        }
    }
    
    /**
     * Cambia el atributo "estado" de un empleado a false.
     * @param nroLegajoEmpleDel
     * @throws Exception
     */
    public void delEmpleado(int nroLegajoEmpleDel) throws Exception{
        System.out.println("\t>>LLAMADO AL MÓDULO BAJA EMPLEADO");
        Empleado empleadoExis = this.buscarEmpleado(nroLegajoEmpleDel);
        if(empleadoExis != null){
            empleadoExis.setEstado(false);
            System.out.println("\t\t> Se cambió el estado del empleado a '"+
                    empleadoExis.isEstado() + "'");
        }else{
            throw new Exception("No se econtró un empleado con el nro de legajo '"
                                + nroLegajoEmpleDel+"' a borrar");
        }
    }
    
    //DIAS CORRESPONDIENTES DE EMPLEADO

    /**
     * Asigan días de un año a un empleado.
     * @param nroLegajoEmpleado
     * @param diasAgregar
     * @throws Exception
     */
    public void generarDiasCorrespondientesEmpleado(int nroLegajoEmpleado, DiasCorrespondiente diasAgregar) throws Exception{
       System.out.println("\t>>LLAMADO AL MÓDULO GENERAR DIAS CORRESPONDIENTES EMPLEADO");
        Empleado empleAgregarDias = this.buscarEmpleado(nroLegajoEmpleado);
        if(empleAgregarDias != null){//si existe el empleado
            DiasCorrespondiente diasDuplicado = empleAgregarDias.buscarDiasCorrespondiente(diasAgregar.getFechaAnio());
            if(isNull(diasDuplicado)){//si ya no existe dias asociados de ese anio
                empleAgregarDias.addDiasCorrespondiente(diasAgregar);
                System.out.println("\t\t> Se agregaron al empleado legajo nro '"+
                    empleAgregarDias.getNroLegajo()+ "'" + "'"+diasAgregar.getDias()+
                    "' días del año '"+diasAgregar.getFechaAnio().get(Calendar.YEAR)+"'");
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
    
    /**
     * Cambia el atributo "estado" de un DiasCorrespondiente a false.
     * @param nroLegajoEmpleado
     * @param diasBaja
     * @throws Exception
     */
    public void bajaDiasCorrespondientesEmpleado(int nroLegajoEmpleado, DiasCorrespondiente diasBaja) throws Exception{
        System.out.println("\t>>LLAMADO AL MÓDULO BAJA DIAS CORRESPONDIENTES EMPLEADO");
        Empleado empleBajaDias = this.buscarEmpleado(nroLegajoEmpleado);
        if(empleBajaDias != null){//si existe el empleado
            DiasCorrespondiente diasBajaBusc = empleBajaDias.buscarDiasCorrespondiente(diasBaja.getFechaAnio());
            if(!isNull(diasBajaBusc)){//si existe dias asociados de ese anio
                diasBajaBusc.setEstado(false);
                System.out.println("\t\t> Se cambió el estado del dia correspondiente '"+
                    diasBajaBusc.getFechaAnio().getTime() + "' a '"+diasBajaBusc.isEstado()+"'");
            }else{
                throw new Exception("El empleado con el nro de legajo '"
                                + nroLegajoEmpleado+"' no posee días correspondientes"
                                + " asociados al año '"+diasBajaBusc.getFechaAnio().getTime()
                                +"' (Posee '"+diasBajaBusc.getDias()+"' días del año");
            }
        }else{
            throw new Exception("No se encontró un empleado con el nro de legajo '"
                                + nroLegajoEmpleado+"' a dar de baja los días correspondientes");
        }
    }
    
    //Licencia

    /**
     * Función que controla y retorna verdadero si existen suficientes
     * días tomables para generar una licencia.
     * @param diasCorrespTotalesEmple
     * @param newLicencia
     * @return verifica
     * @throws Exception
     */
    public boolean verificarCantidadDiasLic(List<DiasCorrespondiente> diasCorrespTotalesEmple, Licencia newLicencia) throws Exception{
        System.out.println("\t\t>>LLAMADO AL MÓDULO VERIFICAR CANT DIAS LIC ");
        boolean verifica = false;
        int totalDiasDisponibles = 0;
        int diasPedidos = newLicencia.getCantDiasPedidos();
        for (DiasCorrespondiente d : diasCorrespTotalesEmple){
            if(d.isEstado() == true){ //si tienes dias ocupables
                totalDiasDisponibles += d.getDias();
                if(totalDiasDisponibles >= diasPedidos){
                    verifica = true;
                    System.out.println("\t\t\t>Existen suficientes días disponibles"
                    + " para generar\n\t\t\t la licencia solicitada ('"+newLicencia.getFechaInicio().getTime()
                            +"' que solicita '"+diasPedidos+"' dias.");
                    break;
                }
            }
        }
        if(verifica == false){
            throw new Exception("No existen suficientes días disponibles para"
                    + " generar la licencia solicitada ('"+newLicencia.getFechaInicio().getTime()
                            +"' requiere '"+diasPedidos+"'");
        }
        return verifica;
    }
    
    /**
     * Función principal que genera("inserta") una licencia a partir de una licencia con su fecha inicio
     * y la cantidad de días solicitados, esta es la que invoca cuando se desea agregar una
     * licencia a un empleado.
     * @param nroLegajoBuscado
     * @param newLicencia
     * @throws java.lang.Exception
     */
    public void generarLicenciaAuto(int nroLegajoBuscado, Licencia newLicencia) throws Exception{
        System.out.println("\t>>LLAMADO AL MÓDULO GENERAR LICENCIA");
        Empleado empleado = this.buscarEmpleado(nroLegajoBuscado);
        if(empleado != null){//si existe el empleado
            Licencia licdupli = empleado.buscarLicencia(newLicencia.getFechaInicio());
            if(licdupli == null){//si no existe una licencia con la misma fecha de inicio
                //si existen la cantidad de dias que pide la licencia
                if(this.verificarCantidadDiasLic(empleado.getDiasCorrespondientes(),
                        newLicencia) == true){
                    //calculamos su fecha fin
                    newLicencia = this.calcularFechaFinLicencia(newLicencia);
                    //generamos sus dias tomados
                    newLicencia = this.insertarDiasALicencia(nroLegajoBuscado,newLicencia);
                    //insertamos la nueva licencia a la lista del empleado
                    empleado.addLicencia(newLicencia);
                    System.out.println("\t\t>Se insertó la licencia del '"
                            +newLicencia.getFechaFin().getTime()+"\n\t\t' al empleado legajo '"
                            +empleado.getNroLegajo()+"'");
                }
            }else{
                throw new Exception("Ya existe una licencia con la fecha '"
                        +licdupli.getFechaInicio().getTime()+"'");
            }
        }
    }

    /**
     * Función que calcula la fecha fin que tendrá una licencia generada a partir
     * de la cantidad de días pedidos que posee y su fecha inicio.
     * @param newLicencia
     * @return newLicencia
     * @throws java.lang.Exception
     */
    private Licencia calcularFechaFinLicencia(Licencia newLicencia) {
        System.out.println("\t>>LLAMADO AL MÓDULO CALCULAR FECHA FIN LICENCIA");
        int cantDiasPedidosAuxCont = newLicencia.getCantDiasPedidos() - 1;
        Calendar newFechaFin = Calendar.getInstance();
        newFechaFin.setTime(newLicencia.getFechaInicio().getTime());
        
        while (cantDiasPedidosAuxCont > 0){
              /*si es sábado o domingo, hay que incrementar la fecha una vez más,
                el empleado no puede volver un fin de semana*/
            if( newFechaFin.get(Calendar.DAY_OF_WEEK) > 5){
                //si es sábado o domingo, incrementamos otro día, pero no restamos al contador
                newFechaFin.add(Calendar.DAY_OF_YEAR, 1);
            }else{
                /*el empleado tampoco puede volver un feriado, buscamos la nueva
                fecha en feriados, si está es porque existe un feriado con esa fecha*/
                if(this.buscarFeriado(newFechaFin) != null){
                    System.out.println("\t\t>Existe un feriado el día '"
                    +this.buscarFeriado(newFechaFin).getFechaFeriado().getTime()+" - "+this.buscarFeriado(newFechaFin).getDescripcion()+"\n\t\t' salteando día.");
                    newFechaFin.add(Calendar.DAY_OF_YEAR, 1);
                }else{
                    /*si es un dia útil sumamos un día a la fecha inicial,
                    y restamos uno a los que se piden de licencia*/
                    newFechaFin.add(Calendar.DAY_OF_YEAR, 1);
                    cantDiasPedidosAuxCont = cantDiasPedidosAuxCont - 1;
                }
            }
        }
        //guardamos la nueva fecha en la licencia
        newLicencia.setFechaFin(newFechaFin);
        System.out.println("\t\t>Retorno la licencia (Del '"+newLicencia.getFechaInicio().getTime()+"') "
              +"con\n\t\t su nueva fecha final calculada: '"+newLicencia.getFechaFin().getTime()+"')");
        return newLicencia;
    }

    /**
     * Función que inserta los diasTomados a la licencia y actualiza los dias correspondientes
     * del empleado.
     * @param nroLegajoBuscado
     * @param newLicencia
     * @return newLicencia
     * @throws java.lang.Exception
     */
    private Licencia insertarDiasALicencia(int nroLegajoBuscado, Licencia newLicencia) {
        System.out.println("\t>>LLAMADO AL MÓDULO INSERTAR LICENCIA");
        Empleado empleado = this.buscarEmpleado(nroLegajoBuscado);
        int cantDiasPedidos = newLicencia.getCantDiasPedidos();
        int diasPedidosCorresp = 0;
        //recorremos todos los dias correspondientes del empleado
        for(DiasCorrespondiente dias : empleado.getDiasCorrespondientes()){
            /*si no se tomaron la cantidad de días para la lic, y ese dia corresp
            tiene aun dias tomables(se setea sola el estado en false si llega a cero)*/
            while((cantDiasPedidos > 0) && (dias.isEstado() == true)){
                cantDiasPedidos = cantDiasPedidos - 1;
                dias.setDias(dias.getDias() - 1);
                diasPedidosCorresp = diasPedidosCorresp + 1;
            }
            /*cuando se terminan los de esos días se registra en la lista
            de lincencia de q años se tomaron los dias*/
            if(diasPedidosCorresp > 0){
                DiasTomados newDiasTomados = new DiasTomados(diasPedidosCorresp, dias);
                newLicencia.addDiasTomados(newDiasTomados);
                System.out.println("\t\t>Se tomaron '"+newDiasTomados.getCantidadDias()+" '"
                        +"dias del año '"+newDiasTomados.getAnioDiasCorresp().getFechaAnio().getTime()+"'");
            }
            for(DiasTomados dTomadosEnLic : newLicencia.getDiasTomados()){
                Calendar anio = dTomadosEnLic.getAnioDiasCorresp().getFechaAnio();
                System.out.println("\t\t\t>La licencia '"+newLicencia.getFechaInicio().getTime()
                        +"' \n\t\t\ttiene '"+ dTomadosEnLic.getCantidadDias()+"' días del año '"+anio.getTime()+"'");
            }
            diasPedidosCorresp = 0;
            if(cantDiasPedidos == 0){
                System.out.println("\t\t└>La licencia del día '"+newLicencia.getFechaInicio().getTime()
                        +"' ya tomo\n\t\t todos los días necesarios ('"+newLicencia.getCantDiasPedidos()+"' días)");
                // si ya se llego a los dias pedidos, salimos del bucle (más óptimo)
                break;
            }
        }
        return newLicencia;
    }
    
     /**
     * Función que fuerza la inserción de diasTomados a una licencia y actualiza los dias correspondientes
     * del empleado.
     * @param newLicencia
     * @param diasTomados
     * @return newLicencia
     * @throws java.lang.Exception
     */
    public Licencia agregarDiasCorrespALicencia(Licencia newLicencia, DiasTomados diasTomados) throws Exception{
        System.out.println("\t>>LLAMADO AL MÓDULO INSERTAR DIAS A LICENCIA");
        //si es posible sacarle los días a esos diascorresp
        if((diasTomados.getAnioDiasCorresp().getDias() - diasTomados.getCantidadDias()) >= 0){
            //si ya no existen esos dias en la licencia
            if(newLicencia.buscarDiasTomados(diasTomados) == null){
                //actualizamos los dias corresp
                diasTomados.getAnioDiasCorresp().setDias((diasTomados.getAnioDiasCorresp().getDias()-diasTomados.getCantidadDias()));
                //agregamos los dias tomados a la lic
                newLicencia.addDiasTomados(diasTomados);
                System.out.println("\t\t>Se actualizaron los días correspondientes del año '"
                        +diasTomados.getAnioDiasCorresp().getFechaAnio().get(Calendar.YEAR)
                        +"' a '"+diasTomados.getAnioDiasCorresp().getDias()+"' días (Se insertaron en la licencia '"+newLicencia.getFechaInicio().getTime()+"')");
                }else{
                    throw new Exception("El día correspondiente '"
                            + diasTomados.getAnioDiasCorresp().getFechaAnio().get(Calendar.YEAR)
                            +"' no cuenta con la cantidad de días suficientes para ser quitados ("
                            +diasTomados.getCantidadDias()+" días pedidos)");
                }
        }
        return newLicencia;
    }
    
}
