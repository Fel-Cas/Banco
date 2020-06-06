/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejo;

import Cuentas.Cuenta;

/**
 *
 * @author andres
 */
public class FachadaCuentas {
    private AdministracionCuentasAhorros cuentasAhorros;//Objeto encargado de administrar las cuentas de ahorros.
    private AdministracionCuentasCorrientes cuentasCorrientes;//Objeto encargado de administrar las cuentas corrientes
    private static FachadaCuentas fachada;//Instancia de la clase FachadaClientes que permite el singleton
    /**
     * Método constructor.
     **/
    private FachadaCuentas(){
        
    }
    /**
     * Método encargado de devolver la instancia de la clase FachadaCuentas.
     **/
    public static FachadaCuentas getFachadaCuentas(){
        if(fachada==null){
            fachada= new FachadaCuentas();
        }
        return fachada;
    }
    /**
     * Método encargado de agregar una cuenta a su lista correspondiente, según 
     * el tipo que sea la cuenta(Ahorros o Corriente).
     **/
    public void agregarCuenta(Cuenta cuenta, String tipo){
        if(tipo.equals("Corriente")){
            cuentasCorrientes.agregarCuenta(cuenta);
        }else{
            cuentasAhorros.agregarCuenta(cuenta);
        }
    }
    /**
     * Método encargado de reemplazar una cuenta existente, por una que haya sufrido 
     * algún cambio.
     **/
    public void reemplazarCuenta(Cuenta cuenta,String tipo){
        
    }
    /**
     * Método encargado de buscar una cuenta en específico. 
     **/
    public Cuenta buscarCuenta(String identificador, String tipo){
        Cuenta cuenta=null;
        if(tipo.equals("Corriente")){
            cuenta=cuentasCorrientes.buscarCuenta(identificador);
        }else{
            cuenta=cuentasAhorros.buscarCuenta(identificador);
        }
        return cuenta;
    }
    /**
     * Método encargado de validar que un identificar de cuenta sea único.
     **/
    public boolean verificarCodigoUnico(String identificador, String tipo){
        return false;
    }
    /**
     * Método utilizado para obtener el objeto que administra las cuentas de ahorros.
     **/
    public AdministracionCuentasAhorros getCuentasAhorros() {
        return cuentasAhorros;
    }
    /**
     * Método utilizado para cambiar el objeto que administra las cuentas de ahorros.
     **/
    public void setCuentasAhorros(AdministracionCuentasAhorros cuentasAhorros) {
        this.cuentasAhorros = cuentasAhorros;
    }
    /**
     * Método utilizado para obtener el objeto que administra las cuentas corrientes.
     **/
    public AdministracionCuentasCorrientes getCuentasCorrientes() {
        return cuentasCorrientes;
    }
    /**
     * Método utilizado para cambiar el objeto que administra las cuentas corrientes.
     **/
    public void setCuentasCorrientes(AdministracionCuentasCorrientes cuentasCorrientes) {
        this.cuentasCorrientes = cuentasCorrientes;
    }
    /***
     * Método encargado de generar el identificador único para cada una de las cuentas.
     */
    public String generarIdentificador(String tipo) {
         String identificador="";
         if(tipo.equals("Corriente")){
             String [] abc=new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","Ñ"};
             int numero = 0;
             for(int k=0;k<2;k++){
                 numero = (int) (Math.random() * (abc.length));
                 identificador+=abc[numero];
            }
             identificador+=Integer.toString((cuentasCorrientes.getCuentas().size()+1));
         }else{
            String [] abc=new String[]{"AA","BB","CC","DD","EE","FF","GG","HH","II","JJ","KK","LL","MM","NN","OO","PP","QQ","RR","SS","TT","UU","VV","WW","XX","YY","ZZ","ÑÑ"};
            int numero = 0;
            for(int k=0;k<2;k++){
                 numero = (int) (Math.random() * (abc.length));
                 identificador+=abc[numero];
            }
            identificador+=Integer.toString((cuentasAhorros.getCuentas().size()+1));
         }
        
         return identificador;
    }
}
