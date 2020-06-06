/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

/**
 *
 * @author andres
 */
public class Sucursal {
    private String identifiador;//Clave unica que identifica a la sucursal.
    private String direccion;//Ubicación de la sucursal.
    private String ciudad;//Ciudad donde está la sucursal.
    private String nombreClave;//Nombre corto para identificar la sucursal.
    private Cajero cajero;//Objeto que se encarga de atender a los clientes.
    /**
     * Método constructor.
     */
    public Sucursal() {
        this.ciudad="Donmatias";
        this.direccion="Cra 26 # 28 A 48";
        this.identifiador="27-AC6-01";
        this.nombreClave="Donma";
        this.cajero=new Cajero();
    }
    /**
     * Método utilizado para obtener el identificador de la sucursal.
     */
    public String getIdentifiador() {
        return identifiador;
    }
    /**
     * Método utilizado para cambiar el identificador de la sucursal.
     */
    public void setIdentifiador(String identifiador) {
        this.identifiador = identifiador;
    }
    /**
     * Método utilizado para obtener la dirección de la sucursal.
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Método utilizado para cambiar la dirección de la sucursal.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Método utilizado para obtener la ciudad de la sucursal.
     */
    public String getCiudad() {
        return ciudad;
    }
    /**
     * Método utilizado para cambiar la ciudad de la sucursal.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    /**
     * Método utilizado para obtener el nombre clave  de la sucursal.
     */
    public String getNombreClave() {
        return nombreClave;
    }
    /**
     * Método utilizado para cambiar el nombre clave de la sucursal.
     */
    public void setNombreClave(String nombreClave) {
        this.nombreClave = nombreClave;
    }
    /**
     * Método utilizado para obtener el cajero de la sucursal.
     */
    public Cajero getCajero() {
        return cajero;
    }
    /**
     * Método utilizado para cambiar el cajero de la sucursal.
     */
    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }
    
}
