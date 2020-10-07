package Puissance4IA;


import java.util.Stack;

import Puissance4A2joueurs.Pion;
import Puissance4A2joueurs.Position;
import Puissance4A2joueurs.Puissance4;

/**
 * <b>Grille est la classe permettant de représenter et d'utiliser une grille d'un puissance 4.</b>
 * 
 * <p>
 *		Une grille est représentée par :
 *		<ul>
 *			<li> un tableau "grille" à deux dimensions de Pions représentant l'état actuel
 *					de la grille du jeu.
 *			</li>
 *			<li> le nombre de Pions "nbPionsDisponible" pouvant encore être placé
 *					sur la grille.
 *			</li>
 *			<li> un tableau "prochainCoup" dont la i-ième entrée indique l'ordonnée
 *					du prochain Pion joué dans la colonne i de la grille.
 *			</li>
 *			<li> une pile "historique" représentant l'ensemble des coups qui ont été joués.
 *			</li>
 *		</ul>
 * </p>
 * 
 * @author ???
 * 
 * @version 1.0
 */
public class Grille {
	/**
    * La grille de Pions représentant l'état actuel de la grille du jeu.
    */	
	private Pion[][] grille;

	/**
    * Le nombre de pions encore disponibles.
    */	
	private int nbPionsDisponible;

	/**
    * Un tableau d'entiers dont la i-ième entrée indique l'ordonnée
    * du prochain Pion joué dans la i-ième colonne de la grille.
    */	
	private int[] prochainsCoups;

	/**
     * L'historique de la partie de jeu.
     */	
	private Stack<Position> historique;
	
	/**
     * La position du dernier coup joué.
     */	
	private Position dernierCoup;
	
	
    /**
     * <p>
     * 		A la construction d'une grille, le tableau représentant l'attribut "grille"
     * 		est juste alloué, mais pas initialisé. Ainsi, une case de ce tableau sera
     * 		"null" si aucun pion n'est placé, et sera un objet de type Pion lorsqu'un
     * 		pion y a été placé.
     * </p>
     * 
     * @see Grille#grille
     * @see Grille#prochainsCoups
     * @see Grille#nbPionsDisponible
     * 
     */
	public Grille() {
		this.grille =  new Pion[7][6];
		this.nbPionsDisponible = Puissance4.dimensionH; 
		this.prochainsCoups = new int[Puissance4.dimensionH];
	}

	/**
     * Retourne la grille courante du jeu.
     * 
     * @return Le nombre la grille courante du jeu.
     * 
     * @see Grille#grille
     */
	public Pion[][] getGrille() {
		
		return this.grille;
	}

	/**
     * Retourne le dernier coup effectué.
     * 
     * N'est utilisé que dans les tests unitaires.
     * 
     * @return Le dernier coup effectué.
     * 
     * @see Grille#historique
     */
	public Position getDernierCoup() {
		
		return this.dernierCoup;
	}

	/**
     * Retourne le nombre de pions encore disponibles.
     * 
     * @return Le nombre de pions encore disponibles.
     * 
     * @see Grille#nbPionsDisponible
     */
	public int getNbPionsDisponible() {
		
		return this.nbPionsDisponible;
	}

	/**
     * Retourne le tableau "prochainsCoups" dont la i-ième entrée indique l'ordonnée
     * du prochain Pion joué dans la i-ième colonne de la grille
     * 
     * @return Le tableau "prochainsCoups" dont la i-ième entrée indique l'ordonnée
     * du prochain Pion joué dans la i-ième colonne de la grille.
     * 
     * @see Grille#prochainsCoups
     */
	public int[] getProchainsCoups() {
		
		return this.prochainsCoups;
	}

	/**
     * Retourne la pile contenant l'historique de la partie.
     * 
     * @return La pile contenant l'historique de la partie
     * 
     * @see Grille#historique
     */
	/*public Stack<Position> getHistorique() {
		
		
	}*/

	/**
     * Retourne une chaine de caractère représentant la grille.
     * 
     * @return Une chaine de caractère représentant la grille.
     */
	@Override
	public String toString() {
		StringBuilder chaine = new StringBuilder();
		for(int y=Puissance4.dimensionV-1; y>=0; y--){  
			for(int x=0; x <= Puissance4.dimensionH-1; x++){
				if(y!= 0){
					if (x==0)
						chaine.append ("|");
					if(this.grille[x][y] == null)
						chaine.append ("  ") ;
					else
						chaine.append (this.grille[x][y]);
					if(x==Puissance4.dimensionH-1)
						chaine.append ("|\n");
				}
				else{
					if (x==0)
						chaine.append ("|");
					if(this.grille[x][y] == null)
						chaine.append ("__") ;
					else
						chaine.append (this.grille[x][y]);
					if(x==Puissance4.dimensionH-1)
						chaine.append ("|\n");
				}
			}
		}
		chaine.append (" 0 1 2 3 4 5 6  \n");
		return chaine.toString();
	}
	
    /**
     * Teste si un coup est valide, c'est-à-dire à l'intérieur de la grille de jeu,
     * et dans une colonne qui n'est pas encore pleine.
     * 
     * @param coup
     *			Entier désignant la colonne où le coup demandé aura lieu.
     * 
     * @return Booléen répondant à "le coup proposé est il possible ?"
     */
	public boolean estCoupValide(int coup) {
		
		if((nbPionsDisponible == 0) || (coup >= Puissance4.dimensionH) || (coup >= Puissance4.dimensionV) || (prochainsCoups[coup] == Puissance4.dimensionV) || (coup < 0))   //exemple pour 7 colonne (0 1 2 3 4 5 6)
			return false;														  				// et une hauteur de 6 (0 1 2 3 4 5)
		else
			return true;
	}

    /**
     * Représente le coup d'un joueur dans la grille, et effectue tous les traitements
     * de mise à jour nécessaire :
     * <ul>
     * 		<li> la grille est mis à jour ;</li>
     * 		<li> le nombre de pion disponible diminue ;</li>
     * 		<li> le tableau "dernierCoup" est mis à jour ;</li>
     * 		<li> l'historique de la partie est mis à jour.</li>
     * </ul>
     * 
     * @param coupAJouer
     *			Entier désignant la colonne où le coup demandé aura lieu.
     *
     * @param joueur
     * 			Objet de type Joueur indiquant quel est le joueur réalisant le coup demandé.
     */
	public void joueCoup(int coupAJouer, Joueur joueur) {
		
		this.nbPionsDisponible--;
		this.grille[coupAJouer][this.prochainsCoups[coupAJouer]]= new Pion(joueur.getCouleur());
		this.dernierCoup = new Position(coupAJouer, this.prochainsCoups[coupAJouer]);
		this.prochainsCoups[coupAJouer]++;
	}

	/**
     * Annule le dernier coup joué dans la grille, et effectue tous les traitements
     * de mise à jour nécessaire :
     * <ul>
     * 		<li> la grille est mis à jour ;</li>
     * 		<li> le nombre de pion disponible augmente ;</li>
     * 		<li> le tableau "dernierCoup" est mis à jour ;</li>
     * 		<li> l'historique de la partie est mis à jour.</li>
     * </ul>
     * 
     * @param void
     */
	public void annuleDernierCoup() {
		
		this.nbPionsDisponible++;
		
	}
	
	/**
	 * <p>Teste si la grille courante est gagnante.</p>
	 * 
	 * Cette méthode est appelée après chaque nouveau pion positionné sur la grille.
	 * Il suffit donc de tester si ce pion appartient à un alignement de quatres pions
	 * de la même couleur et évite de parcourir la grille entière.
	 * 
	 * @param dernierJoueur
	 * 			Objet de type Joueur indiquant le dernier joueur à avoir joué
	 * 
     * @return Booléen répondant à "le dernier joueur vient-il de gagner ?", ce qui est
     * 				équivalent à la question "la grille est-elle gagnante ?"
	 */
	public boolean estGrilleGagnante(Joueur dernierJoueur) {
		int indice = 1; //compte le nombre total de pion de même couleur
		int compteur = 1;//Utiliser dans la vérification des couleurs, se remet à un si la couleur change
		int flag = 0;
		
		//alignement horizontal
		while(indice < 4 && ((this.dernierCoup.getX()+compteur) < Puissance4.dimensionV) && flag==0){
			if(this.grille[this.dernierCoup.getX()+compteur][this.dernierCoup.getY()]!=null){
				if(this.grille[this.dernierCoup.getX()+compteur][this.dernierCoup.getY()].getCouleur() == dernierJoueur.getCouleur()){
					indice++;
					compteur++;
				}
				else 
					flag=1;
			}
			else
				flag=1;
		}
		if (indice == 4)
			return true;
		
		compteur = 1;
		flag=0;
		
		while((indice < 4) && (this.dernierCoup.getX()-compteur >= 0) && flag==0){ //test a droite du pionJoue
			if(this.grille[this.dernierCoup.getX()-compteur][this.dernierCoup.getY()]!=null){
				if (this.grille[this.dernierCoup.getX()-compteur][this.dernierCoup.getY()].getCouleur() == dernierJoueur.getCouleur()){
					indice++;
					compteur++;
				}
				else
					flag=1;
			}
			else
				flag=1;
		}
		
		if(indice == 4){
			return true;
		}
		
		else{
			flag=0;
			indice = 1;
			compteur = 1;
			while(indice < 4 && ((this.dernierCoup.getY()+compteur) < Puissance4.dimensionH) && flag==0){
				if(this.grille[this.dernierCoup.getX()][this.dernierCoup.getY()+compteur]!=null){
					if (this.grille[this.dernierCoup.getX()][this.dernierCoup.getY()+compteur].getCouleur() == dernierJoueur.getCouleur()){
						indice++;
						compteur++;
					}
					else 
						flag=1;
				}
				else
					flag=1;
			}
			if (indice == 4)
				return true;
			
			compteur = 1;
			flag=0;
			
			while((indice < 4) && (this.dernierCoup.getY()-compteur >= 0) && flag==0){ //test a droite du pionJoue
				if(this.grille[this.dernierCoup.getX()][this.dernierCoup.getY()-compteur]!=null){
					if (this.grille[this.dernierCoup.getX()][this.dernierCoup.getY()-compteur].getCouleur() == dernierJoueur.getCouleur()){
						indice++;
						compteur++;
					}
					else
						flag=1;	
				}
				else
					flag=1;
			}
			
			if(indice == 4){
				return true;
			}
			
			// pour diagonal
			else{
				flag=0;
				indice=1;
				compteur=1;
				while((indice < 4) && (this.dernierCoup.getX() +compteur) < Puissance4.dimensionH && (this.dernierCoup.getY() +compteur) < Puissance4.dimensionV && flag==0){
					if(this.grille[this.dernierCoup.getX()+compteur][this.dernierCoup.getY()+compteur]!=null){
						if (this.grille[this.dernierCoup.getX()+compteur][this.dernierCoup.getY()+compteur].getCouleur() == dernierJoueur.getCouleur()){
							indice++;
							compteur++;
						}
						else 
							flag=1;
					}
					else 
						flag=1;
				}
		
				compteur = 1;
				flag=0;
				
				while((indice < 4) && (this.dernierCoup.getX() -compteur) >= 0 && (this.dernierCoup.getY() -compteur) >= 0 && flag==0){
					if(this.grille[this.dernierCoup.getX()-compteur][this.dernierCoup.getY()-compteur]!=null){
						if (this.grille[this.dernierCoup.getX()-compteur][this.dernierCoup.getY()-compteur].getCouleur() == dernierJoueur.getCouleur()){
							indice++;
							compteur++;
						}
						else 
							flag=1;
					}
					else flag=1;
				}
				if(indice == 4)
					return true;
				else{
					flag=0;
					indice=1;
					compteur=1;
					while((indice < 4) && ((this.dernierCoup.getX() +compteur) < Puissance4.dimensionH) && ((this.dernierCoup.getY() -compteur) >=0) && flag==0){ //test a droite du pionJoue
						if(this.grille[this.dernierCoup.getX()+compteur][this.dernierCoup.getY()-compteur]!=null){
							if (this.grille[this.dernierCoup.getX()+compteur][this.dernierCoup.getY()-compteur].getCouleur() == dernierJoueur.getCouleur()){
								indice++;
								compteur++;
							}
							else 
								flag=1;
						}
						else
							flag=1;
					}
					compteur = 1;
					flag=0;
	
					while((indice < 4) && ((this.dernierCoup.getX() -compteur) >= 0) && ((this.dernierCoup.getY() +compteur) < Puissance4.dimensionV) && flag==0){ //test a droite du pionJoue
						if(this.grille[this.dernierCoup.getX()-compteur][this.dernierCoup.getY()+compteur]!=null){
							if (this.grille[this.dernierCoup.getX()-compteur][this.dernierCoup.getY()+compteur].getCouleur() == dernierJoueur.getCouleur()){
								indice++;
								compteur++;
							}
							else 
								flag=1;
						}
						else
							flag=1;
					}
					if(indice == 4)
						return true;
					else
						return false;
				}
			}
		}
	}

	/**
	 * <p>
	 * 		D'une position <code>position</code> et de directions <code>directionX</code> et <code>directionY</code>,
	 * 		détermine si celle peut être la position initiale d'un alignement gagnant,
	 * 		et si oui, détermine combien de pions sont déjà dans cet alignement.
	 * </p>
	 * 
	 * @param evaluationGrille
	 * 			Objet de type int[][] permettant d'évaluer la grille : il est mis à jour à l'issue de la méthode et contient
	 * 			le nombre d'alignements actuels de 1, 2, 3 ou 4 pions se trouvant dans la grille pour les deux joueurs.
	 * 
	 * @param position
	 * 			Objet de type Position donnant la position initiale de l'alignement
	 * 
	 * @param directionX
	 * 			Entier indiquant le pas dx d'un pion à un autre selon l'axe des abcisses, donc prend ses valeurs parmi -1, 0 et 1.
	 * 
	 * @param directionY
	 * 			Entier indiquant le pas dy d'un pion à un autre selon l'axe des ordonnées, donc prend ses valeurs parmi -1, 0 et 1.
	 * 
     * @return void : le tableau evaluationGrille est mis à jour à l'issue de l'appel de la méthode.
	 */
	public void evaluePositionDansDirection(int[][] evaluationGrille, Position position, int directionX, int directionY) {
	}

	/**
	 * <p>
	 * 		Evalue les alignements potentiellement gagnants émanant d'une position <code>position</code>.
	 * </p>
	 * 
	 * @param evaluationGrille
	 * 			Objet de type int[][] permettant d'évaluer la grille : il est mis à jour à l'issue de la méthode et contient
	 * 			le nombre d'alignements actuels de 1, 2, 3 ou 4 pions se trouvant dans la grille pour les deux joueurs.
	 * 
	 * @param position
	 * 			Objet de type Position donnant la position initiale de l'alignement
	 * 
	 * @param directionX
	 * 			Entier indiquant le pas dx d'un pion à un autre selon l'axe des abcisses, donc prend ses valeurs parmi -1, 0 et 1.
	 * 
	 * @param directionY
	 * 			Entier indiquant le pas dy d'un pion à un autre selon l'axe des ordonnées, donc prend ses valeurs parmi -1, 0 et 1.
	 * 
     * @return void : le tableau evaluationGrille est mis à jour à l'issue de l'appel de la méthode.
	 */
	public void evaluePosition(int[][] evaluationGrille, Position position) {
	}
	
	/**
	 * <p>
	 * 		Evalue toutes les position d'une grille de jeu de Puissance 4, pour avoir une vision globale de celle-ci.
	 * </p>
	 * 
	 * @throws GrilleGagnanteException
	 * 			Lorsque la grille est gagnante pour l'un des deux joueurs, l'exception est levée
	 * 
     * @return un tableau indiquant le nombre d'alignements (pouvant encore devenir gagnant) de 1, 2, 3 ou 4 pions
     * 				 se trouvant dans la grille pour les deux joueurs.
     * 
     * @see GrilleGagnanteException
	 */
	/*private int[][] evalueGrille() throws GrilleGagnanteException {
	}*/	
	/**
	 * <p>
	 * 		Evalue globalement une grille de jeu de Puissance 4.
	 * </p>
	 * 
	 * @throws GrilleGagnanteException
	 * 			Lorsque la grille est gagnante pour l'un des deux joueurs, l'exception est levée
	 * 
     * @return un tableau indiquant le nombre d'alignements (pouvant encore devenir gagnant) de 1, 2, 3 ou 4 pions
     * 			se trouvant dans la grille pour les deux joueurs.
     * 
     * @see GrilleGagnanteException
	 */
	/*public int evalueGrille(Joueur joueur) throws GrilleGagnanteException {
	}*/
}