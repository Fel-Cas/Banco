/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public interface Serializar {
    public void serializacion(ArrayList<Object> objetos);
    public Object deserializacion();
}
