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

	// M�thode pour ajouter un panier dans la liste
	public boolean save(Panier panier) {
		/*
		 * On v�rifie que le panier n'appartient pas d�j� � la liste avant de le
		 * rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (this.paniers.contains(panier)) {
			return false;
		} else {
			return this.paniers.add(panier);
		}
	}

	// M�thode pour retirer un panier de la liste
	public boolean remove(Panier panier) {
		/*
		 * On v�rifie que le panier est bien pr�sent dans la liste avant de le
		 * supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (this.paniers.contains(panier)) {
			return this.paniers.remove(panier);
		} else {
			return false;
		}
	}

	// M�thode pour mettre � jour un panier
	public boolean update(Panier panier) {
		/*
		 * La m�thode retourne true si le panier � mettre � jour est dans la liste,
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

	// M�thode pour rendre la liste compl�te (convention de nommage)
	public ArrayList<Panier> findAll() {
		return this.paniers;
	}

	// M�thode pour trouver dans la liste un panier d'id connu
	public Panier findById(String id) {
		for (Panier pani : this.paniers) {
			if (pani.getId() == id) {
				return pani;
			}
		}
		return null;
	}
	
	// M�thode pour ajouter une ligne de panier au panier d'un client
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
	

	// M�thode pour vider compl�tement un panier
	public void viderPanier (String id) {
		Panier panier = this.findById(id);
		ArrayList<LignePanier> lignesPanier = panier.getLignesPanier();
		lignesPanier.clear();
	}
	
	
	// M�thode pour valider un panier et le transformer en une commande
	public void validerPanier (String id, LignePanierService lignePanierService, PanierService panierService) {
		
		
		
		this.viderPanier(id)
		
	}
	
	

	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "PanierService [paniers=" + this.paniers + "]";
	}

}
