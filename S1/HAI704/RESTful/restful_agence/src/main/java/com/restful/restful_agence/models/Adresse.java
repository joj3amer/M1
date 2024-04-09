package com.restful.restful_agence.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Adresse {

    @Id
    private int id;
    private String pays;
    private String ville;
    private String rue;
    private int num_rue;
    private int lattitude;
    private int longitude;

    public Adresse(){}

    public Adresse(int id, String pays, String ville, String rue, int num_rue, int lattitude, int longitude) {
        this.id = id;
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.num_rue = num_rue;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNum_rue() {
        return num_rue;
    }

    public void setNum_rue(int num_rue) {
        this.num_rue = num_rue;
    }

    public int getLattitude() {
        return lattitude;
    }

    public void setLattitude(int lattitude) {
        this.lattitude = lattitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
