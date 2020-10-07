package org.eclipse.model;

public class Produit {
    /** Classe décrivant les produits vendus sur le site */
	
	// Attributs
	private String id;
	private String designation;
	private float prixUnitaire;
	private int QuantiteEnStock;
	private String urlImageString;
	private String descriptionProduitString;
	private Vendeur vendeur;
	
	public Produit(String id, String designation, float prixUnitaire, int quantiteEnStock, String urlImageString,
			String descriptionProduitString, Vendeur vendeur) {
		// Constructeur complet permettant la création standard d'un produit
		this.id = id;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		QuantiteEnStock = quantiteEnStock;
		this.urlImageString = urlImageString;
		this.descriptionProduitString = descriptionProduitString;
		this.vendeur = vendeur;
	}

	// Les getteurs et les setteurs classiques
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	
	public int getQuantiteEnStock() {
		return QuantiteEnStock;
	}
	
	public void setQuantiteEnStock(int quantiteEnStock) {
		QuantiteEnStock = quantiteEnStock;
	}
	
	public String getUrlImageString() {
		return urlImageString;
	}
	
	public void setUrlImageString(String urlImageString) {
		this.urlImageString = urlImageString;
	}
	
	public String getDescriptionProduitString() {
		return descriptionProduitString;
	}
	
	public void setDescriptionProduitString(String descriptionProduitString) {
		this.descriptionProduitString = descriptionProduitString;
	}
	
	public Vendeur getVendeur() {
		return vendeur;
	}
	
	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

	// La méthode "toString" sert uniquement au débuggage
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", prixUnitaire=" + prixUnitaire
				+ ", QuantiteEnStock=" + QuantiteEnStock + ", urlImageString=" + urlImageString
				+ ", descriptionProduitString=" + descriptionProduitString + ", vendeur=" + vendeur + "]";
	}
	
	
	
}
