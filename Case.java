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
        return this.lettre; // il faut que ce soit une lettre majuscule
    }
    public void setLettre(char let) {
        //verifier que la lettre est en majuscule
        this.lettre=let;
        this.recouverte=true;
    }
    public boolean estRecouverte() {
        return this.recouverte;
    }
    public String toString(){
        if(this.recouverte == false){
            return ("La case n'est pas recouverte");
        }
        else {
            return ("La case est recouverte par la lettre numéro "+this.lettre+" et par la couleur "+this.couleur);
        }
    }   
}