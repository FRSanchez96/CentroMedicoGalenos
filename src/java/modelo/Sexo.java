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
public class Sexo {
  
    private int Id_Sexo;
    private String Nombre;

    public Sexo() {
    }

    public Sexo(int Id_Sexo, String Nombre) {
        this.Id_Sexo = Id_Sexo;
        this.Nombre = Nombre;
    }
    
    public int getId_Sexo() {
        return Id_Sexo;
    }

    public void setId_Sexo(int Id_Sexo) {
        this.Id_Sexo = Id_Sexo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
}
