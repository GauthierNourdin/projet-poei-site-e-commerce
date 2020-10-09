package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.LignePanier;

public class LignePanierService {

	// Attributs
	private ArrayList<LignePanier> lignesPanier;

	// Le constructeur
	public LignePanierService(ArrayList<LignePanier> lignesPaniers) {
		this.lignesPanier = lignesPaniers;
	}

	// Les getters et les setters classiques
	public ArrayList<LignePanier> getLignesPaniers() {
		return this.lignesPanier;
	}

	public void setLignesPaniers(ArrayList<LignePanier> lignesPaniers) {
		this.lignesPanier = lignesPaniers;
	}

	// M�thode pour ajouter une ligne de panier dans la liste
	public boolean save(LignePanier lignePanier) {
		/*
		 * On v�rifie que la ligne de panier n'appartient pas d�j� � la liste avant de
		 * la rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (this.lignesPanier.contains(lignePanier)) {
			return false;
		} else {
			return this.lignesPanier.add(lignePanier);
		}
	}

	// M�thode pour retirer une ligne de panier de la liste
	public boolean remove(LignePanier lignePanier) {
		/*
		 * On v�rifie que la ligne de panier est bien pr�sente dans la liste avant de la
		 * supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (this.lignesPanier.contains(lignePanier)) {
			return this.lignesPanier.remove(lignePanier);
		} else {
			return false;
		}
	}

	// M�thode pour mettre � jour une ligne de panier
	public boolean update(LignePanier lignePanier) {
		/*
		 * La m�thode retourne true si la ligne de panier � mettre � jour est dans la
		 * liste, false sinon.
		 */
		for (LignePanier lignPani : this.lignesPanier) {
			if (lignPani.getId() == lignePanier.getId()) {
				lignPani = lignePanier;
				return true;
			}
		}
		return false;
	}

	// M�thode pour rendre la liste compl�te (convention de nommage)
	public ArrayList<LignePanier> findAll() {
		return this.lignesPanier;
	}

	// M�thode pour trouver dans la liste une ligne de panier d'id connu
	public LignePanier findById(String id) {
		for (LignePanier lignPani : this.lignesPanier) {
			if (lignPani.getId() == id) {
				return lignPani;
			}
		}
		return null;
	}

	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "LignePanierService [lignesPanier=" + this.lignesPanier + "]";
	}

}
