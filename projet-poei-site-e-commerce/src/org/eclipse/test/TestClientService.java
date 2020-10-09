package org.eclipse.test;

import java.util.ArrayList;
import org.eclipse.model.*;
import org.eclipse.service.*;

public class TestClientService {

	public static void main(String[] args) {

		ArrayList<Client> clientsInitiaux = new ArrayList<Client>();
		ClientService clientService = new ClientService(clientsInitiaux);

		System.out.println(clientService);

		Adresse adresse1 = new Adresse("8", "Avenue Jacques Chirac", "Aix La Chapelle", "84512", "France", "");
		Adresse adresse2 = new Adresse("30", "Rue des elfes", "Lannion", "64021", "France", "");
		Adresse adresse3 = new Adresse("14", "Rue Amiral Ronarc'h", "Quimperlé", "74005", "France", "");
		Adresse adresse4 = new Adresse("1870", "Jack the Ripper street", "London", "0105", "England", "");
		Adresse adresse5 = new Adresse("140", "Rue des cordonniers", "Lyon", "31003", "France", "");
		ArrayList<Adresse> adresses1 = new ArrayList<Adresse>();
		ArrayList<Adresse> adresses2 = new ArrayList<Adresse>();
		ArrayList<Adresse> adresses3 = new ArrayList<Adresse>();
		ArrayList<Adresse> adresses4 = new ArrayList<Adresse>();
		adresses1.add(adresse1);
		adresses2.add(adresse2);
		adresses3.add(adresse3);
		adresses3.add(adresse4);
		adresses4.add(adresse5);
		Client client1 = new Client("00000001", "Durouet", "Etienne", "etienneD@yahoo.fr", "0643246167", "DurouetE",
				"AucuneIdée", adresses1);
		Client client2 = new Client("00000002", "Lescard", "Dominique", "dominique.lescard@gmail.com", "0643213265",
				"DominiqueLescard", "VivelaBretagne!", adresses2);
		Client client3 = new Client("00000003", "Desmoulins", "Francois", "francois.des@sfr.fr", "0761621733",
				"FrancoisDD", "JaimelaBière", adresses3);
		Client client4 = new Client("00000004", "Bouchard", "Paul", "paul.bouchard@orange.fr", "0673413473",
				"Paul-Bouchard", "S3ri3us3m3nt", adresses4);

		if (!clientService.save(client1))
			System.out.println("Echec de l'ajout : client identique déjà présent");
		System.out.println(clientService);

		if (!clientService.save(client2))
			System.out.println("Echec de l'ajout : client identique déjà présent");
		System.out.println(clientService);

		if (!clientService.save(client3))
			System.out.println("Echec de l'ajout : client identique déjà présent");
		System.out.println(clientService);

		if (!clientService.save(client2))
			System.out.println("Echec de l'ajout : client identique déjà présent");
		System.out.println(clientService);
		
		if (!clientService.remove(client1))
			System.out.println("Echec de la suppression : ce client n'est pas présent dans la liste");
		System.out.println(clientService);

		if (!clientService.remove(client4))
			System.out.println("Echec de la suppression : ce client n'est pas présent dans la liste");
		System.out.println(clientService);
		
		client3.setPrenom("Xavier");
		client3.setAdresseMail("xavier.des@sfr.fr");
		if(!clientService.update(client3))
			System.out.println("Echec de la mise à jour : ce client n'est pas présent dans la liste");
		System.out.println(clientService);

		client4.setMotDePasse("FaceJohnCena");
		if (!clientService.update(client4))
			System.out.println("Echec de la mise à jour : ce client n'est pas présent dans la liste");
		System.out.println(clientService);
		
		ArrayList<Client> clientsAInstantT = clientService.findAll();
		System.out.println(clientsAInstantT);

		System.out.println("Le client ayant pour id : 00000002 est : " + clientService.findById("00000002"));
		System.out.println("Le client ayant pour id : 00000004 est : " + clientService.findById("00000004"));

		clientService.findById("00000002").setIdentifiantConnexion("DominiqueLeBreton");
		System.out.println(clientService);
		
		for(Client clie : clientService.getClients()) {
			clie.setNumeroTelephone("");
			clientService.update(clie);
		}
		System.out.println(clientService);
	}

}
