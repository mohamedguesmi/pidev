/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncours.Views;

import gestioncours.Entities.Examen;
import gestioncours.Service.CoursService;
import gestioncours.Service.ExamenService;
import gestioncours.Util.DataBase;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class AffecterExamenController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private Button ajouter;
    @FXML
    private Button v;
    @FXML
    private Button r;
    @FXML
    private ComboBox<String> cours;
    @FXML
    private DatePicker dateE;
    @FXML
    private TextField dureE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Connection connexion = DataBase.getInstance().getConnexion();
         try{
            String sql="select nom from cours";
            Statement ste = connexion.createStatement();
            ResultSet rs=ste.executeQuery(sql);
            while(rs.next())
        {
            cours.getItems().addAll(rs.getString("nom")); 
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(ModifierExamenController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
        GestionExamenController gec = new GestionExamenController();
        Examen exm= gec.getE();
        int x=exm.getDuree();
        dureE.setText(String.valueOf(x));
        dateE.setValue(LocalDate.now());
        dureE.setEditable(false);
        dateE.setEditable(false);
        retour.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("GestionExamen.fxml"));
             retour.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AffecterExamenController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             });  
         v.setOnAction(e->{
             //Local(String nom, String adresse, float prix,float surface,int capacite)
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Error");
             Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
             alert.setTitle("Error");
             String du= dureE.getText();
             String da=dateE.getEditor().getText();
             String c = cours.getSelectionModel().getSelectedItem().toString();
             String ch="";
             Boolean ok =true;
             int qt = -1;
             int test=Integer.parseInt(du);
             if(!da.matches("^[a-zA-Z]+$")){
                 ch+="Vous devez entrer un nom valide!";
                 ok=false;
             }
             if(!du.matches("\\d+")||du.length()==0){
                 ch+="Vous devez entrer un prenom valide!";
                 ok=false;
             }
             else qt = Integer.parseInt(du);
             if(ok==true){
                 
                 Examen examen = new Examen(qt,c,da);
                 examen.setId(exm.getId());
                 ExamenService es = new ExamenService();
                 try {
                     es.updateExamen(examen);
                     ch+="Operation effectuée avec success!\n";
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
      

    }    
    
    
}
