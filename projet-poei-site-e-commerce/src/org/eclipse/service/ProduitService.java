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

	// M�thode pour mettre � jour un produit (m�me ID !)
	public boolean update(Produit produit) {
		/*
		 * On compare l'id de produit dans la liste avec l'id du produit que l'on a
		 * envoy� en entr�e. Si on obtient une correspondance, on enl�ve le produit avec
		 * cet id de la liste et on rajoute le produit en entr�e. Seul le premier
		 * produit ayant cet id sera �limin�. La fonction retourne "true" si on a pu
		 * proc�der au remplacement, "false" sinon.
		 */
		for(Produit produitIndividuel : this.produits) {
			if(produitIndividuel.getId() == produit.getId()) {
				this.produits.remove(produitIndividuel);
				return this.save(produit);				
			}
		}
		return false;		
	}

	// M�thode pour rendre la liste compl�te (convention de nommage)
	public ArrayList<Produit> findAll(){
		return this.produits;
	}
	
	// M�thode pour trouver dans la liste un produit d'id connu
	public Produit findById(String id) {
		for(Produit produitIndividuel : this.produits) {
			if(produitIndividuel.getId() == id) {
				return produitIndividuel;
			}
		}
		return null;
	}
	
	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "ProduitService [produits=" + this.produits + "]";
	}

}
