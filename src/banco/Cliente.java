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
public class Cliente {
    protected String id;
    protected String nombre;
    protected String celular;
    protected String direccion;
    protected String ocupacion;
    protected boolean subscripcion;

    public Cliente(String id, String nombre, String celular, String direccion, String ocupacion, boolean subscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
        this.direccion = direccion;
        this.ocupacion = ocupacion;
        this.subscripcion = subscripcion;
    }
    
    
    public void contraseña(String id, String contraseña){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public boolean isSubscripcion() {
        return subscripcion;
    }

    public void setSubscripcion(boolean subscripcion) {
        this.subscripcion = subscripcion;
    }
    
}
