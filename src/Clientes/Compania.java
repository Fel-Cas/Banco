/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

/**
 *
 * @author andres
 */
public class Compania extends Cliente {
    private String nit;// Número de Identificación Tributaria de la empresa.
    private String nombreEmpresa;//Nombre de la empresa.
    private String sectorComercial;//Sector comercial en el que trabaja la empresa.
    
    /**
     * Método constructor.
     */
    public Compania(String nit, String nombreEmpresa, String sectorComercial, String nombreCompleto, String documento, String numeroContacto, String ocupacion, String direcion, int cuentasActivas, boolean suscrito) {
        super(nombreCompleto, documento, numeroContacto, ocupacion, direcion, cuentasActivas, suscrito);
        this.nit = nit;
        this.nombreEmpresa = nombreEmpresa;
        this.sectorComercial = sectorComercial;
    }
    /**
     * Método utilizado para obtener el nit de la empresa.
     */
    public String getNit() {
        return nit;
    }
    /**
     * Método utilizado para cambiar el nit de la empresa.
     */
    public void setNit(String nit) {
        this.nit = nit;
    }
    /**
     * Método utilizado para obtener el nombre de la empresa.
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    /**
     * Método utilizado para cambiar el nombre de la empresa.
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    /**
     * Método utilizado para obtener el sector comercial en el que trabaja la empresa.
     */
    public String getSectorComercial() {
        return sectorComercial;
    }
    /**
     * Método utilizado para cambiar el sector comercial en el que trabaja la empresa.
     */
    public void setSectorComercial(String sectorComercial) {
        this.sectorComercial = sectorComercial;
    }
/**
     * Método utilizado para obtener el nombre completo del cliente(Persona natural o representante de una empresa).
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    /**
     * Método utilizado para cambiar el nombre completo del cliente(Persona natural o representante de una empresa).
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    /**
     * Método utilizado para obtener el número de documento del cliente(Persona natural o representante de una empresa).
     */
    public String getDocumento() {
        return documento;
    }
    /**
     * Método utilizado para cambiar el número de documento del cliente(Persona natural o representante de una empresa).
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    /**
     * Método utilizado para obtener el número de contacto del cliente(Persona natural o representante de una empresa).
     */
    public String getNumeroContacto() {
        return numeroContacto;
    }
    /**
     * Método utilizado para cambiar el número de contacto del cliente(Persona natural o representante de una empresa).
     */
    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }
    /**
     * Método utilizado para obtener la ocupación del cliente(Persona natural o representante de una empresa).
     */
    public String getOcupacion() {
        return ocupacion;
    }
    /**
     * Método utilizado para cambiar la ocupación del cliente(Persona natural o representante de una empresa).
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    /**
     * Método utilizado para obtener la dirección del cliente(Persona natural o representante de una empresa).
     */
    public String getDirecion() {
        return direcion;
    }
    /**
     * Método utilizado para cambiar la dirección  del cliente(Persona natural o representante de una empresa).
     */
    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }
    /**
     * Método utilizado para obtener el número de cuentas activas del cliente(Persona natural o representante de una empresa).
     */
    public int getCuentasActivas() {
        return cuentasActivas;
    }
    /**
     * Método utilizado para cambiar el número de cuentas activas del cliente(Persona natural o representante de una empresa).
     */
    public void setCuentasActivas(int cuentasActivas) {
        this.cuentasActivas = cuentasActivas;
    }
    /**
     * Método utilizado para obtener el estado de suscripción del cliente(Persona natural o representante de una empresa).
     */
    public boolean isSuscrito() {
        return suscrito;
    }
    /**
     *Método utilizado para cambiar el estado de suscripción del cliente(Persona natural o representante de una empresa).
     */
    public void setSuscrito(boolean suscrito) {
        this.suscrito = suscrito;
    }
       
}
