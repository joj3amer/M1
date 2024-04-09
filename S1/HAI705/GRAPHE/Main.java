import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Sommet s1 = new Sommet(1);
        Sommet s2 = new Sommet(2);
        Sommet s3 = new Sommet(3);
        //Sommet s4 = new Sommet(4);

        Arete a1 = new Arete(s1,s2);
        Arete a2 = new Arete(s2,s3);
        Arete a3 = new Arete(s3,s1);
        //Arete a4 = new Arete(s4,s1);
        //Arete a5 = new Arete(s3,s1);

        ArrayList<Arete> listeAreteInterference = new ArrayList<>();
        listeAreteInterference.add(a1);
        listeAreteInterference.add(a2);
        listeAreteInterference.add(a3);
        //listeAreteInterference.add(a4);
        //listeAreteInterference.add(a5);

        ArrayList<Sommet> listeSommet = new ArrayList<>();
        listeSommet.add(s1);
        listeSommet.add(s2);
        listeSommet.add(s3);
        //listeSommet.add(s4);

        Graphe graphe = new Graphe(listeSommet, listeAreteInterference);
        Main.colorationGraphe(graphe,2);
        System.out.println("Jul");

        JFrame frame = new JFrame("Graph Display");
        System.out.println("Jul");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Jul");
        frame.getContentPane().add(new GrapheAffichage(graphe));
        System.out.println("Jul");
        frame.pack();
        System.out.println("Jul");
        frame.setVisible(true);
        System.out.println("Jul");

    }

    private static void colorationGraphe(Graphe graphe, int nbColor){
        //colorationDeChaitin(graphe, nbColor);
        colorationGrapheOptimiste(graphe,nbColor);
    }

    private static void colorationGrapheOptimiste(Graphe graphe, int nbColor) {
        for(Sommet s : graphe.getSommets()){
            if(s.getcodeCouleur() == -1){
                for(int i = 1; i <= nbColor; i++){
                    if(graphe.Coloriable(s,i)){
                        s.setCouleur(i);
                    }
                }
            }
        }
    }

    private static void colorationDeChaitin(Graphe graphe, int nbreCouleur){

        if(!graphe.getSommets().isEmpty()) {
            boolean existeTrivialSommet = false;

            Sommet sommetTrivial = new Sommet(-1);
            for (Sommet s : graphe.getSommets()) {
                if (graphe.coloriageTrivial(s, nbreCouleur)) {
                    existeTrivialSommet = true;
                    sommetTrivial = s;
                    break;
                }
            }
            ArrayList<Sommet> newVertices;
            ArrayList<Arete> newArretesInterferences;
            ArrayList<Arete> newArretesPreferences;

            if (existeTrivialSommet) {

                newVertices = graphe.getNewSommet(sommetTrivial);
                newArretesInterferences = graphe.getNewInterferenceArete(sommetTrivial);
                newArretesPreferences = graphe.getNewPreferenceArete(sommetTrivial);
                colorationDeChaitin(new Graphe(newVertices, newArretesInterferences, newArretesPreferences), nbreCouleur);

                graphe.coloriageSommet(sommetTrivial, nbreCouleur);

            } else {

                Sommet plusHautDegre = new Sommet(-1);
                for (Sommet s : graphe.getSommets()) {
                    if (graphe.degreInterference(s) == graphe.maxDegre()) {
                        plusHautDegre = s;
                    }
                }

                newVertices = graphe.getNewSommet(plusHautDegre);
                newArretesInterferences = graphe.getNewInterferenceArete(plusHautDegre);
                newArretesPreferences = graphe.getNewPreferenceArete(plusHautDegre);
                colorationDeChaitin(new Graphe(newVertices, newArretesInterferences, newArretesPreferences), nbreCouleur);

            }
        }
    }
}
