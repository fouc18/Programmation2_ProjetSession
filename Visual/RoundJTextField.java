/* Nom: RoundJTextField
 * Version: 1.0
 * Date: 03/28/2021
 * Auteur: Membres de l'équipe 4
 * Copyright 2021 Équipe 4
 * */

package Visual;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextArea;

/* Cette classe permet d'arrondir les zones de textes afin de representer graphiquement les noeuds */
public class RoundJTextField extends JTextArea {
    private Shape shape;

    public RoundJTextField() {
        super( 3, 4 ); //Taille des noeuds par defaut
        setOpaque( false ); //Ne pas afficher les coins dans la limite du composant
    }

    /* Colorier la couleur du composant
    *  @param   g   l'objet graphique du composant
    * */
    protected void paintComponent( Graphics g ) {
        g.setColor( getBackground() );
        g.fillRoundRect( 0, 0, getWidth() - 1, getHeight() - 1, 15, 15 );
        super.paintComponent( g );
    }

    /* Colorier les bords du composant
    *  @param   g   l'objet graphique du composant
    * */
    protected void paintBorder( Graphics g ) {
        g.setColor( getForeground() );
        g.drawRoundRect( 0, 0, getWidth() - 1, getHeight() - 1, 15, 15 );
    }

    /* Tester si un point est dans le composant
    *   @param  x   la coordonnee X d'un point
    *   @param  y   la coordonnee Y d'un point
    *   @return Si le point est dans le composant
    * */
    public boolean contains( int x, int y ) {
        if ( shape == null || !shape.getBounds().equals( getBounds() ) ) {
            shape = new RoundRectangle2D.Float( 0, 0, getWidth() - 1, getHeight() - 1, 15, 15 );
        }
        return shape.contains( x, y );
    }
}