/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Attestation {
    private User user;

    
    private int id;
    private String typeA;
    private String langueA;
    private String dateA;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeA() {
        return typeA;
    }

    public String getDateA() {
        return dateA;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDateA(String dateA) {
        this.dateA = dateA;
    }

    public Attestation(String typeA, String langueA, String dateA) {
        this.typeA = typeA;
        this.langueA = langueA;
        this.dateA = dateA;
    }

    public void setTypeA(String typeA) {
        this.typeA = typeA;
    }

    public String getLangueA() {
        return langueA;
    }

    public void setLangueA(String langueA) {
        this.langueA = langueA;
    }

    public Attestation() {
    }

    public Attestation(String typeA, String dateA) {
        this.typeA = typeA;
        this.dateA = dateA;
    }
    

    public Attestation(int id, String typeA, String langueA) {
        this.id = id;
        this.typeA = typeA;
        this.langueA = langueA;
    }

    public Attestation(int id, String typeA, String langueA, String dateA) {
        this.id = id;
        this.typeA = typeA;
        this.langueA = langueA;
        this.dateA = dateA;
    }

    

    public Attestation(String langueA) {
        this.langueA = langueA;
    }

    public Attestation(User user, int id, String typeA, String langueA, String dateA) {
        this.user = user;
        this.id = id;
        this.typeA = typeA;
        this.langueA = langueA;
        this.dateA = dateA;
    }

    public Attestation(User user, String typeA, String langueA, String dateA) {
        this.user = user;
        this.typeA = typeA;
        this.langueA = langueA;
        this.dateA = dateA;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.typeA);
        hash = 97 * hash + Objects.hashCode(this.langueA);
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
        final Attestation other = (Attestation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.typeA, other.typeA)) {
            return false;
        }
        if (!Objects.equals(this.langueA, other.langueA)) {
            return false;
        }
        return true;
    }
    
}
