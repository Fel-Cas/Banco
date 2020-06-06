/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejo;

import Clientes.Cliente;

/**
 *
 * @author andres
 */
public class FachadaClientes {
    private AdministracionClientes clientes;//Objeto que se encarga de la manipulación todos los clientes tipo persona natural
    private AdministracionCompanias companias;//Objeto que se encarga de la manipulación todos los clientes tipo compania.
    private static FachadaClientes fachada;//Instancia de la clase FachadaClientes que permite el singleton
    /**
     * Método constructor.
     **/
    private FachadaClientes(){
        
    }
    /***
     * Método encargado de devolver la instancia de la clase FachadaClientes.
     **/
    public static FachadaClientes getFachadaClientes(){
        if(fachada==null){
            fachada=new FachadaClientes();
        }
        return fachada;
    }
    /***
     * Método encargado de agregar un cliente a cada una de las listas correspondientes,
     * según el tipo que sea(Persona natural o compania).
     **/
    public void agregarCliente(Cliente cliente, String tipo){
        if(tipo.equals("Compania")){
            companias.agregarCliente(cliente);
        }else{
            clientes.agregarCliente(cliente);
        }
    }
    /***
     * Método encargado de buscar un cliente específico en cada una de las listas correspondientes,
     * según el tipo que sea(Persona natural o compania).
     **/
    public Cliente buscarCliente(String cedula,String tipo){
        Cliente usuario=null;
        if(tipo.equals("Compania")){
            usuario=companias.buscarCliente(cedula);
        }else{
            usuario=clientes.buscarCliente(cedula);
        }
        return usuario;
    }
    /**
     * Método que permite obtener el objeto encargado de administrar los clientes tipo persona natural.
     **/
    public AdministracionClientes getClientes() {
        return clientes;
    }
    /**
     * Método que permite cambiar el objeto encargado de administrar los clientes tipo persona natural.
     **/
    public void setClientes(AdministracionClientes clientes) {
        this.clientes = clientes;
    }
    /**
     * Método que permite obtener el objeto encargado de administrar los clientes tipo compania.
     **/
    public AdministracionCompanias getCompanias() {
        return companias;
    }
    /**
     * Método que permite cambiar el objeto encargado de administrar los clientes tipo compania.
     **/
    public void setCompanias(AdministracionCompanias companias) {
        this.companias = companias;
    }
    
    
}
