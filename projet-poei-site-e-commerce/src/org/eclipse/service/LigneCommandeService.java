package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.LigneCommande;

public class LigneCommandeService {

	// Attributs
	private ArrayList<LigneCommande> lignesCommande;

	// Le constructeur
	public LigneCommandeService(ArrayList<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	// Les getters et les setters classiques
	public ArrayList<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(ArrayList<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	// M�thode pour ajouter une ligne de commande dans la liste
	public boolean save(LigneCommande ligneCommande) {
		/*
		 * On v�rifie que la ligne de commande n'appartient pas d�j� � la liste avant de
		 * la rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (this.lignesCommande.contains(ligneCommande)) {
			return false;
		} else {
			return this.lignesCommande.add(ligneCommande);
		}
	}

	// M�thode pour retirer une ligne de commande de la liste
	public boolean remove(LigneCommande ligneCommande) {
		/*
		 * On v�rifie que la ligne de commande est bien pr�sente dans la liste avant de
		 * la supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (this.lignesCommande.contains(ligneCommande)) {
			return this.lignesCommande.remove(ligneCommande);
		} else {
			return false;
		}
	}

	// M�thode pour mettre � jour une ligne de commande
	public boolean update(LigneCommande ligneCommande) {
		/*
		 * La m�thode retourne true si la ligne de commande � mettre � jour est dans la
		 * liste, false sinon.
		 */
		for (LigneCommande lignComm : this.lignesCommande) {
			if (lignComm.getId() == ligneCommande.getId()) {
				lignComm = ligneCommande;
				return true;
			}
		}
		return false;
	}

	// M�thode pour rendre la liste compl�te (convention de nommage)
	public ArrayList<LigneCommande> findAll() {
		return this.lignesCommande;
	}

	// M�thode pour trouver dans la liste une ligne de commande d'id connu
	public LigneCommande findById(String id) {
		for (LigneCommande lignComm : this.lignesCommande) {
			if (lignComm.getId() == id) {
				return lignComm;
			}
		}
		return null;
	}

	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "LigneCommandeService [lignesCommande=" + lignesCommande + "]";
	}

}
