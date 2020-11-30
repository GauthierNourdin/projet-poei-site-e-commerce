package org.eclipse.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.model.Client;
import org.eclipse.model.Commande;
import org.eclipse.model.LigneCommande;
import org.eclipse.model.LignePanier;
import org.eclipse.model.Produit;

public class ClientService {
	/*
	 * Cet attribut ne doit etre initialise qu'une seule fois. Le rendre statique
	 * permet de le generer au debut de l'execution.
	 */
	private static ArrayList<Client> clients = new ArrayList<Client>(Arrays.asList(
			new Client("Bouchard", "Gerard", "gerard.bouchard@yahoomail.com", "0405678916",
					"GerardBouchard", "QuelJoliNom", new ArrayList<Integer>(Arrays.asList(1, 2)))
			));
	
	// Constructeur prive pour eviter de creer des instances.
	private ClientService() {
	}

	// Le getter statique et le setter statique adaptes, ne servent qu'aux tests et
	// au débuggage.
	public static ArrayList<Client> getClients() {
		return clients;
	}

	public static void setClients(ArrayList<Client> argClients) {
		clients = argClients;
	}

	// Methode statique pour ajouter un client dans la liste
	public static void save(Client client) throws Exception {
		if (clients.contains(client)) {
			throw new Exception ("Le client appartient deja à la liste");
		} else {
			clients.add(client);
		}
	}

	// Methode statique pour retirer un client de la liste
	public static void remove(Client client) throws Exception {
		if (clients.contains(client)) {
			clients.remove(client);
		} else {
			throw new Exception ("Le client n'appartient pas a la liste");
		}
	}

	// Methode statique pour mettre a jour un client
	public static void update(Client client) throws Exception {
		for (Client clie : clients) {
			if (clie.getIdClient() == client.getIdClient()) {
				clie = client;
				return;
			}
		}
		throw new Exception ("Le client n'appartient pas a la liste");
	}

	// Methode statique pour rendre la liste complete (convention de nommage)
	public static ArrayList<Client> findAll() {
		return clients;
	}

	// Methode statique pour trouver dans la liste un client d'id connu.
	public static Client findById(int id) {
		for (Client clie : clients) {
			if (clie.getIdClient() == id) {
				return clie;
			}
		}
		return null;
	}

	// Methode statique pour autoriser la connection d'un client (en retournant son
	// objet associé)
	public static Client connectionClient(String identifiantConnexion, String motDePasse) {
		for (Client clie : clients) {
			if (clie.getIdentifiantConnexion().equals(identifiantConnexion)
					&& clie.getMotDePasse().equals(motDePasse)) {
				return clie;
			}
		}
		return null;
	}
	
	// Methode statique pour ajouter une ligne de panier au panier d'un client via un produit
	public static void ajouterLignePanier (Client client, Produit produit, int quantiteSouhaitee) throws Exception {
		boolean flagSurAjout = false;
		ArrayList<Integer> idLignesPanier = client.getIdLignesPanier();
		ArrayList<LignePanier> lignesPanier = new ArrayList<LignePanier>();
		for (int idLignPani : idLignesPanier) {
			LignePanier lignePanier = LignePanierService.findById(idLignPani); 
			if (lignePanier != null) 
				lignesPanier.add(lignePanier);
		}
		for (LignePanier lignPani : lignesPanier) {
			if (!flagSurAjout && (lignPani.getIdProduit() == produit.getId())) {
				if (quantiteSouhaitee + lignPani.getQuantiteSouhaitee() > produit.getQuantiteEnStock()) {
					lignPani.setQuantiteSouhaitee(produit.getQuantiteEnStock());
					LignePanierService.update(lignPani);
				} else {
					lignPani.setQuantiteSouhaitee(quantiteSouhaitee + lignPani.getQuantiteSouhaitee());
					LignePanierService.update(lignPani);
				}
				flagSurAjout = true;
			}
		}
		if (!flagSurAjout) {
			LignePanier newLignePanier;
			if (quantiteSouhaitee > produit.getQuantiteEnStock()) {
				newLignePanier = new LignePanier(produit.getQuantiteEnStock(), client.getIdClient(), produit.getId());
			} else {
				newLignePanier = new LignePanier(quantiteSouhaitee, client.getIdClient(), produit.getId());
			}
			try {
				LignePanierService.save(newLignePanier);
			} catch (Exception e) {
				throw new Exception("Problème de création de la nouvelle ligne de panier");
			}
			idLignesPanier.add(newLignePanier.getId());
			client.setIdLignesPanier(idLignesPanier);
			ClientService.update(client);
		}
	}
	
	// Methode statique pour supprimer une ligne de panier au panier d'un client
	public static void supprimerLignePanier (Client client, LignePanier lignePanier) throws Exception {
		try {
			LignePanierService.remove(lignePanier);
		} catch (Exception e) {
			throw new Exception("Problème de la suppression de la ligne de panier");
		}
		ArrayList<Integer> idLignesPanier = client.getIdLignesPanier();
		idLignesPanier.remove(lignePanier.getId());
		client.setIdLignesPanier(idLignesPanier);
		ClientService.update(client);
	}
	
	// Methode statique pour modifier la quantite souhaitee de produit d'une ligne de panier au panier d'un client
	public static void modifierLignePanier (Client client, LignePanier lignePanier, int quantiteSouhaitee) throws Exception {
		Produit produit = ProduitService.findById(lignePanier.getIdProduit());
		if (produit == null) {
			supprimerLignePanier(client, lignePanier);
			throw new Exception("Le produit n'est pas valide");
		}
		if (quantiteSouhaitee > produit.getQuantiteEnStock()) {
			lignePanier.setQuantiteSouhaitee(produit.getQuantiteEnStock());
			throw new Exception("Le produit n'est pas disponible en assez grande quantité");
		}
		lignePanier.setQuantiteSouhaitee(quantiteSouhaitee);
	}
	
	// Methode statique pour vider entièrement le panier
	public static void viderPanier (Client client) throws Exception {
		ArrayList<Integer> idLignesPanier = client.getIdLignesPanier();
		ArrayList<LignePanier> lignesPanier = new ArrayList<LignePanier>();
		for (int idLignPani : idLignesPanier) {
			LignePanier lignePanier = LignePanierService.findById(idLignPani); 
			if (lignePanier != null) 
				lignesPanier.add(lignePanier);
		}
		for (LignePanier lignPani : lignesPanier) {
			try {
				LignePanierService.remove(lignPani);
			} catch (Exception e) {
				throw new Exception("Problème de la suppression de la ligne de panier");
			}
		}
		idLignesPanier.clear();
		client.setIdLignesPanier(idLignesPanier);
		ClientService.update(client);
	}
	
	// Methode statique pour verifier qu'un panier est toujours valide
	public static void verifierPanier(Client client) throws Exception {
		ArrayList<Integer> idLignesPanier = client.getIdLignesPanier();
		ArrayList<LignePanier> lignesPanier = new ArrayList<LignePanier>();
		for (int idLignPani : idLignesPanier) {
			LignePanier lignePanier = LignePanierService.findById(idLignPani); 
			if (lignePanier != null) 
				lignesPanier.add(lignePanier);
		}
		for (LignePanier lignPani : lignesPanier) {
			Produit produit = ProduitService.findById(lignPani.getIdProduit());
			if (produit == null) {
				supprimerLignePanier(client, lignPani);
				throw new Exception("Le produit n'est pas valide");
			}
			if (lignPani.getQuantiteSouhaitee() > produit.getQuantiteEnStock()) {
				lignPani.setQuantiteSouhaitee(produit.getQuantiteEnStock());
				LignePanierService.update(lignPani);
				throw new Exception("Le produit n'est pas disponible en assez grande quantité");
			}
		}
	}
	
	// Methode statique pour valider le panier et le transformer en commande
	public static void validerPanier (Client client) throws Exception {
		ArrayList<Integer> idLignesPanier = client.getIdLignesPanier();
		ArrayList<LignePanier> lignesPanier = new ArrayList<LignePanier>();
		for (int idLignPani : idLignesPanier) {
			LignePanier lignePanier = LignePanierService.findById(idLignPani); 
			if (lignePanier != null) 
				lignesPanier.add(lignePanier);
		}
		try {
			verifierPanier(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Commande commande = new Commande(client.getIdClient());
		ArrayList<Integer> idCommandes = client.getIdCommandes();
		idCommandes.add(commande.getId());
		client.setIdCommandes(idCommandes);
		
		ArrayList<Integer> idLignesCommande = new ArrayList<Integer>();
		for (LignePanier lignPani : lignesPanier) {
			Produit produit = ProduitService.findById(lignPani.getIdProduit());
			produit.setQuantiteEnStock(produit.getQuantiteEnStock() - lignPani.getQuantiteSouhaitee());
			
			LigneCommande ligneCommande = new LigneCommande(lignPani.getQuantiteSouhaitee(), commande.getId(), lignPani.getIdProduit(), produit.getPrixUnitaire());
			try {
				LigneCommandeService.save(ligneCommande);
			} catch (Exception e) {
				throw new Exception("Probleme de sauvegarde de la ligne de commande");
			}
			idLignesCommande.add(ligneCommande.getId());
			
			ArrayList<Integer> produitIdLignesCommande = produit.getIdLignesCommande();
			produitIdLignesCommande.add(ligneCommande.getId());
			produit.setIdLignesCommande(produitIdLignesCommande);
			ProduitService.update(produit);
		}
		
		commande.setIdLignesCommande(idLignesCommande);
		CommandeService.save(commande);
		viderPanier(client);
	}

	// La methode sert uniquement au debuggage.
	public static String affichageDebuggage() {
		return "ClientService [clients=" + clients + "]";
	}

}
