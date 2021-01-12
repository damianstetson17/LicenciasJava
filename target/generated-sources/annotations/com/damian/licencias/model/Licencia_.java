package com.damian.licencias.model;

import com.damian.licencias.model.DiasTomados;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-11T20:57:42")
@StaticMetamodel(Licencia.class)
public class Licencia_ { 

    public static volatile SingularAttribute<Licencia, Integer> cantDiasPedidos;
    public static volatile SingularAttribute<Licencia, Long> id;
    public static volatile SingularAttribute<Licencia, Calendar> fechaFin;
    public static volatile SingularAttribute<Licencia, Calendar> fechaInico;
    public static volatile SingularAttribute<Licencia, DiasTomados> diasTomados;

}