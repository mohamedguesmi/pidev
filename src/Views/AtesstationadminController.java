/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Attestation;
import Service.AttestationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class AtesstationadminController implements Initializable {

    @FXML
    private Button r;
    @FXML
    private Button ActualiserF;
    @FXML
    private Button r2;
    @FXML
    private TableView<Attestation> tb;
    @FXML
    private TableColumn<Attestation, String> typeA;
    @FXML
    private TableColumn<Attestation, String> langueA;
    @FXML
    private TableColumn<Attestation, String> dateA;
    @FXML
    private TableColumn<Attestation,Integer > userID;
     private static Attestation at;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        r2.setOnAction(e->{ 
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Back.fxml"));
                r2.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
          
        AttestationService as= new AttestationService(); 
        ArrayList<Attestation> ats= new ArrayList<Attestation>();
        try {
            ats = (ArrayList<Attestation>) as.readAlls();
        } catch (SQLException ex) {
            Logger.getLogger(GestionServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Attestation> obs1 = FXCollections.observableArrayList(ats);
        
        tb.setItems(obs1);
        typeA.setCellValueFactory(new PropertyValueFactory<>("typeA"));
        langueA.setCellValueFactory(new PropertyValueFactory<>("langueA"));
        dateA.setCellValueFactory(new PropertyValueFactory<>("dateA"));
        userID.setCellValueFactory(new PropertyValueFactory<>("user"));
       
       
        ActualiserF.setOnAction(e -> {
          AttestationService cs5= new AttestationService(); 
        ArrayList<Attestation> ats5= new ArrayList<Attestation>();
        try {
            ats5 = (ArrayList<Attestation>) cs5.readAlls();
        } catch (SQLException ex) {
            Logger.getLogger(AttestationFController.class.getName()).log(Level.SEVERE, null, ex);
        }
         ObservableList<Attestation> obs5 = FXCollections.observableArrayList(ats5);
        tb.setItems(obs5);
        typeA.setCellValueFactory(new PropertyValueFactory<>("typeA"));
        langueA.setCellValueFactory(new PropertyValueFactory<>("langueA"));
        dateA.setCellValueFactory(new PropertyValueFactory<>("dateA"));
        userID.setCellValueFactory(new PropertyValueFactory<>("user"));
        
    });   
        
    } 
    public Attestation getA() {
        return at;
    }   
    
}
