package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.LigneCommande;
import org.eclipse.model.Produit;

public class ProduitService {
	/*
	 * Cet attribut ne doit etre initialise qu'une seule fois. Le rendre
	 * statique permet de le generer au debut de l'execution.
	 */
	private static ArrayList<Produit> produits = new ArrayList<Produit>();

	// Constructeur prive pour eviter de creer des instances.
	private ProduitService() {
	}

	// Le getter statique et le setter statique adaptes, ne servent qu'aux tests et au debuggage.
	public static ArrayList<Produit> getProduits() {
		return produits;
	}

	public static void setProduits(ArrayList<Produit> argProduits) {
		produits = argProduits;
	}

	// Methode statique pour ajouter un produit dans la liste
	public static void save(Produit produit) throws Exception {
		if (produits.contains(produit)) {
			throw new Exception("Le produit appartient deja a la liste");
		} else {
			produits.add(produit);
		}
	}

	// Methode statique pour retirer un produit de la liste
	public static void remove(Produit produit) throws Exception {
		if (produits.contains(produit)) {
			produits.remove(produit);
		} else {
			throw new Exception("Le produit n'appartient pas a la liste");
		}
	}

	// Methode statique pour mettre a jour un produit
	public static void update(Produit produit) throws Exception {
		for (Produit prod: produits) {
			if (prod.getId() == produit.getId()) {
				prod = produit;
				return;
			}
		}
		throw new Exception("Le produit n'appartient pas a la liste");
	}
	
	// Methode statique pour rendre la liste complete (convention de nommage)
	public static ArrayList<Produit> findAll() {
		return produits;
	}

	// Methode statique pour trouver dans la liste un produit d'id connu
	public static Produit findById(int id) {
		for (Produit prod: produits) {
			if (prod.getId() == id) {
				return prod;
			}
		}
		return null;
	}

	// Methode statique pour trouver les lignes de commandes concernant un produit
	public static ArrayList<LigneCommande> findLignesCommandeOfProduct(int idProduit) {
		ArrayList<LigneCommande> resLignesCommande = new ArrayList<LigneCommande>();
		ArrayList<LigneCommande> lignesCommande = LigneCommandeService.findAll();
		for (LigneCommande lignComm : lignesCommande) {
			if (lignComm.getIdProduit() == idProduit) {
				resLignesCommande.add(lignComm);
			}
		}
		return resLignesCommande;
	}
	
	// Methode statique pour restocker un produit (+X Exemplaires)
	public static void restockageProduit(Produit produit, int quantiteRentree) throws Exception {
		produit.setQuantiteEnStock(quantiteRentree + produit.getQuantiteEnStock());
		try {
			ProduitService.update(produit);
		} catch (Exception e) {
			throw new Exception("Erreur de mise à jour du produit");
		}
	}
	
	// Methode statique pour restocker un produit (X Exemplaires)
	public static void newStockProduit(Produit produit, int quantiteEnStock) throws Exception {
		produit.setQuantiteEnStock(quantiteEnStock);
		try {
			ProduitService.update(produit);
		} catch (Exception e) {
			throw new Exception("Erreur de mise à jour du produit");
		}
	}
	
	// Methode statique pour trouver les produits disponibles
	public static ArrayList<Produit> findDisponibles() {
		ArrayList<Produit> disponibles = new ArrayList<Produit>();
		for (Produit prod : produits) {
			if (prod.getQuantiteEnStock() > 0) {
				disponibles.add(prod);
			}
		}
		return disponibles;
	}
	
	// Methode statique pour trouver les produits indisponibles
	public static ArrayList<Produit> findIndisponibles() {
		ArrayList<Produit> disponibles = new ArrayList<Produit>();
		for (Produit prod : produits) {
			if (prod.getQuantiteEnStock() == 0) {
				disponibles.add(prod);
			}
		}
		return disponibles;
	}
	
	// Methode statique pour trouver les produits d'un vendeur
	public static ArrayList<Produit> findByVendeur(int idVendeur) {
		ArrayList<Produit> produitsVendeur = new ArrayList<Produit>();
		for (Produit prod : produits) {
			if (prod.getIdVendeur() == idVendeur) {
				produitsVendeur.add(prod);
			}
		}
		return produitsVendeur;
	}
	
	// Methode statique pour trouver les produits disponibles d'un vendeur
	public static ArrayList<Produit> findDisponiblesOfVendeur(int idVendeur) {
		ArrayList<Produit> produitsVendeur = new ArrayList<Produit>();
		for (Produit prod : produits) {
			if (prod.getIdVendeur() == idVendeur && prod.getQuantiteEnStock() > 0) {
				produitsVendeur.add(prod);
			}
		}
		return produitsVendeur;
	}
	
	// Methode statique pour trouver les produits indisponibles d'un vendeur
	public static ArrayList<Produit> findIndisponiblesOfVendeur(int idVendeur) {
		ArrayList<Produit> produitsVendeur = new ArrayList<Produit>();
		for (Produit prod : produits) {
			if (prod.getIdVendeur() == idVendeur && prod.getQuantiteEnStock() == 0) {
				produitsVendeur.add(prod);
			}
		}
		return produitsVendeur;
	}
	
	// Methode statique pour trouver un produit par nom
	public static ArrayList<Produit> findByName(String designation) {
		ArrayList<Produit> produitsName = new ArrayList<Produit>();
		for (Produit prod : produits) {
			if (prod.getDesignation().equalsIgnoreCase(designation)) {
				produitsName.add(prod);
			}
		}
		return produitsName;
	}
	
	// Methode statique pour trouver un produit par categories
	public static ArrayList<Produit> findByCategories(ArrayList<Integer> idCategories) {
		ArrayList<Produit> produitsCategories = new ArrayList<Produit>();
		boolean test;
		for (Produit prod : produits) {
			test = true;
			for (int idCate : idCategories) {
				if (!prod.getIdCategories().contains(idCate)) {
					test = false;
				}
			}
			if (test) {
				produitsCategories.add(prod);
			}
		}
		return produitsCategories;
	}
	
	// Methode statique pour filtrer une liste de produits selon disponibilite
	public static ArrayList<Produit> filterDisponibles(ArrayList<Produit> listeProduits) {
		ArrayList<Produit> listeProduitsDisponibles = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getQuantiteEnStock() > 0) {
				listeProduitsDisponibles.add(prod);
			}
		return listeProduitsDisponibles;
	}
	
	// Methode statique pour filtrer une liste de produits selon indisponibilite
	public static ArrayList<Produit> filterIndisponibles(ArrayList<Produit> listeProduits) {
		ArrayList<Produit> listeProduitsIndisponibles = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getQuantiteEnStock() == 0) {
				listeProduitsIndisponibles.add(prod);
			}
		return listeProduitsIndisponibles;
	}
	
	// Methode statique pour filtrer une liste de produits selon le vendeur
	public static ArrayList<Produit> filterVendeur(ArrayList<Produit> listeProduits, int idVendeur) {
		ArrayList<Produit> listeProduitsVendeur = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getIdVendeur() == idVendeur) {
				listeProduitsVendeur.add(prod);
			}
		return listeProduitsVendeur;
	}
	
	// Methode statique pour filtrer une liste de produits selon la designation
	public static ArrayList<Produit> filterName(ArrayList<Produit> listeProduits, String designation) {
		ArrayList<Produit> listeProduitsDesignation = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getDesignation() == designation) {
				listeProduitsDesignation.add(prod);
			}
		return listeProduitsDesignation;
	}
	
	// Methode statique pour filtrer une liste de produits selon des categories
	public static ArrayList<Produit> filterCategories(ArrayList<Produit> listeProduits, ArrayList<Integer> idCategories) {
		ArrayList<Produit> listeProduitsCategories = new ArrayList<Produit>();
		boolean test;
		for (Produit prod : listeProduits) {
			test = true;
			for (int idCate : idCategories) {
				if (!prod.getIdCategories().contains(idCate)) {
					test = false;
				}
			}
			if (test) {
				listeProduitsCategories.add(prod);
			}
		}
		return listeProduitsCategories;
	}
	
	// La methode sert uniquement au debuggage.
	public static String affichageDebuggage() {
		return "ProduitService [produits=" + produits + "]";
	}

}
