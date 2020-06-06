/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejo;

import Operaciones.Operacion;
import Banco.Sucursal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author andres
 */
public class AdministracionOperaciones implements ManejoOperaciones{
    private ArrayList<Operacion>operaciones;//Listado de todas la operaciones que se hacen en la sucursal.
    private static AdministracionOperaciones adminOperaciones;
    /**
     * Método constructor.
     **/
    private AdministracionOperaciones() {
       
    }
    
    /***
     *  Método utilizado para obtener la instacia de la clase AdministracionOperaciones.
     **/
    public static AdministracionOperaciones getAdministracionOperaciones(){
        if(adminOperaciones==null){
            adminOperaciones=new AdministracionOperaciones();
        }
        return adminOperaciones;
    }
    /**
     * Método utilizado para obtener el listado de operaciones.
     **/
    public ArrayList<Operacion> getOperaciones() {
        return operaciones;
    }
    /**
     * Método encargado de cambiar el listado de operaciones.
     **/
    public void setOperaciones(ArrayList<Operacion> operaciones) {
        this.operaciones = operaciones;
    }
    /**
     * Método encargado de buscar una operacion en específico.
     **/
    @Override
    public Operacion buscarOperacion(Date fecha, String codigo) {
        int i=0;
        while(i<operaciones.size()){
            if(operaciones.get(i).getFecha().equals(fecha)){
                return operaciones.get(i);
            }
        }
        return null;
    }
    /**
     * Método encargado de agregar una nueva operación en la lista de operaciones.
     **/
    @Override
    public void agregarOperacionOperacion(String nombre, String codigoCuenta, double cantidad) {
        switch(nombre){
            case"Consignar":
                Operacion consignar=new Operacion(nombre,codigoCuenta,cantidad);
                consignar.hacerIdetificador();
                operaciones.add(consignar);
                break;
            case"Retirar":
                Operacion retirar =new Operacion(nombre,codigoCuenta,cantidad);
                retirar.hacerIdetificador();
                operaciones.add(retirar);
                break;
            case"ActivarCuenta":
                Operacion activarCuenta=new Operacion(nombre,codigoCuenta,cantidad);
                activarCuenta.getIdentificador();
                operaciones.add(activarCuenta);
                break;
            case"DesactivarCuenta":
                Operacion desactivarCuenta=new Operacion(nombre,codigoCuenta,cantidad);
                desactivarCuenta.hacerIdetificador();
                operaciones.add(desactivarCuenta);
                break;
            case"CrearCliente":
                Operacion crearCliente=new Operacion(nombre,codigoCuenta,cantidad);
                crearCliente.hacerIdetificador();
                operaciones.add(crearCliente);
                break;
            case"CrearCuenta":
                Operacion crearCuenta=new Operacion(nombre,codigoCuenta,cantidad);
                crearCuenta.hacerIdetificador();
                operaciones.add(crearCuenta);
                break;
             
        }
    }
    
    
}
