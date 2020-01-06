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
public class Sucursal {
    
    private  int Id_Sucursal;
    private  String Nom_Sucursal,Direccion;
    private int Numeracion,Id_Comu,Coste_Comicion;

    public Sucursal() {
    }

    public Sucursal(int Id_Sucursal, String Nom_Sucursal, String Direccion, int Numeracion, int Id_Comu, int Coste_Comicion) {
        this.Id_Sucursal = Id_Sucursal;
        this.Nom_Sucursal = Nom_Sucursal;
        this.Direccion = Direccion;
        this.Numeracion = Numeracion;
        this.Id_Comu = Id_Comu;
        this.Coste_Comicion = Coste_Comicion;
    }

    public int getId_Sucursal() {
        return Id_Sucursal;
    }

    public void setId_Sucursal(int Id_Sucursal) {
        this.Id_Sucursal = Id_Sucursal;
    }

    public String getNom_Sucursal() {
        return Nom_Sucursal;
    }

    public void setNom_Sucursal(String Nom_Sucursal) {
        this.Nom_Sucursal = Nom_Sucursal;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getNumeracion() {
        return Numeracion;
    }

    public void setNumeracion(int Numeracion) {
        this.Numeracion = Numeracion;
    }

    public int getId_Comu() {
        return Id_Comu;
    }

    public void setId_Comu(int Id_Comu) {
        this.Id_Comu = Id_Comu;
    }

    public int getCoste_Comicion() {
        return Coste_Comicion;
    }

    public void setCoste_Comicion(int Coste_Comicion) {
        this.Coste_Comicion = Coste_Comicion;
    }
    
    
    
}
