package interfaceweb.agencemodel;

import org.springframework.stereotype.Component;
import web.service.Chambre;
import web.service.Hotel;
import web.service.HotelWebService;
import web.service.Reservation;
import web.service.Client;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.*;

@Component
public class Agence {

    private final int id_agence;
    private String nom_agence;
    private String mot_de_passe;
    private HashMap<HotelWebService, Double> liste_hotels = new HashMap<HotelWebService, Double>();

    public Agence(){
        this.id_agence = 0;
        this.nom_agence = "Guest";
        this.mot_de_passe = "admin";
    }

    public Agence(int id_agence, String nom_agence, String mot_de_passe) {
        this.id_agence=id_agence;
        this.mot_de_passe = mot_de_passe;
        this.nom_agence = nom_agence;
    }

    public String getNomAgence() {
        return nom_agence;
    }

    public String getMotDePasse(){
        return this.mot_de_passe;
    }

    public HotelWebService getHotelByName(String nom_hotel){
        for(HotelWebService hotel : liste_hotels.keySet()){
            if(Objects.equals(hotel.getNom(), nom_hotel)){
                return hotel;
            }
        }
        return null;
    }

    public void setNomAgence(String nom_agence) {
        this.nom_agence = nom_agence;
    }

    public HashMap<HotelWebService, Double> getListeHotels() {
        return liste_hotels;
    }

    public void setListeHotels(HashMap<HotelWebService, Double> liste_hotels) {
        this.liste_hotels = liste_hotels;
    }

    public void addListeHotels(HotelWebService hotel, Double taux){
        this.liste_hotels.put(hotel,taux);
    }

    public void hotelFinder(Client client) {
        try  {
            Scanner textScanner = new Scanner(System.in);
            Scanner intScanner = new Scanner(System.in);
            System.out.println("Quel ville?\n");
            String ville = textScanner.nextLine();
            System.out.println("Quelle est votre date d'arriv� ? (yyyy-MM-dd))\n");
            String debutS = textScanner.nextLine();
            System.out.println("Quelle est votre date de retour ? (yyyy-MM-dd))\n");
            String finS = textScanner.nextLine();
            System.out.println("Combien de lis voulez vous ?\n");
            int nombre_lits = intScanner.nextInt();
            System.out.println("Combien d'�toiles ?");
            int etoiles = intScanner.nextInt();
            System.out.println("Nous recherchons les meilleurs offres pour vous...\n");

            HashMap<HotelWebService, Double> hotels = this.rechercher(ville,nombre_lits,debutS,finS, etoiles);

            if(hotels.isEmpty()) {
                System.err.println("D�sol�, aucun hotel ne correspond � vos attentes.");
                return;
            }

            ArrayList<HotelWebService> liste_hotels = new ArrayList<>();
            int cpt = 1;
            for (Map.Entry<HotelWebService, Double> current_proxy : hotels.entrySet()) {
                HotelWebService hotel = current_proxy.getKey();
                liste_hotels.add(hotel);
                String etoiles_string = String.valueOf(etoiles);
                System.out.println(hotel.getNom() + " " + etoiles_string + "\n");
                for(int j = 1; j <= hotel.getChambres().size(); j++) {
                    Chambre chambre = hotel.getChambres().get(j-1);
                    System.out.println("N�" + cpt + "-" + j + " : " + chambre.toString());
                }
                System.out.println();
                cpt++;
            }


            System.out.println("Voulez vous reservez l'une d'entre elles ?\n");
            int choix_hotel = -1;
            int choix_chambre = 0;
            while(choix_hotel == -1) {
                System.out.println("Num�ro de l'hotel voulu (choisissez 0 pour quitter) : ");
                choix_hotel = intScanner.nextInt();
                if(choix_hotel == 0) {
                    System.out.println("A bientot...");
                    return;
                }
                else if(choix_hotel > hotels.size() || choix_hotel <= -1) {
                    System.err.println("Impossible de faire ce choix !");
                    choix_hotel = -1;
                }
                else {
                    System.out.println("Numero de chambre : ");
                    choix_chambre = intScanner.nextInt();
                }
            }

            reserverChambre(client,debutS,finS,liste_hotels.get(choix_hotel -1).getChambres().get(choix_chambre -1),liste_hotels.get(choix_hotel -1), hotels.get(liste_hotels.get(choix_hotel -1)));

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Chambre> rechercherChambre(HotelWebService proxy, String debutS, String finS, int nombre_lits) {
        return (ArrayList<Chambre>) proxy.chambreDisponible(nombre_lits, debutS, finS);

    }

    public void reserverChambre(Client client, String debutS, String finS, Chambre chambre, HotelWebService hotel, double prix){

        Reservation reservation = new Reservation();
        reservation.setClient(client);
        reservation.setDateArrivee(debutS);
        reservation.setDateDepart(finS);
        reservation.setChambreReservee(chambre);

        hotel.addReservation(reservation);
        System.out.println("Votre r�servation est confirm�. Merci !\n");
        //this.genererReservation(agence, hotel, client, reservation);
    }
    public HashMap<HotelWebService, Double> rechercher(String ville, int nombre_lits, String debutS, String finS, int etoiles) {
        HashMap<HotelWebService, Double> hotels = new HashMap<>();
        HashMap<HotelWebService, Double> liste_proxy = this.getListeHotels();
        System.out.println(liste_proxy.size());
        try {
            for (Map.Entry<HotelWebService, Double> current_proxy : liste_proxy.entrySet()) {
                HotelWebService hotel = current_proxy.getKey();
                System.out.println(hotel.getHotel().getNom());
                if(hotel.getAdresse().getVille().equals(ville) && hotel.getEtoiles() >= etoiles && !this.rechercherChambre(hotel,debutS,finS, nombre_lits).isEmpty()) {
                    hotels.put(hotel,this.getListeHotels().get(hotel));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return hotels;
    }

    public static void sendMail(String nom_agence,String nom, String prenom, String numero_reservation,String debut,String fin,double prix,String email) {
        // Paramètres de configuration du serveur SMTP et des informations d'authentification
        String host = "smtp.gmail.com";
        int port = 587;
        String username = "ayoub.chenini1@gmail.com";
        String password = "afxfonhtbjcxqxaz";

        // Propriétés pour la configuration de la session
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Création de la session avec les informations d'authentification
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Création du message e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sender@example.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Bienvenue à "+nom_agence+" ! Confirmation de votre réservation");
            message.setContent("Cher(e) [Nom du client],<br>" +
                    "<br>" +
                    "Nous vous remercions d'avoir choisi notre établissement pour votre séjour. Nous sommes ravis de confirmer votre réservation de chambre. Voici les détails de votre réservation :<br>" +
                    "<br>" +
                    "<strong>Client : </strong>"+nom+" "+prenom+"<br>" +
                    "<strong>Numéro de réservation : </strong>"+numero_reservation+"]<br>" +
                    "<strong>Date d'arrivée : </strong>"+debut+"<br>" +
                    "<strong>Date de départ : </strong>"+fin+"<br>" +
                    "<strong>Tarif : </strong>"+prix+" €<br><br>" +
                    "Nous tenons à vous assurer que nous ferons tout notre possible pour rendre votre séjour agréable et confortable. Si vous avez des demandes spéciales ou des besoins particuliers, n'hésitez pas à nous en informer à l'avance afin que nous puissions les prendre en compte.<br>" +
                    "<br>" +
                    "Pour toute question supplémentaire ou demande d'assistance, notre équipe est à votre disposition. Nous vous encourageons également à consulter notre site web pour découvrir les services et installations disponibles dans notre établissement.<br>" +
                    "<br>" +
                    "Nous sommes impatients de vous accueillir bientôt. Si vous avez besoin d'apporter des modifications à votre réservation ou d'annuler, veuillez nous en informer dès que possible.<br>" +
                    "<br>" +
                    "Encore une fois, merci de nous avoir choisis. Nous espérons que votre séjour sera des plus agréables.<br>" +
                    "<br>" +
                    "Cordialement,<br>" +
                    "<br>" +
                    "<h3>CHENINI Ayoub le plus beau de tous les rebeux</h3><br>"
                    +nom_agence+"<br>","text/html; charset=utf-8");

            // Envoi du message
            Transport.send(message);

            System.out.println("L'e-mail a été envoyé avec succès.");
        } catch (MessagingException e) {
            System.out.println("Une erreur s'est produite lors de l'envoi de l'e-mail : " + e.getMessage());
        }
    }

}
