/* Nom: Voiture
 * Version: 1.0
 * Date: 03/28/2021
 * Auteur: Membres de l'équipe 4
 * Copyright 2021 Équipe 4
 * */
package Code;

/* Cette class permet de representer le comportement d'une voiture */
public class Voiture {
    private int depart;
    private int fin;
    private int positionActuelle;

    public Voiture(){
        this.depart = 'A';
        this.fin = 'D';
        this.positionActuelle = this.depart;
    }

    public Voiture(char depart, char fin) {
        this.depart = depart;
        this.fin = fin;
        this.positionActuelle = depart;
    }

    public boolean avancer(){
        //super.getItineraire()
        int[] chemin = {0,1,2,5};

        return true;
    }

}
