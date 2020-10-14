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
	public Panier findById(String idPanier) {
		for (Panier pani : this.paniers) {
			if (pani.getId() == idPanier) {
				return pani;
			}
		}
		return null;
	}

	// Méthode pour ajouter une ligne de panier au panier d'un client
	public void ajouterLignePanier(Panier panier, Produit produit, int quantiteSouhaitee,
			LignePanierService lignePanierService, PanierService panierService, ClientService clientService,
			GestionnaireId gestionnaireId) {
		for (LignePanier lignPani : panier.getLignesPanier()) {
			if (lignPani.getProduit().getId() == produit.getId()) {
				/*
				 * Vérification que le produit que l'on veut ajouter au panier n'en fait pas
				 * déjà partie.
				 */
				if (quantiteSouhaitee + lignPani.getQuantiteCommandee() < produit.getQuantiteEnStock()) {
					/*
					 * Vérification que la quantité que l'on va commander ne dépasse pas le stock
					 * disponible
					 */
					lignPani.setQuantiteCommandee(produit.getQuantiteEnStock());
				} else {
					lignPani.setQuantiteCommandee(quantiteSouhaitee + lignPani.getQuantiteCommandee());
				}
				/*
				 * Maintenant que la quantité à commander a été ajustée, on va mettre à jour la
				 * base de données. On doit vérifier que cette quantité est non nulle.
				 */
				lignePanierService.update(lignPani);
				panierService.update(panier);
				clientService.update(panier.getClient());
				return; // Arrêt de l'exécution.
			}
		}
		// Si on n'a pas modifié une ligne de papier, il faut en créer une.
		LignePanier lignePanier = new LignePanier(gestionnaireId.giveNewIdLignePanier(), quantiteSouhaitee, panier,
				produit);
		// Ajout de la ligne de panier à la base de données
		lignePanierService.save(lignePanier);
		// Mise à jour de la base de données panier et client
		panierService.update(panier);
		clientService.update(panier.getClient());
	}

	// Méthode pour vider complètement un panier
	public void viderPanier(Panier panier, LignePanierService lignePanierService, PanierService panierService,
			ClientService clientService) {
		ArrayList<LignePanier> lignesPanier = panier.getLignesPanier();
		// Mise à jour de la base de données : suppression des lignes de panier.
		for (LignePanier lignePanier : lignesPanier) {
			lignePanierService.remove(lignePanier);
		}
		// Mise à jour de la base de données panier et client.
		panierService.update(panier);
		clientService.update(panier.getClient());
	}

	// Méthode pour valider un panier et le transformer en une commande
	public void validerPanier(Panier panier, LignePanierService lignePanierService, PanierService panierService,
			LigneCommandeService ligneCommandeService, CommandeService commandeService, ClientService clientService,
			ProduitService produitService, VendeurService vendeurService, GestionnaireId gestionnaireId) {
		// On vérifie une dernière fois la disponibilité des produits du panier
			verifierDisponibilitePanier(panier, lignePanierService, panierService, clientService);
		// On vérifie qu'il y ait au moins une ligne de panier valide.

		// On vide le panier (mise à jour bases de données panier et client incluses)
		panierService.viderPanier(panier, lignePanierService, panierService, clientService);
	}

	// Méthode pour vérifier à tout moment la disponibilité des éléments du panier
	public boolean verifierDisponibilitePanier(Panier panier, LignePanierService lignePanierService,
			PanierService panierService, ClientService clientService) {
		//
		
		
		// On supprime les éléments de la 
		return true;
	}

	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "PanierService [paniers=" + this.paniers + "]";
	}

}
