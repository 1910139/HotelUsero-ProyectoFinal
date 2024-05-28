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
import java.sql.Statement;
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

        System.out.println("Datos recibidos: " + user + ", " + pass + ", " + confirmarPass);

        if (!usuarioExiste(user)) 
        {
            if (pass.equals(confirmarPass)) 
            {
                insertarUsuario(user, pass, nombre, apellidos, nif, email, numeroTLF, sexo);
                // Si se desea, se puede redirigir a otra ventana (por ejemplo, la ventana de inicio de sesión) aquí
            } else {
                mostrarAlerta("Error", "Las contraseñas no coinciden", Alert.AlertType.ERROR);
            }
        } else {
            mostrarAlerta("Error", "El nombre de usuario ya está en uso", Alert.AlertType.ERROR);
        }
    }
    
    private boolean usuarioExiste(String user) 
    {
        String query = "SELECT * FROM Persona WHERE user = ?";
        try (Connection connection = DatabaseConnection.getConnection();
      /*{*/  PreparedStatement preparedStatement = connection.prepareStatement(query)) 
        {
            preparedStatement.setString(1, user);
            try (ResultSet resultSet = preparedStatement.executeQuery()) 
            {
                return resultSet.next(); // Devuelve true si encuentra alguna coincidencia
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return true; // En caso de error, asumimos que el usuario existe para evitar problemas
        }
    }

    private void insertarUsuario(String user, String pass, String nombre, String apellidos, String nif, String email, String numeroTLF, String sexo) 
    {
        String query = "INSERT INTO Persona (user, pass, nif, nombre, apellidos, email, tlf, sexo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
      /*{*/  PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) 
        {
                preparedStatement.setString(1, user);
                preparedStatement.setString(2, pass);
                preparedStatement.setString(3, nif);
                preparedStatement.setString(4, nombre);
                preparedStatement.setString(5, apellidos);
                preparedStatement.setString(6, email);
                preparedStatement.setString(7, numeroTLF);
                preparedStatement.setString(8, sexo);
                int affectedRows = preparedStatement.executeUpdate();
                if (affectedRows == 0) 
                {
                    throw new SQLException("No se pudo insertar el usuario");
                }
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) 
                {
                    if (generatedKeys.next()) 
                    {
                        int userId = generatedKeys.getInt(1);
                        insertarCliente(userId); // Insertar cliente después de insertar la persona
                    } else 
                    {
                        throw new SQLException("No se pudo obtener el ID generado del usuario");
                    }
                }
                    mostrarAlerta("Éxito", "Usuario creado correctamente", Alert.AlertType.INFORMATION);
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo crear el usuario", Alert.AlertType.ERROR);
            }
    }

    private void insertarCliente(int userId) 
    {
        String query = "INSERT INTO Cliente (id, nivel_cliente, descuento) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
      /*{*/  PreparedStatement preparedStatement = connection.prepareStatement(query)) 
        {
            preparedStatement.setInt(1, userId);
            // Define el nivel de cliente y descuento según sea necesario
            preparedStatement.setInt(2, 1); // Ejemplo: nivel de cliente 1
            preparedStatement.setFloat(3, 0.1f); // Ejemplo: descuento del 10%
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar errores de inserción del cliente si es necesario
        }
    }
    
    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) 
    {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setContentText(contenido);
        alerta.showAndWait();
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
     //salir
    @FXML
    private void actionSalir(ActionEvent event) throws IOException 
    {
        App.cargarVentana("confirmarSalir");
    }
/******************************************************************************/
}