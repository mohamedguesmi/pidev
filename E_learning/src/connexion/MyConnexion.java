/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amado
 */
public class MyConnexion {
    
    private static MyConnexion instance =null;
    private Connection con;
    
    private MyConnexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");   
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/e_learning?autoReconnect=true&useSSL=false",
                    "root", "");
        } catch ( ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static MyConnexion getInstance(){
        if(instance == null)
            instance= new MyConnexion();
        return instance;
    }
    
    public Connection getConnection(){
        return con;
    }
}
