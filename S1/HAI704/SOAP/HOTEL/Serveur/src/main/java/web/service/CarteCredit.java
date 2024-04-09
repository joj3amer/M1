package web.service;

import java.time.LocalDate;

public class CarteCredit {
	
	private String nom;
	private String prenom;
	private String numero;
	private String dateExp;
	private int cvc;

	public CarteCredit(){
		this.nom = "nom";
		this.prenom = "prenom";
		this.numero = "98574697125089364819";
		this.dateExp = "1999-01-01";
		this.cvc = 666;
	}
	public CarteCredit(String nom, String prenom, String numero, String date, int cvc) {
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.dateExp = date;
		this.cvc = cvc;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		if(numero.length()==16){
			this.numero = numero;
		}
	}

	public String getDateExp() {
		return dateExp;
	}
	public void setDateExp(String dateExp) {
		this.dateExp = dateExp;
	}
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	
}
