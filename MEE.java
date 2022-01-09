import java.util.*;
public class MEE {
    //Attributs
    private int[] tabFreq;// tabFreq[i] est le nombre d’exemplaires(fréquence) de l’élément i
    private int nbTotEx; // nombre total d'exemplaires

    //Constructeurs
    public MEE (int max) {
        /**
        * pré-requis : max >= 0
        * action : crée un multi-ensemble vide dont les éléments seront
        * inférieurs à max*/
        this.tabFreq = new int[max];
        this.nbTotEx=0;
    }
    public MEE (int []tab) {
        int co = 0;
        for (int i=0; i<this.tabFreq.length-1;i++){
            this.tabFreq[i]=tab[i];
        }
        for (int j=0; j<this.tabFreq.length-1;j++){
            co += tabFreq[j];
        }
        this.nbTotEx=co;
    }
    public MEE (MEE e) {
        this.tabFreq=e.tabFreq;
        this.nbTotEx=e.nbTotEx;
    }

    //Méthodes
    private static int randomMinMax(int min, int max) {
        // Resultat : un entier entre min et max choisi aleatoirement
        Random rand = new Random();
        int res = rand.nextInt(max - min + 1) + min;
        // System.out.println(res + " in [" + min + "," + max + "]");
        // assert min <= res && res <= max : "tirage aleatoire hors des bornes";
        return res;
    }
    public boolean estVide() {
        return this.nbTotEx==0;
    }
    public void ajoute (int i) {
        /**
        * pré-requis : 0 <= i < tabFreq.length
        * action : ajoute un exemplaire de i à this
        */
        this.tabFreq[i]++;
        nbTotEx++;
    }
    public boolean retire (int i) {
        /**
        * pré-requis : 0 <= i < tabFreq.length
        * action/résultat : retire un exemplaire de i de this s’il en existe,
        * et retourne vrai ssi cette action a pu être effectuée
        */
        if (this.tabFreq[i]>0) {
            this.tabFreq[i]--;
            nbTotEx--;
            return true;
        }
        else {
            return false;
        }
    }
    public int retraitAleat () {
        /**
        * pré-requis : this est non vide
        * action/résultat : retire de this un exemplaire choisi aléatoirement
        * et le retourne*/
        int j =0;
        boolean test = true;
        while (test){
            int i = randomMinMax(this.tabFreq[0], this.tabFreq.length-1);
            if(i>0){
                retire(i);
                j = i;
                test=false;
            }
        }
        return j;
    }
    public boolean transfert (MEE e, int i) {
        /**
        * pré-requis : 0 <= i < tabFreq.length
        * action/résultat : transfère un exemplaire de i de this vers e s’il
        * en existe, et retourne vrai ssi cette action a pu être effectuée*/
        if (this.tabFreq[i] > 0) {
            this.tabFreq[i]--;
            this.nbTotEx--;
            e.tabFreq[i]++;
            e.nbTotEx++;
            return true;
        }
        else {
            return false;
        }
    }
    public int regarde(int i){
        return this.tabFreq[i];
    }
    public boolean transfertAleat (MEE e, int k) {
        k= randomMinMax(tabFreq[0], tabFreq.length-1);
        if (this.tabFreq[k] > 0) {
            this.tabFreq[k]--;
            this.nbTotEx--;
            e.tabFreq[k]++;
            e.nbTotEx++;
            return true;
        }
        else {
            return false;
        }
    }
    public int sommeValeurs (int []v) {
        /**
        * pré-requis : tabFreq.length <= v.length
        * résultat : retourne la somme des valeurs des exemplaires des
        * éléments de this, la valeur d’un exemplaire d’un élément i
        * de this étant égale à v[i]*/
        int total=0;
        for(int i = 0; i<v.length-1; i++) {
            total+=this.tabFreq[i]*v[i];    
        }
        return total;
    }
}