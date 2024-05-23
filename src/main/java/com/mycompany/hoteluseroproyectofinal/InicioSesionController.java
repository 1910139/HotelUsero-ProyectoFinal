/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.hoteluseroproyectofinal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author franc
 */
public class InicioSesionController implements Initializable 
{
    @FXML            // Usuario que inica sesion
    private javafx.scene.control.TextField userName; // --> fx.id
    @FXML                // Contraseña del usuario
    private PasswordField userPass; 
    @FXML           // Boton recuperar contraseña
    private Button repPass;
    @FXML
    private CheckBox mostrarPass;
    @FXML           //menu para crear cuenta
    private Button btcrearCuenta;
    @FXML           //Inicia sesion
    private Button btiniciarSesion;
    @FXML           //ayuda
    private Button helpInicio;
    @FXML           // Cerrar programa
    private Button exitInicio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }

    @FXML
    private void iniciarSesion(ActionEvent event) throws IOException
    {   // Inplementar inicio de sesion
        
//     FXMLLoader fxmlloader=new FXMLLoader(App.class.getResource("MenuCliente.fxml"));
//     Scene scene=new Scene(fxmlloader.load());  
//     
//     Stage stage=new Stage();  
//     stage.setScene(scene);
//    
//     //Inhabilitar la ventana actual
//     stage.initModality(Modality.APPLICATION_MODAL);
//     stage.show();     
     
     App.cargarVentana("MenuCliente");
     
    }
/******************************************************************************/  

    @FXML
    private void crearCuenta(ActionEvent event) throws IOException
    {
 
//     FXMLLoader fxmlloader=new FXMLLoader(App.class.getResource("CreacionCuenta.fxml"));
//     Scene scene=new Scene(fxmlloader.load());  
//     
//     Stage stage=new Stage();  
//     stage.setScene(scene);
//    
//     //Inhabilitar la ventana actual
//     stage.initModality(Modality.APPLICATION_MODAL);
//     stage.show();    
     
     App.cargarVentana("CreacionCuenta");

    }       
}



//    public void datosIniciales (String usuario)
//    {
//        userActivo.setText(usuario);
//    }
    
//    void iniciarSesion(ActionEvent event) 
//    {
//        String usuario = userName.getText(); // Obtener el nombre de usuario ingresado
//        String contraseña = userPass.getText(); // Obtener la contraseña ingresada
//
//        // Aquí iría la lógica para verificar las credenciales del usuario
//        if (verificarCredenciales(usuario, contraseña)) {
//            // Credenciales válidas, navegar a la página de inicio
//            try {
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("*PAGINAINICIO*"));
//                InicioSesionController inicio = loader.getController();
//                inicio.datosIniciales(usuario); // Pasar el nombre de usuario a la página de inicio
//                Parent root = loader.load();
//
//                // Configurar la escena y mostrarla en el escenario principal
//                Scene escena = new Scene(root);
//                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                primaryStage.setScene(escena);
//                primaryStage.show();
//            } catch (IOException e) {
//                e.printStackTrace(); // Manejar cualquier excepción de carga de FXML
//            }
//        } else {
//            // Credenciales inválidas, mostrar un mensaje de error
//            errorInicio.setText("Nombre de usuario o contraseña incorrectos");
//        }
//    }
//
//    // Método para verificar las credenciales del usuario (simulado)
//    private boolean verificarCredenciales(String usuario, String contraseña) {
//        // Simplemente para demostración, aquí se compararían las credenciales con datos reales
//        // Por ejemplo, verificar en una base de datos
//        // En esta implementación simulada, se acepta cualquier nombre de usuario y contraseña
//        return true;
//    }
