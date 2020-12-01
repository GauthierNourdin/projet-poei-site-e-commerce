package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.dao.VendeurDao;
import org.eclipse.model.Vendeur;

public class VendeurService {
	private VendeurDao vendeurDao = new VendeurDao();

	// Methode pour ajouter un vendeur dans la BdD
	public Vendeur save(Vendeur vendeur) throws Exception {
		if (vendeurDao.findByIdentifiantConnexion(vendeur.getIdentifiantConnexion()) != null) {
			throw new Exception ("Erreur : l'identifiant de connexion est déjà utilisé !");
		}
		return vendeurDao.save(vendeur);
	}

	// Methode pour retirer un vendeur de la BdD
	public void remove(Vendeur vendeur) throws Exception {
		if (vendeurDao.findById(vendeur.getIdUtilisateur()) == null) {
			throw new Exception("Erreur : le vendeur n'appartient pas à la base de données !");
		}
		vendeurDao.remove(vendeur);
	}

	// Methode pour mettre a jour un vendeur dans la BdD
	public Vendeur update(Vendeur vendeur) throws Exception {
		if (vendeurDao.findById(vendeur.getIdUtilisateur()) == null) {
			throw new Exception("Erreur : le vendeur n'appartient pas à la base de données !");
		}
		return vendeurDao.update(vendeur);
	}
	
	// Methode statique pour rendre la liste complete des vendeurs
	public ArrayList<Vendeur> findAll() {
		return (ArrayList<Vendeur>) vendeurDao.findAll();
	}

	// Methode pour trouver dans la liste un vendeur d'id connu
	public Vendeur findById(int id) {
		return vendeurDao.findById(id);
	}

	/*
	 * Methode pour autoriser la connection d'un vendeur (en retournant son objet
	 * associé)
	 */
	public Vendeur connectionVendeur(String identifiantConnexion, String motDePasse) {
		return vendeurDao.findByIdentifiantConnexionAndMotDePasse(identifiantConnexion, motDePasse);
	}

}
