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
public class Cliente extends Persona implements Serializable
{
    private int nivel_Cliente;
   private float descuento;
   
   public Cliente (String user, String pass, String nif, String cod, String nombre, 
  /*{*/            String apellidos, String email, String tlf, 
  /*{*/            Boolean sexo, int nivel_Cliente, float descuento)
   {
        super(user, pass, nif, cod, nombre, apellidos, email, tlf, sexo);
        this.nivel_Cliente = nivel_Cliente;
        this.descuento = descuento;
   }
   
        public int getNivel_Cliente() 
        {
            return nivel_Cliente;
        }

        public void setNivel_Cliente(int nivel_Cliente) 
        {
            this.nivel_Cliente = nivel_Cliente;
        }

        public float getDescuento()
        {
            return descuento;
        }

        public void setDescuento(float descuento) 
        {
            this.descuento = descuento;
        }
}
