/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Attestation;
import Entities.Service;
import Util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServiceService {
     private final Connection connexion;
    private Statement ste;

       
       public ServiceService() {
       connexion=DataBase.getInstance().getConnexion();
    }
       
    public List<Service> readAll() throws SQLException {
        List<Service> arr = new ArrayList<>();
        ste = connexion.createStatement();
        ResultSet rs = ste.executeQuery("select * from service");
        while (rs.next()) {
            int id = rs.getInt(1);
            String nomS = rs.getString("nomS");
            String langueA = rs.getString("langueA");
            String dateS = rs.getString("dateS");
            Service s = new Service(id, nomS, langueA, dateS);
            arr.add(s);
        }
        return arr;
    }
    public boolean deleteService(Service s) throws SQLException {
        PreparedStatement pre = connexion.prepareStatement("DELETE FROM service where id =?");
        pre.setInt(1, s.getIdS());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A Child was deleted successfully!");
        }
        return true;
    }
    public boolean deleteServiceAttestation(Attestation a) throws SQLException {
        PreparedStatement pre = connexion.prepareStatement("DELETE FROM attestation where id =?");
        pre.setInt(1, a.getId());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A Child was deleted successfully!");
        }
        return true;
    }
    
       
    
}
