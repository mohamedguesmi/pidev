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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modeles.Formation;
import services.FormationService;
import javax.swing.JOptionPane;


//import tray.animations.AnimationType;
//import tray.notification.NotificationType;
//import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author amado
 */
public class FormationController implements Initializable {

    @FXML
    private TextField txtTitre;
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtLien;
    @FXML
    private TextField txtPrix;
    @FXML
    private DatePicker txtDate_debut;
    @FXML
    private DatePicker txtDate_fin;
    @FXML
    private TextField txtId;
    @FXML
    private Button btnAjout;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnAct;
    @FXML
    private Button btnFormation;
    @FXML
    private Button btnOffre;
    @FXML
    private Button btnRechercher;
    @FXML
    private TextField txtRecher;
    @FXML
    private TableView<Formation> tabView;
    @FXML
    private TableColumn<Formation, String> tabTitre;
    @FXML
    private TableColumn<Formation, Integer> tabUser;
    @FXML
    private TableColumn<Formation, String> tabLien_cours;
    @FXML
    private TableColumn<Formation, Date> tabdate_debut;
    @FXML
    private TableColumn<Formation, Float> tabPrix;
    @FXML
    private TableColumn<Formation, Integer> tabId;
    @FXML
    private TableColumn<Formation, Date> tabdate_fin;
    
    String title = "SocialPro NOTIFICATION",message;
//    TrayNotification tray = new TrayNotification();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnModifier.setDisable(true);
//        btnAjout.setDisable(true);
        btnDelete.setDisable(true);
        
        
        tabId.setCellValueFactory(new PropertyValueFactory<>("id_ref"));
        tabUser.setCellValueFactory(new PropertyValueFactory<>("id_user"));
         tabTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        tabLien_cours.setCellValueFactory(new PropertyValueFactory<>("lien_cours"));
        tabdate_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        tabdate_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        tabPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     
        FormationService formationAfficher=new FormationService();
        
       tabView.setItems((formationAfficher.displayWithTableView()));
       tabView.getColumns().addAll(tabId,tabUser,tabLien_cours,tabdate_debut,tabdate_fin,tabPrix,tabTitre);
       tabView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetailsBien(newValue));
        
//        txtId.setVisible(false);
//    
//
//        btnModifier.setDisable(true);
//        btnDelete.setDisable(true);
    }    

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
        
//          FormationService myFormationServ=new FormationService();
        //User myUser=new User();
        //int a= myUser.getId();
        //myUser=myUserServ.findById(user.getId());
//          user = new UserServices().findById(userId);
//          new UserServices().findById(userId);

        FormationService formationAjout=new FormationService();
        Formation formation1=new Formation();
        if((txtTitre.getText().isEmpty())||(txtUser.getText().isEmpty())||(txtLien.getText().isEmpty())
                ){
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText("Le champ nom est vide");
        alert.showAndWait();
                
        } 
        else if ((txtPrix.getText().matches("^[a-zA-Z]*$"))){
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText("Le champ prix doit etre des entiers ou des réels");
        
        alert.showAndWait();
        }

        
        
        //int a=user.getId();
//        int b=Integer.parseInt(txtUser.getText());
        //b=a;
       // evt.setUser_id((myUserServ.findById2(user.getId())));
       //evt.setUser_id((1));
//        MyName=txtNom.getText();

//        evt.setUser_id(CurrentUser.currentId);

        formation1.setId_user(Integer.parseInt(txtUser.getText()));  
        formation1.setLien_cours(txtLien.getText());
        formation1.setTitre(txtTitre.getText());
       
        formation1.setDate_debut(java.sql.Date.valueOf(txtDate_debut.valueProperty().getValue()));
        formation1.setDate_fin(java.sql.Date.valueOf(txtDate_fin.valueProperty().getValue()));
//        formation1.setDate(Date.valueOf(LocalDate.now()));
         
        
        formation1.setPrix(Float.parseFloat(txtPrix.getText()));
      
        
         if (txtDate_debut.getValue().isBefore(LocalDate.now())) {
                    JOptionPane.showMessageDialog(null,
                            "La date de debut de la formation doit être supérieure ou égale à la date d'aujourd'hui",
                            "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);   
                } else {
                    System.out.println("correct");
                }
          if (txtDate_fin.getValue().isBefore(txtDate_fin.getValue())) {                
                    JOptionPane.showMessageDialog(null,
                            "La date de fin de la formation  doit être supérieure à la date de debut de l'evenemla formation ",
                            "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);             
                } else {
                    System.out.println("correct");
                }
        
        
        
        
        
        formationAjout.insert(formation1);
          
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/Formation.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage app_stage =(Stage)((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
        
            message = " votre evenement a été ajouté avec succes!";
//                tray.setTitle(title);
////                tray.setImage(new Image(photoPathArea.getText()));
//                tray.setMessage(message);
//                tray.setNotificationType(NotificationType.SUCCESS);
//                tray.setAnimationType(AnimationType.SLIDE);
//                tray.showAndDismiss(Duration.millis(6500.0));
                
        
//        String description=txtDescription.getText();
//        String nom=txtNom.getText();
//        String lieu=txtLieu.getText();
//        String theme=txtTheme.getText(); 
//        Date  MyDate=txtDate.setD
//       
//        float latitude=Float.parseFloat(txtLat.getText());
//        float longitude=Float.parseFloat(txtLng.getText());
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        
        int selectedIndex = tabView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            
           Formation formation = new Formation();
           FormationService formationSupprimer=new FormationService();
           
           int Id_delete=(tabView.getSelectionModel().getSelectedItem().getId_ref());
            //String nomBien = tabV.getSelectionModel().getSelectedItem().getNom();
            //Bien e = evennementUtil.getIdeeByTitre(nomBien);
           // evennementDAO.delete(e);
           
           int Id_user=(tabView.getSelectionModel().getSelectedItem().getId_user());
          
           
//           if((CurrentUser.currentId==Id_user)||(CurrentUser.current.equals("binoty"))){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(tabView.getScene().getWindow());
            alert.setTitle("your Confirmation");
            alert.setHeaderText("Suppression formation");
            alert.setContentText("Do you want to remove this formation");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
           formationSupprimer.delete(Id_delete);
            tabView.getItems().remove(selectedIndex);
           System.out.println("la formation a été supprimer"+Id_delete);
           }});
            
            }
//           else{
//            Alert alert2 = new Alert(Alert.AlertType.WARNING);
//            alert2.initOwner(tabView.getScene().getWindow());
//            alert2.setTitle("you can't delete this object");
//            alert2.setHeaderText("Not Allowed");
//            alert2.setContentText("Only the owner can delete it.");
//            alert2.showAndWait();
//               
//           }
          
           // allEventTable.getItems().remove(e);

           
//         else {
//            System.out.println("erreurSuppBien");
////            // Nothing selected.
////            Alert alert = new Alert(AlertType.WARNING);
////            alert.initOwner(mainApp.getPrimaryStage());
////            alert.setTitle("No Selection");
////            alert.setHeaderText("No Person Selected");
////            alert.setContentText("Please select a person in the table.");
////            
////            alert.showAndWait();
//      }
    }

    @FXML
    private void Modifier(ActionEvent event) throws IOException {
        
        int Id_user=(tabView.getSelectionModel().getSelectedItem().getId_ref());
          
           
//           if((CurrentUser.currentId==Id_user)||(CurrentUser.current.equals("binoty"))){
        
        FormationService formationtModifiert=new FormationService();
        Formation frm=new Formation();
        
       

        //int a=user.getId();
        int b=Integer.parseInt(txtUser.getText());
        //b=a;0
        frm.setId_ref(Integer.parseInt(txtId.getText()));
        frm.setId_user(Integer.parseInt(txtUser.getText()));
        frm.setTitre(txtTitre.getText());
        frm.setLien_cours(txtLien.getText());
        
        frm.setDate_debut(java.sql.Date.valueOf(txtDate_debut.valueProperty().getValue()));
        frm.setDate_fin(java.sql.Date.valueOf(txtDate_fin.valueProperty().getValue()));
       
        if((txtTitre.getText().isEmpty())||(txtLien.getText().isEmpty()))
              {
                  
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText("Le champ nom est vide");
        alert.showAndWait();
                
        } 
        else if ((txtPrix.getText().matches("^[a-zA-Z]*$"))){
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText("Le champ Prix doit etre des entiers ou des réels");
        
        alert.showAndWait();
        }
        frm.setPrix(Float.parseFloat(txtPrix.getText()));
        
      
       formationtModifiert.update(frm);
        
//            evt.setUser_id(1);
//        evt.setNom(txtNom.getText());
//        evt.setDescription(txtDescription.getText());
//        evt.setLieu(txtLieu.getText());
//        evt.setTheme(txtTheme.getText());
//        evt.setDate_debut(java.sql.Date.valueOf(txtDateDebut.valueProperty().getValue()));
//        evt.setDate_fin(java.sql.Date.valueOf(txtDateFin.valueProperty().getValue()));
//        evt.setDate(Date.valueOf(LocalDate.now()));
//         
//        evt.setNombre_place(Integer.parseInt(txtNbr.getText()));
//        evt.setLat(Float.parseFloat(txtLat.getText()));
//        evt.setLng(Float.parseFloat(txtLng.getText()));
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/Formation.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage app_stage =(Stage)((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();   
        
//        message = " votre formation a été modifié avec succes!";
//                tray.setTitle(title);
////                tray.setImage(new Image(photoPathArea.getText()));
//                tray.setMessage(message);
//                tray.setNotificationType(NotificationType.SUCCESS);
//                tray.setAnimationType(AnimationType.SLIDE);
//                tray.showAndDismiss(Duration.millis(6500.0));
    
//             else{
//            Alert alert2 = new Alert(Alert.AlertType.WARNING);
//            alert2.initOwner(tabV.getScene().getWindow());
//            alert2.setTitle("you can't delete this object");
//            alert2.setHeaderText("You are not Allowed");
//            alert2.setContentText("Only the owner can modify.");
//            alert2.showAndWait();
//               
//           }
    }

    private void ActualiserClear(ActionEvent event) throws IOException {
                
          txtId.setText("");
          txtUser.setText("");
          txtTitre.setText("");
          txtLien.setText("");
            txtPrix.setText("");
           
          txtDate_debut.setValue(null);
          txtDate_fin.setValue(null);
         
          
         // txtVote.setText(null);
         
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/Formation.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage app_stage =(Stage)((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void Actualiser(ActionEvent event) throws IOException {
        txtId.setText("");
          txtUser.setText("");
          txtTitre.setText("");
          txtLien.setText("");
            txtPrix.setText("");
          
          txtDate_debut.setValue(null);
          txtDate_fin.setValue(null);
        
         
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/Formation.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage app_stage =(Stage)((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void afficheFormation(ActionEvent event) throws IOException {
           Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/Formation.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage app_stage =(Stage)((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void afficheOffre(ActionEvent event) throws IOException {
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/Offre.fxml"));
        Scene home_page_scene = new Scene (home_page_parent);
        Stage app_stage =(Stage)((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void rechercher(ActionEvent event) {
        
          FormationService evS = new FormationService();
           
          
          String srch = txtRecher.getText();
          
         
        tabView.setItems( evS.searchFormation(srch));
        
//         tabView.getColumns().addAll(tabId,tabUser,tabLien_cours,tabdate_debut,tabdate_fin,tabPrix,tabTitre);
//       tabView.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) -> showDetailsBien(newValue));
    }
    
    
     private void showDetailsBien(Formation b) {
//      String ResultatVote=String.valueOf(txtVote.getText());
//        if(ResultatVote.equals("false")){
//            btnLike.setStyle("-fx-background-color:#e4d78e");
//            btnLike.setText("I don't like it");
//        } else{
//            btnLike.setStyle("-fx-background-color:#7fc9c4");
//            btnLike.setText("I like it");
//        }  
//    
        if (b != null) {
           

        btnModifier.setDisable(false);
        btnDelete.setDisable(false);
        
        
    txtId.setText(String.valueOf(b.getId_ref()));
    txtUser.setText(String.valueOf(b.getId_user()));
    txtTitre.setText(b.getTitre());
    txtLien.setText(b.getLien_cours());
        
         txtDate_debut.setValue(b.getDate_debut().toLocalDate());
         txtDate_fin.setValue(b.getDate_fin().toLocalDate());
         txtPrix.setText(String.valueOf(b.getPrix()));
        
      //txtVote.setText(String.valueOf(b.isVote()));
        } else {
  txtId.setText("");txtUser.setText(""); txtTitre.setText("");txtLien.setText(""); 
    txtPrix.setText("");
   txtDate_debut.setValue(null);     
  txtDate_debut.setValue(null);          
        }
        
        
    }

    
}
