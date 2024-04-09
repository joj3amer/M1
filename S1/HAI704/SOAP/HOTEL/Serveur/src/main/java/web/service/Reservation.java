package web.service;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.Date;

public class Reservation {
	private Client client;
    private Hotel hotel;
    private String dateArrivee;
    private String dateDepart;
    private Chambre chambreReservee;

	public Reservation(){
		this.client = new Client();
		this.hotel = new Hotel();
		this.dateArrivee = "1999-01-01";
		this.dateDepart = "1999-01-01";
		this.chambreReservee = new Chambre();
	}
    public Reservation(Client client, Hotel hotel, String dateArrivee, String dateDepart, Chambre chambreReservee) {
        this.client = client;
        this.hotel = hotel;
        this.dateArrivee = dateArrivee;
        this.dateDepart = dateDepart;
        this.chambreReservee = chambreReservee;
    }

	@XmlElement
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@XmlElement
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@XmlElement
	public String getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(String dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	@XmlElement
	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	@XmlElement
	public Chambre getChambreReservee() {
		return chambreReservee;
	}

	public void setChambreReservee(Chambre chambreReservee) {
		this.chambreReservee = chambreReservee;
	}
}