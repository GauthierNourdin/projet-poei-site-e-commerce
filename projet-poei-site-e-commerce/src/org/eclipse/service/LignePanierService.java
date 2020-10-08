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

	// Méthode pour ajouter une ligne de panier dans la liste
	public boolean save(LignePanier lignePanier) {
		/*
		 * On vérifie que la ligne de panier n'appartient pas déjà à la liste avant de
		 * la rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (this.lignesPanier.contains(lignePanier)) {
			return false;
		} else {
			return this.lignesPanier.add(lignePanier);
		}
	}

	// Méthode pour retirer une ligne de panier de la liste
	public boolean remove(LignePanier lignePanier) {
		/*
		 * On vérifie que la ligne de panier est bien présente dans la liste avant de la
		 * supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (this.lignesPanier.contains(lignePanier)) {
			return this.lignesPanier.remove(lignePanier);
		} else {
			return false;
		}
	}

	// Méthode pour mettre à jour une ligne de panier (même ID !)
	public boolean update(LignePanier lignePanier) {
		/*
		 * On compare l'id de la ligne de panier dans la liste avec l'id de la ligne de
		 * panier que l'on a envoyé en entrée. Si on obtient une correspondance, on
		 * enlève la ligne de panier avec cet id de la liste et on rajoute la ligne de
		 * panier en entrée. Seul la première ligne de panier ayant cet id sera éliminé.
		 * La fonction retourne "true" si on a pu procéder au remplacement, "false"
		 * sinon.
		 */
		for (LignePanier lignePanierIndividuelle : this.lignesPanier) {
			if (lignePanierIndividuelle.getId() == lignePanier.getId()) {
				this.lignesPanier.remove(lignePanierIndividuelle);
				return this.save(lignePanier);
			}
		}
		return false;
	}

	// Méthode pour rendre la liste complète (convention de nommage)
	public ArrayList<LignePanier> findAll() {
		return this.lignesPanier;
	}

	// Méthode pour trouver dans la liste une ligne de panier d'id connu
	public LignePanier findById(String id) {
		for (LignePanier lignePanierIndividuelle : this.lignesPanier) {
			if (lignePanierIndividuelle.getId() == id) {
				return lignePanierIndividuelle;
			}
		}
		return null;
	}

	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "LignePanierService [lignesPanier=" + this.lignesPanier + "]";
	}

}
