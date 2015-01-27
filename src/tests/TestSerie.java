package tests;

import static org.junit.Assert.*;
import modele.Couleur;
import modele.Plaque;
import modele.Serie;

import org.junit.Before;
import org.junit.Test;

import controler.RummikubException;

public class TestSerie {
	
	protected Serie serie;
	
	protected Plaque plaqueRouge_01;
	protected Plaque plaqueRouge_02;
	protected Plaque plaqueRouge_03;
	protected Plaque plaqueRouge_04;
	protected Plaque plaqueRouge_05;
	protected Plaque plaqueRouge_06;
	protected Plaque plaqueRouge_07;
	protected Plaque plaqueRouge_08;
	protected Plaque plaqueRouge_09;
	protected Plaque plaqueRouge_10;
	protected Plaque plaqueRouge_11;
	protected Plaque plaqueRouge_12;
	protected Plaque plaqueRouge_13;
	
	protected Plaque plaqueBleu_01;
	protected Plaque plaqueJaune_01;
	protected Plaque plaqueNoir_01;
	protected Plaque plaqueBleu_10;
	protected Plaque plaqueJaune_10;
	protected Plaque plaqueNoir_10;
	protected Plaque plaqueBleu_05;
	protected Plaque plaqueJaune_05;
	protected Plaque plaqueNoir_05;
	
	  @Before
	   public void setUp() throws RummikubException {
			
		plaqueRouge_01 = new Plaque(Couleur.rouge,1);
		plaqueRouge_02 = new Plaque(Couleur.rouge,2);
		plaqueRouge_03 = new Plaque(Couleur.rouge,3);
		plaqueRouge_04 = new Plaque(Couleur.rouge,4);
		plaqueRouge_05 = new Plaque(Couleur.rouge,5);
		plaqueRouge_06 = new Plaque(Couleur.rouge,6);
		plaqueRouge_07 = new Plaque(Couleur.rouge,7);
		plaqueRouge_08 = new Plaque(Couleur.rouge,8);
		plaqueRouge_09 = new Plaque(Couleur.rouge,9);
		plaqueRouge_10 = new Plaque(Couleur.rouge,10);
		plaqueRouge_11 = new Plaque(Couleur.rouge,11);
		plaqueRouge_12 = new Plaque(Couleur.rouge,12);
		plaqueRouge_13 = new Plaque(Couleur.rouge,13);
			
		plaqueBleu_01 = new Plaque(Couleur.bleu,1);
		plaqueJaune_01 = new Plaque(Couleur.jaune,1);
		plaqueNoir_01 = new Plaque(Couleur.noir,2);
		plaqueBleu_10 = new Plaque(Couleur.bleu,10);
		plaqueJaune_10 = new Plaque(Couleur.jaune,10);
		plaqueNoir_10 = new Plaque(Couleur.noir,10);
		plaqueBleu_05 = new Plaque(Couleur.bleu,5);
		plaqueJaune_05 = new Plaque(Couleur.jaune,5);
		plaqueNoir_05 = new Plaque(Couleur.noir,5);
						
	   }
	
	@Test
	public void testSerie2Plaques() throws RummikubException {
		try {
			serie = new Serie(plaqueRouge_01, plaqueBleu_01, null, null);
		} catch (RummikubException e) {
			assertNotNull(e);
			assertEquals(e.getMessage(), "La série doit contenir 3 plaques minimum.");
		}
	}
		
	@Test
	public void testSerie3Plaques() throws RummikubException {
		serie = new Serie(plaqueRouge_01, plaqueBleu_01, plaqueJaune_01, null);
		assertEquals(serie.getValeurSerie(), 1);
		assertEquals(serie.getNombrePlaques(), 3);
	}

	@Test
	public void testSerie4Plaques() throws RummikubException {
		serie = new Serie(plaqueRouge_10, plaqueBleu_10, plaqueJaune_10, plaqueNoir_10);
		assertEquals(serie.getValeurSerie(), 10);
		assertEquals(serie.getNombrePlaques(), 4);
		
	}
		
	@Test
	public void testAjouterPlaqueASerie3Plaques() throws RummikubException {
		serie = new Serie(plaqueRouge_05, plaqueBleu_05, plaqueJaune_05, null);
			
		serie.ajouterPlaque(plaqueNoir_05);
		assertEquals(serie.getNombrePlaques(), 4);
				
	}

	@Test
	public void testRetirerPlaqueASerie4Plaques() throws RummikubException {

		serie = new Serie(plaqueRouge_05, plaqueBleu_05, plaqueJaune_05, plaqueNoir_05);
		serie.retirerPlaque(plaqueRouge_05);
		assertEquals(serie.getNombrePlaques(), 3);
	}
	
	@Test
	public void testRetirerPlaqueASerie3Plaques() throws RummikubException {

		serie = new Serie(plaqueRouge_05, plaqueBleu_05, plaqueJaune_05, null);
		try {
			serie.retirerPlaque(plaqueNoir_05);
		} catch (RummikubException e) {
			assertNotNull(e);
			assertEquals(e.getMessage(), "La série doit contenir 3 plaques minimum.");
		}

	}
	
	@Test
	public void testRetirerPlaqueInexistante() throws RummikubException {

		serie = new Serie(plaqueRouge_05, plaqueBleu_05, plaqueJaune_05, plaqueNoir_05);
		try {
			serie.retirerPlaque(plaqueNoir_10);
		} catch (RummikubException e) {
			assertNotNull(e);
			assertEquals(e.getMessage(), "La plaque demandée n'est pas dans la série.");
		}

	}
	
}
