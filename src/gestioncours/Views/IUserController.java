/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncours.Views;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import javafx.scene.paint.ImagePattern;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class IUserController implements Initializable {

    @FXML
    private FlowPane FlowPaneCour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            affichageUS();
        } catch (SQLException ex) {
            Logger.getLogger(IUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
      public void setFILES(String Body, String Body1, String Body2, String Body3,String path) {
        try {

            OutputStream file = new FileOutputStream(new File("cour"+Math.random()+".pdf"));

            Document document = new Document();

            PdfWriter.getInstance(document, file);

            document.open();
            document.addTitle("Cour");

            com.itextpdf.text.Image img;
            img = com.itextpdf.text.Image.getInstance(path);
            com.itextpdf.text.Image.getInstance(img);
            document.add(img);
            document.add(new Paragraph("                    "));
            document.add(new Paragraph("                    "));
            document.add(new Paragraph("                    "));
            document.add(new Paragraph("                    "));
            document.add(new Paragraph(Body));
            document.add(new Paragraph(Body1));
            document.add(new Paragraph(Body2));
            document.add(new Paragraph(Body3));
            document.close();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
      
       public void btnPDF(String Body, String Body1, String Body2, String Body3, String path) throws IOException, SQLException {
        //User userTest = new User(102, "Louay", "Yahyaoui", "louay@esprit.tn", "louay", "oussema", "male", "28-08-1992", 234223878, "SimpleUtilisateur", "Comedie", "hahaha", 5000);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Button button2 = new Button();
        button2.setStyle("-fx-background-color: #00ff00");
        alert.setTitle("PDF ");
        alert.setContentText("votre cours est telecharger en format pdf ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            setFILES(Body, Body1, Body2, Body3,path);

        } else {

        }
    }
    
    
    private void affichageUS() throws SQLException {

        CoursService ser = new CoursService();

        ObservableList<Cours> listComp = FXCollections.observableArrayList(ser.readAll());

        System.out.println("We're right here for now ");
        ArrayList<Separator> as = new ArrayList<>();
        ArrayList<VBox> vbx = new ArrayList<>();
        ArrayList<HBox> btnP = new ArrayList<>();

        for (int i = 0; i < listComp.size(); i++) {

            Separator h = new Separator(Orientation.VERTICAL);
            h.setPrefWidth(17);
            h.setPrefHeight(24);
            h.setVisible(false);
            as.add(h);

            VBox VBoxComp = new VBox();

            VBoxComp.setSpacing(7);
            VBoxComp.setStyle("-fx-background-color : #FFFFFF;");
            //VBoxComp.setStyle("-fx-border-color : #2B48E8;");
            VBoxComp.setAlignment(Pos.CENTER);
            VBoxComp.setPrefHeight(265);
            VBoxComp.setPrefWidth(230);
            HBox panne = new HBox();
            panne.setSpacing(5);
            panne.setStyle("-fx-background-color : #FFFFFF;");
            //VBoxComp.setStyle("-fx-border-color : #2B48E8;");
            panne.setAlignment(Pos.CENTER);
            panne.setPrefHeight(30);
            panne.setPrefWidth(80);

            Rectangle c = new Rectangle(230, 180);

//                ImageView img = new ImageView(new Image(new FileInputStream("C:\\Users\\loume78\\Desktop\\Mon_cv\\loume.png")));
//                img.setFitHeight(10);
//                img.setFitWidth(20);
            try {
                c.setFill(new ImagePattern(new Image(new FileInputStream("C:/xampp/htdocs/AssetsPIDEV/" + listComp.get(i).getImage()))));
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

            VBoxComp.getChildren().add(c);

            Label titreComp = new Label("Titre : " + listComp.get(i).getNom());
            
            //Label mail = new Label("Mail: " + listUs.get(i).getMail());
            //Label tel = new Label("téléphone: " + listUs.get(i).getNumTel());
            //Label etat = new Label();
            //Label adresse = new Label("Adresse: " + listUs.get(i).getAdresse().getVille() + "," + listUs.get(i).getAdresse().getPays());

            int idCour = listComp.get(i).getId();
            String path = ("C:/xampp/htdocs/AssetsPIDEV/" + listComp.get(i).getImage());
//            Competition c1 = ser.findById(idCompetition);
            

           

            Button print = new Button("Print");
            //String modifbtn = listComp.get(i).getTitre();
            print.setStyle("-fx-background-color : #60A9C4;");
            print.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    
                                    String Body = "réviser bien ";
                                    String Body1 = "";
                                    String Body2 = "";
                                    String Body3 = " ";
                                    try {
                                        btnPDF(Body, Body1, Body2, Body3,path);
                                    } catch (IOException ex) {
                                        Logger.getLogger(IUserController.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (SQLException ex) {
                        Logger.getLogger(IUserController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    
                }
            });
            
            panne.getChildren().add(print);
            VBoxComp.getChildren().add(panne);

//            ComboBox<String> actions = new ComboBox<>();
//            actions.setPromptText("Les Actions");
//
//            if (listUs.get(i).getEnabled() == 1) {
//                etat.setText("Etat: Activer");
//                actions.getItems().addAll("Voir Profil", "Désactiver", "Chat");
//            } else if (listUs.get(i).getEnabled() == 0) {
//                etat.setText("Etat: Désactiver");
//                actions.getItems().addAll("Voir Profil", "Activer", "Chat");
//            }
//            else if (listUs.get(i).getEnabled() == -1) {
//                etat.setText("Etat: Non Encore Activer");
//                actions.getItems().addAll("Voir Profil", "Activer", "Chat");
//            }
//            
//            Alert al = new Alert(Alert.AlertType.NONE);
//            ButtonType Oui = new ButtonType("Oui");
//            ButtonType Non = new ButtonType("Non");
//
//            al.getButtonTypes().addAll(Oui, Non);
//            actions.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    if (actions.getValue().equals("Voir Profil")) {
//                        System.out.println("Voir Profil " + id);
//                    } else if (actions.getValue().equals("Désactiver")) {
//                        al.setContentText("Vous Voulez vraiment désactiver le compte !");
//                        Optional<ButtonType> OuiNon = al.showAndWait();
//                        if (OuiNon.get() == Oui) {
//                            gUs.desactiverCompte(id);
//                            flowPaneUsers.getChildren().clear();
//                            affichageUS();
//                        }
//
//                    } else if (actions.getValue().equals("Activer")) {
//                        al.setContentText("Vous Voulez vraiment activer le compte !");
//                        Optional<ButtonType> OuiNon = al.showAndWait();
//                        if (OuiNon.get() == Oui) {
//                            gUs.activerCompte(id);
//                            flowPaneUsers.getChildren().clear();
//                            affichageUS();
//                        }
//                    }
//                    System.out.println(actions.getValue() + " ; " + id);
//
//                }
//            });
            VBoxComp.getChildren().add(titreComp);
            
//            VBoxUser.getChildren().add(mail);
//            VBoxUser.getChildren().add(etat);
//            VBoxUser.getChildren().add(adresse);
//            VBoxUser.getChildren().add(actions);

            vbx.add(VBoxComp);
            btnP.add(panne);
            FlowPaneCour.getChildren().add(vbx.get(i));

            FlowPaneCour.getChildren().add(as.get(i));

            if (i == 0) {
                System.out.println("i=0 llllll");
            } else if (((i + 1) % 3) == 0) {
                Separator sepHoriz = new Separator(Orientation.HORIZONTAL);
                sepHoriz.setPrefWidth(30);
                sepHoriz.setPrefHeight(30);
                sepHoriz.setVisible(false);
                FlowPaneCour.getChildren().add(sepHoriz);

            }
        }
    }
}


    
    

