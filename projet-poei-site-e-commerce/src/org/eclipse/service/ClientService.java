package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.Client;

public class ClientService {
	/*
	 * Cet attribut ne doit être initialisé qu'une seule fois. Le rendre statique
	 * permet de le générer au début de l'exécution.
	 */
	private static ArrayList<Client> clients;

	// Constructeur privé pour éviter de créer des instances.
	private ClientService() {
	}

	// Le getter statique et le setter statique adaptés
	public static ArrayList<Client> getClients() {
		return clients;
	}

	public static void setClients(ArrayList<Client> argClients) {
		clients = argClients;
	}

	// Méthode statique pour ajouter un client dans la liste
	public static boolean save(Client client) {
		/*
		 * On vérifie que le client n'appartient pas déjà à la liste avant de le
		 * rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (clients.contains(client)) {
			return false;
		} else {
			return clients.add(client);
		}
	}

	// Méthode statique pour retirer un client de la liste
	public static boolean remove(Client client) {
		/*
		 * On vérifie que le client est bien présent dans la liste avant de le
		 * supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (clients.contains(client)) {
			return clients.remove(client);
		} else {
			return false;
		}
	}

	// Méthode statique pour mettre à jour un client
	public static boolean update(Client client) {
		/*
		 * La méthode retourne true si le client à mettre à jour est dans la liste,
		 * false sinon.
		 */
		for (Client clie : clients) {
			if (clie.getId() == client.getId()) {
				clie = client;
				return true;
			}
		}
		return false;
	}

	// Méthode statique pour rendre la liste complète (convention de nommage)
	public static ArrayList<Client> findAll() {
		return clients;
	}

	// Méthode statique pour trouver dans la liste un client d'id connu.
	public static Client findById(int id) {
		for (Client clie : clients) {
			if (clie.getId() == id) {
				return clie;
			}
		}
		return null;
	}

	/*
	 * // Méthode pour ajouter une ligne de panier au panier d'un client public void
	 * ajouterLignePanier(Panier panier, Produit produit, int quantiteSouhaitee,
	 * LignePanierService lignePanierService, PanierService panierService,
	 * ClientService clientService, GestionnaireId gestionnaireId) { for
	 * (LignePanier lignPani : panier.getLignesPanier()) { if
	 * (lignPani.getProduit().getId() == produit.getId()) {
	 * 
	 * Vérification que le produit que l'on veut ajouter au panier n'en fait pas
	 * déjà partie.
	 * 
	 * if (quantiteSouhaitee + lignPani.getQuantiteCommandee() <
	 * produit.getQuantiteEnStock()) {
	 * 
	 * Vérification que la quantité que l'on va commander ne dépasse pas le stock
	 * disponible
	 * 
	 * lignPani.setQuantiteCommandee(produit.getQuantiteEnStock()); } else {
	 * lignPani.setQuantiteCommandee(quantiteSouhaitee +
	 * lignPani.getQuantiteCommandee()); }
	 * 
	 * Maintenant que la quantité à commander a été ajustée, on va mettre à jour la
	 * base de données. On doit vérifier que cette quantité est non nulle.
	 * 
	 * lignePanierService.update(lignPani); panierService.update(panier);
	 * clientService.update(panier.getClient()); return; // Arrêt de l'exécution. }
	 * } // Si on n'a pas modifié une ligne de papier, il faut en créer une.
	 * LignePanier lignePanier = new
	 * LignePanier(gestionnaireId.giveNewIdLignePanier(), quantiteSouhaitee, panier,
	 * produit); // Ajout de la ligne de panier à la base de données
	 * lignePanierService.save(lignePanier); // Mise à jour de la base de données
	 * panier et client panierService.update(panier);
	 * clientService.update(panier.getClient()); }
	 * 
	 * // Méthode pour vider complètement un panier public void viderPanier(Panier
	 * panier, LignePanierService lignePanierService, PanierService panierService,
	 * ClientService clientService) { ArrayList<LignePanier> lignesPanier =
	 * panier.getLignesPanier(); // Mise à jour de la base de données : suppression
	 * des lignes de panier. for (LignePanier lignePanier : lignesPanier) {
	 * lignePanierService.remove(lignePanier); } // Mise à jour de la base de
	 * données panier et client. panierService.update(panier);
	 * clientService.update(panier.getClient()); }
	 * 
	 * // Méthode pour valider un panier et le transformer en une commande public
	 * void validerPanier(Panier panier, LignePanierService lignePanierService,
	 * PanierService panierService, LigneCommandeService ligneCommandeService,
	 * CommandeService commandeService, ClientService clientService, ProduitService
	 * produitService, VendeurService vendeurService, GestionnaireId gestionnaireId)
	 * { // On vérifie une dernière fois la disponibilité des produits du panier
	 * verifierDisponibilitePanier(panier, lignePanierService, panierService,
	 * clientService); // On vérifie qu'il y ait au moins une ligne de panier
	 * valide.
	 * 
	 * // On vide le panier (mise à jour bases de données panier et client incluses)
	 * panierService.viderPanier(panier, lignePanierService, panierService,
	 * clientService); }
	 * 
	 * // Méthode pour vérifier à tout moment la disponibilité des éléments du
	 * panier public boolean verifierDisponibilitePanier(Panier panier,
	 * LignePanierService lignePanierService, PanierService panierService,
	 * ClientService clientService) { //
	 * 
	 * 
	 * // On supprime les éléments de la return true; }
	 */

	// La méthode sert uniquement au débuggage.
	public static String affichageDebuggage() {
		return "ClientService [clients=" + clients + "]";
	}

}
