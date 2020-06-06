/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Banco.Sucursal;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author andres
 */
public  class Operacion {
    protected String nombre;//Nombre de la operación que se realizó.
    protected String fecha;//Fecha en la que se hizo la operación.
    protected String sucursal;//Nombre de la sucursal donde se hizo la operación.
    protected String identificador;//identificador de operacion, que es la concatenación del identificador de la cuenta con la fecha.
    protected String codigoCuenta;//identificador de la cuenta en la que se hizo la operación.
     private double valor;//
    /**
     * Método constructor.
     **/
    public Operacion(String nombre,  String codigoCuenta,double valor) {
        this.nombre = nombre;
        this.fecha = LocalDate.now().toString();
        this.sucursal = "Donmatías";
        this.codigoCuenta = codigoCuenta;
        this.valor=valor;
    }
    /**
     * Método utilizado para obtener el nombre de la operación.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método utilizado para cambiar el nombre de la operación.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método utilizado para obtener la fecha en la que fue realizada  la operación.
     */
    public String getFecha() {
        return fecha;
    }
    /**
     * Método utilizado para cambiar la fecha en la que fue realizada  la operación.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    /**
     * Método utilizado para obtener la sucursal  en la que fue realizada  la operación.
     */
    public String getSucursal() {
        return sucursal;
    }
    /**
     * Método utilizado para cambiar la sucursal en la que fue realizada  la operación.
     */
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    /**
     * Método utilizado para obtener el identificador de la operación.
     */
    public String getIdentificador() {
        return identificador;
    }
    /**
     * Método utilizado para cambiar el identificador de la operación.
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    /**
     * Método utilizado para obtener el identificador  de la cuenta en la cual fue realizada la operación.
     */
    public String getCodigoCuenta() {
        return codigoCuenta;
    }
    /**
     * Método utilizado para cambiar el identificador  de la cuenta en la cual fue realizada la operación.
     */
    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }
    /**
     * Método utilizada para hacer el identificador de la operación, osea unor el identificador de la cuenta 
     * y la fecha en la que fue realizada la operación.
     */
    public  void hacerIdetificador(){
        String codigo=this.codigoCuenta+this.fecha;
        this.identificador=codigo;
    }
    
}
