package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.Commande;
import org.eclipse.model.LigneCommande;

public class CommandeService {
	/*
	 * Cet attribut ne doit etre initialise qu'une seule fois. Le rendre
	 * statique permet de le generer au debut de l'execution.
	 */
	private static ArrayList<Commande> commandes = new ArrayList<Commande>();

	// Constructeur prive pour eviter de creer des instances.
	private CommandeService() {
	}

	// Le getter statique et le setter statique adaptes, ne servent qu'aux tests et au débuggage.
	public static ArrayList<Commande> getCommandes() {
		return commandes;
	}

	public static void setCommandes(ArrayList<Commande> argCommandes) {
		commandes = argCommandes;
	}

	// Methode statique pour ajouter une commande dans la liste
	public static void save(Commande commande) throws Exception {
		if (commandes.contains(commande)) {
			throw new Exception("La commande appartient deja a la liste");
		} else {
			commandes.add(commande);
		}
	}

	// Méthode statique pour retirer une commande de la liste
	public static void remove(Commande commande) throws Exception {
		if (commandes.contains(commande)) {
			commandes.remove(commande);
		} else {
			throw new Exception("La commande n'appartient pas a la liste");
		}
	}

	// Methode statique pour mettre a jour une commande
	public static void update(Commande commande) throws Exception {
		for (Commande comm : commandes) {
			if (comm.getId() == commande.getId()) {
				comm = commande;
				return;
			}
		}
		throw new Exception("La commande n'appartient pas a la liste");
	}

	// Méthode statique pour rendre la liste complete (convention de nommage)
	public static ArrayList<Commande> findAll() {
		return commandes;
	}

	// Methode statique pour trouver dans la liste une commande d'id connu
	public static Commande findById(int id) {
		for (Commande comm : commandes) {
			if (comm.getId() == id) {
				return comm;
			}
		}
		return null;
	}

	// Methode statique pour retourner la liste des commandes d'un client
	public static ArrayList<Commande> findCommandeByClient(int idClient) {
		ArrayList<Commande> resCommandes = new ArrayList<Commande>();
		for (Commande comm : commandes) {
			if (comm.getIdClient() == idClient) {
				resCommandes.add(comm);
			}
		}
		return resCommandes;
	}
	
	// Methode statique pour retourner la liste des lignes de commandes associes à une commande
	public static ArrayList<LigneCommande> findLignesCommandeOfCommande(int idCommande) {
		ArrayList<LigneCommande> resLignesCommande = new ArrayList<LigneCommande>();
		ArrayList<LigneCommande> lignesCommande = LigneCommandeService.findAll();
		for(LigneCommande lignComm : lignesCommande) {
			if (lignComm.getIdCommande() == idCommande) {
				resLignesCommande.add(lignComm);
			}
		}
		return resLignesCommande;
	}
	
	// La methode sert uniquement au debuggage.
	public static String affichageDebuggage() {
		return "ClientService [commandes=" + commandes + "]";
	}

}
