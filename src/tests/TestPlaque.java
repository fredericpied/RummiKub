package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modele.Couleur;
import modele.Plaque;

import org.junit.Test;

import controler.RummikubException;

public class TestPlaque {

	Plaque plaque;
	private ArrayList<Plaque> listePlaque = new ArrayList<Plaque>();
		
	@Test
	public void testToutesPlaques() throws RummikubException {

		Couleur tabCouleur[] = Couleur.values();
		int minValeur = 1;
		int maxValeur = 13;
					
		for (int valeur=minValeur;valeur<=maxValeur;valeur++) {
			
			for (int indexCouleur=0;indexCouleur<tabCouleur.length;indexCouleur++) {
				
				Plaque plaque = new Plaque(tabCouleur[indexCouleur],valeur);
				this.listePlaque.add(plaque);
			}
		}
		
		// Ajout des jockers
		this.listePlaque.add(new Plaque(Couleur.rouge,0));
		this.listePlaque.add(new Plaque(Couleur.noir,0));
		
		assertEquals(this.listePlaque.size(), 54);
		
	}
	
	@Test
	public void testErreurCreationPlaquesJokers() {
		
		// Ajout d'un joker de couleur jaune
		try {
			this.listePlaque.add(new Plaque(Couleur.jaune,0));
		} catch (RummikubException e) {
			assertNotNull(e);
			assertEquals(e.getMessage(), "Une plaque Joker ne peut être que noir ou rouge.");
		}

	}
	
	@Test
	public void testGetCouleur() throws RummikubException {
		
		Plaque plaque1 = new Plaque(Couleur.rouge,1);
		Plaque plaque2 = new Plaque(Couleur.jaune,2);
		Plaque plaque3 = new Plaque(Couleur.bleu,3);
		Plaque plaque4 = new Plaque(Couleur.noir,4);
		Plaque plaque5 = new Plaque(Couleur.rouge,5);
		Plaque plaque6 = new Plaque(Couleur.bleu,6);
		Plaque plaque7 = new Plaque(Couleur.rouge,7);
		Plaque plaque8 = new Plaque(Couleur.jaune,8);
		Plaque plaque9 = new Plaque(Couleur.rouge,9);
		Plaque plaque10 = new Plaque(Couleur.noir,10);

		assertEquals(plaque10.getCouleur(), Couleur.noir);
		assertEquals(plaque3.getCouleur(), Couleur.bleu);
		assertEquals(plaque1.getCouleur(), Couleur.rouge);
		assertEquals(plaque8.getCouleur(), Couleur.jaune);
		
	}
	
	@Test
	public void testGetValeur() throws RummikubException {
		
		Plaque plaque1 = new Plaque(Couleur.rouge,1);
		Plaque plaque2 = new Plaque(Couleur.jaune,2);
		Plaque plaque3 = new Plaque(Couleur.bleu,3);
		Plaque plaque4 = new Plaque(Couleur.noir,4);
		Plaque plaque5 = new Plaque(Couleur.rouge,5);
		Plaque plaque6 = new Plaque(Couleur.bleu,6);
		Plaque plaque7 = new Plaque(Couleur.rouge,7);
		Plaque plaque8 = new Plaque(Couleur.jaune,8);
		Plaque plaque9 = new Plaque(Couleur.rouge,9);
		Plaque plaque10 = new Plaque(Couleur.noir,10);

		assertEquals(plaque10.getValeur(), 10);
		assertEquals(plaque3.getValeur(), 3);
		assertEquals(plaque1.getValeur(), 1);
		assertEquals(plaque8.getValeur(), 8);
		
	}
	
	@Test
	public void testGetNomPlaque() throws RummikubException {
		
		Plaque plaque1 = new Plaque(Couleur.rouge,1);
		Plaque plaque2 = new Plaque(Couleur.jaune,2);
		Plaque plaque3 = new Plaque(Couleur.bleu,3);
		Plaque plaque4 = new Plaque(Couleur.noir,4);
		Plaque plaque5 = new Plaque(Couleur.rouge,5);
		Plaque plaque6 = new Plaque(Couleur.bleu,6);
		Plaque plaque7 = new Plaque(Couleur.rouge,7);
		Plaque plaque8 = new Plaque(Couleur.jaune,8);
		Plaque plaque9 = new Plaque(Couleur.rouge,9);
		Plaque plaque10 = new Plaque(Couleur.noir,10);

		assertEquals(plaque10.getNomPlaque(), "10_NOIR");
		assertEquals(plaque3.getNomPlaque(), "03_BLEU");
		assertEquals(plaque1.getNomPlaque(), "01_ROUGE");
		assertEquals(plaque8.getNomPlaque(), "08_JAUNE");
		
	}
	
	
	

}
