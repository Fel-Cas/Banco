/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seriallizar;

import Clientes.Compania;
import Clientes.PersonaNatural;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public interface SerializarCompanias {
    public ArrayList<Compania> deserializacion();
    public void serializacion(ArrayList<Compania> objetos);
}
