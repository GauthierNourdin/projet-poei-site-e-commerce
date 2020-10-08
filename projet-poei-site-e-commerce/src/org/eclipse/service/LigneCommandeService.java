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

	// Méthode pour mettre à jour une ligne de commande (même ID !)
	public boolean update(LigneCommande ligneCommande) {
		/*
		 * On compare l'id de la ligne de commande dans la liste avec l'id de la ligne
		 * de commande que l'on a envoyé en entrée. Si on obtient une correspondance, on
		 * enlève la ligne de commande avec cet id de la liste et on rajoute la ligne de
		 * commande en entrée. Seul la première ligne de panier ayant cet id sera
		 * éliminé. La fonction retourne "true" si on a pu procéder au remplacement,
		 * "false" sinon.
		 */
		for (LigneCommande ligneCommandeIndividuelle : this.lignesCommande) {
			if (ligneCommandeIndividuelle.getId() == ligneCommande.getId()) {
				this.lignesCommande.remove(ligneCommandeIndividuelle);
				return this.save(ligneCommande);
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
		for (LigneCommande ligneCommandeIndividuelle : this.lignesCommande) {
			if (ligneCommandeIndividuelle.getId() == id) {
				return ligneCommandeIndividuelle;
			}
		}
		return null;
	}

	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "LigneCommandeService [lignesCommande=" + lignesCommande + "]";
	}

}
