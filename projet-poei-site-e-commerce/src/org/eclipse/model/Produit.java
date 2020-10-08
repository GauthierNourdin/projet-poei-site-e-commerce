package org.eclipse.model;

import java.util.ArrayList;

public class Produit {
	/** Classe décrivant les produits vendus sur le site */

	// Attributs
	private String id;
	private String designation;
	private double prixUnitaire;
	private int quantiteEnStock;
	private String urlImageString;
	private String descriptionProduitString;
	private Vendeur vendeur;
	private ArrayList<LigneCommande> lignesCommande;

	// Le constructeur
	public Produit(String id, String designation, double prixUnitaire, int quantiteEnStock, String urlImageString,
			String descriptionProduitString, Vendeur vendeur) {
		// Constructeur complet permettant la création standard d'un produit
		this.id = id;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.quantiteEnStock = quantiteEnStock;
		this.urlImageString = urlImageString;
		this.descriptionProduitString = descriptionProduitString;
		this.vendeur = vendeur;
		this.lignesCommande = new ArrayList<LigneCommande>();
		// Le tableau des commandes du produit commence vide.
	}

	// Les getters et les setters classiques
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

	public double getPrixUnitaire() {
		return this.prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
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

	public ArrayList<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(ArrayList<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	/*
	 * La méthode "toString" sert uniquement au débuggage. Pour éviter les boucles
	 * d'affichage infinies on n'écrit pas directement les lignes de commandes et le
	 * vendeur mais on écrit juste leur id.
	 */
	public String toString() {
		String idLignesCommande = "";
		if(this.lignesCommande.size() != 0) {
			idLignesCommande += " [";
			int i;
			for(i = 0 ; i < this.lignesCommande.size() - 1 ; i++) {
				idLignesCommande += this.lignesCommande.get(i).getId() + ", ";
			}
			idLignesCommande += this.lignesCommande.get(i).getId() + " ]";
		} else {
			idLignesCommande += " [ ]";
		}
		return "Produit [id=" + this.id + ", designation=" + this.designation + ", prixUnitaire=" + this.prixUnitaire
				+ ", quantiteEnStock=" + this.quantiteEnStock + ", urlImageString=" + this.urlImageString
				+ ", descriptionProduitString=" + this.descriptionProduitString + ", vendeur.id=" + this.vendeur.getId()
				+ ", lignesCommandes.id=" + idLignesCommande + "]";
	}

}
