/**
 * Nom: Voiture
 * Version: 1.0
 * Date: 03/28/2021
 * Auteur: Membres de l'equipe 4
 * 
 * Description : 
 * 
 * Copyright 2021 equipe 4
 */

package Code;

/* Cette classe permet de representer le comportement d'une voiture */
public class Voiture extends Gps{

	private int positionActuelle;

	private int positionFin;

	private int compteur;
	
	/**
	 * Constructeur par defaut qui cree une voiture 
	 * entre les noeuds 0 et 3 comme point d'arrive et de départ
	 * cré un itineraire unique a cette voiture
	 */

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
	
	/**
	 * Constructeur avec parametre, 
	 * les noeud de depart et d'arrive ne sont pas defini
	 * @param depart
	 * @param fin
	 */
	public Voiture(int depart, int fin){

		super(depart, fin);

		compteur =0;

		positionFin = fin;

		this.positionActuelle = super.getNoeudDepart();

		try {
			//Calcul l'itineraire le plus court en fonction du noeud actuel et de la destination finale
			super.calculeItineraire(positionActuelle);
		}catch(IndexOutOfBoundsException e) {
			//Si la voiture est entoure de routes bloque, reinitialiser le traffic
			super.reinitialiserTraffic();
		}
	}

	/**
	 * Calcul l'itinéraire le plus court entre la position actuelle et la destination finale
	 */
	public void trouverItineraire() {

		try {
			//Si la voiture n'est pas isolé, faire le calcul de l'itinéraire
			super.calculeItineraire(positionActuelle);
		} catch (ArrayIndexOutOfBoundsException e) {
			//Si toutes les routes entourant la voiture sont bloqués, regénérer l'état des routes
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
			//La voiture est arrivé à la destination finale
			return 2;

		}

		try {
			//La voiture avance à la prochaine intersection
			Route routeActuelle = super.getCheminRoute().get(0);
	
			this.positionActuelle = routeActuelle.getNoeud(1);

			super.ajouterDistance(routeActuelle.getLongueur());
			
			return 0;

		} catch(IndexOutOfBoundsException e) {
			//Toutes les routes entourant la voiture sont bloques
			//le traffic est regenere et un nouvel itineraire est trouve
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

