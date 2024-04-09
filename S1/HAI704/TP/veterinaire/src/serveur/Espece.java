package serveur;

import common.Iespece;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Espece extends UnicastRemoteObject implements Iespece{

    private int duree_vie;
    private String nom_espece;

    public Espece() throws RemoteException{

    }

    public Espece(String espece,int duree_vie) throws RemoteException{
        this.nom_espece = espece;
        this.duree_vie = duree_vie;
    }
    public Espece(String n) throws RemoteException{
        this.nom_espece = n;
        this.duree_vie = 14;
    }

    @Override
    public void setDureeVie(int duree_vie) {
        this.duree_vie = duree_vie;
    }

    @Override
    public void setNomEspece(String nom_espece) {
        this.nom_espece = nom_espece;
    }

    @Override
    public int getDureeVie() {
        return this.duree_vie;
    }

    @Override
    public String getNomEspece() {
        return this.nom_espece;
    }
}
