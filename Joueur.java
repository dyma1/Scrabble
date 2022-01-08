public class Joueur {

   private int score ;
   private MEE chevalet ;
   private String nom ;

   public Joueur(String unNom){
      this.nom = unNom;
      this.score = 0;
      this.chevalet = new MEE(7);
   }

   public int getScore(){
      return this.score;
   }

   public void ajouteScore(int nb){
      this.score += nb;
   }

   /*public int nbPointsChevalet (int[] nbPointsJet){
      int smax = 0;
      for(int i =0; i<nbPointsJet.length-1; i++){
         if(chevalet[i] > 0){
            smax += chevalet[i] * nbPointsJet[i];
         }
      }
      return smax ;
   }*/

   public void prendJetons (MEE s, int nbJetons) {
      this.chevalet = new MEE(7);
   }



}