/* Nom: RouteTest
 * Version: 1.0
 * Date: 03/26/2021
 * Auteur: Membre de l'equipe 4
 * Copyright 2021 equipe 4
 * */

package Tests;

import Code.Gps;
import Code.Route;
/* 
 * Module de test sur le comportement des routes
 * 
 * */
public class RouteTest {

    public static void main( String[] args ) {
        Route r1 = new Route();
        Route r2 = new Route();
        Route r3 = new Route();
        
        Gps g = new Gps(2,3);
        
        System.out.println("Rapport sur les routes");
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println("**********************");
        
        r1.setTrafic( 10 );
        System.out.println(r1);
        
        
       
        
        
    }

}
