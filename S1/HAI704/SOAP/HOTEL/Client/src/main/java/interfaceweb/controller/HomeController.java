package interfaceweb.controller;


import interfaceweb.agencemodel.Agence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import interfaceweb.agencemodel.Client;
import web.service.HotelWebService;
import web.service.HotelWebServiceHotelImplService;

import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class HomeController {

    private Agence agence;
    private Client client;
    private Boolean first_connexion = true;

    @Autowired
    public HomeController(Agence agence, Client client) {
        this.agence = agence;
        this.client = client;
    }

    @RequestMapping("/")
    public String home(Model model) {

        if(first_connexion){
            agence.setNomAgence("Atlas Hotel");

            HotelWebService proxy_ibis = null;
            HotelWebService proxy_carleton = null;
            HotelWebService proxy_F1P = null;
            HotelWebService proxy_F1M = null;
            HotelWebService proxy_adadio = null;
            HotelWebService proxy_TOP1 = null;
            HotelWebService proxy_mercure = null;
            HotelWebService proxy_novotel = null;
            HotelWebService proxy_Hilton = null;
            HotelWebService proxy_sofitel = null;
            HotelWebService proxy_campanille = null;
            HotelWebService proxy_plaza = null;
            HotelWebService proxy_bristol = null;
            HotelWebService proxy_meurice = null;
            HotelWebService proxy_lutetia = null;
            HotelWebService proxy_george = null;


            try {
                URL url_ibis;
                url_ibis = new URL("http://localhost:8090/hotelwebserviceibis?wsdl");
                HotelWebServiceHotelImplService serviceImpl = new HotelWebServiceHotelImplService(url_ibis);
                proxy_ibis = serviceImpl.getHotelWebServiceHotelImplPort();

                URL url_carleton;
                url_carleton = new URL("http://localhost:8090/hotelwebservicecarleton?wsdl");
                serviceImpl = new HotelWebServiceHotelImplService(url_carleton);
                proxy_carleton = serviceImpl.getHotelWebServiceHotelImplPort();

                URL url_F1P;
                url_F1P = new URL("http://localhost:8090/hotelwebserviceF1P?wsdl");
                serviceImpl = new HotelWebServiceHotelImplService(url_F1P);
                proxy_F1P = serviceImpl.getHotelWebServiceHotelImplPort();

                URL url_F1M;
                url_F1M = new URL("http://localhost:8090/hotelwebserviceF1M?wsdl");
                serviceImpl = new HotelWebServiceHotelImplService(url_F1M);
                proxy_F1M = serviceImpl.getHotelWebServiceHotelImplPort();

                URL url_Adadio;
                url_Adadio = new URL("http://localhost:8090/hotelwebserviceAdadio?wsdl");
                serviceImpl = new HotelWebServiceHotelImplService(url_Adadio);
                proxy_adadio = serviceImpl.getHotelWebServiceHotelImplPort();

                URL url_TOP1;
                url_TOP1 = new URL("http://localhost:8090/hotelwebserviceTOP1?wsdl");
                serviceImpl = new HotelWebServiceHotelImplService(url_TOP1);
                proxy_TOP1 = serviceImpl.getHotelWebServiceHotelImplPort();

                URL url_mercure;
                url_mercure = new URL("http://localhost:8090/hotelwebservicemercure?wsdl");
                serviceImpl = new HotelWebServiceHotelImplService(url_mercure);
                proxy_mercure = serviceImpl.getHotelWebServiceHotelImplPort();

                URL url_novotel;
                url_novotel = new URL("http://localhost:8090/hotelwebservicenovotel?wsdl");
                serviceImpl = new HotelWebServiceHotelImplService(url_novotel);
                proxy_novotel = serviceImpl.getHotelWebServiceHotelImplPort();

                URL url_Hilton;
                url_Hilton = new URL("http://localhost:8090/hotelwebserviceHilton?wsdl");
                serviceImpl = new HotelWebServiceHotelImplService(url_Hilton);
                proxy_Hilton = serviceImpl.getHotelWebServiceHotelImplPort();

                URL url_sofitel;
                url_sofitel = new URL("http://localhost:8090/hotelwebservicesofitel?wsdl");
                serviceImpl = new HotelWebServiceHotelImplService(url_sofitel);
                proxy_sofitel = serviceImpl.getHotelWebServiceHotelImplPort();

                URL url_campanille;
                url_campanille = new URL("http://localhost:8090/hotelwebservicecampanille?wsdl");
                serviceImpl = new HotelWebServiceHotelImplService(url_campanille);
                proxy_campanille = serviceImpl.getHotelWebServiceHotelImplPort();

                URL url_plaza;
                url_plaza = new URL("http://localhost:8090/hotelwebserviceplaza?wsdl");
                serviceImpl = new HotelWebServiceHotelImplService(url_plaza);
                proxy_plaza = serviceImpl.getHotelWebServiceHotelImplPort();

                URL url_bristol;
                url_bristol = new URL("http://localhost:8090/hotelwebservicebristol?wsdl");
                serviceImpl = new HotelWebServiceHotelImplService(url_bristol);
                proxy_bristol = serviceImpl.getHotelWebServiceHotelImplPort();

                URL url_meurice;
                url_meurice = new URL("http://localhost:8090/hotelwebservicemeurice?wsdl");
                serviceImpl = new HotelWebServiceHotelImplService(url_meurice);
                proxy_meurice = serviceImpl.getHotelWebServiceHotelImplPort();

                URL url_lutetia;
                url_lutetia = new URL("http://localhost:8090/hotelwebservicelutetia?wsdl");
                serviceImpl = new HotelWebServiceHotelImplService(url_lutetia);
                proxy_lutetia = serviceImpl.getHotelWebServiceHotelImplPort();

                URL url_george;
                url_george = new URL("http://localhost:8090/hotelwebservicegeorge?wsdl");
                serviceImpl = new HotelWebServiceHotelImplService(url_george);
                proxy_george = serviceImpl.getHotelWebServiceHotelImplPort();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            agence.addListeHotels(proxy_ibis, 1.6);
            agence.addListeHotels(proxy_carleton, 1.1);

            agence.addListeHotels(proxy_ibis, 1.98);
            agence.addListeHotels(proxy_carleton, 1.1);
            agence.addListeHotels(proxy_F1P, 0.5);
            agence.addListeHotels(proxy_F1M, 0.5);
            agence.addListeHotels(proxy_adadio, 1.1);
            agence.addListeHotels(proxy_TOP1, 0.75);
            agence.addListeHotels(proxy_mercure, 0.36);
            agence.addListeHotels(proxy_novotel, 1.1);
            agence.addListeHotels(proxy_Hilton, 0.75);
            agence.addListeHotels(proxy_sofitel, 1.1);
            agence.addListeHotels(proxy_campanille, 0.48);
            agence.addListeHotels(proxy_plaza, 1.1);
            agence.addListeHotels(proxy_bristol, 0.75);
            agence.addListeHotels(proxy_meurice, 0.7);
            agence.addListeHotels(proxy_lutetia, 0.48);
            agence.addListeHotels(proxy_george, 0.6);

            first_connexion = false;
        }
        model.addAttribute("agence", agence);
        return "home";

    }
}