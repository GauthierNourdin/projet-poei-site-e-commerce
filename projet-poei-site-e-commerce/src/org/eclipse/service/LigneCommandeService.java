package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.dao.LigneCommandeDao;
import org.eclipse.model.LigneCommande;

public class LigneCommandeService {
	private LigneCommandeDao ligneCommandeDao = new LigneCommandeDao();
	
	// Methode pour ajouter une ligne de commande dans la BdD
	public LigneCommande save(LigneCommande ligneCommande) throws Exception {
		if (ligneCommande.getIdProduit() == 0) {
			throw new Exception("Erreur : idProduit manquant !");
		}
		if (ligneCommande.getIdCommande() == 0) {
			throw new Exception("Erreur : idCommande manquant !");
		}
		return ligneCommandeDao.save(ligneCommande);
	}

	// Methode pour retirer une ligne de commande de la BdD
	public void remove(LigneCommande ligneCommande) throws Exception {
		if (ligneCommandeDao.findById(ligneCommande.getId()) == null) {
			throw new Exception("Erreur : la ligne de commande n'appartient pas a la base de données");
		}
		ligneCommandeDao.remove(ligneCommande);
	}

	// Methode pour mettre a jour une ligne de commande dans la BdD
	public LigneCommande update(LigneCommande ligneCommande) throws Exception {
		if (ligneCommande.getIdProduit() == 0) {
			throw new Exception("Erreur : idProduit manquant !");
		}
		if (ligneCommande.getIdCommande() == 0) {
			throw new Exception("Erreur : idCommande manquant !");
		}
		if (ligneCommandeDao.findById(ligneCommande.getId()) == null) {
			throw new Exception("Erreur : la ligne de commande n'appartient pas a la base de données");
		}
		return ligneCommandeDao.update(ligneCommande);
	}

	// Methode pour rendre la liste complete des lignes de commande
	public ArrayList<LigneCommande> findAll() {
		return (ArrayList<LigneCommande>) ligneCommandeDao.findAll();
	}

	// Methode pour trouver dans la BdD une ligne de commande d'id connu
	public LigneCommande findById(int id) {
		return ligneCommandeDao.findById(id);
	}

	// Methode pour retourner la liste des lignes de commandes associes à une commande
	public ArrayList<LigneCommande> findByCommande(int idCommande) {
		return ligneCommandeDao.findByCommande(idCommande);
	}
	
	// Methode pour trouver les lignes de commandes concernant un produit
	public ArrayList<LigneCommande> findByProduit(int idProduit) {
		return ligneCommandeDao.findByProduit(idProduit);
	}
}
