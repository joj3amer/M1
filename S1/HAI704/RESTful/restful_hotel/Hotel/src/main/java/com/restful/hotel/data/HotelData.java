package com.restful.hotel.data;

import com.restful.hotel.models.Adresse;
import com.restful.hotel.models.Chambre;
import com.restful.hotel.models.Hotel;
import com.restful.hotel.repositories.HotelRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class HotelData {
   private Logger logger = LoggerFactory.getLogger(HotelData.class);
   @Bean
   public CommandLineRunner initDataBase(HotelRepository hotelRepository){
        return args->{
            List<Chambre> chambres = new ArrayList<>();
            Chambre c1 = new Chambre();
            chambres.add(c1);
            Hotel hotel_1 = new Hotel("Ibis",new Adresse("France","Montpellier","Avenue Mendes France",7,134,130),3,chambres);
            logger.info("Ajout d'une donnée..."+hotelRepository.save(hotel_1));
        };
   }
}
