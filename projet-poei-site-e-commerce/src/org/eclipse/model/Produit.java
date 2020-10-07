package org.eclipse.model;

import java.util.Arrays;

public class Produit {
	/** Classe décrivant les produits vendus sur le site */

	// Attributs
	private String id;
	private String designation;
	private float prixUnitaire;
	private int quantiteEnStock;
	private String urlImageString;
	private String descriptionProduitString;
	private Vendeur vendeur;
	private LigneCommande[] commandes;

	public Produit(String id, String designation, float prixUnitaire, int quantiteEnStock, String urlImageString,
			String descriptionProduitString, Vendeur vendeur) {
		// Constructeur complet permettant la création standard d'un produit
		this.id = id;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.quantiteEnStock = quantiteEnStock;
		this.urlImageString = urlImageString;
		this.descriptionProduitString = descriptionProduitString;
		this.vendeur = vendeur;
		this.commandes = new LigneCommande[5000];
		/*
		 * Le tableau des commandes du produit commence vide. On place une limite de
		 * 5000 commandes par produit. On utilise les lignes de commandes comme base
		 */
	}

	// Les getteurs et les setteurs classiques
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getPrixUnitaire() {
		return this.prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getQuantiteEnStock() {
		return this.quantiteEnStock;
	}

	public void setQuantiteEnStock(int quantiteEnStock) {
		this.quantiteEnStock = quantiteEnStock;
	}

	public String getUrlImageString() {
		return this.urlImageString;
	}

	public void setUrlImageString(String urlImageString) {
		this.urlImageString = urlImageString;
	}

	public String getDescriptionProduitString() {
		return this.descriptionProduitString;
	}

	public void setDescriptionProduitString(String descriptionProduitString) {
		this.descriptionProduitString = descriptionProduitString;
	}

	public Vendeur getVendeur() {
		return this.vendeur;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}
	
	public LigneCommande[] getCommandes() {
		return commandes;
	}

	public void setCommandes(LigneCommande[] commandes) {
		this.commandes = commandes;
	}

	// La méthode "toString" sert uniquement au débuggage
	public String toString() {
		return "Produit [id=" + this.id + ", designation=" + this.designation + ", prixUnitaire=" + this.prixUnitaire
				+ ", quantiteEnStock=" + this.quantiteEnStock + ", urlImageString=" + this.urlImageString
				+ ", descriptionProduitString=" + this.descriptionProduitString + ", vendeur=" + this.vendeur + ", commandes="
				+ Arrays.toString(this.commandes) + "]";
	}

}
