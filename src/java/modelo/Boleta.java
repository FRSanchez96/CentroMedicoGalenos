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
public class Boleta {
    
    private int Id_Bole;
    private int Total;
    private Date Fecha;

    public Boleta() {
    }

    public Boleta(int Id_Bole, int Total, Date Fecha) {
        this.Id_Bole = Id_Bole;
        this.Total = Total;
        this.Fecha = Fecha;
    }

    public int getId_Bole() {
        return Id_Bole;
    }

    public void setId_Bole(int Id_Bole) {
        this.Id_Bole = Id_Bole;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
    
    
}
