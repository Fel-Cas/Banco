/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seriallizar;

import Cuentas.Cuenta;
import Cuentas.CuentaAhorros;
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
public class SerializarCuentaAhorros implements SerializarCuentasAhorros {
    private Gson gson;// Objeto que ayuda a pasar los objetos al json y también a recuperarlos.
    private static SerializarCuentaAhorros serializarCuentasAhorros;//Instancia de la clase SerializarCuentaAhorros que permite el singleton
    /**
     * Método constructor.
     **/
    private SerializarCuentaAhorros(){
        gson=new Gson();
    }
    /***
     * Método encargado de devolver la instancia de la clase SerializarCompania.
     **/
    public static SerializarCuentaAhorros getSerializarCuentaAhorros(){
        if(serializarCuentasAhorros==null){
            serializarCuentasAhorros=new SerializarCuentaAhorros();
        }
        return serializarCuentasAhorros;
    }
    /**
     * Método encargado de pasar la lista de objetos cuentas de ahorros a el archivo 
     * CuentasAhorros.json.
     **/
    @Override
    public void serializacion(ArrayList<CuentaAhorros> objetos) {
       if(objetos.size()>0){
            String entrada="[";
        
            for(int i=0;i<objetos.size();i++){
                entrada+=gson.toJson(objetos.get(i));
                entrada+=",";
            }
            entrada=entrada.substring(0,entrada.length()-1);
            entrada+="]";
        
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("CuentasAhorros.json"))) {
                bw.write(entrada);

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } 
        }
        
    }
    /**
     * Método encargado de recuperar los objetos cuentas de ahorros del archivo 
     * CuentasAhorros.json.
     **/
    @Override
    public ArrayList<CuentaAhorros> deserializacion() {
        ArrayList<CuentaAhorros>cuentas=new ArrayList<>();
        String json="";
        try(BufferedReader rd=new BufferedReader(new FileReader("CuentasAhorros.json"))){
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
            CuentaAhorros[]cuentas1=gson.fromJson(json,CuentaAhorros[].class);
            for (CuentaAhorros cuentas2 : cuentas1) {
                cuentas.add(cuentas2);
            }
        }
        return cuentas;
    }   
}
