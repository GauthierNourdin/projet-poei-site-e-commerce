package org.eclipse.model;

import java.util.Arrays;

public class Panier {
	/** Classe d�crivant le panier qu'utilise le client pour pr�parer ses achats. */

	// Attributs
	private String id;
	private LignePanier[] lignesPanier;
	private Client client;

	// Le constructeur
	public Panier(String id, Client client) {
		/*
		 * Le panier est cr�� en relation avec un client et porte l'id de son client. Le
		 * tableau des lignes de commande commence vide avec un nombre de lignes limit�
		 * � 50
		 */
		this.id = id;
		this.lignesPanier = new LignePanier[50];
		/* Limitation � 50 lignes par panier. La ligne de panier commence vide */
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

	// La m�thode "toString" sert uniquement au d�buggage
	public String toString() {
		return "Panier [id=" + id + ", lignesPanier=" + Arrays.toString(lignesPanier) + ", client=" + client + "]";
	}

}
