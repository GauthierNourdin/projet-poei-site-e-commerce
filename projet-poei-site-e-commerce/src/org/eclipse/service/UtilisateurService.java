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

	// Méthode pour mettre à jour un utilisateur (même ID !)
	public boolean update(Utilisateur utilisateur) {
		/*
		 * On compare l'id de l'utilisateur dans la liste avec l'id de l'utilisateur que l'on a
		 * envoyé en entrée. Si on obtient une correspondance, on enlève l'utilisateur avec
		 * cet id de la liste et on rajoute l'utilisateur en entrée. Seul le premier
		 * produit ayant cet id sera éliminé. La fonction retourne "true" si on a pu
		 * procéder au remplacement, "false" sinon.
		 */
		for (Utilisateur utilisateurIndividuel : this.utilisateurs) {
			if (utilisateurIndividuel.getId() == utilisateur.getId()) {
				this.utilisateurs.remove(utilisateurIndividuel);
				return this.save(utilisateur);
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
		for (Utilisateur utilisateurIndividuel : this.utilisateurs) {
			if (utilisateurIndividuel.getId() == id) {
				return utilisateurIndividuel;
			}
		}
		return null;
	}

	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "UtilisateurService [utilisateurs=" + this.utilisateurs + "]";
	}

}
