/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.hoteluseroproyectofinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author franc
 */
public class AdAñadirEmpleadoController implements Initializable 
{

    
    @FXML
    private Button btCrearCrearCuenta;

    @FXML
    private Button btVolverInicioCrear;

    @FXML
    private TextField cApellidosUser;

    @FXML
    private PasswordField cCContrasena;

    @FXML
    private PasswordField cContrasena;

    @FXML
    private TextField cEmail;

    @FXML
    private TextField cNUser;

    @FXML
    private TextField cNombreUser;

    @FXML
    private TextField cNumeroTLF;

    @FXML
    private TextField cRol;

    @FXML
    private TextField cRolEmpleado;

    @FXML
    private TextField cSexo;

    @FXML
    private TextField cnif;

    @FXML
    private Button exitC;

    @FXML
    private Button helpCreacioC;

    @FXML
    void actionSalir(ActionEvent event) throws IOException 
    {
        App.cargarVentana("confirmarSalir");
        Stage ventana = (Stage) this.exitC.getScene().getWindow(); //cerrar ventana 
        ventana.close();
    }


    @FXML
    void volverInicioSe(ActionEvent event) throws IOException 
    {
        App.cargarVentana("menuAdmin");
        Stage ventana = (Stage) this.btVolverInicioCrear.getScene().getWindow(); //cerrar ventana 
        ventana.close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
    @FXML
    private void adCrearCuentaCEmpleado(ActionEvent event) 
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
        String rol = cRolEmpleado.getText(); // Se asume que se está añadiendo un empleado

        // Validar campos vacíos
        if (user.isEmpty() || pass.isEmpty() || confirmarPass.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() ||
                nif.isEmpty() || email.isEmpty() || numeroTLF.isEmpty() || sexo.isEmpty() || rol.isEmpty()) 
        {
            mostrarAlerta("Error", "Todos los campos son obligatorios.", Alert.AlertType.ERROR);
            return;
        }

        // Verificar si las contraseñas coinciden
        if (!pass.equals(confirmarPass)) 
        {
            mostrarAlerta("Error", "Las contraseñas no coinciden.", Alert.AlertType.ERROR);
            return;
        }

        // Verificar si el usuario ya existe
        if (!usuarioExiste(user)) 
        {
            // Insertar empleado
            insertarEmpleado(user, pass, nombre, apellidos, nif, email, numeroTLF, sexo, rol);
        } else {
            mostrarAlerta("Error", "El nombre de usuario ya está en uso.", Alert.AlertType.ERROR);
        }
    }

    private boolean usuarioExiste(String user) {
        String query = "SELECT * FROM empleado WHERE user = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Devuelve true si encuentra alguna coincidencia
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return true; // En caso de error, asumimos que el usuario existe para evitar problemas
        }
    }

    private void insertarEmpleado(String user, String pass, String nombre, String apellidos, String nif,
                                   String email, String numeroTLF, String sexo, String rol) {
        String query = "INSERT INTO empleado (user, pass, nombre, apellidos, nif, email, telefono, sexo, rol) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            preparedStatement.setString(3, nombre);
            preparedStatement.setString(4, apellidos);
            preparedStatement.setString(5, nif);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, numeroTLF);
            preparedStatement.setString(8, sexo);
            preparedStatement.setString(9, rol);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                mostrarAlerta("Éxito", "Usuario creado correctamente.", Alert.AlertType.INFORMATION);
            } else {
                mostrarAlerta("Error", "No se pudo crear el usuario.", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo crear el usuario.", Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
