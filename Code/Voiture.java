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

	private static int compteur;

	public Voiture(){
		
		super(0,3);
		
		this.positionActuelle = super.getNoeudDepart();
		
		this.positionFin = super.getNoeudFin();
		
		compteur =0;
		
		super.calculeItineraire(positionActuelle);
	}

	public Voiture(int depart, int fin) {

		super(depart, fin);

		compteur =0;

		positionFin = fin;
		
		this.positionActuelle = super.getNoeudDepart();
		
		super.calculeItineraire(positionActuelle);
	}


	/**
	 * 
	 * @return boolean, s'il a reussi a avancer
	 */
	public boolean avancer(){

	/*	if (super.getCheminRoute().isEmpty() ) {

			super.calculeItineraire(positionActuelle);

			compteur = 0;
		}
	 */
		
		
		//while(this.positionActuelle != super.getNoeudFin()) {
		

		super.calculeItineraire(positionActuelle);

		if(positionActuelle != super.getNoeudFin()) {

			Route routeActuelle = super.getCheminRoute().get(compteur);

			compteur ++;

			this.positionActuelle = routeActuelle.getNoeud(1);

			super.ajouterDistance(routeActuelle.getLongueur());

			return true;
		}
		return false;
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

