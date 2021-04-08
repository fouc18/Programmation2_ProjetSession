package Tests;


import java.util.Arrays;

import Code.Controleur;
import Code.Gps;

public class ControleurTest {

	public static void main( String[] args ) {

		Controleur c = new Controleur();

		c.demarrer(0, 3);
		
		//c.getVoiture().getListeRoute()[1].setTrafic(4);
		
		//c.getVoiture().getListeRoute()[2].setTrafic(2);
		
		//System.out.println(c.getVoiture().getListeRoute()[0]);

		//System.out.println("la distance est: " +c.getVoiture().getDistance());

		//System.out.println("La position actuelle est: "+c.getVoiture().getPositionActuelle());
		
		//System.out.println(c.getVoiture().getCheminRoute());
		
		//while(c.deplacement() ) {
		
		
		c.deplacement();
		
		//System.out.println("ceci est liste route: " +Arrays.toString(c.getVoiture().getListeRoute()));
		
		//c.getVoiture().getListeRoute()[4].setTrafic(2);
		
		c.deplacement();
		
	//	System.out.println(c.getVoiture().getCheminRoute());
	
		
	//		System.out.println("Avance, position actuelle est: "+c.getVoiture().getPositionActuelle());

		//}

		//System.out.println("la distance est: " +c.getVoiture().getDistance());
		
	//	System.out.println("La position actuelle est: "+c.getVoiture().getPositionActuelle());
		
		//System.out.println(c.getVoiture().getListeRoute()[0]);
		

	}
}
