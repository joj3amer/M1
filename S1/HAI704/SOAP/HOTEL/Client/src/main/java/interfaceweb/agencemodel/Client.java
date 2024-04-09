package interfaceweb.agencemodel;

import org.springframework.stereotype.Component;
import web.service.CarteCredit;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Component
public class Client {

    private String nom;
    private String prenom;
    private CarteCredit carteCredit;

    public Client(){
        this.nom = "nom";
        this.prenom = "prenom";
        this.carteCredit = new CarteCredit();
    }
    public Client(String nom, String prenom, CarteCredit carteCredit) {
        this.nom = nom;
        this.prenom = prenom;
        this.carteCredit = carteCredit;
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

    public CarteCredit getCarteCredit() {
        return carteCredit;
    }

    public void setCarteCredit(CarteCredit carteCredit) {
        this.carteCredit = carteCredit;
    }

}