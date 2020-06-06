/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author andres
 */
public class ControllerOpciones implements Initializable{
    @FXML
    private javafx.scene.control.Button retirarInactiva,empezar,retirar,consignar,crearCuenta,activarCuenta,desactivarCuenta,persona,compania;
    private Stage stage=new Stage();
    public void abrirOpciones(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Opciones.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("¿Que desea hacer el dia de hoy?");
        stage.setResizable(false);
        Stage stage =(Stage) empezar.getScene().getWindow();
        stage.hide();
    }
     public void abrirRetirar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Retirar.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Retirar");
        stage.setResizable(false);
        Stage stage =(Stage) retirar.getScene().getWindow();
        stage.hide();
    }
     public void abrirConsignar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Consignar.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Consignar");
        stage.setResizable(false);
        Stage stage =(Stage) consignar.getScene().getWindow();
        stage.hide();
    }
     public void abrirCrearCuenta(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CrearCuenta.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Crear Cuenta");
        stage.setResizable(false);
        Stage stage =(Stage) crearCuenta.getScene().getWindow();
        stage.hide();
    }
     public void abrirActivarCuenta(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ActivarCuenta.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Activar Cuenta");
        stage.setResizable(false);
        Stage stage =(Stage) activarCuenta.getScene().getWindow();
        stage.hide();
    }
     public void abrirDesactivarCuenta(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DesactivarCuenta.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Desactivar Cuenta");
        stage.setResizable(false);
        Stage stage =(Stage) desactivarCuenta.getScene().getWindow();
        stage.hide();
    }
     public void abrirRegistroPersona(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RegistrarCliente.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Registrar Persona");
        stage.setResizable(false);
        Stage stage =(Stage) persona.getScene().getWindow();
        stage.hide();
    }
     public void abrirRegistroCompania(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RegistrarCompania.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Registrar Compañia");
        stage.setResizable(false);
        Stage stage =(Stage) compania.getScene().getWindow();
        stage.hide();
    }
     public void abrirConfirmacioncuenta(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ConfirmacionAsociacion.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("StarBank");
        stage.setResizable(false);
        Stage stage =(Stage) crearCuenta.getScene().getWindow();
        stage.hide();
    }
    public void recomendacion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Opciones.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("¿Que desea hacer el dia de hoy?");
        stage.setResizable(false);
        JOptionPane.showMessageDialog(null, "Cree una cuenta, sea personal o para una empresa. En la sección registrarse");
        Stage stage =(Stage) empezar.getScene().getWindow();
        stage.hide();
    }
    
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO;
    }
}
