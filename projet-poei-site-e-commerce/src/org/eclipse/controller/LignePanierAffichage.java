package org.eclipse.controller;

public class LignePanierAffichage {
	/** Classe spéciale pour afficher les lignes de panier complètes*/
	
	// Attributs
	private int id;
	private int quantiteSouhaitee;
	private double prixUnitaire;
	private String designation;
	private String urlImage;

	public LignePanierAffichage() {
	}

	public LignePanierAffichage(int id, int quantiteSouhaitee, double prixUnitaire, String designation,
			String urlImage) {
		super();
		this.id = id;
		this.quantiteSouhaitee = quantiteSouhaitee;
		this.prixUnitaire = prixUnitaire;
		this.designation = designation;
		this.urlImage = urlImage;
	}

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

	public double getPrixUnitaire() {
		return this.prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getUrlImage() {
		return this.urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	// La méthode toString ne sert qu'au débuggage
	public String toString() {
		return "LignePanierAffichage [id=" + this.id + ", quantiteSouhaitee=" + this.quantiteSouhaitee + ", prixUnitaire="
				+ this.prixUnitaire + ", designation=" + this.designation + ", urlImage=" + this.urlImage + "]";
	}
	
}
