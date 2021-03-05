/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Reclamation;
import Entities.User;
import Service.ReclamationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReclamationadminController implements Initializable {

    @FXML
    private Button r;
    @FXML
    private Button ActualiserR;
    @FXML
    private Button r4;
    @FXML
    private TableView<Reclamation> tb;
    @FXML
    private TableColumn<Reclamation, String> nomR;
    @FXML
    private TableColumn<Reclamation, String>sujetR;
    @FXML
    private TableColumn<Reclamation, String> dateR;
    
    private static Reclamation at;
    @FXML
    private TableColumn<Reclamation, Integer> user;
    private ReclamationService sc = new ReclamationService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                r4.setOnAction(e->{ 
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Back.fxml"));
                r4.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
          
        ReclamationService as= new ReclamationService(); 
        ArrayList<Reclamation> ats= new ArrayList<Reclamation>();
        try {
            ats = (ArrayList<Reclamation>) as.readAlls();
            System.out.println("dans reclamation admin cont");
        } catch (SQLException ex) {
            Logger.getLogger(GestionServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Reclamation> obs1 = FXCollections.observableArrayList(ats);
        
        tb.setItems(obs1);
        nomR.setCellValueFactory(new PropertyValueFactory<>("nomR"));
        sujetR.setCellValueFactory(new PropertyValueFactory<>("sujetR"));
        dateR.setCellValueFactory(new PropertyValueFactory<>("dateR"));
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        
        
        
        /*tb.getSelectionModel().clearSelection();*/
        
        /*r.setOnAction(e->{ 
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                r.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            });*/




        
        
   
                        
       
        ActualiserR.setOnAction(e -> {
          ReclamationService cs5= new ReclamationService(); 
        ArrayList<Reclamation> ats5= new ArrayList<Reclamation>();
        try {
            ats5 = (ArrayList<Reclamation>) cs5.readAlls();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationFController.class.getName()).log(Level.SEVERE, null, ex);
        }
         ObservableList<Reclamation> obs5 = FXCollections.observableArrayList(ats5);
        tb.setItems(obs5);
        nomR.setCellValueFactory(new PropertyValueFactory<>("nomR"));
        sujetR.setCellValueFactory(new PropertyValueFactory<>("sujetR"));
        dateR.setCellValueFactory(new PropertyValueFactory<>("dateR"));
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        
    });   
        
    } 
    public Reclamation getR() {
        return at;

}
    /*public void afficher(){
        try {
            

        ObservableList<Reclamation> eventData = FXCollections.observableArrayList();
        List  <Reclamation> l=new ArrayList<Reclamation>();
                l=sc.readAll();
        for(Reclamation r :l){
            eventData.add(r);
        } 
                } catch (SQLException ex) {
            Logger.getLogger(ReclamationadminController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    
}



