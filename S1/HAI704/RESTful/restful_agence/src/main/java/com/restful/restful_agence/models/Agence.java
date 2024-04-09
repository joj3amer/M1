package com.restful.restful_agence.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Agence {
    @GeneratedValue
    private long id;
    private String nomAgence;
    private List<Hotel> hotels;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNomAgence() {
        return nomAgence;
    }
    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }
    public void setOffers(List<Hotel> hotels) {
        this.hotels = hotels;
    }


    public Agence(String nomAgence, List<Hotel> hotels) {
        this.nomAgence = nomAgence;
        this.hotels = hotels;
    }
    public Agence() {
        this.nomAgence = "agence de base";
        this.hotels = new ArrayList<Hotel>();
    }

    @Override
    public String toString() {
        return "Agence [nomAgence=" + nomAgence + ", hotels=" + hotels + "]";
    }


}