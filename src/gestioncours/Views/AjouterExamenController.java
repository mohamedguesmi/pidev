/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncours.Views;

import gestioncours.Entities.Examen;
import gestioncours.Service.ExamenService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class AjouterExamenController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private Button ajouter;
    @FXML
    private TextField dureeE;
    @FXML
    private DatePicker dateE;
    @FXML
    private Button v;
    @FXML
    private Button r;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
retour.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("GestionExamen.fxml"));
             retour.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AjouterExamenController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             }); 
        v.setOnAction(e->{
          //Local(String nom, String adresse, float prix,float surface,int capacite)  
        Alert alert = new Alert(Alert.AlertType.WARNING);

                alert.setTitle("Error");
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle("Success");
                
                 
         String du= dureeE.getText();
         String da= dateE.getEditor().getText();
         String ch="";
         Boolean ok =true;
         int pr= -1;
         int test=Integer.parseInt(du);

        
         if(!du.matches("\\d+")||da.length()==0)
         {
             ch += "Vous devez entrer une taille valide!\n";
                ok=false;
         }
         else pr = Integer.parseInt(du);
         if(ok==true){
             Examen examen = new Examen(pr,da);
             ExamenService es = new ExamenService();
             try {
                es.ajouterExamen(examen);
                ch+="Ajout effectué avec success!\n";
                alert1.setContentText(ch);
                alert1.show();
                 
             } catch (SQLException ex) {
                 Logger.getLogger(AjouterExamenController.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         else {
             alert.setContentText(ch);
             alert.show();
         }
        });
        r.setOnAction(e->{
          dureeE.setText("");
          dateE.setValue(LocalDate.now());
       });  
    }            
    
        }    
    

