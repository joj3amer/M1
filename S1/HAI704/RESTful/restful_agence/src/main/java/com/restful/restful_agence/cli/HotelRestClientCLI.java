package com.restful.restful_agence.cli;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restful.restful_agence.exceptions.ReservationException;
import com.restful.restful_agence.models.Adresse;
import com.restful.restful_agence.models.Chambre;
import com.restful.restful_agence.models.Hotel;
import com.restful.restful_agence.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;

@Component
public class HotelRestClientCLI extends AbstractMain implements CommandLineRunner {

    @Autowired
    private RestTemplate proxy;
    private static String URI_HOTEL;
    private static String URI_HOTEL_ID;
    private static Map<String, String> URIS;
    @Override
    protected boolean validServiceUrl() {
        return SERVICE_URL.equals("http://localhost:8080/hotelwebservice/api");
    }

    @Override
    protected void menu() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n1. Nombre hotels");
        builder.append("\n2. Reserver");
        builder.append("\n3. Lhotel par ID.");
        builder.append("\n4. Tous les hotels");
        builder.append("\n"+QUIT+". Quitter.");

        System.out.println(builder);

    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader inputReader;
        String userInput = "";
        try {
            inputReader = new BufferedReader(new InputStreamReader(System.in));
            setTestServiceUrl(inputReader);
            URI_HOTEL = "hotels";
            URI_HOTEL_ID = URI_HOTEL + "/{id}";
            URIS = new HashMap<String, String>();
            URIS.put(SERVICE_URL + "hotels", SERVICE_URL + URI_HOTEL_ID);
            do {
                menu();
                userInput = inputReader.readLine();
                processUserInput(inputReader, userInput, proxy);

            } while (!userInput.equals(QUIT));
            System.exit(0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void processUserInput(BufferedReader reader, String userInput, RestTemplate proxy) {
        Map<String, String> params = new HashMap<>();
        try {
            switch(userInput) {
                case "1":
                    int x = 0;
                    for (String uri : URIS.keySet()) {
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
                    System.out.println(String.format("There are %d hotels:", x));
                    for (String uri : URIS.keySet()) {
                        try {
                            Hotel[] hotels = proxy.getForObject(uri, Hotel[].class);
                            Arrays.asList(hotels).forEach(System.out::println);
                        }

                        catch (Exception e) {
                            continue;
                        }
                    }
                    break;

                case "2":
                    System.out.println("Pays ? Ville ?\n");
                    String position = reader.readLine();
                    System.out.println("\nEtoiles: ");
                    double rating = Double.parseDouble(reader.readLine());
                    System.out.println("\nPrix: ");
                    double price = Double.parseDouble(reader.readLine());
                    System.out.println("\nArrivé: ");
                    String inDate = "2022-05-05";
                    System.out.println("\nDepart: ");
                    String outDate = "2022-05-06";
                    System.out.println("\nNombre de personne: ");
                    int size = Integer.parseInt(reader.readLine());
                    params.put("position", position);
                    params.put("datein", inDate);
                    params.put("dateout", outDate);
                    params.put("size", String.valueOf(size));
                    params.put("rating", String.valueOf(rating));
                    params.put("price", String.valueOf(price));

                    List<Hotel> resultHotel = new ArrayList<>();
                    int cpt = 1;
                    ArrayList<String> uriList = new ArrayList<>();
                    System.out.println("Results:\n");
                    for (String uri : URIS.keySet()) {
                        try {
                            String url = uri + "/search?position={position}&size={size}&rating={rating}&datein={datein}&dateout={dateout}&price={price}";
                            Hotel currentHotel = proxy.getForObject(url, Hotel.class, params);
                            if(!currentHotel.getNom().equals("Undefined")) {
                                uriList.add(uri);
                                resultHotel.add(currentHotel);
                                System.out.println("Hotel n°"+ String.valueOf(cpt));
                                cpt++;
                                System.out.println(currentHotel.toString());
                                for (Chambre chambre: currentHotel.getChambres()) {
                                    System.out.println(chambre.toString());
                                }
                                System.out.println();
                            }
                        }
                        catch (Exception e) {
                            continue;
                        }
                    }


                    System.out.println("Would you like to order one of these ?\n");
                    int chambreChoisi = -1;
                    int roomChoice = 0;
                    while(chambreChoisi == -1) {
                        System.out.println("Hotel number (0 to exit): ");
                        chambreChoisi = Integer.parseInt(reader.readLine());
                        if(chambreChoisi == 0) {
                            System.out.println("Quitting hotel research...");
                            break;
                        }
                        else if(chambreChoisi > resultHotel.size() || chambreChoisi <= -1) {
                            System.err.println("Impossible choice !");
                            chambreChoisi = -1;
                        }
                        else {
                            System.out.println("Room number : ");
                            roomChoice = Integer.parseInt(reader.readLine());
                        }
                    }
                    LocalDate ind = LocalDate.parse(inDate);
                    LocalDate outd = LocalDate.parse(outDate);
                    if(chambreChoisi != 0 && roomChoice != 0) {
                        Hotel selectedHotel = resultHotel.get(chambreChoisi-1);
                        Chambre chambreSelectionner = selectedHotel.getChambre(roomChoice-1);
                        Reservation currentReservation = selectedHotel.reserver(reader, ind, outd, chambreSelectionner);
                        selectedHotel.addReservation(currentReservation);
                        params.put("id", String.valueOf(selectedHotel.getId()));
                        String uriID = URIS.get(uriList.get(chambreChoisi-1));
                        proxy.put(uriID, selectedHotel, params);
                        System.out.println("Votre commande a été réaliser avec succès. Au revoir !\n");


                    }

                    break;

                case "3":
                    System.out.println("Quel est l'id ?\n");
                    String id = reader.readLine();
                    String uri = SERVICE_URL + "/hotels/"+id;
                    Hotel hotel = proxy.getForObject(uri, Hotel.class, params);
                    System.out.println(hotel.toString());

                    break;

                case "4":
                    uri = SERVICE_URL +"/hotels";
                    ResponseEntity<Hotel[]> response = proxy.getForEntity(uri, Hotel[].class);
                    Hotel[] hotels = response.getBody();
                    List<Hotel> list_hotels = Arrays.asList(hotels);
                    System.out.println(list_hotels);
                    break;
                case QUIT:
                    System.out.println("Bisous...");
                    return;
                default:
                    System.err.println("Choix non existant");
                    return;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
