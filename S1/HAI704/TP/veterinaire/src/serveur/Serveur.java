package serveur;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public Serveur(){}
    public static void main(String[] args) {
        try{
            DossierSuivi dossier_rex = new DossierSuivi("BON");
            Espece espece_chien = new Espece();
            Animal chien = new Animal("Rex","Job",espece_chien,"Malinois",dossier_rex);
            //dossier_rex.addAnimal(chien);
            Registry registry = LocateRegistry.createRegistry(1099);
            if (registry==null){
                System.err.println("Rmi_Registry not found");
            }else{
                registry.rebind("dossier_rex",dossier_rex);
                registry.rebind("chien1",chien);
                System.err.println("Serveur pret.");
            }
        }catch (Exception e){
            System.err.println("Serveur exception : "+e.toString());
            e.printStackTrace();
        }
    }
}