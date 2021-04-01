/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Attestation;
import Service.AttestationService;
import java.awt.print.PrinterJob;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import javax.mail.Message;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AtesstationadminController implements Initializable {

    @FXML
    private Button r;
    @FXML
    private Button ActualiserF;
    @FXML
    private Button r2;
    @FXML
    private TableView<Attestation> tb;
    @FXML
    private TableColumn<Attestation, String> typeA;
    @FXML
    private TableColumn<Attestation, String> langueA;
    @FXML
    private TableColumn<Attestation, String> dateA;
    @FXML
    private TableColumn<Attestation,Integer > userID;
     private static Attestation at;
     private static ArrayList<Attestation> ats;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        r2.setOnAction(e->{ 
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Back.fxml"));
                r2.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
          
        AttestationService as= new AttestationService(); 
         ats= new ArrayList<Attestation>();
        try {
            ats = (ArrayList<Attestation>) as.readAlls();
        } catch (SQLException ex) {
            Logger.getLogger(GestionServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Attestation> obs1 = FXCollections.observableArrayList(ats);
        
        tb.setItems(obs1);
        typeA.setCellValueFactory(new PropertyValueFactory<>("typeA"));
        langueA.setCellValueFactory(new PropertyValueFactory<>("langueA"));
        dateA.setCellValueFactory(new PropertyValueFactory<>("dateA"));
        userID.setCellValueFactory(new PropertyValueFactory<>("user"));
       
       
        ActualiserF.setOnAction(e -> {
          AttestationService cs5= new AttestationService(); 
        ArrayList<Attestation> ats5= new ArrayList<Attestation>();
        try {
            ats5 = (ArrayList<Attestation>) cs5.readAlls();
        } catch (SQLException ex) {
            Logger.getLogger(AttestationFController.class.getName()).log(Level.SEVERE, null, ex);
        }
         ObservableList<Attestation> obs5 = FXCollections.observableArrayList(ats5);
        tb.setItems(obs5);
        typeA.setCellValueFactory(new PropertyValueFactory<>("typeA"));
        langueA.setCellValueFactory(new PropertyValueFactory<>("langueA"));
        dateA.setCellValueFactory(new PropertyValueFactory<>("dateA"));
        userID.setCellValueFactory(new PropertyValueFactory<>("user"));
        
    });   
        
    } 
    public Attestation getA() {
        return at;
    }   

    @FXML
    private void imprimer(ActionEvent event) {
     // Table.
     Document document = new Document();
     File temp=null;

        PdfWriter writer = null;    //C:\Users\malek.heni\Desktop
        try {
         try {
              temp = File.createTempFile("monfichier",".pdf");
         } catch (IOException ex) {
             Logger.getLogger(AtesstationadminController.class.getName()).log(Level.SEVERE, null, ex);
         }
            writer = PdfWriter.getInstance(document, new FileOutputStream(temp));
                    //"C:\\Users\\ASUS\\Desktop\\WassimMkadmi\\Liste"+Math.random()+".pdf"));
        } catch (FileNotFoundException ex) {
        } catch (DocumentException ex) {
        }
        document.open();
        document.addTitle("Liste des attestations");
        document.addSubject("Gestion Scolarité");
        document.addAuthor("LEADERS");
        document.addCreator("Mkadmi Wassim");
        Paragraph preface = new Paragraph();
        preface.add(new Paragraph("Attestation :"));
        preface.add(new Paragraph("Attestation genéré par: Mkadmi Wassim" + ", le " + new Date()));
        try {
            document.add(preface);
        } catch (DocumentException ex) {
        }
        /*PdfPTable table = new PdfPTable(7); // 3 columns.
        table.setWidthPercentage(100); //Width 100%
        table.setSpacingBefore(10f); //Space before table
        table.setSpacingAfter(10f); //Space after table

        //Set Column widths
        float[] columnWidths = {0.75f, 2f, 2.5f, 1f};
        try {
            table.setWidths(columnWidths);
        } catch (DocumentException ex) {
        }
        /*PdfPCell cell1 = new PdfPCell(new Paragraph("Id"));
        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);*/

        /*PdfPCell cell2 = new PdfPCell(new Paragraph("Type"));
        cell2.setBackgroundColor(BaseColor.GRAY);
        cell2.setPaddingLeft(10);
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

        PdfPCell cell3 = new PdfPCell(new Paragraph("Langue"));
        cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell3.setPaddingLeft(10);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

        PdfPCell cell4 = new PdfPCell(new Paragraph("Date d'obtention"));
        cell4.setBackgroundColor(BaseColor.GRAY);
        cell4.setPaddingLeft(10);
        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        PdfPCell cell5 = new PdfPCell(new Paragraph("User"));
        cell5.setBackgroundColor(BaseColor.GRAY);
        cell5.setPaddingLeft(10);
        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);



        
        //To avoid having the cell border and the content overlap, if you are having thick cell borders
        //cell1.setUserBorderPadding(true);
        //cell2.setUserBorderPadding(true);
        //cell3.setUserBorderPadding(true);

        //table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        table.addCell(cell5);
       


        ats.forEach((Attestation en) -> {
            /*PdfPCell cell11 = new PdfPCell(new Paragraph(String.valueOf(loc.getUser().getId())));
            cell11.setPaddingLeft(10);
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);*/

           /* PdfPCell cell21 = new PdfPCell(new Paragraph(en.getTypeA()));
            cell21.setPaddingLeft(10);
            cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell21.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell31 = new PdfPCell(new Paragraph(en.getLangueA()));
            cell31.setPaddingLeft(10);
            cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell31.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell41 = new PdfPCell(new Paragraph(en.getDateA()));
            cell41.setPaddingLeft(10);
            cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell41.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell51 = new PdfPCell(new Paragraph(en.getUser().getId()));
            cell51.setPaddingLeft(10);
            cell51.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell51.setVerticalAlignment(Element.ALIGN_MIDDLE);

           

            //cell11.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell21.setBackgroundColor(BaseColor.GRAY);
            cell31.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell41.setBackgroundColor(BaseColor.GRAY);
            cell51.setBackgroundColor(BaseColor.LIGHT_GRAY);
          

            //table.addCell(cell11);
            table.addCell(cell21);
            table.addCell(cell31);
            table.addCell(cell41);
            table.addCell(cell51);
          
        });

        try {
            document.add(table);
        } catch (DocumentException ex) {
          
        }*/ 
           Paragraph x=new Paragraph();
           Paragraph p1=new Paragraph("ATTESTATION DE PRÉSENCE");
           Paragraph p2=new Paragraph("Je soussigné(e) (nom et prénom) agissant en qualité de (fonction dans l’organisme de formation) de (raison sociale de l’organisme de formation) atteste que:");
           Paragraph p3=new Paragraph("Madame ou Monsieur (nom et prénom du stagiaire)");
           Paragraph p4=new Paragraph("est inscrit dans notre établissement");
           Paragraph p5=new Paragraph("Ce certificat lui a été délivré à la demande du tuteur intéressé pour valoir ce que de droit");
           String text2="Madame ou Monsieur (nom et prénom du stagiaire):";
           String text3="de (raison sociale de l’entreprise)\n" +"a suivi la formation : ";
           x.add(p1);
           x.add(p2);
           x.add(p3);
           x.add(p4);
           x.add(p5);
           try {
            document.add(x);
        } catch (DocumentException ex) {
          
        }
           


        document.close();
        writer.close();
           /*******************/ 
           /***********************/
           
           String mailingList = "mohammed.guesmi@esprit.tn";
		String subject = "Attestaion";// Sujet du mail
		String content = "Mail pour tester l'envoi";
		String nomSource ="attestation";
 
		String ServeurSNMP = "**********";
		AtesstationadminController.checkMail(ServeurSNMP, temp, mailingList, subject, content, nomSource);
		temp.deleteOnExit();
           
           
        
           Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                         alert1.setContentText("Fichier generé avec succès!");
                           alert1.show();
        
    
  


    }
  
    
    
    public static void checkMail(String ServeurSNMP, File fichierTemp,
			String mailingList, String Subject, String content, String nomSource) {		
		String from = "*********";
 
		Properties props = System.getProperties();
		props.put("mail.smtp.host", ServeurSNMP);
                  Properties prop = new Properties();
        final String moncompteEmail = "wassim.mkadmi@esprit.tn";
        final String psw = "12666957";
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(moncompteEmail, psw);
            }
        });
		//Session session = Session.getDefaultInstance(props, null);
		MimeMessage msg = new MimeMessage(session);
		try {
		msg.setFrom(new InternetAddress(moncompteEmail));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
				mailingList));
		msg.setSubject(Subject);
 
		                  Multipart mp = new MimeMultipart();
		                  MimeBodyPart mbp = new MimeBodyPart();
		mbp.setContent(content, "text/plain");
		mp.addBodyPart(mbp);
 
		                  FileDataSource source = new FileDataSource(fichierTemp);
		mbp.setDataHandler(new DataHandler(source));
		mbp.setFileName(nomSource);
		mp.addBodyPart(mbp);
 
		msg.setContent(mp);
 
		Transport.send(msg);
	} catch (Exception e) {
		System.err.println("L'envoi du mail a échoué : " + e.getMessage());
	}
 
	}
}


