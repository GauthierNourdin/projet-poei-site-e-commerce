package org.eclipse.model;

import java.util.ArrayList;

public class Panier {
	/** Classe decrivant le panier qu'utilise le client pour preparer ses achats. */

	// Attributs
	private int id;
	private ArrayList<Integer> idLignesPanier = new ArrayList<Integer>();

	// Les constructeurs
	public Panier() {
	}
	
	public Panier(int id) {
		this.id = id;
	}

	// Les getters et les setters classiques
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Integer> getIdLignesPanier() {
		return this.idLignesPanier;
	}

	public void setIdLignesPanier(ArrayList<Integer> idLignesPanier) {
		this.idLignesPanier = idLignesPanier;
	}

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "Panier [id=" + this.id + ", idLignesPanier=" + this.idLignesPanier + ", ]";
	}

}
