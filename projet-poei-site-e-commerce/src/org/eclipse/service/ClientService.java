package org.eclipse.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.model.Client;
import org.eclipse.model.Panier;

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
			if (clie.getId() == client.getId()) {
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
			if (clie.getId() == id) {
				return clie;
			}
		}
		return null;
	}

	// Methode statique pour créer un nouveau client et son panier associé
	public static void ajouterClient(Client client) throws Exception {
		ClientService.save(client);
		Panier panier = new Panier(client.getId());
		PanierService.save(panier);
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

	// Methode statique pour nettoyer un compte client et son panier
	public static void retirerClient(Client client) throws Exception {
		int id = client.getId();
		Panier panier = PanierService.findById(id);
		PanierService.remove(panier);
		ClientService.remove(client);
	}

	// La methode sert uniquement au debuggage.
	public static String affichageDebuggage() {
		return "ClientService [clients=" + clients + "]";
	}

}
