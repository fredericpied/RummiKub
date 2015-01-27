package tests;

import static org.junit.Assert.*;
import modele.Couleur;
import modele.Plaque;
import modele.Sequence;
import modele.Serie;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import controler.Main;
import controler.RummikubException;

public class TestSequence {
	private static final Logger logger = Logger.getLogger(TestSequence.class);
	
	protected Sequence sequence;
	
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
		public void testSequence2Plaques() throws RummikubException {
			try {
				sequence = new Sequence(plaqueRouge_01, plaqueRouge_02, null);
				fail("Une exception aurait du être levée");
			} catch (RummikubException e) {
				assertNotNull(e);
				assertEquals(e.getMessage(), "La séquence doit contenir 3 plaques minimum.");
			}
		}
	  
		@Test
		public void testSequencePlaques123() throws RummikubException {
			sequence = new Sequence(plaqueRouge_01, plaqueRouge_02,  plaqueRouge_03);
			assertEquals(sequence.getNombrePlaques(), 3);
		}
		
		@Test
		public void testSequencePlaques345() throws RummikubException {
			sequence = new Sequence(plaqueRouge_03, plaqueRouge_04,  plaqueRouge_05);
			assertEquals(sequence.getNombrePlaques(), 3);
		}
		
		@Test
		public void testSequencePlaques111213() throws RummikubException {
			sequence = new Sequence(plaqueRouge_11, plaqueRouge_12,  plaqueRouge_13);
			assertEquals(sequence.getNombrePlaques(), 3);
		}
		
		@Test
		public void testSequence4Plaques() throws RummikubException {
			sequence = new Sequence(plaqueRouge_01, plaqueRouge_02,  plaqueRouge_03);
			assertEquals(sequence.getNombrePlaques(), 3);
			sequence.ajouterPlaque(plaqueRouge_04);
			assertEquals(sequence.getNombrePlaques(), 4);
		}
	  
		@Test
		public void testSequenceComplete() throws RummikubException {
			sequence = new Sequence(plaqueRouge_01, plaqueRouge_02,  plaqueRouge_03);
			assertEquals(sequence.getNombrePlaques(), 3);
			sequence.ajouterPlaque(plaqueRouge_04);
			assertEquals(sequence.getNombrePlaques(), 4);
			sequence.ajouterPlaque(plaqueRouge_05);
			assertEquals(sequence.getNombrePlaques(), 5);
			sequence.ajouterPlaque(plaqueRouge_06);
			assertEquals(sequence.getNombrePlaques(), 6);
			sequence.ajouterPlaque(plaqueRouge_07);
			assertEquals(sequence.getNombrePlaques(), 7);
			sequence.ajouterPlaque(plaqueRouge_08);
			assertEquals(sequence.getNombrePlaques(), 8);
			sequence.ajouterPlaque(plaqueRouge_09);
			assertEquals(sequence.getNombrePlaques(), 9);
			sequence.ajouterPlaque(plaqueRouge_10);
			assertEquals(sequence.getNombrePlaques(), 10);
			sequence.ajouterPlaque(plaqueRouge_11);
			assertEquals(sequence.getNombrePlaques(), 11);
			sequence.ajouterPlaque(plaqueRouge_12);
			assertEquals(sequence.getNombrePlaques(), 12);
			sequence.ajouterPlaque(plaqueRouge_13);
			assertEquals(sequence.getNombrePlaques(), 13);
		}
		
		@Test
		public void testAjoutPlaque() throws RummikubException {
			sequence = new Sequence(plaqueRouge_01, plaqueRouge_02,  plaqueRouge_03);
			assertEquals(sequence.getNombrePlaques(), 3);
			try {
				sequence.ajouterPlaque(plaqueRouge_05);
				fail("Une exception aurait du être levée");
			} catch (RummikubException e) {
				assertNotNull(e);
				assertEquals(e.getMessage(), "Il manque une plaque dans la séquence en position 4.");
			}
		}
		
		@Test
		public void testAjoutPlaque2() throws RummikubException {
			sequence = new Sequence(plaqueRouge_01, plaqueRouge_02,  plaqueRouge_03);
			assertEquals(sequence.getNombrePlaques(), 3);
			try {
				sequence.ajouterPlaque(plaqueRouge_07);
				fail("Une exception aurait du être levée");
			} catch (RummikubException e) {
				assertNotNull(e);
				assertEquals(e.getMessage(), "Il manque une plaque dans la séquence en position 4.");
			}
		}
		
		@Test
		public void testAjoutPlaque3() throws RummikubException {
			sequence = new Sequence(plaqueRouge_01, plaqueRouge_02,  plaqueRouge_03);
			assertEquals(sequence.getNombrePlaques(), 3);
			try {
				sequence.ajouterPlaque(plaqueRouge_04);
				assertEquals(sequence.getNombrePlaques(), 4);
				
				sequence.ajouterPlaque(plaqueRouge_13);
				assertEquals(sequence.getNombrePlaques(), 4);
				
				fail("Une exception aurait du être levée");
			} catch (RummikubException e) {
				assertNotNull(e);
				assertEquals(e.getMessage(), "Il manque une plaque dans la séquence en position 5.");
			}
		}

		@Test
		public void testRetirerPlaque() throws RummikubException {
			sequence = new Sequence(plaqueRouge_01, plaqueRouge_02,  plaqueRouge_03);
			assertEquals(sequence.getNombrePlaques(), 3);

			sequence.ajouterPlaque(plaqueRouge_04);
			assertEquals(sequence.getNombrePlaques(), 4);
				
			sequence.retirerDernierePlaque();
			assertEquals(sequence.getNombrePlaques(), 3);

		}
		
		@Test
		public void testRetirerPlaque2() throws RummikubException {
			sequence = new Sequence(plaqueRouge_01, plaqueRouge_02,  plaqueRouge_03);
			assertEquals(sequence.getNombrePlaques(), 3);

			try {
				sequence.retirerDernierePlaque();
				fail("Une exception aurait du être levée");
			} catch (RummikubException e) {
				assertNotNull(e);
				assertEquals(e.getMessage(), "La séquence doit contenir 3 plaques minimum.");
			}
				
		}
		
		@Test
		public void testRetirerPlaqueSequenceComplete() throws RummikubException {
			sequence = new Sequence(plaqueRouge_01, plaqueRouge_02,  plaqueRouge_03);
			assertEquals(sequence.getNombrePlaques(), 3);
			sequence.ajouterPlaque(plaqueRouge_04);
			assertEquals(sequence.getNombrePlaques(), 4);
			sequence.ajouterPlaque(plaqueRouge_05);
			assertEquals(sequence.getNombrePlaques(), 5);
			sequence.ajouterPlaque(plaqueRouge_06);
			assertEquals(sequence.getNombrePlaques(), 6);
			sequence.ajouterPlaque(plaqueRouge_07);
			assertEquals(sequence.getNombrePlaques(), 7);
			sequence.ajouterPlaque(plaqueRouge_08);
			assertEquals(sequence.getNombrePlaques(), 8);
			sequence.ajouterPlaque(plaqueRouge_09);
			assertEquals(sequence.getNombrePlaques(), 9);
			sequence.ajouterPlaque(plaqueRouge_10);
			assertEquals(sequence.getNombrePlaques(), 10);
			sequence.ajouterPlaque(plaqueRouge_11);
			assertEquals(sequence.getNombrePlaques(), 11);
			sequence.ajouterPlaque(plaqueRouge_12);
			assertEquals(sequence.getNombrePlaques(), 12);
			sequence.ajouterPlaque(plaqueRouge_13);
			assertEquals(sequence.getNombrePlaques(), 13);
			
			sequence.retirerDernierePlaque();
			assertEquals(sequence.getNombrePlaques(), 12);
			
			sequence.retirerDernierePlaque();
			assertEquals(sequence.getNombrePlaques(), 11);
			
			sequence.retirerDernierePlaque();
			assertEquals(sequence.getNombrePlaques(), 10);
			
			sequence.retirerDernierePlaque();
			assertEquals(sequence.getNombrePlaques(), 9);
			
			sequence.retirerDernierePlaque();
			assertEquals(sequence.getNombrePlaques(), 8);
			
			sequence.retirerDernierePlaque();
			assertEquals(sequence.getNombrePlaques(), 7);
			
			sequence.retirerDernierePlaque();
			assertEquals(sequence.getNombrePlaques(), 6);
			
			sequence.retirerDernierePlaque();
			assertEquals(sequence.getNombrePlaques(), 5);
			
			sequence.retirerDernierePlaque();
			assertEquals(sequence.getNombrePlaques(), 4);
			
			sequence.retirerDernierePlaque();
			assertEquals(sequence.getNombrePlaques(), 3);
						
		}
		
		@Test
		public void testScinderAvant() throws RummikubException {
			sequence = new Sequence(plaqueRouge_01, plaqueRouge_02,  plaqueRouge_03);
			assertEquals(sequence.getNombrePlaques(), 3);
			
			sequence.ajouterPlaque(plaqueRouge_04);
			assertEquals(sequence.getNombrePlaques(), 4);
			sequence.ajouterPlaque(plaqueRouge_05);
			assertEquals(sequence.getNombrePlaques(), 5);
			sequence.ajouterPlaque(plaqueRouge_06);
			assertEquals(sequence.getNombrePlaques(), 6);
			
			
			Sequence sequence2 = sequence.scinderAvant(plaqueRouge_04);
			
			assertEquals(sequence.getNombrePlaques(), 3);
			logger.info(sequence.toString());
			assertEquals(sequence2.getNombrePlaques(), 3);
			logger.info(sequence2.toString());
						
		}
		
		@Test
		public void testScinderAvant2() throws RummikubException {
			sequence = new Sequence(plaqueRouge_01, plaqueRouge_02,  plaqueRouge_03);
			assertEquals(sequence.getNombrePlaques(), 3);
			sequence.ajouterPlaque(plaqueRouge_04);
			assertEquals(sequence.getNombrePlaques(), 4);
			sequence.ajouterPlaque(plaqueRouge_05);
			assertEquals(sequence.getNombrePlaques(), 5);
			sequence.ajouterPlaque(plaqueRouge_06);
			assertEquals(sequence.getNombrePlaques(), 6);
			sequence.ajouterPlaque(plaqueRouge_07);
			assertEquals(sequence.getNombrePlaques(), 7);
			sequence.ajouterPlaque(plaqueRouge_08);
			assertEquals(sequence.getNombrePlaques(), 8);
			sequence.ajouterPlaque(plaqueRouge_09);
			assertEquals(sequence.getNombrePlaques(), 9);
			sequence.ajouterPlaque(plaqueRouge_10);
			assertEquals(sequence.getNombrePlaques(), 10);
			sequence.ajouterPlaque(plaqueRouge_11);
			assertEquals(sequence.getNombrePlaques(), 11);
			sequence.ajouterPlaque(plaqueRouge_12);
			assertEquals(sequence.getNombrePlaques(), 12);
			sequence.ajouterPlaque(plaqueRouge_13);
			assertEquals(sequence.getNombrePlaques(), 13);
			
			
			Sequence sequence2 = sequence.scinderAvant(plaqueRouge_04);
			
			assertEquals(sequence.getNombrePlaques(), 10);
			logger.info(sequence.toString());
			assertEquals(sequence2.getNombrePlaques(), 3);
			logger.info(sequence2.toString());
						
		}
		
		@Test
		public void testScinderAvant3() throws RummikubException {
			sequence = new Sequence(plaqueRouge_01, plaqueRouge_02,  plaqueRouge_03);
			assertEquals(sequence.getNombrePlaques(), 3);
			sequence.ajouterPlaque(plaqueRouge_04);
			assertEquals(sequence.getNombrePlaques(), 4);
			sequence.ajouterPlaque(plaqueRouge_05);
			assertEquals(sequence.getNombrePlaques(), 5);
			sequence.ajouterPlaque(plaqueRouge_06);
			assertEquals(sequence.getNombrePlaques(), 6);
			sequence.ajouterPlaque(plaqueRouge_07);
			assertEquals(sequence.getNombrePlaques(), 7);
			sequence.ajouterPlaque(plaqueRouge_08);
			assertEquals(sequence.getNombrePlaques(), 8);
			sequence.ajouterPlaque(plaqueRouge_09);
			assertEquals(sequence.getNombrePlaques(), 9);
			sequence.ajouterPlaque(plaqueRouge_10);
			assertEquals(sequence.getNombrePlaques(), 10);
			sequence.ajouterPlaque(plaqueRouge_11);
			assertEquals(sequence.getNombrePlaques(), 11);
			sequence.ajouterPlaque(plaqueRouge_12);
			assertEquals(sequence.getNombrePlaques(), 12);
			sequence.ajouterPlaque(plaqueRouge_13);
			assertEquals(sequence.getNombrePlaques(), 13);
			
			try {
				Sequence sequence2 = sequence.scinderAvant(plaqueRouge_03);
				fail("Une exception aurait du être levée");
			} catch (RummikubException e) {
				assertNotNull(e);
				assertEquals(e.getMessage(), "Chaque nouvelle séquence doit contenir 3 plaques minimum.");
			}
						
		}
		
		@Test
		public void testScinderAvant4() throws RummikubException {
			sequence = new Sequence(plaqueRouge_01, plaqueRouge_02,  plaqueRouge_03);
			assertEquals(sequence.getNombrePlaques(), 3);
			sequence.ajouterPlaque(plaqueRouge_04);
			assertEquals(sequence.getNombrePlaques(), 4);
			sequence.ajouterPlaque(plaqueRouge_05);
			assertEquals(sequence.getNombrePlaques(), 5);
			sequence.ajouterPlaque(plaqueRouge_06);
			assertEquals(sequence.getNombrePlaques(), 6);
			sequence.ajouterPlaque(plaqueRouge_07);
			assertEquals(sequence.getNombrePlaques(), 7);
			sequence.ajouterPlaque(plaqueRouge_08);
			assertEquals(sequence.getNombrePlaques(), 8);
			sequence.ajouterPlaque(plaqueRouge_09);
			assertEquals(sequence.getNombrePlaques(), 9);
			sequence.ajouterPlaque(plaqueRouge_10);
			assertEquals(sequence.getNombrePlaques(), 10);
			sequence.ajouterPlaque(plaqueRouge_11);
			assertEquals(sequence.getNombrePlaques(), 11);
			sequence.ajouterPlaque(plaqueRouge_12);
			assertEquals(sequence.getNombrePlaques(), 12);
			sequence.ajouterPlaque(plaqueRouge_13);
			assertEquals(sequence.getNombrePlaques(), 13);
			
			try {
				Sequence sequence2 = sequence.scinderAvant(plaqueRouge_12);
				fail("Une exception aurait du être levée");
			} catch (RummikubException e) {
				assertNotNull(e);
				assertEquals(e.getMessage(), "Chaque nouvelle séquence doit contenir 3 plaques minimum.");
			}
						
		}
		
}
