public class Arete {
    private Sommet sommets[] = new Sommet[2];

    Arete(Sommet s1, Sommet s2){
        this.sommets[0] = s1;
        this.sommets[1] = s2;
    }

    public boolean estLieA(Sommet s) {
        return (sommets[0].equals(s)|| sommets[1].equals(s));
    }

    public Sommet[] getSommets() {
        return sommets;
    }
}
