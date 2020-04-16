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
public class Sucursal {
    private String id;
    private String direccion;
    private String nombre;
    private String ciudad;
    private Cajero cajero;

    public Sucursal(String id, String direccion, String nombre, String ciudad) {
        this.id = id;
        this.direccion = direccion;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.cajero=new Cajero();
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
