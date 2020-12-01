package org.eclipse.model;

public class LigneCommande {
	/** Classe d'association entre Commande et Produit */

	// Attributs
	private int id;
	private int quantiteCommandee;
	private int idCommande;
	private int idProduit;
	private double prixUnitaire;

	// Les constructeur
	// Constructeur vide
	public LigneCommande() {
	}

	// Constructeur pour le delete
	public LigneCommande(int id) {
		this.id = id;
	}
	
	// Constructeur pour le save
	public LigneCommande(int quantiteCommandee, int idCommande, int idProduit, double prixUnitaire) {
		this.quantiteCommandee = quantiteCommandee;
		this.idCommande = idCommande;
		this.idProduit = idProduit;
		this.prixUnitaire = prixUnitaire;
	}
	
	// Constructeur pour l'update, le findById et le findAll	
	public LigneCommande(int id, int quantiteCommandee, int idCommande, int idProduit, double prixUnitaire) {
		this.id = id;
		this.quantiteCommandee = quantiteCommandee;
		this.idCommande = idCommande;
		this.idProduit = idProduit;
		this.prixUnitaire = prixUnitaire;
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

	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getIdProduit() {
		return this.idProduit;
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

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "LigneCommande [id=" + this.id + ", quantiteCommandee=" + this.quantiteCommandee + ", idCommande="
				+ this.idCommande + ", idProduit=" + this.idProduit + ", prixUnitaire=" + this.prixUnitaire + "]";
	}

}
