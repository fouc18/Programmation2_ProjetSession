/* Nom: Voiture
 * Version: 1.0
 * Date: 03/28/2021
 * Auteur: Membres de l'équipe 4
 * Copyright 2021 Équipe 4
 * */
package Code;

/* Cette class permet de representer le comportement d'une voiture */
public class Voiture extends Gps{

	private int positionActuelle;

	public Voiture(){
		super();
		this.positionActuelle = super.getNoeudDepart();
	}

	public Voiture(int depart, int fin) {
	
		super.setNoeudDepart(depart);
		
		super.setNoeudFin(fin);
		
		this.positionActuelle = super.getNoeudDepart();
		
	}

	public boolean avancer(){
		
		if (super.getCheminRoute().isEmpty() ) {
			
			super.calculeItineraire();
		}
		
		Route routePasse = super.getCheminRoute().get(positionActuelle);
		
		this.positionActuelle = super.getCheminRoute().indexOf(routePasse)+1;
		//super.AjouterDistance(routePasse.getLongueur());
		System.out.println("Position actuelle: "+positionActuelle);
		return true;
	}

}
