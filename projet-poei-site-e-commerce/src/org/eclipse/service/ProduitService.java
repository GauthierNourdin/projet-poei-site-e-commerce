package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.Produit;

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

	// Méthode pour mettre à jour un produit (même ID !)
	public boolean update(Produit produit) {
		/*
		 * On compare l'id de produit dans la liste avec l'id du produit que l'on a
		 * envoyé en entrée. Si on obtient une correspondance, on enlève le produit avec
		 * cet id de la liste et on rajoute le produit en entrée. Seul le premier
		 * produit ayant cet id sera éliminé. La fonction retourne "true" si on a pu
		 * procéder au remplacement, "false" sinon.
		 */
		for(Produit produitIndividuel : this.produits) {
			if(produitIndividuel.getId() == produit.getId()) {
				this.produits.remove(produitIndividuel);
				return this.save(produit);				
			}
		}
		return false;		
	}

	// Méthode pour rendre la liste complète (convention de nommage)
	public ArrayList<Produit> findAll(){
		return this.produits;
	}
	
	// Méthode pour trouver dans la liste un produit d'id connu
	public Produit findById(String id) {
		for(Produit produitIndividuel : this.produits) {
			if(produitIndividuel.getId() == id) {
				return produitIndividuel;
			}
		}
		return null;
	}
	
	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "ProduitService [produits=" + this.produits + "]";
	}

}
