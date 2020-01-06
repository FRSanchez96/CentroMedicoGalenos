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
public class Ciudad {
    
    private String Id_Ciudad;
    private String Nombre;
    private int Regi_Id;

    public Ciudad() {
    }

    public Ciudad(String Id_Ciudad, String Nombre, int Regi_Id) {
        this.Id_Ciudad = Id_Ciudad;
        this.Nombre = Nombre;
        this.Regi_Id = Regi_Id;
    }

    public String getId_Ciudad() {
        return Id_Ciudad;
    }

    public void setId_Ciudad(String Id_Ciudad) {
        this.Id_Ciudad = Id_Ciudad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getRegi_Id() {
        return Regi_Id;
    }

    public void setRegi_Id(int Regi_Id) {
        this.Regi_Id = Regi_Id;
    }
    
    
}
