package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.Utilisateur;

public class UtilisateurService {

	// Attributs
	private ArrayList<Utilisateur> utilisateurs;

	// Le constructeur
	public UtilisateurService(ArrayList<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	// Les getters et les setters classiques
	public ArrayList<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(ArrayList<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	// Méthode pour ajouter un utilisateur dans la liste
	public boolean save(Utilisateur utilisateur) {
		/*
		 * On vérifie que l'utilisateur n'appartient pas déjà à la liste avant de le
		 * rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (this.utilisateurs.contains(utilisateur)) {
			return false;
		} else {
			return this.utilisateurs.add(utilisateur);
		}
	}

	// Méthode pour retirer un utilisateur de la liste
	public boolean remove(Utilisateur utilisateur) {
		/*
		 * On vérifie que l'utilisateur est bien présent dans la liste avant de le
		 * supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (this.utilisateurs.contains(utilisateur)) {
			return this.utilisateurs.remove(utilisateur);
		} else {
			return false;
		}
	}

	// Méthode pour mettre à jour un utilisateur
	public boolean update(Utilisateur utilisateur) {
		/*
		 * La méthode retourne true si l'utilisateur à mettre à jour est dans la liste,
		 * false sinon.
		 */
		for (Utilisateur util: this.utilisateurs) {
			if (util.getId() == util.getId()) {
				util = utilisateur;
				return true;
			}
		}
		return false;
	}

	// Méthode pour rendre la liste complète (convention de nommage)
	public ArrayList<Utilisateur> findAll() {
		return this.utilisateurs;
	}

	// Méthode pour trouver dans la liste un utilisateur d'id connu
	public Utilisateur findById(String id) {
		for (Utilisateur util: this.utilisateurs) {
			if (util.getId() == id) {
				return util;
			}
		}
		return null;
	}

	public Utilisateur findByLoginAndPassword(String login, String password) {
		for(Utilisateur util : utilisateurs)
			if((util.getNom() == login) && (util.getMotDePasse() == password)) {
				return util;
			}
		return null;
	}
	
	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "UtilisateurService [utilisateurs=" + this.utilisateurs + "]";
	}

}
