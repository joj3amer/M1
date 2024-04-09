package com.restful.hotel.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {
        "com.restful.hotel.models"
})
@EnableJpaRepositories(basePackages = {
        "com.restful.hotel.repositories"
})
@SpringBootApplication(scanBasePackages = {
        "com.restful.hotel.data",
        "com.restful.hotel.exceptions",
        "com.restful.hotel.controller"
})
public class HotelApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
    }
}
