/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Date;
/**
 *
 * @author Felipe
 */
public class Agenda {
    
    private int Id_Agen;
    private Date Fecha;
    private int Id_Sucu, Id_Modu, Doctor_Rut;

    public Agenda() {
    }

    public Agenda(int Id_Agen, Date Fecha, int Id_Sucu, int Id_Modu, int Doctor_Rut) {
        this.Id_Agen = Id_Agen;
        this.Fecha = Fecha;
        this.Id_Sucu = Id_Sucu;
        this.Id_Modu = Id_Modu;
        this.Doctor_Rut = Doctor_Rut;
    }

    public int getId_Agen() {
        return Id_Agen;
    }

    public void setId_Agen(int Id_Agen) {
        this.Id_Agen = Id_Agen;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getId_Sucu() {
        return Id_Sucu;
    }

    public void setId_Sucu(int Id_Sucu) {
        this.Id_Sucu = Id_Sucu;
    }

    public int getId_Modu() {
        return Id_Modu;
    }

    public void setId_Modu(int Id_Modu) {
        this.Id_Modu = Id_Modu;
    }

    public int getDoctor_Rut() {
        return Doctor_Rut;
    }

    public void setDoctor_Rut(int Doctor_Rut) {
        this.Doctor_Rut = Doctor_Rut;
    }
    
    
    
}
