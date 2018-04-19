/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.casospoliciales;

import java.util.Scanner;

/**
 *
 * @author gonza
 */
class Menus {
     public void menu1(){
        String op=null;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println(" P R Á C T I C A  3 \n");
            System.out.println(" ***  M E N U  ***");
            System.out.println(" 1- Guarda experto");
            System.out.println(" 2- Elimina experto");
            System.out.println(" 3- Actualiza experto");
            System.out.println(" 4- Obtener experto\n\n");
            System.out.println(" 0- Salir");
            System.out.println("");
            System.out.print("Elige opcion: ");
            op=sc.next();
            if(!op.equals("0")){
                manejaExperto manejaexperto = new manejaExperto();
                switch (op) {
                    case "1":
                        {
                            System.out.println("\nNUEVO EXPERTO:");
                            System.out.println("-----------------------------------------");
                            System.out.println("CODEXPERTO: ");
                            String codigo = sc.next();
                            
                            System.out.println("NOMBRE: ");
                            String nombre = sc.next();
                            
                            String sexo;
                            do{
                                System.out.println("SEXO: (Masculino: m / Femenino: f)");
                                sexo = sc.next();
                            }while(!sexo.equalsIgnoreCase("m") && !sexo.equalsIgnoreCase("f"));
                            Character sexoChar = sexo.toUpperCase().charAt(0);
                            
                            System.out.println("PAIS: ");
                            String pais = sc.next();
                            
                            System.out.println("ESPECIALIDAD: ");
                            String especialidad = sc.next();
                            
                            //System.out.println(codigo + " " + nombre + " " + sexoChar + " " + pais + " " + especialidad);
                            Experto experto1 = new Experto(codigo, nombre, sexoChar, pais, especialidad);
                            manejaexperto.guardaExperto(experto1);
                            
                            System.out.println("\nPulsa una tecla para continuar...");
                            String pausa = sc.next();
                            break;
                        }
                    case "2":
                        {
                            Boolean encontrado = false;
                            String codexperto;
                            Experto experto1;
                            
                            System.out.println("\n\nELIMINAR UN EXPERTO:");
                            System.out.println("-----------------------------------------");
                            do{
                                System.out.print("Introduzca el CODEXPERTO: ");
                                codexperto = sc.next();

                                experto1 = manejaexperto.obtenExperto(codexperto);
                                if(experto1 != null){
                                    System.out.println("\nResultado de la búsqueda:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("CODEXPERTO: "+experto1.getCodexperto());
                                    System.out.println("NOMBRE: " + experto1.getNombre());
                                    System.out.println("SEXO: " + experto1.getSexo());
                                    System.out.println("ESPECIALIDAD: " + experto1.getEspecialidad());
                                    System.out.println("PAIS: " + experto1.getPais());
                                    encontrado = true;
                                }
                                else{
                                    System.out.println("\n>>No se encontró ningún experto con ese código.");
                                    encontrado = false;
                                }
                            } while (encontrado != true);
                            
                            String eliminar;
                            do{
                                System.out.println("\n¿Está seguro que desea eliminar a este experto? (Sí: S /No: N)");
                                eliminar = sc.next();
                            }while(!eliminar.equalsIgnoreCase("s") && !eliminar.equalsIgnoreCase("n"));
                            
                            if(eliminar.equalsIgnoreCase("s")){
                                manejaexperto.eliminaExperto(experto1);
                            }
                            else{
                                System.out.println(">> No se eliminó a ningún experto.");
                            }
                            
                            System.out.println("\nPulsa una tecla para continuar...");
                            String pausa = sc.next();
                            break;
                        }
                    case "3":
                        {
                            Experto experto1 = new Experto();
                            String codexperto;
                            Boolean encontrado = false;
                            Integer cambiar;
                            
                            System.out.println("\n\nACTUALIZAR UN EXPERTO:");
                            System.out.println("-----------------------------------------");
                            do{
                                System.out.print("Introduzca el CODEXPERTO: ");
                                codexperto = sc.next();

                                experto1 = manejaexperto.obtenExperto(codexperto);
                                if(experto1 != null){
                                    System.out.println("\nResultado de la búsqueda:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("CODEXPERTO: "+experto1.getCodexperto());
                                    System.out.println("NOMBRE: " + experto1.getNombre());
                                    System.out.println("PAIS: " + experto1.getPais());
                                    System.out.println("SEXO: " + experto1.getSexo());
                                    System.out.println("ESPECIALIDAD: " + experto1.getEspecialidad());
                                    encontrado = true;
                                }
                                else{
                                    System.out.println("\n>> No se encontró ningún experto con ese código.");
                                    encontrado = false;
                                }

                                System.out.println("\nPulsa una tecla para continuar...");
                                String pausa = sc.next();
                            } while (encontrado != true);
                            
                            System.out.println("¿Que quiere cambiar?");
                            System.out.println("1- Codigo   2- Nombre   3- Pais");
                            System.out.println("4- Sexo     5- Especialidad");
                            cambiar = sc.nextInt();
                            switch(cambiar){
                                    case 1:
                                    {
                                        System.out.print("Modificar CODEXPERTO: ");
                                        String codigo = sc.next();
                                        experto1.setCodexperto(codigo);
                                        break;
                                    }
                                    case 2:
                                    {
                                        System.out.print("Modificar NOMBRE: ");
                                        String nombre = sc.next();
                                        experto1.setNombre(nombre);
                                    }
                                    case 3:
                                    {
                                        String pais;
                                        System.out.print("Modificar PAIS: ");
                                        pais = sc.next();
                                        experto1.setPais(pais);
                                    }
                                    case 4:
                                    {
                                        String sexo;
                                        do{
                                            System.out.println("Modificar SEXO: (Masculino: m / Femenino: f)");
                                            sexo = sc.next();
                                        }while(!sexo.equalsIgnoreCase("m") && !sexo.equalsIgnoreCase("f"));
                                        
                                        experto1.setSexo(sexo.charAt(0));
                                        break;
                                    }
                                    case 5:
                                    {
                                        String especialidad;
                                        System.out.print("Modificar ESPECIALIDAD: ");
                                        especialidad = sc.next();
                                        experto1.setEspecialidad(especialidad);
                                    }
                                    default:
                                        break;
                            }
                            
                            manejaexperto.actualizaExperto(experto1);
                            System.out.println("\nPulsa una tecla para continuar...");
                            String pausa = sc.next();
                            
                            break;
                        }
                    case "4":
                        {
                            Experto experto1;
                            String codexperto;
                            
                            System.out.print("Introduzca el CODEXPERTO: ");
                            codexperto = sc.next();
                            
                            experto1 = manejaexperto.obtenExperto(codexperto);
                            if(experto1 != null){
                                System.out.println("\nRESULTADO DE LA BÚSQUEDA:");
                                System.out.println("-----------------------------------------");
                                System.out.println("CODEXPERTO: "+experto1.getCodexperto());
                                System.out.println("NOMBRE: " + experto1.getNombre());
                                System.out.println("SEXO: " + experto1.getSexo());
                                System.out.println("ESPECIALIDAD: " + experto1.getEspecialidad());
                                System.out.println("PAIS:" + experto1.getPais());
                            }
                            else{
                                System.out.println("\n>>No se encontró ningún experto con ese código.");
                            }
                            
                            System.out.println("\nPulsa una tecla para continuar...");
                            String pausa = sc.next();
                            
                            break;
                        }
                    default:
                        break;
                }
            }
        }while(!op.equals("0"));
    }
}
