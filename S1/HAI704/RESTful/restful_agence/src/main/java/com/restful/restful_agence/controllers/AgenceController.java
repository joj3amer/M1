package com.restful.restful_agence.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restful.restful_agence.models.Agence;
import com.restful.restful_agence.models.Hotel;
import com.restful.restful_agence.repositories.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AgenceController {

    @Autowired
    private RestTemplate proxy;
    @Autowired
    private AgenceRepository repository;
    private static final String uri = "hotelorg/api";

    @GetMapping(uri + "/agency/count")
    public int getCountHotels() {
        int x = 0;
        Agence agence = repository.findAll().get(0);
        ArrayList<String> URIS = new ArrayList<>();
        for (Hotel hotel: agence.getHotels()){
            URIS.add(hotel.getUri());
        }
        for (String uri : URIS) {

            for (Hotel hotel: agence.getHotels()){
                URIS.add(hotel.getUri());
            }
            try {
                String uriCount = uri + "/count";
                ObjectMapper mapper = new ObjectMapper();
                String countStr = proxy.getForObject(uriCount, String.class);
                long count = (int)mapper.readValue(countStr, Map.class).get("count");
                x += count;
            }
            catch (Exception e) {
                continue;
            }
        }
        return x;
    }


    @PutMapping(uri + "/agence/resa/{id}")
    public Hotel updateHotel(@RequestBody Hotel newHotel, @PathVariable long id) {
        Agence agence = repository.findAll().get(0);
        HashMap<Long, String> URIS = new HashMap<Long, String>();
        for (Hotel offer: agence.getHotels()) {
            URIS.put(offer.getId(),offer.getUri());
        }
        String uri = URIS.get(id);
        proxy.put(uri + "/" + String.valueOf(id), newHotel);
        return newHotel;
    }

    @GetMapping(uri + "/agency")
    public List<Agence> getAllAgencies() {
        return repository.findAll();
    }

    @GetMapping(uri + "/agency/hotels")
    public List<Hotel> getAllHotels() {
        Agence agence = repository.findAll().get(0);
        ArrayList<String> URIS = new ArrayList<>();
        for (Hotel hotel: agence.getHotels()) {
            URIS.add(hotel.getUri());
        }
        List<Hotel> hotels = new ArrayList<>();
        for (String uri : URIS) {
            try {
                Hotel[] hotel = proxy.getForObject(uri, Hotel[].class);
                for (Hotel hotel2 : hotel) {
                    hotels.add(hotel2);
                }
            }
            catch (Exception e) {
                continue;
            }

        }
        return hotels;
    }

    @RequestMapping(
            value = uri + "/agency/search",
            params = { "position", "size", "rating", "datein", "dateout", "price" },
            method = RequestMethod.GET)
    @ResponseBody
    public List<Hotel> searchHotel(@RequestParam("position") String position, @RequestParam("size") int size, @RequestParam("rating") double rating,
                                   @RequestParam("datein") String datein, @RequestParam("dateout") String dateout, @RequestParam("price") double price) {
        Agence agence = repository.findAll().get(0);
        List<Hotel> toReturnHotels = new ArrayList<>();
        HashMap<String, Double> URIS = new HashMap<>();
        for (Hotel offer: agence.getHotels()) {
            URIS.put(offer.getUri(),1.);
        }
        Map<String, String> params = new HashMap<>();
        params.put("position", position);
        params.put("datein", datein);
        params.put("dateout", dateout);
        params.put("size", String.valueOf(size));
        params.put("rating", String.valueOf(rating));
        params.put("price", String.valueOf(price));
        for (String uri : URIS.keySet()) {
            try {
                String url = uri + "/search?position={position}&size={size}&rating={rating}&datein={datein}&dateout={dateout}&price={price}";
                Hotel returnedHotel = proxy.getForObject(url, Hotel.class, params);
                if(!returnedHotel.getNom().equals("Non defini")) {
                    toReturnHotels.add(returnedHotel);
                }
            }
            catch (Exception e) {
                continue;
            }
        }
        return toReturnHotels;
    }

}
