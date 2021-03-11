/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncours.Entities;

import java.util.Objects;

/**
 *
 * @author moham
 */
public class Cours {
    private int id;
    private String nom;
    private String nom_ens ;
    private int nb_heure;
    private String image;

    public Cours() {
    }

    public Cours(int id, String nom, String nom_ens, int nb_heure, String image) {
        this.id = id;
        this.nom = nom;
        this.nom_ens = nom_ens;
        this.nb_heure = nb_heure;
        this.image = image;
    }

    public Cours(String nom, String nom_ens, int nb_heure, String image) {
        this.nom = nom;
        this.nom_ens = nom_ens;
        this.nb_heure = nb_heure;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom_ens() {
        return nom_ens;
    }

    public void setNom_ens(String nom_ens) {
        this.nom_ens = nom_ens;
    }

    public int getNb_heure() {
        return nb_heure;
    }

    public void setNb_heure(int nb_heure) {
        this.nb_heure = nb_heure;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Cours{" + "id=" + id + ", nom=" + nom + ", nom_ens=" + nom_ens + ", nb_heure=" + nb_heure + ", image=" + image + '}';
    }
    

   
    
    
}
