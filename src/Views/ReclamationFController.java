/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Attestation;
import Entities.Reclamation;
import Service.AttestationService;
import Service.ReclamationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReclamationFController implements Initializable {

    @FXML
    private Button r;
    @FXML
    private Button AjouterR;
    @FXML
    private Button ActualiserR;
    @FXML
    private Button ModifierR;
    @FXML
    private Button SupprimerR;
    @FXML
    private TableColumn<Reclamation, String> nomR;
    @FXML
    private TableColumn<Reclamation, String> sujetR;
    @FXML
    private TableColumn<Reclamation, String> dateR;
    
    private static Reclamation at;
    @FXML
    private TableView<Reclamation> tb;
    @FXML
    private Button r4;
    
    @FXML
    private TextField rech;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                r4.setOnAction(e->{ 
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Front.fxml"));
                r4.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
          
        ReclamationService as= new ReclamationService(); 
        ArrayList<Reclamation> ats= new ArrayList<Reclamation>();
        try {
            ats = (ArrayList<Reclamation>) as.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(GestionServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Reclamation> obs1 = FXCollections.observableArrayList(ats);
        
        tb.setItems(obs1);
        nomR.setCellValueFactory(new PropertyValueFactory<>("nomR"));
        sujetR.setCellValueFactory(new PropertyValueFactory<>("sujetR"));
        dateR.setCellValueFactory(new PropertyValueFactory<>("dateR"));
        AjouterR.setOnAction(e->{ 
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("AjouterReclamation.fxml"));
                AjouterR.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AjouterReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
        r.setOnAction(e->{ 
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                r.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            });

        SupprimerR.setOnAction(e -> {
            at = tb.getSelectionModel().getSelectedItem();
                if(at != null)
                {
                at = tb.getSelectionModel().getSelectedItem();
                    try {
                        as.deleteReclamation(at);
                        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                         alert1.setContentText("Suppression effectuée avec succès!");
                         alert1.show();
                           
                    } catch (SQLException ex) {
                        Logger.getLogger(ReclamationFController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                ReclamationService as5= new ReclamationService(); 
        ArrayList<Reclamation> ats5= new ArrayList<Reclamation>();
        try {
            ats5 = (ArrayList<Reclamation>) as5.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationFController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Reclamation> obs5 = FXCollections.observableArrayList(ats5);
        tb.setItems(obs5);
        nomR.setCellValueFactory(new PropertyValueFactory<>("nomR"));
        sujetR.setCellValueFactory(new PropertyValueFactory<>("sujetR"));
        dateR.setCellValueFactory(new PropertyValueFactory<>("dateR"));
                }

        });
        ModifierR.setOnAction(e->{
                //(String id,String nom, String adresse, String prix, String surface,String capacite)
                
                at = tb.getSelectionModel().getSelectedItem();
                if (!(at == null)) {
                    try {
                        Parent root;
                        root = FXMLLoader.load(ReclamationFController.this.getClass().getResource("ModifierReclamation.fxml"));
                        ModifierR.getScene().setRoot(root);
                    }catch (IOException ex) {
                        Logger.getLogger(ReclamationFController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            
                        });
       
        ActualiserR.setOnAction(e -> {
          ReclamationService cs5= new ReclamationService(); 
        ArrayList<Reclamation> ats5= new ArrayList<Reclamation>();
        try {
            ats5 = (ArrayList<Reclamation>) cs5.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationFController.class.getName()).log(Level.SEVERE, null, ex);
        }
         ObservableList<Reclamation> obs5 = FXCollections.observableArrayList(ats5);
        tb.setItems(obs5);
        nomR.setCellValueFactory(new PropertyValueFactory<>("nomR"));
        sujetR.setCellValueFactory(new PropertyValueFactory<>("sujetR"));
        dateR.setCellValueFactory(new PropertyValueFactory<>("dateR"));
        
    });   
        
    } 
    public Reclamation getR() {
        return at;
    }


    @FXML
    private void recherche(ActionEvent event) {
        String type= rech.getText();
        ReclamationService cs5= new ReclamationService(); 
        ArrayList<Reclamation> ats5= new ArrayList<Reclamation>();
        tb.getSelectionModel().clearSelection();
        System.out.println(type);
        try {
           ats5= cs5.Rechercher(type);
        } catch (SQLException ex) {
            
           System.out.println("Problemeee  ................ .");
            System.out.println(ex.getMessage());
        }
        ObservableList<Reclamation> obs5 = FXCollections.observableArrayList(ats5);
        tb.setItems(obs5);
        nomR.setCellValueFactory(new PropertyValueFactory<>("nomR"));
        sujetR.setCellValueFactory(new PropertyValueFactory<>("sujetR"));
        dateR.setCellValueFactory(new PropertyValueFactory<>("dateR"));
    }
}
