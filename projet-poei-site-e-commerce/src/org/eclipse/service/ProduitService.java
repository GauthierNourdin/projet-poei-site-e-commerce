package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.Produit;
import org.eclipse.model.Vendeur;

public class ProduitService {
	/*
	 * Cet attribut ne doit �tre initialis� qu'une seule fois. Le rendre
	 * statique permet de le g�n�rer au d�but de l'ex�cution.
	 */
	private static ArrayList<Produit> produits;

	// Constructeur priv� pour �viter de cr�er des instances.
	private ProduitService() {
	}

	// Le getter statique et le setter statique adapt�s
	public static ArrayList<Produit> getProduits() {
		return produits;
	}

	public static void setProduits(ArrayList<Produit> argProduits) {
		produits = argProduits;
	}

	// M�thode statique pour ajouter un produit dans la liste
	public static boolean save(Produit produit) {
		/*
		 * On v�rifie que le produit n'appartient pas d�j� � la liste avant de le
		 * rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (produits.contains(produit)) {
			return false;
		} else {
			return produits.add(produit);
		}
	}

	// M�thode statique pour retirer un produit de la liste
	public static boolean remove(Produit produit) {
		/*
		 * On v�rifie que le produit est bien pr�sent dans la liste avant de le
		 * supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (produits.contains(produit)) {
			return produits.remove(produit);
		} else {
			return false;
		}
	}

	// M�thode statique pour mettre � jour un produit
	public static boolean update(Produit produit) {
		/*
		 * La m�thode retourne true si le produit � mettre � jour est dans la liste,
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
	
	// M�thode statique pour rendre la liste compl�te (convention de nommage)
	public static ArrayList<Produit> findAll() {
		return produits;
	}

	// M�thode statique pour trouver dans la liste un produit d'id connu
	public static Produit findById(int id) {
		for (Produit prod: produits) {
			if (prod.getId() == id) {
				return prod;
			}
		}
		return null;
	}

	// M�thode statique pour trouver les produits disponibles
	public static ArrayList<Produit> findByQuantiteEnStock() {
		ArrayList<Produit> disponibles = new ArrayList<Produit>();
		for (Produit prod : produits) {
			if (prod.getQuantiteEnStock() > 0) {
				disponibles.add(prod);
			}
		}
		return disponibles;
	}
	
	// M�thode statique pour trouver les produits d'un vendeur
	public static ArrayList<Produit> findByVendeur(Vendeur vendeur) {
		ArrayList<Produit> produitsVendeur = new ArrayList<Produit>();
		for (Produit prod : produits) {
			if (prod.getQuantiteEnStock() > 0) {
				produitsVendeur.add(prod);
			}
		}
		return produitsVendeur;
	}
	
	// M�thode statique pour trouver un produit par nom
	public static ArrayList<Produit> findByName(String designation) {
		ArrayList<Produit> produitsName = new ArrayList<Produit>();
		for (Produit prod : produits) {
			if (prod.getQuantiteEnStock() > 0) {
				produitsName.add(prod);
			}
		}
		return produitsName;
	}
	
	// M�thode statique pour filtrer une liste de produits selon disponibilit�
	public static ArrayList<Produit> filterDisponibilite(ArrayList<Produit> listeProduits) {
		ArrayList<Produit> listeProduitsDisponibles = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getQuantiteEnStock() > 0) {
				listeProduitsDisponibles.add(prod);
			}
		return listeProduitsDisponibles;
	}
	
	// M�thode statique pour filtrer une liste de produits selon indisponibilit�
	public static ArrayList<Produit> filterIndisponibilite(ArrayList<Produit> listeProduits) {
		ArrayList<Produit> listeProduitsIndisponibles = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getQuantiteEnStock() == 0) {
				listeProduitsIndisponibles.add(prod);
			}
		return listeProduitsIndisponibles;
	}
	
	// M�thode statique pour filtrer une liste de produits selon le vendeur
	public static ArrayList<Produit> filterVendeur(ArrayList<Produit> listeProduits, Vendeur vendeur) {
		ArrayList<Produit> listeProduitsVendeur = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getIdVendeur() == vendeur.getId()) {
				listeProduitsVendeur.add(prod);
			}
		return listeProduitsVendeur;
	}
	
	// M�thode statique pour filtrer une liste de produits selon la designation
	public static ArrayList<Produit> filterDesignation(ArrayList<Produit> listeProduits, String designation) {
		ArrayList<Produit> listeProduitsDesignation = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getDesignation() == designation) {
				listeProduitsDesignation.add(prod);
			}
		return listeProduitsDesignation;
	}
	
	// La m�thode sert uniquement au d�buggage.
	public static String affichageDebuggage() {
		return "ProduitService [produits=" + produits + "]";
	}

}
