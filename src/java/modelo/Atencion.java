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
public class Atencion {
    
    private int Id_Aten;
    private String Descripcion;
    private int Costo,Id_Agen;
    private Date Hora;
    private int Paciente_Rut, Id_Espe, Id_Bole, Sum;
    private String Estado;

    public Atencion() {
    }

    public Atencion(int Id_Aten, String Descripcion, int Costo, int Id_Agen, Date Hora, int Paciente_Rut, int Id_Espe, int Id_Bole, int Sum, String Estado) {
        this.Id_Aten = Id_Aten;
        this.Descripcion = Descripcion;
        this.Costo = Costo;
        this.Id_Agen = Id_Agen;
        this.Hora = Hora;
        this.Paciente_Rut = Paciente_Rut;
        this.Id_Espe = Id_Espe;
        this.Id_Bole = Id_Bole;
        this.Sum = Sum;
        this.Estado = Estado;
    }

    public int getId_Aten() {
        return Id_Aten;
    }

    public void setId_Aten(int Id_Aten) {
        this.Id_Aten = Id_Aten;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCosto() {
        return Costo;
    }

    public void setCosto(int Costo) {
        this.Costo = Costo;
    }

    public int getId_Agen() {
        return Id_Agen;
    }

    public void setId_Agen(int Id_Agen) {
        this.Id_Agen = Id_Agen;
    }

    public Date getHora() {
        return Hora;
    }

    public void setHora(Date Hora) {
        this.Hora = Hora;
    }

    public int getPaciente_Rut() {
        return Paciente_Rut;
    }

    public void setPaciente_Rut(int Paciente_Rut) {
        this.Paciente_Rut = Paciente_Rut;
    }

    public int getId_Espe() {
        return Id_Espe;
    }

    public void setId_Espe(int Id_Espe) {
        this.Id_Espe = Id_Espe;
    }

    public int getId_Bole() {
        return Id_Bole;
    }

    public void setId_Bole(int Id_Bole) {
        this.Id_Bole = Id_Bole;
    }

    public int getSum() {
        return Sum;
    }

    public void setSum(int Sum) {
        this.Sum = Sum;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    
}
