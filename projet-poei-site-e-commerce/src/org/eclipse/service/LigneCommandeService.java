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

	// Méthode pour ajouter une ligne de commande dans la liste
	public boolean save(LigneCommande ligneCommande) {
		/*
		 * On vérifie que la ligne de commande n'appartient pas déjà à la liste avant de
		 * la rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (this.lignesCommande.contains(ligneCommande)) {
			return false;
		} else {
			return this.lignesCommande.add(ligneCommande);
		}
	}

	// Méthode pour retirer une ligne de commande de la liste
	public boolean remove(LigneCommande ligneCommande) {
		/*
		 * On vérifie que la ligne de commande est bien présente dans la liste avant de
		 * la supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (this.lignesCommande.contains(ligneCommande)) {
			return this.lignesCommande.remove(ligneCommande);
		} else {
			return false;
		}
	}

	// Méthode pour mettre à jour une ligne de commande
	public boolean update(LigneCommande ligneCommande) {
		/*
		 * La méthode retourne true si la ligne de commande à mettre à jour est dans la
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

	// Méthode pour rendre la liste complète (convention de nommage)
	public ArrayList<LigneCommande> findAll() {
		return this.lignesCommande;
	}

	// Méthode pour trouver dans la liste une ligne de commande d'id connu
	public LigneCommande findById(String id) {
		for (LigneCommande lignComm : this.lignesCommande) {
			if (lignComm.getId() == id) {
				return lignComm;
			}
		}
		return null;
	}

	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "LigneCommandeService [lignesCommande=" + lignesCommande + "]";
	}

}
