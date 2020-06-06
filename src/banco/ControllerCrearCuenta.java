/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import Banco.Cajero;
import Banco.Sucursal;
import Clientes.Cliente;
import Clientes.Compania;
import Manejo.AdministracionClientes;
import Manejo.AdministracionCompanias;
import Manejo.AdministracionCuentasAhorros;
import Manejo.AdministracionCuentasCorrientes;
import Manejo.AdministracionOperaciones;
import Manejo.FachadaClientes;
import Manejo.FachadaCuentas;
import Seriallizar.SerializarCompania;
import Seriallizar.SerializarCuentaAhorros;
import Seriallizar.SerializarCuentaCorriente;
import Seriallizar.SerializarOperacion;
import Seriallizar.SerializarPersonaNatural;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author andres
 */
public class ControllerCrearCuenta implements Initializable {
    ObservableList list1=FXCollections.observableArrayList();
    ObservableList list2=FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<String> tipoClientes;
    @FXML
    private Button buscar;
    @FXML
    private ChoiceBox<String> tipoCuentas;
    @FXML
    private Button crearCuenta;
    @FXML
    private javafx.scene.control.Button cancelar;
    private Stage stage=new Stage();
    @FXML
    Label datos,tipoCuenta,textContrasena,textContrasena1;
    @FXML
    TextField contrasena,contrasena1,identificacion;
    private static Sucursal sucursal;
    private static SerializarOperacion operaciones;
    private static SerializarPersonaNatural usuarios;
    private static SerializarCompania companias;
    private static SerializarCuentaCorriente cuentasCorrientes;
    private static SerializarCuentaAhorros cuentasAhorros;
    private static Cajero cajero;
    private static Cliente usuario;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadData();
        loadData1();
        sucursal=new Sucursal();
        operaciones=SerializarOperacion.getSerializarOperacion();
        usuarios=SerializarPersonaNatural.getSerializarPersonaNatural();
        companias=SerializarCompania.getSerializarCompania();
        cuentasCorrientes=SerializarCuentaCorriente.getSerializarCuentaCorriente();
        cuentasAhorros=SerializarCuentaAhorros.getSerializarCuentaAhorros();
        cajero=sucursal.getCajero();
        //Instancias de los Adminisradores
        AdministracionClientes adminUsuario=AdministracionClientes.getAdminClientes();
        AdministracionCompanias adminCompanias=AdministracionCompanias.getAdminCompanias();
        AdministracionOperaciones adminOperaciones=AdministracionOperaciones.getAdministracionOperaciones();
        AdministracionCuentasAhorros adminCuentaAhorros=AdministracionCuentasAhorros.getAdministracionCuentasAhorros();
        AdministracionCuentasCorrientes adminCuentaCorriente=AdministracionCuentasCorrientes.getAdministracionCuentasCorrientes();
        FachadaClientes fachadaCliente=FachadaClientes.getFachadaClientes();
        FachadaCuentas fachadaCuentas=FachadaCuentas.getFachadaCuentas();
        //Deserializamos los datos.
        adminUsuario.setClientes(usuarios.deserializacion());
        adminCompanias.setCompanias(companias.deserializacion());
        adminOperaciones.setOperaciones(operaciones.deserializacion());
        adminCuentaAhorros.setCuentas(cuentasAhorros.deserializacion());
        adminCuentaCorriente.setCuentas(cuentasCorrientes.deserializacion());
        //Integramos los objetos
        fachadaCliente.setClientes(adminUsuario);
        fachadaCliente.setCompanias(adminCompanias);
        fachadaCuentas.setCuentasAhorros(adminCuentaAhorros);
        fachadaCuentas.setCuentasCorrientes(adminCuentaCorriente);
        cajero.setClientes(fachadaCliente);
        cajero.setCuentas(fachadaCuentas);
        cajero.setOperaciones(adminOperaciones);
    }    
      private void loadData(){
        list1.removeAll(list1);
        String a="Ahorros";
        String b="Corriente";
        list1.addAll(a,b);
        tipoCuentas.getItems().addAll(list1);
    }
    private void loadData1(){
        list2.removeAll(list2);
        String a="Persona Natural";
        String b="Compañia";
        list2.addAll(a,b);
        tipoClientes.getItems().addAll(list2);
    }
    public void cancelar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Opciones.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("¿Que desea hacer el dia de hoy?");
        stage.setResizable(false);
        Stage stage =(Stage) cancelar.getScene().getWindow();
        stage.hide();
    }
    public void buscar(){
        int input=JOptionPane.showConfirmDialog(null, "¿Está seguro de enviar los datos?");
        if(input==0){
            String id,tipo;
            id=identificacion.getText();
            tipo=tipoClientes.getValue();
            if(!id.equals("")&&tipo!=null){
                if(tipo.equals("Compañia")) tipo="Compania";
                usuario=cajero.getClientes().buscarCliente(id, tipo);
                if(usuario!=null){
                    textContrasena.setDisable(false);
                    textContrasena1.setDisable(false);
                    tipoCuentas.setDisable(false);
                    crearCuenta.setDisable(false);
                    datos.setDisable(false);
                    tipoCuenta.setDisable(false);
                    contrasena.setDisable(false);
                    contrasena1.setDisable(false);
                    buscar.setDisable(true);
                    tipoClientes.setDisable(true);
                }else{
                    JOptionPane.showMessageDialog(null, "El usuario no existe");
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Debe llenar el campo y escoger el tipo de cliente al que pertenece");
            }
            
        }
        
    }
    public void crearCuenta() throws IOException{
        int input=JOptionPane.showConfirmDialog(null, "¿Está seguro de enviar los datos?");
        if(input==0){
            String pass,pass1,tipo;
            pass=contrasena.getText();
            pass1=contrasena1.getText();
            tipo=tipoCuentas.getValue();
            if(!pass.equals("")&&!pass1.equals("")&&tipo!=null){
                if(pass.equals(pass1)){
                    if(tipo.equals("Ahorros")){
                        String id="";
                        if(tipoClientes.getValue().equals("Compañia")){
                            Compania compania=(Compania) usuario;
                            id=cajero.crearCuentaAhorros(compania.getNit(), pass, tipoClientes.getValue());
                        }else{
                            id=cajero.crearCuentaAhorros(usuario.getDocumento(), pass, tipoClientes.getValue());
                        } 
                         
                        System.out.println(id);
                        operaciones.serializacion(cajero.getOperaciones().getOperaciones());
                        cuentasAhorros.serializacion(cajero.getCuentas().getCuentasAhorros().getCuentas());
                        JOptionPane.showMessageDialog(null, "Su cuenta de ahorros fue creada satisfactoriamente.\nEl identificador es el siguiente:\n"+id);
                    }else{
                        String id="";
                        if(tipoClientes.getValue().equals("Compañia")){
                            Compania compania=(Compania) usuario;
                            id=cajero.crearCuentaCorriente(compania.getNit(), pass,tipoClientes.getValue() );
                        }else{
                            id=cajero.crearCuentaCorriente(usuario.getDocumento(), pass,tipoClientes.getValue() );
                        }                        
                        System.out.println(id);
                        operaciones.serializacion(cajero.getOperaciones().getOperaciones());
                        cuentasCorrientes.serializacion(cajero.getCuentas().getCuentasCorrientes().getCuentas());
                        JOptionPane.showMessageDialog(null, "Su cuenta de corriente fue creada satisfactoriamente.\nEl identificador es el siguiente:\n"+id);
                    }
                    Parent root = FXMLLoader.load(getClass().getResource("Opciones.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    stage.setTitle("¿Que desea hacer el dia de hoy?");
                    stage.setResizable(false);
                    Stage stage =(Stage) crearCuenta.getScene().getWindow();
                    stage.hide();
                }else{
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Debe llenar los  campos de contraseña y escoger el tipo de cuenta que quiere crear");
            }
        }
    }
}
