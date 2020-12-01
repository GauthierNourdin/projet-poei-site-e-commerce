package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.dao.AdresseDao;
import org.eclipse.model.Adresse;

public class AdresseService {
	private AdresseDao adresseDao = new AdresseDao();

	// Methode pour ajouter une adresse dans la BdD
	public Adresse save(Adresse adresse) throws Exception {
		if (adresse.getIdUtilisateur() == 0) {
			throw new Exception("Erreur : idUtilisateur manquant !");
		}
		return adresseDao.save(adresse);
	}

	// Méthode pour retirer une adresse de la BdD
	public void remove(Adresse adresse) throws Exception {
		if (adresseDao.findById(adresse.getId()) == null) {
			throw new Exception("Erreur : l'adresse n'appartient pas à la base de données !");
		}
		adresseDao.remove(adresse);
	}

	// Methode pour mettre a jour une adresse dans la BdD
	public Adresse update(Adresse adresse) throws Exception {
		if (adresse.getIdUtilisateur() == 0) {
			throw new Exception("Erreur : idUtilisateur manquant !");
		}
		if (adresseDao.findById(adresse.getId()) == null) {
			throw new Exception("Erreur : l'adresse n'appartient pas à la base de données !");
		}
		return adresseDao.update(adresse);
	}

	// Méthode pour rendre la liste complete des adresses
	public ArrayList<Adresse> findAll() {
		return (ArrayList<Adresse>) adresseDao.findAll();
	}

	// Methode pour trouver dans la BdD une adresse d'id connu
	public Adresse findById(int id) {
		return adresseDao.findById(id);
	}

	// Methode pour trouver les adresses d'un utilisateur
	public ArrayList<Adresse> findByUtilisateur(int idUtilisateur) {
		return (ArrayList<Adresse>) adresseDao.findByUtilisateur(idUtilisateur);
	}
	
}
