/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author andres
 */
public class PersonaNatural extends Cliente{
    
    public PersonaNatural(String id, String nombre, String celular, String direccion, String ocupacion, boolean subscripcion) {
        super(id, nombre, celular, direccion, ocupacion, subscripcion);
    }
    
}
