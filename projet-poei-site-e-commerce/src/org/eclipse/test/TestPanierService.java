package org.eclipse.test;

import java.util.ArrayList;
import org.eclipse.model.*;
import org.eclipse.service.*;

public class TestPanierService {

	public static void main(String[] args) {

		ArrayList<Panier> paniersInitiaux = new ArrayList<Panier>();
		PanierService panierService = new PanierService(paniersInitiaux);

		System.out.println(panierService);

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
		Client client3 = new Client("00000003", "Desmoulins", "Francois", "francois.des@sf.fr", "0761621733",
				"FrancoisDD", "JaimelaBière", adresses3);
		Client client4 = new Client("00000004", "Bouchard", "Paul", "paul.bouchard@orange.fr", "0673413473",
				"Paul-Bouchard", "S3ri3us3m3nt", adresses4);
		Panier panier1 = new Panier("00000001", client1);
		Panier panier2 = new Panier("00000002", client2);
		Panier panier3 = new Panier("00000003", client3);
		Panier panier4 = new Panier("00000004", client1);

		if (!panierService.save(panier1))
			System.out.println("Echec de l'ajout : panier identique déjà présent");
		System.out.println(panierService);

		if (!panierService.save(panier2))
			System.out.println("Echec de l'ajout : panier identique déjà présent");
		System.out.println(panierService);

		if (!panierService.save(panier3))
			System.out.println("Echec de l'ajout : panier identique déjà présent");
		System.out.println(panierService);

		if (!panierService.save(panier2))
			System.out.println("Echec de l'ajout : panier identique déjà présent");
		System.out.println(panierService);

		if (!panierService.remove(panier1))
			System.out.println("Echec de la suppression : ce panier n'est pas présent dans la liste");
		System.out.println(panierService);

		if (!panierService.remove(panier4))
			System.out.println("Echec de la suppression : ce panier n'est pas présent dans la liste");
		System.out.println(panierService);

		panier3.setClient(client4);
		if (!panierService.update(panier3))
			System.out.println("Echec de la mise à jour : ce panier n'est pas présent dans la liste");
		System.out.println(panierService);

		panier4.setClient(client3);
		if (!panierService.update(panier4))
			System.out.println("Echec de la mise à jour : ce panier n'est pas présent dans la liste");
		System.out.println(panierService);

		ArrayList<Panier> paniersAInstantT = panierService.findAll();
		System.out.println(paniersAInstantT);

		System.out.println("Le panier ayant pour id : 00000002 est : " + panierService.findById("00000002"));
		System.out.println("Le panier ayant pour id : 00000004 est : " + panierService.findById("00000004"));

		panierService.findById("00000002").setClient(client4);
		System.out.println(panierService);
	}

}
