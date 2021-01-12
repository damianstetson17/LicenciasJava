/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damian.licencias.JpaController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Piotr
 */
public class Conexion {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public Conexion() {
         System.out.print("estoy en conexion");
        Conexion.conectar();
    }

    private static void conectar() {
        if (em == null) {
            Conexion.emf = Persistence.createEntityManagerFactory("com.mycompany_PLicencias_jar_1.0-SNAPSHOTPU");
            Conexion.em = Conexion.emf.createEntityManager();
             System.out.print("conecte");
        }else{
            System.out.print("else conecte");
        }
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void setEmf(EntityManagerFactory emf) {
        Conexion.emf = emf;
    }

    public static EntityManager getEm() {
        return em;
    }

    public static void setEm(EntityManager em) {
        Conexion.em = em;
    }
    
    //obtener hora del servidor
    public static Query Date_NOW(){
        String Cons = "SELECT NOW()";
        Query qy = em.createNativeQuery(Cons);
        return qy;
    }

}