package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import client.*;
import serveur.Espece;

public interface Ianimal extends Remote{
    String getNom() throws RemoteException;
    String getNomMaitre() throws RemoteException;
    Espece getEspece() throws RemoteException;
    String getRace() throws RemoteException;
    IdossierSuivi getDossierSuivi() throws RemoteException;

}