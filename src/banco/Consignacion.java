/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author andres
 */
public class Consignacion extends Operacion {
    private float valor;

    public Consignacion(float valor, String nombre, Date fecha, Time hora) {
        super(nombre, fecha, hora);
        this.valor = valor;
    }
    
    

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
