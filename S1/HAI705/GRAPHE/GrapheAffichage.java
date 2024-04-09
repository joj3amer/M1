import javax.swing.*;
import java.awt.*;

public class GrapheAffichage extends JPanel {
    private Graphe graphe;
    public GrapheAffichage(Graphe graphe) {
        this.graphe = graphe;
        setPreferredSize(new Dimension(600, 400));

        // Disposition aléatoire des sommets
        for (Sommet sommet : graphe.getSommets()) {
            int x = (int) (Math.random() * 400) + 100; // Coordonnée x aléatoire entre 100 et 500
            int y = (int) (Math.random() * 300) + 50; // Coordonnée y aléatoire entre 50 et 350
            sommet.setLocation(x, y);
        }
    }

    private double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessiner les arêtes
        g.setColor(Color.BLACK);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));

        for (Arete arete : graphe.getInterferenceArete()) {
            Sommet sommet1 = arete.getSommets()[0];
            Sommet sommet2 = arete.getSommets()[1];

            Point p1 = sommet1.getLocation();
            Point p2 = sommet2.getLocation();

            g.drawLine(p1.x, p1.y, p2.x, p2.y); // Dessiner l'arête
        }

        // Dessiner les sommets
        int rayon = 20; // Rayon du cercle représentant le sommet

        for (Sommet sommet : graphe.getSommets()) {
            Point p = sommet.getLocation();

            int colorCode = sommet.getcodeCouleur();
            Color color = getColorFromCode(colorCode);

            g.setColor(color);
            g.fillOval(p.x - rayon, p.y - rayon, 2 * rayon, 2 * rayon); // Dessiner le cercle représentant le sommet
            g.setColor(Color.WHITE);
            g.drawString(Integer.toString(sommet.getName()), p.x - 3, p.y + 5); // Afficher le nom du sommet à l'intérieur du cercle
        }
    }

    private Color getColorFromCode(int colorCode) {
        // Définir une logique pour convertir le code de couleur en objet Color
        // Par exemple, vous pouvez utiliser un tableau de couleurs prédéfinies
        // ou implémenter une autre méthode qui attribue des couleurs en fonction du code

        // Exemple de conversion basée sur des codes prédéfinis

    }
}