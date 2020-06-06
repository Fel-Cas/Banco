/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuentas;

/**
 *
 * @author andres
 */
public abstract class Cuenta {
    protected String identificador;//Identificador alfanumérico de la cuenta.
    protected String idTitular;//Número de cédula del titular de la cuenta.
    protected double saldo;//Cantidad de dinero que tiene disponible el titular en la cuenta.
    protected boolean isActiva;//Nos indica si la cuenta es activa o no.
    protected double interesRetiro;//Interés que se descuenta cuando se hace un retiro.
    protected String contrasena;//Contraseña de la cuenta.
    protected String tipoUsuario;//Nos dice a que tipo de cliente pertenece el tirular de la cuenta(Persona natural o cliente). 
    /**
     * Método constructor.
     **/
    public Cuenta(String identificador, String idTitular, double saldo, boolean isActiva, double interesRetiro, String contrasena, String tipoUsuario) {
        this.identificador = identificador;
        this.idTitular = idTitular;
        this.saldo = saldo;
        this.isActiva = isActiva;
        this.interesRetiro = interesRetiro;
        this.contrasena = contrasena;
        this.tipoUsuario=tipoUsuario;
    }
    /**
     * Método utilizado para obtener el identificador de la cuenta.
     **/
    public String getIdentificador() {
        return identificador;
    }
    /**
     * Método utilizado para cambiar el identificador de la cuenta.
     **/
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    /**
     * Método utilizado para obtener el número de cedula del titular de la cuenta.
     **/
    public String getIdTitular() {
        return idTitular;
    }
    
    /**
     * Método utilizado para cambiar el número de cedula del titular de la cuenta.
     **/
    public void setIdTitular(String idTitular) {
        this.idTitular = idTitular;
    }
    /**
     * Método utilizado para obtener el saldo de la cuenta.
     **/
    public double getSaldo() {
        return saldo;
    }
    
    /**
     * Método utilizado para cambiar el saldo de la cuenta.
     **/
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    /**
     * Método utilizado para obtener el estado de la cuenta(Activa o Inactiva) de la cuenta.
     **/
    public boolean isIsActiva() {
        return isActiva;
    }
    
    /**
     * Método utilizado para cambiar el estado de la cuenta.
     **/
    public void setIsActiva(boolean isActiva) {
        this.isActiva = isActiva;
    }
    /**
     * Método utilizado para obtener el interés de retiro de la cuenta.
     **/
    public double getInteresRetiro() {
        return interesRetiro;
    }
    /**
     * Método utilizado para cambiar el interés de retiro de la cuenta.
     **/
    public void setInteresRetiro(double interesRetiro) {
        this.interesRetiro = interesRetiro;
    }
    /**
     * Método utilizado para obtener la contraseña de la cuenta.
     **/
    public String getContrasena() {
        return contrasena;
    }
    
    /**
     * Método utilizado para cambiar la contraseña de la cuenta.
     **/
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    /**
     * Método utilizado para válidar que la cuenta tiene cantidad necesaria de dinero para realizar un retiro.
     */
    public abstract boolean verificarSaldo(int cantidad);
    
    
}
