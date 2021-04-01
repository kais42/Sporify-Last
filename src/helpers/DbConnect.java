/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DbConnect {
        private static String url="jdbc:mysql://localhost/sporify";
        private static String userName="root";
        private static String password="";
        private static Connection connection ;
        
        
        public static Connection getConnect (){
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return  connection;
        }
    
    
}
