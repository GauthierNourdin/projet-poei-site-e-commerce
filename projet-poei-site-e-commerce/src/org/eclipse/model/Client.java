package org.eclipse.model;

import java.util.ArrayList;

public class Client extends Utilisateur {
	/** Classe décrivant les méthodes et attributs propres au client */

	// Attributs propres
	private Panier panier;
	private ArrayList<Commande> commandes;

	// Le constructeur
	public Client(String id, String nom, String prenom, String adresseMail, String numeroTelephone,
			String identifiantConnexion, String motDePasse, ArrayList<Adresse> adresses) {
		super(id, nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, adresses);
		this.panier = new Panier(this.getId(), this);
		/* On envoie au panier à créer l'id du client ainsi que l'objet client */
		this.commandes = new ArrayList<Commande>();
		// La liste des commandes commence vide.
	}

	// Les getters et les setters classiques
	public Panier getPanier() {
		return this.panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public ArrayList<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(ArrayList<Commande> commandes) {
		this.commandes = commandes;
	}

	/*
	 * La méthode "toString" sert uniquement au débuggage. Pour éviter les boucles
	 * d'affichage infinies on n'écrit pas directement les commandes et le panier
	 * mais on écrit juste leur id.
	 */
	public String toString() {
		String idCommandes = "";
		if (this.commandes.size() != 0) {
			idCommandes += " [";
			int i;
			for (i = 0; i < this.commandes.size() - 1; i++) {
				idCommandes += this.commandes.get(i).getId() + ", ";
				++i;
			}
			idCommandes += this.commandes.get(i).getId() + " ]";
		} else {
			idCommandes += " [ ]";
		}
		return "Client [panier.id=" + this.panier.getId() + ", commandes.id=" + idCommandes + ", toString()="
				+ super.toString() + "]";
	}

}
