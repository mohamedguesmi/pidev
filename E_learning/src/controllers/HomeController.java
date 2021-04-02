/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modeles.User;
import services.UserService;

/**
 *
 * @author amado
 */
public class HomeController implements Initializable {
    
    private Label label;
    @FXML
    private TextField txtUsername;

    @FXML
    private Button btnLogin;
    
    public static String my_username,my_pswd;
    public List<User> users = new ArrayList<>();
    @FXML
    private Label txtlMessage;
    @FXML
    private PasswordField txtPassword;

    
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        txtlMessage.setVisible(false);
    }    

    @FXML
    private void LoginUsers(ActionEvent event) throws IOException {
        
        UserService service = new UserService();
        
        my_username =txtUsername.getText() ;
        my_pswd = txtPassword.getText();
       
        
        service.loginUser(my_username, my_pswd, "admin");
        
        users = service.loginUser(my_username, my_pswd, "admin");
        
        if(!users.isEmpty())
        {
             Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/Formation.fxml"));
                Scene home_page_scene = new Scene (home_page_parent);
                Stage app_stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(home_page_scene);
                app_stage.show();
                
            System.out.println("welcome");
        }else{
            txtlMessage.setVisible(true);
            System.out.println("nooooo welcom");
        }
       System.out.println(users.toString());
        
    }
    
}
