package common;

import serveur.Animal;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IdossierSuivi extends Remote {
    String getEtat() throws RemoteException;

    //void addAnimal(Animal animal) throws RemoteException;

    void setEtat(String etat);
}
