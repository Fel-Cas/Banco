/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejo;

import Clientes.Cliente;
import Clientes.PersonaNatural;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class AdministracionClientes implements ManejoClientes {
    private ArrayList<PersonaNatural> clientes;//Lista de todos los clientes(Persona natural) que estan inscritos en el banco.
    private static  AdministracionClientes adminClientes;//Atributo del mismo tipo de la clase para poder implementar el patrón singletón
    /**
     * Método constructor.
     */
    private AdministracionClientes() {
    }
    /***
     *  Método utilizado para obtener la instacia de la clase AdministracionClientes.
     **/
    public static AdministracionClientes getAdminClientes(){
        if(adminClientes==null){
            adminClientes=new AdministracionClientes();
            return adminClientes;
        }
        return adminClientes;
    }
    /**
     * Método encargado de agregar un nuevo cliente a la lista.
     */
    @Override
    public void agregarCliente(Cliente cliente) {
        clientes.add((PersonaNatural)cliente);
    }
    /**
     * Método encargado de buscar un  cliente en la lista.
     */
    @Override
    public Cliente buscarCliente(String identificacion) {
        PersonaNatural cliente=null;
        int i=0;
        while(i<clientes.size()){
            if(clientes.get(i).getDocumento().equals(identificacion)){
                cliente=clientes.get(i);
                return cliente;
            }
            i++;
        }
        return null;
    }
    /**
     * Método utilizado para obtener la lista de clientes.
     */
    public ArrayList<PersonaNatural> getClientes() {
        return clientes;
    }
    /**
     * Método encargado de cambiar la lista de clientes.
     */
    public void setClientes(ArrayList<PersonaNatural> clientes) {
        this.clientes = clientes;
    }
}
