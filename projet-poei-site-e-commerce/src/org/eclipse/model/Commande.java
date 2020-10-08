package org.eclipse.model;

import java.sql.Date;
import java.util.ArrayList;

public class Commande {
	/** Classe permettant d'enregistrer les commandes pass�s par les utilisateurs */

	// Attributs
	private String id;
	private Client client;
	private ArrayList<LigneCommande> lignesCommande;
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
		this.lignesCommande = new ArrayList<LigneCommande>();
		// La ligne de commande commence vide.
		this.dateDeCommande = dateDeCommande;
	}

	// Les getters et les setters classiques
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

	public ArrayList<LigneCommande> getLignesCommande() {
		return this.lignesCommande;
	}

	public void setLignesCommande(ArrayList<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	public Date getDateDeCommande() {
		return this.dateDeCommande;
	}

	public void setDateDeCommande(Date dateDeCommande) {
		this.dateDeCommande = dateDeCommande;
	}

	/*
	 * La m�thode "toString" sert uniquement au d�buggage. Pour �viter les boucles
	 * d'affichage infinies on n'�crit pas directement les lignes de commande et le
	 * client mais on �crit juste leur id.
	 */
	public String toString() {
		String idLignesCommande = "";
		if(this.lignesCommande.size() != 0) {
			idLignesCommande += " [";
			int i;
			for(i = 0 ; i < this.lignesCommande.size() ; i++) {
				idLignesCommande += this.lignesCommande.get(i).getId() + ", ";
				++i;
			}
			idLignesCommande += this.lignesCommande.get(i).getId() + " ]";
		} else {
			idLignesCommande += " [ ]";			
		}
		return "Commande [id=" + this.id + ", client.id=" + this.client.getId() + ", lignesCommande.id=" + idLignesCommande
				+ ", dateDeCommande=" + this.dateDeCommande + "]";
	}

}
