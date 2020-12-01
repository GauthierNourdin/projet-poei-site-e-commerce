package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.dao.CommentaireDao;
import org.eclipse.model.Commentaire;

public class CommentaireService {
	private CommentaireDao commentaireDao = new CommentaireDao();
	
	// Methode pour ajouter un commentaire dans la BdD
	public Commentaire save(Commentaire commentaire) throws Exception {
		if (commentaire.getIdProduit() == 0) {
			throw new Exception("Erreur : idProduit manquant !");
		}
		if (commentaire.getIdUtilisateur() == 0) {
			throw new Exception("Erreur : idUtilisateur manquant !");
		}
		return commentaireDao.save(commentaire);
	}

	// Méthode pour retirer une commande de la BdD
	public void remove(Commentaire commentaire) throws Exception {
		if (commentaireDao.findById(commentaire.getId()) == null) {
			throw new Exception("Erreur : le commentaire n'appartient pas a la base de données");
		}
		commentaireDao.remove(commentaire);
	}

	// Methode pour mettre a jour une commande dans la BdD
	public Commentaire update(Commentaire commentaire) throws Exception {
		if (commentaire.getIdProduit() == 0) {
			throw new Exception("Erreur : idProduit manquant !");
		}
		if (commentaire.getIdUtilisateur() == 0) {
			throw new Exception("Erreur : idUtilisateur manquant !");
		}
		if (commentaireDao.findById(commentaire.getId()) == null) {
			throw new Exception("Erreur : le commentaire n'appartient pas a la base de données");
		}
		return commentaireDao.update(commentaire);
	}

	// Méthode pour rendre la liste complete des commentaires
	public ArrayList<Commentaire> findAll() {
		return (ArrayList<Commentaire>) commentaireDao.findAll();
	}

	// Methode pour trouver dans la BdD un commentaire d'id connu
	public Commentaire findById(int id) {
		return commentaireDao.findById(id);
	}
	
	// Methode pour trouver tous les commentaires relatifs à un produit
	public ArrayList<Commentaire> findByProduit(int idProduit) {
		return commentaireDao.findByProduit(idProduit);
	}
}
