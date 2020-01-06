/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenedor;


import coneccion.Conexion;
import coneccion.LogData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Agenda;
import modelo.Atencion;
import modelo.Boleta;
import modelo.DetalleDoctorSucu;
import modelo.DetalleEspecialidad;
import modelo.DetalleTipoUsuario;
import modelo.Dia;
import modelo.HorarioSemanal;
import modelo.Horas;
import modelo.Modulo;
import modelo.Prevision;

/**
 *
 * @author Felipe
 */
public class ManHora {
    /*
    Insert a Boleta
    Rescatar Datos de Modulo (NOTA: Datos ya están ingresados no hay que hacer nada)
    Insertar 3 Datos y 2 Llamados en Agenda
    4 Insercion de datos y 5 Llamados de Atencion
    */
    
    //Agregar para Boleta
    public boolean AgregarBoleta(Boleta bol) throws ClassNotFoundException, SQLException
    {
        Connection cnx = Conexion.getConnection();
        String sql = "Insert into BOLETA Values ("+bol.getId_Bole()+", "+bol.getTotal()+", to_date('"+bol.getFecha()+"','dd-MM-yyyy')')";
        PreparedStatement consultaBD = cnx.prepareStatement(sql);
       
        if(consultaBD.execute())
        {
            return true;
        }
        return false;
       
    }
    
    //Listar de Modulo, Quiero comprobar algo
      public ArrayList<Modulo> ListModu() throws ClassNotFoundException
    {
        
       ArrayList<Modulo> lModulo = new ArrayList();
        try
        {
            //ArrayList<Comuna> lComuna = new ArrayList<>();
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            String stSql  = "SELECT ID_MODU, NOMBRE, TIEMPO"
                    + " FROM MODULO";
            ResultSet rs = st.executeQuery(stSql);
            
            while (rs.next())
                    {
                        
                       Modulo mod = new Modulo();
                       mod.setId_Modulo(rs.getInt("ID_MODU"));
                       mod.setNombre(rs.getString("NOMBRE"));
                       mod.setNombre(rs.getString("TIEMPO"));
                       lModulo.add(mod);
                    }
            
        }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }
        
        return lModulo;
    }
      
      
      //Listar de Modulo, Quiero comprobar algo
      public ArrayList<Atencion> ListAtencion() throws ClassNotFoundException
    {
        
       ArrayList<Atencion> lAtencion = new ArrayList();
        try
        {
            //ArrayList<Comuna> lComuna = new ArrayList<>();
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            String stSql  = "SELECT ID_ATEN, DESCRIPCION, COSTO, ID_AGEN, HORA, PACIENTE_RUT, ID_ESPE, ID_BOLE, SUMATORIA_COMISION, ESTADO"
                    + " FROM ATENCION Order by ID_ATEN asc";
            ResultSet rs = st.executeQuery(stSql);
            
            while (rs.next())
                    {
                        
                       Atencion ate = new Atencion();
                       ate.setId_Aten(rs.getInt("ID_ATEN"));
                       ate.setDescripcion(rs.getString("DESCRIPCION"));
                       ate.setCosto(rs.getInt("COSTO"));
                       ate.setId_Agen(rs.getInt("ID_AGEN"));
                       ate.setHora(rs.getDate("HORA"));
                       ate.setPaciente_Rut(rs.getInt("PACIENTE_RUT"));
                       ate.setId_Espe(rs.getInt("ID_ESPE"));
                       ate.setId_Bole(rs.getInt("ID_BOLE"));
                       ate.setSum(rs.getInt("SUMATORIA_COMISION"));
                       ate.setEstado(rs.getString("ESTADO"));
                       lAtencion.add(ate);
                    }
            
        }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }
        
        return lAtencion;
    }
      
      
      
      //Insertar de Agenda
      public boolean AgregarAgenda(Agenda age) throws ClassNotFoundException, SQLException
    {
        Connection cnx = Conexion.getConnection();
        String sql = "Insert into AGENDA Values ("+age.getId_Agen()+", , to_date('"+age.getFecha()+"','dd-MM-yyyy'), "+age.getId_Sucu()+", "+age.getId_Modu()+", "+age.getDoctor_Rut()+"')";
        PreparedStatement consultaBD = cnx.prepareStatement(sql);
       
        if(consultaBD.execute())
        {
            return true;
        }
        return false;
       
    }
      
      
      //Insertar en Atencion 
      public boolean AgregarAtencion(Atencion ate) throws ClassNotFoundException, SQLException
    {
        Connection cnx = Conexion.getConnection();
        String sql = "Insert into ATENCION Values ("+ate.getId_Aten()+", '"+ate.getDescripcion()+"', '"+ate.getCosto()+"', '"+ate.getId_Agen()+"', to_date('"+ate.getHora()+"','dd-MM-yyyy HH24:MI:SS'), "+ate.getPaciente_Rut()+", '"+ate.getId_Espe()+"', '"+ate.getId_Bole()+"', '"+ate.getSum()+"', '"+ate.getEstado()+"')";
       //String sql = "call P_insert_usuario(" +ate.getId_Aten()+", '"+ate.getDescripcion()+"', '"+ate.getCosto()+"', '"+ate.getId_Agen()+"', to_date('"+ate.getHora()+"','dd-MM-yyyy HH24:MI:SS'), "+ate.getPaciente_Rut()+", '"+ate.getId_Espe()+"', '"+ate.getId_Bole()+"', '"+ate.getSum()+"', '"+ate.getEstado()+"')";
        PreparedStatement consultaBD = cnx.prepareStatement(sql);
       
        if(consultaBD.execute())
        {
            return true;
        }
        return false;
       
    }
      
      
      //Modificar Hora (Anular Hora)
    
      public boolean modificar(Atencion ate) throws ClassNotFoundException, SQLException
    {                                                                                                                                                                           //21-05-2017
        Connection cnx = Conexion.getConnection();                                                                                                                        //to_date('"+pers.getFecha_Nacimiento()+"','dd-MM-yyyy')              
        String sql = "UPDATE ATENCION SET ID_ATEN= "+ate.getId_Aten()+", ESTADO= '"+ate.getEstado()+"'  Where ID_ATEN= "+ate.getId_Aten()+"";
        PreparedStatement consultaBD = cnx.prepareStatement(sql);
       
        if(consultaBD.execute())
        {
            return true;
        }
        return false;
    }
      
       public Atencion BuscarPaciente(int Rut) throws ClassNotFoundException
    {
        //Codigo para listar la wea 
       
        try
        {
             Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
          String stSql  = "SELECT ID_ATEN, DESCRIPCION, COSTO, ID_AGEN, HORA, PACIENTE_RUT, ID_ESPE, ID_BOLE, SUMATORIA_COMISION, ESTADO"
                    + " FROM ATENCION WHERE PACIENTE_RUT = "+Rut+" Order by ID_ATEN asc";
            ResultSet rs = st.executeQuery(stSql);
            if (!rs.next()) return null;
            
          Atencion ate = new Atencion();
                       ate.setId_Aten(rs.getInt("ID_ATEN"));
                       ate.setDescripcion(rs.getString("DESCRIPCION"));
                       ate.setCosto(rs.getInt("COSTO"));
                       ate.setId_Agen(rs.getInt("ID_AGEN"));
                       ate.setHora(rs.getDate("HORA"));
                       ate.setPaciente_Rut(rs.getInt("PACIENTE_RUT"));
                       ate.setId_Espe(rs.getInt("ID_ESPE"));
                       ate.setId_Bole(rs.getInt("ID_BOLE"));
                       ate.setSum(rs.getInt("SUMATORIA_COMISION"));
                       ate.setEstado(rs.getString("ESTADO"));
                       return ate;
                    
         }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }    
   
        
        return null;
    }    
       
       //Listar de Modulo, Quiero comprobar algo
      public ArrayList<DetalleDoctorSucu> ListDetDoctSuc() throws ClassNotFoundException
    {
        
       ArrayList<DetalleDoctorSucu> lDetDocSuc = new ArrayList();
        try
        {
            //ArrayList<Comuna> lComuna = new ArrayList<>();
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            String stSql  = "SELECT DOCTOR_RUT, ID_SUCU"
                    + " FROM DETALLE_DOCTOR_SUCURSAL Order by ID_SUCU asc";
            ResultSet rs = st.executeQuery(stSql);
            
            while (rs.next())
                    {
                        
                       DetalleDoctorSucu detDocSuc = new DetalleDoctorSucu();
                       detDocSuc.setDoctor_Rut(rs.getInt("DOCTOR_RUT"));
                       detDocSuc.setId_Sucu(rs.getInt("ID_SUCU"));
                       lDetDocSuc.add(detDocSuc);
                    }
            
        }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }
        
        return lDetDocSuc;
    }
      
      
      //Listar de Modulo, Quiero comprobar algo
      public ArrayList<Horas> ListHoras() throws ClassNotFoundException
    {
        
       ArrayList<Horas> lHoras = new ArrayList();
        try
        {
            //ArrayList<Comuna> lComuna = new ArrayList<>();
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            String stSql  = "SELECT ID_HOR, HOR_DIA"
                    + " FROM HORAS Order by ID_HOR asc";
            ResultSet rs = st.executeQuery(stSql);
            
            while (rs.next())
                    {
                        
                       Horas lHorass = new Horas();
                       lHorass.setId_Hora(rs.getInt("ID_HOR"));
                       lHorass.setHor_Dia(rs.getString("HOR_DIA"));
                       lHoras.add(lHorass);
                    }
            
        }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }
        
        return lHoras;
    }
      
      //Listar de Modulo, Quiero comprobar algo
      public ArrayList<DetalleEspecialidad> ListDetEsp() throws ClassNotFoundException
    {
        
       ArrayList<DetalleEspecialidad> lDetEsp = new ArrayList();
        try
        {
            //ArrayList<Comuna> lComuna = new ArrayList<>();
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            String stSql  = "SELECT DOCTOR_RUT, ID_ESPE"
                    + " FROM DETALLE_DOCTOR_ESPECIALIDAD Order by ID_ESPE asc";
            ResultSet rs = st.executeQuery(stSql);
            
            while (rs.next())
                    {
                        
                       DetalleEspecialidad lDetEspe = new DetalleEspecialidad();
                       lDetEspe.setDoctorRut(rs.getInt("DOCTOR_RUT"));
                       lDetEspe.setId_Espe(rs.getInt("ID_ESPE"));
                       lDetEsp.add(lDetEspe);
                    }
            
        }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }
        
        return lDetEsp;
    }
      
      
       //Listar de Modulo, Quiero comprobar algo
      public ArrayList<HorarioSemanal> ListHorarioSemanal() throws ClassNotFoundException
    {
        
       ArrayList<HorarioSemanal> lHorario = new ArrayList();
        try
        {
            //ArrayList<Comuna> lComuna = new ArrayList<>();
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            String stSql  = "SELECT ID_HORA_SEM, ID_SUCU, ID_DIA, HORAS_ID_HOR"
                    + " FROM HORARIO_SEMANAL Order by ID_HORA_SEM asc";
            ResultSet rs = st.executeQuery(stSql);
            
            while (rs.next())
                    {
                        
                       HorarioSemanal lHorarioSemanal = new HorarioSemanal();
                       lHorarioSemanal.setIdHoraSema(rs.getInt("ID_HORA_SEM"));
                       lHorarioSemanal.setIdSucu(rs.getInt("ID_SUCU"));
                       lHorarioSemanal.setIdDia(rs.getInt("ID_DIA"));
                       lHorarioSemanal.setHorasiDHora(rs.getInt("HORAS_ID_HOR"));
                       lHorario.add(lHorarioSemanal);
                    }
            
        }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }
        
        return lHorario;
    }
      
      //Listar de Modulo, Quiero comprobar algo
      public ArrayList<Dia> ListDia() throws ClassNotFoundException
    {
        
       ArrayList<Dia> LiDia = new ArrayList();
        try
        {
            //ArrayList<Comuna> lComuna = new ArrayList<>();
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            String stSql  = "SELECT ID_DIA, NOMBRE"
                    + " FROM DIA Order by ID_DIA asc";
            ResultSet rs = st.executeQuery(stSql);
            
            while (rs.next())
                    {
                        
                       Dia lDia = new Dia();
                       lDia.setId_Dia(rs.getInt("ID_DIA"));
                       lDia.setNombre(rs.getString("NOMBRE"));
                       LiDia.add(lDia);
                    }
            
        }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }
        
        return LiDia;
    }
      
}
