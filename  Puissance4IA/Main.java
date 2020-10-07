package Puissance4IA;

import java.util.Scanner;
import java.util.Random;

import Puissance4A2joueurs.Grille;
import Puissance4A2joueurs.Joueur;
import Puissance4A2joueurs.Puissance4;

/**
 * <b>Main est la classe permettant de lancer un jeu de puissance 4.</b>
 * <p>
 * 
 * @see Puissance4
 * 
 * @author ???
 * @version 1.0
 */

public class Main {
	
	/**
	 * <b>
	 * 		Méthode main permettant de lancer un menu initialisant les deux joueurs en lice,
	 * 		de créer et enfin de lancer un jeu de puissance 4
	 * </b>
	 * 
	 * @param args
	 * 			est l'argument générique d'une méthode main
	 */
	public static void main(String[] args) {
		
		
		
		System.out.println("Vous jouez contre l'ordinateur" );
		Joueur joueur2 = new Joueur("Ordinateur", 1);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le nom du joueur 1 : " );
		Joueur joueur1 = new Joueur(sc.nextLine(), 0);
		
		Puissance4 puissance4 = new Puissance4(joueur1, joueur2);
		Grille grille = new Grille();
		
		int i=0,fin=0;

		while(fin == 0){
			if(i==0){
				grille.joueCoup(joueur1.choisirCoup(grille, sc), joueur1);
				System.out.println("dernier coup : " + grille.getDernierCoup());
				System.out.println("pions dispo : " + grille.getNbPionsDisponible());
				i=1;
				if(grille.estGrilleGagnante(joueur1) == true){
					System.out.println(grille);
					System.out.println("C'est "+ joueur1.getNom() + " qui gagne !");
					fin=1;
				}
			}
			else{
				grille.joueCoup((int)(Math.random() * 6) + 0, joueur2);
				System.out.println("dernier coup : " + grille.getDernierCoup());
				System.out.println("pions dispo : " + grille.getNbPionsDisponible());
				i=0;
				if(grille.estGrilleGagnante(joueur2) == true){
					System.out.println(grille);
					System.out.println("C'est "+ joueur2.getNom() + " qui gagne !");
					fin=1;
				}
			}
		}
	} 
}