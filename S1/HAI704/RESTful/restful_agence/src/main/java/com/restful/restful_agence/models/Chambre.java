package com.restful.restful_agence.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Chambre{

    @Id
    private int id;
    public int getNumero() {
        return 0;
    }

    public boolean estDisponible(String debutS, String finS) {
        return false;
    }

    public void addReservation(Reservation reservationClient) {
    }

    public List<Reservation> getDisponibilite() {
        return null;
    }

    public int getLits() {
        return 0;
    }
}
