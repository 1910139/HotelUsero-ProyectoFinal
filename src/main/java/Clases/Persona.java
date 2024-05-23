/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author franc
 */
public class Persona 
{
    
    private String user;
    private String pass;
    private String nif;
    private String cod;
    private String nombre;
    private String apellidos;
    private String email;
    private String tlf;
    private Boolean sexo; 
    
    /*
    Constructor
    */
    public Persona (String user, String pass, String nif, String cod, String nombre, 
  /*{*/             String apellidos, String email, String tlf, Boolean sexo)
    {
        this.user = user;
        this.pass = pass;
        this.nif = nif;
        this.cod = cod;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.tlf = tlf;
        this.sexo = sexo;
    }
    

    public String getUser() 
    {
        return user;
    }

    public void setUser(String user) 
    {
        this.user = user;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public String getNif() 
    {
        return nif;
    }

    public void setNif(String nif) 
    {
        this.nif = nif;
    }

    public String getCod() 
    {
        return cod;
    }

    public void setCod(String cod) 
    {
        this.cod = cod;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTlf() 
    {
        return tlf;
    }

    public void setTlf(String tlf) 
    {
        this.tlf = tlf;
    }

    public Boolean getSexo() 
    {
        return sexo;
    }

    public void setSexo(Boolean sexo) 
    {
        this.sexo = sexo;
    }
}
