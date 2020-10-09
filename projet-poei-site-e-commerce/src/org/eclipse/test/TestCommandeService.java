package org.eclipse.test;

import java.sql.Date;
import java.util.ArrayList;
import org.eclipse.model.*;
import org.eclipse.service.*;

public class TestCommandeService {

	public static void main(String[] args) {

		ArrayList<Commande> commandesInitiales = new ArrayList<Commande>();
		CommandeService commandeService = new CommandeService(commandesInitiales);

		System.out.println(commandeService);

		Adresse adresse1 = new Adresse("8", "Avenue Jacques Chirac", "Aix La Chapelle", "84512", "France", "");
		Adresse adresse2 = new Adresse("30", "Rue des elfes", "Lannion", "64021", "France", "");
		Adresse adresse3 = new Adresse("14", "Rue Amiral Ronarc'h", "Quimperlé", "74005", "France", "");
		Adresse adresse4 = new Adresse("140", "Rue des cordonniers", "Lyon", "31003", "France", "");
		ArrayList<Adresse> adresses1 = new ArrayList<Adresse>();
		ArrayList<Adresse> adresses2 = new ArrayList<Adresse>();
		ArrayList<Adresse> adresses3 = new ArrayList<Adresse>();
		ArrayList<Adresse> adresses4 = new ArrayList<Adresse>();
		adresses1.add(adresse1);
		adresses2.add(adresse2);
		adresses3.add(adresse3);
		adresses4.add(adresse4);
		Client client1 = new Client("00000001", "Durouet", "Etienne", "etienneD@yahoo.fr", "0643246167", "DurouetE",
				"AucuneIdée", adresses1);
		Client client2 = new Client("00000002", "Lescard", "Dominique", "dominique.lescard@gmail.com", "0643213265",
				"DominiqueLescard", "VivelaBretagne!", adresses2);
		Client client3 = new Client("00000003", "Desmoulins", "Francois", "francois.des@sf.fr", "0761621733",
				"FrancoisDD", "JaimelaBière", adresses3);
		Client client4 = new Client("00000004", "Bouchard", "Paul", "paul.bouchard@orange.fr", "0673413473",
				"Paul-Bouchard", "S3ri3us3m3nt", adresses4);
		Date date1 = new Date(12154542112L);
		Date date2 = new Date(15413165451L);
		Date date3 = new Date(14113265843L);
		Date date4 = new Date(15483264310L);
		Commande commande1 = new Commande("00000001", client1, date1);
		Commande commande2 = new Commande("00000002", client2, date2);
		Commande commande3 = new Commande("00000003", client3, date3);
		Commande commande4 = new Commande("00000004", client1, date4);

		if (!commandeService.save(commande1))
			System.out.println("Echec de l'ajout : commande identique déjà présente");
		System.out.println(commandeService);

		if (!commandeService.save(commande2))
			System.out.println("Echec de l'ajout : commande identique déjà présente");
		System.out.println(commandeService);

		if (!commandeService.save(commande3))
			System.out.println("Echec de l'ajout : commande identique déjà présente");
		System.out.println(commandeService);

		if (!commandeService.save(commande2))
			System.out.println("Echec de l'ajout : commande identique déjà présente");
		System.out.println(commandeService);

		if (!commandeService.remove(commande1))
			System.out.println("Echec de la suppression : cette commande n'est pas présente dans la liste");
		System.out.println(commandeService);

		if (!commandeService.remove(commande4))
			System.out.println("Echec de la suppression : cette commande n'est pas présente dans la liste");
		System.out.println(commandeService);

		Date date5 = new Date(1753707750L);
		commande3.setDateDeCommande(date5);
		if (!commandeService.update(commande3))
			System.out.println("Echec de la mise à jour : cette commande n'est pas présente dans la liste");
		System.out.println(commandeService);

		commande4.setClient(client4);
		if (!commandeService.update(commande4))
			System.out.println("Echec de la mise à jour : cette commande n'est pas présente dans la liste");
		System.out.println(commandeService);

		ArrayList<Commande> commandesAInstantT = commandeService.findAll();
		System.out.println(commandesAInstantT);

		System.out.println("La commande ayant pour id : 00000002 est : " + commandeService.findById("00000002"));
		System.out.println("La commande ayant pour id : 00000004 est : " + commandeService.findById("00000004"));

		commandeService.findById("00000002").setClient(client4);
		System.out.println(commandeService);
	}

}
