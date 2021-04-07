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
	public boolean deplacement() {
		
		for(int i = 0;  i < voitureActuelle.getListeRoute().length; i++) {
			
			
			voitureActuelle.getListeRoute()[i].genererTrafic();
	
		
		}
		
		return voitureActuelle.avancer();
		
		
	}
	
}
