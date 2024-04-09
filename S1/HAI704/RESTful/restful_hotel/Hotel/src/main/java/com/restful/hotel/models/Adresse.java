package com.restful.hotel.models;

import java.util.Objects;

public class Adresse{
	
	private String pays;
    private String ville;
    private String rue;
    private int numero;
    private String lieuDit;
    private int lattitude;
	private int longitude;

	public Adresse(){
		this.pays = "Pays";
		this.ville = "Ville";
		this.rue = "rue";
		this.numero = 0;
		this.lieuDit = "lieu-dit";
		this.lattitude = 0;
		this.longitude = 0;
	}
    public Adresse(String pays, String ville, String rue, int numero, String lieuDit, int lattitude, int longitude) {
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.numero = numero;
        this.lieuDit = lieuDit;
        this.lattitude = lattitude;
		this.longitude = longitude;
    }

	public Adresse(String pays, String ville, String rue, int numero, int lattitude, int longitude) {
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.numero = numero;
		this.lattitude = lattitude;
		this.longitude = longitude;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLieuDit() {
		return lieuDit;
	}

	public void setLieuDit(String lieuDit) {
		this.lieuDit = lieuDit;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Adresse adresse)) return false;
		return getNumero() == adresse.getNumero() && getLattitude() == adresse.getLattitude() && getLongitude() == adresse.getLongitude() && Objects.equals(getPays(), adresse.getPays()) && Objects.equals(getVille(), adresse.getVille()) && Objects.equals(getRue(), adresse.getRue()) && Objects.equals(getLieuDit(), adresse.getLieuDit());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPays(), getVille(), getRue(), getNumero(), getLieuDit(), getLattitude(), getLongitude());
	}

	@Override
	public String toString() {
		return "Adresse{" +
				"pays='" + pays + '\'' +
				", ville='" + ville + '\'' +
				", rue='" + rue + '\'' +
				", numero=" + numero +
				", lieuDit='" + lieuDit + '\'' +
				", lattitude=" + lattitude +
				", longitude=" + longitude +
				'}';
	}
}
