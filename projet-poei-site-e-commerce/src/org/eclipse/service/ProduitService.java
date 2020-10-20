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

	// M�thode pour ajouter un produit dans la liste
	public boolean save(Produit produit) {
		/*
		 * On v�rifie que le produit n'appartient pas d�j� � la liste avant de le
		 * rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (this.produits.contains(produit)) {
			return false;
		} else {
			return this.produits.add(produit);
		}
	}

	// M�thode pour retirer un produit de la liste
	public boolean remove(Produit produit) {
		/*
		 * On v�rifie que le produit est bien pr�sent dans la liste avant de le
		 * supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (this.produits.contains(produit)) {
			return this.produits.remove(produit);
		} else {
			return false;
		}
	}

	// M�thode pour mettre � jour un produit
	public boolean update(Produit produit) {
		/*
		 * La m�thode retourne true si le produit � mettre � jour est dans la liste,
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
	
	// M�thode pour rendre la liste compl�te (convention de nommage)
	public ArrayList<Produit> findAll() {
		return this.produits;
	}

	// M�thode pour trouver dans la liste un produit d'id connu
	public Produit findById(int id) {
		for (Produit prod: this.produits) {
			if (prod.getId() == id) {
				return prod;
			}
		}
		return null;
	}

	// M�thode pour trouver les produits disponibles
	public ArrayList<Produit> findByQuantiteEnStock() {
		ArrayList<Produit> disponibles = new ArrayList<Produit>();
		for (Produit prod : this.produits) {
			if (prod.getQuantiteEnStock() > 0) {
				disponibles.add(prod);
			}
		}
		return disponibles;
	}
	
	// M�thode pour trouver les produits d'un vendeur
	public ArrayList<Produit> findByVendeur(Vendeur vendeur) {
		ArrayList<Produit> produitsVendeur = new ArrayList<Produit>();
		for (Produit prod : this.produits) {
			if (prod.getQuantiteEnStock() > 0) {
				produitsVendeur.add(prod);
			}
		}
		return produitsVendeur;
	}
	
	// M�thode pour trouver un produit par nom
	public ArrayList<Produit> findByName(String designation) {
		ArrayList<Produit> produitsName = new ArrayList<Produit>();
		for (Produit prod : this.produits) {
			if (prod.getQuantiteEnStock() > 0) {
				produitsName.add(prod);
			}
		}
		return produitsName;
	}
	
	// M�thode pour filtrer une liste de produits selon disponibilit�
	public ArrayList<Produit> filterDisponibilite(ArrayList<Produit> listeProduits) {
		ArrayList<Produit> listeProduitsDisponibles = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getQuantiteEnStock() > 0) {
				listeProduitsDisponibles.add(prod);
			}
		return listeProduitsDisponibles;
	}
	
	// M�thode pour filtrer une liste de produits selon indisponibilit�
	public ArrayList<Produit> filterIndisponibilite(ArrayList<Produit> listeProduits) {
		ArrayList<Produit> listeProduitsIndisponibles = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getQuantiteEnStock() == 0) {
				listeProduitsIndisponibles.add(prod);
			}
		return listeProduitsIndisponibles;
	}
	
	// M�thode pour filtrer une liste de produits selon le vendeur
	public ArrayList<Produit> filterVendeur(ArrayList<Produit> listeProduits, Vendeur vendeur) {
		ArrayList<Produit> listeProduitsVendeur = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getIdVendeur() == vendeur.getId()) {
				listeProduitsVendeur.add(prod);
			}
		return listeProduitsVendeur;
	}
	
	// M�thode pour filtrer une liste de produits selon la designation
	public ArrayList<Produit> filterDesignation(ArrayList<Produit> listeProduits, String designation) {
		ArrayList<Produit> listeProduitsDesignation = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getDesignation() == designation) {
				listeProduitsDesignation.add(prod);
			}
		return listeProduitsDesignation;
	}
	
	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "ProduitService [produits=" + this.produits + "]";
	}

}
