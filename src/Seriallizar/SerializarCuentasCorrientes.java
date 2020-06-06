/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seriallizar;

import Cuentas.Cuenta;
import Cuentas.CuentaCorriente;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public interface SerializarCuentasCorrientes {
    public ArrayList<CuentaCorriente> deserializacion();
    public void serializacion(ArrayList<CuentaCorriente> objetos);
}
