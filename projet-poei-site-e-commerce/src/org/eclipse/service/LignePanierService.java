package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.LignePanier;

public class LignePanierService {
	/*
	 * Cet attribut ne doit �tre initialis� qu'une seule fois. Le rendre
	 * statique permet de le g�n�rer au d�but de l'ex�cution.
	 */
	private static ArrayList<LignePanier> lignesPanier;

	// Constructeur priv� pour �viter de cr�er des instances.
	private LignePanierService() {
	}

	// Le getter statique et le setter statique adapt�s
	public static ArrayList<LignePanier> getLignesPaniers() {
		return lignesPanier;
	}

	public static void setLignesPaniers(ArrayList<LignePanier> argLignesPaniers) {
		lignesPanier = argLignesPaniers;
	}

	// M�thode statique pour ajouter une ligne de panier dans la liste
	public static boolean save(LignePanier lignePanier) {
		/*
		 * On v�rifie que la ligne de panier n'appartient pas d�j� � la liste avant de
		 * la rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (lignesPanier.contains(lignePanier)) {
			return false;
		} else {
			return lignesPanier.add(lignePanier);
		}
	}

	// M�thode statique pour retirer une ligne de panier de la liste
	public static boolean remove(LignePanier lignePanier) {
		/*
		 * On v�rifie que la ligne de panier est bien pr�sente dans la liste avant de la
		 * supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (lignesPanier.contains(lignePanier)) {
			return lignesPanier.remove(lignePanier);
		} else {
			return false;
		}
	}

	// M�thode statique pour mettre � jour une ligne de panier
	public static boolean update(LignePanier lignePanier) {
		/*
		 * La m�thode retourne true si la ligne de panier � mettre � jour est dans la
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

	// M�thode statique pour rendre la liste compl�te (convention de nommage)
	public static ArrayList<LignePanier> findAll() {
		return lignesPanier;
	}

	// M�thode statique pour trouver dans la liste une ligne de panier d'id connu
	public static LignePanier findById(int id) {
		for (LignePanier lignPani : lignesPanier) {
			if (lignPani.getId() == id) {
				return lignPani;
			}
		}
		return null;
	}

	// La m�thode sert uniquement au d�buggage.
	public static String affichageDebuggage() {
		return "LignePanierService [lignesPanier=" + lignesPanier + "]";
	}

}
