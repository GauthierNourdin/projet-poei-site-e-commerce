package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.Vendeur;

public class VendeurService {

	// Attributs
	private ArrayList<Vendeur> vendeurs;

	// Le constructeur
	public VendeurService(ArrayList<Vendeur> vendeurs) {
		this.vendeurs = vendeurs;
	}

	// Les getters et les setters classiques
	public ArrayList<Vendeur> getVendeurs() {
		return this.vendeurs;
	}

	public void setVendeurs(ArrayList<Vendeur> vendeurs) {
		this.vendeurs = vendeurs;
	}

	// Méthode pour ajouter un vendeur dans la liste
	public boolean save(Vendeur vendeur) {
		/*
		 * On vérifie que le vendeur n'appartient pas déjà à la liste avant de le
		 * rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (this.vendeurs.contains(vendeur)) {
			return false;
		} else {
			return this.vendeurs.add(vendeur);
		}
	}

	// Méthode pour retirer un produit de la liste
	public boolean remove(Vendeur vendeur) {
		/*
		 * On vérifie que le vendeur est bien présent dans la liste avant de le
		 * supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (this.vendeurs.contains(vendeur)) {
			return this.vendeurs.remove(vendeur);
		} else {
			return false;
		}
	}

	// Méthode pour mettre à jour un produit (même ID !)
	public boolean update(Vendeur vendeur) {
		/*
		 * On compare l'id du vendeur dans la liste avec l'id du vendeur que
		 * l'on a envoyé en entrée. Si on obtient une correspondance, on enlève
		 * le vendeur avec cet id de la liste et on rajoute le vendeur en entrée.
		 * Seul le premier vendeur ayant cet id sera éliminé. La fonction retourne
		 * "true" si on a pu procéder au remplacement, "false" sinon.
		 */
		for (Vendeur vendeurIndividuel : this.vendeurs) {
			if (vendeurIndividuel.getId() == vendeur.getId()) {
				this.vendeurs.remove(vendeurIndividuel);
				return this.save(vendeur);
			}
		}
		return false;
	}

	// Méthode pour rendre la liste complète (convention de nommage)
	public ArrayList<Vendeur> findAll() {
		return this.vendeurs;
	}

	// Méthode pour trouver dans la liste un vendeur d'id connu
	public Vendeur findById(String id) {
		for (Vendeur vendeurIndividuel : this.vendeurs) {
			if (vendeurIndividuel.getId() == id) {
				return vendeurIndividuel;
			}
		}
		return null;
	}

	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "VendeurService [vendeurs=" + this.vendeurs + "]";
	}

}
