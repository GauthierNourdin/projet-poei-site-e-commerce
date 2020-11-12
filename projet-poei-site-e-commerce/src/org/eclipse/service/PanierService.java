package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.LignePanier;
import org.eclipse.model.Panier;
import org.eclipse.model.Produit;

public class PanierService {
	/*
	 * Cet attribut ne doit etre initialise qu'une seule fois. Le rendre
	 * statique permet de le generer au debut de l'execution.
	 */
	private static ArrayList<Panier> paniers = new ArrayList<Panier>();

	// Constructeur prive pour eviter de creer des instances.
	private PanierService() {
	}

	// Le getter statique et le setter statique adaptes, ne servent qu'aux tests et au débuggage.
	public static ArrayList<Panier> getPaniers() {
		return paniers;
	}

	public static void setPaniers(ArrayList<Panier> argPaniers) {
		paniers = argPaniers;
	}

	// Methode statique pour ajouter un panier dans la liste
	public static void save(Panier panier) throws Exception {
		if (paniers.contains(panier)) {
			throw new Exception("Le panier appartient deja a la liste");
		} else {
			paniers.add(panier);
		}
	}

	// Methode statique pour retirer un panier de la liste
	public static void remove(Panier panier) throws Exception {
		if (paniers.contains(panier)) {
			paniers.remove(panier);
		} else {
			throw new Exception("Le panier n'appartient pas a la liste");
		}
	}

	// Methode statique pour mettre a jour un panier
	public static void update(Panier panier) throws Exception {
		for (Panier pani : paniers) {
			if (pani.getId() == panier.getId()) {
				pani = panier;
				return;
			}
		}
		throw new Exception("Le panier n'appartient pas a la liste");
	}

	// Methode statique pour rendre la liste complete (convention de nommage)
	public static ArrayList<Panier> findAll() {
		return paniers;
	}

	// Methode statique pour trouver dans la liste un panier d'id connu
	public static Panier findById(int idPanier) {
		for (Panier pani : paniers) {
			if (pani.getId() == idPanier) {
				return pani;
			}
		}
		return null;
	}

	// Methode statique pour trouver tous les lignes du panier d'un client
	public static ArrayList<LignePanier> findLignesPanier(int idPanier) {
		ArrayList<LignePanier> resLignesPanier = new ArrayList<LignePanier>();
		ArrayList<LignePanier> lignesPanier = LignePanierService.findAll();
		for (LignePanier lignPani : lignesPanier) {
			if (lignPani.getIdPanier() == idPanier) {
				resLignesPanier.add(lignPani);
			}
		}
		return resLignesPanier;
	}
	
	// Methode statique pour ajouter une ligne de panier au panier d'un client
	public static void ajouterLignePanier (Panier panier, Produit produit, ArrayList<LignePanier> lignesPanier, int quantiteSouhaitee) throws Exception {
		boolean flagSurAjout = false;
		for (LignePanier lignPani : lignesPanier) {
			if (!flagSurAjout && (lignPani.getIdProduit() == produit.getId())) {
				if (quantiteSouhaitee + lignPani.getQuantiteSouhaitee() > produit.getQuantiteEnStock()) {
					lignPani.setQuantiteSouhaitee(produit.getQuantiteEnStock());
				} else {
					lignPani.setQuantiteSouhaitee(quantiteSouhaitee + lignPani.getQuantiteSouhaitee());
				}
				flagSurAjout = true;
			}
		}
		if (!flagSurAjout) {
			LignePanier newLignePanier;
			if (quantiteSouhaitee > produit.getQuantiteEnStock()) {
				newLignePanier = new LignePanier(produit.getQuantiteEnStock(), panier.getId(), produit.getId());
			} else {
				newLignePanier = new LignePanier(quantiteSouhaitee, panier.getId(), produit.getId());
			}
			try {
				LignePanierService.save(newLignePanier);
			} catch (Exception e) {
				throw new Exception("Problème de création de la nouvelle ligne de panier");
			}
			ArrayList<Integer> idLignesPanier = panier.getIdLignesPanier();
			idLignesPanier.add(newLignePanier.getId());
			panier.setIdLignesPanier(idLignesPanier);
			PanierService.update(panier);
		}
	}
	
	// Methode statique pour supprimer une ligne de panier au panier d'un client
	public static void supprimerLignePanier (Panier panier, LignePanier lignePanier) throws Exception {
		try {
			LignePanierService.remove(lignePanier);
		} catch (Exception e) {
			throw new Exception("Problème de la suppression de la ligne de panier");
		}
		ArrayList<Integer> idLignesPanier = panier.getIdLignesPanier();
		idLignesPanier.remove(lignePanier.getId());
		panier.setIdLignesPanier(idLignesPanier);
		PanierService.update(panier);
	}
	
	
	// Methode statique pour modifier une ligne de panier au panier d'un client
	public static void modifierLignePanier (Panier panier, LignePanier lignePanier, int quantiteSouhaitee) throws Exception {

	}
	
	// Methode statique pour vider entièrement le panier
	public static void viderPanier (Panier panier, ArrayList<LignePanier> lignesPanier) throws Exception {
		for (LignePanier lignPani : lignesPanier) {
			try {
				LignePanierService.remove(lignPani);
			} catch (Exception e) {
				throw new Exception("Problème de la suppression de la ligne de panier");
			}
		}
		ArrayList<Integer> idLignesPanier = panier.getIdLignesPanier();
		idLignesPanier.clear();
		panier.setIdLignesPanier(idLignesPanier);
		PanierService.update(panier);
	}
	
	// Methode statique pour valider le panier et le transformer en commande
	public static void validerPanier (Panier panier, ArrayList<LignePanier> lignesPanier) throws Exception {
		for (LignePanier lignPani : lignesPanier) {
		
			
		}
		
		
		
		for (LignePanier lignPani : lignesPanier) {
			try {
				LignePanierService.remove(lignPani);
			} catch (Exception e) {
				throw new Exception("Problème de la suppression de la ligne de panier");
			}
		}
		ArrayList<Integer> idLignesPanier = panier.getIdLignesPanier();
		idLignesPanier.clear();
		panier.setIdLignesPanier(idLignesPanier);
		PanierService.update(panier);
	}
	
	// La methode sert uniquement au debuggage.
	public static String affichageDebuggage() {
		return "PanierService [paniers=" + paniers + "]";
	}

}
