package Puissance4A2joueurs;

import java.util.Scanner;

/**
 * <b>Joueur est la classe représentant un joueur.</b>
 * <p>
 *		Un joueur est caractérisé par :
 *		<ul>
 *			<li> un nom.</li>
 *			<li> une couleur.</li>
 *			<li> un adversaire.</li>
 *		</ul>
 * </p>
 * 
 * @author Yohann RAULET
 * 
 * @version 1.0
 */
public class Joueur {
    /**
     * Le nom du joueur.
     */	
	private String nom;

    /**
     * La couleur du joueur.
     */	
	private int couleur;

    /**
     * L'adversaire du joueur.
     */	
	private Joueur adversaire;
	
    /**
     * <p>
     * 		A la construction d'un objet Joueur, seul les attributs "couleur" et "nom" sont initialisés,
     * 		puisqu'il n'est pas encore possible de connaitre l'adversaire du joueur.
     * </p>
     * 
     * @param couleur
     *            La couleur des pions que le joueur utilisera.
     * @param nom
     *            Le nom du joueur.
     * 
     * @see Joueur#nom
     * @see Joueur#couleur
     */
	public Joueur(String nom, int couleur) {
		this.nom = nom;
		this.couleur = couleur;
	}

    /**
     * Retourne le nom du joueur.
     * 
     * @return Le nom du joueur, sous forme d'une chaine de caractères.
     * 
     * @see Joueur#nom
     */
 	public String getNom() {
 		return this.nom;
	}

    /**
     * Retourne la couleur du joueur.
     * 
     * @return La couleur du joueur, sous forme d'un entier.
     * 
     * @see Joueur#couleur
     */
    public int getCouleur() {
    	return this.couleur;
	}
		
    /**
     * Retourne l'adversaire du joueur.
     * 
     * @return L'adversaire du joueur, qui se trouve être un Joueur.
     * 
     * @see Joueur#adversaire
     */
    public Joueur getAdversaire() {
    	return this.adversaire;
	}
	
    /**
     * Permet de définir l'adversaire du joueur.
     * 
     * @param adversaire
     *            L'adversaire est un joueur, fixé au moment du lancement d'un jeu
     *            (c'est-à-dire dans la méthode jouer de la classe Puissance4).
     *            
     * @see Puissance4#jouer(Scanner)
     */
    public void setAdversaire(Joueur adversaire) {
    	this.adversaire = adversaire;
	}
    
    /**
     *  Teste si deux joueurs sont identiques, c'est-à-dire s'ils ont
     *  le même nom et la même couleur. L'adversaire n'est pas testé, car
     *  il est possible qu'un joueur joue contre plusieurs adversaires en même
     *  temps, ce qui forcerait ici à crêer plusieurs instance du même joueur.
     *
     *  @param objet
     *  		Est un objet quelconque (qui peut être une instance d'un Joueur)
     *  
     *  @return Renvoie True si objet est un joueur identique à l'instance courante.
     *  
     *  @see Joueur#nom
     *  @see Joueur#couleur
     */
    public boolean equals(Object obj) {
    	if(!(obj instanceof Joueur))
    		return false;
    	Joueur j = (Joueur) obj;
    	return (this.nom==j.nom) && (this.couleur==j.couleur);
    }

    /**
     * Implémente l'interaction de base entre l'ordinateur et le joueur pour demander au joueur
     * l'endroit où il souhaite jouer. Cette méthode est appelée au cours d'un jeu de puissance 4.
     * 
     * @param grille
     *			La grille est la grille du jeu courant de puisssance 4.
     *            
     * @param scanner
     * 			Un outil de la classe Scanner permettant à l'ordinateur de dialoguer avec les joueurs.	
     * 
     * @see Grille
     * @see Puissance4#jouer(Scanner)
     */
    public int choisirCoup(Grille grille, Scanner scanner) {
    	int saisie = 1;
        System.out.println(grille);
        System.out.println(this.nom + ", dans quelle colonne voulez-vous jouer ? \n");
        int val = scanner.nextInt();
        while (saisie == 1){
            if (val < 0 || val >= Puissance4.dimensionH){
                System.out.println("La colonne selectionn�e n'est pas valide");
                System.out.println(this.nom + ", dans quelle colonne voulez-vous jouer ? \n");
                val=  scanner.nextInt();
                saisie = 1;
            }
            else{
                
                saisie = 0;
            }
        }
         
        return val;
	}
}