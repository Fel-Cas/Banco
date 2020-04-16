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
public class Operacion {
    protected String nombre;
    protected Date fecha;
    protected Time hora;

    public Operacion(String nombre, Date fecha, Time hora) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    
}
