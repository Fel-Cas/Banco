/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seriallizar;

import Clientes.Cliente;
import Clientes.PersonaNatural;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public interface SerializarClientes {
    public ArrayList<PersonaNatural> deserializacion();
    public void serializacion(ArrayList<PersonaNatural> objetos);
}
