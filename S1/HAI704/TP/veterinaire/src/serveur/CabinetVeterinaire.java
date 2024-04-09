package serveur;

import common.Icabinet;
import common.Ianimal;
import common.Iclient;
import common.IdossierSuivi;
import common.Iespece;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class CabinetVeterinaire extends RemoteException implements Icabinet{

    private ArrayList<Ianimal> animals;
    private ArrayList<Iclient> clients;

    public CabinetVeterinaire() throws RemoteException{
        this.animals = new ArrayList<Ianimal>();
        this.clients = new ArrayList<Iclient>();
    }

    @Override
    public ArrayList<Ianimal> getAnimals() throws RemoteException {
        return null;
    }

    @Override
    public void addAnimal(Ianimal animal) throws RemoteException {
        this.animals.add(animal);

        if(animals.size() >= 100){
            for (Iclient client : this.clients) {
                client.alerte("Plus de 100 animaux dans le cabinet !\n");
            }
        }
    }

    @Override
    public void addAnimal(String nomAnimal, String nomMaitre, Iespece esp, String race, IdossierSuivi doss) throws RemoteException {
        Espece espece = new Espece();
        espece.setDureeVie(esp.getDureeVie());
        espece.setNomEspece(esp.getNomEspece());
        DossierSuivi dossier = new DossierSuivi();
        dossier.setEtat(doss.getEtat());
        Animal animal = new Animal(nomAnimal, nomMaitre, espece, race, dossier);

        this.animals.add(animal);

        if(animals.size() >= 100){
            for (Iclient client : this.clients) {
                client.alerte("Plus de 100 animaux dans le cabinet !\n");
            }
        }
    }

    @Override
    public void addAnimal(String nomAnimal, String nomMaitre, String espece, String race) throws RemoteException {
        Espece esp = new Espece(espece);
        DossierSuivi dos = new DossierSuivi("Stable");
        Animal animal = new Animal(nomAnimal, nomMaitre, esp, race, dos);
        this.animals.add(animal);
        if(animals.size() >= 100){
            for (Iclient client : clients) {
                client.alerte("Plus de 100 animaux dans le cabinet !\n");
            }
        }
    }

    @Override
    public Ianimal searchAnimal(String nomAnimal) throws RemoteException {
        for (int i = 0; i < this.animals.size(); i++) {
            try {
                if (this.animals.get(i).getNom().equals(nomAnimal)) {
                    return this.animals.get(i);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Animal inexistant dans le cabinet");
        return null;

    }

    @Override
    public void suprClient(Iclient client) throws RemoteException {
        for (int i = 0; i < clients.size(); i++) {
            if (client.equals(clients.get(i) )) {
                this.clients.remove(i);
            }
        }
    }

    @Override
    public void addClient(Iclient client) throws RemoteException {
        this.clients.add(client);
    }

}
