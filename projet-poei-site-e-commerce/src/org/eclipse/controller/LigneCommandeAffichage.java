package org.eclipse.controller;

public class LigneCommandeAffichage {
	/** Classe spéciale pour afficher les lignes de commandes complètes*/
	
	// Attributs
	private int id;
	private int quantiteCommandee;
	private int idCommande;
	private int idProduit;
	private double prixUnitaire;
	private String designation;
	private String urlImage;
	
	// Les constructeurs	
	public LigneCommandeAffichage() {
	}

	public LigneCommandeAffichage(int id, int quantiteCommandee, int idCommande, int idProduit, double prixUnitaire,
			String designation, String urlImage) {
		this.id = id;
		this.quantiteCommandee = quantiteCommandee;
		this.idCommande = idCommande;
		this.idProduit = idProduit;
		this.prixUnitaire = prixUnitaire;
		this.designation = designation;
		this.urlImage = urlImage;
	}

	// Les getters et les setters classiques
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantiteCommandee() {
		return quantiteCommandee;
	}

	public void setQuantiteCommandee(int quantiteCommandee) {
		this.quantiteCommandee = quantiteCommandee;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	// La méthode toString ne sert qu'au débuggage
	public String toString() {
		return "LigneCommandeAffichage [id=" + id + ", quantiteCommandee=" + quantiteCommandee + ", idCommande="
				+ idCommande + ", idProduit=" + idProduit + ", prixUnitaire=" + prixUnitaire + ", designation="
				+ designation + ", urlImage=" + urlImage + "]";
	}
	
}
