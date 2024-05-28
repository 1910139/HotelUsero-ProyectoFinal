/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hoteluseroproyectofinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author franc
 */
public class DatabaseConnection 
{
    private static final String URL = "jdbc:mysql://localhost:3307/hotelusero";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {
        Connection connection = null;
        try 
        {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos MySQL");
        } catch (SQLException e) 
        {
            System.out.println("Error al conectar a la base de datos MySQL");
            e.printStackTrace();
        }
        return connection;
    }
}
