package com.mycompany.casospoliciales;
// Generated 05-abr-2018 16:59:44 by Hibernate Tools 4.3.1



/**
 * Colabora generated by hbm2java
 */
public class Colabora  implements java.io.Serializable {


     private ColaboraId id;
     private String descripcionColaboracion;

    public Colabora() {
    }

	
    public Colabora(ColaboraId id) {
        this.id = id;
    }
    public Colabora(ColaboraId id, String descripcionColaboracion) {
       this.id = id;
       this.descripcionColaboracion = descripcionColaboracion;
    }
   
    public ColaboraId getId() {
        return this.id;
    }
    
    public void setId(ColaboraId id) {
        this.id = id;
    }
    public String getDescripcionColaboracion() {
        return this.descripcionColaboracion;
    }
    
    public void setDescripcionColaboracion(String descripcionColaboracion) {
        this.descripcionColaboracion = descripcionColaboracion;
    }




}


