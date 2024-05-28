/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.hoteluseroproyectofinal;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    @FXML           // NIF / DNI
    private TextField cnif;
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

/******************************************************************************/
    @FXML
    private void crearCuenta(ActionEvent event) throws IOException 
    {
        String user = cNUser.getText();
        String pass = cContrasena.getText();
        String confirmarPass = cCContrasena.getText();
        String nombre = cNombreUser.getText();
        String apellidos = cApellidosUser.getText();
        String nif = cnif.getText();
        String email = cEmail.getText();
        String numeroTLF = cNumeroTLF.getText();
        String sexo = cSexo.getText();

        if (!usuarioExiste(user)) 
        {
            if (pass.equals(confirmarPass)) 
            {
                insertarUsuario(user, pass, nombre, apellidos, nif, email, numeroTLF, sexo);
                // Si se desea, se puede redirigir a otra ventana (por ejemplo, la ventana de inicio de sesión) aquí
            } else 
            {
                // Mostrar mensaje de error indicando que las contraseñas no coinciden
            }
        } else 
        {
            // Mostrar mensaje de error indicando que el nombre de usuario ya está en uso
        }
    }
    private boolean usuarioExiste(String user) 
    {
        String query = "SELECT * FROM tabla_usuarios WHERE nombre_usuario = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) 
        {
            preparedStatement.setString(1, user);
            try (ResultSet resultSet = preparedStatement.executeQuery()) 
            {
                return resultSet.next(); // Devuelve true si encuentra alguna coincidencia
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            return true; // En caso de error, asumimos que el usuario existe para evitar problemas
        }
    }

    private void insertarUsuario(String user, String pass, String nombre, String apellidos, String nif, String email, String numeroTLF, String sexo) 
    {
        String query = "INSERT INTO tabla_usuarios (nombre_usuario, contraseña, nombre, apellidos, nif, email, numero_telefono, sexo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) 
        {
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            preparedStatement.setString(3, nombre);
            preparedStatement.setString(4, apellidos);
            preparedStatement.setString(5, nif);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, numeroTLF);
            preparedStatement.setString(8, sexo);
            preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            // Manejar errores de inserción si es necesario
        }
    }

//Vuelve a la pantalla de iniciar sesion
/******************************************************************************/
    @FXML
    private void volverInicioSe(ActionEvent event) throws IOException 
    {
        App.cargarVentana("inicioSesion");
        Stage ventana = (Stage) this.btVolverInicioCrear.getScene().getWindow(); //cerrar ventana 
        ventana.close();
    }
/******************************************************************************/
}