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

   public int nbPointsChevalet (int[] nbPointsJet){
      int smax = 0;
      for(int i =0; i<nbPointsJet.length-1; i++){
         if(this.chevalet.regarde(i) > 0){
            smax += this.chevalet.regarde(i) * nbPointsJet[i];
         }
      }
      return smax ;
   }

   public void prendJetons (MEE s, int nbJetons) {
      this.chevalet = new MEE(7);
      for(int i = 0; i < nbJetons ; i++){
         this.chevalet.ajoute(s.retraitAleat());   
      }
   }

   public int joue(Plateau p, MEE s, int[] nbPointsJet) {
      int joue = 0;
      System.out.println("Choix 1: ne pas jouer, Choix 2: prendre des jetons, Choix 3: Placer un mot ");
      int Choix = Ut.saisirEntier();
      if(Choix > 3 && Choix < 0){
         while(Choix >3 && Choix < 0){
            System.out.println("Ce choix n'est pas possible");
            Choix = Ut.saisirEntier();
         }
      }
      if(Choix == 1){
         joue += -1; 
      }
      if(Choix == 2){
         if(this.chevalet.estVide()){
            joue += 1;
         }

      }
      if(Choix == 3){
         if(this.chevalet.estVide()){
            joue += 1;
         }

      }
      return joue;
   }

   public boolean joueMot(Plateau p, MEE s, int[] nbPointsJet) {
      char sens ="";
      int numLig = 0;
      int numCol =0;
      int mot[] ="";
      System.out.println("Choisir le sens du mot ");
      sens = Ut.saisirCharArray();
      System.out.println("Choisir une ligne");
      numLig = Ut.saisirEntier();
      System.out.println("Choisir une colonne");
      numCol = Ut.saisirEntier();
      System.out.println("Choisir un mot");
      mot = Ut.saisirCharArray();
}  