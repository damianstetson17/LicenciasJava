
import com.damian.licencias.controller.LicenciaController;
import com.damian.licencias.model.*;

import java.util.Calendar;


/**
 *
 * @author Damian
 */
public class Main {

    public static void main(String[] args) {
        //controlador
        LicenciaController controlador = new LicenciaController();
        
        //empleados
        Empleado emple1 = new Empleado(1,"namis",Calendar.getInstance(),true);
        Empleado emple2 = new Empleado(2,"angy",Calendar.getInstance(),true);
        
        //diasCorresp
        DiasCorrespondiente diasNuevo = new DiasCorrespondiente(Calendar.getInstance(),10,true);
        Calendar fechaviejaDiascorresp = Calendar.getInstance(); fechaviejaDiascorresp.set(2009,1,12);
        DiasCorrespondiente diasViejos = new DiasCorrespondiente(fechaviejaDiascorresp,5,true);
         
        //feriado
        Calendar fechaFeriado = Calendar.getInstance(); fechaFeriado.set(2021,0,12);
        Feriado feriadoNew = new Feriado("Dia del amigo",fechaFeriado);
        
        try {
            controlador.addEmpleado(emple1);
            controlador.addEmpleado(emple2);
            controlador.generarDiasCorrespondientesEmpleado(1, diasNuevo);
            controlador.generarDiasCorrespondientesEmpleado(1, diasViejos);
            controlador.addFeriado(feriadoNew);
            Calendar fechaIniLic = Calendar.getInstance(); fechaIniLic.set(2021,0,11);
            Licencia newLicencia = new Licencia(fechaIniLic, 5);
            controlador.generarLicenciaAuto(1, newLicencia);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        //RESULTADOS FINALES
        controlador.getEmpleados().forEach((e) -> {
            System.out.println("\nDIAS CORRESP DE EMPLEADO:"+ e.getNombreApellido());
            e.getDiasCorrespondientes().forEach((d) -> {
                System.out.println("\tEl empleado: "+e.getNombreApellido()+" tiene los dias corresp:");
                System.out.println("\tdel anio: "+d.getFechaAnio().get(Calendar.YEAR)+" tiene: "+d.getDias()+" dias con el estado: "+d.isEstado());
            });
            System.out.println("\t\tTotal: "+ e.getDiasCorrespondientes().size());
            
            System.out.println("\nLICENCIAS DE EMPLEADO: "+ e.getNombreApellido());
            e.getLicencias().forEach((l) -> {
            System.out.println("\tfechaInicio Lic"+l.getFechaInicio().getTime());
            System.out.println("\tfechaFin Lic"+l.getFechaFin().getTime());
            System.out.println("\tdiasPedidos Lic:"+ l.getCantDiasPedidos());
            });
            System.out.println("\t\tTotal: "+ e.getLicencias().size());
        });
    }
}
  
    

