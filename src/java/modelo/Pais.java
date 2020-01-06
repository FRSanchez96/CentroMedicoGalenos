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
public class Pais {
    
    private int Id_Pais;
    private String Nombre;
    private int Id_Feri;

    public Pais() {
    }

    public Pais(int Id_Pais, String Nombre, int Id_Feri) {
        this.Id_Pais = Id_Pais;
        this.Nombre = Nombre;
        this.Id_Feri = Id_Feri;
    }
    
    

    public int getId_Pais() {
        return Id_Pais;
    }

    public void setId_Pais(int Id_Pais) {
        this.Id_Pais = Id_Pais;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getId_Feri() {
        return Id_Feri;
    }

    public void setId_Feri(int Id_Feri) {
        this.Id_Feri = Id_Feri;
    }
    
}
