package org.eclipse.model;

import java.util.Date;
import java.util.ArrayList;

public class Commande {
	/** Classe permettant d'enregistrer les commandes passés par les utilisateurs */

	// Attributs
	private int id;
	private int idClient;
	private ArrayList<Integer> idLignesCommande;
	private Date dateDeCommande;

	// Le constructeur
	public Commande(int id, int idClient, Date dateDeCommande) {
		this.id = id;
		this.idClient = idClient;
		this.idLignesCommande = new ArrayList<Integer>();
		// La ligne de commande commence vide.
		this.dateDeCommande = dateDeCommande;
	}

	// Les getters et les setters classiques
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int client) {
		this.idClient = client;
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

	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "Commande [id=" + this.id + ", idClient" + this.idClient + ", idLignesCommande=" + this.idLignesCommande
				+ ", dateDeCommande=" + this.dateDeCommande + "]";
	}

}
