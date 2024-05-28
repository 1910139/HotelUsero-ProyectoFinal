/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author franc
 */

public class Empleado extends Persona implements Serializable {
    private String rol;

    // Constructor
    public Empleado(String user, String pass, String nif, String cod, String nombre, String apellidos, 
                    String email, String tlf, Boolean sexo, String cod_Empleado, int nivel_Empleado, String rol) {
        super(user, pass, nif, cod, nombre, apellidos, email, tlf, sexo);
        this.rol = rol;
    }

    // Getters y Setters
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
