/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Clientes.PersonaNatural;
import Clientes.Cliente;
import Clientes.Compania;
import Cuentas.CuentaAhorros;
import Cuentas.CuentaCorriente;
import Cuentas.Cuenta;
import Manejo.AdministracionOperaciones;
import Manejo.FachadaClientes;
import Manejo.FachadaCuentas;
import Manejo.ManejoOperaciones;

/**
 *
 * @author andres
 */
public class Cajero {
    private FachadaCuentas cuentas;//Objeto encargado del manejo de todas las cuentas
    private FachadaClientes clientes;//Objeto encargado del manejo de todos los clientes(Persona natural o compania)
    private AdministracionOperaciones operaciones;//Objeto encrgado del manejo de todas las Operaciones.
    /**
     * Método constructor.
     */
    public Cajero(){
        
    }
    /**
     * Método encargado de crear una Cuenta corriente.
     */
    public String crearCuentaCorriente(String idTitular,String contrasena ,String tipo){
        String identificador=cuentas.generarIdentificador("Corriente");
        CuentaCorriente corriente=new CuentaCorriente(identificador,idTitular, contrasena,tipo);
        cuentas.agregarCuenta(corriente, "Corriente");
        operaciones.agregarOperacionOperacion("CrearCuenta", identificador, 0); 
        return identificador;
    }
    /**
     * Método encargado de crear una cuenta de ahorros.
     */ 
    public String crearCuentaAhorros(String idTitular,String contrasena,String tipo){
        String identificador=cuentas.generarIdentificador("Ahorros");
        CuentaAhorros ahorros=new CuentaAhorros(identificador,idTitular, contrasena,tipo);
        cuentas.agregarCuenta(ahorros, "Ahorros");
         operaciones.agregarOperacionOperacion("CrearCuenta", identificador, 0);
         return identificador;
    }
    /**
     * Método encargado de crear un cliente tipo persona natural.
     */ 
    public void crearPersonaNatural(String nombreCompleto, String documento, String numeroContacto, String ocupacion, String direcion){
       PersonaNatural persona=new PersonaNatural(nombreCompleto,documento,  numeroContacto,ocupacion, direcion, 0, false); 
       clientes.agregarCliente(persona, "Persona Natural");
       operaciones.agregarOperacionOperacion("CrearCliente", documento, 0);
    }
    /**
     * Método encargado de crear un cliente tipo compania.
     */
    public void crearCompania(String nit, String nombreEmpresa, String sectorComercial, String nombreCompleto, String documento, String numeroContacto, String ocupacion, String direcion){
        Compania compania=new Compania(nit,nombreEmpresa, sectorComercial, nombreCompleto, documento,numeroContacto, ocupacion,direcion, 0,false);
        clientes.agregarCliente(compania, "Compania");
        operaciones.agregarOperacionOperacion("CrearCliente", nit, 0);
    }
    /**
     * Método utilizado para desactivar una cuenta.
     */
    public double desactivarCuenta( Cuenta cuenta){
        cuenta.setIsActiva(false);
        Cliente usuario=clientes.buscarCliente(cuenta.getIdTitular(),cuenta.getTipoUsuario());
        usuario.setCuentasActivas(usuario.getCuentasActivas()-1);
        if(usuario.getCuentasActivas()==0){
            usuario.setSuscrito(false);
        }
        double retiro=cuenta.getInteresRetiro()*cuenta.getSaldo();
        double canRetiro=cuenta.getSaldo()-retiro;
        cuenta.setSaldo(0);
        Cuenta cuentaSucursal=cuentas.buscarCuenta("AA1", "Corriente");
        cuentaSucursal.setSaldo(cuentaSucursal.getSaldo()+retiro);
        operaciones.agregarOperacionOperacion("DesactivarCuenta", cuenta.getIdentificador(), 0);
        return canRetiro;
    }
    /**
     * Método utilizado para activar una cuenta.
     */
    public void activarCuenta(double saldo,Cuenta cuenta){
        cuenta.setSaldo(saldo);
        cuenta.setIsActiva(true);
        System.out.println(cuenta.getTipoUsuario());
        Cliente usuario=clientes.buscarCliente(cuenta.getIdTitular(),cuenta.getTipoUsuario());
        System.out.println(usuario);
        usuario.setCuentasActivas(usuario.getCuentasActivas()+1);
        usuario.setSuscrito(true);
        operaciones.agregarOperacionOperacion("ActivarCuenta", cuenta.getIdentificador(), saldo);
    }
    /**
     * 
     */
    public void consignar(Cuenta cuenta, double valor){
        cuenta.setSaldo(cuenta.getSaldo()+valor);
         operaciones.agregarOperacionOperacion("Consignar", cuenta.getIdentificador(), valor);
    }
    /**
     * Método utilizado para realizar un retiro en una cuenta.
     */
    public void retirar(Cuenta cuenta, int valor){
        double retiro=valor*cuenta.getInteresRetiro();
        double canRetiro=retiro;
        retiro=retiro+valor;
        cuenta.setSaldo(cuenta.getSaldo()-retiro);
        operaciones.agregarOperacionOperacion("Retirar", cuenta.getIdentificador(), valor);
        Cuenta cuentaSucursal=cuentas.buscarCuenta("AA1", "Corriente");
        cuentaSucursal.setSaldo(cuentaSucursal.getSaldo()+canRetiro);
    }
    /***
     * Método utilizado para obtener el objeto encargado de manejar las cuentas.
     */
    public FachadaCuentas getCuentas() {
        return cuentas;
    }
    /***
     * Método utilizado para cambiar el objeto encargado de manejar las cuentas.
     **/
    public void setCuentas(FachadaCuentas cuentas) {
        this.cuentas = cuentas;
    }
    /***
     * Método utilizado para obtener el objeto encargado de manejar a los clientes.
     **/
    public FachadaClientes getClientes() {
        return clientes;
    }
    /***
     * Método utilizado para cambiar el objeto encargado de maneja a los clientes.
     **/
    public void setClientes(FachadaClientes clientes) {
        this.clientes = clientes;
    }
    /***
     * Método utilizado para obtener el objeto encargado de manejar las operaciones.
     **/
    public AdministracionOperaciones getOperaciones() {
        return operaciones;
    }
    /***
     * Método utilizado para cambiar el objeto encargado de manejar las operaciones.
     **/
    public void setOperaciones(AdministracionOperaciones operaciones) {
        this.operaciones = operaciones;
    }
    
}
