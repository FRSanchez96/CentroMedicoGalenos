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
public class DetalleTipoUsuario {
    private int id_usti,rut_pers;

    public DetalleTipoUsuario() {
    }

    public DetalleTipoUsuario(int id_usti, int rut_pers) {
        this.id_usti = id_usti;
        this.rut_pers = rut_pers;
    }
    
    
    
    public int getId_usti() {
        return id_usti;
    }

    public void setId_usti(int id_usti) {
        this.id_usti = id_usti;
    }

    public int getRut_pers() {
        return rut_pers;
    }

    public void setRut_pers(int rut_pers) {
        this.rut_pers = rut_pers;
    }
    
    
}
