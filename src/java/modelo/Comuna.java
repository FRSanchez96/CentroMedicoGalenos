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
public class Comuna {

    private String Id_Comu,Nombre,Id_Ciud;

    public Comuna() {
    }

    public Comuna(String Id_Comu, String Nombre, String Id_Ciud) {
        this.Id_Comu = Id_Comu;
        this.Nombre = Nombre;
        this.Id_Ciud = Id_Ciud;
    }
    
    public String getId_Comu() {
        return Id_Comu;
    }

    public void setId_Comu(String Id_Comu) {
        this.Id_Comu = Id_Comu;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getId_Ciud() {
        return Id_Ciud;
    }

    public void setId_Ciud(String Id_Ciud) {
        this.Id_Ciud = Id_Ciud;
    }
    
    
}
