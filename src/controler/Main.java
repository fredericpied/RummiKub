package controler;

import modele.Joueur;
import modele.Partie;

import org.apache.log4j.Logger;

public class Main {
	private static final Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {

		try {
			
			Partie partie = new Partie();
			
			partie.addJoueur(new Joueur("Alexandra"));
			partie.addJoueur(new Joueur("Frederic"));
			partie.addJoueur(new Joueur("Clemence"));
			partie.addJoueur(new Joueur("Axel"));
			
			
			
			
			System.exit(0);
		} catch (RummikubException e) {
			logger.fatal("Exception: "+e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		

	}

}
