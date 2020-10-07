package org.eclipse.model;

import java.util.Arrays;

public class Panier {
	/** Classe décrivant le panier qu'utilise le client pour préparer ses achats. */

	// Attributs
	private String id;
	private LignePanier[] lignesPanier;
	private Client client;

	// Le constructeur
	public Panier(String id, Client client) {
		/*
		 * Le panier est créé en relation avec un client et porte l'id de son client. Le
		 * tableau des lignes de commande commence vide avec un nombre de lignes limité
		 * à 50
		 */
		this.id = id;
		this.lignesPanier = new LignePanier[50];
		/* Limitation à 50 lignes par panier. La ligne de panier commence vide */
	}

	// Les getteurs et setteurs classiques
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LignePanier[] getLignesPanier() {
		return this.lignesPanier;
	}

	public void setLignesPanier(LignePanier[] lignesPanier) {
		this.lignesPanier = lignesPanier;
	}

	// La méthode "toString" sert uniquement au débuggage
	public String toString() {
		return "Panier [id=" + id + ", lignesPanier=" + Arrays.toString(lignesPanier) + ", client=" + client + "]";
	}

}
