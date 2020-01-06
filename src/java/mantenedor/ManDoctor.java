/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenedor;

import coneccion.Conexion;
import coneccion.LogData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Doctor;
import modelo.Especialidad;
import modelo.Sucursal;
import oracle.sql.BLOB;

/**
 *
 * @author Felipe
 */
public class ManDoctor {
    
    //Listar Agenga
    //Cancelar Agenga
    
    //Listar Doctor
      public ArrayList<Doctor> ListDoctor() throws ClassNotFoundException
    {
        //Codigo para listar la 
       ArrayList<Doctor> lDoctor = new ArrayList();
        try
        {
            //ArrayList<Comuna> lComuna = new ArrayList<>();
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            String stSql  = "SELECT DOCTOR_RUT, ID_HORA_SEM, FOTO, ESTADO"
                    + " FROM DOCTOR";
            ResultSet rs = st.executeQuery(stSql);
            
            while (rs.next())
                    {
                        
                       Doctor doc = new Doctor();
                       doc.setRutDoctor(rs.getInt("DOCTOR_RUT"));
                       doc.setId_hora(rs.getInt("ID_HORA_SEM"));
                       doc.setFoto((BLOB) rs.getObject("FOTO"));
                       doc.setEstado(rs.getString("ESTADO"));
                       lDoctor.add(doc);
                    }
            
        }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }
        
        return lDoctor;
    }
      
      
      //Listar Sucursal
       public ArrayList<Sucursal> ListSucursal() throws ClassNotFoundException
    {
        //Codigo para listar la 
       ArrayList<Sucursal> lSucursal = new ArrayList();
        try
        {
            //ArrayList<Comuna> lComuna = new ArrayList<>();
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            String stSql  = "SELECT ID_SUCU, NOMBRE_SUCU, DIRECCION, NUMERACION, ID_COMU, COSTE_COMISION"
                    + " FROM SUCURSAL";
            ResultSet rs = st.executeQuery(stSql);
            
            while (rs.next())
                    {
                        
                       Sucursal suc = new Sucursal();
                       suc.setId_Sucursal(rs.getInt("ID_SUCU"));
                       suc.setNom_Sucursal(rs.getString("NOMBRE_SUCU"));
                       suc.setDireccion(rs.getString("DIRECCION"));
                       suc.setNumeracion(rs.getInt("NUMERACION"));
                       suc.setId_Comu(rs.getInt("ID_COMU"));
                       suc.setCoste_Comicion(rs.getInt("COSTE_COMISION"));
                       lSucursal.add(suc);
                    }
            
        }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }
        
        return lSucursal;
    }
      
       
       //Listar Especialidad
       public ArrayList<Especialidad> LisEsp() throws ClassNotFoundException
    {
        //Codigo para listar la 
       ArrayList<Especialidad> lEspecialidad = new ArrayList();
        try
        {
            //ArrayList<Comuna> lComuna = new ArrayList<>();
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            String stSql  = "SELECT ID_ESPE, NOMB_ESPE, CANTI_MODU, COSTE_COMISION"
                    + " FROM ESPECIALIDAD Order by ID_ESPE asc";
            ResultSet rs = st.executeQuery(stSql);
            
            while (rs.next())
                    {
                        
                       Especialidad esp = new Especialidad();
                       esp.setId_Espe(rs.getInt("ID_ESPE"));
                       esp.setNombre_Esp(rs.getString("NOMB_ESPE"));
                       esp.setCanti_Modu(rs.getInt("CANTI_MODU"));
                       esp.setCoste_Comision(rs.getInt("COSTE_COMISION"));
                       lEspecialidad.add(esp);
                    }
            
        }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }
        
        return lEspecialidad;
    }  
    
}
