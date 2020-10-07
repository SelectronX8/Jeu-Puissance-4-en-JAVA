package Puissance4IA;
/**
 * <b>Pion est la classe représentant un pion.</b>
 * <p>
 *		Un pion est caractérisé par sa couleur.
 * </p>
 * 
 * @author ???
 * 
 * @version 1.0
 */
public class Pion {
    /**
     * Représente la couleur d'un pion à l'aide d'un entier.
     * 
     */	
	private int couleur;
	
	/**
     * <p> Constructeur générique d'un pion. </p>
     * 
     * @param couleur
     *            La couleur du pion, représentée par un entier.
     */
	public Pion(int couleur) {
		this.couleur = couleur;
	}
	
    /**
     * Retourne la couleur d'un pion.
     * 
     * @return La couleur d'un pion, sous forme d'un entier.
     * 
     * @see Pion#couleur
     */
	public int getCouleur() {
		if (this.couleur != 0 && this.couleur != 1)
			return 2;
		else
			return this.couleur;
	}
	
    /**
     * Retourne une chaine de caractére représentant le pion.
     * 
     * @return Une chaine de caractére représentant le pion.
     * 
     * @see Pion#couleur
     * @see String#toString()
     */
	@Override
	public String toString() {
		if (this.couleur == 0)
			return "o ";
		if (this.couleur == 1)
			return "x ";
		return "  ";
	}
}