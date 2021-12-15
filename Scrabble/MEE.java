package Scrabble;

public class MEE {
    //Attributs
    private int[] tabFreq;
    private int nbTotEx; // nombre total d'exemplaires

    //Constructeurs
    public MEE (int max) {
        /**
        * pré-requis : max >= 0
        * action : crée un multi-ensemble vide dont les éléments seront
        * inférieurs à max*/
        this.tabFreq = new int[max];
    }
    public MEE (int []tab) {
        for (int i=0; i<this.tabFreq.length;i++) {
            this.tabFreq[i]=tab[i];
        }
    }
    public MEE (MEE e) {
        this.tabFreq=e.tabFreq;
        this.nbTotEx=e.nbTotEx;
    }

    //Méthodes
    //public int sommeValeurs (int []v) {
        /*
        prérequis : v.length >=this.tabFreq.length
        résultat : retourne la somme des valeurs des exemplaires des éléments de this,
        la valeur d'un exemplaire d'un élément étant v[i] 
        Exemple : si this est un ensemble de jetons et v = nbPointsLettres, la fx retourne */

    //}

    public static MEE getNbTotEx () {
        return MEE.getNbTotEx();
    }
    public boolean estVide() {
        return this.tabFreq.length==0;
    }
    public void ajoute (int i) {
        /**
        * pré-requis : 0 <= i < tabFreq.length
        * action : ajoute un exemplaire de i à this
        */
        this.tabFreq[i]++;
        nbTotEx++;
    }
}
