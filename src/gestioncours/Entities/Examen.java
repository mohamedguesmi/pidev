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
public class Examen {
    private int id;
    private int duree;
    private String cours;
    private String dateE;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + this.duree;
        hash = 67 * hash + Objects.hashCode(this.cours);
        hash = 67 * hash + Objects.hashCode(this.dateE);
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
        final Examen other = (Examen) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.duree != other.duree) {
            return false;
        }
        if (!Objects.equals(this.cours, other.cours)) {
            return false;
        }
        if (!Objects.equals(this.dateE, other.dateE)) {
            return false;
        }
        return true;
    }
     

    

    public Examen(int id, int duree, String cours) {
        this.id = id;
        this.duree = duree;
        this.cours = cours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getCours() {
        return cours;
    }

    public void setCours(String cours) {
        this.cours = cours;
    }

    public Examen(int duree, String dateE) {
        this.duree = duree;
        this.dateE = dateE;
    }
    

    public Examen() {
    }

    public String getDateE() {
        return dateE;
    }

    public void setDateE(String dateE) {
        this.dateE = dateE;
    }

    public Examen(int id, int duree, String cours, String dateE) {
        this.id = id;
        this.duree = duree;
        this.cours = cours;
        this.dateE = dateE;
    }

    public Examen(int duree, String cours, String dateE) {
        this.duree = duree;
        this.cours = cours;
        this.dateE = dateE;
    }
    
    
}
