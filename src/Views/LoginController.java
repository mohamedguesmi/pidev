/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class LoginController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private Button signin;
    @FXML
    private PasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User u= new User(1,"admin","admin","admin");
        
 
        signin.setOnAction(e->{
            String a=username.getText();
        String b=password.getText();
        int x=u.getUsername().compareTo(a);
        int y=u.getPassword().compareTo(b);
            if (a.equals("admin")&&b.equals("admin")){
               System.out.println(a);
        System.out.println(b); 
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Back.fxml"));
                signin.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else
                try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Front.fxml"));
                signin.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }); 
        
    }    
    
       
    }    
    

