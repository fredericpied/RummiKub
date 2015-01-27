package modele;

import controler.RummikubException;

public class Plaque {
	// Couleur de la plaque
	private Couleur couleur;
	
	// la valeur est 0 pour les deux plaques Joker
	private int valeur;
	
	public Plaque(Couleur couleur, int valeur) throws RummikubException {
		
		if (valeur == 0 && (couleur != Couleur.noir && couleur != Couleur.rouge)) {
			throw new RummikubException("Une plaque Joker ne peut être que noir ou rouge.");
		}
				
		this.couleur = couleur;
		this.valeur = valeur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public int getValeur() {
		return valeur;
	}
	
	public String getNomPlaque() {
		String lettreCouleur = "";
		switch (this.couleur) {
		 case rouge:
	         lettreCouleur = "ROUGE";
	         break;
	      case bleu:
	    	 lettreCouleur = "BLEU";
	         break;
	      case jaune:
	    	 lettreCouleur = "JAUNE";
	         break;
	      case noir:
	    	 lettreCouleur = "NOIR";
	         break;
		}
		
		String stringValeur = null;
		if (this.valeur != 0 ) 
			stringValeur = String.format("%02d", this.valeur);
		else 
			stringValeur = "JOKER";
		
		return stringValeur + "_" + lettreCouleur;
	}
	
	
}
