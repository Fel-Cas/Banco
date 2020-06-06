/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seriallizar;

import Clientes.Cliente;
import Clientes.PersonaNatural;
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
public class SerializarPersonaNatural implements SerializarClientes {
    private Gson gson;// Objeto que ayuda a pasar los objetos al json y también a recuperarlos.
    private static SerializarPersonaNatural serializarPersonaNatural;//Instancia de la clase SerializarPersonaNatural que permite el singleton
    /**
     * Método constructor.
     **/
    private SerializarPersonaNatural(){
        gson=new Gson();
    }
    /***
     * Método encargado de devolver la instancia de la clase SerializarPersonaNatural.
     **/
    public static SerializarPersonaNatural getSerializarPersonaNatural(){
        if(serializarPersonaNatural==null){
            serializarPersonaNatural=new SerializarPersonaNatural();
        }
        return serializarPersonaNatural;
    }
    /**
     * Método encargado de pasar la lista de objetos clientes tipo persona natural a el archivo 
     * PersonaNatural.json.
     **/
    @Override
    public void serializacion(ArrayList<PersonaNatural> objetos) {
       if(objetos.size()>0){
            String entrada="[";
        
            for(int i=0;i<objetos.size();i++){
                entrada+=gson.toJson(objetos.get(i));
                entrada+=",";
            }
            entrada=entrada.substring(0,entrada.length()-1);
            entrada+="]";
        
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("PersonaNatural.json"))) {
                bw.write(entrada);

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } 
        }
        
    }
    /**
     * Método encargado de recuperar los objetos clientes  del archivo 
     * PersonaNatural.json.
     **/
    @Override
    public ArrayList<PersonaNatural> deserializacion() {
        ArrayList<PersonaNatural>clientes=new ArrayList<>();
        String json="";
        try(BufferedReader rd=new BufferedReader(new FileReader("PersonaNatural.json"))){
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
            PersonaNatural[]clientes1=gson.fromJson(json,PersonaNatural[].class);
            for (PersonaNatural clientes2 : clientes1) {
                clientes.add(clientes2);
            }
        }
        return clientes;
    }

}
