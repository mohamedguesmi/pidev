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
import javafx.event.ActionEvent;
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
public class AttestationFController implements Initializable {

    @FXML
    private Button r;
    @FXML
    private Button AjouterA;
    @FXML
    private Button ActualiserF;
    @FXML
    private Button ModifierA;
    @FXML
    private Button SupprimerA;
    private TableView<Attestation> table;
    @FXML
    private TableColumn<Attestation, String> typeA;
    @FXML
    private TableColumn<Attestation, String> langueA;
    @FXML
    private TableColumn<Attestation, String> dateA;
    
    private static Attestation at;
    @FXML
    private TableView<Attestation> tb;
    @FXML
    private Button r2;
    @FXML
    private TextField recherche;
    AttestationService as= new AttestationService(); 


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            r2.setOnAction(e->{ 
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Front.fxml"));
                r2.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
          
        
        ArrayList<Attestation> ats= new ArrayList<Attestation>();
        try {
            ats = (ArrayList<Attestation>) as.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(GestionServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Attestation> obs1 = FXCollections.observableArrayList(ats);
        
        tb.setItems(obs1);
        typeA.setCellValueFactory(new PropertyValueFactory<>("typeA"));
        langueA.setCellValueFactory(new PropertyValueFactory<>("langueA"));
        dateA.setCellValueFactory(new PropertyValueFactory<>("dateA"));
        AjouterA.setOnAction(e->{ 
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("AjouterAttestation.fxml"));
                AjouterA.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AjouterAttestationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
        SupprimerA.setOnAction(e -> {
            at = tb.getSelectionModel().getSelectedItem();
                if(at != null)
                {
                at = tb.getSelectionModel().getSelectedItem();
                    try {
                        as.deleteAttestation(at);
                        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                         alert1.setContentText("Suppression effectuée avec succès!");
                         alert1.show();
                           
                    } catch (SQLException ex) {
                        Logger.getLogger(AttestationFController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                AttestationService as5= new AttestationService(); 
        ArrayList<Attestation> ats5= new ArrayList<Attestation>();
        try {
            ats5 = (ArrayList<Attestation>) as5.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(AttestationFController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Attestation> obs5 = FXCollections.observableArrayList(ats5);
        tb.setItems(obs5);
        typeA.setCellValueFactory(new PropertyValueFactory<>("typeA"));
        langueA.setCellValueFactory(new PropertyValueFactory<>("langueA"));
        dateA.setCellValueFactory(new PropertyValueFactory<>("dateA"));
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

        ModifierA.setOnAction(e -> {
            //(String id,String nom, String adresse, String prix, String surface,String capacite)

            at = tb.getSelectionModel().getSelectedItem();
            if (!(at == null)) {
                try {
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("ModifierAttestation.fxml"));
                    ModifierA.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AttestationFController.class.getName()).log(Level.SEVERE, null, ex);
                }
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

       
        ActualiserF.setOnAction(e -> {
          AttestationService cs5= new AttestationService(); 
        ArrayList<Attestation> ats5= new ArrayList<Attestation>();
        try {
            ats5 = (ArrayList<Attestation>) cs5.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(AttestationFController.class.getName()).log(Level.SEVERE, null, ex);
        }
         ObservableList<Attestation> obs5 = FXCollections.observableArrayList(ats5);
        tb.setItems(obs5);
        typeA.setCellValueFactory(new PropertyValueFactory<>("typeA"));
        langueA.setCellValueFactory(new PropertyValueFactory<>("langueA"));
        dateA.setCellValueFactory(new PropertyValueFactory<>("dateA"));
        
    });   
        
    } 
    public Attestation getA() {
        return at;
    }

    @FXML
    private void chercher(ActionEvent event) {
        String type= recherche.getText();
        AttestationService cs5= new AttestationService(); 
        ArrayList<Attestation> ats5= new ArrayList<Attestation>();
        tb.getSelectionModel().clearSelection();
        System.out.println(type);
        try {
           ats5= as.Rechercher(type);
        } catch (SQLException ex) {
            
           System.out.println("Problemeee  ................ .");
            System.out.println(ex.getMessage());
        }
        
         ObservableList<Attestation> obs5 = FXCollections.observableArrayList(ats5);
        tb.setItems(obs5);
        typeA.setCellValueFactory(new PropertyValueFactory<>("typeA"));
        langueA.setCellValueFactory(new PropertyValueFactory<>("langueA"));
        dateA.setCellValueFactory(new PropertyValueFactory<>("dateA"));
    }
}
