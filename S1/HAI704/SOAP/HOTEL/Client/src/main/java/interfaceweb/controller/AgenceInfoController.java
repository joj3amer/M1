package interfaceweb.controller;

import interfaceweb.agencemodel.Agence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgenceInfoController{
    private Agence agence;

    @Autowired
    public AgenceInfoController(Agence agence){
        this.agence = agence;
    }

    @GetMapping("/agence")
    public String afficherAgence(Model model){
        model.addAttribute("agence", agence);
        return "agence";
    }

}