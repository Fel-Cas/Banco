/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seriallizar;

import Clientes.Cliente;
import Clientes.Compania;
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
public class SerializarCompania implements SerializarCompanias {
    private Gson gson;// Objeto que ayuda a pasar los objetos al json y también a recuperarlos.
    private static SerializarCompania serializarCompanias;//Instancia de la clase SerializarCompania que permite el singleton
    /**
     * Método constructor.
     **/
    private SerializarCompania(){
        gson=new Gson();
    }
    /***
     * Método encargado de devolver la instancia de la clase SerializarCompania.
     **/
    public static SerializarCompania getSerializarCompania(){
        if(serializarCompanias==null){
            serializarCompanias=new SerializarCompania();
        }
        return serializarCompanias;
    }
    /**
     * Método encargado de pasar la lista de objetos companias a el archivo 
     * Compañias.json.
     **/
    @Override
    public void serializacion(ArrayList<Compania> objetos) {
       if(objetos.size()>0){
            String entrada="[";
        
            for(int i=0;i<objetos.size();i++){
                entrada+=gson.toJson(objetos.get(i));
                entrada+=",";
            }
            entrada=entrada.substring(0,entrada.length()-1);
            entrada+="]";
        
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("Compañias.json"))) {
                bw.write(entrada);

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
       }
         
    }
    /**
     * Método encargado de recuperar los objetos companias del archivo 
     * Compañias.json.
     **/
    @Override
    public ArrayList<Compania> deserializacion() {
        ArrayList<Compania>companias=new ArrayList<>();
        String json="";
        try(BufferedReader rd=new BufferedReader(new FileReader("Compañias.json"))){
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
            Compania[]compania1=gson.fromJson(json,Compania[].class);
            for (Compania compania2 : compania1) {
                companias.add(compania2);
            }
        }
        return companias;
    }

   
}
