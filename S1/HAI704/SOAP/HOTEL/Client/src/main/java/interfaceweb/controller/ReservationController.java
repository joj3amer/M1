package interfaceweb.controller;

import interfaceweb.agencemodel.Agence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.Hotel;
import web.service.HotelWebService;
import web.service.Reservation;

import javax.servlet.http.HttpSession;

@Controller
public class ReservationController {

    private Agence agence;
    @Autowired
    private HttpSession session;

    @Autowired
    public ReservationController(Agence agence){
        this.agence = agence;
    }

    @RequestMapping("/reservation")
    public String reservation(Model model, @RequestParam("numeroChambre") int numeroChambre){

        String debut = (String) model.getAttribute("debut");
        HotelWebService hotel = (HotelWebService) session.getAttribute("hotel");
        model.addAttribute("prix",hotel.getChambreByNumero(numeroChambre).getPrix());
        model.addAttribute("numero_chambre",numeroChambre);
        model.addAttribute("debut",debut);
        model.addAttribute("hotel",hotel);

        return "reservation";
    }
}
