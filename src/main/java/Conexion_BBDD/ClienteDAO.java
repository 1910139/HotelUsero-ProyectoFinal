/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package Conexion_BBDD;
//import Clases.Cliente;
//import com.mycompany.hoteluseroproyectofinal.DatabaseConnection;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
///**
// *
// * @author franc
// */
//
//
//public class ClienteDAO {
//
//    public void insertarCliente(Cliente cliente) {
//        String sql = "INSERT INTO Cliente (user, pass, nif, cod, nombre, apellidos, email, tlf, sexo, nivel_Cliente, descuento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, cliente.getUser());
//            pstmt.setString(2, cliente.getPass());
//            pstmt.setString(3, cliente.getNif());
//            pstmt.setString(4, cliente.getCod());
//            pstmt.setString(5, cliente.getNombre());
//            pstmt.setString(6, cliente.getApellidos());
//            pstmt.setString(7, cliente.getEmail());
//            pstmt.setString(8, cliente.getTlf());
//            pstmt.setBoolean(9, cliente.getSexo());
//            pstmt.setInt(10, cliente.getNivel_Cliente());
//            pstmt.setFloat(11, cliente.getDescuento());
//            pstmt.executeUpdate();
//            System.out.println("Cliente insertado correctamente.");
//        } catch (SQLException e) {
//            System.out.println("Error al insertar cliente.");
//            e.printStackTrace();
//        }
//    }
//
//    public List<Cliente> obtenerTodosLosClientes() {
//        List<Cliente> clientes = new ArrayList<>();
//        String sql = "SELECT * FROM Cliente";
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql);
//             ResultSet rs = pstmt.executeQuery()) {
//            while (rs.next()) {
//                    Cliente cliente = new Cliente(
//                    rs.getString("user"),
//                    rs.getString("pass"),
//                    rs.getString("nif"),
//                    rs.getString("cod"),
//                    rs.getString("nombre"),
//                    rs.getString("apellidos"),
//                    rs.getString("email"),
//                    rs.getString("tlf"),
//                    rs.getBoolean("sexo"),
//                    rs.getInt("nivel_Cliente"),
//                    rs.getFloat("descuento")
//                );
//                clientes.add(cliente);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error al obtener clientes.");
//            e.printStackTrace();
//        }
//        return clientes;
//    }
//}
//
