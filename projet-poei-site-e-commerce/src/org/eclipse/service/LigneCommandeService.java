package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.LigneCommande;

public class LigneCommandeService {
	/*
	 * Cet attribut ne doit être initialisé qu'une seule fois. Le rendre
	 * statique permet de le générer au début de l'exécution.
	 */
	private static ArrayList<LigneCommande> lignesCommande;

	// Constructeur privé pour éviter de créer des instances.
	private LigneCommandeService() {
	}

	// Le getter statique et le setter statique adaptés
	public static ArrayList<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public static void setLignesCommande(ArrayList<LigneCommande> argLignesCommande) {
		lignesCommande = argLignesCommande;
	}

	// Méthode statique pour ajouter une ligne de commande dans la liste
	public static boolean save(LigneCommande ligneCommande) {
		/*
		 * On vérifie que la ligne de commande n'appartient pas déjà à la liste avant de
		 * la rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (lignesCommande.contains(ligneCommande)) {
			return false;
		} else {
			return lignesCommande.add(ligneCommande);
		}
	}

	// Méthode statique pour retirer une ligne de commande de la liste
	public static boolean remove(LigneCommande ligneCommande) {
		/*
		 * On vérifie que la ligne de commande est bien présente dans la liste avant de
		 * la supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (lignesCommande.contains(ligneCommande)) {
			return lignesCommande.remove(ligneCommande);
		} else {
			return false;
		}
	}

	// Méthode statique pour mettre à jour une ligne de commande
	public static boolean update(LigneCommande ligneCommande) {
		/*
		 * La méthode retourne true si la ligne de commande à mettre à jour est dans la
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

	// Méthode statique pour rendre la liste complète (convention de nommage)
	public static ArrayList<LigneCommande> findAll() {
		return lignesCommande;
	}

	// Méthode statique pour trouver dans la liste une ligne de commande d'id connu
	public static LigneCommande findById(int id) {
		for (LigneCommande lignComm : lignesCommande) {
			if (lignComm.getId() == id) {
				return lignComm;
			}
		}
		return null;
	}

	// La méthode sert uniquement au débuggage.
	public static String affichageDebuggage() {
		return "LigneCommandeService [lignesCommande=" + lignesCommande + "]";
	}

}
