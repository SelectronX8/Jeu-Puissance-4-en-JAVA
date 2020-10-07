package Puissance4A2joueurs;

/**
 * <b>Position est la classe représentant la position d'un pion.</b>
 * <p>Une position est représentée par ses coordonnée dans la grille.</p>
 * 
 * @author Yohann RAULET
 * 
 * @version 1.0
 */
public class Position {
    /**
     * Coordonnées en x.
     */	
	private int x;

    /**
     * Coordonnées en y.
     */	
	private int y;
	
    /**
     * <p>Constructeur générique d'une position.</p>
     * 
     * @param x
     *          Future coordonnée x de la position construite.
     * @param y
     * 			Future coordonnée y de la position construite.
     * 
     * @see Position#x
     * @see Position#y
     */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
    /**
     * Retourne l'abscisse de la position.
     * 
     * @return L'abscisse de la position.
     * 
     * @see Position#x
     */
	public int getX() {
		return this.x;
	}
	
    /**
     * Retourne l'ordonnée de la position.
     * 
     * @return L'ordonnée de la position.
     * 
     * @see Position#y
     */
	public int getY() {
		return this.y;
	}
	
	
	
	/**
     * Retourne une chaine de caractère représentant la position.
     * 
     * @return Une chaine de caractère représentant la position.
     * 
     * @see Position#x
     * @see Position#y
     * @see String#toString()
     */
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
	
	
	/**
     *  Teste si deux positions sont identiques, c'est-à-dire s'ils ont
     *  le même abscisse et le même ordonnee. 
     *
     *  @param objet
     *  		Est un objet quelconque (qui peut être une instance d'une position)
     *  
     *  @return Renvoie True si objet est une position identique à l'instance courante.
     */    
    @Override
    public boolean equals(Object obj) {
    	if(!(obj instanceof Position))
    		return false;
    	Position p = (Position) obj;
    	return (this.x==p.x) && (this.y==p.y);
    }
	
	
	
    /**
     * Teste si la position est une position déjà occupée sur la grille de jeu..
     * 
     * @param grille
     *			Il s'agit de la grille du jeu en cours de puisssance 4.
     * 
     * @return Réponds à "la position est elle occupee par un pion ?"
     * 
     * @see Grille
     */
	public boolean estOccupee(Grille  grille) {
		if(grille.getGrille()[this.x][this.y] != null)
			return true;
		return false;
	}
	
	/**
     * Teste si la position est bien a l'interieur de la grille de jeu.
     * 
     * @param grille
     *			Il s'agit de la grille du jeu en cours de puisssance 4.
     * 
     * @return Réponds à "la position est elle bien à l'intérieur de la grille de jeu ?"
     * 
     * @see Grille
     */
	//public boolean estValide(Grille grille){    // methode a remplir
		
	//}
}