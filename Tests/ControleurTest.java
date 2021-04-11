package Tests;


import java.util.Arrays;

import Code.Controleur;
import Code.Gps;
import exception.NoeudIntrouvableException;

public class ControleurTest {

	public static void main( String[] args ) throws ArrayIndexOutOfBoundsException {

		Controleur c = new Controleur();

		c.demarrer(0, 1);
		
		
		//System.out.println("chemin route " +c.getVoiture().getCheminRoute());
		
		//c.getVoiture().getListeRoute()[0].setTrafic(10);
		//c.getVoiture().getListeRoute()[1].setTrafic(4);
		//c.getVoiture().getListeRoute()[2].setTrafic(2);
		
		//System.out.println(Arrays.toString(c.getVoiture().getListeRoute()));
		
	//	System.out.println(c.getVoiture().getCheminRoute());
		
		/*
		System.out.println("position" +c.getVoiture().getPositionActuelle());		
		

		
		c.deplacement();
	
		System.out.println("position" +c.getVoiture().getPositionActuelle());	
		
		System.out.println(c.getVoiture().getCheminRoute());
		
		c.deplacement();
		
		System.out.println("FIN");
	
		c.deplacement();
		c.deplacement();
		c.deplacement();
		*/
	//	System.out.println("position initiale: "+c.getVoiture().getPositionActuelle());
		System.out.println("position intiale: "+c.getVoiture().getPositionActuelle());
		System.out.println("distance initiale => "+c.getVoiture().getDistance());
		
		while(c.deplacement()!=2) {
		    System.out.println("Mon itineraire => "+c.getVoiture().getCheminRoute());
			System.out.println("J'ai avancé, ma position => "+c.getVoiture().getPositionActuelle());
		}
		
		System.out.println("distance => "+c.getVoiture().getDistance());

	}
}
