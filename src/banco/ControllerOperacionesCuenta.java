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
 *
 * @author andres
 */
public class ControllerOperacionesCuenta implements Initializable{
        ObservableList list=FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<String> tiposCuenta;
    @FXML
    private javafx.scene.control.Button consignar,cancelar,retirar;
    private Stage stage=new Stage(); 
    @FXML
    private TextField codigoCuenta,cantidadRetiro,contrasena,cantidadConsignar;
    private static Sucursal sucursal;
    private static SerializarOperacion operaciones;
    private static SerializarCuentaCorriente cuentasCorrientes;
    private static SerializarCuentaAhorros cuentasAhorros;
    private static Cajero cajero;
    private static Cuenta cuenta;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        
        sucursal=new Sucursal();
        operaciones=SerializarOperacion.getSerializarOperacion();
        cuentasCorrientes=SerializarCuentaCorriente.getSerializarCuentaCorriente();
        cuentasAhorros=SerializarCuentaAhorros.getSerializarCuentaAhorros();
        cajero=sucursal.getCajero();
        //Instancias de los Adminisradores
        AdministracionOperaciones adminOperaciones=AdministracionOperaciones.getAdministracionOperaciones();
        AdministracionCuentasAhorros adminCuentaAhorros=AdministracionCuentasAhorros.getAdministracionCuentasAhorros();
        AdministracionCuentasCorrientes adminCuentaCorriente=AdministracionCuentasCorrientes.getAdministracionCuentasCorrientes();
        FachadaCuentas fachadaCuentas=FachadaCuentas.getFachadaCuentas();
        //Deserializamos los datos.
        adminOperaciones.setOperaciones(operaciones.deserializacion());
        adminCuentaAhorros.setCuentas(cuentasAhorros.deserializacion());
        adminCuentaCorriente.setCuentas(cuentasCorrientes.deserializacion());
        //Integramos los objetos
        fachadaCuentas.setCuentasAhorros(adminCuentaAhorros);
        fachadaCuentas.setCuentasCorrientes(adminCuentaCorriente);
        cajero.setCuentas(fachadaCuentas);
        cajero.setOperaciones(adminOperaciones);
    }    
    
    private void loadData(){
        list.removeAll(list);
        String a="Ahorros";
        String b="Corriente";
        list.addAll(a,b);
        tiposCuenta.getItems().addAll(list);
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
    public void retirar() throws IOException{
        int input=JOptionPane.showConfirmDialog(null, "¿Está seguro de enviar los datos?");
        if(input==0){
            String id, tipo,cantidad,pass;
            id=codigoCuenta.getText();
            cantidad=cantidadRetiro.getText();
            pass=contrasena.getText();
            tipo=tiposCuenta.getValue();
            if(!id.equals("")&&!cantidad.equals("")&&tipo!=null&&!pass.equals("")){
                cuenta=cajero.getCuentas().buscarCuenta(id, tipo);
                if(cuenta!=null){
                    int valor=Integer.parseInt(cantidad);
                    if(valor>=20000 && valor%10000==0){
                        if(cuenta.isIsActiva()){
                            if(cuenta.verificarSaldo(valor)){
                                if(cuenta.getContrasena().equals(pass)){
                                    double saldoA=0;
                                    cajero.retirar(cuenta, valor);
                                    saldoA=cuenta.getSaldo();
                                    operaciones.serializacion(cajero.getOperaciones().getOperaciones());
                                    cuentasCorrientes.serializacion(cajero.getCuentas().getCuentasCorrientes().getCuentas());
                                    cuentasAhorros.serializacion(cajero.getCuentas().getCuentasAhorros().getCuentas());
                                    Parent root = FXMLLoader.load(getClass().getResource("Opciones.fxml"));
                                    Scene scene = new Scene(root);
                                    stage.setScene(scene);
                                    stage.show();
                                    stage.setTitle("¿Que desea hacer el dia de hoy?");
                                    stage.setResizable(false);
                                    Stage stage =(Stage) retirar.getScene().getWindow();
                                    stage.hide();
                                    System.out.println(tiposCuenta.getValue());
                                    JOptionPane.showMessageDialog(null, "El retiro se realizó con éxito.\nCuenta: "+id+"\nTipo: "+tipo+"\nCantidad: "+valor+"\nSaldo: "+saldoA);
                                }else{
                                    JOptionPane.showMessageDialog(null, "La contraseña es incorrecta.");
                                }
                                
                            }else{
                                 JOptionPane.showMessageDialog(null, "No tiene la cantidad de dinero suficiente para realizar el retiro.");
                            }                            
                        }else{
                            JOptionPane.showMessageDialog(null, "La cuenta debe estar activa para poder realizar el retiro."); 
                        }
                    }else{
                     JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad positiva y que sea multiplo de 10.000, para poder realizar el retiro.");   
                    }                    
                }else{
                    JOptionPane.showMessageDialog(null, "La cuenta no existe.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos y seleccionar el tipo de la cuenta.");
            }
        }
    }
    public void consignar() throws IOException{
        int input=JOptionPane.showConfirmDialog(null, "¿Está seguro de enviar los datos?");
        if(input==0){
            String id, tipo,cantidad;
            id=codigoCuenta.getText();
            cantidad=cantidadConsignar.getText();
            tipo=tiposCuenta.getValue();
            if(!id.equals("")&&!cantidad.equals("")&&tipo!=null){
                cuenta=cajero.getCuentas().buscarCuenta(id, tipo);
                if(cuenta!=null){
                    double valor=Double.parseDouble(cantidad);
                    if(valor>0){
                        if(cuenta.isIsActiva()){
                            cajero.consignar(cuenta, valor);
                            operaciones.serializacion(cajero.getOperaciones().getOperaciones());
                            cuentasCorrientes.serializacion(cajero.getCuentas().getCuentasCorrientes().getCuentas());
                            cuentasAhorros.serializacion(cajero.getCuentas().getCuentasAhorros().getCuentas());
                            Parent root = FXMLLoader.load(getClass().getResource("Opciones.fxml"));
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                            stage.setTitle("¿Que desea hacer el dia de hoy?");
                            stage.setResizable(false);
                            Stage stage =(Stage) consignar.getScene().getWindow();
                            stage.hide();
                            System.out.println(tiposCuenta.getValue());
                            JOptionPane.showMessageDialog(null, "La consignacion fue exitosa.\nCuenta: "+id+"\nTipo: "+tipo+"\nCantidad: "+valor);
                        }else{
                            JOptionPane.showMessageDialog(null, "La cuenta debe estar activa para poder realizar la consignación."); 
                        }
                    }else{
                     JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad positiva, para poder realizar la consignación.");   
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
