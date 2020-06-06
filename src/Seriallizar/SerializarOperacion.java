/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seriallizar;

import Operaciones.Operacion;
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
public class SerializarOperacion implements SerializarOperaciones{
    private Gson gson;// Objeto que ayuda a pasar los objetos al json y también a recuperarlos.
    private static SerializarOperacion serializarOperacion;//Instancia de la clase SerializarOperacion que permite el singleton
    /**
     * Método constructor.
     **/
    private SerializarOperacion(){
        gson=new Gson();
    }
    /***
     * Método encargado de devolver la instancia de la clase SerializarOperacion.
     **/
    public static SerializarOperacion getSerializarOperacion(){
        if(serializarOperacion==null){
            serializarOperacion=new SerializarOperacion();
        }
        return serializarOperacion;
    }
    /**
     * Método encargado de pasar la lista de objetos operacion a el archivo 
     * Operaciones.json.
     **/
    @Override
    public void serializacion(ArrayList<Operacion> objetos) {
       if(objetos.size()>0){
            String entrada="[";
        
            for(int i=0;i<objetos.size();i++){
                entrada+=gson.toJson(objetos.get(i));
                entrada+=",";
            }
            entrada=entrada.substring(0,entrada.length()-1);
            entrada+="]";
        
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("Operaciones.json"))) {
                bw.write(entrada);

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }    
        }
        
    }
    /**
     * Método encargado de recuperar los objetos operaciones del archivo 
     * Operaciones.json.
     **/
    @Override
    public ArrayList<Operacion> deserializacion() {
        ArrayList<Operacion>operaciones=new ArrayList<>();
        String json="";
        try(BufferedReader rd=new BufferedReader(new FileReader("Operaciones.json"))){
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
            Operacion[]operaciones1=gson.fromJson(json,Operacion[].class);
            for (Operacion operaciones2 : operaciones1) {
                operaciones.add(operaciones2);
            }
        }
        return operaciones;
    }
}
