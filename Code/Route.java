/**
 * Nom: Route
 * Version: 1.0
 * Date: 03/26/2021
 * Auteur: Membres de l'equipe 4
 * 
 * Description : Permet de representer le comportement d'une route.
 * 
 * Copyright 2021 equipe 4
 */

package Code;

import java.util.Random;

public class Route {
	
	/**
	 * Attributs
	 */
	private int maxVoiture;
	private int nbreVoiture;
	private int longueur;
	EtatRoute etat;
	int[] noeuds = new int[2];

	/**
	 * Constructeur par defaut qui cree une route 
	 * entre les noeuds 0 et 1 de longueur 20 avec
	 * un maximum de 10 voitures.
	 */
	public Route() {
		
	    setNoeud(0,1);
	    setMaxVoiture(10);
		genererTrafic();
		setLongueur(20);
		updateEtat();
	}

	/**
	 * Constructeur avec parametres
	 * 
	 * @param maxVoiture
	 * @param longueur de la route
	 * @param noeudDepart
	 * @param noeudArrive
	 */
	public Route(int maxVoiture, int longueur, int noeudDepart, int noeudArrive) {
		
	    setNoeud(noeudDepart,noeudArrive);
		setMaxVoiture(maxVoiture);
		genererTrafic();
		setLongueur(longueur);
		updateEtat();
	}

	/**
	 * Permet de generer un nombre aleatoire de voitures sur la
	 * route entre 0 et le maximum de voiture.
	 */
	public void genererTrafic() {
		Random random = new Random();
		setTrafic(random.nextInt(maxVoiture + 1));

	}

	/**
	 * Permet d'inserer un nombre de voitures precis sur la route
	 * 
	 * @param nbVoiture le nombre de voitures sur la route
	 */
	public void setTrafic(int nbVoiture) {
		if (nbVoiture <= maxVoiture) {
			this.nbreVoiture = nbVoiture;

			updateEtat(); // Mettre a jour l'etat de la route
		}
	}

	/**
	 * Permet d'inserer le nombre de maximum de voitures sur la route
     * 
     * @param maxVoiture le nombre de maximum de voitures sur la route
	 */
	public void setMaxVoiture(int maxVoiture) {
		this.maxVoiture = maxVoiture;
	}

	/**
	 * Permet de changer l'etat de la route selon le trafic et les accidents
	 */
	public void updateEtat() {
		//Si une route est accident�, changer son �tat � accident�
		if (Accident.causeAccident() == true) {
			this.etat = EtatRoute.ACCIDENT;
		//Si la route a atteint son nombre maximal de voiture, changer son �tat � congestionn�	
		} else if (this.nbreVoiture == this.maxVoiture) {
			this.etat = EtatRoute.CONGESTION;
		//Si une route n'est pas congestionn� ou accident�, elle est fluide	
		} else {
			this.etat = EtatRoute.FLUIDE;
		}
	}

	/**
	 * Permet d'obtenir le nombre de voiture sur la route
	 *
	 * @return le nombre de voiture sur la route
	 */
	public int getNbreVoiture() {
		return this.nbreVoiture;
	}

	/**
	 * Permet d'obtenir le nombre de voiture sur la route
	 *
	 * @return le nombre de voiture sur la route
	 */
	public int getMaxVoiture() {
		return this.maxVoiture;
	}

	/**
	 * Permet d'obtenir la distance de la route
	 *
	 * @return la distance de la route
	 */
	public int getLongueur() {
		return this.longueur;
	}

	/**
	 * Permet de definir la longueur de la route
	 * 
	 * @param longueur de la route
	 */
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	/**
	 * Permet d'obtenir l'etat de la route
	 *
	 * @return l'etat de la route
	 */
	public EtatRoute getEtat() {
		return this.etat;
	}

	/**
	 * Permet de definir l'etat de la route
	 * 
	 * @param etat
	 */
    public void setEtat(EtatRoute etat) {
        this.etat = etat;
    }
    
    /**
     * Permet d'obtenir les noeuds relies a la route
     *
     * @return le noeud de la route
     * @return -1 si le noeud n'existe pas
     */
	public int getNoeud(int n) {

		if ( n<noeuds.length ) {
			return noeuds[ n ];
		} else {
			return -1 ;
		}
	}
	
	/**
	 * Definit les noeuds de depart et d'arrive de la route
	 * @param noeudDepart
	 * @param noeudArrive
	 */
	public void setNoeud(int noeudDepart, int noeudArrive) {
	    if( (noeudDepart <=7 && noeudDepart >= 0) && (noeudArrive<=7 && noeudArrive >= 0) ) {
	    	
	        this.noeuds[0] = noeudDepart;
            this.noeuds[1] = noeudArrive;
	    }
	}

	/**
	 * Permet d'afficher sous forme de String la description complete
	 * de la route
	 * 
	 * @return une String contenant la description complete de la route
	 */
	public String toString() {
		return " \n"+"Noeuds: " + getNoeud(0) + " => "+ getNoeud(1) + " Nbre de voitures: " + getNbreVoiture() + "/" + getMaxVoiture()
		 +" tailles: " + getLongueur() +  " Etat; " + getEtat() ;
	}

}
