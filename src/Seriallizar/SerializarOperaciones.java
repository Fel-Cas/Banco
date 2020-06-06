/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seriallizar;

import Operaciones.Operacion;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public interface SerializarOperaciones {
    public ArrayList<Operacion> deserializacion();
     public void serializacion(ArrayList<Operacion> objetos);
}
