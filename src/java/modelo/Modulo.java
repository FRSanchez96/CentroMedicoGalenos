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
public class Modulo {
    
    private int Id_Modulo;
    private String Nombre;
    private Date Tiempo;

    public Modulo() {
    }

    public Modulo(int Id_Modulo, String Nombre, Date Tiempo) {
        this.Id_Modulo = Id_Modulo;
        this.Nombre = Nombre;
        this.Tiempo = Tiempo;
    }

    public int getId_Modulo() {
        return Id_Modulo;
    }

    public void setId_Modulo(int Id_Modulo) {
        this.Id_Modulo = Id_Modulo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getTiempo() {
        return Tiempo;
    }

    public void setTiempo(Date Tiempo) {
        this.Tiempo = Tiempo;
    }
    
    
    
}
