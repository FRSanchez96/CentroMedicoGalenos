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
public class Especialidad {
    
    private int Id_Espe;
    private String Nombre_Esp;
    private int Canti_Modu;
    private int Coste_Comision;

    public Especialidad() {
    }
    
    
    public Especialidad(int Id_Espe, String Nombre_Esp, int Canti_Modu, int Coste_Comision) {
        this.Id_Espe = Id_Espe;
        this.Nombre_Esp = Nombre_Esp;
        this.Canti_Modu = Canti_Modu;
        this.Coste_Comision = Coste_Comision;
    }

    public int getId_Espe() {
        return Id_Espe;
    }

    public void setId_Espe(int Id_Espe) {
        this.Id_Espe = Id_Espe;
    }

    public String getNombre_Esp() {
        return Nombre_Esp;
    }

    public void setNombre_Esp(String Nombre_Esp) {
        this.Nombre_Esp = Nombre_Esp;
    }

    public int getCanti_Modu() {
        return Canti_Modu;
    }

    public void setCanti_Modu(int Canti_Modu) {
        this.Canti_Modu = Canti_Modu;
    }

    public int getCoste_Comision() {
        return Coste_Comision;
    }

    public void setCoste_Comision(int Coste_Comision) {
        this.Coste_Comision = Coste_Comision;
    }
    
    
    
}
