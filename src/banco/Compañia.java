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
public class Compañia extends Cliente {
    private String nit;
    private String nombreCompañia;
    private String sectorComercial;


    public Compañia(String nit, String nombreC, String sectorComercial, String id, String nombre, String celular, String direccion, String ocupacion, boolean subscripcion) {
        super(id, nombre, celular, direccion, ocupacion, subscripcion);
        this.nit = nit;
        this.nombreCompañia = nombreC;
        this.sectorComercial = sectorComercial;
    }

    
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreCompañia() {
        return nombreCompañia;
    }

    public void setNombreCompañia(String nombre) {
        this.nombreCompañia = nombre;
    }

    public String getSectorComercial() {
        return sectorComercial;
    }

    public void setSectorComercial(String sectorComercial) {
        this.sectorComercial = sectorComercial;
    }
    
    
}
