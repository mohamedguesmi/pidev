/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.MyConnexion;
import interfaces.IUser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeles.User;

/**
 *
 * @author amado
 */
public class UserService implements IUser<User>{
   private Connection cnx;
   
    public UserService() {
        cnx = MyConnexion.getInstance().getConnection();
    }
    @Override
    public void insert(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    public User getLogin(String username, String password, String role){
//        
//    }
    
    
    
    public List<User> loginUser(String username, String password, String role) {
         List<User> users=new ArrayList<>();
        try {
String req="SELECT * FROM user where username='"+username+"' and password='"+password+"' and role='"+role+"' " ;
            Statement stm=cnx.createStatement();
            ResultSet resultat= stm.executeQuery(req);
            while(resultat.next()){
                User MyUser=new User();
                MyUser.setId(resultat.getInt(1));
                MyUser.setUsername(resultat.getString(2));
                MyUser.setNom(resultat.getString(3));
                MyUser.setPrenom(resultat.getString(4));
                MyUser.setEmail(resultat.getString(5));
                MyUser.setPassword(resultat.getString(6));
                MyUser.setRole(resultat.getString(7));
              
                
                
                users.add(MyUser);
            }
             } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return  users;
       
    }
    
    
    
}
