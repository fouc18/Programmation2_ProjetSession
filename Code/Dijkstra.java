/**
 * Nom: Dijkstra
 * Version: 1.0
 * Date: 03/29/2021
 * Auteur: Membres de l'equipe 4
 * 
 * Description :La classe Dijkstra implemente l'algorithme du
 * même nom permettant de trouver le chemin le plus cours entre
 * deux noeuds dans un graphe.
 * Ce programme utilise un graphe sous un format matriciel.
 * 
 * Copyright 2021 equipe 4
 */

package Code;

import java.util.ArrayList;
import java.util.Arrays;

public class Dijkstra {

	/**
	 * Constantes et variables globales
	 */
    private static final int AUCUN_PARENT = -1;
    
    private static int[] distancesMin;
    private static int[] parents;
    private static ArrayList<Integer> route = new ArrayList<Integer>();
    
    /**
     * Presente sous forme d'un tableau d'entiers le chemin le plus court 
     * entre un noeud de depart et un noeud d'arrivee.
     * @param grapheMatrice : Une matrice en deux dimensions representant un graphe. 
     * @param noeudDepart : Le noeud d'ou commencera le chemin
     * @param noeudArrivee : Le noeud ou finira le chemin
     * @return un tableau d'entiers contenant le chemin le plus court
     * @throws ArrayIndexOutOfBoundsException 
     * 
     */
    public static int [] cheminASuivre(int[][] grapheMatrice, int noeudDepart, int noeudArrivee)  {
    	
    	route.clear();
    	
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
     * @param noeudActuel : Le noeud evalue
     * @param parents : Le tableau contenant l'ensemble des chemins
     * @return un ArrayList contenant le chemin le plus court du noeud
     * de depart au noeud d'arrivee
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
	 * Permet d'acceder à la distance que represente le chemin le
	 * plus court
	 * @param grapheMatrice : Une matrice en deux dimensions representant un graphe
	 * @param noeudDepart : Le noeud d'ou commence le chemin
	 * @param noeudArrivee : Le noeud ou finit le chemin
	 * @return La distance parcourue sous forme d'un entier
	 * @throws ArrayIndexOutOfBoundsException 
	 * @throws ArrayIndexOutOfBoundsException 
	 */
	public static int distanceMin(int[][] grapheMatrice, int noeudDepart, int noeudArrivee)  {
	    	
	    	dijkstra(grapheMatrice, noeudDepart);
	    	return distancesMin[noeudArrivee];
	}
    
    /**
     * Calcule, a partir d'un point de dée distance qu'il represente. Stocke ces
     * resultats dans les variables globales parents et distancesMin respectivement.
     * @param grapheMatrice : Une matrice en deux dimensions representant un graphe
     * @param noeudDepart : Le noeud d'ou commencera le calcul des chemins
     * @throws ArrayIndexOutOfBoundsException 
     */
    private static void dijkstra(int[][] grapheMatrice, int noeudDepart) throws ArrayIndexOutOfBoundsException    {
    	
    	
    	
        int nbNoeuds = grapheMatrice[0].length;

        /*
         * Contiendra les distances les plus courtes de
         * noeudDepart a chacun des noeuds d'arrivee
         */
        distancesMin = new int[nbNoeuds];

        /*
         * ajoute[i] sera true si le noeud i a ete evalue et 
         * ajoute a l'arbre de chemins possibles
         */
        boolean[] ajoute = new boolean[nbNoeuds];

        /*
         * Initialise toutes les distances a la plus grande
         * valeur possible et tout le tableau ajoute a false
         */
        for (int noeudIndex = 0; noeudIndex < nbNoeuds; noeudIndex++)
        {
            distancesMin[noeudIndex] = Integer.MAX_VALUE;
            ajoute[noeudIndex] = false;
        }

        /*
         * La distance entre le noeud de depart et lui-meme
         * est toujours de 0.
         */
        distancesMin[noeudDepart] = 0;

        // Contient l'arbre des plus courts chemins
        parents = new int[nbNoeuds];
	for (int i = 0; i < parents.length; i++)
            parents[i] = AUCUN_PARENT;

        // Trouve le plus court chemin pour chaque noeud d'arrivee
        for (int i = 1; i < nbNoeuds; i++)
        {

        	/*
        	 * Choisi le noeud le plus pres parmi les noeuds
        	 * qui n'ont pas encore ete evalue. noeudVoisin est 
        	 * toujours le noeud de depart à la premiere iteration.
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

           
            // Marque le noeud choisi comme evalue
	    if  (noeudVoisin != -1)
                ajoute[noeudVoisin] = true ;
          
            /*
             * Met a jour la distance des noeuds voisins en
             * fonction du noeud choisi.
             */
            for (int noeudIndex = 0; noeudIndex < nbNoeuds; noeudIndex++)
            {
                int routeLongueur = grapheMatrice[noeudVoisin][noeudIndex];
		
		if(noeudVoisin == -1)
		    routeLongueur = 0;

                if (routeLongueur > 0 && ((distanceMin + routeLongueur) < distancesMin[noeudIndex]))
                {
                    parents[noeudIndex] = noeudVoisin;
                    distancesMin[noeudIndex] = distanceMin + routeLongueur;
                }
            }
        }
        
    	 
    }

}

// Ce code a ete inspire de Harikrishnan Rajan
