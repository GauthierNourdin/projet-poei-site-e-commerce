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

	// M�thode pour ajouter un utilisateur dans la liste
	public boolean save(Utilisateur utilisateur) {
		/*
		 * On v�rifie que l'utilisateur n'appartient pas d�j� � la liste avant de le
		 * rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (this.utilisateurs.contains(utilisateur)) {
			return false;
		} else {
			return this.utilisateurs.add(utilisateur);
		}
	}

	// M�thode pour retirer un utilisateur de la liste
	public boolean remove(Utilisateur utilisateur) {
		/*
		 * On v�rifie que l'utilisateur est bien pr�sent dans la liste avant de le
		 * supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (this.utilisateurs.contains(utilisateur)) {
			return this.utilisateurs.remove(utilisateur);
		} else {
			return false;
		}
	}

	// M�thode pour mettre � jour un utilisateur
	public boolean update(Utilisateur utilisateur) {
		/*
		 * La m�thode retourne true si l'utilisateur � mettre � jour est dans la liste,
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

	// M�thode pour rendre la liste compl�te (convention de nommage)
	public ArrayList<Utilisateur> findAll() {
		return this.utilisateurs;
	}

	// M�thode pour trouver dans la liste un utilisateur d'id connu
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
	
	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "UtilisateurService [utilisateurs=" + this.utilisateurs + "]";
	}

}
