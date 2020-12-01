package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.dao.CommandeDao;
import org.eclipse.model.Commande;

public class CommandeService {
	private CommandeDao commandeDao = new CommandeDao();
	
	// Methode pour ajouter une commande dans la BdD
	public Commande save(Commande commande) throws Exception {
		if (commande.getIdClient() == 0) {
			throw new Exception("Erreur : idClient manquant !");
		}
		return commandeDao.save(commande);
	}

	// Méthode pour retirer une commande de la BdD
	public void remove(Commande commande) throws Exception {
		if (commandeDao.findById(commande.getId()) == null) {
			throw new Exception("Erreur : la commande n'appartient pas à la base de données !");
		}
		commandeDao.remove(commande);
	}

	// Methode pour mettre a jour une commande dans la BdD
	public Commande update(Commande commande) throws Exception {
		if (commande.getIdClient() == 0) {
			throw new Exception("Erreur : idClient manquant !");
		}
		if (commandeDao.findById(commande.getId()) == null) {
			throw new Exception("Erreur : la commande n'appartient pas à la base de données !");
		}
		return commandeDao.update(commande);
	}

	// Méthode pour rendre la liste complete des commandes
	public ArrayList<Commande> findAll() {
		return (ArrayList<Commande>) commandeDao.findAll();
	}

	// Methode pour trouver dans la BdD une commande d'id connu
	public Commande findById(int id) {
		return commandeDao.findById(id);
	}

	// Methode pour retourner la liste des commandes d'un client
	public ArrayList<Commande> findByClient(int idClient) {
		return (ArrayList<Commande>) commandeDao.findByClient(idClient);
	}
}
