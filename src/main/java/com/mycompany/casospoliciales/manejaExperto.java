/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.casospoliciales;

import java.sql.PreparedStatement;
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
    
    
}
