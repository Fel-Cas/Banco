/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejo;

import Cuentas.Cuenta;
import Cuentas.CuentaCorriente;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class AdministracionCuentasCorrientes implements ManejoCuenta {
    private ArrayList<CuentaCorriente> cuentas;//Listado de todas la cuentas corrientes con las que cuenta la sucursal.
    private static  AdministracionCuentasCorrientes cuentasCorrientes;
    /**
     * Método constructor.
     **/
    private AdministracionCuentasCorrientes() {
    }
    
    /***
     *  Método utilizado para obtener la instacia de la clase AdministracionCuentasCorrientes.
     **/
    public static AdministracionCuentasCorrientes getAdministracionCuentasCorrientes(){
        if(cuentasCorrientes==null){
            cuentasCorrientes=new  AdministracionCuentasCorrientes();
        }
        return cuentasCorrientes;
    }
    
    /**
     * Método encargado de agregar una cuenta a la lista de Cuentas.
     **/
    @Override
    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add((CuentaCorriente)cuenta);
    }
    /**
     * Método utilizado para buscar una cuenta específica.
     **/
    @Override
    public Cuenta buscarCuenta(String codigo) {
        int i=0;
        while(i<cuentas.size()){
            if(cuentas.get(i).getIdentificador().equals(codigo)){
                return cuentas.get(i);
            }
                 i++;
            }
        return null;
    }
    /**
     * Método utilizado para obtener el listado de las cuentas.
     **/
    public ArrayList<CuentaCorriente> getCuentas() {
        return cuentas;
    }
    /**
     * Método encargado de modificar el listado de las cuentas.
     **/
    public void setCuentas(ArrayList<CuentaCorriente> cuentas) {
        this.cuentas = cuentas;
    }
    
    
    
}
