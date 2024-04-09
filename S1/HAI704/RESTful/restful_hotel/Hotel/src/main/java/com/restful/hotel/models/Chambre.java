package com.restful.hotel.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Chambre")
public class Chambre {

	@Id
	@GeneratedValue
	@Column(name ="id")
	private Long numero;
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
    private int lits;

	@OneToMany(mappedBy="chambreReservee", cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    private List<Reservation> date_occupation;
    private double prix;

	public Chambre(){
		this.numero = 0L;
		this.lits = 0;
		this.prix = 0;
	}
    public Chambre(int numero, int lits, double prixNuit) {
        this.numero = (long) numero;
        this.lits = lits;
        this.prix = prixNuit;
    }

	public int getLits(){
		return lits;
	}

	public void setLits(int lits){
		this.lits = lits;
	}

	public boolean estDisponible(String debutS, String finS){

		LocalDate debut = LocalDate.parse(debutS);
		LocalDate fin = LocalDate.parse(finS);
		for(Reservation reservation : date_occupation){
			LocalDate date_arrive = LocalDate.parse(reservation.getDateArrivee());
			LocalDate date_depart = LocalDate.parse(reservation.getDateDepart());

			if((date_arrive.isBefore(fin) && date_arrive.isAfter(debut)) || date_depart.isBefore(fin) && date_depart.isAfter(debut) || (date_arrive.isBefore(debut) && date_depart.isAfter(fin))){
				return false;
			}
		}
		return true;

	}

	public List<Reservation> getDisponibilite(){
		return date_occupation;
	}

	public void setDateOccupation(List<LocalDate> disponibilite) {
		this.date_occupation = date_occupation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public void addReservation(Reservation reservation) {
		if(this.estDisponible(reservation.getDateDepart(),reservation.getDateArrivee())){
			this.date_occupation.add(reservation);
		}else{
			System.out.println("Reservation impossible sur cette plage horaire.");
		}
	}

	@Override
	public String toString() {
		return "Chambre{" +
				"numero=" + numero +
				", lits=" + lits +
				", date_occupation=" + date_occupation +
				", prix=" + prix +
				'}';
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Long getNumero() {
		return numero;
	}
}
