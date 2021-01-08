
import com.damian.licencias.model.DiasCorrespondiente;
import com.damian.licencias.model.DiasTomados;
import com.damian.licencias.model.Empleado;

import java.util.Calendar;

/**
 *
 * @author Damian
 */
public class Main {

    public static void main(String[] args) {
        
        DiasCorrespondiente diasNuevo = new DiasCorrespondiente(Calendar.getInstance(),10,true);
        Calendar calViejo = Calendar.getInstance();
        calViejo.set(Calendar.YEAR, 2010);
        
        DiasCorrespondiente diasViejo = new DiasCorrespondiente(calViejo,10,true);
        
        Empleado emple1 = new Empleado(1,"namis",Calendar.getInstance(),true);
        
        
        emple1.addDiasCorrespondiente(diasNuevo);
        emple1.addDiasCorrespondiente(diasViejo);

        emple1.getDiasCorrespondientes().forEach((d) -> {
            System.out.println(d.getFechaAnio().getTime());
        });
        
        System.out.println(emple1.getDiasCorrespondientes().size());
    }
}
  
    

