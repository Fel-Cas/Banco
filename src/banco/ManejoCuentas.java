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
public class ManejoCuentas  {
    private ArrayList<Cuenta>cuentas;

    public ManejoCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    
    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    public Cuenta buscar(String id, String nroCuenta) {
        int i=0;
        while(i<cuentas.size()){
            if(cuentas.get(i).getId().equals(id)&&cuentas.get(i).getNroCuenta().equals(nroCuenta)){
                return cuentas.get(i);
            }
            i++;
        }
        return null;
    }
    public void insertar(Object objeto) {
        cuentas.add((Cuenta)objeto);
    }
    
    
}
