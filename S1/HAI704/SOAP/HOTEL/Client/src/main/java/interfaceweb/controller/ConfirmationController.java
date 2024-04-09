package interfaceweb.controller;

import interfaceweb.agencemodel.Agence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarteCredit;
import web.service.Client;
import web.service.Hotel;
import web.service.HotelWebService;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
public class ConfirmationController {

    private Agence agence;
    @Autowired
    private HttpSession session;
    @Autowired
    public ConfirmationController(Agence agence){
        this.agence = agence;
    }

    @RequestMapping("/confirmation")
    public String confirmation(@RequestParam("numeroChambre") int numeroChambre,@RequestParam("nom") String nom,@RequestParam("prenom") String prenom,@RequestParam("debut") String debut,@RequestParam("fin") String fin,@RequestParam("numero_carte") String numero,@RequestParam("date_exp") String date_exp,@RequestParam("email") String email,@RequestParam("cvv") int cvv ,Model model){

        CarteCredit carte_credit = new CarteCredit();
        carte_credit.setNom(nom);
        carte_credit.setPrenom(prenom);
        carte_credit.setNumero(numero);
        carte_credit.setDateExp(date_exp);
        carte_credit.setCvc(cvv);

        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setCarteCredit(carte_credit);

        String numero_reservation = ConfirmationController.genererNumeroReservation();

        HotelWebService hotel = (HotelWebService) session.getAttribute("hotel");

        agence.reserverChambre(client,debut,fin,hotel.getChambreByNumero(numeroChambre),hotel,hotel.getChambreByNumero(numeroChambre).getPrix());
        Agence.sendMail(agence.getNomAgence(),nom,prenom,numero_reservation,debut,fin,hotel.getChambreByNumero(numeroChambre).getPrix(),email);

        model.addAttribute("nom",nom);
        model.addAttribute("prenom",prenom);
        model.addAttribute("debut",debut);
        model.addAttribute("fin",fin);
        model.addAttribute("numeroConfirmation",numero_reservation);

        return "confirmation";
    }

    public static String genererNumeroReservation() {
        int longueur = 8;
        String caracteresPermis = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(longueur);
        Random random = new Random();

        for (int i = 0; i < longueur; i++) {
            int index = random.nextInt(caracteresPermis.length());
            char caractere = caracteresPermis.charAt(index);
            sb.append(caractere);
        }

        return sb.toString();
    }

}
