import java.util.ArrayList;

public class Graphe {

    private ArrayList<Sommet> sommets;
    private ArrayList<Arete> interferenceArete;
    private ArrayList<Arete> preferenceArete;

    Graphe(ArrayList<Sommet> sommets, ArrayList<Arete> interferences, ArrayList<Arete> preferences){
        preferenceArete = preferences;
        interferenceArete = interferences;
        this.sommets = sommets;
    }

    Graphe(ArrayList<Sommet> sommets, ArrayList<Arete> interferences){
        preferenceArete = new ArrayList<>();
        interferenceArete = interferences;
        this.sommets = sommets;
    }

    public int degreInterference(Sommet s) {
        int count = 0;
        for (Arete a : interferenceArete) {
            if (a.estLieA(s)) {
                count++;
            }
        }
        return count;
    }

    public int maxDegre(){
        int max = 0;
        for(Sommet s : sommets){
            if(degreInterference(s) > max){
                max = degreInterference(s);
            }
        }
        return max;
    }

    public boolean coloriageTrivial(Sommet s, int nbColor){
        return degreInterference(s) < nbColor;
    }

    public ArrayList<Sommet> getNewSommet(Sommet Sommet) {
        ArrayList<Sommet> res = new ArrayList<>();
        for(Sommet s : sommets){
            if(!s.equals(Sommet)){
                res.add(s);
            }
        }
        return res;
    }

    public ArrayList<Arete> getNewInterferenceArete(Sommet sTrivial) {
        ArrayList<Arete> res = new ArrayList<>();
        for(Arete a : interferenceArete){
            if(!a.estLieA(sTrivial)){
                res.add(a);
            }
        }
        return res;
    }

    public ArrayList<Arete> getNewPreferenceArete(Sommet sTrivial) {
        ArrayList<Arete> res = new ArrayList<>();
        for(Arete a : preferenceArete){
            if(!a.estLieA(sTrivial)){
                res.add(a);
            }
        }
        return res;
    }

    public void coloriageSommet(Sommet sTrivial, int nbColor) {
        if(prefCouleur(sTrivial) != -1 && Coloriable(sTrivial, prefCouleur(sTrivial))){
            sTrivial.setCouleur(prefCouleur(sTrivial));
        } else {
            for (int i = 1; i <= nbColor; i++) {
                if(Coloriable(sTrivial,i)){
                    sTrivial.setCouleur(i);
                    break;
                }
            }
        }
    }

    public boolean Coloriable(Sommet sTrivial, int color){
        for(Arete a : interferenceArete){
            if(a.estLieA(sTrivial)){
                if(a.getSommets()[0].getcodeCouleur() == color||a.getSommets()[1].getcodeCouleur() == color){
                    return false;
                }
            }
        }
        return true;
    }

    private int prefCouleur(Sommet sTrivial){
        for(Arete a : preferenceArete){
            if(a.estLieA(sTrivial)){
                if(a.getSommets()[0].equals(sTrivial)){
                    if(a.getSommets()[1].getcodeCouleur() != -1){
                        return a.getSommets()[1].getcodeCouleur();
                    }
                } else {
                    if(a.getSommets()[0].getcodeCouleur() != -1){
                        return a.getSommets()[0].getcodeCouleur();
                    }
                }
            }
        }
        return -1;
    }

    public ArrayList<Sommet> getSommets() {
        return sommets;
    }

    public ArrayList<Arete> getInterferenceArete() {
        return interferenceArete;
    }
}