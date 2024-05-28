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

/* 
CREATE TABLE Administrador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    pass VARCHAR(20) NOT NULL
);

CREATE TABLE Persona (
    id INT AUTO_INCREMENT NOT NULL,
    user VARCHAR(20),
    pass VARCHAR(20) NOT NULL,
    nif VARCHAR(9) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    tlf VARCHAR(15) NOT NULL,
    sexo VARCHAR(15),
    rol VARCHAR(20) NOT NULL DEFAULT 'cliente',
    PRIMARY KEY (id),
    UNIQUE (user)
);


CREATE TABLE Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nivel_cliente INT NOT NULL,
    descuento FLOAT NOT NULL,
    FOREIGN KEY (id) REFERENCES Persona(id)
);

CREATE TABLE Empleado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rol VARCHAR(50) NOT NULL,
    FOREIGN KEY (id) REFERENCES Persona(id)
);


CREATE TABLE Habitacion (
    cod_habitacion INT AUTO_INCREMENT PRIMARY KEY,
    num_habitacion INT NOT NULL,
    planta_habitacion INT NOT NULL,
    tipo_habitacion INT NOT NULL,
    ocupada_hab BOOLEAN NOT NULL,
    inicio_ocupacion DATE,
    fin_ocupacion DATE
);


INSERT INTO Administrador (nombre, apellidos, email, pass) VALUES
('Admin', 'ad', 'admin1@example.com', '1234'),
('FranciscoAd', 'Apellido2', 'admin2@example.com', 'qwerty');

INSERT INTO Persona (user, pass, nif, nombre, apellidos, email, tlf, sexo)
VALUES ('francisco', 'qwerty', '25568423B', 'Francisco', 'Fernandez Fernandez', 'francisco@example.com', '123456789', 0);
INSERT INTO Cliente (id, nivel_cliente, descuento)
VALUES (LAST_INSERT_ID(), 100, 50);
*/