package Code;

/**
 * Nom: Dijkstra
 * Version: 1.0
 * Date: 03/29/2021
 * Auteur: Membres de l'équipe 4
 * Copyright 2021 équipe 4
 * La classe Dijkstra implémente l'algorithme du
 * même nom permettant de trouver le chemin le 
 * plus cours entre deux noeuds dans un graphe.
 * Ce programme utilise un graphe sous un format
 * matriciel.
 */

import java.util.ArrayList;
import java.util.Arrays;

class Dijkstra {

	/**
	 * Constantes et variables globales
	 */
    private static final int AUCUN_PARENT = -1;
    
    private static int[] distancesMin;
    private static int[] parents;
    private static ArrayList<Integer> route = new ArrayList<Integer>();
    
    /**
     * Présente sous forme d'un tableau d'entiers le chemin le plus court 
     * entre un noeud de départ et un noeud d'arrivée.
     * @param grapheMatrice : Une matrice en deux dimensions représentant un graphe
     * @param noeudDepart : Le noeud d'où commencera le chemin
     * @param noeudArrivee : Le noeud où finira le chemin
     * @return un tableau d'entiers contenant le chemin le plus court
     */
    public static int [] cheminASuivre(int[][] grapheMatrice, int noeudDepart, int noeudArrivee) {
    	
    	dijkstra(grapheMatrice, noeudDepart);
    	
    	route = getChemin(noeudArrivee, parents);
    	
    	int [] chemin = new int [route.size()];
    	
    	for(int i = 0; i < route.size(); i++) {
    		chemin[i] = route.get(i);
    	}
    	
    	return chemin;
    }
    
    /**
     * Tire du tableau parent le chemin le plus court
     * @param noeudActuel : Le noeud évalué
     * @param parents : Le tableau contenant l'ensemble des chemins
     * @return un ArrayList contenant le chemin le plus court du noeud
     * de départ au noeud d'arrivée
     */
	private static ArrayList<Integer> getChemin(int noeudActuel, int[] parents) {
	    	
	    	// Base case : Source node has
	        // been processed
	        if (noeudActuel == AUCUN_PARENT) {
	            return route;
	        } else {
	        	route = getChemin(parents[noeudActuel], parents);
	            route.add(noeudActuel);
	        }
			return route;
	}
	
	/**
	 * Permet d'accéder à la distance que représente le chemin le
	 * plus court
	 * @param grapheMatrice : Une matrice en deux dimensions représentant un graphe
	 * @param noeudDepart : Le noeud d'où commence le chemin
	 * @param noeudArrivee : Le noeud où finit le chemin
	 * @return La distance parcourue sous forme d'un entier
	 */
	public static int distanceMin(int[][] grapheMatrice, int noeudDepart, int noeudArrivee) {
	    	
	    	dijkstra(grapheMatrice, noeudDepart);
	    	return distancesMin[noeudArrivee];
	}
    
    /**
     * Calcule, à partir d'un point de départ, le chemin le plus court vers chacun 
     * des noeuds du graphe, ainsi que la distance qu'il représente. Stocke ces
     * résultats dans les variables globales parents et distancesMin respectivement.
     * @param grapheMatrice : Une matrice en deux dimensions représentant un graphe
     * @param noeudDepart : Le noeud d'où commencera le calcul des chemins
     */
    private static void dijkstra(int[][] grapheMatrice, int noeudDepart) {
    	
        int nbNoeuds = grapheMatrice[0].length;

        /*
         * Contiendra les distances les plus courtes de
         * noeudDepart à chacun des noeuds d'arrivée
         */
        distancesMin = new int[nbNoeuds];

        /*
         * ajoute[i] sera true si le noeud i à été évalué et 
         * ajouté à l'arbre de chemins possibles
         */
        boolean[] ajoute = new boolean[nbNoeuds];

        /*
         * Initialise toutes les distances à la plus grande
         * valeur possible et tout le tableau ajoute à false
         */
        for (int noeudIndex = 0; noeudIndex < nbNoeuds; noeudIndex++)
        {
            distancesMin[noeudIndex] = Integer.MAX_VALUE;
            ajoute[noeudIndex] = false;
        }

        /*
         * La distance entre le noeud de départ et lui-même
         * est toujours de 0.
         */
        distancesMin[noeudDepart] = 0;

        // Contient l'arbre des plus courts chemins
        parents = new int[nbNoeuds];

        // Le noeud de départ n'a pas de parent
        parents[noeudDepart] = AUCUN_PARENT;

        // Trouve le plus court chemin pour chaque noeud d'arrivée
        for (int i = 1; i < nbNoeuds; i++)
        {

        	/*
        	 * Choisi le noeud le plus près parmi les noeuds
        	 * qui n'ont pas encore été évalués. noeudVoisin est 
        	 * toujours le noeud de départ à la première itération.
        	 */
            int noeudVoisin = -1;
            int distanceMin = Integer.MAX_VALUE;
            for (int noeudIndex = 0; noeudIndex < nbNoeuds; noeudIndex++)
            {
                if (!ajoute[noeudIndex] && distancesMin[noeudIndex] < distanceMin)
                {
                    noeudVoisin = noeudIndex;
                    distanceMin = distancesMin[noeudIndex];
                }
            }

            // Marque le noeud choisi comme évalué
            ajoute[noeudVoisin] = true;

            /*
             * Met à jour la distance des noeuds voisins en
             * fonction du noeud choisi.
             */
            for (int noeudIndex = 0; noeudIndex < nbNoeuds; noeudIndex++)
            {
                int routeLongueur = grapheMatrice[noeudVoisin][noeudIndex];

                if (routeLongueur > 0 && ((distanceMin + routeLongueur) < distancesMin[noeudIndex]))
                {
                    parents[noeudIndex] = noeudVoisin;
                    distancesMin[noeudIndex] = distanceMin + routeLongueur;
                }
            }
        }
    }

    
    // Main pour tester
    public static void main(String[] args)
    {
        int[][] adjacencyMatrix = { { 0, 5, 0, 0, 0, 1, 2, 0},
                { 5, 0, 1, 0, 0, 0, 3, 0},
                { 0, 1, 0, 6, 0, 0, 0, 3},
                { 0, 0, 6, 0, 12, 0, 0, 6},
                { 0, 0, 0, 12, 0, 3, 0, 4},
                { 1, 0, 0, 0, 3, 0, 1, 0},
                { 2, 3, 0, 0, 0, 1, 0, 10},
                { 0, 0, 3, 6, 4, 0, 10, 0}};

        //dijkstra(adjacencyMatrix, 0);
        int distance0_3 = distanceMin(adjacencyMatrix, 1, 4);
        System.out.println(distance0_3);
        int[] chemin0_3 = cheminASuivre(adjacencyMatrix, 1, 4);
        System.out.println(Arrays.toString(chemin0_3));
    }
}

// Ce code a été inspiré de Harikrishnan Rajan
