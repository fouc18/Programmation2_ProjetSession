package Tests;

import Code.Voiture;

public class VoitureTest {

	public VoitureTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Voiture v= new Voiture() ;

		System.out.println(v.avancer());
		System.out.println(v.avancer());
		System.out.println(v.avancer());
		

		System.out.println(v.getNoeudFin());
		
		v.calculeItineraire();
		
		System.out.println(v.getCheminRoute().toString());

		Voiture v2 = new Voiture(2,6);

		System.out.println(v2.avancer());

		System.out.println(v2.getNoeudFin());
		
		v2.calculeItineraire();
		
		System.out.println(v2.getCheminRoute().toString());
			
	}

}