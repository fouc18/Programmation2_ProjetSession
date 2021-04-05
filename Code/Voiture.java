/* Nom: Voiture
 * Version: 1.0
 * Date: 03/28/2021
 * Auteur: Membres de l'equipe 4
 * Copyright 2021 equipe 4
 * */
package Code;

import java.util.Arrays;

/* Cette classe permet de representer le comportement d'une voiture */
public class Voiture extends Gps{

	private int positionFuture;

	public Voiture(){
		super();
		this.positionFuture = super.getNoeudDepart();
	}

	public Voiture(int depart, int fin) {

		super.setNoeudDepart(depart);

		super.setNoeudFin(fin);

		this.positionFuture = super.getNoeudDepart();

	}
	
	
	/**
	 * 
	 * @return
	 */
	public void avancer(){
		
		
		if (super.getCheminRoute().isEmpty() ) {

			super.calculeItineraire();
		}
		
		
		
		while(positionFuture != super.getNoeudFin()) {
			
			super.calculeItineraire();
			
			Route routeActuelle = super.getCheminRoute().get(positionFuture);

			this.positionFuture = super.getCheminRoute().indexOf(routeActuelle)+1;
			
			//System.out.println("Position future: "+positionFuture);
			
			//System.out.println("Route actuelle " +super.getCheminRoute().indexOf(routeActuelle));
			
			//System.out.println("Noeud fin "+super.getNoeudFin());
			
		}
		
	}

}
