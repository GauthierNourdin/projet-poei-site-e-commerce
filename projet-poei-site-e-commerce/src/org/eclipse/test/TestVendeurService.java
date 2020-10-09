package org.eclipse.test;

import java.util.ArrayList;
import org.eclipse.model.*;
import org.eclipse.service.*;

public class TestVendeurService {

	public static void main(String[] args) {

		ArrayList<Vendeur> vendeursInitiaux = new ArrayList<Vendeur>();
		VendeurService vendeurService = new VendeurService(vendeursInitiaux);

		System.out.println(vendeurService);

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
		Vendeur vendeur1 = new Vendeur("00000001", "Durouet", "Etienne", "etienneD@yahoo.fr", "0643246167", "DurouetE",
				"AucuneIdée", adresses1);
		Vendeur vendeur2 = new Vendeur("00000002", "Lescard", "Dominique", "dominique.lescard@gmail.com", "0643213265",
				"DominiqueLescard", "VivelaBretagne!", adresses2);
		Vendeur vendeur3 = new Vendeur("00000003", "Desmoulins", "Francois", "francois.des@sf.fr", "0761621733",
				"FrancoisDD", "JaimelaBière", adresses3);
		Vendeur vendeur4 = new Vendeur("00000004", "Bouchard", "Paul", "paul.bouchard@orange.fr", "0673413473",
				"Paul-Bouchard", "S3ri3us3m3nt", adresses4);

		if (!vendeurService.save(vendeur1))
			System.out.println("Echec de l'ajout : vendeur identique déjà présent");
		System.out.println(vendeurService);

		if (!vendeurService.save(vendeur2))
			System.out.println("Echec de l'ajout : vendeur identique déjà présent");
		System.out.println(vendeurService);

		if (!vendeurService.save(vendeur3))
			System.out.println("Echec de l'ajout : vendeur identique déjà présent");
		System.out.println(vendeurService);

		if (!vendeurService.save(vendeur2))
			System.out.println("Echec de l'ajout : vendeur identique déjà présent");
		System.out.println(vendeurService);

		if (!vendeurService.remove(vendeur1))
			System.out.println("Echec de la suppresion : ce vendeur n'est pas présent dans la liste");
		System.out.println(vendeurService);

		if (!vendeurService.remove(vendeur4))
			System.out.println("Echec de la suppresion : ce vendeur n'est pas présent dans la liste");
		System.out.println(vendeurService);

		vendeur3.setPrenom("Xavier");
		vendeur3.setAdresseMail("xavier.des@sfr.fr");
		if (!vendeurService.update(vendeur3))
			System.out.println("Echec de la mise à jour : ce vendeur n'est pas présent dans la liste");
		System.out.println(vendeurService);

		vendeur4.setMotDePasse("FaceJohnCena");
		if (!vendeurService.update(vendeur4))
			System.out.println("Echec de la mise à jour : ce vendeur n'est pas présent dans la liste");
		System.out.println(vendeurService);

		ArrayList<Vendeur> vendeursAInstantT = vendeurService.findAll();
		System.out.println(vendeursAInstantT);

		System.out.println("Le vendeur ayant pour id : 00000002 est : " + vendeurService.findById("00000002"));
		System.out.println("Le vendeur ayant pour id : 00000004 est : " + vendeurService.findById("00000004"));

		vendeurService.findById("00000002").setIdentifiantConnexion("DominiqueLeBreton");
		System.out.println(vendeurService);

	}

}
