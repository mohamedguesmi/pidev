/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncours.Service;

import gestioncours.Entities.Cours;
import gestioncours.Util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moham
 */
public class CoursService {
    private final Connection connexion;
    private Statement ste;

       
       public CoursService() {
       connexion=DataBase.getInstance().getConnexion();
    }
       public void ajouterCours(Cours c) throws SQLException {
        String req = "INSERT INTO `cours` (`nom`, `nom_ens`, `nb_heure`, `image`) VALUES ( ?, ?, ?,?) ";
        PreparedStatement pstm = connexion.prepareStatement(req);
        pstm.setString(1, c.getNom());
        pstm.setString(2, c.getNom_ens());
        pstm.setInt(3, c.getNb_heure());
                pstm.setString(4, c.getImage());

        pstm.executeUpdate();
    }
       List<Cours> getAllCours() throws SQLException {
        List<Cours> cours = new ArrayList<>();
        String req = "select * from cours";
        Statement stm = connexion.createStatement();
        ResultSet result =  stm.executeQuery(req);    
        while(result.next()){
            Cours c = new Cours(result.getString("nom"), result.getString("nom_ens"),result.getInt("nb_heure"),result.getString("image"));
            cours.add(c);
        }
        
        return cours;
    }
    
    public boolean updateCours(Cours c) throws SQLException {
        String sql = "UPDATE cours SET nom=?, nom_ens=?, nb_heure=?,image=? WHERE id=?";

        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(1, c.getNom());
        statement.setString(2, c.getNom_ens());
        statement.setInt(3, c.getNb_heure());
                statement.setString(4, c.getImage());

        statement.setInt(5, c.getId());
        System.out.println(c.getId());
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing product was updated successfully!");
        }
        return true;
    }
    public boolean deleteClasse(Cours c) throws SQLException {
        PreparedStatement pre = connexion.prepareStatement("DELETE FROM cours where id =?");
        pre.setInt(1, c.getId());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A Child was deleted successfully!");
        }
        return true;
    }
    public List<Cours> readAll() throws SQLException {
        List<Cours> arr = new ArrayList<>();
        ste = connexion.createStatement();
        ResultSet rs = ste.executeQuery("select * from cours");
        while (rs.next()) {
            int id = rs.getInt(1);
            String nom = rs.getString("nom");
            String nom_ens = rs.getString("nom_ens");
            int nb_heure = rs.getInt("nb_heure");
                        String image = rs.getString("image");

            Cours c = new Cours(id, nom, nom_ens, nb_heure,image);
            arr.add(c);
        }
        return arr;
    }
    
    public List<String> GetEmails() throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = connexion.createStatement();
        ResultSet rs = ste.executeQuery("select email from user WHERE role = 'User' ");
        while (rs.next()) {
            
            String email = rs.getString("email");
           
            arr.add(email);
        }
        return arr;
    }
    
}
