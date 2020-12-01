package org.eclipse.model;

public class LignePanier {
	/** Classe d'association entre Client et Produit */
	
	// Attributs
	private int id;
	private int quantiteSouhaitee;
	private int idClient;
	private int idProduit;
	
	// Les constructeurs
	// Constructeur vide
	public LignePanier() {
	}

	// Constructeur pour le delete
	public LignePanier(int id) {
		this.id = id;
	}
	
	// Constructeur pour le save
	public LignePanier(int quantiteSouhaitee, int idClient, int idProduit) {
		this.quantiteSouhaitee = quantiteSouhaitee;
		this.idClient = idClient;
		this.idProduit = idProduit;
	}	
	
	// Constructeur pour l'update, le findById et le findAll
	public LignePanier(int id, int quantiteSouhaitee, int idClient, int idProduit) {
		this.id = id;
		this.quantiteSouhaitee = quantiteSouhaitee;
		this.idClient = idClient;
		this.idProduit = idProduit;
	}

	// Les getters et les setters classiques
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

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "LigneCommande [id=" + this.id + ", quantiteCommandee=" + this.quantiteSouhaitee + ", idClient" + this.idClient
				+ ", idProduit=" + this.idProduit + "]";
	}
	
}
