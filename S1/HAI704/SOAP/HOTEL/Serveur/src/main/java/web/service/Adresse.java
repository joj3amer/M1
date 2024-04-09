package web.service;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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

	@XmlElement
	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@XmlElement
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@XmlElement
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	@XmlElement
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@XmlElement
	public String getLieuDit() {
		return lieuDit;
	}

	public void setLieuDit(String lieuDit) {
		this.lieuDit = lieuDit;
	}

	@XmlElement
	public int getLattitude() {
		return lattitude;
	}

	public void setLattitude(int lattitude) {
		this.lattitude = lattitude;
	}

	@XmlElement
	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
}
