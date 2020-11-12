package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.Utilisateur;

public class UtilisateurService {
	/*
	 * Cet attribut ne doit etre initialise qu'une seule fois. Le rendre
	 * statique permet de le generer au debut de l'execution.
	 */
	private static ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

	// Constructeur prive pour eviter de creer des instances.
	private UtilisateurService() {
	}

	// Le getter statique et le setter statique adaptes, ne servent qu'aux tests et au débuggage.
	public static ArrayList<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public static void setUtilisateurs(ArrayList<Utilisateur> argUtilisateurs) {
		utilisateurs = argUtilisateurs;
	}

	// Methode statique pour ajouter un utilisateur dans la liste
	public static void save(Utilisateur utilisateur) throws Exception {
		if (utilisateurs.contains(utilisateur)) {
			throw new Exception("L'utilisateur appartient deja a la liste");
		} else {
			utilisateurs.add(utilisateur);
		}
	}

	// Methode statique pour retirer un utilisateur de la liste
	public static void remove(Utilisateur utilisateur) throws Exception {
		if (utilisateurs.contains(utilisateur)) {
			utilisateurs.remove(utilisateur);
		} else {
			throw new Exception("L'utilisateur n'appartient pas a la liste");
		}
	}

	// Methode statique pour mettre a jour un utilisateur
	public static void update(Utilisateur utilisateur) throws Exception {
		for (Utilisateur util: utilisateurs) {
			if (util.getId() == util.getId()) {
				util = utilisateur;
				return;
			}
		}
		throw new Exception("L'utilisateur n'appartient pas a la liste");
	}

	// Methode statique pour rendre la liste complete (convention de nommage)
	public static ArrayList<Utilisateur> findAll() {
		return utilisateurs;
	}

	// Methode statique pour trouver dans la liste un utilisateur d'id connu
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
	
	// La methode sert uniquement au debuggage.
	public static String affichageDebuggage() {
		return "UtilisateurService [utilisateurs=" + utilisateurs + "]";
	}

}
