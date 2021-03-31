/* Nom: Gps
 * Version: 1.0
 * Date: 03/26/2021
 * Auteur: Membres de l'équipe 4
 * Copyright 2021 Équipe 4
 * */
package Code;

import java.util.Arrays;

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

    private static int[][] associeNoeudRoute = {
            { 1, 0 },
            { 0, 1 },
            {0,6},
            {6,0}
    };
    
    
    Route[]                listeRoutes;

    public Gps() {

        listeRoutes = new Route[26]; // Creer les routes
        setDistanceParcouru( 0 );
    }

    public int[] getItineraire() {

        return this.cheminRoute;
    }

    public void calculeItineraire() {
        int[] cheminNeud = Dijkstra.cheminASuivre( distNoeud, 0, 3 );

        System.out.println( Arrays.toString( cheminNeud ) );
        // int[] route = {-1};
        // int route = -1;
        int[] route = new int[3];
        route[0] = -1;
        route[1] = -1;
        route[2] = -1;
        int y = 0;

        // Trouver la route
        for ( int i = 0; i < cheminNeud.length - 1; i++ ) {
    
            for ( int j = 0; j < associeNoeudRoute.length; j++ ) {
                //System.out.println(cheminNeud[i] + " == " + associeNoeudRoute[j][0]);
                if ( cheminNeud[i] == associeNoeudRoute[j][0] && cheminNeud[i + 1] == associeNoeudRoute[j][1] ) {
                    System.out.println(i);
                    route[y] = i;
                    y++;
                }
            }
        }
        System.out.println( Arrays.toString( route ) );

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