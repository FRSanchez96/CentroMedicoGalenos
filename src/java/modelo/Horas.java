/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Felipe
 */
public class Horas {
    private int Id_Hora;
    private String Hor_Dia;

    public Horas() {
    }

    public Horas(int Id_Hora, String Hor_Dia) {
        this.Id_Hora = Id_Hora;
        this.Hor_Dia = Hor_Dia;
    }

    public int getId_Hora() {
        return Id_Hora;
    }

    public void setId_Hora(int Id_Hora) {
        this.Id_Hora = Id_Hora;
    }

    public String getHor_Dia() {
        return Hor_Dia;
    }

    public void setHor_Dia(String Hor_Dia) {
        this.Hor_Dia = Hor_Dia;
    }
    
    
}
