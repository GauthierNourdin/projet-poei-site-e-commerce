package org.eclipse.test;

import java.util.ArrayList;
import org.eclipse.model.*;
import org.eclipse.service.*;

public class TestLignePanierService {

	public static void main(String[] args) {
		
		ArrayList<LignePanier> lignesPanierInitiales = new ArrayList<LignePanier>();
		LignePanierService lignePanierService = new LignePanierService(lignesPanierInitiales);

		System.out.println(lignePanierService);

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
		Panier panier = new Panier("00000001", client);
		Produit produit1 = new Produit("00000001", "Playstation 5", 499.99, 500,
				"https.sony.presentation-produits.PS5.image1", "", vendeur);
		Produit produit2 = new Produit("00000002", "Playstation 4", 149.99, 100,
				"https.sony.presentation-produits.PS4.image1", "", vendeur);
		Produit produit3 = new Produit("00000003", "Playstation 3", 79.99, 20,
				"https.sony.presentation-produits.PS3.image1", "", vendeur);
		Produit produit4 = new Produit("00000004", "Manette PS5", 59.99, 300,
				"https.sony.presentation-produits.PS5.image3", "", vendeur);
		LignePanier lignePanier1 = new LignePanier("00000001", 10, panier, produit1);
		LignePanier lignePanier2 = new LignePanier("00000002", 5, panier, produit2);
		LignePanier lignePanier3 = new LignePanier("00000003", 20, panier, produit3);
		LignePanier lignePanier4 = new LignePanier("00000004", 1, panier, produit4);

		if (!lignePanierService.save(lignePanier1))
			System.out.println("Echec de l'ajout : ligne de panier identique déjà présente");
		System.out.println(lignePanierService);

		if (!lignePanierService.save(lignePanier2))
			System.out.println("Echec de l'ajout : ligne de panier identique déjà présente");
		System.out.println(lignePanierService);

		if (!lignePanierService.save(lignePanier3))
			System.out.println("Echec de l'ajout : ligne de panier identique déjà présente");
		System.out.println(lignePanierService);

		if (!lignePanierService.save(lignePanier2))
			System.out.println("Echec de l'ajout : ligne de panier identique déjà présente");
		System.out.println(lignePanierService);

		if (!lignePanierService.remove(lignePanier1))
			System.out.println("Echec de la suppression : cette ligne de panier n'est pas présente dans la liste");
		System.out.println(lignePanierService);

		if (!lignePanierService.remove(lignePanier4))
			System.out.println("Echec de la suppression : cette ligne de panier n'est pas présente dans la liste");
		System.out.println(lignePanierService);

		lignePanier3.setQuantiteCommandee(15);
		if (!lignePanierService.update(lignePanier3))
			System.out.println("Echec de la mise à jour : cette ligne de panier n'est pas présente dans la liste");
		System.out.println(lignePanierService);

		lignePanier4.setProduit(produit1);
		if (!lignePanierService.update(lignePanier4))
			System.out.println("Echec de la mise à jour : cette ligne de panier n'est pas présente dans la liste");
		System.out.println(lignePanierService);

		ArrayList<LignePanier> lignesPanierAInstantT = lignePanierService.findAll();
		System.out.println(lignesPanierAInstantT);

		System.out.println("La ligne de panier ayant pour id : 00000002 est : " + lignePanierService.findById("00000002"));
		System.out.println("La ligne de panier ayant pour id : 00000004 est : " + lignePanierService.findById("00000004"));

		lignePanierService.findById("00000002").setQuantiteCommandee(10);
		System.out.println(lignePanierService);
	}
	
}
