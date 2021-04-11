/* Nom: Route
 * Version: 1.0
 * Date: 03/26/2021
 * Auteur: Membres de l'equipe 4
 * Copyright 2021 equipe 4
 * */
package Code;

import java.util.Random;

/* Cette class permet de representer le comportement d'une route */
public class Route {

	private int maxVoiture;
	private int nbreVoiture;
	private int longueur;
	EtatRoute etat;
	int[] noeuds = new int[2];

	public Route() {
		
		noeuds[0] = 0;
		noeuds[1] = 1;
		maxVoiture = 10;
		genererTrafic();
		setLongueur(20);
		updateEtat();
	}

	public Route(int maxVoiture, int longueur, int noeudDepart, int noeudArrive) {
		
		noeuds[0] = noeudDepart;
		noeuds[1] = noeudArrive;

		setMaxVoiture(maxVoiture);
		genererTrafic();
		setLongueur(longueur);
		updateEtat();
	}

	/*
	 * Permet de generer le nombre de voitures sur la route
	 * 
	 * @return nombre de voitures sur la route
	 */
	public void genererTrafic() {
		Random random = new Random();
		setTrafic(random.nextInt(maxVoiture + 1));

	}

	/*
	 * Permet d'inserer un nombre de voitures precis sur la route
	 * 
	 * @param nVoiture le nombre de voitures sur la rout
	 */
	public void setTrafic(int nVoiture) {
		if (nVoiture <= maxVoiture) {
			this.nbreVoiture = nVoiture;

			updateEtat(); // Mettre a jour l'etat de la route
		} else {
			this.nbreVoiture = 0;
		}
	}

	public void setMaxVoiture(int maxVoiture) {
		if (maxVoiture <= 100) {
			this.maxVoiture = maxVoiture;
		} else {
			this.maxVoiture = 10;
		}
	}

	/*
	 * Permet de changer l'etat de la route selon le trafic et les accidents
	 * 
	 */
	public void updateEtat() {
		if (Accident.causeAccident() == true) {
			this.etat = EtatRoute.ACCIDENT;
			//this.etat = EtatRoute.FLUIDE;
		} else if (this.nbreVoiture == this.maxVoiture) {
			this.etat = EtatRoute.CONGESTION;
			//this.etat = EtatRoute.FLUIDE;
		} else {
			this.etat = EtatRoute.FLUIDE;
		}
	}

	/*
	 * Permet d'obtenir le nombre de voiture sur la route
	 *
	 * @return le nombre de voiture sur la route
	 */
	public int getNbreVoiture() {
		return this.nbreVoiture;
	}

	/*
	 * Permet d'obtenir le nombre de voiture sur la route
	 *
	 * @return le nombre de voiture sur la route
	 */
	public int getMaxVoiture() {
		return this.maxVoiture;
	}

	/*
	 * Permet d'obtenir la distance de la route
	 *
	 * @return la distance de la route
	 */
	public int getLongueur() {
		return this.longueur;
	}

	/*
	 * Permet de definir la longueur de la route
	 */
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	/*
	 * Permet d'obtenir l'etat de la route
	 *
	 * @return l'etat de la route
	 */
	public EtatRoute getEtat() {
		return this.etat;
	}

    public void setEtat(EtatRoute etat) {
        this.etat = etat;
    }
    
	public int getNoeud(int n) {

		if ( n<noeuds.length ) {

			return noeuds[ n ];
		}else {

			return -1 ;
		}
	}

	/*
	 * Permet d'acceder a la description complete de la route
	 * 
	 * @return La description complete de la route
	 */
	public String toString() {
		return " \n"+"Noeuds: " + getNoeud(0) + " => "+ getNoeud(1) + " Nbre de voitures: " + getNbreVoiture() + "/" + getMaxVoiture()
		 +" tailles: " + getLongueur() +  " Etat; " + getEtat() ;
	}

}
