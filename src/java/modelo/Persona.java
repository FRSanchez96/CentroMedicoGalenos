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
public class Persona {
    
    private int Rut;
    private String Verificador;
    private String Nombres,ApellidoPaterno,ApellidoMaterno;
    private String Fecha_Nacimiento;
    private int Sexo_Id;
    private String Direccion,Mail;
    private int Comuna_Id;
    private int Prevision_Id;
    private String Contrasena;
    
    public Persona()
    {
        
    }

    public Persona(int Rut, String Verificador, String Nombres, String ApellidoPaterno, String ApellidoMaterno, String Fecha_Nacimiento, int Sexo_Id, String Direccion, String Mail, int Comuna_Id, int Prevision_Id, String Contrasena) {
        this.Rut = Rut;
        this.Verificador = Verificador;
        this.Nombres = Nombres;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Sexo_Id = Sexo_Id;
        this.Direccion = Direccion;
        this.Mail = Mail;
        this.Comuna_Id = Comuna_Id;
        this.Prevision_Id = Prevision_Id;
        this.Contrasena = Contrasena;
    }

    

    
    
    public int getRut() {
        return Rut;
    }

    public void setRut(int Rut) {
        this.Rut = Rut;
    }

    public String getVerificador() {
        return Verificador;
    }

    public void setVerificador(String Verificador) {
        this.Verificador = Verificador;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public int getSexo_Id() {
        return Sexo_Id;
    }

    public void setSexo_Id(int Sexo_Id) {
        this.Sexo_Id = Sexo_Id;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getComuna_Id() {
        return Comuna_Id;
    }

    public void setComuna_Id(int Comuna_Id) {
        this.Comuna_Id = Comuna_Id;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public int getPrevision_Id() {
        return Prevision_Id;
    }

    public void setPrevision_Id(int Prevision_Id) {
        this.Prevision_Id = Prevision_Id;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
   
    
}
