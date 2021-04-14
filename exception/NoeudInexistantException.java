/**
 * Nom: NoeudInexistantException
 * Version: 1.0
 * Date: 04/14/2021
 * Auteur: Membres de l'equipe 4
 * 
 * Description : Permet d'informer le programme que les noeuds sont invalides
 * 
 * Copyright 2021 equipe 4
 */

package exception;

public class NoeudInexistantException extends Exception {

	public NoeudInexistantException() {
		super("Le noeud que vous avez saisie n'existe pas !");
	}

	
}
