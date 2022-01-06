public class Plateau {
    
    private Case [][] g;

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
    	* r�sultat : cha�ne d�crivant ce Plateau
    	*/
    	String plat = "";
    	for(int i = 0; i<this.g.length; i++) {
            plat += "|";
    		for(int j = 0;j<this.g[i].length; j++) {
    			if(g[i][j].estRecouverte()) {
    				plat += g[i][j].getLettre();
                    
    			}
                else{
                    if(g[i][j].getCouleur() == 1){
                        plat += " ";
                    }
                    else{
                        plat += g[i][j].getCouleur();
                    }
                }
                plat += "|";
    		}
            plat += "\n";
    	}
        return plat;
    }

    public boolean placementValide(String mot, int numLigne, int numCol, char sens, MEE e){
        /**
        * pré-requis : le placement de mot sur this à partir de la case
        * (numLig, numCol) dans le sens donné par sens est valide
        * résultat : retourne le nombre de points rapportés par ce placement, le
        * nombre de points de chaque jeton étant donné par le tableau nbPointsJet.
        */
        int m[] = new []; 
        m[] = this.mot.toCharArray();

    }

    public int nbPointsPlacement(String mot, int numLig, int numCol, char sens, int[] nbPointsJet) {
        /**
        * pré-requis : le placement de mot sur this à partir de la case
        * (numLig, numCol) dans le sens donné par sens est valide
        * résultat : retourne le nombre de points rapportés par ce placement, le
        * nombre de points de chaque jeton étant donné par le tableau nbPointsJet.
        */

    }

    public int place(String mot, int numLig, int numCol, char sens, MEE e){
        /**
        * pré-requis : le placement de mot sur this à partir de la case
        * (numLig, numCol) dans le sens donné par sens à l’aide des
        * jetons de e est valide.
        * action/résultat : effectue ce placement et retourne le
        * nombre de jetons retirés de e.
        */
    }


}