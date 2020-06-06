/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejo;

import Operaciones.Operacion;
import Banco.Sucursal;
import java.util.Date;

/**
 *
 * @author andres
 */
public interface ManejoOperaciones {
  public Operacion buscarOperacion(Date fecha,String codigo);
  public void agregarOperacionOperacion(String nombre,String codigoCuenta,double cantidad);
}
