/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Calendar;

/**
 *
 * @author franc
 */

public class Habitacion {
    private int cod_Habitacion;
    private int num_Habitacion;
    private int planta_Habitacion;
    private int tipo_Habitacion;
    private boolean ocupada_Hab;
    private Calendar inicio_Ocupacion;
    private Calendar fin_Ocupacion;

    // Constructor
    public Habitacion(int cod_Habitacion, int num_Habitacion, int planta_Habitacion, int tipo_Habitacion, boolean ocupada_Hab, Calendar inicio_Ocupacion, Calendar fin_Ocupacion) {
        this.cod_Habitacion = cod_Habitacion;
        this.num_Habitacion = num_Habitacion;
        this.planta_Habitacion = planta_Habitacion;
        this.tipo_Habitacion = tipo_Habitacion;
        this.ocupada_Hab = ocupada_Hab;
        this.inicio_Ocupacion = inicio_Ocupacion;
        this.fin_Ocupacion = fin_Ocupacion;
    }

    // Getters y Setters
    public int getCod_Habitacion() {
        return cod_Habitacion;
    }

    public void setCod_Habitacion(int cod_Habitacion) {
        this.cod_Habitacion = cod_Habitacion;
    }

    public int getNum_Habitacion() {
        return num_Habitacion;
    }

    public void setNum_Habitacion(int num_Habitacion) {
        this.num_Habitacion = num_Habitacion;
    }

    public int getPlanta_Habitacion() {
        return planta_Habitacion;
    }

    public void setPlanta_Habitacion(int planta_Habitacion) {
        this.planta_Habitacion = planta_Habitacion;
    }

    public int getTipo_Habitacion() {
        return tipo_Habitacion;
    }

    public void setTipo_Habitacion(int tipo_Habitacion) {
        this.tipo_Habitacion = tipo_Habitacion;
    }

    public boolean isOcupada_Hab() {
        return ocupada_Hab;
    }

    public void setOcupada_Hab(boolean ocupada_Hab) {
        this.ocupada_Hab = ocupada_Hab;
    }

    public Calendar getInicio_Ocupacion() {
        return inicio_Ocupacion;
    }

    public void setInicio_Ocupacion(Calendar inicio_Ocupacion) {
        this.inicio_Ocupacion = inicio_Ocupacion;
    }

    public Calendar getFin_Ocupacion() {
        return fin_Ocupacion;
    }

    public void setFin_Ocupacion(Calendar fin_Ocupacion) {
        this.fin_Ocupacion = fin_Ocupacion;
    }
}