/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import java.sql.Date;

/**
 *
 * @author amado
 */
public class Offre {
    private int code,id_formation;
    private float  prix;
    private Date date_delai;
    

    public Offre() {
    }

    public Offre(int code, int id_formation, float prix, Date date_delai) {
        this.code = code;
        this.id_formation = id_formation;
        this.prix = prix;
        this.date_delai = date_delai;
    }

    public Offre(int id_formation, float prix, Date date_delai) {
        this.id_formation = id_formation;
        this.prix = prix;
        this.date_delai = date_delai;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDate_delai() {
        return date_delai;
    }

    public void setDate_delai(Date date_delai) {
        this.date_delai = date_delai;
    }

    @Override
    public String toString() {
        return "Offre{" + "code=" + code + ", id_formation=" + id_formation + ", prix=" + prix + ", date_delai=" + date_delai + '}';
    }
    
    
    
}
