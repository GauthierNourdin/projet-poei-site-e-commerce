package org.eclipse.model;

import java.util.Date;
import java.util.ArrayList;

public class Commande {
	/** Classe permettant d'enregistrer les commandes passes par les utilisateurs */

	// Attributs
	private int id;
	private int idClient;
	private ArrayList<Integer> idLignesCommande = new ArrayList<Integer>();
	private Date dateDeCommande;

	// Les constructeurs
	public Commande() {
		this.dateDeCommande = new Date();
	}
	
	public Commande(int idClient) {
		this.id = GestionnaireId.giveNewIdCommande();
		this.idClient = idClient;
		this.dateDeCommande = new Date();
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

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "Commande [id=" + this.id + ", idClient" + this.idClient + ", idLignesCommande=" + this.idLignesCommande
				+ ", dateDeCommande=" + this.dateDeCommande + "]";
	}

}
