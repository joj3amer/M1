import java.awt.*;

public class Sommet {
    private int name;
    private Color couleur = Color.WHITE;

    private int codeCouleur = -1;
    private Point location;

    public Sommet(int name) {
        this.name = name;
        this.location = new Point(0, 0); // Coordonnées par défaut (0, 0)
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void setLocation(int x, int y) {
        this.location = new Point(x, y);
    }

    public int getcodeCouleur() {
        return codeCouleur;
    }

    public void setCouleur(int codeCouleur){
        this.codeCouleur = codeCouleur;
        switch (codeCouleur) {
            case 1:
                this.couleur = Color.RED;
            case 2:
                this.couleur = Color.GREEN;
            case 3:
                this.couleur = Color.BLUE;
            case 4:
                this.couleur = Color.CYAN;
            default:
                this.couleur = Color.BLACK;
        }
    }
}