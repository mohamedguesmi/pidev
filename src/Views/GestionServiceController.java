/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Attestation;
import Entities.Reclamation;
import Entities.Service;
import Service.AttestationService;
import Service.ReclamationService;
import Service.ServiceService;
import Util.DataBase;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GestionServiceController implements Initializable {

    @FXML
    private Button r;

    private static Service se;
    private static Attestation at;
    @FXML
    private Button r5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                r5.setOnAction(e->{ 
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Back.fxml"));
                r5.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
        
  
          
        
        
        
        
        /*r.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
             r.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(GestionServiceController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             }); */
        r.setOnAction(e->{ 
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                r.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            });

    }

    @FXML
    private void reclamation(ActionEvent event) {
                        
 try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reclamationadmin.fxml"));
        
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));  
        stage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
    }
    

    @FXML
    private void attestation(ActionEvent event) {
 try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("atesstationadmin.fxml"));
        
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));  
        stage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
    }
    }
    
    

