/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejo;

import Cuentas.Cuenta;
import Cuentas.CuentaAhorros;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class AdministracionCuentasAhorros implements ManejoCuenta{
    private ArrayList<CuentaAhorros> cuentas;//Listado de cuentas de ahorros que hay en la sucursal
    private static AdministracionCuentasAhorros cuentasAhorros;//Atributo del mismo tipo de la clase para poder implementar el patrón singletón
    /**
    * Método constructor.
    */ 
    private AdministracionCuentasAhorros() {

    }
    /***
     *  Método utilizado para obtener la instacia de la clase AdministracionCuentasAhorros.
     **/
    public static AdministracionCuentasAhorros getAdministracionCuentasAhorros(){
        if(cuentasAhorros==null){
            cuentasAhorros= new AdministracionCuentasAhorros();
        }
        return cuentasAhorros;
    }
    
    /**
    * Método encargado de agregar una nueva cuenta a la lista de cuentas.
    */
    @Override
    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add((CuentaAhorros)cuenta);
    }
    /**
    * Método utilizado para encontrar una cuenta en específico de la lista.
    */
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
    */
    public ArrayList<CuentaAhorros> getCuentas() {
        return cuentas;
    }
    /**
    * Método encargado de modificar el listado de las cuentas.
    */
    public void setCuentas(ArrayList<CuentaAhorros> cuentas) {
        this.cuentas = cuentas;
    }

    
}
