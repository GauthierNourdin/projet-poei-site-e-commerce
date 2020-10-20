package org.eclipse.model;

public class LignePanier {
	/** Classe d'association entre Panier et Produit */
	
	// Attributs
	private int id;
	private int quantiteCommandee;
	private int idPanier;
	private int idProduit;
	
	// Le constructeur
	public LignePanier(int id, int quantiteCommandee, int idPanier, int idProduit) {
		this.id = id;
		this.quantiteCommandee = quantiteCommandee;
		this.idPanier = idPanier;
		this.idProduit = idProduit;
	}

	// Les getters et les setters classiques
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantiteCommandee() {
		return this.quantiteCommandee;
	}

	public void setQuantiteCommandee(int quantiteCommandee) {
		this.quantiteCommandee = quantiteCommandee;
	}

	public int getIdPanier() {
		return this.idPanier;
	}

	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}

	public int getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "LigneCommande [id=" + this.id + ", quantiteCommandee=" + this.quantiteCommandee + ", idPanier" + this.idPanier
				+ ", idProduit=" + this.idProduit + "]";
	}
	
}
