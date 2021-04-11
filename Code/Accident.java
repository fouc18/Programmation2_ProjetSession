/* Nom: Accident
 * Version: 1.0
 * Date: 03/26/2021
 * Auteur: Membres de l'equipe 4
 * Copyright 2021 equipe 4
 * */
package Code;

import java.util.Random;

/* Permet de definir si un accident a lieu sur une route */
public class Accident {
    
    private static int probabilite = 5; //Probabilite d'avoir un accident en %
    
    /* Permet de generer si un accident est cause
     * 
     * @return  un boolean si un accident a lieu
     * */
    public static boolean causeAccident() {
        Random random = new Random();
        
        if(random.nextInt( 100 ) < probabilite) {
            return true;
        }
        return false;
    }
    
}
