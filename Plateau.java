public class Plateau {
    private Case [][] g;
    private static String []abscisse = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15"};
    private static String []ordonnee = {"A |", "B |", "C |", "D |", "E |", "F |", "G |", "H |", "I |", "J |", "K |", "L |", "M |", "N |", "O |", "P |"};

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_ROUGE = "\u001B[31m";
    public static final String ANSI_MAGENTA = "\u001B[35m";
    public static final String ANSI_BLEU = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLANC_BACKGROUND = "\u001B[47m";

    public Plateau() {
        int[][] plateau = {{5, 1, 1, 2, 1, 1, 1, 5, 1, 1, 1, 2, 1, 1, 5},
                          {1, 4, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 4, 1},
                          {1, 1, 4, 1, 1, 1, 2, 1, 2, 1, 1, 1, 4, 1, 1},
                          {2, 1, 1, 4, 1, 1, 1, 2, 1, 1, 1, 4, 1, 1, 2},
                          {1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1},
                          {1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1},
                          {1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1},
                          {5, 1, 1, 2, 1, 1, 1, 4, 1, 1, 1, 2, 1, 1, 5},
                          {1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1},
                          {1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1},
                          {1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1},
                          {2, 1, 1, 4, 1, 1, 1, 2, 1, 1, 1, 4, 1, 1, 2},
                          {1, 1, 4, 1, 1, 1, 2, 1, 2, 1, 1, 1, 4, 1, 1},
                          {1, 4, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 4, 1},
                          {5, 1, 1, 2, 1, 1, 1, 5, 1, 1, 1, 2, 1, 1, 5}};
        g = new Case [15][15];
        for (int i=0; i<plateau.length; i++) {
            for (int j=0; j<plateau[0].length; j++) {
                this.g[i][j] = new Case(plateau[i][j]);
            }
        }
    }
    public Plateau (Case[][] plateau) {
        this.g = plateau;
    }
    
    public String toString (){
    	/**
    	* resultat : chaine decrivant ce Plateau
    	*/
    	String plat = "";

        plat+="   ";
        for (int a = 0; a < g.length; a++) {
            plat += "|"+abscisse[a];
        }
        plat += "|";
        plat += "\n"+" ";
        for (int interligne = 0; interligne < g.length+1; interligne++) {
            plat += "__|";
        }
        plat += "\n";

    	for(int i = 0; i<this.g.length; i++) {
            plat += "|"+ordonnee[i];
    		for(int j = 0;j<this.g[i].length; j++) {
    			if(g[i][j].estRecouverte()) {
    				plat += g[i][j].getLettre();
    			}
                else{
                    if(g[i][j].getCouleur() == 1){
                        plat += "  ";
                    }
                    else{
                        plat += g[i][j].getCouleur()+" ";
                    }
                }
                plat += "|";
    		}
            plat += "\n";
    	}
        for (int interligne = 0; interligne < g.length+1; interligne++) {
            plat += "---";
        }
        plat += "\n";
        return plat;
    }

    public boolean placementValide(String mot, int numLigne, int numCol, char sens, MEE e){
        /**
        * pré-requis : mot est un mot accepté par CapeloDico,
        * 0 <= numLig <= 14, 0 <= numCol <= 14, sens est un élément
        * de {’h’,’v’} et l’entier maximum prévu pour e est au moins 25
        * résultat : retourne vrai ssi le placement de mot sur this à partir
        * de la case (numLig, numCol) dans le sens donné par sens à l’aide
        * des jetons de e est valide.
        */
        if (mot.length()>=2) {
            if (sens == 'H') { // si lettre minuscule, la mettre en maj
                for (int i=0; !this.g[numCol][numLigne+i].estRecouverte(); i++) {
                    if (numLigne <= 14 && numLigne >= 0) {
                        if (i == mot.length()-1) {
                         return true;
                        }
                    }
                }
            }
            else if (sens =='V') {
                for (int i=0; !this.g[numCol+i][numLigne].estRecouverte(); i++) {
                    if (numCol <= 14 && numCol >= 0) {
                        if (i == mot.length()-1) {
                         return true;
                        }
                    }
                }
            }
            else {
                return false;
            }
            //int m[] = new [];
            //m[] = this.mot.toCharArray();
        }
        return false;

    }

    //public int nbPointsPlacement(String mot, int numLig, int numCol, char sens, int[] nbPointsJet) {
        /**
        * pré-requis : le placement de mot sur this à partir de la case
        * (numLig, numCol) dans le sens donné par sens est valide
        * résultat : retourne le nombre de points rapportés par ce placement, le
        * nombre de points de chaque jeton étant donné par le tableau nbPointsJet.
        */

    //}

    //public int place(String mot, int numLig, int numCol, char sens, MEE e){
        /**
        * pré-requis : le placement de mot sur this à partir de la case
        * (numLig, numCol) dans le sens donné par sens à l’aide des
        * jetons de e est valide.
        * action/résultat : effectue ce placement et retourne le
        * nombre de jetons retirés de e.
        */
    //}


}