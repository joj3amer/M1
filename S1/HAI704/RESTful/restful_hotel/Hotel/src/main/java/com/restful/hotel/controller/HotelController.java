package com.restful.hotel.controller;

import com.restful.hotel.exceptions.HotelInexistantException;
import com.restful.hotel.models.Chambre;
import com.restful.hotel.models.Hotel;
import com.restful.hotel.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;
    private static final String uri = "hotelwebservice/api";

    @GetMapping(uri+"/hotels")
    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }

   @GetMapping(uri+"/hotels/count")
    public String count(){
        return String.format("{\" %s\": %d}","count",hotelRepository.count());
    }

    @GetMapping(uri+"/hotels/{id}")
    public Hotel getHotelById(@PathVariable long id) throws HotelInexistantException {
        return hotelRepository.findById(id).orElseThrow(
                () -> new HotelInexistantException("Aucun hotel avec l'id "+id+" n'a été trouvé")
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(uri+"/hotels")
    public Hotel createHotel(@RequestBody Hotel hotel){
        return hotelRepository.save(hotel);
    }

    @PutMapping(uri+"/hotels/{id}")
    public Hotel modifierHotel(@RequestBody Hotel nouvelle_hotel, @PathVariable long id){
        return hotelRepository.findById(id)
                .map(hotel->{
                    hotel.setNom(nouvelle_hotel.getNom());
                    hotel.setEtoiles(nouvelle_hotel.getEtoiles());
                    hotel.setChambres(nouvelle_hotel.getChambres());
                    hotel.setAdresse(nouvelle_hotel.getAdresse());
                    return nouvelle_hotel;
                })
                .orElseGet(()->{
                    nouvelle_hotel.setId(id);
                    hotelRepository.save(nouvelle_hotel);
                    return nouvelle_hotel;
                });
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(uri+"hotels/{id}")
    public void supprimerHotel(@PathVariable long id) throws HotelInexistantException{
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(()-> new HotelInexistantException((
                            "Erreur : l'hotel d'id"+id+" n'a pas été trouvé"
                        )));
        hotelRepository.delete(hotel);

    }

    @RequestMapping(
            value = uri + "/hotels/search",
            params = {"size", "rating", "datein", "dateout", "price" },
            method = RequestMethod.GET)
    @ResponseBody
    public Hotel searchHotel(@RequestParam("size") int size, @RequestParam("rating") double rating,
                             @RequestParam("datein") String datein, @RequestParam("dateout") String dateout, @RequestParam("price") double price) {
        List<Hotel> hotels = hotelRepository.findAll();
        int etoiles = hotels.get(0).getEtoiles();
        LocalDate in = LocalDate.parse(datein);
        LocalDate out = LocalDate.parse(dateout);
        Hotel currentHotel = hotels.get(0);
        List<Chambre> nouvelleChambres = new ArrayList<Chambre>();
        if(etoiles >= rating) {
            for (Chambre chambre : hotels.get(0).getChambres()) {
                double roomPrice = chambre.getPrix();
                int roomSize = chambre.getLits();
                if(roomPrice <= price && roomSize >= size && chambre.estDisponible(in.toString(),out.toString())) {
                    nouvelleChambres.add(chambre);
                }
            }
            if(!nouvelleChambres.isEmpty()) {
                currentHotel.setChambres(nouvelleChambres);
                return currentHotel;
            }
        }
        return new Hotel();
    }
}