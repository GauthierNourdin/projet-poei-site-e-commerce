package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.Client;

public class ClientService {

	// Attributs
	private ArrayList<Client> clients;

	// Le constructeur
	public ClientService(ArrayList<Client> clients) {
		this.clients = clients;
	}

	// Les getters et les setters classiques
	public ArrayList<Client> getClients() {
		return this.clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	// Méthode pour ajouter un client dans la liste
	public boolean save(Client client) {
		/*
		 * On vérifie que le client n'appartient pas déjà à la liste avant de le
		 * rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (this.clients.contains(client)) {
			return false;
		} else {
			return this.clients.add(client);
		}
	}

	// Méthode pour retirer un client de la liste
	public boolean remove(Client client) {
		/*
		 * On vérifie que le client est bien présent dans la liste avant de le
		 * supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (this.clients.contains(client)) {
			return this.clients.remove(client);
		} else {
			return false;
		}
	}

	// Méthode pour mettre à jour un client
	public boolean update(Client client) {
		/*
		 * La méthode retourne true si le client à mettre à jour est dans la liste,
		 * false sinon.
		 */
		for (Client clie : this.clients) {
			if (clie.getId() == client.getId()) {
				clie = client;
				return true;
			}
		}
		return false;
	}

	// Méthode pour rendre la liste complète (convention de nommage)
	public ArrayList<Client> findAll() {
		return this.clients;
	}

	// Méthode pour trouver dans la liste un client d'id connu. On doit pouvoir le
	// modifier.
	public Client findById(String id) {
		for (Client clie : this.clients) {
			if (clie.getId() == id) {
				return clie;
			}
		}
		return null;
	}

	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "ClientService [clients=" + this.clients + "]";
	}

}
