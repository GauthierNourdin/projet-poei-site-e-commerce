package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.Produit;
import org.eclipse.model.Vendeur;

public class ProduitService {
	/*
	 * Cet attribut ne doit être initialisé qu'une seule fois. Le rendre
	 * statique permet de le générer au début de l'exécution.
	 */
	private static ArrayList<Produit> produits;

	// Constructeur privé pour éviter de créer des instances.
	private ProduitService() {
	}

	// Le getter statique et le setter statique adaptés
	public static ArrayList<Produit> getProduits() {
		return produits;
	}

	public static void setProduits(ArrayList<Produit> argProduits) {
		produits = argProduits;
	}

	// Méthode statique pour ajouter un produit dans la liste
	public static boolean save(Produit produit) {
		/*
		 * On vérifie que le produit n'appartient pas déjà à la liste avant de le
		 * rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (produits.contains(produit)) {
			return false;
		} else {
			return produits.add(produit);
		}
	}

	// Méthode statique pour retirer un produit de la liste
	public static boolean remove(Produit produit) {
		/*
		 * On vérifie que le produit est bien présent dans la liste avant de le
		 * supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (produits.contains(produit)) {
			return produits.remove(produit);
		} else {
			return false;
		}
	}

	// Méthode statique pour mettre à jour un produit
	public static boolean update(Produit produit) {
		/*
		 * La méthode retourne true si le produit à mettre à jour est dans la liste,
		 * false sinon.
		 */
		for (Produit prod: produits) {
			if (prod.getId() == produit.getId()) {
				prod = produit;
				return true;
			}
		}
		return false;
	}
	
	// Méthode statique pour rendre la liste complète (convention de nommage)
	public static ArrayList<Produit> findAll() {
		return produits;
	}

	// Méthode statique pour trouver dans la liste un produit d'id connu
	public static Produit findById(int id) {
		for (Produit prod: produits) {
			if (prod.getId() == id) {
				return prod;
			}
		}
		return null;
	}

	// Méthode statique pour trouver les produits disponibles
	public static ArrayList<Produit> findByQuantiteEnStock() {
		ArrayList<Produit> disponibles = new ArrayList<Produit>();
		for (Produit prod : produits) {
			if (prod.getQuantiteEnStock() > 0) {
				disponibles.add(prod);
			}
		}
		return disponibles;
	}
	
	// Méthode statique pour trouver les produits d'un vendeur
	public static ArrayList<Produit> findByVendeur(Vendeur vendeur) {
		ArrayList<Produit> produitsVendeur = new ArrayList<Produit>();
		for (Produit prod : produits) {
			if (prod.getQuantiteEnStock() > 0) {
				produitsVendeur.add(prod);
			}
		}
		return produitsVendeur;
	}
	
	// Méthode statique pour trouver un produit par nom
	public static ArrayList<Produit> findByName(String designation) {
		ArrayList<Produit> produitsName = new ArrayList<Produit>();
		for (Produit prod : produits) {
			if (prod.getQuantiteEnStock() > 0) {
				produitsName.add(prod);
			}
		}
		return produitsName;
	}
	
	// Méthode statique pour filtrer une liste de produits selon disponibilité
	public static ArrayList<Produit> filterDisponibilite(ArrayList<Produit> listeProduits) {
		ArrayList<Produit> listeProduitsDisponibles = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getQuantiteEnStock() > 0) {
				listeProduitsDisponibles.add(prod);
			}
		return listeProduitsDisponibles;
	}
	
	// Méthode statique pour filtrer une liste de produits selon indisponibilité
	public static ArrayList<Produit> filterIndisponibilite(ArrayList<Produit> listeProduits) {
		ArrayList<Produit> listeProduitsIndisponibles = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getQuantiteEnStock() == 0) {
				listeProduitsIndisponibles.add(prod);
			}
		return listeProduitsIndisponibles;
	}
	
	// Méthode statique pour filtrer une liste de produits selon le vendeur
	public static ArrayList<Produit> filterVendeur(ArrayList<Produit> listeProduits, Vendeur vendeur) {
		ArrayList<Produit> listeProduitsVendeur = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getIdVendeur() == vendeur.getId()) {
				listeProduitsVendeur.add(prod);
			}
		return listeProduitsVendeur;
	}
	
	// Méthode statique pour filtrer une liste de produits selon la designation
	public static ArrayList<Produit> filterDesignation(ArrayList<Produit> listeProduits, String designation) {
		ArrayList<Produit> listeProduitsDesignation = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getDesignation() == designation) {
				listeProduitsDesignation.add(prod);
			}
		return listeProduitsDesignation;
	}
	
	// La méthode sert uniquement au débuggage.
	public static String affichageDebuggage() {
		return "ProduitService [produits=" + produits + "]";
	}

}
