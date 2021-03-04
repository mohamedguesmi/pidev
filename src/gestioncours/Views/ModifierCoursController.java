/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncours.Views;

import gestioncours.Entities.Cours;
import gestioncours.Service.CoursService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class ModifierCoursController implements Initializable {

    @FXML
    private Button r;
    @FXML
    private TextField nomC;
    @FXML
    private TextField nbH;
    @FXML
    private TextField nomE;
    @FXML
    private Button v;
    private static Cours cr;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GestionCoursController gcc = new GestionCoursController();
        Cours crs= gcc.getC();
        nomC.setText(crs.getNom());
        nomE.setText(crs.getNom_ens());
        nbH.setText(String.valueOf(crs.getNb_heure()));
         r.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("GestionCours.fxml"));
             r.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(ModifierCoursController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             });  
         v.setOnAction(e->{
          //Local(String nom, String adresse, float prix,float surface,int capacite)  
         Alert alert = new Alert(Alert.AlertType.WARNING);

                alert.setTitle("Error");
                  
         Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle("Error");
                 
         String n= nomC.getText();
         String ne=nomE.getText();
         String nb= nbH.getText();
         String ch="";
         Boolean ok =true;
         int pr = -1;
         int test=Integer.parseInt(nb);
         if(!n.matches("^[a-zA-Z]+$")){
             ch+="Vous devez entrer un nom valide!\n";
             ok=false;
         }
         if(!ne.matches("^[a-zA-Z]+$")){
             ch+="Vous devez entrer un nom d'enseignant valide!\n";
             ok=false;
         }
         if(!nb.matches("\\d+")||nb.length()==0||test>3){
             ch+="Vous devez entrer une durée inferieure a 3 heures\n";
             ok=false;
         }
         else pr = Integer.parseInt(nb);
         if(ok==true){
             
             Cours cours = new Cours(n, ne, pr);
             cours.setId(crs.getId());
             CoursService cs = new CoursService();
             try {
                 cs.updateCours(cours);
                 ch+="Modification effectué avec success!\n";
                alert1.setContentText(ch);
                alert1.show();
             } catch (SQLException ex) {
                 Logger.getLogger(ModifierCoursController.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         else {
             alert.setContentText(ch);
                alert.show();
         }
        });
         
    }    
    public Cours getC() {
        return cr;
}
}
