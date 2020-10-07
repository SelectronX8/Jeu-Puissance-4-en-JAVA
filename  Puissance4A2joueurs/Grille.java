package Puissance4A2joueurs;
/**
 * <b>Grille est la classe permettant de représenter et d'utiliser une grille d'un puissance 4.</b>
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
 *			<li> une Position "dernierCoup" afin de garder en mémoire le dernier coup
 *					joué sur la grille.
 *			</li>
 *		</ul>
 * </p>
 * 
 * @author Siva SARAVANANE
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
     */
	
	public Grille() {
		this.grille =  new Pion[Puissance4.dimensionH][Puissance4.dimensionV];
		this.nbPionsDisponible = Puissance4.dimensionH * Puissance4.dimensionV;
		this.prochainsCoups = new int[Puissance4.dimensionH];
	}

	/**
     * Retourne la grille courante du jeu.
     * 
     * @return Le nombre la grille courante du jeu.
     * 
     * @see Grille#grille
     */
	public Pion[][] getGrille(){
		return this.grille;
	}

	/**
     * Retourne le dernier coup effectué.
     * 
     * N'est utilisé que dans les tests unitaires.
     * 
     * @return Le dernier coup effectué.
     * 
     * @see Grille#dernierCoup
     */
	public Position getDernierCoup() {
		return this.dernierCoup;
	}

	/**
     * Fixe le dernier coup effectué.
     * 
     * N'est utilisé que dans les tests unitaires.
     * 
     * @see Grille#dernierCoup
     */
	public void setDernierCoup(Position position) {
		this.dernierCoup = position;
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
     * Fixe le nombre de pions encore disponibles.
     * 
     * N'est utilisé que dans les tests unitaires.
     * 
     * @param nbPionsDispo
     * 			Indique le nouveau nombre de pions encore disponibles.
     * 
     * @see Grille#nbPionsDisponible
     */
	public void setNbPionsDisponible(int nbPionsDispo) {
		this.nbPionsDisponible = nbPionsDispo;
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
     * 		<li> le nombre de pion disponible diminue ;</li>
     * 		<li> le tableau "dernierCoup" est mis à jour ;</li>
     * 		<li> la sauvegarde "dernierCoup" du dernier coup jou?? est mise à jour.</li>
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
	public boolean estGrilleGagnante(Joueur dernierJoueur){
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
}
