/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncours.Service;

import gestioncours.Entities.Examen;
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
public class ExamenService {
    private final Connection connexion;
    private Statement ste;

       
       public ExamenService() {
       connexion=DataBase.getInstance().getConnexion();
    }
       public void ajouterExamen(Examen e) throws SQLException {
        String req = "INSERT INTO `examen` (`duree`, `cours`, `dateE`) VALUES ( ?, ?, ?) ";
        PreparedStatement pstm = connexion.prepareStatement(req);
        pstm.setInt(1, e.getDuree());
        pstm.setString(2, e.getCours());
        pstm.setString(3, e.getDateE());
        pstm.executeUpdate();
    }
       List<Examen> getAllExamen() throws SQLException {
        List<Examen> examen = new ArrayList<>();
        String req = "select * from examen";
        Statement stm = connexion.createStatement();
        ResultSet result =  stm.executeQuery(req);    
        while(result.next()){
            Examen e = new Examen(result.getInt("duree"),result.getString("cours"),result.getString("dateE"));
            examen.add(e);
        }
        
        return examen;
    }
    
    public boolean updateExamen(Examen e) throws SQLException {
        String sql = "UPDATE examen SET duree=?, cours=?, dateE=?  WHERE id=?";

        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setInt(1, e.getDuree());
        statement.setString(2, e.getCours());
        statement.setInt(3, e.getId());
        System.out.println(e.getId());
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing product was updated successfully!");
        }
        return true;
    }
    public boolean deleteExamen(Examen e) throws SQLException {
        PreparedStatement pre = connexion.prepareStatement("DELETE FROM examen where id =?");
        pre.setInt(1, e.getId());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A Child was deleted successfully!");
        }
        return true;
    }
    public List<Examen> readAll() throws SQLException {
        List<Examen> arr = new ArrayList<>();
        ste = connexion.createStatement();
        ResultSet rs = ste.executeQuery("select * from examen");
        while (rs.next()) {
            int id = rs.getInt(1);
            int duree = rs.getInt("duree");
            String cours = rs.getString("cours");
            String dateE= rs.getString("dateE");
            Examen e = new Examen(id, duree, cours,dateE);
            arr.add(e);
        }
        return arr;
    }
    
    
}
