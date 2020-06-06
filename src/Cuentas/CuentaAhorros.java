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
public class CuentaAhorros extends Cuenta {
    private double interes;//Porcentae de interés mensual con el cual aumenta el saldo de la cuenta.
    /**
     * Método Constructor.
     **/
    public CuentaAhorros( String identificador, String idTitular, String contrasena, String tipoUsuario) {
        super(identificador, idTitular, 0, false, 0.02, contrasena,tipoUsuario);
        this.interes = 0.017;
    }
    /**
     * Método utilizado para obtener el interés mensual de la cuenta.
     **/
    public double getInteres() {
        return interes;
    }
    /**
     * Método utilizado para modificar el interés mensual de la cuenta.
     **/
    public void setInteres(double interes) {
        this.interes = interes;
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
    /**
     * Método utilizado para válidar que la cuenta tiene cantidad necesaria de dinero para realizar un retiro.
     */
    @Override
    public boolean verificarSaldo(int cantidad) {
       double retiro=cantidad*this.interesRetiro;
        retiro+=cantidad;
        if((this.saldo-retiro)>=10000){
            return true;
        }        
        return false;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
    
}




