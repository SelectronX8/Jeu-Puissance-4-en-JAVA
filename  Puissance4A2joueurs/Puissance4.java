package Puissance4A2joueurs;
import java.util.Scanner;

/**
 * <b>Puissance4 est la classe permettant de représenter un jeu de Puissance 4, et d'y jouer.</b>
 * <p>
 *		Un jeu de puissance 4 est caractérisé par :
 *		<ul> les caractéristiques du jeu, qui ne peuvent être modifiées :
 *			<ul>
 *				<li> les dimensions de la grille de jeu : 8 colonnes de 6 cases de hauteurs.</li>
 *				<li> le nombre de pions à aligner pour déclarer la fin de partie.</li>
 *			</ul>
 *		</ul>
 *		<ul> les informations suivantes :
 *			<ul>
 * 				<li>Le joueur courant.</li>
 * 				<li>Une grille du jeu représentant où les pions joués se trouvent.</li>
 *	 		</ul>
 *		</ul>
 * </p>
 * 
 * @author Yohann RAULET
 * 
 * @version 1.0
 */

public class Puissance4 {
	/**
     * La dimension horizontale de la grille de jeu utilisée : celle-ci n'est pas modifiable
     * et ne dépend pas de l'instance utilisée.
     */
	public final static int dimensionH = 7;   //8

	/**
     * La dimension verticale de la grille de jeu utilisée : celle-ci n'est pas modifiable et
     * ne dépend pas de l'instance utilisée.
     */
	public final static int dimensionV = 6;   //6
	
	/**
     * Le nombre de pions à aligner pour gagner : celui-ci n'est pas modifiable et ne dépend
     * pas de l'instance utilisée.
     */
	public final static int nbPionsAlignesPourGagner = 4;
	
    /**
     * Le joueur dont c'est le tour de jouer.
     * 
     * @see Joueur
     */	
	private Joueur joueurJouant;

	/**
     * La grille de jeu.
     * 
     * @see Grille
     */
	private Grille grilleDeJeu;

    /**
     * <p>
     * 		A la construction d'un objet Puissance4, l'attribut "joueurJouant" est fixé à "joueur1".
     * 		Les joueurs 1 et 2 sont alors déclarés adversaires l'un de l'autre et la grille de jeu est crée.
     * </p>
     * 
     * @param joueur1
     *            Le premier joueur du jeu.
     * @param joueur2
     *            Le second joueur du jeu.
     * 
     * @see Joueur
     * @see Puissance4#joueurJouant
     * @see Puissance4#grilleDeJeu
     */
	public Puissance4(Joueur joueur1, Joueur joueur2) {
		this.joueurJouant = joueur1;
		joueur1.setAdversaire(joueur2);
		joueur2.setAdversaire(joueur1);
	}
	
    /**
     * Lance un jeu : cette méthode est celle qui distribue les différentes tâches à effectuer pour que le jeu se passe bien.
     * 
     * @param scanner
     *            Un outil de la classe Scanner permettant à l'ordinateur de dialoguer avec les joueurs.
     * 
     * @see Scanner
     */
	public void jouer(Scanner scanner) {
		System.out.println("Commencement d'une partie de Puissance4");
	}
}