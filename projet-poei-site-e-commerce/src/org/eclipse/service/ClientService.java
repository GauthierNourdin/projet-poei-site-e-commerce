package org.eclipse.service;

import java.util.ArrayList;
import java.sql.Date;

import org.eclipse.dao.ClientDao;
import org.eclipse.model.Client;
import org.eclipse.model.Commande;
import org.eclipse.model.LigneCommande;
import org.eclipse.model.LignePanier;
import org.eclipse.model.Produit;

public class ClientService {
	private ClientDao clientDao = new ClientDao();

	// Methode pour ajouter un client dans la BdD
	public Client save(Client client) throws Exception {
		if (clientDao.findByIdentifiantConnexion(client.getIdentifiantConnexion()) != null) {
			throw new Exception("Erreur : l'identifiant de connexion est déjà utilisé !");
		}
		return clientDao.save(client);
	}

	// Methode pour retirer un client de la BdD
	public void remove(Client client) throws Exception {
		if (clientDao.findById(client.getIdUtilisateur()) == null) {
			throw new Exception("Erreur : le client n'appartient pas à la base de données !");
		}
		clientDao.remove(client);
	}

	// Methode pour mettre a jour un client dans la BdD
	public Client update(Client client) throws Exception {
		if (clientDao.findById(client.getIdUtilisateur()) == null) {
			throw new Exception("Erreur : le client n'appartient pas à la base de données !");
		}
		return clientDao.update(client);
	}

	// Methode pour rendre la liste complete des clients
	public ArrayList<Client> findAll() {
		return (ArrayList<Client>) clientDao.findAll();
	}

	// Methode pour trouver dans la BdD un client d'id connu.
	public Client findById(int id) {
		return clientDao.findById(id);
	}

	// Recherche d'utilisateur par identifiant de connexion.
	public Client findByIdentifiantConnexion(String identifiantConnexion) {
		return clientDao.findByIdentifiantConnexion(identifiantConnexion);
	}
	
	/*
	 * Methode pour autoriser la connection d'un client (en retournant son objet
	 * associé)
	 */
	public Client connectionClient(String identifiantConnexion, String motDePasse) {
		return clientDao.findByIdentifiantConnexionAndMotDePasse(identifiantConnexion, motDePasse);
	}

	// Methode pour ajouter une ligne de panier au panier d'un client. Retourne la ligne de panier concernée
	public LignePanier ajouterLignePanier(int idClient, int idProduit, int quantiteSouhaitee) throws Exception {
		LignePanierService lignePanierService = new LignePanierService();
		
		LignePanier lignePanierPresente = lignePanierService.findByClientAndProduit(idClient, idProduit);
		if (lignePanierPresente != null) { // En cas de sur-ajout.	
			int quantiteSouhaiteePresente = lignePanierPresente.getQuantiteSouhaitee();
			lignePanierPresente.setQuantiteSouhaitee(quantiteSouhaiteePresente + quantiteSouhaitee);
			return lignePanierService.update(lignePanierPresente);
		} else { 
			LignePanier nouvelleLignePanier = new LignePanier(quantiteSouhaitee, idClient, idProduit);
			return lignePanierService.save(nouvelleLignePanier);
		}
	}

	// Methode pour supprimer une ligne de panier au panier d'un client
	public void supprimerLignePanier(LignePanier lignePanier) throws Exception {
		LignePanierService lignePanierService = new LignePanierService();
		
		lignePanierService.remove(lignePanier);
	}

	/* Methode pour modifier la quantite souhaitee de produit d'une ligne de panier
	 * au panier d'un client. Retourne la ligne de panier mise à jour
	 */
	public LignePanier modifierLignePanier(LignePanier lignePanier, int quantiteSouhaitee) throws Exception {
		LignePanierService lignePanierService = new LignePanierService();
		
		lignePanier.setQuantiteSouhaitee(quantiteSouhaitee);
		return lignePanierService.update(lignePanier);
	}

	// Methode pour vider entièrement le panier
	public void viderPanier(int idClient) throws Exception {
		LignePanierService lignePanierService = new LignePanierService();
		
		lignePanierService.removeByClient(idClient);
	}

	// Methode pour verifier qu'un panier est toujours valide
	public ArrayList<LignePanier> verifierPanier(int idClient) throws Exception {
		LignePanierService lignePanierService = new LignePanierService();
	
		ArrayList<LignePanier> lignesPanier = lignePanierService.findByClient(idClient);
		ArrayList<LignePanier> lignesPanierVerifiees = new ArrayList<LignePanier>();
		
		for (LignePanier lignePanier : lignesPanier) {
			LignePanier lignePanierVerifiee = lignePanierService.checkQuantiteSouhaitee(lignePanier);
			if (lignePanierVerifiee != null) {
				lignesPanierVerifiees.add(lignePanierVerifiee);
			}
		}
		return lignesPanierVerifiees;
	}

	// Methode statique pour valider le panier et le transformer en commande
	public ArrayList<LigneCommande> validerPanier(int idClient) throws Exception {
		CommandeService commandeService = new CommandeService();
		ProduitService produitService = new ProduitService();
		LigneCommandeService ligneCommandeService = new LigneCommandeService();
		
		ArrayList<LignePanier> lignesPanier = verifierPanier(idClient);
		
		ArrayList<Integer> idLignesCommande = new ArrayList<Integer>();
		Commande commande = new Commande(idClient, idLignesCommande, new Date(System.currentTimeMillis()));
		commande = commandeService.save(commande);
		if (commande == null) {
			throw new Exception("Erreur : La nouvelle commande n'a pas été sauvegardée");
		}
		
		ArrayList<LigneCommande> lignesCommande = new ArrayList<LigneCommande>();
				
		for (LignePanier lignPani : lignesPanier) {
			Produit produit = produitService.findById(lignPani.getIdProduit());
			
			LigneCommande ligneCommande = new LigneCommande(lignPani.getQuantiteSouhaitee(), commande.getId(), produit.getId(), produit.getPrixUnitaire());
			ligneCommande = ligneCommandeService.save(ligneCommande);
			if (ligneCommande == null) {
				throw new Exception("Erreur : La nouvelle ligne de commande n'a pas été sauvegardée");
			}
			lignesCommande.add(ligneCommande);

			produit.setQuantiteEnStock(produit.getQuantiteEnStock() - lignPani.getQuantiteSouhaitee());
			produit = produitService.update(produit);
		}
		viderPanier(idClient);
		
		return lignesCommande;
	}

}
