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
public class DetalleDoctorSucu {
    
    private int Doctor_Rut, Id_Sucu;

    public DetalleDoctorSucu() {
    }

    public DetalleDoctorSucu(int Doctor_Rut, int Id_Sucu) {
        this.Doctor_Rut = Doctor_Rut;
        this.Id_Sucu = Id_Sucu;
    }

    public int getDoctor_Rut() {
        return Doctor_Rut;
    }

    public void setDoctor_Rut(int Doctor_Rut) {
        this.Doctor_Rut = Doctor_Rut;
    }

    public int getId_Sucu() {
        return Id_Sucu;
    }

    public void setId_Sucu(int Id_Sucu) {
        this.Id_Sucu = Id_Sucu;
    }
    
    
    
    
    
}
