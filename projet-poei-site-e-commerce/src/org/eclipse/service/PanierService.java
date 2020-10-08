package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.Panier;

public class PanierService {

	// Attributs
	private ArrayList<Panier> paniers;

	// Le constructeur
	public PanierService(ArrayList<Panier> paniers) {
		this.paniers = paniers;
	}

	// Les getters et les setters classiques
	public ArrayList<Panier> getPaniers() {
		return this.paniers;
	}

	public void setPaniers(ArrayList<Panier> paniers) {
		this.paniers = paniers;
	}

	// Méthode pour ajouter un panier dans la liste
	public boolean save(Panier panier) {
		/*
		 * On vérifie que le panier n'appartient pas déjà à la liste avant de le
		 * rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (this.paniers.contains(panier)) {
			return false;
		} else {
			return this.paniers.add(panier);
		}
	}

	// Méthode pour retirer un panier de la liste
	public boolean remove(Panier panier) {
		/*
		 * On vérifie que le panier est bien présent dans la liste avant de le
		 * supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (this.paniers.contains(panier)) {
			return this.paniers.remove(panier);
		} else {
			return false;
		}
	}

	// Méthode pour mettre à jour un panier (même ID !)
	public boolean update(Panier panier) {
		/*
		 * On compare l'id du panier dans la liste avec l'id du panier que l'on a envoyé
		 * en entrée. Si on obtient une correspondance, on enlève le panier avec cet id
		 * de la liste et on rajoute le panier en entrée. Seul le premier panier ayant
		 * cet id sera éliminé. La fonction retourne "true" si on a pu procéder au
		 * remplacement, "false" sinon.
		 */
		for (Panier panierIndividuel : this.paniers) {
			if (panierIndividuel.getId() == panier.getId()) {
				this.paniers.remove(panierIndividuel);
				return this.save(panier);
			}
		}
		return false;
	}

	// Méthode pour rendre la liste complète (convention de nommage)
	public ArrayList<Panier> findAll() {
		return this.paniers;
	}

	// Méthode pour trouver dans la liste un panier d'id connu
	public Panier findById(String id) {
		for (Panier panierIndividuel : this.paniers) {
			if (panierIndividuel.getId() == id) {
				return panierIndividuel;
			}
		}
		return null;
	}

	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "PanierService [paniers=" + this.paniers + "]";
	}

}
