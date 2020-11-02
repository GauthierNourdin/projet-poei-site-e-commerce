package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.Panier;

public class PanierService {
	/*
	 * Cet attribut ne doit être initialisé qu'une seule fois. Le rendre
	 * statique permet de le générer au début de l'exécution.
	 */
	private static ArrayList<Panier> paniers;

	// Constructeur privé pour éviter de créer des instances.
	private PanierService() {
	}

	// Le getter statique et le setter statique adaptés
	public static ArrayList<Panier> getPaniers() {
		return paniers;
	}

	public static void setPaniers(ArrayList<Panier> argPaniers) {
		paniers = argPaniers;
	}

	// Méthode statique pour ajouter un panier dans la liste
	public static boolean save(Panier panier) {
		/*
		 * On vérifie que le panier n'appartient pas déjà à la liste avant de le
		 * rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (paniers.contains(panier)) {
			return false;
		} else {
			return paniers.add(panier);
		}
	}

	// Méthode statique pour retirer un panier de la liste
	public static boolean remove(Panier panier) {
		/*
		 * On vérifie que le panier est bien présent dans la liste avant de le
		 * supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (paniers.contains(panier)) {
			return paniers.remove(panier);
		} else {
			return false;
		}
	}

	// Méthode statique pour mettre à jour un panier
	public static boolean update(Panier panier) {
		/*
		 * La méthode retourne true si le panier à mettre à jour est dans la liste,
		 * false sinon.
		 */
		for (Panier pani : paniers) {
			if (pani.getId() == panier.getId()) {
				pani = panier;
				return true;
			}
		}
		return false;
	}

	// Méthode statique pour rendre la liste complète (convention de nommage)
	public static ArrayList<Panier> findAll() {
		return paniers;
	}

	// Méthode statique pour trouver dans la liste un panier d'id connu
	public static Panier findById(int idPanier) {
		for (Panier pani : paniers) {
			if (pani.getId() == idPanier) {
				return pani;
			}
		}
		return null;
	}

	// La méthode sert uniquement au débuggage.
	public static String affichageDebuggage() {
		return "PanierService [paniers=" + paniers + "]";
	}

}
