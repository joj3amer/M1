package client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import common.*;

public class Client extends UnicastRemoteObject implements Iclient{
    private Client() throws RemoteException{}

    public static void main(String[] args){
        try{
            Registry registry = LocateRegistry.getRegistry(1099);
            Ianimal stub = (Ianimal) registry.lookup("chien1");
            IdossierSuivi stub2 = (IdossierSuivi) registry.lookup("dossier_rex");
            String dossier_rex = stub.getDossierSuivi().getEtat();
            System.out.println(dossier_rex);
        }catch(Exception e){
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }

    @Override
    public void alerte(String message) throws RemoteException {

    }
}