package org.eclipse.model;

import java.util.ArrayList;

public class Panier {
	/** Classe décrivant le panier qu'utilise le client pour préparer ses achats. */

	// Attributs
	private int id;
	private ArrayList<Integer> idLignesPanier;

	// Le constructeur
	public Panier(int id) {
		this.id = id;
		this.idLignesPanier = new ArrayList<Integer>();
		// La ligne de panier commence vide */
	}

	// Les getters et les setters classiques
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Integer> getLignesPanier() {
		return this.idLignesPanier;
	}

	public void setLignesPanier(ArrayList<Integer> idLignesPanier) {
		this.idLignesPanier = idLignesPanier;
	}

	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "Panier [id=" + this.id + ", idLignesPanier=" + this.idLignesPanier + ", ]";
	}

}
