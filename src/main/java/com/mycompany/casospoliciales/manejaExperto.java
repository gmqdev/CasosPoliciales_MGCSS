/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.casospoliciales;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author gonza
 */
public class manejaExperto {
    private Session sesion;
    
    private Transaction tx;

    public manejaExperto() {
    }
    
    public void iniciaOperacion() throws HibernateException {
        System.out.println("Comenzando con Hibernate");
        sesion = NewHibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }
    
    public void manejaExcepcion(HibernateException he) throws HibernateException{
        tx.rollback();
        System.out.println("Ocurrió un error en el acceso a datos" + he.getMessage());
        System.exit(0);
    }
    
    public void finalizaOperacion() throws HibernateException{
        tx.commit();
        sesion.close();
        System.out.println("Cerrando sesión");
    }
    
    public void guardaExperto(Experto experto){
        try {
            iniciaOperacion();
            sesion.save(experto);
            System.out.println("Experto guardado");
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        }
        finally{
            finalizaOperacion();
        }
    }
    
    public void eliminaExperto(Experto experto){
        try {
            iniciaOperacion();
            sesion.delete(experto);
            System.out.println("Experto eliminado");
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        }
        finally{
            finalizaOperacion();
        }
    }
    
    public void actualizaExperto(Experto experto){
        try {
            iniciaOperacion();
            sesion.update(experto);
            System.out.println("Experto actualizado");
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        }
        finally{
            finalizaOperacion();
        }
    }
    
    public Experto obtenExperto(String idExperto){
        Experto experto;
        
        try {
            iniciaOperacion();            
            experto = (Experto) sesion.get(Experto.class, idExperto);
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        }
        finally{
            finalizaOperacion();
        }
        
        return experto;
    }
    
    //Mostrar todos los nombres y especialidades de cada uno de los expertos de la tabla Experto
    public void obtenNombresyEspecialidad(){
        
        try {
            iniciaOperacion();
            Query query = sesion.createQuery("from Experto");   // Hago la consulta HQL, me devuelve un objeto con una lista.
            List<Experto> expertos = (List<Experto>) query.list(); // Una lista donde cargar la información.
            System.out.println("\nNombre\t\tEspecialidad");
            System.out.println("----------------------------------");
            for(Experto experto:expertos){
                System.out.println(experto.getNombre() + "\t\t" + experto.getEspecialidad());
            }
            System.out.println("\n\nFin obtenNombresyEspecialidad");
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        }
        finally{
            finalizaOperacion();
        }
    }
    
    public void listaConParametro(String keyword){
        
        try {
            iniciaOperacion();
            Query query = sesion.createQuery("from Experto where especialidad='" + keyword+ "'");
            List<Experto> expertos = (List<Experto>) query.list();
            System.out.println("\nNombre\t\t\tEspecialidad");
            System.out.println("-------------------------------------------");
            for(Experto experto:expertos){
                System.out.println(experto.getNombre() + "\t\t" + experto.getEspecialidad());
            }
            System.out.println("\n\nFin listaConParametro");
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        }
        finally{
            finalizaOperacion();
        }
    }
    
    public void obtenCasos(){
        Experto experto;
        
        try {
            iniciaOperacion();
            Query query = sesion.createQuery("from Colabora");
            List<Colabora> colaboradores = (List<Colabora>) query.list();
            System.out.println("\nNombre\t\t\tCódigo Caso");
            System.out.println("-------------------------------------------");
            for(Colabora colaborador:colaboradores){
                experto = (Experto) sesion.get(Experto.class, colaborador.getId().getCodexperto());
                //System.out.println(obtenExperto(colaborador.getId().getCodexperto()).getNombre() + "\t\t" + colaborador.getId().getCodcaso());
                System.out.println(experto.getNombre() + "\t\t" + colaborador.getId().getCodcaso());
            }
            System.out.println("\n\nFin obtenCasos");
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        }
        finally{
            finalizaOperacion();
        }
    }
}
