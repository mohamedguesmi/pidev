/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Attestation;
import Entities.Reclamation;
import Entities.Service;
import Entities.User;
import Util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ReclamationService {
     private final Connection connexion;
    private Statement ste;

       
       public ReclamationService() {
       connexion=DataBase.getInstance().getConnexion();
    }
       public List<Reclamation> readAll() throws SQLException {
        List<Reclamation> arr = new ArrayList<>();
        ste = connexion.createStatement();
        ResultSet rs = ste.executeQuery("select * from Reclamation");
        while (rs.next()) {
            int id = rs.getInt(1);
            String nomR= rs.getString("nomR");
            String sujetR = rs.getString("sujetR");
            String dateR=rs.getString("dateR");
            Reclamation r = new Reclamation(id,nomR,sujetR, dateR);
            arr.add(r);
        }
        return arr;
    }
        public List<Reclamation> readNameAndDate() throws SQLException {
        List<Reclamation> arr = new ArrayList<>();
        ste = connexion.createStatement();
        ResultSet rs = ste.executeQuery("select nomR, dateR from reclamation");
        while (rs.next()) {
            String typeA= rs.getString("nomR");
            String dateA = rs.getString("dateR");
            Reclamation s = new Reclamation(typeA, dateA);
            arr.add(s);
        }
        return arr;
    }
        public void ajouterReclamation(Reclamation r) throws SQLException {

        String req = "INSERT INTO `Reclamation` (`nomR`, `sujetR`, `dateR`) VALUES ( ?, ?, ?) ";
        PreparedStatement pstm = connexion.prepareStatement(req);
        pstm.setString(1, r.getNomR());
        pstm.setString(3, r.getSujetR());
        pstm.setString(2, r.getDateR());
        pstm.executeUpdate();
    }
         public boolean updateReclamation(Reclamation a) throws SQLException {
        String sql = "UPDATE reclamation SET nomR=?, sujetR=?, dateR=? WHERE idReclamation=?";

        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(1, a.getNomR());
        statement.setString(2, a.getSujetR());
        statement.setString(3, a.getDateR());
        statement.setInt(4, a.getIdReclamation());
       
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing product was updated successfully!");
        }
        return true;
    }
         
       public boolean deleteReclamation(Reclamation a) throws SQLException {
        PreparedStatement pre = connexion.prepareStatement("DELETE FROM Reclamation where idReclamation=?");
        pre.setInt(1, a.getIdReclamation());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A reclamation was deleted successfully!");
        }
        return true;
    }

   
/*********************************************partie admin*************************************/
       public List<Reclamation> readAllforadmin() throws SQLException {
        List<Reclamation> arr = new ArrayList<>();
        ste = connexion.createStatement();
        ste = connexion.createStatement();
        ResultSet rs = ste.executeQuery("select * from Reclamation");
        while (rs.next()) {
            int id = rs.getInt(1);
            String nomR= rs.getString("nomR");
            String sujetR = rs.getString("sujetR");
            String dateR=rs.getString("dateR");
            
            
            int user=rs.getInt("user");
            Reclamation r = new Reclamation(id,nomR,sujetR, dateR,getUserById(user));
            System.out.println("dans reclamation service");
            
            arr.add(r);
        }
        return arr;
    }
       public User getUserById(int id){
        
         User Usr=new User();
        String rqt="SELECT `id` WHERE `id`="+id;
        
        try {
            PreparedStatement ps=connexion.prepareStatement(rqt);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
               
               
        Usr=new User(id);
                              
                
                
                
            }
         } catch (SQLException ex) {
            ex.getMessage();
        }
       return Usr;
}
        public List<Reclamation> readAlls() throws SQLException {
        List<Reclamation> arr = new ArrayList<>();
        ste = connexion.createStatement();
        ResultSet rs = ste.executeQuery("select * from Reclamation");
        while (rs.next()) {
            int id = rs.getInt(1);
            String nomR= rs.getString("nomR");
            String sujetR = rs.getString("sujetR");
            String dateR=rs.getString("dateR");
            int user=rs.getInt("user");
            User u=new User(user);
            Reclamation r = new Reclamation(id,nomR,sujetR, dateR,u);
            arr.add(r);
        }
        return arr;
    }
        
public ArrayList<Reclamation> Rechercher(String name) throws SQLException {
            
        ArrayList<Reclamation> arr = new ArrayList<>();
        //ste = connexion.createStatement();
        
        String rq = "SELECT * FROM `reclamation` WHERE `nomR`=?";
        PreparedStatement pst = connexion.prepareStatement(rq);
         pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String nomR= rs.getString("nomR");
            String sujetR = rs.getString("sujetR");
            String dateR=rs.getString("dateR");
            int user=rs.getInt("user");
            User u=new User(user);
            Reclamation s = new Reclamation(id,nomR,sujetR, dateR,u);
            arr.add(s);
        }
        return arr;
    } 
}


