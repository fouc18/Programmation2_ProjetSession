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
	}

	public Voiture(int depart, int fin) {

		super(depart, fin);

		compteur =0;

		positionFin = fin;
		this.positionActuelle = super.getNoeudDepart();

		System.out.println("position actuelle: " +positionActuelle);
	}


	/**
	 * 
	 * @return
	 */
	public void avancer(){


		if (super.getCheminRoute().isEmpty() ) {

			super.calculeItineraire(positionActuelle);
		}



		//while(this.positionActuelle != super.getNoeudFin()) {

		//super.calculeItineraire(positionActuelle);

		if(positionActuelle != super.getNoeudFin()) {

			//if(super.getCheminRoute().indexOf(super.getCheminRoute().get(positionActuelle-1)) < super.getCheminRoute().size()) {

			System.out.println("dans le if");

			Route routeActuelle = super.getCheminRoute().get(compteur);

			compteur ++;

			this.positionActuelle = super.getCheminRoute().indexOf(routeActuelle)+1;

			//System.out.print("Ceci est getCheminRoute "+getCheminRoute().toString());
			System.out.println("position actuelle: " +positionActuelle);
		}else {
			System.out.println("Pas cappable avansser");
		}


		//System.out.println("Ceci est posDep "+ positionActuelle);

		//System.out.println("Ceci est noeudFin "+ super.getNoeudFin());

		//System.out.println("Deplacement actuel: "+ routeActuelle);
		//System.out.println("Chemin actuel: " +positionActuelle);


		//System.out.println("Position future: "+positionFuture);

		//System.out.println("Route actuelle " +super.getCheminRoute().indexOf(routeActuelle));

		//System.out.println("Noeud fin "+super.getNoeudFin());

		//}

	}

	/**
	 * 
	 * @return Position actuelle de la voiture (noeud) 
	 */
	public int getPositionActuelle() {

		return this.positionActuelle;
	}



}

