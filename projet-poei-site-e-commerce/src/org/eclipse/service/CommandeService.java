package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.Commande;

public class CommandeService {

	// Attributs
	private ArrayList<Commande> commandes;

	// Le constructeur
	public CommandeService(ArrayList<Commande> commandes) {
		this.commandes = commandes;
	}

	// Les getters et les setters classiques
	public ArrayList<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(ArrayList<Commande> commandes) {
		this.commandes = commandes;
	}

	// M�thode pour ajouter une commande dans la liste
	public boolean save(Commande commande) {
		/*
		 * On v�rifie que la commande n'appartient pas d�j� � la liste avant de la
		 * rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (this.commandes.contains(commande)) {
			return false;
		} else {
			return this.commandes.add(commande);
		}
	}

	// M�thode pour retirer une commande de la liste
	public boolean remove(Commande commande) {
		/*
		 * On v�rifie que la commande est bien pr�sente dans la liste avant de la
		 * supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (this.commandes.contains(commande)) {
			return this.commandes.remove(commande);
		} else {
			return false;
		}
	}

	// M�thode pour mettre � jour une commande
	public boolean update(Commande commande) {
		/*
		 * La m�thode retourne true si la commande � mettre � jour est dans la liste,
		 * false sinon.
		 */
		for (Commande comm : this.commandes) {
			if (comm.getId() == commande.getId()) {
				comm = commande;
				return true;
			}
		}
		return false;
	}

	// M�thode pour rendre la liste compl�te (convention de nommage)
	public ArrayList<Commande> findAll() {
		return this.commandes;
	}

	// M�thode pour trouver dans la liste une commande d'id connu
	public Commande findById(String id) {
		for (Commande comm : this.commandes) {
			if (comm.getId() == id) {
				return comm;
			}
		}
		return null;
	}

	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "ClientService [commandes=" + this.commandes + "]";
	}

}
