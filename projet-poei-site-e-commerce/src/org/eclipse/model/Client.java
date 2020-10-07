package org.eclipse.model;

import java.util.Arrays;

public class Client extends Utilisateur {
	/** Classe d�crivant les m�thodes et attributs propres au client */

	// Attributs propres
	private Panier panier;
	private Commande[] commandes;

	// Le constructeur
	public Client(String id, String nom, String prenom, String adresseMail, String numeroTelephone,
			String identifiantConnexion, String motDePasse, Adresse[] adresses) {
		super(id, nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, adresses);
		this.panier = new Panier(id, this);
		/* On envoie au panier � cr�er l'id du client ainsi que l'objet client*/
		this.commandes = new Commande[200];
		/*
		 * Le tableau des commandes commence vide, limitation � 200 commandes par
		 * client.
		 */
	}

	// Les setteurs et les getteurs classiques
	public Panier getPanier() {
		return this.panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public Commande[] getCommandes() {
		return this.commandes;
	}

	public void setCommandes(Commande[] commandes) {
		this.commandes = commandes;
	}

	// La m�thode "toString" sert uniquement au d�buggage
	public String toString() {
		return "Client [panier=" + this.panier + ", commandes=" + Arrays.toString(this.commandes) + ", toString()="
				+ super.toString() + "]";
	}

}
