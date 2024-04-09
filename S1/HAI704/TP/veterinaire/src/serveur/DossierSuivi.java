package serveur;

import common.IdossierSuivi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DossierSuivi extends UnicastRemoteObject implements IdossierSuivi {
    private String etat;
    public DossierSuivi() throws RemoteException{}
    public DossierSuivi(String etat) throws RemoteException{
        this.etat = etat;
    }
    @Override
    public String getEtat() throws RemoteException{
        return this.etat;
    }
    //@Override
    //public void addAnimal(Animal animal) throws RemoteException {
    //}

    @Override
    public void setEtat(String etat) {
        this.etat = etat;
    }
}
