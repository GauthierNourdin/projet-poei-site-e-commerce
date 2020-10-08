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
		 * On compare l'id du client dans la liste avec l'id du client que l'on a envoyé
		 * en entrée. Si on obtient une correspondance, on enlève le client avec cet id
		 * de la liste et on rajoute le client en entrée. Seul le premier client ayant
		 * cet id sera éliminé. La fonction retourne "true" si on a pu procéder au
		 * remplacement, "false" sinon.
		 */
		for (Client clientIndividuel : this.clients) {
			if (clientIndividuel.getId() == client.getId()) {
				this.clients.remove(clientIndividuel);
				return this.save(client);
			}
		}
		return false;
	}

	// Méthode pour rendre la liste complète (convention de nommage)
	public ArrayList<Client> findAll() {
		return this.clients;
	}

	// Méthode pour trouver dans la liste un client d'id connu
	public Client findById(String id) {
		for (Client clientIndividuel : this.clients) {
			if (clientIndividuel.getId() == id) {
				return clientIndividuel;
			}
		}
		return null;
	}

	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "ClientService [clients=" + this.clients + "]";
	}

}
