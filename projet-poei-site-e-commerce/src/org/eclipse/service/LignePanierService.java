package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.LignePanier;

public class LignePanierService {
	/*
	 * Cet attribut ne doit être initialisé qu'une seule fois. Le rendre
	 * statique permet de le générer au début de l'exécution.
	 */
	private static ArrayList<LignePanier> lignesPanier;

	// Constructeur privé pour éviter de créer des instances.
	private LignePanierService() {
	}

	// Le getter statique et le setter statique adaptés
	public static ArrayList<LignePanier> getLignesPaniers() {
		return lignesPanier;
	}

	public static void setLignesPaniers(ArrayList<LignePanier> argLignesPaniers) {
		lignesPanier = argLignesPaniers;
	}

	// Méthode statique pour ajouter une ligne de panier dans la liste
	public static boolean save(LignePanier lignePanier) {
		/*
		 * On vérifie que la ligne de panier n'appartient pas déjà à la liste avant de
		 * la rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (lignesPanier.contains(lignePanier)) {
			return false;
		} else {
			return lignesPanier.add(lignePanier);
		}
	}

	// Méthode statique pour retirer une ligne de panier de la liste
	public static boolean remove(LignePanier lignePanier) {
		/*
		 * On vérifie que la ligne de panier est bien présente dans la liste avant de la
		 * supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (lignesPanier.contains(lignePanier)) {
			return lignesPanier.remove(lignePanier);
		} else {
			return false;
		}
	}

	// Méthode statique pour mettre à jour une ligne de panier
	public static boolean update(LignePanier lignePanier) {
		/*
		 * La méthode retourne true si la ligne de panier à mettre à jour est dans la
		 * liste, false sinon.
		 */
		for (LignePanier lignPani : lignesPanier) {
			if (lignPani.getId() == lignePanier.getId()) {
				lignPani = lignePanier;
				return true;
			}
		}
		return false;
	}

	// Méthode statique pour rendre la liste complète (convention de nommage)
	public static ArrayList<LignePanier> findAll() {
		return lignesPanier;
	}

	// Méthode statique pour trouver dans la liste une ligne de panier d'id connu
	public static LignePanier findById(int id) {
		for (LignePanier lignPani : lignesPanier) {
			if (lignPani.getId() == id) {
				return lignPani;
			}
		}
		return null;
	}

	// La méthode sert uniquement au débuggage.
	public static String affichageDebuggage() {
		return "LignePanierService [lignesPanier=" + lignesPanier + "]";
	}

}
