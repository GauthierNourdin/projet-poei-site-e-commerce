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

	// Méthode pour retirer un vendeur de la liste
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

	// Méthode pour mettre à jour un vendeur
	public boolean update(Vendeur vendeur) {
		/*
		 * La méthode retourne true si le client à mettre à jour est dans la liste,
		 * false sinon.
		 */
		for (Vendeur vend: this.vendeurs) {
			if (vend.getId() == vend.getId()) {
				vend = vendeur;
				return true;
			}
		}
		return false;
	}
	
	// Méthode pour rendre la liste complète (convention de nommage)
	public ArrayList<Vendeur> findAll() {
		return this.vendeurs;
	}

	// Méthode pour trouver dans la liste un vendeur d'id connu
	public Vendeur findById(int id) {
		for (Vendeur vend: this.vendeurs) {
			if (vend.getId() == id) {
				return vend;
			}
		}
		return null;
	}
	
	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "VendeurService [vendeurs=" + this.vendeurs + "]";
	}

}
