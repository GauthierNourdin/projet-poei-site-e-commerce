package org.eclipse.model;

public class LigneCommande {
	/** Classe d'association entre Commande et Produit */

	// Attributs
	private String id;
	private int quantiteCommandee;
	private Commande commande;
	private Produit produit;

	// Les constructeurs
	public LigneCommande(String id, int quantiteCommandee, Commande commande, Produit produit) {
		// Constructeur complet pour la création standard d'une ligne de commande
		this.id = id;
		this.quantiteCommandee = quantiteCommandee;
		this.commande = commande;
		this.produit = produit;
	}
	
	public LigneCommande() {
		// Constructeur vide pour le debuggage
	}

	// Les getters et les setters classiques
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

	/*
	 * La méthode "toString" sert uniquement au débuggage. Pour éviter les boucles
	 * d'affichage infinies on n'écrit pas directement la commande et le produit
	 * mais on écrit juste leur id.
	 */
	public String toString() {
		return "LigneCommande [id=" + this.id + ", quantiteCommandee=" + this.quantiteCommandee + ", commande.id="
				+ this.commande.getId() + ", produit.id=" + this.produit.getId() + "]";
	}

}
