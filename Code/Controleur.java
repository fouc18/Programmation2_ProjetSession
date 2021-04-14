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

import exception.NoeudInexistantException;

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
	 * @throws NoeudInexistantException 
	 */
	public void demarrer(int noeudDepart, int noeudFin) throws NoeudInexistantException {
	    
	    if( (noeudDepart >=0 && noeudDepart <=7) && (noeudFin >=0 && noeudFin <=7) ) {
	        
	        //D�finition d'un d'une position de d�part et d'une destination pour la voiture
	        voitureActuelle = new Voiture(noeudDepart, noeudFin);
	    
	    }else {
	        throw new NoeudInexistantException();
	    }


	}
	/**
	 * Permet d'enlever la voiture du programme
	 */
	public void arreter() {
	    voitureActuelle = null;
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
			//Pour toutes les routes obtenir leur �tat
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
