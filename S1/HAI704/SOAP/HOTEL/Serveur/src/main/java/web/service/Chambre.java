package web.service;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@XmlRootElement
public class Chambre {
	
	private int numero;
    private int lits;
    private ArrayList<Reservation> date_occupation = new ArrayList<Reservation>();
    private double prix;

	public Chambre(){
		this.numero = 0;
		this.lits = 0;
		this.prix = 0;
	}
    public Chambre(int numero, int lits, double prixNuit) {
        this.numero = numero;
        this.lits = lits;
        this.prix = prixNuit;
    }

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero){
		this.numero = numero;
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

	public ArrayList<Reservation> getDisponibilite(){
		return date_occupation;
	}

	public void setDateOccupation(ArrayList<LocalDate> disponibilite) {
		this.date_occupation = date_occupation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString(){
		return "__\n" +
				"Chambre numéro : "+ this.numero+"\n"+
				"Nombre lits : "+this.lits+"\n"+
				"Prix à la nuit : "+this.prix+"\n__";
	}

	public void addReservation(Reservation reservation) {
		if(this.estDisponible(reservation.getDateDepart(),reservation.getDateArrivee())){
			this.date_occupation.add(reservation);
		}else{
			System.out.println("Reservation impossible sur cette plage horaire.");
		}
	}
	
}
