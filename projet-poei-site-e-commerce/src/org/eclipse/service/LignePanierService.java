package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.dao.LignePanierDao;
import org.eclipse.model.LignePanier;

public class LignePanierService {
	private LignePanierDao lignePanierDao = new LignePanierDao();

	// Méthode pour ajouter une ligne de panier dans la liste
	public LignePanier save(LignePanier lignePanier) throws Exception {
		if (lignePanier.getIdProduit() == 0) {
			throw new Exception("Erreur : idProduit manquant !");
		}
		if (lignePanier.getIdClient() == 0) {
			throw new Exception("Erreur : idClient manquant !");
		}
		return lignePanierDao.save(lignePanier);
	}

	// Méthode pour retirer une ligne de panier de la liste
	public void remove(LignePanier lignePanier) throws Exception {
		if (lignePanierDao.findById(lignePanier.getId()) == null) {
			throw new Exception("Erreur : la ligne de panier n'appartient pas a la base de données");
		}
		lignePanierDao.remove(lignePanier);
	}

	// Méthode pour mettre a jour une ligne de panier
	public LignePanier update(LignePanier lignePanier) throws Exception {
		if (lignePanier.getIdProduit() == 0) {
			throw new Exception("Erreur : idProduit manquant !");
		}
		if (lignePanier.getIdClient() == 0) {
			throw new Exception("Erreur : idClient manquant !");
		}
		if (lignePanierDao.findById(lignePanier.getId()) == null) {
			throw new Exception("Erreur : la ligne de panier n'appartient pas a la base de données");
		}
		return lignePanierDao.update(lignePanier);
	}

	// Méthode pour rendre la liste complete des lignes de panier
	public ArrayList<LignePanier> findAll() {
		return (ArrayList<LignePanier>) lignePanierDao.findAll();
	}

	// Méthode pour trouver dans la BdD une ligne de panier d'id connu
	public LignePanier findById(int id) {
		return lignePanierDao.findById(id);
	}
	
	// Méthode pour trouver toutes les lignes de panier d'un client
	public ArrayList<LignePanier> findByClient(int idClient) {
		return lignePanierDao.findByClient(idClient);
	}
	
	// Méthode pour trouver une ligne de panier d'un client concernant un produit
	public LignePanier findByClientAndProduit(int idClient, int idProduit) {
		return lignePanierDao.findByClientAndProduit(idClient, idProduit);
	}
	
	/*
	 * Méthode pour vérifier que la quantité souhaitée d'une ligne de panier ne
	 * dépasse pas la quantité en stock du produit correspondant. Retourne la
	 * ligne de panier (corrigée, le cas échéant).
	 */
	public LignePanier checkQuantiteSouhaitee(LignePanier lignePanier) throws Exception {
		if (lignePanier.getIdProduit() == 0) {
			throw new Exception("Erreur : idProduit manquant !");
		}
		if (lignePanier.getIdClient() == 0) {
			throw new Exception("Erreur : idClient manquant !");
		}
		if (lignePanierDao.findById(lignePanier.getId()) == null) {
			throw new Exception("Erreur : la ligne de panier n'appartient pas a la base de données");
		}
		return lignePanierDao.checkQuantiteSouhaitee(lignePanier);
	}

	// Méthode pour retirer toutes les lignes de panier d'un client
	public void removeByClient(int idClient) {
		lignePanierDao.removeByClient(idClient);
	};
}
