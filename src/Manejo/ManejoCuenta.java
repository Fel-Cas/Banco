/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejo;

import Cuentas.Cuenta;

/**
 *
 * @author andres
 */
public interface ManejoCuenta {
    public void agregarCuenta(Cuenta cuenta);
    public Cuenta buscarCuenta(String codigo);
}
