package org.eclipse.model;

public class LignePanier {
	/** Classe d'association entre Client et Produit */
	
	// Attributs
	private int id;
	private int quantiteSouhaitee;
	private int idClient;
	private int idProduit;
	
	// Les constructeurs
	public LignePanier() {
	}
	
	public LignePanier(int quantiteSouhaitee, int idClient, int idProduit) {
		this.id = GestionnaireId.giveNewIdLignePanier();
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
