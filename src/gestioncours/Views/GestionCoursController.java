/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncours.Views;

import gestioncours.Entities.Cours;
import gestioncours.Service.CoursService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class GestionCoursController implements Initializable {

    
    @FXML
    private Button AjouterC;
    @FXML
    private Button AfficherC;
    @FXML
    private Button ModifierC;
    @FXML
    private Button SupprimerC;
    @FXML
    private TableView<Cours> table;
    @FXML
    private TableColumn<Cours, String> nom;
    @FXML
    private TableColumn<Cours, String> nomE;
    @FXML
    private TableColumn<Cours, Integer> nbH;
    @FXML
    private Button r;
    private static Cours cr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CoursService cs= new CoursService(); 
        ArrayList<Cours> crs= new ArrayList<Cours>();
        try {
            crs = (ArrayList<Cours>) cs.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(GestionCoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Cours> obs = FXCollections.observableArrayList(crs);
        table.setItems(obs);
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nomE.setCellValueFactory(new PropertyValueFactory<>("nom_ens"));
        nbH.setCellValueFactory(new PropertyValueFactory<>("nb_heure"));
        AjouterC.setOnAction(e -> {
            //(String id,String nom, String adresse, String prix, String surface,String capacite)

            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("AjouterCours.fxml"));
                AjouterC.getScene().setRoot(root);

            } catch (IOException ex) {
                Logger.getLogger(AjouterCoursController.class.getName()).log(Level.SEVERE, null, ex);
            }
               });
            SupprimerC.setOnAction(e -> {
            //Local(String nom, String adresse, float prix,float surface,int capacite)
            cr = table.getSelectionModel().getSelectedItem();
                if(cr != null)
                {
                cr = table.getSelectionModel().getSelectedItem();
                    try {
                        cs.deleteClasse(cr);
                        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                         alert1.setContentText("Suppression effectuée avec succès!");
                           alert1.show();
                           
                    } catch (SQLException ex) {
                        Logger.getLogger(GestionCoursController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                CoursService cr5= new CoursService(); 
        ArrayList<Cours> cla5= new ArrayList<Cours>();
        try {
            cla5 = (ArrayList<Cours>) cr5.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(GestionCoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Cours> obs5 = FXCollections.observableArrayList(cla5);
        table.setItems(obs5);
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nomE.setCellValueFactory(new PropertyValueFactory<>("nom_ens"));
        nbH.setCellValueFactory(new PropertyValueFactory<>("nb_heure"));
                }
                   });

       
        ModifierC.setOnAction(e -> {
            //(String id,String nom, String adresse, String prix, String surface,String capacite)

            cr = table.getSelectionModel().getSelectedItem();
            if (!(cr == null)) {
                try {
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("ModifierCours.fxml"));
                    ModifierC.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(GestionCoursController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       
         r.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("IAdmin.fxml"));
             r.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(ModifierCoursController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             });  
        
    }  
    
     public Cours getC() {
        return cr;
}
     
     
}
