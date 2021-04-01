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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierAttestationController implements Initializable {

    @FXML
    private ChoiceBox<String> typeA;
    @FXML
    private TextField langueA;
    @FXML
    private Button valider;
    @FXML
    private DatePicker dateA;
    @FXML
    private Button r;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeA.getItems().add("Présence");
        typeA.getItems().add("Inscription");
        AttestationFController afc = new AttestationFController();
        Attestation ats= afc.getA();
        String dateAT= ats.getDateA();
        typeA.setValue(ats.getTypeA());
        langueA.setText(ats.getLangueA());
        dateA.setValue(LocalDate.now());
        System.out.println("bla"+ats.getId());
         
              r.setOnAction(e->{ 
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("AttestationF.fxml"));
                r.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            });

         valider.setOnAction(e->{
          //Local(String nom, String adresse, float prix,float surface,int capacite)  
         Alert alert = new Alert(Alert.AlertType.WARNING);

                alert.setTitle("Error");
                  
         Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle("Error");
                 
         String t= typeA.getValue();
         String l=langueA.getText();
         String d= dateA.getEditor().getText();
         String ch="";
         Boolean ok =true;
         int pr = -1;
        /* if(!t.matches("^[a-zA-Z]+$")){
             ch+="Vous devez entrer un bloc valide!";
             ok=false;
         }*/
         if(!l.matches("^[a-zA-Z]+$")){
             ch+="Vous devez entrer une libelle valide!";
             ok=false;
         }
         if(ok==true){
             
             Attestation attestation = new Attestation(t, l, d);
             attestation.setId(ats.getId());
             AttestationService as = new AttestationService();
             try {
                 as.updateAttestation(attestation);
                 ch+="Modification effectué avec success!\n";
                alert1.setContentText(ch);
                alert1.show();
             } catch (SQLException ex) {
                 Logger.getLogger(ModifierAttestationController.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         else {
             alert.setContentText(ch);
                alert.show();
         }
        });
    }    
    
}
