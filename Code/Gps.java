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
public class Gps extends Route {
	
	
	private int noeudDepart;
	private int noeudFin;
	
	private ArrayList<Route>          cheminRoute;
	private int                       distanceParcouru;
	private static int[][] distNoeud         = { { 0, 5, 0, 0, 0, 1, 2, 0 },
			{ 5, 0, 1, 0, 0, 0, 3, 0 },
			{ 0, 1, 0, 6, 0, 0, 0, 3 },
			{ 0, 0, 6, 0, 12, 0, 0, 6 },
			{ 0, 0, 0, 12, 0, 3, 0, 4 },
			{ 1, 0, 0, 0, 3, 0, 1, 0 },
			{ 2, 3, 0, 0, 0, 1, 0, 10 },
			{ 0, 0, 3, 6, 4, 0, 10, 0 } };
	
	Route[]                listeRoutes;

	public Gps() {

		System.out.println("Dans le constructeur par default");
		this.noeudDepart = 0;
		this.noeudFin = 3;
		
		cheminRoute = new ArrayList<Route>() ;

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

	public ArrayList<Route> getCheminRoute() {

		return this.cheminRoute;
	}
	
	public void setNoeudDepart( int n ) {
		
		this.noeudDepart = n;
	}
	
	public void setNoeudFin( int n ) {
		
		this.noeudFin = n;
	}
	
	public int getNoeudDepart() {
		
		return noeudDepart;
	} 
	
	public int getNoeudFin() {
		
		return this.noeudFin ;
	}

	public void calculeItineraire() {

		int[] cheminNoeud = Dijkstra.cheminASuivre( distNoeud, noeudDepart, noeudFin ); //distNoeud, Depart, arrive

		if (!this.cheminRoute.isEmpty()) {

			this.cheminRoute.clear();
			
		}
		
		for (int i =0; i<cheminNoeud.length-1; i++) {

			for (int j = 0; j<= listeRoutes.length-1; j++) {

				
				if( (cheminNoeud[i] == listeRoutes[j].getNoeuds(0) ) && (cheminNoeud[i+1] == listeRoutes[j].getNoeuds(1))) {

					this.cheminRoute.add(listeRoutes[j]);

				}

			}

		}

	}

	protected void AjouterDistance( int distance ) {

		distanceParcouru += distance;
		
	}

	public double getDistance() {
		return this.distanceParcouru;
	}

	private void setDistanceParcouru( int distance ) {
		this.distanceParcouru = distance;
	}

}