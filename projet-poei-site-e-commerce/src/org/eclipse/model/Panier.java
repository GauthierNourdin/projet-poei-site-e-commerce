package org.eclipse.model;

import java.util.ArrayList;

public class Panier {
	/** Classe d�crivant le panier qu'utilise le client pour pr�parer ses achats. */

	// Attributs
	private String id;
	private ArrayList<LignePanier> lignesPanier;
	private Client client;

	// Le constructeur
	public Panier(String id, Client client) {
		/*
		 * Le panier est cr�� en relation avec un client et porte l'id de son client. Le
		 * tableau des lignes de commande commence vide avec un nombre de lignes limit�
		 * � 50
		 */
		this.id = id;
		this.lignesPanier = new ArrayList<LignePanier>();
		// La ligne de panier commence vide */
	}

	// Les getters et les setters classiques
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

	public ArrayList<LignePanier> getLignesPanier() {
		return this.lignesPanier;
	}

	public void setLignesPanier(ArrayList<LignePanier> lignesPanier) {
		this.lignesPanier = lignesPanier;
	}

	/*
	 * La m�thode "toString" sert uniquement au d�buggage. Pour �viter les boucles
	 * d'affichage infinies on n'�crit pas directement les lignes de panier et le
	 * client mais on �crit juste leur id.
	 */
	public String toString() {
		String idLignesPanier = "";
		if (this.lignesPanier.size() != 0) {
			idLignesPanier += " [";
			int i;
			for (i = 0; i < this.lignesPanier.size() - 1; i++) {
				idLignesPanier += this.lignesPanier.get(i).getId() + ", ";
				++i;
			}
			idLignesPanier += this.lignesPanier.get(i).getId() + " ]";
		} else {
			idLignesPanier += " [ ]";
		}
		return "Panier [id=" + this.id + ", lignesPanier.id=" + idLignesPanier + ", client.id=" + this.client.getId()
				+ "]";
	}

}
