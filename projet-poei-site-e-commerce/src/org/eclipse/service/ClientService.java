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

	// M�thode pour ajouter un client dans la liste
	public boolean save(Client client) {
		/*
		 * On v�rifie que le client n'appartient pas d�j� � la liste avant de le
		 * rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (this.clients.contains(client)) {
			return false;
		} else {
			return this.clients.add(client);
		}
	}

	// M�thode pour retirer un client de la liste
	public boolean remove(Client client) {
		/*
		 * On v�rifie que le client est bien pr�sent dans la liste avant de le
		 * supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (this.clients.contains(client)) {
			return this.clients.remove(client);
		} else {
			return false;
		}
	}

	// M�thode pour mettre � jour un client
	public boolean update(Client client) {
		/*
		 * La m�thode retourne true si le client � mettre � jour est dans la liste,
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

	// M�thode pour rendre la liste compl�te (convention de nommage)
	public ArrayList<Client> findAll() {
		return this.clients;
	}

	// M�thode pour trouver dans la liste un client d'id connu. On doit pouvoir le
	// modifier.
	public Client findById(String id) {
		for (Client clie : this.clients) {
			if (clie.getId() == id) {
				return clie;
			}
		}
		return null;
	}

	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "ClientService [clients=" + this.clients + "]";
	}

}
