/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncours.Views;

import gestioncours.Entities.Cours;
import gestioncours.Entities.Examen;
import gestioncours.Service.CoursService;
import gestioncours.Service.ExamenService;
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
 * @author moham
 */
public class GestionExamenController implements Initializable {

    @FXML
    private Button affecterE;
    @FXML
    private Button supprimerE;
    @FXML
    private Button actualiserE;
    @FXML
    private TableView<Examen> table;
    @FXML
    private TableColumn<Examen, String> coursE;
    @FXML
    private TableColumn<Examen,Integer> dureeE;
    @FXML
    private Button AjouterE;
    @FXML
    private TableColumn<Examen, String> dateE;
    private static Examen ex;
    @FXML
    private Button ModifierE;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ExamenService es= new ExamenService(); 
        ArrayList<Examen> exm= new ArrayList<Examen>();
        try {
            exm = (ArrayList<Examen>) es.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(GestionCoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Examen> obs = FXCollections.observableArrayList(exm);
        table.setItems(obs);
        dureeE.setCellValueFactory(new PropertyValueFactory<>("duree"));
        coursE.setCellValueFactory(new PropertyValueFactory<>("cours"));
        dateE.setCellValueFactory(new PropertyValueFactory<>("dateE"));
        AjouterE.setOnAction(e -> {
            //(String id,String nom, String adresse, String prix, String surface,String capacite)

            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("AjouterExamen.fxml"));
                AjouterE.getScene().setRoot(root);

            } catch (IOException ex) {
                Logger.getLogger(AjouterCoursController.class.getName()).log(Level.SEVERE, null, ex);
            }
               });
         affecterE.setOnAction(e -> {
            ex = table.getSelectionModel().getSelectedItem();
            if (!(ex == null)) {
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("AffecterExamens.fxml"));
                affecterE.getScene().setRoot(root);

            } catch (IOException ex) {
                Logger.getLogger(AjouterCoursController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
               });
            supprimerE.setOnAction(e -> {
            //Local(String nom, String adresse, float prix,float surface,int capacite)
            ex = table.getSelectionModel().getSelectedItem();
                if(ex != null)
                {
                ex = table.getSelectionModel().getSelectedItem();
                    try {
                        es.deleteExamen(ex);
                        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                         alert1.setContentText("Suppression effectuée avec succès!");
                           alert1.show();
                           
                    } catch (SQLException ex) {
                        Logger.getLogger(GestionCoursController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                ExamenService ex5= new ExamenService(); 
        ArrayList<Examen> exm5= new ArrayList<Examen>();
        try {
            exm5 = (ArrayList<Examen>) ex5.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(GestionCoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Examen> obs5 = FXCollections.observableArrayList(exm5);
        table.setItems(obs5);
        dureeE.setCellValueFactory(new PropertyValueFactory<>("duree"));
        coursE.setCellValueFactory(new PropertyValueFactory<>("cours"));
        dateE.setCellValueFactory(new PropertyValueFactory<>("dateE"));
                }
                   });

       
        ModifierE.setOnAction(e -> {
            //(String id,String nom, String adresse, String prix, String surface,String capacite)

            ex = table.getSelectionModel().getSelectedItem();
            if (!(ex == null)) {
                try {
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("ModifierExamen.fxml"));
                    ModifierE.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(GestionCoursController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       
        
    }    
    public Examen getE() {
        return ex;
}
    
}
