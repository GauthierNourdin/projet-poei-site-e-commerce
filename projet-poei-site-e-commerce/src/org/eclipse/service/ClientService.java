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
		 * On compare l'id du client dans la liste avec l'id du client que l'on a envoy�
		 * en entr�e. Si on obtient une correspondance, on enl�ve le client avec cet id
		 * de la liste et on rajoute le client en entr�e. Seul le premier client ayant
		 * cet id sera �limin�. La fonction retourne "true" si on a pu proc�der au
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

	// M�thode pour rendre la liste compl�te (convention de nommage)
	public ArrayList<Client> findAll() {
		return this.clients;
	}

	// M�thode pour trouver dans la liste un client d'id connu
	public Client findById(String id) {
		for (Client clientIndividuel : this.clients) {
			if (clientIndividuel.getId() == id) {
				return clientIndividuel;
			}
		}
		return null;
	}

	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "ClientService [clients=" + this.clients + "]";
	}

}
