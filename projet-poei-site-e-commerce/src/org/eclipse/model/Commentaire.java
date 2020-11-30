package org.eclipse.model;

import java.util.Date;

public class Commentaire {
	/** Classe permettant d'enregistrer les commentaires sur les produits*/

	// Les attributs
	private Date date;
	private int idUtilisateur;
	private int idProduit;
	private int id;
	private int idPrecedent;
	private String texte;

	// Les constructeurs
	public Commentaire(int idUtilisateur, int idProduit, int idPrecedent, String texte) {
		this.idUtilisateur = idUtilisateur;
		this.idProduit = idProduit;
		this.id = GestionnaireId.giveNewIdCommentaire();
		this.texte = texte;
		this.date = new Date();
		this.idPrecedent = idPrecedent;
	}

	// Les getters et les setters classiques
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexte() {
		return this.texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	public int getIdPrecedent() {
		return idPrecedent;
	}

	public void setIdPrecedent(int idPrecedent) {
		this.idPrecedent = idPrecedent;
	}

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "Commentaire [date=" + this.date + ", idUtilisateur=" + this.idUtilisateur + ", idProduit="
				+ this.idProduit + ", id=" + this.id + ", idPrecedent=" + this.idPrecedent + ", texte=" + this.texte + "]";
	}

}
