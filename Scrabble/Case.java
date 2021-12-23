package Scrabble;
public class Case {
    private int couleur;
    private char lettre;
    public boolean recouverte;
    public Case (int uneCouleur) {
        /**
        * pré-requis : uneCouleur est un entier entre 1 et 5
        * action : constructeur de Case*/
        this.couleur = uneCouleur;
        this.lettre = 0;
        this.recouverte = false;
    }
    public int getCouleur() {
        return this.couleur;
    }
    public char getLettre () {
        return this.lettre;
    }
}
