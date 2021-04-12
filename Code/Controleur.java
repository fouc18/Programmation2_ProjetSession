/** 
 * Nom: Controleur
 * Version: 1.0
 * Date: 04/10/2021
 * Auteur: Membres de l'equipe 4
 * 
 * Description : La classe Controleur sert de d'intermediaire
 * entre l'interface et le reste du code.
 * 
 * Copyright 2021 equipe 4
 */

package Code;

import java.util.ArrayList;

public class Controleur {
	
	/**
	 * Attribut
	 */
	private Voiture voitureActuelle;

	/** 
	 * Permet de demarrer un trajet
	 * 
	 * @param noeudDepart
	 * @param noeudFin
	 */
	public void demarrer(int noeudDepart, int noeudFin) {

		voitureActuelle = new Voiture(noeudDepart, noeudFin);

	}
	
	/** 
	 * Permet d'effectuer un deplacement de la voiture
	 * 
	 * @return possibilite d'avancer
	 */
	public int deplacement() {

		int resultatAvance;
		do {
			
			resultatAvance = voitureActuelle.avancer();
			voitureActuelle.reinitialiserTraffic();

		} while(resultatAvance == 1); //Reessayer d'avancer tant que la voiture rencontre des problemes de trajet

		return resultatAvance;
	}

	/** Permet d'obtenir l'etat de tous les routes
	 * 
	 * @return l'etat des routes
	 */
	public EtatRoute[] getEtatRoutes() {
		EtatRoute[] etat = new EtatRoute[26];

		for(int i = 0; i < etat.length; i++) {
			etat[i] = voitureActuelle.getListeRoute()[i].getEtat();
		}

		return etat;
	}

	/** Permet d'obtenir l'itineraire des routes
	 * 
	 * @return l'itineraire des routes
	 */
	public ArrayList<Route> getItineraire() {
		voitureActuelle.calculeItineraire(voitureActuelle.getPositionActuelle());
		return voitureActuelle.getCheminRoute();
	}

	/** Permet d'obtenir la distance de la voiture
	 * 
	 * @return la distance de la voiture
	 */
	public double getVoitureDistance() {
		return voitureActuelle.getDistance();
	}

	/** Permet d'obtenir la position actuelle de la voiture
	 * 
	 * @return la position actuelle de la voiture
	 */
	public int getPositionVoiture() {
		return voitureActuelle.getPositionActuelle();
	}

}
