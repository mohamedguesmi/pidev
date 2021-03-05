/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Reclamation {
    private int idReclamation;
    private String nomR;
    private String sujetR;
    private String dateR;
    private User user;

    public Reclamation(int idReclamation, String nomR, String sujetR, String dateR) {
        this.idReclamation = idReclamation;
        this.nomR = nomR;
        this.sujetR = sujetR;
        this.dateR = dateR;
    }

    public Reclamation(String nomR, String sujetR, String dateR) {
        this.nomR = nomR;
        this.sujetR = sujetR;
        this.dateR = dateR;
    }

    public Reclamation(String nomR, String dateR) {
        this.nomR = nomR;
        this.dateR = dateR;
    }

    public Reclamation() {
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getNomR() {
        return nomR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    public String getSujetR() {
        return sujetR;
    }

    public void setSujetR(String sujetR) {
        this.sujetR = sujetR;
    }

    public String getDateR() {
        return dateR;
    }

    public void setDateR(String dateR) {
        this.dateR = dateR;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idReclamation;
        hash = 89 * hash + Objects.hashCode(this.nomR);
        hash = 89 * hash + Objects.hashCode(this.sujetR);
        hash = 89 * hash + Objects.hashCode(this.dateR);
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
        final Reclamation other = (Reclamation) obj;
        if (this.idReclamation != other.idReclamation) {
            return false;
        }
        if (!Objects.equals(this.nomR, other.nomR)) {
            return false;
        }
        if (!Objects.equals(this.sujetR, other.sujetR)) {
            return false;
        }
        if (!Objects.equals(this.dateR, other.dateR)) {
            return false;
        }
        return true;
    }

    public Reclamation(int idReclamation, String nomR, String sujetR, String dateR, User user) {
        this.idReclamation = idReclamation;
        this.nomR = nomR;
        this.sujetR = sujetR;
        this.dateR = dateR;
        this.user = user;
    }

    public Reclamation(String nomR, String sujetR, String dateR, User user) {
        this.nomR = nomR;
        this.sujetR = sujetR;
        this.dateR = dateR;
        this.user = user;
    }
    
    
    
}
