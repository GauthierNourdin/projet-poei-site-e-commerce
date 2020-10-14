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
	public Panier findById(String idPanier) {
		for (Panier pani : this.paniers) {
			if (pani.getId() == idPanier) {
				return pani;
			}
		}
		return null;
	}

	// M�thode pour ajouter une ligne de panier au panier d'un client
	public void ajouterLignePanier(Panier panier, Produit produit, int quantiteSouhaitee,
			LignePanierService lignePanierService, PanierService panierService, ClientService clientService,
			GestionnaireId gestionnaireId) {
		for (LignePanier lignPani : panier.getLignesPanier()) {
			if (lignPani.getProduit().getId() == produit.getId()) {
				/*
				 * V�rification que le produit que l'on veut ajouter au panier n'en fait pas
				 * d�j� partie.
				 */
				if (quantiteSouhaitee + lignPani.getQuantiteCommandee() < produit.getQuantiteEnStock()) {
					/*
					 * V�rification que la quantit� que l'on va commander ne d�passe pas le stock
					 * disponible
					 */
					lignPani.setQuantiteCommandee(produit.getQuantiteEnStock());
				} else {
					lignPani.setQuantiteCommandee(quantiteSouhaitee + lignPani.getQuantiteCommandee());
				}
				/*
				 * Maintenant que la quantit� � commander a �t� ajust�e, on va mettre � jour la
				 * base de donn�es. On doit v�rifier que cette quantit� est non nulle.
				 */
				lignePanierService.update(lignPani);
				panierService.update(panier);
				clientService.update(panier.getClient());
				return; // Arr�t de l'ex�cution.
			}
		}
		// Si on n'a pas modifi� une ligne de papier, il faut en cr�er une.
		LignePanier lignePanier = new LignePanier(gestionnaireId.giveNewIdLignePanier(), quantiteSouhaitee, panier,
				produit);
		// Ajout de la ligne de panier � la base de donn�es
		lignePanierService.save(lignePanier);
		// Mise � jour de la base de donn�es panier et client
		panierService.update(panier);
		clientService.update(panier.getClient());
	}

	// M�thode pour vider compl�tement un panier
	public void viderPanier(Panier panier, LignePanierService lignePanierService, PanierService panierService,
			ClientService clientService) {
		ArrayList<LignePanier> lignesPanier = panier.getLignesPanier();
		// Mise � jour de la base de donn�es : suppression des lignes de panier.
		for (LignePanier lignePanier : lignesPanier) {
			lignePanierService.remove(lignePanier);
		}
		// Mise � jour de la base de donn�es panier et client.
		panierService.update(panier);
		clientService.update(panier.getClient());
	}

	// M�thode pour valider un panier et le transformer en une commande
	public void validerPanier(Panier panier, LignePanierService lignePanierService, PanierService panierService,
			LigneCommandeService ligneCommandeService, CommandeService commandeService, ClientService clientService,
			ProduitService produitService, VendeurService vendeurService, GestionnaireId gestionnaireId) {
		// On v�rifie une derni�re fois la disponibilit� des produits du panier
			verifierDisponibilitePanier(panier, lignePanierService, panierService, clientService);
		// On v�rifie qu'il y ait au moins une ligne de panier valide.

		// On vide le panier (mise � jour bases de donn�es panier et client incluses)
		panierService.viderPanier(panier, lignePanierService, panierService, clientService);
	}

	// M�thode pour v�rifier � tout moment la disponibilit� des �l�ments du panier
	public boolean verifierDisponibilitePanier(Panier panier, LignePanierService lignePanierService,
			PanierService panierService, ClientService clientService) {
		//
		
		
		// On supprime les �l�ments de la 
		return true;
	}

	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "PanierService [paniers=" + this.paniers + "]";
	}

}
