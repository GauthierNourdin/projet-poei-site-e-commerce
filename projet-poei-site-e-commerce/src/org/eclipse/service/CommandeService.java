package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.Commande;

public class CommandeService {
	/*
	 * Cet attribut ne doit être initialisé qu'une seule fois. Le rendre
	 * statique permet de le générer au début de l'exécution.
	 */
	private static ArrayList<Commande> commandes;

	// Constructeur privé pour éviter de créer des instances.
	private CommandeService() {
	}

	// Le getter statique et le setter statique adaptés
	public static ArrayList<Commande> getCommandes() {
		return commandes;
	}

	public static void setCommandes(ArrayList<Commande> argCommandes) {
		commandes = argCommandes;
	}

	// Méthode statique pour ajouter une commande dans la liste
	public static boolean save(Commande commande) {
		/*
		 * On vérifie que la commande n'appartient pas déjà à la liste avant de la
		 * rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (commandes.contains(commande)) {
			return false;
		} else {
			return commandes.add(commande);
		}
	}

	// Méthode statique pour retirer une commande de la liste
	public static boolean remove(Commande commande) {
		/*
		 * On vérifie que la commande est bien présente dans la liste avant de la
		 * supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (commandes.contains(commande)) {
			return commandes.remove(commande);
		} else {
			return false;
		}
	}

	// Méthode statique pour mettre à jour une commande
	public static boolean update(Commande commande) {
		/*
		 * La méthode retourne true si la commande à mettre à jour est dans la liste,
		 * false sinon.
		 */
		for (Commande comm : commandes) {
			if (comm.getId() == commande.getId()) {
				comm = commande;
				return true;
			}
		}
		return false;
	}

	// Méthode statique pour rendre la liste complète (convention de nommage)
	public static ArrayList<Commande> findAll() {
		return commandes;
	}

	// Méthode statique pour trouver dans la liste une commande d'id connu
	public static Commande findById(int id) {
		for (Commande comm : commandes) {
			if (comm.getId() == id) {
				return comm;
			}
		}
		return null;
	}

	// La méthode sert uniquement au débuggage.
	public static String affichageDebuggage() {
		return "ClientService [commandes=" + commandes + "]";
	}

}
