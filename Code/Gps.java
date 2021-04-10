/* Nom: Gps
 * Version: 1.0
 * Date: 03/26/2021
 * Auteur: Membres de l'equipe 4
 * 
 * Description: Permet de recuperer la trajectoire de la voiture et l'etat des routes sur la carte
 * 
 * Copyright 2021 equipe 4
 * */
package Code;

import java.util.Arrays;	
import java. util.ArrayList;

import Code.Dijkstra;


public class Gps extends Route {

	/**
	 * Attributs de la classe
	 */
	private int noeudDepart;
	private int noeudFin;

	protected ArrayList<Route> cheminRoute;
	private int distanceParcourue;
	public Route[] listeRoutes;

	// Graphe d'origine sans congestion
	protected static int[][] distNoeud = { { 0, 5, 0, 0, 0, 1, 2, 0 },
			{ 5, 0, 1, 0, 0, 0, 3, 0 },
			{ 0, 1, 0, 6, 0, 0, 0, 3 },
			{ 0, 0, 6, 0, 12, 0, 0, 6 },
			{ 0, 0, 0, 12, 0, 3, 0, 4 },
			{ 1, 0, 0, 0, 3, 0, 1, 0 },
			{ 2, 3, 0, 0, 0, 1, 0, 10 },
			{ 0, 0, 3, 6, 4, 0, 10, 0 } };

	protected  int[][] copieGraphe = distNoeud.clone();

	/**
	 * Constructeur sans parametre permettant de creer l'ensemble des routes.
	 */
	public Gps(int noeudDepart, int noeudFin) {

		this.noeudDepart = noeudDepart;

		this.noeudFin = noeudFin;

		cheminRoute = new ArrayList<Route>() ;

		creationRoute();

		setDistanceParcourue( 0 );
	}

	/**
	 * Creation des routes
	 */
	public void creationRoute() {

		listeRoutes = new Route[26]; // Creer les routes
		listeRoutes[0]  = new Route( 100, 5, 0, 1);  //maxVoiture, longueur, noeudDepart, noeudArrive
		listeRoutes[1]  = new Route( 100, 2, 0, 6); 
		listeRoutes[2]  = new Route( 20, 1, 0, 5); 
		listeRoutes[3]  = new Route( 100, 5, 1, 0);
		listeRoutes[4]  = new Route( 20, 1, 1, 2);
		listeRoutes[5]  = new Route( 60, 3, 1, 6);
		listeRoutes[6]  = new Route( 20, 1, 2, 1);
		listeRoutes[7]  = new Route( 60, 3, 2, 7);
		listeRoutes[8]  = new Route( 12, 6, 2, 3);
		listeRoutes[9]  = new Route( 12, 6, 3, 2);
		listeRoutes[10] = new Route( 12, 6, 3, 7);
		listeRoutes[11] = new Route( 24, 12, 3, 4);
		listeRoutes[12] = new Route( 60, 3, 4, 5);
		listeRoutes[13] = new Route( 80, 4, 4, 7);
		listeRoutes[14] = new Route( 24, 12, 4, 3);
		listeRoutes[15] = new Route( 20, 1, 5, 0);
		listeRoutes[16] = new Route( 20, 1, 5, 6);
		listeRoutes[17] = new Route( 6, 3, 5, 4);
		listeRoutes[18] = new Route( 40, 2, 6, 0);
		listeRoutes[19] = new Route( 60, 3, 6, 1);
		listeRoutes[20] = new Route( 20, 1, 6, 5);
		listeRoutes[21] = new Route( 20, 10, 6, 7);
		listeRoutes[22] = new Route( 60, 3, 7, 2);
		listeRoutes[23] = new Route( 12, 6, 7, 3);
		listeRoutes[24] = new Route( 80, 4, 7, 4);
		listeRoutes[25] = new Route( 20, 10, 7, 6);

	}

	/**
	 * Accesseur pour le tableau de routes
	 * @return : ArrayList cheminRoute
	 */
	public ArrayList<Route> getCheminRoute() {

		return this.cheminRoute;
	}

	/**
	 * Initialise le noeud de depart
	 * @param n : le noeud de depart
	 */
	public void setNoeudDepart( int n ) {

		this.noeudDepart = n;
	}

	/**
	 * Initialise le noeud d'arrivee
	 * @param n : le noeud d'arrivee
	 */
	public void setNoeudFin( int n ) {

		this.noeudFin = n;
	}

	/**
	 * Accesseur pour le noeud de depart
	 * @return le noeud de depart
	 */
	public int getNoeudDepart() {

		return noeudDepart;
	} 

	/**
	 * Accesseur pour le noeud d'arrivee
	 * @return le noeud d'arrivee
	 */
	public int getNoeudFin() {

		return this.noeudFin ;
	}



	/**
	 * Transforme le tableau de noeud de dijkstra en tableau de routes.
	 * @throws ArrayIndexOutOfBoundsException 
	 * @throws ArrayIndexOutOfBoundsException 
	 */
	public void calculeItineraire(int positionActuelle) throws ArrayIndexOutOfBoundsException  {

		//System.out.println(Arrays.toString(listeRoutes));

		copieGraphe = modifierGraphe();


		int sommeCongestion = 0;

		do {

			for(int y = 0; y < copieGraphe[positionActuelle].length; y++) {

				sommeCongestion += copieGraphe[positionActuelle][y];

			}

			if (sommeCongestion == 0) {

				reinitialiserTraffic();

				modifierGraphe();
			}
		}while(sommeCongestion == 0);


		int [] cheminNoeud = Dijkstra.cheminASuivre(copieGraphe, positionActuelle, noeudFin ); //Graphe, Depart, Arrivee


		if (!this.cheminRoute.isEmpty()) {

			this.cheminRoute.clear();

		}

		for (int i =0; i<cheminNoeud.length-1; i++) {

			for (int j = 0; j<= listeRoutes.length-1; j++) {

				if((cheminNoeud[i] == listeRoutes[j].getNoeud(0)) && 
						(cheminNoeud[i+1] == listeRoutes[j].getNoeud(1))) {

					this.cheminRoute.add(listeRoutes[j]);
					//si une route est relie par les deux noeuds, l'ajouter 
				}
			}	
		}

	}


	/**
	 * Ajoute la distance recemment parcourue a la distance totale parcourue.
	 * @param distance : distance recemment parcourue
	 */
	protected void ajouterDistance( int distance ) {

		distanceParcourue += distance;
	}

	/**
	 * 
	 * @return liste des routes
	 */
	public Route[] getListeRoute() {

		return listeRoutes;
	}

	public void reinitialiserTraffic() {

		for(int i = 0;  i < listeRoutes.length; i++) {

			listeRoutes[i].genererTrafic();
		}

	}

	/**
	 * Accesseur pour la distance totale parcourue
	 * @return la distance totale parcourue
	 */
	public double getDistance() {
		return this.distanceParcourue;
	}

	/**
	 * Initialise la distance totale parcourue
	 * @param distance : distance totale parcourue
	 */
	private void setDistanceParcourue( int distance ) {

		this.distanceParcourue = distance;
	}

	/**
	 * Modifie le graphe en remplacant les routes fermees par des 0 dans 
	 * la copie du graphe de depart.
	 * @return la copie du graphe de depart avec les routes fermees
	 */
	private int[][] modifierGraphe(){

		copieGraphe = distNoeud.clone();

		for (int i = 0 ; i< listeRoutes.length; i++) {

			if((listeRoutes[i].getEtat() == EtatRoute.CONGESTION) || ( listeRoutes[i].getEtat() == EtatRoute.ACCIDENT)){	// Si une route est fermee

				copieGraphe[listeRoutes[i].getNoeud(0) ][listeRoutes[i].getNoeud(1)] = 0 ;
			}
		}

		



		return copieGraphe;
	}


	/**
	 * Main pour tester les methodes de Gps
	 * @param args
	 */
	/*
	public static void main (String args[]) {

		Gps g = new Gps(2,5);

		int [][] g2 = g.modifierGraphe();

		for(int i = 0; i < g2.length; i++) {
			System.out.print("[");
			for(int j = 0; j < g2[i].length; j++) {
				System.out.print(g2[i][j] + " ");
			}
			System.out.print("]");
			System.out.println();
		}

		//System.out.println(Arrays.deepToString(g2));

	}
	 */

}