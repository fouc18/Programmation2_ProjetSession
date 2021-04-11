/* Nom: Route
 * Version: 1.0
 * Date: 03/26/2021
 * Auteur: Membres de l'equipe 4
 * Copyright 2021 equipe 4
 * */
package Code;

import java.util.Random;

/* Permet de representer le comportement d'une route */
public class Route {

	private int maxVoiture;
	private int nbreVoiture;
	private int longueur;
	EtatRoute etat;
	int[] noeuds = new int[2];

	public Route() {
		
	    setNoeud(0,1);
		
	    setMaxVoiture(10);
		genererTrafic();
		setLongueur(20);
		updateEtat();
	}

	public Route(int maxVoiture, int longueur, int noeudDepart, int noeudArrive) {
		
	    setNoeud(noeudDepart,noeudArrive);
	    
		setMaxVoiture(maxVoiture);
		genererTrafic();
		setLongueur(longueur);
		updateEtat();
	}

	/*
	 * Permet de generer le nombre de voitures sur la route
	 */
	public void genererTrafic() {
		Random random = new Random();
		setTrafic(random.nextInt(maxVoiture + 1));

	}

	/*
	 * Permet d'inserer un nombre de voitures precis sur la route
	 * 
	 * @param nVoiture le nombre de voitures sur la route
	 */
	public void setTrafic(int nVoiture) {
		if (nVoiture <= maxVoiture) {
			this.nbreVoiture = nVoiture;

			updateEtat(); // Mettre a jour l'etat de la route
		}
	}

	/*
     * Permet d'inserer le nombre de maximum de voitures sur la route
     * 
     * @param maxVoiture le nombre de maximum de voitures sur la route
     */
	public void setMaxVoiture(int maxVoiture) {
		this.maxVoiture = maxVoiture;
	}

	/*
	 * Permet de changer l'etat de la route selon le trafic et les accidents
	 * 
	 */
	public void updateEtat() {
		if (Accident.causeAccident() == true) {
			this.etat = EtatRoute.ACCIDENT;
		} else if (this.nbreVoiture == this.maxVoiture) {
			this.etat = EtatRoute.CONGESTION;
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

	/*
     * Set l'etat de la route
     */
    public void setEtat(EtatRoute etat) {
        this.etat = etat;
    }
    
    /*
     * Permet d'obtenir les noeuds relies a la route
     *
     * @return le noeud de la route
     * @return -1 si le noeud n'existe pas
     */
	public int getNoeud(int n) {

		if ( n<noeuds.length ) {

			return noeuds[ n ];
		}else {

			return -1 ;
		}
	}
	
	/*
     * Set les noeuds de depart et d'arrive de la route
     */
	public void setNoeud(int noeudDepart, int noeudArrive) {
	    if( (noeudDepart <=7 && noeudDepart >= 0) && (noeudArrive<=7 && noeudArrive >= 0) ) {
	        this.noeuds[0] = noeudDepart;
            this.noeuds[1] = noeudArrive;
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
