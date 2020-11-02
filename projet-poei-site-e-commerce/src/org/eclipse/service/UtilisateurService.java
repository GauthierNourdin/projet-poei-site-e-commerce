package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.Utilisateur;

public class UtilisateurService {
	/*
	 * Cet attribut ne doit être initialisé qu'une seule fois. Le rendre
	 * statique permet de le générer au début de l'exécution.
	 */
	private static ArrayList<Utilisateur> utilisateurs;

	// Constructeur privé pour éviter de créer des instances.
	private UtilisateurService() {
	}

	// Le getter statique et le setter statique adaptés
	public static ArrayList<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public static void setUtilisateurs(ArrayList<Utilisateur> argUtilisateurs) {
		utilisateurs = argUtilisateurs;
	}

	// Méthode statique pour ajouter un utilisateur dans la liste
	public static boolean save(Utilisateur utilisateur) {
		/*
		 * On vérifie que l'utilisateur n'appartient pas déjà à la liste avant de le
		 * rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (utilisateurs.contains(utilisateur)) {
			return false;
		} else {
			return utilisateurs.add(utilisateur);
		}
	}

	// Méthode statique pour retirer un utilisateur de la liste
	public static boolean remove(Utilisateur utilisateur) {
		/*
		 * On vérifie que l'utilisateur est bien présent dans la liste avant de le
		 * supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (utilisateurs.contains(utilisateur)) {
			return utilisateurs.remove(utilisateur);
		} else {
			return false;
		}
	}

	// Méthode statique pour mettre à jour un utilisateur
	public static boolean update(Utilisateur utilisateur) {
		/*
		 * La méthode retourne true si l'utilisateur à mettre à jour est dans la liste,
		 * false sinon.
		 */
		for (Utilisateur util: utilisateurs) {
			if (util.getId() == util.getId()) {
				util = utilisateur;
				return true;
			}
		}
		return false;
	}

	// Méthode statique pour rendre la liste complète (convention de nommage)
	public static ArrayList<Utilisateur> findAll() {
		return utilisateurs;
	}

	// Méthode statique pour trouver dans la liste un utilisateur d'id connu
	public static Utilisateur findById(int id) {
		for (Utilisateur util: utilisateurs) {
			if (util.getId() == id) {
				return util;
			}
		}
		return null;
	}

	public static Utilisateur findByLoginAndPassword(String login, String password) {
		for(Utilisateur util : utilisateurs)
			if((util.getNom() == login) && (util.getMotDePasse() == password)) {
				return util;
			}
		return null;
	}
	
	// La méthode sert uniquement au débuggage.
	public static String affichageDebuggage() {
		return "UtilisateurService [utilisateurs=" + utilisateurs + "]";
	}

}
