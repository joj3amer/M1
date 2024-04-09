package interfaceweb.controller;

import interfaceweb.agencemodel.Agence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.HotelWebService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@Controller
public class RechercheController {

    private Agence agence;
    private ArrayList<HotelWebService> liste_hotels_disponibles;

    @Autowired
    public RechercheController(Agence agence){
        this.agence = agence;
    }

    @GetMapping("/recherche")
    public String recherche(@RequestParam("ville") String ville,@RequestParam("nombrelits") int nombre_lits,@RequestParam("debut") String debutS,@RequestParam("fin") String finS,@RequestParam("etoiles") int etoiles, Model model){

        Set<HotelWebService> liste_hotels_disponibles_set = agence.rechercher(ville,nombre_lits,debutS,finS,etoiles).keySet();
        liste_hotels_disponibles = new ArrayList<>(liste_hotels_disponibles_set);

        model.addAttribute("agence",agence);
        model.addAttribute("listeHotelsDisponibles",liste_hotels_disponibles);
        model.addAttribute("debut",debutS);
        model.addAttribute("fin",finS);

        return "recherche";

    }

}
