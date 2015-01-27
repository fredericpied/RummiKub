package modele;

import java.util.ArrayList;

public class Joueur {

	private String pseudo;
	
	private ArrayList<Plaque> socle = new ArrayList<Plaque>();
	
	private Plaque plaqueDebut;
	
	public Joueur(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPseudo() {
		return pseudo;
	}

	public Plaque getPlaqueDebut() {
		return plaqueDebut;
	}

	public void setPlaqueDebut(Plaque plaqueDebut) {
		this.plaqueDebut = plaqueDebut;
	}
	
	
	
}
