/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallermecanico;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuito
 */
public class testCon {
    static String bd ="taller mecánico";
    static String login ="root";
    static String password="";
    static String url ="jdbc:mysql://localhost/"+bd;
    private Connection conn =null;
    
    public Connection gettestCon()  {
        try{
            Class.forName ("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(this.url, this. login, this. password); 
            
        }catch (SQLException e)
        {
            System.out.println(e);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(testCon.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return conn;
    }
    
    
}
