package web.service;

import javax.xml.ws.Endpoint;
public class HotelWebServicePublisher {
    public static void main(String[] args) {

       // Hotel hotel = new Hotel();

        Hotel ibis = new Hotel("Hotel Ibis",new Adresse("France","Montpellier","Avenue bataillon",5,123,345),3);
        ibis.addChambre(new Chambre(2,1,123));
        ibis.addChambre(new Chambre(1, 1, 789));
        ibis.addChambre(new Chambre(4, 2, 234));
        ibis.addChambre(new Chambre(2, 1, 567));
        ibis.addPhoto("/1.jpg");

        Hotel carleton = new Hotel("Le carleton",new Adresse("France","Agde","Boulevard bataillon",5,123,345),5);
        carleton.addChambre(new Chambre(2,1,123));
        carleton.addChambre(new Chambre(1, 1, 789));
        carleton.addChambre(new Chambre(4, 2, 234));
        carleton.addChambre(new Chambre(2, 1, 567));
        carleton.addPhoto("/2.jpg");

        Hotel F1P = new Hotel("F1",new Adresse("France","Paris","Boulevard du marechal",12,13,45),1);
        F1P.addChambre(new Chambre(1,1,25));
        F1P.addChambre(new Chambre(2, 2, 45));
        F1P.addChambre(new Chambre(3, 1, 40));
        F1P.addChambre(new Chambre(4, 3, 75));
        F1P.addPhoto("/3.jpg");

        Hotel F1M = new Hotel("F1",new Adresse("France","Montpellier","chez tati",5,123,345),1);
        F1M.addChambre(new Chambre(1, 1, 25));
        F1M.addChambre(new Chambre(2, 2, 45));
        F1M.addChambre(new Chambre(3, 1, 40));
        F1M.addChambre(new Chambre(4, 3, 75));
        F1M.addPhoto("/4.jpg");

        Hotel adadio = new Hotel("Adadio",new Adresse("France","Nice","Avenue de Nice",5,123,345),4);
        adadio.addChambre(new Chambre(1, 1, 60));
        adadio.addChambre(new Chambre(2, 2, 120));
        adadio.addChambre(new Chambre(3, 1, 90));
        adadio.addChambre(new Chambre(4, 3, 200));
        adadio.addPhoto("/5.jpg");

        Hotel TOP1 = new Hotel("TOP1",new Adresse("France","Montpellier","figuerolle (bientôt)",5,123,345),5);
        TOP1.addChambre(new Chambre(1, 1, 500));
        TOP1.addChambre(new Chambre(2, 2, 750));
        TOP1.addChambre(new Chambre(3, 1, 800));
        TOP1.addChambre(new Chambre(4, 3, 1500));
        TOP1.addPhoto("/6.jpg");

        Hotel mercure = new Hotel("Mercure",new Adresse("France","Agen","Rue du moulin",5,123,345),2);
        mercure.addChambre(new Chambre(1, 1, 40));
        mercure.addChambre(new Chambre(2, 2, 60));
        mercure.addChambre(new Chambre(3, 1, 50));
        mercure.addChambre(new Chambre(4, 3, 130));
        mercure.addPhoto("/7.jpg");

        Hotel novotel = new Hotel("Novotel",new Adresse("France","Lille","Avenue de Bretagne",5,123,345),3);
        novotel.addChambre(new Chambre(1, 1, 45));
        novotel.addChambre(new Chambre(2, 2, 65));
        novotel.addChambre(new Chambre(3, 1, 55));
        novotel.addChambre(new Chambre(4, 3, 135));
        novotel.addPhoto("/8.jpg");

        Hotel Hilton = new Hotel("Hilton",new Adresse("France","Paris","Avenue de la Concorde",5,123,345),5);
        Hilton.addChambre(new Chambre(1, 1, 400));
        Hilton.addChambre(new Chambre(2, 2, 700));
        Hilton.addChambre(new Chambre(3, 1, 700));
        Hilton.addChambre(new Chambre(4, 3, 1400));
        Hilton.addPhoto("/9.jpg");

        Hotel sofitel = new Hotel("Sofitel",new Adresse("France","Perpigan","Avenue de Montpellier",5,123,345),3);
        sofitel.addChambre(new Chambre(1, 1, 50));
        sofitel.addChambre(new Chambre(2, 2, 75));
        sofitel.addChambre(new Chambre(3, 1, 80));
        sofitel.addChambre(new Chambre(4, 3, 100));
        sofitel.addPhoto("/10.jpg");

        Hotel campanille = new Hotel("Campanille",new Adresse("France","Montauban","Rue de thomas",5,123,345),3);
        campanille.addChambre(new Chambre(1, 1, 50));
        campanille.addChambre(new Chambre(2, 2, 75));
        campanille.addChambre(new Chambre(3, 1, 60));
        campanille.addChambre(new Chambre(4, 3, 95));
        campanille.addPhoto("/11.jpg");

        Hotel plaza = new Hotel("Plaza Athénée",new Adresse("France","Monaco","Rive Gauche",5,123,345),5);
        plaza.addChambre(new Chambre(1, 1, 400));
        plaza.addChambre(new Chambre(2, 2, 700));
        plaza.addChambre(new Chambre(3, 1, 600));
        plaza.addChambre(new Chambre(4, 3, 1300));
        plaza.addPhoto("/12.jpg");

        Hotel bristol = new Hotel("Le Bristol Paris",new Adresse("France","Paris","Rue du jeu de pomme",5,123,345),5);
        bristol.addChambre(new Chambre(1, 1, 450));
        bristol.addChambre(new Chambre(2, 2, 700));
        bristol.addChambre(new Chambre(3, 1, 700));
        bristol.addChambre(new Chambre(4, 3, 1200));
        bristol.addPhoto("/13.jpg");

        Hotel meurice = new Hotel("Le Meurice",new Adresse("France","Nice","Promenade des Anglais",5,123,345),5);
        meurice.addChambre(new Chambre(1, 1, 300));
        meurice.addChambre(new Chambre(2, 2, 500));
        meurice.addChambre(new Chambre(3, 1, 750));
        meurice.addChambre(new Chambre(4, 3, 1000));
        meurice.addPhoto("/14.jpg");

        Hotel lutetia = new Hotel("Lutétia",new Adresse("France","Saint Jean de Luz","Sainte Barbe",5,123,345),5);
        lutetia.addChambre(new Chambre(1, 1, 300));
        lutetia.addChambre(new Chambre(2, 2, 650));
        lutetia.addChambre(new Chambre(3, 1, 750));
        lutetia.addChambre(new Chambre(4, 3, 1150));
        lutetia.addPhoto("/15.jpg");

        Hotel George = new Hotel("George V",new Adresse("France","Marseille","Vieux port",5,123,345),5);
        George.addChambre(new Chambre(1, 1, 407.56));
        George.addChambre(new Chambre(2, 2, 600.38));
        George.addChambre(new Chambre(3, 1, 700));
        George.addChambre(new Chambre(4, 3, 1350));
        George.addPhoto("/16.jpg");


        Endpoint.publish("http://localhost:8090/hotelwebservice",new HotelWebServiceHotelImpl());
        Endpoint.publish("http://localhost:8090/hotelwebserviceibis",new HotelWebServiceHotelImpl(ibis));
        Endpoint.publish("http://localhost:8090/hotelwebservicecarleton",new HotelWebServiceHotelImpl(carleton));
        Endpoint.publish("http://localhost:8090/hotelwebserviceF1P",new HotelWebServiceHotelImpl(F1P));
        Endpoint.publish("http://localhost:8090/hotelwebserviceF1M",new HotelWebServiceHotelImpl(F1M));
        Endpoint.publish("http://localhost:8090/hotelwebserviceAdadio",new HotelWebServiceHotelImpl(adadio));
        Endpoint.publish("http://localhost:8090/hotelwebserviceTOP1",new HotelWebServiceHotelImpl(TOP1));
        Endpoint.publish("http://localhost:8090/hotelwebservicemercure",new HotelWebServiceHotelImpl(mercure));
        Endpoint.publish("http://localhost:8090/hotelwebservicenovotel",new HotelWebServiceHotelImpl(novotel));
        Endpoint.publish("http://localhost:8090/hotelwebserviceHilton",new HotelWebServiceHotelImpl(Hilton));
        Endpoint.publish("http://localhost:8090/hotelwebservicesofitel",new HotelWebServiceHotelImpl(sofitel));
        Endpoint.publish("http://localhost:8090/hotelwebservicecampanille",new HotelWebServiceHotelImpl(campanille));
        Endpoint.publish("http://localhost:8090/hotelwebserviceplaza",new HotelWebServiceHotelImpl(plaza));
        Endpoint.publish("http://localhost:8090/hotelwebservicebristol",new HotelWebServiceHotelImpl(bristol));
        Endpoint.publish("http://localhost:8090/hotelwebservicemeurice",new HotelWebServiceHotelImpl(meurice));
        Endpoint.publish("http://localhost:8090/hotelwebservicelutetia",new HotelWebServiceHotelImpl(lutetia));
        Endpoint.publish("http://localhost:8090/hotelwebserviceGeorge",new HotelWebServiceHotelImpl(George));

        System.err.println("Serveur prêt");
    }
}