package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.Produit;
import org.eclipse.model.Vendeur;

public class ProduitService {

	// Attributs
	private ArrayList<Produit> produits;

	// Le constructeur
	public ProduitService(ArrayList<Produit> produits) {
		this.produits = produits;
	}

	// Les getters et les setters classiques
	public ArrayList<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}

	// Méthode pour ajouter un produit dans la liste
	public boolean save(Produit produit) {
		/*
		 * On vérifie que le produit n'appartient pas déjà à la liste avant de le
		 * rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (this.produits.contains(produit)) {
			return false;
		} else {
			return this.produits.add(produit);
		}
	}

	// Méthode pour retirer un produit de la liste
	public boolean remove(Produit produit) {
		/*
		 * On vérifie que le produit est bien présent dans la liste avant de le
		 * supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (this.produits.contains(produit)) {
			return this.produits.remove(produit);
		} else {
			return false;
		}
	}

	// Méthode pour mettre à jour un produit
	public boolean update(Produit produit) {
		/*
		 * La méthode retourne true si le produit à mettre à jour est dans la liste,
		 * false sinon.
		 */
		for (Produit prod: this.produits) {
			if (prod.getId() == produit.getId()) {
				prod = produit;
				return true;
			}
		}
		return false;
	}
	
	// Méthode pour rendre la liste complète (convention de nommage)
	public ArrayList<Produit> findAll() {
		return this.produits;
	}

	// Méthode pour trouver dans la liste un produit d'id connu
	public Produit findById(int id) {
		for (Produit prod: this.produits) {
			if (prod.getId() == id) {
				return prod;
			}
		}
		return null;
	}

	// Méthode pour trouver les produits disponibles
	public ArrayList<Produit> findByQuantiteEnStock() {
		ArrayList<Produit> disponibles = new ArrayList<Produit>();
		for (Produit prod : this.produits) {
			if (prod.getQuantiteEnStock() > 0) {
				disponibles.add(prod);
			}
		}
		return disponibles;
	}
	
	// Méthode pour trouver les produits d'un vendeur
	public ArrayList<Produit> findByVendeur(Vendeur vendeur) {
		ArrayList<Produit> produitsVendeur = new ArrayList<Produit>();
		for (Produit prod : this.produits) {
			if (prod.getQuantiteEnStock() > 0) {
				produitsVendeur.add(prod);
			}
		}
		return produitsVendeur;
	}
	
	// Méthode pour trouver un produit par nom
	public ArrayList<Produit> findByName(String designation) {
		ArrayList<Produit> produitsName = new ArrayList<Produit>();
		for (Produit prod : this.produits) {
			if (prod.getQuantiteEnStock() > 0) {
				produitsName.add(prod);
			}
		}
		return produitsName;
	}
	
	// Méthode pour filtrer une liste de produits selon disponibilité
	public ArrayList<Produit> filterDisponibilite(ArrayList<Produit> listeProduits) {
		ArrayList<Produit> listeProduitsDisponibles = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getQuantiteEnStock() > 0) {
				listeProduitsDisponibles.add(prod);
			}
		return listeProduitsDisponibles;
	}
	
	// Méthode pour filtrer une liste de produits selon indisponibilité
	public ArrayList<Produit> filterIndisponibilite(ArrayList<Produit> listeProduits) {
		ArrayList<Produit> listeProduitsIndisponibles = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getQuantiteEnStock() == 0) {
				listeProduitsIndisponibles.add(prod);
			}
		return listeProduitsIndisponibles;
	}
	
	// Méthode pour filtrer une liste de produits selon le vendeur
	public ArrayList<Produit> filterVendeur(ArrayList<Produit> listeProduits, Vendeur vendeur) {
		ArrayList<Produit> listeProduitsVendeur = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getIdVendeur() == vendeur.getId()) {
				listeProduitsVendeur.add(prod);
			}
		return listeProduitsVendeur;
	}
	
	// Méthode pour filtrer une liste de produits selon la designation
	public ArrayList<Produit> filterDesignation(ArrayList<Produit> listeProduits, String designation) {
		ArrayList<Produit> listeProduitsDesignation = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getDesignation() == designation) {
				listeProduitsDesignation.add(prod);
			}
		return listeProduitsDesignation;
	}
	
	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "ProduitService [produits=" + this.produits + "]";
	}

}
