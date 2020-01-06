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
public class Telefono {
    
    private int Id_Telefono,Numero;
    private String Descripcion;
    private int Rut_Pers,Id_Teti;

    public Telefono() {
    }

    public Telefono(int Id_Telefono, int Numero, String Descripcion, int Rut_Pers, int Id_Teti) {
        this.Id_Telefono = Id_Telefono;
        this.Numero = Numero;
        this.Descripcion = Descripcion;
        this.Rut_Pers = Rut_Pers;
        this.Id_Teti = Id_Teti;
    }

    public int getId_Telefono() {
        return Id_Telefono;
    }

    public void setId_Telefono(int Id_Telefono) {
        this.Id_Telefono = Id_Telefono;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getRut_Pers() {
        return Rut_Pers;
    }

    public void setRut_Pers(int Rut_Pers) {
        this.Rut_Pers = Rut_Pers;
    }

    public int getId_Teti() {
        return Id_Teti;
    }

    public void setId_Teti(int Id_Teti) {
        this.Id_Teti = Id_Teti;
    }
    
    
    
}
