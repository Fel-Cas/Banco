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
    protected String id;
    protected float cuenta;
    protected boolean activa;
    protected String nroCuenta;

    public Cuenta(String id, float cuenta,String nroCuenta) {
        this.id = id;
        this.cuenta = cuenta;
        this.activa=false;
        this.nroCuenta=nroCuenta;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getCuenta() {
        return cuenta;
    }

    public void setCuenta(float cuenta) {
        this.cuenta = cuenta;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    
    
    public void consignar(float valor){
        
    }
    public void retirar(float valor){
        
    }
    public void agregarOperacion(float valor, String nombre){
        
    }
}
