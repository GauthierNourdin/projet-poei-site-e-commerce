package org.eclipse.model;

public class LigneCommande {
	/** Classe d'association entre Commande et Produit */

	// Attributs
	private int id;
	private int quantiteCommandee;
	private int idCommande;
	private int idProduit;

	// Les constructeurs
	public LigneCommande() {
	}
	
	public LigneCommande(int quantiteCommandee, int idCommande, int idProduit) {
		this.id = GestionnaireId.giveNewIdLigneCommande();
		this.quantiteCommandee = quantiteCommandee;
		this.idCommande = idCommande;
		this.idProduit = idProduit;
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

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "LigneCommande [id=" + this.id + ", quantiteCommandee=" + this.quantiteCommandee + ", idCommande="
				+ this.idCommande + ", idProduit=" + this.idProduit + "]";
	}

}
