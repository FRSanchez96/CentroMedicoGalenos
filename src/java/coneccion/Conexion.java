package coneccion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OracleConnection;

/**
 *
 * @author Kevin Zambrano
 */
public class Conexion {
    
    public static Connection getConnection() throws ClassNotFoundException
    {
        
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                String myDB = "jdbc:oracle:thin:@localhost:1521:XE";
                String Usuario = "RespaldoCentro";
                String password = "RespaldoCentro";

                Connection cnx = DriverManager.getConnection(myDB,Usuario,password);

                return cnx;

            }catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
            
            return null;
        
    }
    
    
    
}
    
