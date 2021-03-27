/* Nom: Route
 * Version: 1.0
 * Date: 03/26/2021
 * Auteur: Marc-Antoine Ricard
 * Copyright 2021 Équipe 4
 * */
package Code;

import java.util.Random;

/* Cette class permet de représenter le comportement d'une route */
public class Route {

    private static int id = 0;     // Identifiant unique générer pour chaque route

    private int        nom;
    private int        maxVoiture;
    private int        nbreVoiture;
    private double     longueur;
    EtatRoute          etat;

    public Route() {
        this.nom = genererID();
        maxVoiture = 10;
        setTrafic( genererTrafic() );
        setLongueur( 20.0 );
        setEtat();
    }

    public Route( int nbreVoiture, int maxVoiture, double longueur ) {
        this.nom = genererID();
        setMaxVoiture( maxVoiture );
        setTrafic( nbreVoiture );
        setLongueur( longueur );
        setEtat();
    }

    /*
     * Permet de générer un identifiant unique pour la route
     * 
     * @return l'id de la route
     */
    private int genererID() {
        return id++;
    }

    /*
     * Permet de générer le nombre de voitures sur la route
     * 
     * @return nombre de voitures sur la route
     */
    public int genererTrafic() {
        Random random = new Random();
        return random.nextInt( maxVoiture + 1 );
    }

    /*
     * Permet d'insérer un nombre de voitures précis sur la route
     * 
     * @param nVoiture le nombre de voitures sur la rout
     */
    public void setTrafic( int nVoiture ) {
        if ( nVoiture <= maxVoiture ) {
            this.nbreVoiture = nVoiture;
            
            setEtat(); // Mettre a jour l'etat de la route
        } else {
            this.nbreVoiture = 0;
        }
    }

    public void setMaxVoiture( int maxVoiture ) {
        if ( maxVoiture <= 100 ) {
            this.maxVoiture = maxVoiture;
        } else {
            this.maxVoiture = 10;
        }
    }

    /*
     * Permet de changer l'état de la route selon le trafic et les accidents
     * 
     */
    public void setEtat() {
        if ( Accident.causeAccident() == true ) {
            this.etat = EtatRoute.ACCIDENT;
        } else if ( this.nbreVoiture == this.maxVoiture ) {
            this.etat = EtatRoute.CONGESTION;
        } else {
            this.etat = EtatRoute.FLUIDE;
        }
    }

    /*
     * Permet d'obtenir le nom de la route
     *
     * @return nom de la route
     */
    public int getNom() {
        return this.nom;
    }

    /*
     * Permet d'obtenir le nombre de voiture sur la route
     *
     * @return le nombre de voiture sur la route
     */
    public int getNbreVoiture() {
        return this.nbreVoiture;
    }

    /*
     * Permet d'obtenir le nombre de voiture sur la route
     *
     * @return le nombre de voiture sur la route
     */
    public int getMaxVoiture() {
        return this.maxVoiture;
    }

    /*
     * Permet d'obtenir la distance de la route
     *
     * @return la distance de la route
     */
    public double getLongueur() {
        return this.longueur;
    }

    /*
     * Permet de definir la longueur de la route
     */
    public void setLongueur( double longueur ) {
        this.longueur = longueur;
    }

    /*
     * Permet d'obtenir l'etat de la route
     *
     * @return l'etat de la route
     */
    public EtatRoute getEtat() {
        return this.etat;
    }

    /* Permet d'acceder a la description complete de la route
     * 
     * @return La description complete de la route
     */
    public String toString() {
        return "Nom: " + getNom() + " Nbre de voitures: " + getNbreVoiture() + "/" + getMaxVoiture() + " tailles: "
                + getLongueur() + " Etat; " + getEtat();
    }

}
