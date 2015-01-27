package modele;

import java.util.ArrayList;
import java.util.Iterator;

import controler.RummikubException;

/**
 * Une s�quence est une suite num�rique de 3 chiffres ou plus de la m�me couleur respectant l'ordre chronologique.
 * Chaque chiffre est unique dans la s�quence.
 * @author 09344a
 *
 */
public class Sequence {
	
	/**
	 * liste des plaques composants la s�quence
	 */
	private ArrayList<Plaque> listePlaques = new ArrayList<Plaque>();

	/**
	 * Couleur de la s�quence
	 */
	private Couleur couleurSequence;
	
	/**
	 * Retourne la couleur de la s�quence
	 * @return Couleur
	 */
	public Couleur getCouleurSequence() {
		return couleurSequence;
	}


	/**
	 * Cr�er une nouvelle s�quence compos�e de 3 plaques
	 * @param plaque1
	 * @param plaque2
	 * @param plaque3
	 * @throws RummikubException
	 */
	public Sequence(Plaque plaque1, Plaque plaque2, Plaque plaque3) throws RummikubException {
		
		// On v�rifie que les trois plaques sont valoris�e
		if (plaque1 == null
				|| plaque2 == null
				|| plaque3 == null)
				throw new RummikubException("La s�quence doit contenir 3 plaques minimum.");
		
		
		// On v�rifie que les trois plaques sont de la m�me couleur
		if (plaque1.getCouleur() != plaque2.getCouleur()
				|| plaque1.getCouleur() != plaque3.getCouleur()
				|| plaque2.getCouleur() != plaque3.getCouleur())
				throw new RummikubException("Les 3 plaques ne sont pas de la m�me couleur.");
		
		// On valorise l'attribut couleurS�quence de la classe
		this.couleurSequence = plaque1.getCouleur();
		
		// On initialize la liste sur 14 positions
		for (int indicePlaque=1;indicePlaque<=14;indicePlaque++) {
			this.listePlaques.add(null);
		}
		
		// On ajoute les 3 plaques � la s�quence
		this.listePlaques.set(plaque1.getValeur(), plaque1);
		this.listePlaques.set(plaque2.getValeur(), plaque2);
		this.listePlaques.set(plaque3.getValeur(), plaque3);
		
		// On controle la coh�rence de la s�quence
		controlerSequence();
	}
	
	
	/**
	 * Ajoute une nouvelle plaque � la s�quence
	 * @param plaque
	 * @throws RummikubException
	 */
	public void ajouterPlaque(Plaque plaque) throws RummikubException {
				
		// On v�rifie que c'est la m�me couleur que les plaques pr�sentes dans la s�quence
		if (plaque.getCouleur() != this.couleurSequence) 
			throw new RummikubException("La s�quence ne re�oit que des plaques de couleur "+this.couleurSequence+".");
		
		// On v�rifie que la plaque n'existe pas d�ja dans la s�quence
		if (this.listePlaques.get(plaque.getValeur()) == null) this.listePlaques.set(plaque.getValeur(), plaque);
		else throw new RummikubException("La s�quence contient d�ja une plaque de valeur "+plaque.getValeur());
		
		// on controle la coh�rence de la s�quence
		controlerSequence();
		
	}
	
	/**
	 * Retourne et retire la derni�re plaque de la s�quence
	 * @return Plaque
	 * @throws RummikubException
	 */
	public Plaque retirerDernierePlaque() throws RummikubException {
		
		// Si la s�quence contient 3 plaques, on ne peut pas en retirer
		if (this.getNombrePlaques() == 3)
			throw new RummikubException("La s�quence doit contenir 3 plaques minimum.");

		// On supprime la derni�re plaque de la liste (celle qui � la valeur la plus �lev�e)
		Plaque dernierePlaque = this.listePlaques.remove(this.getNombrePlaques());
		
		// On ajoute un null en fin de liste pour quelle conserve sa taille
		this.listePlaques.add(null); // On rajoute un null pour garder la taille maxi de la liste
		
		// On controle la coh�rence de la s�quence
		controlerSequence();
				
		// On retourne la plaque retir�e
		return dernierePlaque;
	}
	
	/**
	 * Scinde la s�quence en deux � partir de la plaque pass�e en param�tre. Celle ci devient la 
	 * premi�re plaque de la deuxi�me s�quence. La premi�re s�quence est retourn�e.
	 * @param plaque
	 * @return Sequence
	 * @throws RummikubException
	 */
	public Sequence scinderAvant(Plaque plaque) throws RummikubException {
		
		// Si la s�quence contient moins de 6 plaques, on ne peut pas la scinder en deux
		if (this.getNombrePlaques() < 6)
			throw new RummikubException("La s�quence doit contenir 6 plaques minimum pour pouvoir �tre scind�e en deux.");
		
		// Si la plaque pass�e en param�tre n'est pas pr�sente dans la s�quence, on retour une exception
		if (! this.listePlaques.contains(plaque)) 
			throw new RummikubException("La plaque demand�e n'est pas dans la s�rie.");
		
		// On stocke l'index de la plaque pass�e en param�tre
		int indexPlaqueAvant = this.listePlaques.indexOf(plaque);
		
		// Si l'index est < 4, on ne peut pas scinder car l'une des s�quence contiendrait moins de 3 plaques
		if (indexPlaqueAvant < 4)
			throw new RummikubException("Chaque nouvelle s�quence doit contenir 3 plaques minimum.");
		// Si l'index est > 10, on ne peut pas scinder car l'une des s�quence contiendrait moins de 3 plaques
		else if (indexPlaqueAvant > 10)
			throw new RummikubException("Chaque nouvelle s�quence doit contenir 3 plaques minimum.");
		
		// On cr�e la premi�re s�quence (entre la premiere plaque et la plaque pr�c�dent celle pass�e en param�tre)
		Sequence sequenceAvant = new Sequence(this.listePlaques.get(1), this.listePlaques.get(2), this.listePlaques.get(3));
		
		// On supprimer ces trois plaque de la s�quence courante
		this.listePlaques.set(1, null);
		this.listePlaques.set(2, null);
		this.listePlaques.set(3, null);
		
		// On ajoute les plaque suivante � la premi�re s�quence et on les supprime de la s�quence courante
		int i=4;
		while (i < indexPlaqueAvant) {
			sequenceAvant.ajouterPlaque(this.listePlaques.get(i));
			this.listePlaques.set(i, null);
			i++;
		}
		
		// On controle la s�quence courante (2�me s�quence)
		controlerSequence();
		
		// On controle la premiere s�quence
		sequenceAvant.controlerSequence();
		
		// Onn retourne la s�quence courante
		return sequenceAvant;
			
	}
	
	/** 
	 * M�thode priv�e qui controle la coh�rence de la s�quence. Elle v�rifie que toutes les plaques se suivent et
	 * qu'il n'y a pas de "trou" dans les valeurs des plaques
	 * @throws RummikubException
	 */
	private void controlerSequence() throws RummikubException {
		
		int positionPremierePlaque = -1;
		int positionDernierePlaque = -1;
		
		// On parcours les 13 positions de la liste des plaques composants la s�quence
		for (int indicePlaque=1;indicePlaque<=13;indicePlaque++) {

			// Si la position de la premi�re plaque de la s�quence n'est pas valoris�e
			if (positionPremierePlaque == -1) {

				// Si la plaque en position courante n'est pas null, On enregistre la position de la premiere plaque de la s�quence
				if (this.listePlaques.get(indicePlaque) != null)
					positionPremierePlaque = indicePlaque;

			// Sinon si la position de la DERNIERE plaque de la s�quence n'est pas valoris�e
			} else if (positionDernierePlaque == -1) { 
				
				// si on trouve un emplacement vide, on enregistre la position pr�c�dente comme derni�re plaque de la s�quence
				if (this.listePlaques.get(indicePlaque) == null)
					positionDernierePlaque = indicePlaque-1;
			
			} 

			
			// Si on a enregistr� la position de la derni�re plaque de la s�quence mais que
			// l'on trouve un nouvel emplacement occup�, c'est qu'il y a un trou
			if (positionDernierePlaque != -1 && this.listePlaques.get(indicePlaque) != null) {
				int positionTrou = positionDernierePlaque+1;
				throw new RummikubException("Il manque une plaque dans la s�quence en position "+positionTrou+".");
			}
		}
	}
	
	/**
	 * Retourne le contenu de la s�quence dans une chaine de caract�re
	 * @return String
	 */
	public String toString() {
		String chaine = "";
		
		// On cr�er un it�rateur sur la liste des plaques composants la s�quence
		Iterator<Plaque> iterPlaque = this.listePlaques.iterator();
		while (iterPlaque.hasNext()) {
			Plaque plaque = iterPlaque.next();
			
			// Pour chaque plaque, on concatene son nom au nom des autres plaques composants la s�quence
			if (plaque != null) chaine = chaine + plaque.getNomPlaque()+ " ";
		}
		
		return chaine.substring(0, chaine.length()-1);
	}


	/**
	 * Retourne le nombre de plaques dans la s�quence
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
