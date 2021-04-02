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
public class Formation {
    private int id_ref,id_user;
    private String titre,lien_cours;
    private Date date_debut,date_fin;
    private float prix;

    public Formation() {
    }

    public Formation(int id_ref) {
        this.id_ref = id_ref;
    }

    public Formation(String titre) {
        this.titre = titre;
    }
    
    

    
    public Formation(int id_ref, int id_user, String titre,String lien_cours, Date date_debut, Date date_fin,float prix) {
        this.id_ref = id_ref;
        this.id_user = id_user;
        this.titre = titre;
        this.lien_cours = lien_cours;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prix = prix;
    }

    public Formation(int id_user, String titre,String lien_cours, Date date_debut, Date date_fin,float prix) {
        this.id_user = id_user;
        this.titre = titre;
        this.lien_cours = lien_cours;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prix = prix;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getId_ref() {
        return id_ref;
    }

    public void setId_ref(int id_ref) {
        this.id_ref = id_ref;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getLien_cours() {
        return lien_cours;
    }

    public void setLien_cours(String lien_cours) {
        this.lien_cours = lien_cours;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

  

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Formation{" + "id_ref=" + id_ref + ", id_user=" + id_user + ", titre=" + titre + ", lien_cours=" + lien_cours + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", prix=" + prix + '}';
    }

  
    
}
