/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import oracle.sql.BLOB;

/**
 *
 * @author Felipe
 */
public class Doctor {
    private int rutDoctor,Id_hora;
    private BLOB Foto;
    private String estado;

    public Doctor() {
    }

    public Doctor(int rutDoctor, int Id_hora, BLOB Foto, String estado) {
        this.rutDoctor = rutDoctor;
        this.Id_hora = Id_hora;
        this.Foto = Foto;
        this.estado = estado;
    }

    public int getRutDoctor() {
        return rutDoctor;
    }

    public void setRutDoctor(int rutDoctor) {
        this.rutDoctor = rutDoctor;
    }

    public int getId_hora() {
        return Id_hora;
    }

    public void setId_hora(int Id_hora) {
        this.Id_hora = Id_hora;
    }

    public BLOB getFoto() {
        return Foto;
    }

    public void setFoto(BLOB Foto) {
        this.Foto = Foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    
    
    
}
