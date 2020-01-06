/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.DetalleTipoUsuario;
import modelo.Persona;
import modelo.Prevision;
import modelo.Sexo;

/**
 *
 * @author Felipe
 */
public interface DaoUsuario {
    
     public Persona getUsuario(int Rut, String Veri, String Pass) throws ClassNotFoundException;
     
     public DetalleTipoUsuario getTipo(int Rut) throws ClassNotFoundException;
     
     public int logear(int Rut, String Veri, String Pass) throws ClassNotFoundException, SQLException;
     
     public ArrayList<Sexo> ListSexo() throws ClassNotFoundException;
     
     public boolean AgregarDetalleTipo(DetalleTipoUsuario det) throws ClassNotFoundException, SQLException;
     
     public ArrayList<Prevision> ListPrevision() throws ClassNotFoundException;
     
     public boolean AgregarPer(Persona pers) throws ClassNotFoundException, SQLException;
    
}
