
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Attestation;
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
public class AttestationService {
     private final Connection connexion;
    private Statement ste;

       
       public AttestationService() {
       connexion=DataBase.getInstance().getConnexion();
    }
       public List<Attestation> readAll() throws SQLException {
        List<Attestation> arr = new ArrayList<>();
        ste = connexion.createStatement();
        ResultSet rs = ste.executeQuery("select * from attestation");
        while (rs.next()) {
            int id = rs.getInt(1);
            String typeA= rs.getString("typeA");
            String langueA = rs.getString("langueA");
            String dateA=rs.getString("dateA");
            Attestation s = new Attestation(id,typeA,langueA, dateA);
            arr.add(s);
        }
        return arr;
    }
        public void ajouterAttestation(Attestation a) throws SQLException {

        String req = "INSERT INTO `attestation` (`typeA`, `langueA`, `dateA`) VALUES ( ?, ?, ?) ";
        PreparedStatement pstm = connexion.prepareStatement(req);
        pstm.setString(1, a.getTypeA());
        pstm.setString(2, a.getLangueA());
        pstm.setString(3, a.getDateA());
        pstm.executeUpdate();
            ajouterService(a.getLangueA(), a.getDateA());
    }
        public void ajouterService(String langue,String date) throws SQLException {

        String req = "INSERT INTO `service` (`nomS`, `langueA`, `dateS`) VALUES ( ?, ?, ?) ";
        PreparedStatement pstm = connexion.prepareStatement(req);
        pstm.setString(1, "attestation");
        pstm.setString(2, langue);
        pstm.setString(3, date);
        pstm.executeUpdate();
    }
         public boolean updateAttestation(Attestation a) throws SQLException {
        String sql = "UPDATE attestation SET typeA=?, dateA=?, langueA=? WHERE id=?";

        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(1, a.getTypeA());
        statement.setString(2, a.getDateA());
        statement.setString(3, a.getLangueA());
        statement.setInt(4, a.getId());
       
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing product was updated successfully!");
        }
        return true;
    }
         
       public boolean deleteAttestation(Attestation a) throws SQLException {
        PreparedStatement pre = connexion.prepareStatement("DELETE FROM attestation where id=?");
        pre.setInt(1, a.getId());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A Child was deleted successfully!");
        }
        return true;
    }

       public List<Attestation> readNameAndDate() throws SQLException {
        List<Attestation> arr = new ArrayList<>();
        ste = connexion.createStatement();
        ResultSet rs = ste.executeQuery("select typeA, dateA from attestation");
        while (rs.next()) {
            String typeA= rs.getString("typeA");
            String dateA = rs.getString("dateA");
            Attestation s = new Attestation(typeA, dateA);
            arr.add(s);
        }
        return arr;
    }
/*********************************************partie admin*************************************/
       public List<Attestation> readAllforadmin() throws SQLException {
        List<Attestation> arr = new ArrayList<>();
        ste = connexion.createStatement();
        ResultSet rs = ste.executeQuery("select * from attestation");
        while (rs.next()) {
            int id = rs.getInt(1);
            String typeA= rs.getString("typeA");
            String langueA = rs.getString("langueA");
            String dateA=rs.getString("dateA");
            int user=rs.getInt("user");
            Attestation s = new Attestation(getUserById(user),id,typeA,langueA, dateA);
            arr.add(s);
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
        public List<Attestation> readAlls() throws SQLException {
        List<Attestation> arr = new ArrayList<>();
        ste = connexion.createStatement();
        ResultSet rs = ste.executeQuery("select * from attestation");
        while (rs.next()) {
            int id = rs.getInt(1);
            String typeA= rs.getString("typeA");
            String langueA = rs.getString("langueA");
            String dateA=rs.getString("dateA");
            int user=rs.getInt("user");
            User u=new User(user);
            Attestation s = new Attestation(u,id,typeA,langueA, dateA);
            arr.add(s);
        }
        return arr;
    }
        
        
        public ArrayList<Attestation> Rechercher(String name) throws SQLException {
            
        ArrayList<Attestation> arr = new ArrayList<>();
        //ste = connexion.createStatement();
        
        String rq = "SELECT * FROM `attestation` WHERE `typeA`=?";
        PreparedStatement pst = connexion.prepareStatement(rq);
         pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String typeA= rs.getString("typeA");
            String langueA = rs.getString("langueA");
            String dateA=rs.getString("dateA");
            int user=rs.getInt("user");
            User u=new User(user);
            Attestation s = new Attestation(u,id,typeA,langueA, dateA);
            arr.add(s);
        }
        return arr;
    } 

}
