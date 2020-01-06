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
public class Prevision {
    
    private int Id_Prevision;
    private String Nombre;

    public Prevision() {
    }

    public Prevision(int Id_Prevision, String Nombre) {
        this.Id_Prevision = Id_Prevision;
        this.Nombre = Nombre;
    }
    
    

    public int getId_Prevision() {
        return Id_Prevision;
    }

    public void setId_Prevision(int Id_Prevision) {
        this.Id_Prevision = Id_Prevision;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
