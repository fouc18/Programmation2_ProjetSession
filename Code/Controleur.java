package Code;

public class Controleur {
	
	Voiture voitureActuelle;

	/**
	 * 
	 * @param noeudDepart
	 * @param noeudFin
	 */
	public void demarrer(int noeudDepart, int noeudFin) {
		
		voitureActuelle = new Voiture(noeudDepart, noeudFin);
		
	}
	
	/**
	 * 
	 * @return Voiture Actuelle
	 */
	public Voiture getVoiture() {
		
		return this.voitureActuelle;
	}
	
	/**
	 * 
	 * @return possibilite d'avancer
	 */
	public int deplacement() {
		
		/*for(int i = 0;  i < voitureActuelle.getListeRoute().length; i++) {
			
			
			voitureActuelle.getListeRoute()[i].genererTrafic();
	
		
		} */
		
		voitureActuelle.reinitialiserTraffic();
		
		int resultatAvance = voitureActuelle.avancer();
		
		//System.out.println("Ceci est la position actuelle: "+voitureActuelle.getPositionActuelle());
		
		System.out.println("Ceci est le resultat de avance: " +resultatAvance);
		
		return resultatAvance;
	}
	
}
