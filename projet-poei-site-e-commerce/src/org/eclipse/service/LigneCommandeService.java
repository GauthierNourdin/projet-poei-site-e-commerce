package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.LigneCommande;

public class LigneCommandeService {
	/*
	 * Cet attribut ne doit etre initialise qu'une seule fois. Le rendre
	 * statique permet de le generer au debut de l'execution.
	 */
	private static ArrayList<LigneCommande> lignesCommande = new ArrayList<LigneCommande>();

	// Constructeur prive pour eviter de creer des instances.
	private LigneCommandeService() {
	}

	// Le getter statique et le setter statique adaptes, ne servent qu'aux tests et au débuggage.
	public static ArrayList<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public static void setLignesCommande(ArrayList<LigneCommande> argLignesCommande) {
		lignesCommande = argLignesCommande;
	}

	// Methode statique pour ajouter une ligne de commande dans la liste
	public static void save(LigneCommande ligneCommande) throws Exception {
		if (lignesCommande.contains(ligneCommande)) {
			throw new Exception("La ligne de commande appartient deja a la liste");
		} else {
			lignesCommande.add(ligneCommande);
		}
	}

	// Methode statique pour retirer une ligne de commande de la liste
	public static void remove(LigneCommande ligneCommande) throws Exception {
		if (lignesCommande.contains(ligneCommande)) {
			lignesCommande.remove(ligneCommande);
		} else {
			throw new Exception("La ligne de commande n'appartient pas a la liste");
		}
	}

	// Methode statique pour mettre a jour une ligne de commande
	public static void update(LigneCommande ligneCommande) throws Exception {
		for (LigneCommande lignComm : lignesCommande) {
			if (lignComm.getId() == ligneCommande.getId()) {
				lignComm = ligneCommande;
				return;
			}
		}
		throw new Exception("La ligne de commande n'appartient pas a la liste");
	}

	// Methode statique pour rendre la liste complete (convention de nommage)
	public static ArrayList<LigneCommande> findAll() {
		return lignesCommande;
	}

	// Methode statique pour trouver dans la liste une ligne de commande d'id connu
	public static LigneCommande findById(int id) {
		for (LigneCommande lignComm : lignesCommande) {
			if (lignComm.getId() == id) {
				return lignComm;
			}
		}
		return null;
	}

	// La methode sert uniquement au debuggage.
	public static String affichageDebuggage() {
		return "LigneCommandeService [lignesCommande=" + lignesCommande + "]";
	}

}
