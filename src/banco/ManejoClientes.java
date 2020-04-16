/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class ManejoClientes {
    private ArrayList<Cliente>clientes;

    public ManejoClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    public boolean buscar(String id) {
        int i=0;
        while(i<clientes.size()){
            if(clientes.get(i).getId().equals(id)){
                return true;
            }
            i++;
        }
        return false;
    }

    public void insertar(Object objeto) {
        clientes.add((Cliente)objeto);
    }
    
}
