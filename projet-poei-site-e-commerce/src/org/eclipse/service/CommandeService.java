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

	// M�thode pour mettre � jour une commande (m�me ID !)
	public boolean update(Commande commande) {
		/*
		 * On compare l'id de la commande dans la liste avec l'id de la commande que l'on a envoy�
		 * en entr�e. Si on obtient une correspondance, on enl�ve la commande avec cet id
		 * de la liste et on rajoute la commande en entr�e. Seul la premi�re commande ayant
		 * cet id sera �limin�. La fonction retourne "true" si on a pu proc�der au
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

	// M�thode pour rendre la liste compl�te (convention de nommage)
	public ArrayList<Commande> findAll() {
		return this.commandes;
	}

	// M�thode pour trouver dans la liste une commande d'id connu
	public Commande findById(String id) {
		for (Commande commandeIndividuelle : this.commandes) {
			if (commandeIndividuelle.getId() == id) {
				return commandeIndividuelle;
			}
		}
		return null;
	}

	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "ClientService [commandes=" + this.commandes + "]";
	}

}
