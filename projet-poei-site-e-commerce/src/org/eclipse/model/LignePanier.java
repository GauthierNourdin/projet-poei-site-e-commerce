package org.eclipse.model;

public class LignePanier {
	/** Classe d'association entre Panier et Produit */
	
	// Attributs
	private int id;
	private int quantiteSouhaitee;
	private int idPanier;
	private int idProduit;
	
	// Le constructeur
	public LignePanier(int quantiteSouhaitee, int idPanier, int idProduit) {
		this.id = GestionnaireId.giveNewIdLignePanier();
		this.quantiteSouhaitee = quantiteSouhaitee;
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

	public int getQuantiteSouhaitee() {
		return this.quantiteSouhaitee;
	}

	public void setQuantiteSouhaitee(int quantiteSouhaitee) {
		this.quantiteSouhaitee = quantiteSouhaitee;
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

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "LigneCommande [id=" + this.id + ", quantiteCommandee=" + this.quantiteSouhaitee + ", idPanier" + this.idPanier
				+ ", idProduit=" + this.idProduit + "]";
	}
	
}
