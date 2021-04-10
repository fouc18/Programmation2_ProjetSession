/*
 *  Nom: Voiture
 * Version: 1.0
 * Date: 03/28/2021
 * Auteur: Membres de l'equipe 4
 * Copyright 2021 equipe 4
 * 
 * */
package Code;

import java.util.Arrays;


/* Cette classe permet de representer le comportement d'une voiture */
public class Voiture extends Gps{

	private int positionActuelle;

	private int positionFin;

	private int compteur;

	public Voiture(){

		super(0,3);

		this.positionActuelle = super.getNoeudDepart();

		this.positionFin = super.getNoeudFin();

		compteur =0;

		try {
			super.calculeItineraire(positionActuelle);
		}catch(IndexOutOfBoundsException e) {
			super.reinitialiserTraffic();
		}

	}

	public Voiture(int depart, int fin){

		super(depart, fin);

		compteur =0;

		positionFin = fin;

		this.positionActuelle = super.getNoeudDepart();

		try {
			super.calculeItineraire(positionActuelle);
		}catch(IndexOutOfBoundsException e) {
			super.reinitialiserTraffic();
		}
	}

	public void trouverItineraire() {

		try {
			super.calculeItineraire(positionActuelle);
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println("Dans le constructeur");

			super.reinitialiserTraffic();
			trouverItineraire();
		}

	}


	/**
	 * 
	 * @return 0, la voiture a avance
	 * @return 1, trop de congestion pour la voiture
	 * @return 2, la voiture a atteint sa destination
	 */
	public int avancer(){

		if(positionActuelle == super.getNoeudFin() ) {
			
			System.out.println("Arrive !" + positionActuelle);
			
			return 2;

		}

		try {

			super.calculeItineraire(positionActuelle);

			System.out.println("chemin route TEST: " +super.getCheminRoute());
			
			Route routeActuelle = super.getCheminRoute().get(0);
			//Route routeActuelle = super.getCheminRoute().get(positionActuelle);

			//compteur ++;
			
		//	System.out.println("compteur " + compteur);

			this.positionActuelle = routeActuelle.getNoeud(1);

			super.ajouterDistance(routeActuelle.getLongueur());
			
			//System.out.println("ceci est la position actuelle " +positionActuelle);
		
			
			return 0;

		} catch(IndexOutOfBoundsException e) {

			System.out.println("catch: avancer");
			
			System.out.println("ceci est la position actuelle " +positionActuelle);

			super.reinitialiserTraffic();
			
			super.calculeItineraire(positionActuelle);
			
			return 1;

		}

	}
	/**
	 * 
	 * @return Position actuelle de la voiture (noeud) 
	 */
	public int getPositionActuelle() {

		return this.positionActuelle;
	}

	public String toString() {

		return "Voiture a la position: " + positionActuelle;
	}



}

