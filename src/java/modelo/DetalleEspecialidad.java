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
public class DetalleEspecialidad {
    
    private int DoctorRut, Id_Espe;

    public DetalleEspecialidad() {
    }

    public DetalleEspecialidad(int DoctorRut, int Id_Espe) {
        this.DoctorRut = DoctorRut;
        this.Id_Espe = Id_Espe;
    }

    public int getDoctorRut() {
        return DoctorRut;
    }

    public void setDoctorRut(int DoctorRut) {
        this.DoctorRut = DoctorRut;
    }

    public int getId_Espe() {
        return Id_Espe;
    }

    public void setId_Espe(int Id_Espe) {
        this.Id_Espe = Id_Espe;
    }
    
    
    
    
}
