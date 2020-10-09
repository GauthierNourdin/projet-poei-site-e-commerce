package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.LignePanier;
import org.eclipse.model.Panier;
import org.eclipse.model.Produit;

public class PanierService {

	// Attributs
	private ArrayList<Panier> paniers;

	// Le constructeur
	public PanierService(ArrayList<Panier> paniers) {
		this.paniers = paniers;
	}

	// Les getters et les setters classiques
	public ArrayList<Panier> getPaniers() {
		return this.paniers;
	}

	public void setPaniers(ArrayList<Panier> paniers) {
		this.paniers = paniers;
	}

	// Méthode pour ajouter un panier dans la liste
	public boolean save(Panier panier) {
		/*
		 * On vérifie que le panier n'appartient pas déjà à la liste avant de le
		 * rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (this.paniers.contains(panier)) {
			return false;
		} else {
			return this.paniers.add(panier);
		}
	}

	// Méthode pour retirer un panier de la liste
	public boolean remove(Panier panier) {
		/*
		 * On vérifie que le panier est bien présent dans la liste avant de le
		 * supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (this.paniers.contains(panier)) {
			return this.paniers.remove(panier);
		} else {
			return false;
		}
	}

	// Méthode pour mettre à jour un panier
	public boolean update(Panier panier) {
		/*
		 * La méthode retourne true si le panier à mettre à jour est dans la liste,
		 * false sinon.
		 */
		for (Panier pani : this.paniers) {
			if (pani.getId() == panier.getId()) {
				pani = panier;
				return true;
			}
		}
		return false;
	}

	// Méthode pour rendre la liste complète (convention de nommage)
	public ArrayList<Panier> findAll() {
		return this.paniers;
	}

	// Méthode pour trouver dans la liste un panier d'id connu
	public Panier findById(String id) {
		for (Panier pani : this.paniers) {
			if (pani.getId() == id) {
				return pani;
			}
		}
		return null;
	}
	
	// Méthode pour ajouter une ligne de panier au panier d'un client
	public void ajouterLignePanier(Panier panier, Produit produit, int quantiteSouhaitee, LignePanierService lignePanierService, ClientService clientService) {
		boolean flag = false; // Boolean pour savoir si on essaie d'ajouter un produit identique
		for(LignePanier lignPani : panier.getLignesPanier()) {
			if(lignPani.getProduit().getId() == produit.getId()) {
				if (quantiteSouhaitee + lignPani.getQuantiteCommandee() < produit.getQuantiteEnStock()) {
					lignPani.setQuantiteCommandee(produit.getQuantiteEnStock());
				} else {
					lignPani.setQuantiteCommandee(quantiteSouhaitee + lignPani.getQuantiteCommandee());
				}
				lignePanierService.update(lignPani);
				panier.
				this.update(panier)
				
				flag = true;
				break;
			}
		}
		
		
		LignePanier lignePanier = new LignePanier(id, quantiteSouhaitee, panier, produit);
		lignePanierService.save(lignePanier);
		lignePanierService.update(lignePanier);
		ArrayList<LignePanier> lignesPanier = panier.getLignesPanier();	 	
		lignesPanier.add(lignePanier);
		this.update(panier);
	}
	

	// Méthode pour vider complètement un panier
	public void viderPanier (String id) {
		Panier panier = this.findById(id);
		ArrayList<LignePanier> lignesPanier = panier.getLignesPanier();
		lignesPanier.clear();
	}
	
	
	// Méthode pour valider un panier et le transformer en une commande
	public void validerPanier (String id, LignePanierService lignePanierService, PanierService panierService) {
		
		
		
		this.viderPanier(id)
		
	}
	
	

	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "PanierService [paniers=" + this.paniers + "]";
	}

}
