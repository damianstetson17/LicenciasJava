package com.damian.licencias.model;

import com.damian.licencias.model.DiasCorrespondiente;
import com.damian.licencias.model.Licencia;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-11T20:57:42")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, Integer> nroLegajo;
    public static volatile SingularAttribute<Empleado, Boolean> estado;
    public static volatile SingularAttribute<Empleado, String> nombreApellido;
    public static volatile SingularAttribute<Empleado, Calendar> antiguedad;
    public static volatile SingularAttribute<Empleado, DiasCorrespondiente> diasCorrespondientes;
    public static volatile SingularAttribute<Empleado, Long> id;
    public static volatile SingularAttribute<Empleado, Licencia> licencias;

}