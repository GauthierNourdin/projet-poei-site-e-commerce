package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.dao.CategorieDao;
import org.eclipse.model.Categorie;

public class CategorieService {
	private CategorieDao categorieDao = new CategorieDao();

	// Methode pour ajouter une categorie dans la BdD
	public Categorie save(Categorie categorie) throws Exception {
		String nom = categorie.getNom();
		nom = nom.toLowerCase();
		categorie.setNom(nom);
		if (categorieDao.findByNom(categorie.getNom()) != null) {
			throw new Exception("Erreur : cette categorie est déjà référencée dans la base de données !");
		}
		return categorieDao.save(categorie);
	}

	// Méthode pour retirer une commande de la BdD
	public void remove(Categorie categorie) throws Exception {
		if (categorieDao.findById(categorie.getId()) == null) {
			throw new Exception("Erreur : la categorie n'appartient pas à la base de données !");
		}
		categorieDao.remove(categorie);
	}

	// Methode pour mettre a jour une commande dans la BdD
	public Categorie update(Categorie categorie) throws Exception {
		String nom = categorie.getNom();
		nom = nom.toLowerCase();
		categorie.setNom(nom);
		if (categorieDao.findById(categorie.getId()) == null) {
			throw new Exception("Erreur : la categorie n'appartient pas à la base de données !");
		}
		return categorieDao.update(categorie);
	}

	// Méthode pour rendre la liste complete des catégories
	public ArrayList<Categorie> findAll() {
		return (ArrayList<Categorie>) categorieDao.findAll();
	}

	// Methode pour trouver dans la BdD une categorie d'id connu
	public Categorie findById(int id) {
		return categorieDao.findById(id);
	}
	
}
