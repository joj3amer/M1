package common;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Icabinet {
    ArrayList<Ianimal> getAnimals() throws RemoteException;

    void addAnimal(Ianimal animal) throws RemoteException;

    void addAnimal(String nomAnimal, String nomMaitre, Iespece esp, String race, IdossierSuivi doss) throws RemoteException;

    void addAnimal(String nomAnimal, String nomMaitre, String espece, String race) throws RemoteException;

    Ianimal searchAnimal(String nomAnimal) throws RemoteException;

    public void suprClient(Iclient client) throws RemoteException;

    public void addClient(Iclient client) throws RemoteException;

}