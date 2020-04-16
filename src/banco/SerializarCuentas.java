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
public class SerializarCuentas implements Serializar {
    Gson gson=new Gson();
    @Override
    public void serializacion(ArrayList<Object> objetos) {
       String entrada="[Cuentas:";
        
        for(int i=0;i<objetos.size();i++){
            entrada+=gson.toJson(objetos.get(i));
            entrada+=",";
        }
        entrada=entrada.substring(0,entrada.length()-1);
        entrada+="]";
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Cuentas.json"))) {
            bw.write(entrada);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
    }

    @Override
    public Object deserializacion() {
        ArrayList<Cuenta>cuentas=new ArrayList<>();
        String json="";
        try(BufferedReader rd=new BufferedReader(new FileReader("Cuentas.json"))){
            String line;
            while ((line = rd.readLine()) != null) {
                json+= line;
            }
        }catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Cuenta[]cuenta1=gson.fromJson(json,Cuenta[].class);
        for (Cuenta cuenta2 : cuenta1) {
           cuentas.add(cuenta2);
        }
        
        return cuentas;
    }
    
}
