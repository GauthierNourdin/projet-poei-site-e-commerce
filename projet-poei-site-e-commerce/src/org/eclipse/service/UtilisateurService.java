package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.Utilisateur;

public class UtilisateurService {
	/*
	 * Cet attribut ne doit �tre initialis� qu'une seule fois. Le rendre
	 * statique permet de le g�n�rer au d�but de l'ex�cution.
	 */
	private static ArrayList<Utilisateur> utilisateurs;

	// Constructeur priv� pour �viter de cr�er des instances.
	private UtilisateurService() {
	}

	// Le getter statique et le setter statique adapt�s
	public static ArrayList<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public static void setUtilisateurs(ArrayList<Utilisateur> argUtilisateurs) {
		utilisateurs = argUtilisateurs;
	}

	// M�thode statique pour ajouter un utilisateur dans la liste
	public static boolean save(Utilisateur utilisateur) {
		/*
		 * On v�rifie que l'utilisateur n'appartient pas d�j� � la liste avant de le
		 * rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (utilisateurs.contains(utilisateur)) {
			return false;
		} else {
			return utilisateurs.add(utilisateur);
		}
	}

	// M�thode statique pour retirer un utilisateur de la liste
	public static boolean remove(Utilisateur utilisateur) {
		/*
		 * On v�rifie que l'utilisateur est bien pr�sent dans la liste avant de le
		 * supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (utilisateurs.contains(utilisateur)) {
			return utilisateurs.remove(utilisateur);
		} else {
			return false;
		}
	}

	// M�thode statique pour mettre � jour un utilisateur
	public static boolean update(Utilisateur utilisateur) {
		/*
		 * La m�thode retourne true si l'utilisateur � mettre � jour est dans la liste,
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

	// M�thode statique pour rendre la liste compl�te (convention de nommage)
	public static ArrayList<Utilisateur> findAll() {
		return utilisateurs;
	}

	// M�thode statique pour trouver dans la liste un utilisateur d'id connu
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
	
	// La m�thode sert uniquement au d�buggage.
	public static String affichageDebuggage() {
		return "UtilisateurService [utilisateurs=" + utilisateurs + "]";
	}

}
