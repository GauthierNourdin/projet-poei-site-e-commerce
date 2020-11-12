package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.Produit;
import org.eclipse.model.Vendeur;

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

	// Methode statique pour trouver les produits disponibles
	public static ArrayList<Produit> findByQuantiteEnStock() {
		ArrayList<Produit> disponibles = new ArrayList<Produit>();
		for (Produit prod : produits) {
			if (prod.getQuantiteEnStock() > 0) {
				disponibles.add(prod);
			}
		}
		return disponibles;
	}
	
	// Methode statique pour trouver les produits d'un vendeur
	public static ArrayList<Produit> findByVendeur(Vendeur vendeur) {
		ArrayList<Produit> produitsVendeur = new ArrayList<Produit>();
		for (Produit prod : produits) {
			if (prod.getQuantiteEnStock() > 0) {
				produitsVendeur.add(prod);
			}
		}
		return produitsVendeur;
	}
	
	// Methode statique pour trouver un produit par nom
	public static ArrayList<Produit> findByName(String designation) {
		ArrayList<Produit> produitsName = new ArrayList<Produit>();
		for (Produit prod : produits) {
			if (prod.getQuantiteEnStock() > 0) {
				produitsName.add(prod);
			}
		}
		return produitsName;
	}
	
	// Methode statique pour filtrer une liste de produits selon disponibilite
	public static ArrayList<Produit> filterDisponibilite(ArrayList<Produit> listeProduits) {
		ArrayList<Produit> listeProduitsDisponibles = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getQuantiteEnStock() > 0) {
				listeProduitsDisponibles.add(prod);
			}
		return listeProduitsDisponibles;
	}
	
	// Methode statique pour filtrer une liste de produits selon indisponibilite
	public static ArrayList<Produit> filterIndisponibilite(ArrayList<Produit> listeProduits) {
		ArrayList<Produit> listeProduitsIndisponibles = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getQuantiteEnStock() == 0) {
				listeProduitsIndisponibles.add(prod);
			}
		return listeProduitsIndisponibles;
	}
	
	// Methode statique pour filtrer une liste de produits selon le vendeur
	public static ArrayList<Produit> filterVendeur(ArrayList<Produit> listeProduits, Vendeur vendeur) {
		ArrayList<Produit> listeProduitsVendeur = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getIdVendeur() == vendeur.getId()) {
				listeProduitsVendeur.add(prod);
			}
		return listeProduitsVendeur;
	}
	
	// Methode statique pour filtrer une liste de produits selon la designation
	public static ArrayList<Produit> filterDesignation(ArrayList<Produit> listeProduits, String designation) {
		ArrayList<Produit> listeProduitsDesignation = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getDesignation() == designation) {
				listeProduitsDesignation.add(prod);
			}
		return listeProduitsDesignation;
	}
	
	// La methode sert uniquement au debuggage.
	public static String affichageDebuggage() {
		return "ProduitService [produits=" + produits + "]";
	}

}
