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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author franc
 */
public class CrearCuentaController implements Initializable 
{
    @FXML             // Usuario
    private TextField cNUser;
    @FXML                 // Contraseña
    private PasswordField cContrasena;
    @FXML                   // Confirmar Contraseña    
    private PasswordField cCContrasena;
    @FXML             // Nombre usuario
    private TextField cNombreUser;
    @FXML             // Apellidos usuario
    private TextField cApellidosUser;
    @FXML             // email usuario
    private TextField cEmail;
    @FXML             // numero usuario
    private TextField cNumeroTLF;
    @FXML             // sexo usuario
    private TextField cSexo;
    @FXML
    private Button exitC;
    @FXML
    private Button helpCreacioC;
    @FXML
    private Button btCrearCrearCuenta;
    @FXML
    private Button btVolverInicioCrear;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
     private void volverInicioSe(ActionEvent event) throws IOException
     {
  
     App.cargarVentana("inicioSesion");
     Stage ventana = (Stage) this.btVolverInicioCrear.getScene().getWindow(); //cerrar ventana 
     ventana.close();
     }
}
