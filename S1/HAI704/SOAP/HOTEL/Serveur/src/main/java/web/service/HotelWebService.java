package web.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public interface HotelWebService {

    @WebMethod
    Hotel getHotel();
    @WebMethod
    String chambreToString(int i);
    @WebMethod
    ArrayList<Chambre> getChambres();
    @WebMethod
    Chambre getChambreByNumero(int i);
    @WebMethod
    int getEtoiles();
    @WebMethod
    String getNom();

    @WebMethod
    Adresse getAdresse();
    @WebMethod
    ArrayList<Chambre> chambreDisponible(int nombre_lits, String debutS, String finS);
    @WebMethod
    int reserver(int numero,Client client, String debut, String fin);
    @WebMethod
    void addReservation(Reservation reservation);

}
