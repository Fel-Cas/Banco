/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejo;

import Clientes.Cliente;
import Clientes.Compania;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class AdministracionCompanias implements ManejoClientes {
    private ArrayList<Compania> companias;//Lista de todos los clientes(Compania) que estan inscritos en el banco.
    private static  AdministracionCompanias adminCompanias;//Atributo del mismo tipo de la clase para poder implementar el patrón singletón
    /**
     * Método constructor.
     */
    private AdministracionCompanias() {
    }
    /***
     *  Método utilizado para obtener la instacia de la clase AdministracionCompanias.
     **/
    public static AdministracionCompanias getAdminCompanias(){
        if(adminCompanias==null){
            adminCompanias=new AdministracionCompanias();
            
        }
        return adminCompanias;
    }
    
    /**
     * Método encargado de agregar un nuevo cliente del tipo Compania a la lista.
     */
    @Override
    public void agregarCliente(Cliente cliente) {
        companias.add((Compania)cliente);
    }   
    /**
     * Método encargado de buscar un  cliente en la lista.
     */
    @Override
    public Cliente buscarCliente(String identificacion) {
        Compania cliente=null;
        int i=0;
        while(i<companias.size()){
            if(companias.get(i).getNit().equals(identificacion)){
                cliente=companias.get(i);
                return cliente;
            }
            i++;
        }
        return cliente;
    }
    /**
     * Método utilizado para obtener la lista de clientes.
     */
    public ArrayList<Compania> getCompanias() {
        return companias;
    }
    /**
     * Método encargado de cambiar la lista de clientes.
     */
    public void setCompanias(ArrayList<Compania> companias) {
        this.companias = companias;
    }
    

}
