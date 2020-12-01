package org.eclipse.model;

import java.util.ArrayList;
import java.util.Date;

public class Produit {
	/** Classe decrivant les produits vendus sur le site */

	// Attributs
	private int id;
	private String designation;
	private double prixUnitaire;
	private int quantiteEnStock;
	private String urlImage;
	private String descriptionProduit;
	private int idVendeur;
	private Date dateDebut;
	private ArrayList<Integer> idCategories = new ArrayList<Integer>();
	private ArrayList<Integer> idLignesCommande = new ArrayList<Integer>();

	// Les constructeurs
	// Constructeur vide
	public Produit() {
	}
	
	// Constructeur pour le delete
	public Produit(int id) {
		this.id = id;
	}

	// Constructeur pour l'update, le findById et le findAll
	public Produit(int id, String designation, double prixUnitaire, int quantiteEnStock, String urlImage,
			String descriptionProduit, int idVendeur, Date dateDebut, ArrayList<Integer> idCategories, ArrayList<Integer> idLignesCommande) {
		this.id = id;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.quantiteEnStock = quantiteEnStock;
		this.urlImage = urlImage;
		this.descriptionProduit = descriptionProduit;
		this.idVendeur = idVendeur;
		this.dateDebut = dateDebut;
		this.idCategories = idCategories;
		this.idLignesCommande = idLignesCommande;
	}

	// Constructeur pour le save	
	public Produit(String designation, double prixUnitaire, int quantiteEnStock, String urlImage,
			String descriptionProduit, int idVendeur, Date dateDebut, ArrayList<Integer> idCategories,
			ArrayList<Integer> idLignesCommande) {
		super();
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.quantiteEnStock = quantiteEnStock;
		this.urlImage = urlImage;
		this.descriptionProduit = descriptionProduit;
		this.idVendeur = idVendeur;
		this.dateDebut = dateDebut;
		this.idCategories = idCategories;
		this.idLignesCommande = idLignesCommande;
	}

	// Les getters et les setters classiques
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public String getUrlImage() {
		return this.urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getDescriptionProduit() {
		return this.descriptionProduit;
	}

	public void setDescriptionProduit(String descriptionProduit) {
		this.descriptionProduit = descriptionProduit;
	}

	public int getIdVendeur() {
		return this.idVendeur;
	}

	public void setIdVendeur(int idVendeur) {
		this.idVendeur = idVendeur;
	}
	
	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public ArrayList<Integer> getIdCategories() {
		return idCategories;
	}

	public void setIdCategories(ArrayList<Integer> idCategories) {
		this.idCategories = idCategories;
	}

	public ArrayList<Integer> getIdLignesCommande() {
		return idLignesCommande;
	}

	public void setIdLignesCommande(ArrayList<Integer> idLignesCommande) {
		this.idLignesCommande = idLignesCommande;
	}

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "Produit [id=" + this.id + ", designation=" + this.designation + ", prixUnitaire=" + this.prixUnitaire
				+ ", quantiteEnStock=" + this.quantiteEnStock + ", urlImageString=" + this.urlImage
				+ ", descriptionProduitString=" + this.descriptionProduit + ", idVendeur=" + this.idVendeur
				+ ", dateDebut=" + this.dateDebut + ", idCategories=" + this.idCategories 
				+ ", idLignesCommandes=" + this.idLignesCommande + "]";
	}

}
