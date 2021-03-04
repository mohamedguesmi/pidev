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

    public Cours() {
    }

    public Cours(int id, String nom, String nom_ens, int nb_heure) {
        this.id = id;
        this.nom = nom;
        this.nom_ens = nom_ens;
        this.nb_heure = nb_heure;
    }

    public Cours(String nom, String nom_ens, int nb_heure) {
        this.nom = nom;
        this.nom_ens = nom_ens;
        this.nb_heure = nb_heure;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.nom);
        hash = 79 * hash + Objects.hashCode(this.nom_ens);
        hash = 79 * hash + this.nb_heure;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cours other = (Cours) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.nb_heure != other.nb_heure) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.nom_ens, other.nom_ens)) {
            return false;
        }
        return true;
    }
    
    
    
}
