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
public class Service {
    private int idS;
    private String nomS;
    private String langueA;
    private String dateS;

    public int getIdS() {
        return idS;
    }

    public Service(String langueA) {
        this.langueA = langueA;
    }

    public Service(String nomS, String langueA, String dateS) {
        this.nomS = nomS;
        this.langueA = langueA;
        this.dateS = dateS;
    }

    public Service(int idS, String nomS, String langueA, String dateS) {
        this.idS = idS;
        this.nomS = nomS;
        this.langueA = langueA;
        this.dateS = dateS;
    }
    

    public String getLangueA() {
        return langueA;
    }

    public void setLangueA(String langueA) {
        this.langueA = langueA;
    }
    

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public String getNomS() {
        return nomS;
    }

    public void setNomS(String nomS) {
        this.nomS = nomS;
    }



    public Service() {
    }

    public Service(int idS, String nomS, String dateS) {
        this.idS = idS;
        this.nomS = nomS;
        this.dateS = dateS;
    }

    public Service(String nomS, String dateS) {
        this.nomS = nomS;
        this.dateS = dateS;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idS;
        hash = 67 * hash + Objects.hashCode(this.nomS);
        hash = 67 * hash + Objects.hashCode(this.dateS);
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
        final Service other = (Service) obj;
        if (this.idS != other.idS) {
            return false;
        }
        if (!Objects.equals(this.nomS, other.nomS)) {
            return false;
        }
        if (!Objects.equals(this.dateS, other.dateS)) {
            return false;
        }
        return true;
    }
    
    
    
}
