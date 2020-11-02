package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.LigneCommande;

public class LigneCommandeService {
	/*
	 * Cet attribut ne doit �tre initialis� qu'une seule fois. Le rendre
	 * statique permet de le g�n�rer au d�but de l'ex�cution.
	 */
	private static ArrayList<LigneCommande> lignesCommande;

	// Constructeur priv� pour �viter de cr�er des instances.
	private LigneCommandeService() {
	}

	// Le getter statique et le setter statique adapt�s
	public static ArrayList<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public static void setLignesCommande(ArrayList<LigneCommande> argLignesCommande) {
		lignesCommande = argLignesCommande;
	}

	// M�thode statique pour ajouter une ligne de commande dans la liste
	public static boolean save(LigneCommande ligneCommande) {
		/*
		 * On v�rifie que la ligne de commande n'appartient pas d�j� � la liste avant de
		 * la rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (lignesCommande.contains(ligneCommande)) {
			return false;
		} else {
			return lignesCommande.add(ligneCommande);
		}
	}

	// M�thode statique pour retirer une ligne de commande de la liste
	public static boolean remove(LigneCommande ligneCommande) {
		/*
		 * On v�rifie que la ligne de commande est bien pr�sente dans la liste avant de
		 * la supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (lignesCommande.contains(ligneCommande)) {
			return lignesCommande.remove(ligneCommande);
		} else {
			return false;
		}
	}

	// M�thode statique pour mettre � jour une ligne de commande
	public static boolean update(LigneCommande ligneCommande) {
		/*
		 * La m�thode retourne true si la ligne de commande � mettre � jour est dans la
		 * liste, false sinon.
		 */
		for (LigneCommande lignComm : lignesCommande) {
			if (lignComm.getId() == ligneCommande.getId()) {
				lignComm = ligneCommande;
				return true;
			}
		}
		return false;
	}

	// M�thode statique pour rendre la liste compl�te (convention de nommage)
	public static ArrayList<LigneCommande> findAll() {
		return lignesCommande;
	}

	// M�thode statique pour trouver dans la liste une ligne de commande d'id connu
	public static LigneCommande findById(int id) {
		for (LigneCommande lignComm : lignesCommande) {
			if (lignComm.getId() == id) {
				return lignComm;
			}
		}
		return null;
	}

	// La m�thode sert uniquement au d�buggage.
	public static String affichageDebuggage() {
		return "LigneCommandeService [lignesCommande=" + lignesCommande + "]";
	}

}
