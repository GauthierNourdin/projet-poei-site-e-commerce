package org.eclipse.model;

public class LignePanier {
	/** Classe d'association entre Panier et Produit */
	
	// Attributs
	private String id;
	private int quantiteCommandee;
	private Panier panier;
	private Produit produit;
	
	// Le constructeur
	public LignePanier(String id, int quantiteCommandee, Panier panier, Produit produit) {
		// Constructeur complet pour la création standard d'une ligne de commande
		this.id = id;
		this.quantiteCommandee = quantiteCommandee;
		this.panier = panier;
		this.produit = produit;
	}

	// Les getteurs et setteurs classiques
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantiteCommandee() {
		return this.quantiteCommandee;
	}

	public void setQuantiteCommandee(int quantiteCommandee) {
		this.quantiteCommandee = quantiteCommandee;
	}

	public Panier getPanier() {
		return this.panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	// La méthode "toString" sert uniquement au débuggage
	public String toString() {
		return "LigneCommande [id=" + this.id + ", quantiteCommandee=" + this.quantiteCommandee + ", panier=" + this.panier
				+ ", produit=" + this.produit + "]";
	}
	
}
