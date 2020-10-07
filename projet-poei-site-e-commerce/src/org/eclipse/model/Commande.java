package org.eclipse.model;

import java.sql.Date;
import java.util.Arrays;

public class Commande {
	/** Classe permettant d'enregistrer les commandes pass�s par les utilisateurs */

	// Attributs
	private String id;
	private Client client;
	private LigneCommande[] lignesCommande;
	private Date dateDeCommande;

	// Le constructeur
	public Commande(String id, Client client, Date dateDeCommande) {
		/*
		 * La commande est initialis�e avec un id propre, un client associ� et une
		 * dateDeCommande. Le tableau des lignes de commande commence vide avec un
		 * nombre de lignes limit� � 50
		 */
		this.id = id;
		this.client = client;
		this.lignesCommande = new LigneCommande[50];
		/*
		 * Limitation � 50 lignes par commande. La ligne de commande commence vide
		 */
		this.dateDeCommande = dateDeCommande;
	}

	// Les setters et les getters
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LigneCommande[] getLignesCommande() {
		return this.lignesCommande;
	}

	public void setLignesCommande(LigneCommande[] lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	public Date getDateDeCommande() {
		return this.dateDeCommande;
	}

	public void setDateDeCommande(Date dateDeCommande) {
		this.dateDeCommande = dateDeCommande;
	}

	// La m�thode "toString" sert uniquement au d�buggage
	public String toString() {
		return "Commande [id=" + id + ", client=" + client + ", lignesCommande=" + Arrays.toString(lignesCommande)
				+ ", dateDeCommande=" + dateDeCommande + "]";
	}
	
	

}
