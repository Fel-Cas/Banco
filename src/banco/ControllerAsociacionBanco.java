/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import Banco.Cajero;
import Banco.Sucursal;
import Clientes.Cliente;
import Cuentas.Cuenta;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author andres
 */
public class ControllerAsociacionBanco implements Initializable {
    ObservableList list=FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<String> tiposCuentas;
    @FXML
    private javafx.scene.control.Button cancelar,activar,desactivar;
    private Stage stage=new Stage(); 
    @FXML
    TextField dinero,codigoCuenta,contrasena;
    private int i;
    private static Sucursal sucursal;
    private static SerializarOperacion operaciones;
    private static SerializarPersonaNatural usuarios;
    private static SerializarCompania companias;
    private static SerializarCuentaCorriente cuentasCorrientes;
    private static SerializarCuentaAhorros cuentasAhorros;
    private static Cajero cajero;
    private static Cuenta cuenta;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //           
        loadData();
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
        list.removeAll(list);
        String a="Ahorros";
        String b="Corriente";
        list.addAll(a,b);
        tiposCuentas.getItems().addAll(list);
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
    public void soloNumeros(javafx.scene.input.KeyEvent keyEvent){
        char car = keyEvent.getCharacter().charAt(0);
        if ((car < '0' || car > '9') ) {
                    keyEvent.consume();
        }
    }
    public void activarCuenta() throws IOException{
        int input=JOptionPane.showConfirmDialog(null, "¿Está seguro de enviar los datos?");
        if(input==0){
            String pass,id,tipo;
            double valor=0;
            pass=contrasena.getText();
            id=codigoCuenta.getText();
            tipo=tiposCuentas.getValue();
            if(!pass.equals("")&&!id.equals("")&&tipo!=null&&!dinero.getText().equals("")){
               valor= Double.parseDouble(dinero.getText());
               if(valor>=20000){
                   cuenta=cajero.getCuentas().buscarCuenta(id, tipo);
                   if(cuenta!=null){
                       if(cuenta.getContrasena().equals(pass)){
                           if(!cuenta.isIsActiva()){
                                cajero.activarCuenta(valor, cuenta);
                                operaciones.serializacion(cajero.getOperaciones().getOperaciones());
                                usuarios.serializacion(cajero.getClientes().getClientes().getClientes());
                                companias.serializacion(cajero.getClientes().getCompanias().getCompanias());
                                cuentasAhorros.serializacion(cajero.getCuentas().getCuentasAhorros().getCuentas());
                                cuentasCorrientes.serializacion(cajero.getCuentas().getCuentasCorrientes().getCuentas());
                                Parent root = FXMLLoader.load(getClass().getResource("Opciones.fxml"));
                                Scene scene = new Scene(root);
                                stage.setScene(scene);
                                stage.show();
                                stage.setTitle("¿Que desea hacer el dia de hoy?");
                                stage.setResizable(false);
                                Stage stage =(Stage) activar.getScene().getWindow();
                                stage.hide();
                           }else{
                                JOptionPane.showMessageDialog(null, "La cuenta ya está activada."); 
                            }                       
                        }else{
                            JOptionPane.showMessageDialog(null, "La contraseña no es correcta.");
                         }
                   }else{
                       JOptionPane.showMessageDialog(null, "La cuenta no existe.");
                   }                   
               }else{
                   JOptionPane.showMessageDialog(null, "La cantidad mínima de dinero para activar la cuenta es de 20.000 pesos colombianos.");
               }
            }else{
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos y seleccionar el tipo de la cuenta.");
            }
        }
        
    }
    public void desactivarCuenta() throws IOException{ 
        int input=JOptionPane.showConfirmDialog(null, "¿Está seguro de enviar los datos?");
        if(input==0){
            String pass,id,tipo;
            pass=contrasena.getText();
            id=codigoCuenta.getText();
            tipo=tiposCuentas.getValue();
            if(!pass.equals("")&&!id.equals("")&&tipo!=null){
                cuenta=cajero.getCuentas().buscarCuenta(id, tipo);
                if(cuenta!=null){
                    if(cuenta.getContrasena().equals(pass)){
                         if(cuenta.isIsActiva()){
                                double valor=cajero.desactivarCuenta(cuenta);
                                operaciones.serializacion(cajero.getOperaciones().getOperaciones());
                                usuarios.serializacion(cajero.getClientes().getClientes().getClientes());
                                companias.serializacion(cajero.getClientes().getCompanias().getCompanias());
                                cuentasAhorros.serializacion(cajero.getCuentas().getCuentasAhorros().getCuentas());
                                cuentasCorrientes.serializacion(cajero.getCuentas().getCuentasCorrientes().getCuentas());
                                Parent root = FXMLLoader.load(getClass().getResource("Opciones.fxml"));
                                Scene scene = new Scene(root);
                                stage.setScene(scene);
                                stage.show();
                                stage.setTitle("¿Que desea hacer el dia de hoy?");
                                stage.setResizable(false);
                                Stage stage =(Stage) desactivar.getScene().getWindow();
                                stage.hide();
                                JOptionPane.showMessageDialog(null, "La cuenta fue desactivada exitosamente.\nCuenta: "+id+"\nTipo: "+tipo+"\nDinero entregado por el banco: "+valor);
                           }else{
                                JOptionPane.showMessageDialog(null, "La cuenta ya está desactivada."); 
                            }                       
                        }else{
                            JOptionPane.showMessageDialog(null, "La contraseña no es correcta.");
                         }
                   }else{
                       JOptionPane.showMessageDialog(null, "La cuenta no existe.");
                   }                   
            }else{
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos y seleccionar el tipo de la cuenta.");
            }
        }
    }
}
