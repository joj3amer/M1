package com.restful.restful_agence.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.restful.restful_agence.models",
        "com.restful.restful_agence.client",
        "com.restful.restful_agence.cli"
})
public class RestfulAgenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulAgenceApplication.class, args);
    }

}
