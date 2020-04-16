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
public class Cuenta {
    String id;
    float cuenta;
    boolean activa;

    public Cuenta(String id, float cuenta) {
        this.id = id;
        this.cuenta = cuenta;
        this.activa=false;
    }
    
    
    
    public void consignar(float valor){
        
    }
    public void retirar(float valor){
        
    }
    public void agregarOperacion(float valor, String nombre){
        
    }
}
