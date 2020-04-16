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
public class ManejoOperaciones{
    private ArrayList<Operacion>operaciones;

    public ManejoOperaciones(ArrayList<Operacion> operaciones) {
        this.operaciones = operaciones;
    }

    public ArrayList<Operacion> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(ArrayList<Operacion> operaciones) {
        this.operaciones = operaciones;
    }
    
    public Operacion buscar(String fecha) {
        int i=0;
        while(i<operaciones.size()){
            if(operaciones.get(i).getFecha().equals(fecha)){
                return operaciones.get(i);
            }
        }
        return null;
    }

    public void insertar(Object objeto) {
        operaciones.add((Operacion)objeto);
    }
    
    
}
