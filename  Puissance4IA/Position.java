package Puissance4IA;

/**
 * <b>Position est la classe représentant la position d'un pion.</b>
 * <p>Une position est représentée par ses coordonnée dans la grille.</p>
 * 
 * @author ???
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
     * Teste si la position est une position déjà occupée sur la grille de jeu.
     * 
     * @param grille
     *			Il s'agit de la grille du jeu en cours de puisssance 4.
     * 
     * @return Réponds à "la position est elle bien à l'intérieur de la grille de jeu et si oui, est elle déjà occupée ?"
     * 
     * @see Grille
     */
	public boolean estOccupee(Grille  grille) {
		if(grille.getGrille()[this.x][this.y] != null)
			return true;
		return false;
	}
}