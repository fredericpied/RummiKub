package modele;

import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.Logger;

import controler.RummikubException;

public class Partie {
	private static final Logger logger = Logger.getLogger(Partie.class);
	
	private ArrayList<Plaque> pioche = new ArrayList<Plaque>();

	private static int NUMBER_OF_PLAQUE = 106; // 52 couples chiffres/couleurs X 2 + 2 jokers
	
	private ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
		
	public void initializeList() throws RummikubException {
		Couleur tabCouleur[] = Couleur.values();
		int minValeur = 1;
		int maxValeur = 13;
		
		logger.debug("Debut initialisation");
		
		for (int valeur=minValeur;valeur<=maxValeur;valeur++) {
			
			for (int indexCouleur=0;indexCouleur<tabCouleur.length;indexCouleur++) {
				
				Plaque plaque = new Plaque(tabCouleur[indexCouleur],valeur);
				
				logger.trace("Ajout 2 plaques "+plaque.getNomPlaque());
				this.pioche.add(plaque);
				this.pioche.add(plaque);
			}
		}
		
		// Ajout des jockers
		this.pioche.add(new Plaque(Couleur.rouge,0));
		this.pioche.add(new Plaque(Couleur.noir,0));
				
		logger.debug("Fin initialisation");
		
		if (this.pioche.size() != NUMBER_OF_PLAQUE) 
			throw new RummikubException("Erreur d'initialisation de la pioche (nb de plaques = "+this.pioche.size()+" au lieu de "+NUMBER_OF_PLAQUE+")");
		
		logger.debug(this.getNbPlaquesPioche()+" plaques dans la pioche");
		
	}
	
	public Partie() throws RummikubException {
		this.initializeList();
	}
	
	/**
	 * Retourne une plaque aléatoirement et la supprime de la pioche
	 * @throws RummikubException 
	 */
	public Plaque piocherPlaque() throws RummikubException {
		
		if (this.pioche.isEmpty()) throw new RummikubException("La pioche est vide.");
		
	    return this.pioche.remove(getRandom());
	}
	
	/**
	 * Retourne une plaque aléatoirement et la laisse dans la pioche (plaque du début pour déterminer l'ordre de jeux)
	 * @throws RummikubException 
	 */
	public Plaque piocherPlaqueDebut() throws RummikubException {
		
		if (this.pioche.isEmpty()) throw new RummikubException("La pioche est vide.");
		
	    return this.pioche.get(getRandom());
	}
	
	/**
	 * Retourne un nombre alétoire entre 0 et 56
	 * @return
	 */
	private int getRandom() {
		 // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();
	    int max = NUMBER_OF_PLAQUE;
	    int min = 0;
	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	   return rand.nextInt((max - min) + 1) + min;
	}
	
	
	public int getNbPlaquesPioche() {
		return this.pioche.size();
	}
		
	public void addJoueur(Joueur joueur) throws RummikubException {
		
		if (this.listeJoueurs.size() == 4) throw new RummikubException("Le nombre maximum de joueur (4) est atteint.");
		else {
					
			for (int indiceJoueur=1;indiceJoueur<this.listeJoueurs.size();indiceJoueur++) {
				Joueur joueurExistant = this.listeJoueurs.get(indiceJoueur);
				
				if (joueur.getPseudo().compareTo(joueurExistant.getPseudo()) == 0) 
					throw new RummikubException("Un joueur portant le pseudo "+joueur.getPseudo()+ " est déja présent dans la partie.");
			}
			
			this.listeJoueurs.add(joueur);
			joueur.setPlaqueDebut(this.piocherPlaqueDebut());
			
			logger.debug("Ajout joueur "+joueur.getPseudo()+ " (Plaque debut: "+joueur.getPlaqueDebut().getNomPlaque()+")");
			
		}
				
	}
	
	public int getNbJoueurs() {
		return this.listeJoueurs.size();
	}
		
}
