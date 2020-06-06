/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seriallizar;

import Cuentas.Cuenta;
import Cuentas.CuentaCorriente;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class SerializarCuentaCorriente implements SerializarCuentasCorrientes{
    private Gson gson;// Objeto que ayuda a pasar los objetos al json y también a recuperarlos.
    private static SerializarCuentaCorriente serializarCuentasCorrientes;//Instancia de la clase SerializarCuentaCorriente que permite el singleton
    /**
     * Método constructor.
     **/
    private SerializarCuentaCorriente(){
        gson=new Gson();
    }
    /***
     * Método encargado de devolver la instancia de la clase SerializarCuentaAhorros.
     **/
    public static SerializarCuentaCorriente getSerializarCuentaCorriente(){
        if(serializarCuentasCorrientes==null){
            serializarCuentasCorrientes=new SerializarCuentaCorriente();
        }
        return serializarCuentasCorrientes;
    }
    /**
     * Método encargado de pasar la lista de objetos cuenta corriente a el archivo 
     * CuentasCorriente.json.
     **/
    @Override
    public void serializacion(ArrayList<CuentaCorriente> objetos) {
       if(objetos.size()>0){
            String entrada="[";
        
            for(int i=0;i<objetos.size();i++){
                entrada+=gson.toJson(objetos.get(i));
                entrada+=",";
            }
            entrada=entrada.substring(0,entrada.length()-1);
            entrada+="]";
        
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("CuentasCorriente.json"))) {
                bw.write(entrada);

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }    
       }
        
    }
    /**
     * Método encargado de recuperar los objetos cuentas corrientes del archivo 
     * CuentasCorriente.json.
     **/
    @Override
    public ArrayList<CuentaCorriente> deserializacion() {
        ArrayList<CuentaCorriente>cuentas=new ArrayList<>();
        String json="";
        try(BufferedReader rd=new BufferedReader(new FileReader("CuentasCorriente.json"))){
            String line;
            while ((line = rd.readLine()) != null) {
                json+= line;
            }
        }catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        if(!json.equals("")){
            CuentaCorriente[]cuentas1=gson.fromJson(json,CuentaCorriente[].class);
            for (CuentaCorriente cuentas2 : cuentas1) {
                cuentas.add(cuentas2);
            }
        }
        return cuentas;
    }    
}
