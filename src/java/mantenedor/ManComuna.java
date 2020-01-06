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
import modelo.Comuna;

/**
 *
 * @author Felipe
 */
public class ManComuna {
    
    
      public ArrayList<Comuna> ListComuna() throws ClassNotFoundException
    {
        //Codigo para listar la wea 
       ArrayList<Comuna> lComuna = new ArrayList();
        try
        {
            //ArrayList<Comuna> lComuna = new ArrayList<>();
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            String stSql  = "SELECT ID_COMU, NOMBRE, ID_CIUD"
                    + " FROM COMUNA";
            ResultSet rs = st.executeQuery(stSql);
            
            while (rs.next())
                    {
                        
                       Comuna com = new Comuna();
                       com.setId_Comu(rs.getString("ID_COMU"));
                       com.setNombre(rs.getString("NOMBRE"));
                       com.setId_Ciud(rs.getString("ID_CIUD"));
                       lComuna.add(com);
                    }
            
        }catch(SQLException ex)
        {
            LogData.log("ListTipo", " Error "+ ex.getMessage());
        }
        
        return lComuna;
    }
      
    
}
