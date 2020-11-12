package org.eclipse.model;

import java.util.Date;

public class Commentaire {

	private Date date;
	private int idUtilisateur;
	private int idProduit;
	private int id;
	private int idPrecedent;
	private String commentaire;

	public Commentaire(int idUtilisateur, int idProduit, int idPrecedent, String commentaire) {
		this.idUtilisateur = idUtilisateur;
		this.idProduit = idProduit;
		this.id = GestionnaireId.giveNewIdCommentaire();
		this.commentaire = commentaire;
		this.date = new Date();
		this.idPrecedent = idPrecedent;
	}

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

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
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
				+ this.idProduit + ", id=" + this.id + ", idPrecedent=" + this.idPrecedent + ", commentaire=" + this.commentaire + "]";
	}

}
