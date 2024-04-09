package com.restful.hotel.models;

import jakarta.persistence.*;

@Entity
public class Reservation {

	@Id
	private Long numeroReservation;
	@ManyToOne
	private Client client;
	@ManyToOne
    private Hotel hotel;
    private String dateArrivee;
    private String dateDepart;

	@ManyToOne
	@JoinColumn(name="chambre_id")
    private Chambre chambreReservee;

	/*public Reservation(){
		this.client = new Client();
		this.hotel = new Hotel();
		this.dateArrivee = "1999-01-01";
		this.dateDepart = "1999-01-01";
		this.chambreReservee = new Chambre();
	}*/
    public Reservation(Client client, Hotel hotel, String dateArrivee, String dateDepart, Chambre chambreReservee) {
        this.client = client;
        this.hotel = hotel;
        this.dateArrivee = dateArrivee;
        this.dateDepart = dateDepart;
        this.chambreReservee = chambreReservee;
    }

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public String getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(String dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Chambre getChambreReservee() {
		return chambreReservee;
	}

	public void setChambreReservee(Chambre chambreReservee) {
		this.chambreReservee = chambreReservee;
	}

	public void setNumeroReservation(Long numeroReservation) {
		this.numeroReservation = numeroReservation;
	}

	public Long getNumeroReservation() {
		return numeroReservation;
	}
}