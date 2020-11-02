package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.Panier;

public class PanierService {
	/*
	 * Cet attribut ne doit �tre initialis� qu'une seule fois. Le rendre
	 * statique permet de le g�n�rer au d�but de l'ex�cution.
	 */
	private static ArrayList<Panier> paniers;

	// Constructeur priv� pour �viter de cr�er des instances.
	private PanierService() {
	}

	// Le getter statique et le setter statique adapt�s
	public static ArrayList<Panier> getPaniers() {
		return paniers;
	}

	public static void setPaniers(ArrayList<Panier> argPaniers) {
		paniers = argPaniers;
	}

	// M�thode statique pour ajouter un panier dans la liste
	public static boolean save(Panier panier) {
		/*
		 * On v�rifie que le panier n'appartient pas d�j� � la liste avant de le
		 * rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (paniers.contains(panier)) {
			return false;
		} else {
			return paniers.add(panier);
		}
	}

	// M�thode statique pour retirer un panier de la liste
	public static boolean remove(Panier panier) {
		/*
		 * On v�rifie que le panier est bien pr�sent dans la liste avant de le
		 * supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (paniers.contains(panier)) {
			return paniers.remove(panier);
		} else {
			return false;
		}
	}

	// M�thode statique pour mettre � jour un panier
	public static boolean update(Panier panier) {
		/*
		 * La m�thode retourne true si le panier � mettre � jour est dans la liste,
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

	// M�thode statique pour rendre la liste compl�te (convention de nommage)
	public static ArrayList<Panier> findAll() {
		return paniers;
	}

	// M�thode statique pour trouver dans la liste un panier d'id connu
	public static Panier findById(int idPanier) {
		for (Panier pani : paniers) {
			if (pani.getId() == idPanier) {
				return pani;
			}
		}
		return null;
	}

	// La m�thode sert uniquement au d�buggage.
	public static String affichageDebuggage() {
		return "PanierService [paniers=" + paniers + "]";
	}

}
