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

	// Méthode pour ajouter une commande dans la liste
	public boolean save(Commande commande) {
		/*
		 * On vérifie que la commande n'appartient pas déjà à la liste avant de la
		 * rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (this.commandes.contains(commande)) {
			return false;
		} else {
			return this.commandes.add(commande);
		}
	}

	// Méthode pour retirer une commande de la liste
	public boolean remove(Commande commande) {
		/*
		 * On vérifie que la commande est bien présente dans la liste avant de la
		 * supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (this.commandes.contains(commande)) {
			return this.commandes.remove(commande);
		} else {
			return false;
		}
	}

	// Méthode pour mettre à jour une commande (même ID !)
	public boolean update(Commande commande) {
		/*
		 * On compare l'id de la commande dans la liste avec l'id de la commande que l'on a envoyé
		 * en entrée. Si on obtient une correspondance, on enlève la commande avec cet id
		 * de la liste et on rajoute la commande en entrée. Seul la première commande ayant
		 * cet id sera éliminé. La fonction retourne "true" si on a pu procéder au
		 * remplacement, "false" sinon.
		 */
		for (Commande commandeIndividuelle : this.commandes) {
			if (commandeIndividuelle.getId() == commande.getId()) {
				this.commandes.remove(commandeIndividuelle);
				return this.save(commande);
			}
		}
		return false;
	}

	// Méthode pour rendre la liste complète (convention de nommage)
	public ArrayList<Commande> findAll() {
		return this.commandes;
	}

	// Méthode pour trouver dans la liste une commande d'id connu
	public Commande findById(String id) {
		for (Commande commandeIndividuelle : this.commandes) {
			if (commandeIndividuelle.getId() == id) {
				return commandeIndividuelle;
			}
		}
		return null;
	}

	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "ClientService [commandes=" + this.commandes + "]";
	}

}
