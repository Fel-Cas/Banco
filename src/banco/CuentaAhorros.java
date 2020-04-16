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
public class CuentaAhorros extends Cuenta {
    private float interes;

    public CuentaAhorros(float interes, String id, float cuenta) {
        super(id, cuenta);
        this.interes = interes;
    }
    
    
    public float getInteres() {
        return interes;
    }

    public void setInteres(float interes) {
        this.interes = interes;
    }
    
}
