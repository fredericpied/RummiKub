package modele;

import java.util.ArrayList;
import java.util.Iterator;

import controler.RummikubException;

/**
 * Une séquence est une suite numérique de 3 chiffres ou plus de la même couleur respectant l'ordre chronologique.
 * Chaque chiffre est unique dans la séquence.
 * @author 09344a
 *
 */
public class Sequence {
	
	/**
	 * liste des plaques composants la séquence
	 */
	private ArrayList<Plaque> listePlaques = new ArrayList<Plaque>();

	/**
	 * Couleur de la séquence
	 */
	private Couleur couleurSequence;
	
	/**
	 * Retourne la couleur de la séquence
	 * @return Couleur
	 */
	public Couleur getCouleurSequence() {
		return couleurSequence;
	}


	/**
	 * Créer une nouvelle séquence composée de 3 plaques
	 * @param plaque1
	 * @param plaque2
	 * @param plaque3
	 * @throws RummikubException
	 */
	public Sequence(Plaque plaque1, Plaque plaque2, Plaque plaque3) throws RummikubException {
		
		// On vérifie que les trois plaques sont valorisée
		if (plaque1 == null
				|| plaque2 == null
				|| plaque3 == null)
				throw new RummikubException("La séquence doit contenir 3 plaques minimum.");
		
		
		// On vérifie que les trois plaques sont de la même couleur
		if (plaque1.getCouleur() != plaque2.getCouleur()
				|| plaque1.getCouleur() != plaque3.getCouleur()
				|| plaque2.getCouleur() != plaque3.getCouleur())
				throw new RummikubException("Les 3 plaques ne sont pas de la même couleur.");
		
		// On valorise l'attribut couleurSéquence de la classe
		this.couleurSequence = plaque1.getCouleur();
		
		// On initialize la liste sur 14 positions
		for (int indicePlaque=1;indicePlaque<=14;indicePlaque++) {
			this.listePlaques.add(null);
		}
		
		// On ajoute les 3 plaques à la séquence
		this.listePlaques.set(plaque1.getValeur(), plaque1);
		this.listePlaques.set(plaque2.getValeur(), plaque2);
		this.listePlaques.set(plaque3.getValeur(), plaque3);
		
		// On controle la cohérence de la séquence
		controlerSequence();
	}
	
	
	/**
	 * Ajoute une nouvelle plaque à la séquence
	 * @param plaque
	 * @throws RummikubException
	 */
	public void ajouterPlaque(Plaque plaque) throws RummikubException {
				
		// On vérifie que c'est la même couleur que les plaques présentes dans la séquence
		if (plaque.getCouleur() != this.couleurSequence) 
			throw new RummikubException("La séquence ne reçoit que des plaques de couleur "+this.couleurSequence+".");
		
		// On vérifie que la plaque n'existe pas déja dans la séquence
		if (this.listePlaques.get(plaque.getValeur()) == null) this.listePlaques.set(plaque.getValeur(), plaque);
		else throw new RummikubException("La séquence contient déja une plaque de valeur "+plaque.getValeur());
		
		// on controle la cohérence de la séquence
		controlerSequence();
		
	}
	
	/**
	 * Retourne et retire la dernière plaque de la séquence
	 * @return Plaque
	 * @throws RummikubException
	 */
	public Plaque retirerDernierePlaque() throws RummikubException {
		
		// Si la séquence contient 3 plaques, on ne peut pas en retirer
		if (this.getNombrePlaques() == 3)
			throw new RummikubException("La séquence doit contenir 3 plaques minimum.");

		// On supprime la dernière plaque de la liste (celle qui à la valeur la plus élevée)
		Plaque dernierePlaque = this.listePlaques.remove(this.getNombrePlaques());
		
		// On ajoute un null en fin de liste pour quelle conserve sa taille
		this.listePlaques.add(null); // On rajoute un null pour garder la taille maxi de la liste
		
		// On controle la cohérence de la séquence
		controlerSequence();
				
		// On retourne la plaque retirée
		return dernierePlaque;
	}
	
	/**
	 * Scinde la séquence en deux à partir de la plaque passée en paramètre. Celle ci devient la 
	 * première plaque de la deuxième séquence. La première séquence est retournée.
	 * @param plaque
	 * @return Sequence
	 * @throws RummikubException
	 */
	public Sequence scinderAvant(Plaque plaque) throws RummikubException {
		
		// Si la séquence contient moins de 6 plaques, on ne peut pas la scinder en deux
		if (this.getNombrePlaques() < 6)
			throw new RummikubException("La séquence doit contenir 6 plaques minimum pour pouvoir être scindée en deux.");
		
		// Si la plaque passée en paramètre n'est pas présente dans la séquence, on retour une exception
		if (! this.listePlaques.contains(plaque)) 
			throw new RummikubException("La plaque demandée n'est pas dans la série.");
		
		// On stocke l'index de la plaque passée en paramètre
		int indexPlaqueAvant = this.listePlaques.indexOf(plaque);
		
		// Si l'index est < 4, on ne peut pas scinder car l'une des séquence contiendrait moins de 3 plaques
		if (indexPlaqueAvant < 4)
			throw new RummikubException("Chaque nouvelle séquence doit contenir 3 plaques minimum.");
		// Si l'index est > 10, on ne peut pas scinder car l'une des séquence contiendrait moins de 3 plaques
		else if (indexPlaqueAvant > 10)
			throw new RummikubException("Chaque nouvelle séquence doit contenir 3 plaques minimum.");
		
		// On crée la première séquence (entre la premiere plaque et la plaque précédent celle passée en paramètre)
		Sequence sequenceAvant = new Sequence(this.listePlaques.get(1), this.listePlaques.get(2), this.listePlaques.get(3));
		
		// On supprimer ces trois plaque de la séquence courante
		this.listePlaques.set(1, null);
		this.listePlaques.set(2, null);
		this.listePlaques.set(3, null);
		
		// On ajoute les plaque suivante à la première séquence et on les supprime de la séquence courante
		int i=4;
		while (i < indexPlaqueAvant) {
			sequenceAvant.ajouterPlaque(this.listePlaques.get(i));
			this.listePlaques.set(i, null);
			i++;
		}
		
		// On controle la séquence courante (2ème séquence)
		controlerSequence();
		
		// On controle la premiere séquence
		sequenceAvant.controlerSequence();
		
		// Onn retourne la séquence courante
		return sequenceAvant;
			
	}
	
	/** 
	 * Méthode privée qui controle la cohérence de la séquence. Elle vérifie que toutes les plaques se suivent et
	 * qu'il n'y a pas de "trou" dans les valeurs des plaques
	 * @throws RummikubException
	 */
	private void controlerSequence() throws RummikubException {
		
		int positionPremierePlaque = -1;
		int positionDernierePlaque = -1;
		
		// On parcours les 13 positions de la liste des plaques composants la séquence
		for (int indicePlaque=1;indicePlaque<=13;indicePlaque++) {

			// Si la position de la première plaque de la séquence n'est pas valorisée
			if (positionPremierePlaque == -1) {

				// Si la plaque en position courante n'est pas null, On enregistre la position de la premiere plaque de la séquence
				if (this.listePlaques.get(indicePlaque) != null)
					positionPremierePlaque = indicePlaque;

			// Sinon si la position de la DERNIERE plaque de la séquence n'est pas valorisée
			} else if (positionDernierePlaque == -1) { 
				
				// si on trouve un emplacement vide, on enregistre la position précédente comme dernière plaque de la séquence
				if (this.listePlaques.get(indicePlaque) == null)
					positionDernierePlaque = indicePlaque-1;
			
			} 

			
			// Si on a enregistré la position de la dernière plaque de la séquence mais que
			// l'on trouve un nouvel emplacement occupé, c'est qu'il y a un trou
			if (positionDernierePlaque != -1 && this.listePlaques.get(indicePlaque) != null) {
				int positionTrou = positionDernierePlaque+1;
				throw new RummikubException("Il manque une plaque dans la séquence en position "+positionTrou+".");
			}
		}
	}
	
	/**
	 * Retourne le contenu de la séquence dans une chaine de caractère
	 * @return String
	 */
	public String toString() {
		String chaine = "";
		
		// On créer un itérateur sur la liste des plaques composants la séquence
		Iterator<Plaque> iterPlaque = this.listePlaques.iterator();
		while (iterPlaque.hasNext()) {
			Plaque plaque = iterPlaque.next();
			
			// Pour chaque plaque, on concatene son nom au nom des autres plaques composants la séquence
			if (plaque != null) chaine = chaine + plaque.getNomPlaque()+ " ";
		}
		
		return chaine.substring(0, chaine.length()-1);
	}


	/**
	 * Retourne le nombre de plaques dans la séquence
	 * @return int
	 */
	public int getNombrePlaques() {
		int nbPlaques = 0;
		Iterator<Plaque> iterPlaque = this.listePlaques.iterator();
		while (iterPlaque.hasNext()) {
			if (iterPlaque.next() != null) nbPlaques++;
		}
				
		return nbPlaques;
	}
	
	
}
