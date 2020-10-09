package org.eclipse.test;

import java.sql.Date;
import java.util.ArrayList;
import org.eclipse.model.*;
import org.eclipse.service.*;

public class TestLigneCommandeService {

	public static void main(String[] args) {

		ArrayList<LigneCommande> lignesCommandeInitiales = new ArrayList<LigneCommande>();
		LigneCommandeService ligneCommandeService = new LigneCommandeService(lignesCommandeInitiales);

		System.out.println(ligneCommandeService);

		Adresse adresse1 = new Adresse("8", "Avenue Jacques Chirac", "Aix La Chapelle", "84512", "France", "");
		Adresse adresse2 = new Adresse("30", "Rue des elfes", "Lannion", "64021", "France", "");
		ArrayList<Adresse> adresses1 = new ArrayList<Adresse>();
		ArrayList<Adresse> adresses2 = new ArrayList<Adresse>();
		adresses1.add(adresse1);
		adresses2.add(adresse2);
		Client client = new Client("00000001", "Durouet", "Etienne", "etienneD@yahoo.fr", "0643246167", "DurouetE",
				"AucuneIdée", adresses1);
		Vendeur vendeur = new Vendeur("00000002", "Lescard", "Dominique", "dominique.lescard@gmail.com", "0643213265",
				"DominiqueLescard", "VivelaBretagne!", adresses2);
		Date date = new Date(12154542112L);
		Commande commande = new Commande("00000001", client, date);
		Produit produit1 = new Produit("00000001", "Playstation 5", 499.99, 500,
				"https.sony.presentation-produits.PS5.image1", "", vendeur);
		Produit produit2 = new Produit("00000002", "Playstation 4", 149.99, 100,
				"https.sony.presentation-produits.PS4.image1", "", vendeur);
		Produit produit3 = new Produit("00000003", "Playstation 3", 79.99, 20,
				"https.sony.presentation-produits.PS3.image1", "", vendeur);
		Produit produit4 = new Produit("00000004", "Manette PS5", 59.99, 300,
				"https.sony.presentation-produits.PS5.image3", "", vendeur);
		LigneCommande ligneCommande1 = new LigneCommande("00000001", 10, commande, produit1);
		LigneCommande ligneCommande2 = new LigneCommande("00000002", 5, commande, produit2);
		LigneCommande ligneCommande3 = new LigneCommande("00000003", 20, commande, produit3);
		LigneCommande ligneCommande4 = new LigneCommande("00000004", 1, commande, produit4);

		if (!ligneCommandeService.save(ligneCommande1))
			System.out.println("Echec de l'ajout : ligne de commande identique déjà présente");
		System.out.println(ligneCommandeService);

		if (!ligneCommandeService.save(ligneCommande2))
			System.out.println("Echec de l'ajout : ligne de commande identique déjà présente");
		System.out.println(ligneCommandeService);

		if (!ligneCommandeService.save(ligneCommande3))
			System.out.println("Echec de l'ajout : ligne de commande identique déjà présente");
		System.out.println(ligneCommandeService);

		if (!ligneCommandeService.save(ligneCommande2))
			System.out.println("Echec de l'ajout : ligne de commande identique déjà présente");
		System.out.println(ligneCommandeService);
		
		if (!ligneCommandeService.remove(ligneCommande1))
			System.out.println("Echec de la suppression : cette ligne de commande n'est pas présente dans la liste");
		System.out.println(ligneCommandeService);

		if (!ligneCommandeService.remove(ligneCommande4))
			System.out.println("Echec de la suppression : cette ligne de commande n'est pas présente dans la liste");
		System.out.println(ligneCommandeService);
		
		ligneCommande3.setQuantiteCommandee(15);
		if (!ligneCommandeService.update(ligneCommande3))
			System.out.println("Echec de la mise à jour : cette ligne de commande n'est pas présente dans la liste");
		System.out.println(ligneCommandeService);

		ligneCommande4.setProduit(produit1);
		if (!ligneCommandeService.update(ligneCommande4))
			System.out.println("Echec de la mise à jour : cette ligne de commande n'est pas présente dans la liste");
		System.out.println(ligneCommandeService);

		ArrayList<LigneCommande> lignesCommandesAInstantT = ligneCommandeService.findAll();
		System.out.println(lignesCommandesAInstantT);

		System.out.println("La ligne de commande ayant pour id : 00000002 est : " + ligneCommandeService.findById("00000002"));
		System.out.println("La ligne de commande ayant pour id : 00000004 est : " + ligneCommandeService.findById("00000004"));

		ligneCommandeService.findById("00000002").setQuantiteCommandee(10);
		System.out.println(ligneCommandeService);
	}

}
