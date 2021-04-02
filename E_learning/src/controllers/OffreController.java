/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modeles.Offre;
import services.OffreService;

/**
 * FXML Controller class
 *
 * @author amado
 */
public class OffreController implements Initializable {

    @FXML
    private TextField txtcode;
    @FXML
    private TextField txtid_formation;
    @FXML
    private TextField txtprix;
    @FXML
    private DatePicker txtdate_delai;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button btnactualiser;
    @FXML
    private Button btnretour;
    @FXML
    private TableView<Offre> tabview;
    @FXML
    private Button btnrecherche;
    @FXML
    private TextField txtrecherche;
    @FXML
    private TableColumn<Offre, Integer> tabCode;
    @FXML
    private TableColumn<Offre, Integer> tabId_form;
    @FXML
    private TableColumn<Offre, Float> tabPrix;
    @FXML
    private TableColumn<Offre, Date> tabDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        btnmodifier.setDisable(true);
         btnactualiser.setDisable(true);
//          btnrecherche.setDisable(true);
           btnsupprimer.setDisable(true);
          btnretour.setDisable(true);
//          btnajouter.setDisable(true);
          
           tabCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        tabId_form.setCellValueFactory(new PropertyValueFactory<>("id_formation"));
        tabPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
         tabDate.setCellValueFactory(new PropertyValueFactory<>("date_delai"));
         
               OffreService offreAfficher=new OffreService();

tabview.setItems((offreAfficher.displayWithTableView()));
tabview.getColumns().addAll(tabCode,tabId_form,tabPrix,tabDate);
tabview.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetails(newValue));


    }    

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        OffreService myOffreServ=new OffreService();

        OffreService offreAjout=new OffreService();
        Offre offre1=new Offre();
        if((txtid_formation.getText().isEmpty())||(txtprix.getText().isEmpty())
                ){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText("Le champ nom est vide");
        alert.showAndWait();
                
        } 
        else if ((txtprix.getText().matches("^[a-zA-Z]*$"))){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText("Le champ prix doit etre des entiers ou des réels");
        
        alert.showAndWait();
        }

        
 

//        offre1.setCode(Integer.parseInt(txtcode.getText()));
            offre1.setId_formation(Integer.parseInt(txtid_formation.getText()));
       
       offre1.setPrix(Float.parseFloat(txtprix.getText()));
       
        offre1.setDate_delai(java.sql.Date.valueOf(txtdate_delai.valueProperty().getValue()));
        
         
        
        
      
        
         if (txtdate_delai.getValue().isBefore(LocalDate.now())) {
                    JOptionPane.showMessageDialog(null,
                            "La date de debut de l'offre doit être supérieure ou égale à la date d'aujourd'hui",
                            "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);   
                } 
        
        
        
        
        
        offreAjout.insert(offre1);
          
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/Offre.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage app_stage =(Stage)((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
        
              
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        
        
        int code=(tabview.getSelectionModel().getSelectedItem().getCode());
          
           
//           if((CurrentUser.currentId==Id_user)||(CurrentUser.current.equals("binoty"))){
        
        OffreService offreModifiert=new OffreService();
        Offre frm=new Offre();
        
       

        //int a=user.getId();
        int b=Integer.parseInt(txtcode.getText());
        //b=a;0
        frm.setCode(Integer.parseInt(txtcode.getText()));
        frm.setId_formation(Integer.parseInt(txtid_formation.getText()));
        frm.setPrix(Float.parseFloat(txtprix.getText()));

        
        
        frm.setDate_delai(java.sql.Date.valueOf(txtdate_delai.valueProperty().getValue()));
        
       
         if ((txtprix.getText().matches("^[a-zA-Z]*$"))){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText("Le champ Prix doit etre des entiers ou des réels");
        
        alert.showAndWait();
        }
        frm.setPrix(Float.parseFloat(txtprix.getText()));
        
      
       offreModifiert.update(frm);
       
               Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/Offre.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage app_stage =(Stage)((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();   
        
  
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }

    @FXML
    private void actualiser(ActionEvent event) {
          txtcode.setText("");
          txtid_formation.setText("");
          txtprix.setText("");
       
           
          txtdate_delai.setValue(null);
          
          btnajouter.setDisable(false);
         
           btnmodifier.setDisable(true);
            btnsupprimer.setDisable(true);
          
        
         
       
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage app_stage =(Stage)((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();  
    }

    @FXML
    private void rechercher(ActionEvent event) {
        
         OffreService evS = new OffreService();
           
          
          String recherche = txtrecherche.getText();
          
         
        tabview.setItems( evS.searchOffre(recherche));
//        tabview.getColumns().addAll(tabCode,tabId_form,tabPrix,tabDate);
    }
    
     private void showDetails(Offre b) {
 
        if (b != null) {
           

        btnmodifier.setDisable(false);
        btnsupprimer.setDisable(false);
        
        btnajouter.setDisable(true);
        btnactualiser.setDisable(false);
        
        
    txtcode.setText(String.valueOf(b.getCode()));
    txtid_formation.setText(String.valueOf(b.getId_formation()));
    txtprix.setText(String.valueOf(b.getPrix()));
//    txtLien.setText(b.getLien_cours());
        
         txtdate_delai.setValue(b.getDate_delai().toLocalDate());
//         txtDate_fin.setValue(b.getDate_fin().toLocalDate());
//         txtPrix.setText(String.valueOf(b.getPrix()));
//        
      //txtVote.setText(String.valueOf(b.isVote()));
        } else {
  txtcode.setText("");txtid_formation.setText(""); txtprix.setText("");
  
   txtdate_delai.setValue(null);     
        }
        
        
    }
    
    
}
