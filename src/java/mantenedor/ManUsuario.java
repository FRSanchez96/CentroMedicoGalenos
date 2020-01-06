/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenedor;

import coneccion.Conexion;
import coneccion.LogData;
import dao.DaoUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DetalleTipoUsuario;
import modelo.Persona;
import modelo.Prevision;
import modelo.Sexo;
import modelo.Telefono;

/**
 *
 * @author Felipe
 */
public class ManUsuario implements DaoUsuario{
    
    //Listar
    //CrearUsuario (Agregar)
    //ValidarRut??
    //Login
    
   public Persona getUsuario(int Rut, String Veri, String Pass) throws ClassNotFoundException
    {
        //Codigo para listar la wea 
       
        try
        {
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            String stSql  = "SELECT RUT, VERIFICADOR, NOMBRES, APELLIDO_PATERNO, APELLIDO_MATERNO, FECHA_NACIMIENTO, SEXO_ID, DIRECCION, COMUNA_ID, MAIL, PREVISION_ID, CONTRASENA"
                    + " FROM PERSONA where Rut = " + Rut + " And Verificador = '" +Veri+ "' And CONTRASENA = '" +Pass+ "'";
            ResultSet rs = st.executeQuery(stSql);
            if (!rs.next()) return null;
            
           Persona per = new Persona();
           per.setRut(rs.getInt("RUT"));
           per.setVerificador(rs.getString("VERIFICADOR"));
           per.setNombres(rs.getString("NOMBRES"));
           per.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
           per.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
           per.setFecha_Nacimiento(rs.getString("FECHA_NACIMIENTO"));
           per.setSexo_Id(rs.getInt("SEXO_ID"));
           per.setDireccion(rs.getString("DIRECCION"));
           per.setComuna_Id(rs.getInt("COMUNA_ID"));
           per.setMail(rs.getString("MAIL"));
           per.setPrevision_Id(rs.getInt("PREVISION_ID"));
           per.setContrasena(rs.getString("CONTRASENA"));
           return per;
                    
         }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }    
   
        
        return null;
    }    
  
   
    public DetalleTipoUsuario getTipo(int Rut) throws ClassNotFoundException
    {
        //Codigo para listar la 
        try
        {
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT ID_USTI, RUT_PERS"
                    + "  FROM DETALLE_TIPO_USUARIO where RUT_PERS = " + Rut);
            if (!rs.next()) return null;            
           
            DetalleTipoUsuario det = new DetalleTipoUsuario();
            det.setId_usti(rs.getInt("ID_USTI"));
            det.setRut_pers(rs.getInt("RUT_PERS"));
            return det;
                    
            
        }catch(SQLException ex)
        {
           
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }
        
        return null;
    }
    
    public int logear(int Rut, String Veri, String Pass) throws ClassNotFoundException, SQLException
    {
        Persona pers =   getUsuario(Rut,Veri,Pass);
        if (pers  == null) return -1;
        DetalleTipoUsuario detip = getTipo(Rut);
        if (detip == null ) return -1;
        return detip.getId_usti();
    }
    
    
     public ArrayList<Sexo> ListSexo() throws ClassNotFoundException
    {
        //Codigo para listar la 
       ArrayList<Sexo> lSexo = new ArrayList();
        try
        {
            //ArrayList<Comuna> lComuna = new ArrayList<>();
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            String stSql  = "SELECT ID_SEXO, NOMBRE"
                    + " FROM SEXO";
            ResultSet rs = st.executeQuery(stSql);
            
            while (rs.next())
                    {
                        
                       Sexo sex = new Sexo();
                       sex.setId_Sexo(rs.getInt("ID_SEXO"));
                       sex.setNombre(rs.getString("NOMBRE"));
                       lSexo.add(sex);
                    }
            
        }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }
        
        return lSexo;
    }
     
     
     public ArrayList<Prevision> ListPrevision() throws ClassNotFoundException
    {
        //Codigo para listar la  
       ArrayList<Prevision> lPrevision = new ArrayList();
        try
        {
            //ArrayList<Comuna> lComuna = new ArrayList<>();
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            String stSql  = "SELECT ID_PREVISION, NOMBRE"
                    + " FROM PREVISION";
            ResultSet rs = st.executeQuery(stSql);
            
            while (rs.next())
                    {
                        
                       Prevision pre = new Prevision();
                       pre.setId_Prevision(rs.getInt("ID_PREVISION"));
                       pre.setNombre(rs.getString("NOMBRE"));
                       lPrevision.add(pre);
                    }
            
        }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }
        
        return lPrevision;
    }
     
     public ArrayList<Persona> ListPersona() throws ClassNotFoundException
    {
        //Codigo para listar la  
       ArrayList<Persona> LPersona = new ArrayList();
        try
        {
            //ArrayList<Comuna> lComuna = new ArrayList<>();
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            String stSql  = "SELECT RUT, VERIFICADOR, NOMBRES, APELLIDO_PATERNO, APELLIDO_MATERNO, FECHA_NACIMIENTO, SEXO_ID, DIRECCION, COMUNA_ID, MAIL, PREVISION_ID, CONTRASENA"
                    + " FROM PERSONA";
            ResultSet rs = st.executeQuery(stSql);
            
            while (rs.next())
                    {
                        
                       Persona perso = new Persona();
                       
                       perso.setRut(rs.getInt("RUT"));
                       perso.setVerificador(rs.getString("VERIFICADOR"));
                       perso.setNombres(rs.getString("NOMBRES"));
                       perso.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
                       perso.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
                       perso.setFecha_Nacimiento(rs.getString("FECHA_NACIMIENTO"));
                       perso.setSexo_Id(rs.getInt("SEXO_ID"));
                       perso.setDireccion(rs.getString("DIRECCION"));
                       perso.setComuna_Id(rs.getInt("COMUNA_ID"));
                       perso.setMail(rs.getString("MAIL"));
                       perso.setPrevision_Id(rs.getInt("PREVISION_ID"));
                       perso.setContrasena(rs.getString("CONTRASENA"));
                       
                       LPersona.add(perso);
                    }
            
        }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }
        
        return LPersona;
    }
   
     
     
     public boolean AgregarPer(Persona pers) throws ClassNotFoundException, SQLException
    {
        Connection cnx = Conexion.getConnection();
        //String sql = "Insert into Persona Values ("+pers.getRut()+", '"+pers.getVerificador()+"', '"+pers.getNombres()+"', '"+pers.getApellidoPaterno()+"', '" +pers.getApellidoMaterno()+"', to_date('"+pers.getFecha_Nacimiento()+"','dd-MM-yyyy'), "+pers.getSexo_Id()+", '"+pers.getDireccion()+"', "+pers.getComuna_Id()+", '"+pers.getMail()+"', "+pers.getPrevision_Id()+", '"+pers.getContrasena()+"')";
    
           String sql = "call PERSONA_tapi.ins(" +pers.getRut()+""
               + ", '"+pers.getVerificador()+"'"
               + ", '"+pers.getNombres()+"'"
               + ", '"+pers.getApellidoPaterno()+"'"
               + ", '" +pers.getApellidoMaterno()+"'"
               + ", to_date('"+pers.getFecha_Nacimiento()+"'"
               + ",'dd-MM-yyyy'), "+pers.getSexo_Id()+""
               + ", '"+pers.getDireccion()+"'"
               + ", "+pers.getComuna_Id()+""
               + ", '"+pers.getMail()+"'"
               + ", "+pers.getPrevision_Id()+""
               + ", '"+pers.getContrasena()+"')";
       
        PreparedStatement consultaBD = cnx.prepareStatement(sql);
       
        if(consultaBD.execute())
        {
            return true;
        }
        return false;
       
    }
     
      public boolean AgregarDetalleTipo(DetalleTipoUsuario det) throws ClassNotFoundException, SQLException
    {
        Connection cnx = Conexion.getConnection();
        String sql = "Insert into DETALLE_TIPO_USUARIO Values ("+det.getId_usti()+", '"+det.getRut_pers()+"')";
        PreparedStatement consultaBD = cnx.prepareStatement(sql);
       
        if(consultaBD.execute())
        {
            return true;
        }
        return false;
       
    }
     
     public boolean AgregarSex(Sexo sex) throws ClassNotFoundException, SQLException
    {
        Connection cnx = Conexion.getConnection();
        PreparedStatement consultaBD = cnx.prepareStatement("Insert into Sexo Values ('"+sex.getId_Sexo()+"', '"+sex.getNombre()+"')");
       
        if(consultaBD.execute())
        {
            return true;
        }
        return false;
       
    }
     
     /**/
      public boolean AgregarTelefono(Telefono tel) throws ClassNotFoundException, SQLException
    {
        Connection cnx = Conexion.getConnection();
        String sql = "Insert into TELEFONO Values ("+tel.getId_Telefono()+", "+tel.getNumero()+", '"+tel.getDescripcion()+"', "+tel.getRut_Pers()+", "+tel.getId_Teti()+")";
        PreparedStatement consultaBD = cnx.prepareStatement(sql);
       
        if(consultaBD.execute())
        {
            return true;
        }
        return false;
       
    }
      
      public  boolean validarRut(String rut) {
 
        boolean validacion = false;
        try {
        rut =  rut.toUpperCase();
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

        char dv = rut.charAt(rut.length() - 1);

        int m = 0, s = 1;
        for (; rutAux != 0; rutAux /= 10) {
        s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
        }
        if (dv == (char) (s != 0 ? s + 47 : 75)) {
        validacion = true;
        }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
}
    
}

/* PreparedStatement personasSmt;
        try{
		// Hacemos el INSERT
		personasSmt = Conexion.getConnection().prepareStatement(
				"INSERT INTO PERSONA "/*(RUT, VERIFICADOR, NOMBRES, APELLIDO_PATERNO, APELLIDO_MATERNO,"
                                        + " FECHA_NACIMIENTO, SEXO_ID, DIRECCION, COMUNA_ID, MAIL, PREVISION_ID, CONTRASEÑA) "*/
		/*		+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		personasSmt.setInt(1, pers.getRut());
		personasSmt.setString(2, pers.getVerificador());
		personasSmt.setString(3, pers.getNombres());
		personasSmt.setString(4, pers.getApellidoPaterno());
                personasSmt.setString(5, pers.getApellidoMaterno());
                personasSmt.setDate(6, pers.getFecha_Nacimiento());
                personasSmt.setInt(7, pers.getSexo_Id());
                personasSmt.setString(8, pers.getDireccion());
                personasSmt.setString(9, pers.getComuna_Id());
                personasSmt.setString(10, pers.getMail());
                personasSmt.setInt(11, pers.getPrevision_Id());
                personasSmt.setString(12, pers.getContrasena());
		
		personasSmt.executeQuery();
                return true;
		
	}catch( Exception ex){
		
	}

-------
Connection cnx = Conexion.getConnection();
        PreparedStatement consultaBD = cnx.prepareStatement("Insert into PERSONA Values ("+pers.getRut()+"', '"+pers.getVerificador()+"', '"+pers.getNombres()+"', '"+pers.getApellidoPaterno()+"', '"
                +pers.getApellidoMaterno()+"', '"+pers.getFecha_Nacimiento()+"', '"+pers.getSexo_Id()+"', '"+pers.getDireccion()+"', '"+pers.getComuna_Id()+"', '"+pers.getMail()+"', '"+pers.getPrevision_Id()+"', '"+pers.getContrasena()+"')");
       
        if(consultaBD.execute())
        {
            return true;
        }
        return false;




*/


/*"Insert into PERSONA Values ("+pers.getRut()+"', '"+pers.getVerificador()+"', '"+pers.getNombres()+"', '"+pers.getApellidoPaterno()+"', '"
                +pers.getApellidoMaterno()+"', '"+pers.getFecha_Nacimiento()+"', '"+pers.getSexo_Id()+"', '"+pers.getDireccion()+"', '"+pers.getComuna_Id()+"', '"+pers.getMail()+"', '"+pers.getPrevision_Id()+"', '"+pers.getContrasena()+"')"*/