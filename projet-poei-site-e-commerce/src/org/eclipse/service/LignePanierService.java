package org.eclipse.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.model.LignePanier;

public class LignePanierService {
	/*
	 * Cet attribut ne doit etre initialise qu'une seule fois. Le rendre
	 * statique permet de le generer au debut de l'execution.
	 */
	private static ArrayList<LignePanier> lignesPanier = new ArrayList<LignePanier>(Arrays.asList(
			new LignePanier(3, 1, 2)
			));

	// Constructeur prive pour eviter de creer des instances.
	private LignePanierService() {
	}

	// Le getter statique et le setter statique adaptes, ne servent qu'aux tests et au débuggage.
	public static ArrayList<LignePanier> getLignesPaniers() {
		return lignesPanier;
	}

	public static void setLignesPaniers(ArrayList<LignePanier> argLignesPaniers) {
		lignesPanier = argLignesPaniers;
	}

	// Methode statique pour ajouter une ligne de panier dans la liste
	public static void save(LignePanier lignePanier) throws Exception {
		if (lignesPanier.contains(lignePanier)) {
			throw new Exception("La ligne de panier appartient deja a la liste");
		} else {
			lignesPanier.add(lignePanier);
		}
	}

	// Methode statique pour retirer une ligne de panier de la liste
	public static void remove(LignePanier lignePanier) throws Exception {
		if (lignesPanier.contains(lignePanier)) {
			lignesPanier.remove(lignePanier);
		} else {
			throw new Exception("La ligne de panier n'appartient pas a la liste");
		}
	}

	// Methode statique pour mettre a jour une ligne de panier
	public static void update(LignePanier lignePanier) throws Exception {
		for (LignePanier lignPani : lignesPanier) {
			if (lignPani.getId() == lignePanier.getId()) {
				lignPani = lignePanier;
				return;
			}
		}
		throw new Exception("La ligne de panier n'appartient pas a la liste");
	}

	// Methode statique pour rendre la liste complete (convention de nommage)
	public static ArrayList<LignePanier> findAll() {
		return lignesPanier;
	}

	// Methode statique pour trouver dans la liste une ligne de panier d'id connu
	public static LignePanier findById(int id) {
		for (LignePanier lignPani : lignesPanier) {
			if (lignPani.getId() == id) {
				return lignPani;
			}
		}
		return null;
	}
	
	// La methode sert uniquement au debuggage.
	public static String affichageDebuggage() {
		return "LignePanierService [lignesPanier=" + lignesPanier + "]";
	}

}
