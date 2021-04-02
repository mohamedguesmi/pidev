/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.MyConnexion;
import interfaces.IOffre;
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
import modeles.Offre;

/**
 *
 * @author amado
 */
public class OffreService implements IOffre<Offre>{

     private Connection cnx;

    public OffreService() {
        this.cnx = MyConnexion.getInstance().getConnection();
    }
     
     

    @Override
    public void insert(Offre o) {
 try {
             String req="insert into offre (id_formation,prix,date_delai) values(?,?,?)";

             PreparedStatement pst=cnx.prepareStatement(req);
             pst.setInt(1, o.getId_formation());
             pst.setFloat(2, o.getPrix());
             pst.setDate(3, o.getDate_delai());
           
           
             pst.executeUpdate();
             System.out.println("L'ajout a été éffectué avcec succes !!! ");
             
         } catch (SQLException ex) {
             Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
         }
        

    }

    @Override
    public void update(Offre o) {
        
        String req = "update offre set id_formation=? , prix=?, date_delai=? where code=? ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
             pst.setInt(1, o.getId_formation());
           pst.setFloat(2, o.getPrix());
             pst.setDate(3, o.getDate_delai());

      
            pst.setInt(4, o.getCode());
                pst.executeUpdate();
                System.out.println("Mise à jour effectuée avec succès Mr");

            

        } catch (SQLException ex) {
           // System.out.println("Exception1SQL IdeeDAO Update");
 Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void delete(Integer o) {
        
         try {
            String req = "delete from offre where code =?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, o);
            ps.executeUpdate();
              System.out.println("votre offre a été supprimé");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    @Override
    public List<Offre> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Offre findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public ObservableList<Offre> displayWithTableView() {
       ObservableList<Offre> offres =FXCollections.observableArrayList();
        try {
            String req ="select * from offre";
            Statement stm=cnx.createStatement();
            ResultSet resultat= stm.executeQuery(req);
            while(resultat.next()){
                Offre MyOffre=new Offre();
                MyOffre.setCode(resultat.getInt(1));
                MyOffre.setId_formation(resultat.getInt(2));
                MyOffre.setPrix(resultat.getFloat(3));
                MyOffre.setDate_delai(resultat.getDate(4));
               
              
                
                offres.add(MyOffre);
            }
             } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return  offres;
       
    }
    
    public ObservableList<Offre>  searchOffre(String id) {
         ObservableList<Offre> serviceOffreList =FXCollections.observableArrayList() ;      
            String req="SELECT * FROM offre where code LIKE '%"+id+"%' or id_formation LIKE '%"+id+"%' or prix LIKE '%"+id+"%' or date_delai LIKE '%"+id+"%'" ;
            
            try {
            Statement stm=cnx.createStatement();
              ResultSet resultat= stm.executeQuery(req);
                while(resultat.next()){
                    Offre MyOffre= new Offre();
            MyOffre.setCode(resultat.getInt(1));
                MyOffre.setId_formation(resultat.getInt(2));
                MyOffre.setPrix(resultat.getFloat(3));
                MyOffre.setDate_delai(resultat.getDate(4));
               
                
                serviceOffreList.add(MyOffre);
                }
                //ServiceEventList.forEach(System.out::println);
               
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
 return  serviceOffreList;
    }
}
