package modele;

import java.util.ArrayList;
import java.util.Iterator;

import controler.RummikubException;

/**
 * Une serie est une combinaison de 3 ou 4 plaque portant le m�me num�ro mais de couleurs diff�rentes
 * @author 09344a
 *
 */
public class Serie {

	/**
	 * Liste des plaques composants la s�rie
	 */
	private ArrayList<Plaque> listePlaques = new ArrayList<Plaque>();

	/**
	 * Valeur des plaques de la s�rie
	 */
	private int valeurSerie;
	
	/**
	 * Cr�� une s�rie compos�e de 3 plaques
	 * @param plaque1
	 * @param plaque2
	 * @param plaque3
	 * @throws RummikubException
	 */
	public Serie(Plaque plaque1, Plaque plaque2, Plaque plaque3) throws RummikubException {
		new Serie(plaque1, plaque2, plaque3, null);
	}
	
	/**
	 * Cr�� une s�rie compos�e de 4 plaques
	 * @param plaque1
	 * @param plaque2
	 * @param plaque3
	 * @param plaque4
	 * @throws RummikubException
	 */
	public Serie(Plaque plaque1, Plaque plaque2, Plaque plaque3, Plaque plaque4) throws RummikubException {
		
		// Si l'une des 3 plaques est null, on retourne une exception
		if (plaque1 == null ||  plaque2 == null || plaque3 == null) {
			throw new RummikubException("La s�rie doit contenir 3 plaques minimum.");
		} else {
			// Sinon on ajoute les plaque � la s�rie
			listePlaques.add(plaque1);
			listePlaques.add(plaque2);
			listePlaques.add(plaque3);
		}
		
		// Si la 4�me plaque n'est pas null, on l'ajoute � la s�rie
		if (plaque4 != null ) listePlaques.add(plaque4);
		
		// On v�rifie que les plaques composants la s�rie portent toutes la m�me valeur
		int valeurPlaquePrecedente = -1;
		
		for (int indicePlaque=1;indicePlaque<this.listePlaques.size();indicePlaque++) {
			Plaque plaqueCourante = this.listePlaques.get(indicePlaque);

			if (valeurPlaquePrecedente != -1 && valeurPlaquePrecedente != plaqueCourante.getValeur())
				throw new RummikubException("Toutes les plaques composant la s�rie doivent avoir la m�me valeur.");
			
			valeurPlaquePrecedente = plaqueCourante.getValeur();
		}
		
		// On valorise la valeur de la s�rie
		this.valeurSerie = plaque1.getValeur();
	}
	
	/**
	 * Ajoute une plaque � la s�rie
	 * @param plaque
	 * @throws RummikubException
	 */
	public void ajouterPlaque(Plaque plaque) throws RummikubException {
		
		// Si la s�rie contient d�ja 4 plaque, on leve une exception
		if (this.listePlaques.size() == 4) {
			throw new RummikubException("La s�rie contient d�ja 4 plaques.");
			
		// Sinon si la plaque ajout�e ne porte pas la m�me valeur que les plaques de la s�rie, on leve une exception
		} else if (plaque.getValeur() != this.valeurSerie) {
			throw new RummikubException("La s�rie ne re�oit que des plaques de valeur "+this.valeurSerie+".");
		
		// Sinon On v�rifie qu'une plaque de la meme couleur n'est pas d�ja pr�sente
		} else {
			for (int indicePlaque=1;indicePlaque<this.listePlaques.size();indicePlaque++) {
				Plaque plaqueExistante = this.listePlaques.get(indicePlaque);
				
				if (plaque.getCouleur() == plaqueExistante.getCouleur()) 
					throw new RummikubException("La s�rie contient d�ja une plaque de couleur "+plaque.getCouleur());
			}
			
			// On ajoute la plaque
			listePlaques.add(plaque);
		}
	}
	
	/**
	 * Retire une plaque de la s�rie
	 * @param plaque
	 * @throws RummikubException
	 */
	public void retirerPlaque(Plaque plaque) throws RummikubException {
		
		// Si la s�rie contient 3 plaque, on leve une exception
		if (this.listePlaques.size() == 3)
			throw new RummikubException("La s�rie doit contenir 3 plaques minimum.");
		
		if (!this.listePlaques.remove(plaque))
			throw new RummikubException("La plaque demand�e n'est pas dans la s�rie.");
				
	}

	public String afficher() {
		String chaine = "";
		Iterator<Plaque> iterPlaque = this.listePlaques.iterator();
		while (iterPlaque.hasNext()) {
			Plaque plaque = iterPlaque.next();
			chaine = chaine + plaque.getNomPlaque()+ " ";
		}
		
		return chaine.substring(0, chaine.length()-1);
	}
	
	public int getValeurSerie() {
		return valeurSerie;
	}

	public int getNombrePlaques() {
		return this.listePlaques.size();
	}
	
}
