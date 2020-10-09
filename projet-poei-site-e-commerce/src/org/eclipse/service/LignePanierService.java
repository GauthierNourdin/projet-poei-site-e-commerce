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

	// Méthode pour mettre à jour une ligne de panier
	public boolean update(LignePanier lignePanier) {
		/*
		 * La méthode retourne true si la ligne de panier à mettre à jour est dans la
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

	// Méthode pour rendre la liste complète (convention de nommage)
	public ArrayList<LignePanier> findAll() {
		return this.lignesPanier;
	}

	// Méthode pour trouver dans la liste une ligne de panier d'id connu
	public LignePanier findById(String id) {
		for (LignePanier lignPani : this.lignesPanier) {
			if (lignPani.getId() == id) {
				return lignPani;
			}
		}
		return null;
	}

	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "LignePanierService [lignesPanier=" + this.lignesPanier + "]";
	}

}
