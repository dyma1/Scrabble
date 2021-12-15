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
    boolean retire (int i) {
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
        int i=Ut.randomMinMax(tabFreq[0], tabFreq.length);
        retire(i);
        return i;
    }
    public boolean transfert (MEE e, int i) {
        /**
        * pré-requis : 0 <= i < tabFreq.length
        * action/résultat : transfère un exemplaire de i de this vers e s’il
        * en existe, et retourne vrai ssi cette action a pu être effectuée*/
        if (this.tabFreq[i] > 0) {
            this.tabFreq[i]--;
            nbTotEx--;
            e.tabFreq[i]++;
            e.nbTotEx++;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean transfertAleat (MEE e, int k) {
        k=Ut.randomMinMax(tabFreq[0], tabFreq.length);
        if (this.tabFreq[k] > 0) {
            nbTotEx--;
            this.tabFreq[k]--;
            e.tabFreq[k]++;
            e.nbTotEx++;
            return true;
        }
        else {
            return false;
        }
    }
}
