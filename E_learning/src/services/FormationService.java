/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.MyConnexion;
import interfaces.IFormation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modeles.Formation;

/**
 *
 * @author amado
 */
public class FormationService implements IFormation<Formation>{

 private Connection cnx;
//    String title = "SocialPro NOTIFICATION";
 public FormationService()
 {
 cnx =MyConnexion.getInstance().getConnection();
 
 }

    @Override
    public void insert(Formation f) {
        
          
        try {
             String req="insert into formation (id_user,titre,lien_cours,date_debut,date_fin,prix) values(?,?,?,?,?,?)";

             PreparedStatement pst=cnx.prepareStatement(req);
             pst.setInt(1, f.getId_user());
             pst.setString(2, f.getTitre());
             pst.setString(3, f.getLien_cours());
             pst.setDate(4, f.getDate_debut());
             pst.setDate(5, f.getDate_fin());
             pst.setFloat(6, f.getPrix());
           
             pst.executeUpdate();
             System.out.println("L'ajout a été éffectué avcec succes !!! ");
             
         } catch (SQLException ex) {
             Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }

    @Override
    public void update(Formation f) {
String req = "update formation set id_user=? , titre=?, lien_cours=?, date_debut=?, date_fin=?, prix=? where id_ref=? ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
             pst.setInt(1, f.getId_user());
           pst.setString(2, f.getTitre());
             pst.setString(3, f.getLien_cours());
             pst.setDate(4, f.getDate_debut());
             pst.setDate(5, f.getDate_fin());
             pst.setFloat(6, f.getPrix());
      
            pst.setInt(7, f.getId_ref());
                pst.executeUpdate();
                System.out.println("Mise à jour effectuée avec succès Mr");

            

        } catch (SQLException ex) {
           // System.out.println("Exception1SQL IdeeDAO Update");
 Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }     }

    @Override
    public void delete(Integer f) {
      try {
            String req = "delete from formation where id_ref =?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, f);
            ps.executeUpdate();
              System.out.println("votre formation a été supprimé");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }
// ici c juste pour l'afficher sur la console
    @Override
    public List displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ObservableList<Formation> displayWithTableView() {
       ObservableList<Formation> formations =FXCollections.observableArrayList();
        try {
            String req ="select * from formation";
            Statement stm=cnx.createStatement();
            ResultSet resultat= stm.executeQuery(req);
            while(resultat.next()){
                Formation MyFormation=new Formation();
                MyFormation.setId_ref(resultat.getInt(1));
                MyFormation.setId_user(resultat.getInt(2));
                MyFormation.setTitre(resultat.getString(3));
                MyFormation.setLien_cours(resultat.getString(4));
                MyFormation.setDate_debut(resultat.getDate(5));
                MyFormation.setDate_fin(resultat.getDate(6));
                MyFormation.setPrix(resultat.getFloat(7));
              
                
                formations.add(MyFormation);
            }
             } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return  formations;
       
    }

   
    
     public ObservableList<Formation>  searchFormation(String id) {
         ObservableList<Formation> serviceFormationList =FXCollections.observableArrayList() ;      
            String req="SELECT * FROM formation where id_ref LIKE '%"+id+"%' or titre LIKE '%"+id+"%'" ;
            
            try {
            Statement stm=cnx.createStatement();
              ResultSet resultat= stm.executeQuery(req);
                while(resultat.next()){
                    Formation MyFormation= new Formation();
            MyFormation.setId_ref(resultat.getInt(1));
            MyFormation.setId_user(resultat.getInt(2));
                MyFormation.setTitre(resultat.getString(3));
                MyFormation.setLien_cours(resultat.getString(4));
                MyFormation.setDate_debut(resultat.getDate(5));
                MyFormation.setDate_fin(resultat.getDate(6));
                MyFormation.setPrix(resultat.getFloat(7));
                
                serviceFormationList.add(MyFormation);
                }
                //ServiceEventList.forEach(System.out::println);
               
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
 return  serviceFormationList;
    }

    @Override
    public Formation findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
