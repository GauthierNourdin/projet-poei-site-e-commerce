package org.eclipse.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.model.Commentaire;

public class CommentaireService {
	/*
	 * Cet attribut ne doit etre initialise qu'une seule fois. Le rendre
	 * statique permet de le generer au debut de l'execution.
	 */
	private static ArrayList<Commentaire> commentaires = new ArrayList<Commentaire>(Arrays.asList(
			new Commentaire(1, 2, -1, "La figurine est trop petite a mon gout.")
			));

	// Constructeur prive pour eviter de creer des instances.
	private CommentaireService() {
	}

	// Le getter statique et le setter statique adaptes, ne servent qu'aux tests et au débuggage.
	public static ArrayList<Commentaire> getCommentaires() {
		return commentaires;
	}

	public static void setCommentaires(ArrayList<Commentaire> argCommentaires) {
		commentaires = argCommentaires;
	}

	// Methode statique pour ajouter un commentaire dans la liste
	public static void save(Commentaire commentaire) throws Exception {
		if (commentaires.contains(commentaire)) {
			throw new Exception("Le commentaire appartient deja a la liste");
		} else {
			commentaires.add(commentaire);
		}
	}

	// Méthode statique pour retirer une commande de la liste
	public static void remove(Commentaire commentaire) throws Exception {
		if (commentaires.contains(commentaire)) {
			commentaires.remove(commentaire);
		} else {
			throw new Exception("Le commentaire n'appartient pas a la liste");
		}
	}

	// Methode statique pour mettre a jour une commande
	public static void update(Commentaire commentaire) throws Exception {
		for (Commentaire comm : commentaires) {
			if (comm.getId() == commentaire.getId()) {
				comm = commentaire;
				return;
			}
		}
		throw new Exception("Le commentaire n'appartient pas a la liste");
	}

	// Méthode statique pour rendre la liste complete (convention de nommage)
	public static ArrayList<Commentaire> findAll() {
		return commentaires;
	}

	// Methode statique pour trouver dans la liste un commentaire d'id connu
	public static Commentaire findById(int id) {
		for (Commentaire comm : commentaires) {
			if (comm.getId() == id) {
				return comm;
			}
		}
		return null;
	}
	
	// Methode statique pour tous les commentaires relatifs à un produit
	public static ArrayList<Commentaire> findByProduit(int idProduit) {
		ArrayList<Commentaire> listeComm = new ArrayList<Commentaire>();
		for (Commentaire comm : commentaires) {
			if (comm.getIdProduit() == idProduit) {
				listeComm.add(comm);
			}
		}
		return listeComm;
	}
	

	// La methode sert uniquement au debuggage.
	public static String affichageDebuggage() {
		return "ClientService [commentaires=" + commentaires + "]";
	}
}
