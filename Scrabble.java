import java.util.*;
public class Scrabble {
    private static int []nbPointsJeton = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 10, 1, 2, 1, 1, 3, 8, 1, 1, 1, 1, 4, 10, 10, 10, 10};
    private Joueur[] joueurs;
    private int numJoueur; // joueur courant (entre 0 et joueurs.length-1)
    private Plateau plateau;
    private MEE sac;

    public static void main (String[]args) {
        
    }



    public static String saisirChaine () {
        try (Scanner clavier = new Scanner(System.in)) {
        String s = clavier.nextLine();
        return s;
        }
    }
}
