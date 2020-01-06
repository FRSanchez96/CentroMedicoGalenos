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
public class Dia {
    private int Id_Dia;
    private String Nombre;

    public Dia() {
    }

    public Dia(int Id_Dia, String Nombre) {
        this.Id_Dia = Id_Dia;
        this.Nombre = Nombre;
    }

    public int getId_Dia() {
        return Id_Dia;
    }

    public void setId_Dia(int Id_Dia) {
        this.Id_Dia = Id_Dia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
}
