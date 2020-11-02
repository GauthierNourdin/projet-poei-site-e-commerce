package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.Client;

public class ClientService {
	/*
	 * Cet attribut ne doit �tre initialis� qu'une seule fois. Le rendre statique
	 * permet de le g�n�rer au d�but de l'ex�cution.
	 */
	private static ArrayList<Client> clients;

	// Constructeur priv� pour �viter de cr�er des instances.
	private ClientService() {
	}

	// Le getter statique et le setter statique adapt�s
	public static ArrayList<Client> getClients() {
		return clients;
	}

	public static void setClients(ArrayList<Client> argClients) {
		clients = argClients;
	}

	// M�thode statique pour ajouter un client dans la liste
	public static boolean save(Client client) {
		/*
		 * On v�rifie que le client n'appartient pas d�j� � la liste avant de le
		 * rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (clients.contains(client)) {
			return false;
		} else {
			return clients.add(client);
		}
	}

	// M�thode statique pour retirer un client de la liste
	public static boolean remove(Client client) {
		/*
		 * On v�rifie que le client est bien pr�sent dans la liste avant de le
		 * supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (clients.contains(client)) {
			return clients.remove(client);
		} else {
			return false;
		}
	}

	// M�thode statique pour mettre � jour un client
	public static boolean update(Client client) {
		/*
		 * La m�thode retourne true si le client � mettre � jour est dans la liste,
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

	// M�thode statique pour rendre la liste compl�te (convention de nommage)
	public static ArrayList<Client> findAll() {
		return clients;
	}

	// M�thode statique pour trouver dans la liste un client d'id connu.
	public static Client findById(int id) {
		for (Client clie : clients) {
			if (clie.getId() == id) {
				return clie;
			}
		}
		return null;
	}

	/*
	 * // M�thode pour ajouter une ligne de panier au panier d'un client public void
	 * ajouterLignePanier(Panier panier, Produit produit, int quantiteSouhaitee,
	 * LignePanierService lignePanierService, PanierService panierService,
	 * ClientService clientService, GestionnaireId gestionnaireId) { for
	 * (LignePanier lignPani : panier.getLignesPanier()) { if
	 * (lignPani.getProduit().getId() == produit.getId()) {
	 * 
	 * V�rification que le produit que l'on veut ajouter au panier n'en fait pas
	 * d�j� partie.
	 * 
	 * if (quantiteSouhaitee + lignPani.getQuantiteCommandee() <
	 * produit.getQuantiteEnStock()) {
	 * 
	 * V�rification que la quantit� que l'on va commander ne d�passe pas le stock
	 * disponible
	 * 
	 * lignPani.setQuantiteCommandee(produit.getQuantiteEnStock()); } else {
	 * lignPani.setQuantiteCommandee(quantiteSouhaitee +
	 * lignPani.getQuantiteCommandee()); }
	 * 
	 * Maintenant que la quantit� � commander a �t� ajust�e, on va mettre � jour la
	 * base de donn�es. On doit v�rifier que cette quantit� est non nulle.
	 * 
	 * lignePanierService.update(lignPani); panierService.update(panier);
	 * clientService.update(panier.getClient()); return; // Arr�t de l'ex�cution. }
	 * } // Si on n'a pas modifi� une ligne de papier, il faut en cr�er une.
	 * LignePanier lignePanier = new
	 * LignePanier(gestionnaireId.giveNewIdLignePanier(), quantiteSouhaitee, panier,
	 * produit); // Ajout de la ligne de panier � la base de donn�es
	 * lignePanierService.save(lignePanier); // Mise � jour de la base de donn�es
	 * panier et client panierService.update(panier);
	 * clientService.update(panier.getClient()); }
	 * 
	 * // M�thode pour vider compl�tement un panier public void viderPanier(Panier
	 * panier, LignePanierService lignePanierService, PanierService panierService,
	 * ClientService clientService) { ArrayList<LignePanier> lignesPanier =
	 * panier.getLignesPanier(); // Mise � jour de la base de donn�es : suppression
	 * des lignes de panier. for (LignePanier lignePanier : lignesPanier) {
	 * lignePanierService.remove(lignePanier); } // Mise � jour de la base de
	 * donn�es panier et client. panierService.update(panier);
	 * clientService.update(panier.getClient()); }
	 * 
	 * // M�thode pour valider un panier et le transformer en une commande public
	 * void validerPanier(Panier panier, LignePanierService lignePanierService,
	 * PanierService panierService, LigneCommandeService ligneCommandeService,
	 * CommandeService commandeService, ClientService clientService, ProduitService
	 * produitService, VendeurService vendeurService, GestionnaireId gestionnaireId)
	 * { // On v�rifie une derni�re fois la disponibilit� des produits du panier
	 * verifierDisponibilitePanier(panier, lignePanierService, panierService,
	 * clientService); // On v�rifie qu'il y ait au moins une ligne de panier
	 * valide.
	 * 
	 * // On vide le panier (mise � jour bases de donn�es panier et client incluses)
	 * panierService.viderPanier(panier, lignePanierService, panierService,
	 * clientService); }
	 * 
	 * // M�thode pour v�rifier � tout moment la disponibilit� des �l�ments du
	 * panier public boolean verifierDisponibilitePanier(Panier panier,
	 * LignePanierService lignePanierService, PanierService panierService,
	 * ClientService clientService) { //
	 * 
	 * 
	 * // On supprime les �l�ments de la return true; }
	 */

	// La m�thode sert uniquement au d�buggage.
	public static String affichageDebuggage() {
		return "ClientService [clients=" + clients + "]";
	}

}
