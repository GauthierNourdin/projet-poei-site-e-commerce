package org.eclipse.model;

public class LigneCommande {
	/** Classe d'association entre Commande et Produit */
	
	// Attributs
	private String id;
	private int quantiteCommandee;
	private Commande commande;
	private Produit produit;
	
	// Le constructeur
	public LigneCommande(String id, int quantiteCommandee, Commande commande, Produit produit) {
		// Constructeur complet pour la création standard d'une ligne de commande
		this.id = id;
		this.quantiteCommandee = quantiteCommandee;
		this.commande = commande;
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

	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	// La méthode "toString" sert uniquement au débuggage
	public String toString() {
		return "LigneCommande [id=" + this.id + ", quantiteCommandee=" + this.quantiteCommandee + ", commande=" + this.commande
				+ ", produit=" + this.produit + "]";
	}
	
}
