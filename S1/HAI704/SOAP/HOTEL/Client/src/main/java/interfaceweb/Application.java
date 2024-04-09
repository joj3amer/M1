package interfaceweb;

import interfaceweb.agencemodel.Agence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"interfaceweb.agencemodel", "interfaceweb.controller","web.service"})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        Agence agence = new Agence(1,"Atlas Hotel","admin");
        SpringApplication.run(Application.class, args);
    }
}