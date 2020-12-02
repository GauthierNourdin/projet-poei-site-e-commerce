package org.eclipse.controller;

import java.sql.Date;

public class CommandeProduit {
	/** Classe spéciale pour afficher l'historique des commandes d'un produit*/
	
	private Date dateDeCommande;
	private int quantiteCommandee;
	private double prixUnitaire;
	
	public CommandeProduit() {
	}

	public CommandeProduit(Date dateDeCommande, int quantiteCommandee, double prixUnitaire) {
		this.dateDeCommande = dateDeCommande;
		this.quantiteCommandee = quantiteCommandee;
		this.prixUnitaire = prixUnitaire;
	}

	public Date getDateDeCommande() {
		return this.dateDeCommande;
	}

	public void setDateDeCommande(Date dateDeCommande) {
		this.dateDeCommande = dateDeCommande;
	}

	public int getQuantiteCommandee() {
		return this.quantiteCommandee;
	}

	public void setQuantiteCommandee(int quantiteCommandee) {
		this.quantiteCommandee = quantiteCommandee;
	}

	public double getPrixUnitaire() {
		return this.prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	// La méthode toString ne sert qu'au débuggage.
	public String toString() {
		return "CommandeProduit [dateDeCommande=" + this.dateDeCommande + ", quantiteCommandee=" + this.quantiteCommandee
				+ ", prixUnitaire=" + this.prixUnitaire + "]";
	}

}
