/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.hoteluseroproyectofinal;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.TextField;

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
    @FXML             // numero usuario
    private TextField avisos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
/******************************************************************************/    //arreglar
        // Mostrar contraseñas
        mostrarPass.setOnAction(event -> 
        {
            // Cambiar la visibilidad del campo de texto
            userPass.setVisible(mostrarPass.isSelected());

            // Si la caja esta encendida se muestran las contraseñas
            if (mostrarPass.isSelected()) 
            {
                userPass.setText(userPass.getText());
            }
        });
/******************************************************************************/
    }

    
    
/******************************************************************************/
        //Inicio de sesion prueba base de datos
    @FXML
    private void iniciarSesion(ActionEvent event) throws IOException 
    {
        String user = userName.getText();
        String pass = userPass.getText(); 

        if (validarCredenciales(user, pass)) 
        {
            String rol = obtenerRolUsuario(user);
            switch (rol.toLowerCase()) 
            {
                case "cliente":
                    App.cargarVentana("menuCliente");
                    break;
                case "empleado":
                    App.cargarVentana("menuEmpleado");
                    break;
                case "administrador":
                    App.cargarVentana("menuAdmin");
                    break;
                default:
                    avisos.setText("Tipo de usuario desconocido");
                    System.out.println("Tipo de usuario desconocido");
                    break;
            }
            Stage ventana = (Stage) this.btiniciarSesion.getScene().getWindow();
            ventana.close();
        } else {
            avisos.setText("Credenciales incorrectas");
            System.out.println("Credenciales incorrectas");
        }
    }
   
    private String obtenerRolUsuario(String user) 
    {
        String personaQuery = "SELECT rol FROM persona WHERE user = ?";
        String adminQuery = "SELECT 'administrador' AS rol FROM administrador WHERE nombre = ?";
        try (Connection connection = DatabaseConnection.getConnection();
      /*{*/  PreparedStatement personaStatement = connection.prepareStatement(personaQuery);
      /*{*/  PreparedStatement adminStatement = connection.prepareStatement(adminQuery)) 
        {

            // Comprobación en la tabla Persona (cliente o empleado)
            personaStatement.setString(1, user);
            ResultSet personaResultSet = personaStatement.executeQuery();
            if (personaResultSet.next()) 
            {
                return personaResultSet.getString("rol");
            }

            // Comprobación en la tabla Administrador
            adminStatement.setString(1, user);
            ResultSet adminResultSet = adminStatement.executeQuery();
            if (adminResultSet.next()) 
            {
                return adminResultSet.getString("rol");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "desconocido";
    }
    
    
/******************************************************************************/
//ir al menu de crear cuenta    
    @FXML
    private void crearCuenta(ActionEvent event) throws IOException 
    {
        App.cargarVentana("crearCuenta");
        Stage ventana = (Stage) this.btcrearCuenta.getScene().getWindow(); //cerrar ventana 
        ventana.close();
    }
    
    
    //salir
    @FXML
    private void actionSalir(ActionEvent event) throws IOException 
    {
        App.cargarVentana("confirmarSalir");
    }

/******************************************************************************/       
    //hace una consulta en la base de datos para enviarsela al if de comprobar usuario
    private boolean validarCredenciales(String user, String pass) 
    {
    String personaQuery = "SELECT * FROM Persona WHERE user = ? AND pass = ?";
    String adminQuery = "SELECT * FROM Administrador WHERE nombre = ? AND pass = ?";
    
    try (Connection connection = DatabaseConnection.getConnection();  
  /*{*/  PreparedStatement personaStatement = connection.prepareStatement(personaQuery);
  /*{*/  PreparedStatement adminStatement = connection.prepareStatement(adminQuery)) 
    {
        
        // Comprobación en la tabla Persona (cliente o empleado)
        personaStatement.setString(1, user);
        personaStatement.setString(2, pass);
        ResultSet personaResultSet = personaStatement.executeQuery();
        if (personaResultSet.next()) 
        {
            String rol = personaResultSet.getString("rol");
            if (rol.equalsIgnoreCase("cliente")) 
            {
                return true; // Cliente
            } else if (rol.equalsIgnoreCase("empleado")) {
                // Hacer algo para manejar el inicio de sesión de un empleado
                return true; // Suponiendo que también se inicia sesión para un empleado
            }
        }
        
        // Comprobación en la tabla Administrador
        adminStatement.setString(1, user);
        adminStatement.setString(2, pass);
        ResultSet adminResultSet = adminStatement.executeQuery();
        if (adminResultSet.next()) {
            // Hacer algo para manejar el inicio de sesión de un administrador
            return true; // Suponiendo que también se inicia sesión para un administrador
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return false;
    }
/******************************************************************************/         
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
