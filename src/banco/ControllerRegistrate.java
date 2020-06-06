/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import Banco.Cajero;
import Banco.Sucursal;
import Clientes.Cliente;
import Clientes.PersonaNatural;
import Manejo.AdministracionClientes;
import Manejo.AdministracionCompanias;
import Manejo.AdministracionOperaciones;
import Manejo.FachadaClientes;
import Manejo.ManejoOperaciones;
import Seriallizar.SerializarCompania;
import Seriallizar.SerializarOperacion;
import Seriallizar.SerializarOperaciones;
import Seriallizar.SerializarPersonaNatural;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author andres
 */
public class ControllerRegistrate implements Initializable{
    @FXML
    private javafx.scene.control.Button cancelar,registrar;
    private Stage stage=new Stage();
    private static Sucursal sucursal;
    @FXML
    private TextField nombrePersona,apellidoPersona,ocupacionPersona,documentoPersona,numeroPersona,direccionPersona,nombreEmpresa,nitEmpresa,sectorComercial,direccionEmpresa;
    private static SerializarOperacion operaciones;
    private static SerializarPersonaNatural usuarios;
    private static SerializarCompania companias;
    private static Cajero cajero;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 
        sucursal=new Sucursal();
        operaciones=SerializarOperacion.getSerializarOperacion();
        usuarios=SerializarPersonaNatural.getSerializarPersonaNatural();
        companias=SerializarCompania.getSerializarCompania();
        cajero=sucursal.getCajero();
        AdministracionClientes adminUsuario=AdministracionClientes.getAdminClientes();
        AdministracionCompanias adminCompanias=AdministracionCompanias.getAdminCompanias();
        AdministracionOperaciones adminOperaciones=AdministracionOperaciones.getAdministracionOperaciones();
        FachadaClientes fachadaCliente=FachadaClientes.getFachadaClientes();
        //Deserializamos los datos.
        adminUsuario.setClientes(usuarios.deserializacion());
        adminCompanias.setCompanias(companias.deserializacion());
        adminOperaciones.setOperaciones(operaciones.deserializacion());
        //Integramos los objetos
        fachadaCliente.setClientes(adminUsuario);
        fachadaCliente.setCompanias(adminCompanias);
        cajero.setClientes(fachadaCliente);
        cajero.setOperaciones(adminOperaciones);
    } 
    public void cancelar(ActionEvent event) throws IOException{
                   
        Parent root = FXMLLoader.load(getClass().getResource("Opciones.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("¿Que desea hacer el dia de hoy?");
        stage.setResizable(false);
        Stage stage =(Stage) cancelar.getScene().getWindow();
        stage.hide();
    }
    public void registrarPersona() throws IOException{
        int input=JOptionPane.showConfirmDialog(null, "¿Está seguro de enviar los datos?");
        if(input==0){
            String nombre,apellido,ocupacion,documento,numero,direccion;
            nombre= nombrePersona.getText();
            apellido=apellidoPersona.getText();
            ocupacion=ocupacionPersona.getText();
            documento=documentoPersona.getText();
            numero=numeroPersona.getText();
            direccion=direccionPersona.getText();
            if(!nombre.equals("") &&!apellido.equals("")&&!ocupacion.equals("")&&!documento.equals("")&&!numero.equals("")&&!direccion.equals("")){
                if(numero.length()>=4&&apellido.length()>=4&&numero.length()==10&&documento.length()>=10&&direccion.length()>=6&&ocupacion.length()>=6){
                    Cliente existe=cajero.getClientes().buscarCliente(documento, "Persona Natural");
                    if(existe==null){
                        cajero.crearPersonaNatural(nombre, documento, numero, ocupacion, direccion);
                        operaciones.serializacion(cajero.getOperaciones().getOperaciones());
                        usuarios.serializacion(cajero.getClientes().getClientes().getClientes());
                        Parent root = FXMLLoader.load(getClass().getResource("Opciones.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                        stage.setTitle("¿Que desea hacer el dia de hoy?");
                        stage.setResizable(false);
                        Stage stage =(Stage) registrar.getScene().getWindow();
                        stage.hide();
                    }else{
                        JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese número de documento.");
                    }                    
                }else{
                JOptionPane.showMessageDialog(null, "Los campos deben de ir de la siguiente manera:\n1.La longitud del nombre y del apellido debe ser mínimo de 4 caracteres."+
                        "\n 2. El número de contacto debe ser 10 caracteres"+"\n3.El documento debe ser mínimo de 10 caracteres."
                        +"\n4.La dirección y la ocupación deber ser mínimo de 6 caracteres.");    
                }                
            }else{
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
            }
            
        }
    }
    public void registrarEmpresa() throws IOException{
        int input=JOptionPane.showConfirmDialog(null, "¿Está seguro de enviar los datos?");
        if(input==0){
            String nombre,apellido,ocupacion,documento,numero,direccion,nombreE,nitE,sectorE;
            nombre= nombrePersona.getText();
            apellido=apellidoPersona.getText();
            ocupacion=ocupacionPersona.getText();
            documento=documentoPersona.getText();
            numero=numeroPersona.getText();
            direccion=direccionPersona.getText();
            nombreE=nombreEmpresa.getText();
            nitE=nitEmpresa.getText();
            sectorE=sectorComercial.getText();
            if(!nombreE.equals("")&&!nitE.equals("")&&!sectorE.equals("")&&!nombre.equals("") &&!apellido.equals("")&&!ocupacion.equals("")&&!documento.equals("")&&!numero.equals("")&&!direccion.equals("")){
                if(nitE.length()==10&&nombreE.length()>=3&&sectorE.length()>=6 && numero.length()>=4&&apellido.length()>=4&&numero.length()==10&&documento.length()>=10&&direccion.length()>=6&&ocupacion.length()>=6){
                    Cliente existe=cajero.getClientes().buscarCliente(nitE, "Compania");
                    if(existe==null){
                        cajero.crearCompania(nitE, nombreE, sectorE, nombre, documento, numero, ocupacion, direccion);
                        operaciones.serializacion(cajero.getOperaciones().getOperaciones());
                        companias.serializacion(cajero.getClientes().getCompanias().getCompanias());
                        Parent root = FXMLLoader.load(getClass().getResource("Opciones.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                        stage.setTitle("¿Que desea hacer el dia de hoy?");
                        stage.setResizable(false);
                        Stage stage =(Stage) registrar.getScene().getWindow();
                        stage.hide();
                    }else{
                        JOptionPane.showMessageDialog(null, "Ya existe una empresa con ese NIT.");
                    }                    
                }else{
                JOptionPane.showMessageDialog(null, "Los campos deben del representate deben cumplir las siguentes condiciones:\n1.La longitud del nombre y del apellido debe ser mínimo de 4 caracteres."+
                        "\n2.El número de contacto debe ser 10 caracteres"+"\n3.El documento debe ser mínimo de 10 caracteres."
                        +"\n4.La dirección y la ocupación deber ser mínimo de 6 caracteres."
                        +"\nLos datos de la empresa deber cumplir las siguienes condiciones:"+""
                        + "\n5.El NIT debe tener mínimo 10 caracteres"+"\n6. El nombre de la empresa debe tener mínimo 3 caracteres"
                         +"\n7.El sector comercial debe tener mínimo 6 caracteres");    
                }                
            }else{
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
            }
            
        }
    }
    public void eliminarDatosPersona(){
        nombrePersona.setText("");
        apellidoPersona.setText("");
        ocupacionPersona.setText("");
        documentoPersona.setText("");
        numeroPersona.setText("");
        direccionPersona.setText("");
    }
    public void eliminarDatosCompania(){
        nombrePersona.setText("");
        apellidoPersona.setText("");
        ocupacionPersona.setText("");
        documentoPersona.setText("");
        numeroPersona.setText("");
        direccionPersona.setText("");
        nombreEmpresa.setText("");
        nitEmpresa.setText("");
        sectorComercial.setText("");
        direccionEmpresa.setText("");
    }
    public void soloNumeros(javafx.scene.input.KeyEvent keyEvent){
        char car = keyEvent.getCharacter().charAt(0);
        if ((car < '0' || car > '9') ) {
                    keyEvent.consume();
        }
    }
    public void  soloLetras (javafx.scene.input.KeyEvent keyEvent) {
        char car = keyEvent.getCharacter().charAt(0);
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') ) {
            if(car==' '){
                
            }else{
            keyEvent.consume();
                
            }
        } 
    }
}
