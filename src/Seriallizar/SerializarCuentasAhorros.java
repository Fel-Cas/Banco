/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seriallizar;

import Cuentas.CuentaAhorros;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public interface SerializarCuentasAhorros {
   public void serializacion(ArrayList<CuentaAhorros> objetos);
   public ArrayList<CuentaAhorros> deserializacion();
}
