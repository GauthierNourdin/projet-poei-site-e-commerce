package org.eclipse.controller;

import java.sql.Date;
import java.util.ArrayList;

public class CommandeAffichage {
	/** Classe spéciale pour afficher les commandes avec un prix total et un nombre d'articles*/

	// Attributs
	private int id;
	private int idClient;
	private ArrayList<Integer> idLignesCommande = new ArrayList<Integer>();
	private Date dateDeCommande;
	private int nombreArticles;
	private double prixTotal;
	
	public CommandeAffichage() {
	}

	public CommandeAffichage(int id, int idClient, ArrayList<Integer> idLignesCommande, Date dateDeCommande,
			int nombreArticles, double prixTotal) {
		this.id = id;
		this.idClient = idClient;
		this.idLignesCommande = idLignesCommande;
		this.dateDeCommande = dateDeCommande;
		this.nombreArticles = nombreArticles;
		this.prixTotal = prixTotal;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public ArrayList<Integer> getIdLignesCommande() {
		return this.idLignesCommande;
	}

	public void setIdLignesCommande(ArrayList<Integer> idLignesCommande) {
		this.idLignesCommande = idLignesCommande;
	}

	public Date getDateDeCommande() {
		return this.dateDeCommande;
	}

	public void setDateDeCommande(Date dateDeCommande) {
		this.dateDeCommande = dateDeCommande;
	}

	public int getNombreArticles() {
		return this.nombreArticles;
	}

	public void setNombreArticles(int nombreArticles) {
		this.nombreArticles = nombreArticles;
	}

	public double getPrixTotal() {
		return this.prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	// La méthode toString ne sert qu'au débuggage
	public String toString() {
		return "CommandeAffichage [id=" + this.id + ", idClient=" + this.idClient + ", idLignesCommande=" + this.idLignesCommande
				+ ", dateDeCommande=" + this.dateDeCommande + ", nombreArticles=" + this.nombreArticles + ", prixTotal="
				+ this.prixTotal + "]";
	}
	
}
