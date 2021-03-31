/* Nom: Gps
 * Version: 1.0
 * Date: 03/26/2021
 * Auteur: Membres de l'équipe 4
 * Copyright 2021 Équipe 4
 * */
package Code;

import java.util.Arrays;
import java. util.ArrayList;

import Code.Dijkstra;

/* Permet de repérer la trajectoire de la voiture et l'état des routes sur la carte */
public class Gps {

	private int[]          cheminRoute;
	private int            distanceParcouru;
	private static int[][] distNoeud         = { { 0, 5, 0, 0, 0, 1, 2, 0 },
			{ 5, 0, 1, 0, 0, 0, 3, 0 },
			{ 0, 1, 0, 6, 0, 0, 0, 3 },
			{ 0, 0, 6, 0, 12, 0, 0, 6 },
			{ 0, 0, 0, 12, 0, 3, 0, 4 },
			{ 1, 0, 0, 0, 3, 0, 1, 0 },
			{ 2, 3, 0, 0, 0, 1, 0, 10 },
			{ 0, 0, 3, 6, 4, 0, 10, 0 } };

	/*private static int[][] associeNoeudRoute = {
            { 1, 0 },
            { 0, 1 },
            {0,6},
            {6,0}
    };*/


	Route[]                listeRoutes;

	public Gps() {

		listeRoutes = new Route[26]; // Creer les routes
		listeRoutes[0]  = new Route( 10, 5, 0, 1);  //maxVoiture, longueur, noeudDepart, noeudArrive
		listeRoutes[1]  = new Route( 4, 2, 0, 6);
		listeRoutes[2]  = new Route( 2, 1, 0, 5);
		listeRoutes[3]  = new Route( 10, 5, 1, 0);
		listeRoutes[4]  = new Route( 2, 1, 1, 2);
		listeRoutes[5]  = new Route( 6, 3, 1, 6);
		listeRoutes[6]  = new Route( 2, 1, 2, 1);
		listeRoutes[7]  = new Route( 6, 3, 2, 7);
		listeRoutes[8]  = new Route( 12, 6, 2, 3);
		listeRoutes[9]  = new Route( 12, 6, 3, 2);
		listeRoutes[10] = new Route( 12, 6, 3, 7);
		listeRoutes[11] = new Route( 24, 12, 3, 4);
		listeRoutes[12] = new Route( 6, 3, 4, 5);
		listeRoutes[13] = new Route( 8, 4, 4, 7);
		listeRoutes[14] = new Route( 24, 12, 4, 3);
		listeRoutes[15] = new Route( 2, 1, 5, 0);
		listeRoutes[16] = new Route( 2, 1, 5, 6);
		listeRoutes[17] = new Route( 6, 3, 5, 4);
		listeRoutes[18] = new Route( 4, 2, 6, 0);
		listeRoutes[19] = new Route( 6, 3, 6, 1);
		listeRoutes[20] = new Route( 2, 1, 6, 5);
		listeRoutes[21] = new Route( 20, 10, 6, 7);
		listeRoutes[22] = new Route( 6, 3, 7, 2);
		listeRoutes[23] = new Route( 12, 6, 7, 3);
		listeRoutes[24] = new Route( 8, 4, 7, 4);
		listeRoutes[25] = new Route( 20, 10, 7, 6);

		setDistanceParcouru( 0 );
	}
	
	
	







	public Arraylist<Route> getCheminRoute() {

		return this.cheminRoute;
	}
	
	

	public void calculeItineraire() {
		
		int[] cheminNoeud = Dijkstra.cheminASuivre( distNoeud, 0, 3 ); //distNoeud, Depart, arrive
		this.cheminRoute.clear();
		
		for (int i =0; i<cheminNoeud.length()-1; i++) {
			
			for (int j = 0; j<= listeRoutes.length(), j++) {
				
				if(cheminNoeud[i] == listeRoutes[j].getNoeud(0) && cheminNoeud[i+1] == listeRoutes[j].getNoeud(1)) {
					
					this.cheminRoute.add(listeRoute[j]);
					
				}
					
			}
			
		}
		

		/*System.out.println( Arrays.toString( cheminNoeud ) );
        // int[] route = {-1};
        // int route = -1;
        int[] route = new int[3];
        route[0] = -1;
        route[1] = -1;
        route[2] = -1;
        int y = 0;

        // Trouver la route
        for ( int i = 0; i < cheminNoeud.length - 1; i++ ) {

            for ( int j = 0; j < associeNoeudRoute.length; j++ ) {
                //System.out.println(cheminNoeud[i] + " == " + associeNoeudRoute[j][0]);
                if ( cheminNoeud[i] == associeNoeudRoute[j][0] && cheminNoeud[i + 1] == associeNoeudRoute[j][1] ) {
                    System.out.println(i);
                    route[y] = i;
                    y++;
                }
            }
        }
        System.out.println( Arrays.toString( route ) );*/

		/*
		 * for(int i = 0; i < associeNoeudRoute.length; i++) { if(cheminRoute[0]
		 * == associeNoeudRoute[i][0]) {
		 * 
		 * for(int j = 0; j < 2; j++) {
		 * 
		 * if(cheminRoute[1] == associeNoeudRoute[i][j]) {
		 * 
		 * } } }
		 * 
		 * }
		 */

	}

	public void AjouterDistance( int distance ) {

	}

	public double getDistance() {
		return this.distanceParcouru;
	}

	public void setDistanceParcouru( int distance ) {
		this.distanceParcouru = distance;
	}

}