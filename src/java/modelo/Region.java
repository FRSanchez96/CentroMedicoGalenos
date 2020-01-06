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
public class Region {
    
    private int Id_Regi;
    private String Nombre;
    private int Pais_Id_Pais;

    public Region() {
    }

    public Region(int Id_Regi, String Nombre, int Pais_Id_Pais) {
        this.Id_Regi = Id_Regi;
        this.Nombre = Nombre;
        this.Pais_Id_Pais = Pais_Id_Pais;
    }

    
    
    public int getId_Regi() {
        return Id_Regi;
    }

    public void setId_Regi(int Id_Regi) {
        this.Id_Regi = Id_Regi;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPais_Id_Pais() {
        return Pais_Id_Pais;
    }

    public void setPais_Id_Pais(int Pais_Id_Pais) {
        this.Pais_Id_Pais = Pais_Id_Pais;
    }
    
    
    
}
