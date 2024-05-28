/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package Conexion_BBDD;
//
//import Clases.Empleado;
//import com.mycompany.hoteluseroproyectofinal.DatabaseConnection;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
///**
// *
// * @author franc
// */
//
//public class EmpleadoDAO {
//    public void insertarEmpleado(Empleado empleado) {
//        String query = "INSERT INTO empleado (user, pass, nif, cod, nombre, apellidos, email, tlf, sexo, rol) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(query)) {
//
//            statement.setString(1, empleado.getUser());
//            statement.setString(2, empleado.getPass());
//            statement.setString(3, empleado.getNif());
//            statement.setString(4, empleado.getCod());
//            statement.setString(5, empleado.getNombre());
//            statement.setString(6, empleado.getApellidos());
//            statement.setString(7, empleado.getEmail());
//            statement.setString(8, empleado.getTlf());
//            statement.setBoolean(9, empleado.getSexo());
//            statement.setString(10, empleado.getRol());
//
//            statement.executeUpdate();
//            System.out.println("Empleado insertado correctamente.");
//        } catch (SQLException e) {
//            System.out.println("Error al insertar el empleado.");
//            e.printStackTrace();
//        }
//    }
//}