/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncours.Views;

import gestioncours.Entities.Cours;
import gestioncours.Service.CoursService;
import gestioncours.Service.Mailing;
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
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class AjouterCoursController implements Initializable {

    private String imageP;
    @FXML
    private ImageView ImageField;
    @FXML
    private Label ImagePath;
    @FXML
    private TextField nomC;
    @FXML
    private TextField nbH;
    @FXML
    private TextField nomE;
    @FXML
    private Button v;
    @FXML
    private Button r;
    CoursService cs = new CoursService();
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        v.setOnAction(e->{
          //Local(String nom, String adresse, float prix,float surface,int capacite)  
        Alert alert = new Alert(Alert.AlertType.WARNING);

                alert.setTitle("Error");
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle("Success");

        String n= nomC.getText();
         String nb=nbH.getText();
         String ne= nomE.getText();

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
             Cours cours = new Cours(n,ne,pr,imageP);
             CoursService cs = new CoursService();
             try {
                  List<String> emails = new ArrayList<>();
                  emails = cs.GetEmails();
                cs.ajouterCours(cours);
                ch+="Ajout effectué avec success!\n";
//                 System.err.println("This is Test !!!!");
//                 try {
//                     Mailing.mailing(emails.get(0));
//                 } catch (Exception ex) {
//                     Logger.getLogger(AjouterCoursController.class.getName()).log(Level.SEVERE, null, ex);
//                 }
//                 System.err.println("This is Test !!!!");
                alert1.setContentText(ch);
                alert1.show();
                for(String email : emails) {
                     System.err.println("This is Test !!!!");
                    System.err.println(email);
                      try {
                          Mailing.mailing(email);
                      } catch (Exception ex) {
                          Logger.getLogger(AjouterCoursController.class.getName()).log(Level.SEVERE, null, ex);
                      }
                }
//                
                 
             } catch (SQLException ex) {
                 Logger.getLogger(AjouterCoursController.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         else {
             alert.setContentText(ch);
             alert.show();
         }
        });
         r.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("GestionCours.fxml"));
             r.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(ModifierCoursController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             });  
    }    
    
    @FXML
    public void ChoiceImage() throws FileNotFoundException, IOException {
        FileChooser fc = new FileChooser();
        //fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", listFichier));
        File f = fc.showOpenDialog(null);
        if (f != null) {

            //Commentaire.setText("Image selectionnée" + f.getAbsolutePath());
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(new File(f.getAbsolutePath()));
//             
                os = new FileOutputStream(new File("C:/xampp/htdocs/AssetsPIDEV/" + f.getName()));
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                System.out.println("louay");

            } finally {
                is.close();
                os.close();

            }

            File file = new File("C:/xampp/htdocs/AssetsPIDEV/" + f.getName());
//            System.out.println(file.toURI().toString());
            ImageField.setImage(new Image(file.toURI().toString()));
            imageP = f.getName();
            System.out.println(imageP);
            ImagePath.setText(imageP);
        } else if (f == null) {
            //Commentaire.setText("Erreur chargement de l'image");
            System.out.println("Erreur !");
        }

    }
    
}
