/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejo;

import Clientes.Cliente;
import java.util.Date;

/**
 *
 * @author andres
 */
public interface ManejoClientes {
  public void  agregarCliente(Cliente cliente);
  public boolean buscarCliente(String identificacion);
}
