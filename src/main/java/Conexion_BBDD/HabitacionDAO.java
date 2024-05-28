/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion_BBDD;

//import Clases.Habitacion;
//import com.mycompany.hoteluseroproyectofinal.DatabaseConnection;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
///**
// *
// * @author franc
// */
//
//public class HabitacionDAO {
//    public void insertarHabitacion(Habitacion habitacion) {
//        String query = "INSERT INTO habitacion (cod_Habitacion, num_Habitacion, planta_Habitacion, tipo_Habitacion, ocupada_Hab, inicio_Ocupacion, fin_Ocupacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(query)) {
//
//            statement.setInt(1, habitacion.getCod_Habitacion());
//            statement.setInt(2, habitacion.getNum_Habitacion());
//            statement.setInt(3, habitacion.getPlanta_Habitacion());
//            statement.setInt(4, habitacion.getTipo_Habitacion());
//            statement.setBoolean(5, habitacion.isOcupada_Hab());
//            statement.setDate(6, new Date(habitacion.getInicio_Ocupacion().getTimeInMillis()));
//            statement.setDate(7, new Date(habitacion.getFin_Ocupacion().getTimeInMillis()));
//
//            statement.executeUpdate();
//            System.out.println("Habitacion insertada correctamente.");
//        } catch (SQLException e) {
//            System.out.println("Error al insertar la habitacion.");
//            e.printStackTrace();
//        }
//    }
//}