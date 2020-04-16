/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

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
public class SerializarClientes implements Serializar{
    Gson gson=new Gson();
    @Override
    public void serializacion(ArrayList<Object> objetos) {
       String entrada="[Clientes:";
        
        for(int i=0;i<objetos.size();i++){
            entrada+=gson.toJson(objetos.get(i));
        }
        entrada=entrada.substring(0,entrada.length()-1);
        entrada+="]";
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Clientes.json"))) {
            bw.write(entrada);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
    }

    @Override
    public Object deserializacion() {
        ArrayList<Cliente>clientes=new ArrayList<>();
        String json="";
        try(BufferedReader rd=new BufferedReader(new FileReader("Clientes.json"))){
            String line;
            while ((line = rd.readLine()) != null) {
                json+= line;
            }
        }catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Cliente[]clientes1=gson.fromJson(json,Cliente[].class);
        for (Cliente cliente2 : clientes1) {
           clientes.add(cliente2);
        }
        
        return clientes;
    }
    
}
