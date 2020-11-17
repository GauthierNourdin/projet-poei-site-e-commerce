//package org.eclipse.test;
//
//import java.util.ArrayList;
//import org.eclipse.model.*;
//import org.eclipse.service.*;
//
//public class TestProduitService {
//
//	public static void main(String[] args) {
//
//		ArrayList<Produit> produitsInitiaux = new ArrayList<Produit>();
//		ProduitService produitService = new ProduitService(produitsInitiaux);
//
//		System.out.println(produitService);
//
//		Adresse adresse = new Adresse("20", "Rue Morel", "Clichy", "92110", "France", "");
//		ArrayList<Adresse> adresses = new ArrayList<Adresse>();
//		adresses.add(adresse);
//		Vendeur vendeur = new Vendeur("00000001", "Gildas", "Pelliet", "gildas.pelliet@sony.com", "0623775150",
//				"GildasPelliet", "ViveLaPlaystation5", adresses);
//		Produit produit1 = new Produit("00000001", "Playstation 5", 499.99, 500,
//				"https.sony.presentation-produits.PS5.image1", "", vendeur);
//		Produit produit2 = new Produit("00000002", "Playstation 4", 149.99, 100,
//				"https.sony.presentation-produits.PS4.image1", "", vendeur);
//		Produit produit3 = new Produit("00000003", "Playstation 3", 79.99, 20,
//				"https.sony.presentation-produits.PS3.image1", "", vendeur);
//		Produit produit4 = new Produit("00000004", "Manette PS5", 59.99, 300,
//				"https.sony.presentation-produits.PS5.image3", "", vendeur);
//
//		if (!produitService.save(produit1))
//			System.out.println("Echec de l'ajout : produit identique d�j� pr�sent");
//		System.out.println(produitService);
//
//		if (!produitService.save(produit2))
//			System.out.println("Echec de l'ajout : produit identique d�j� pr�sent");
//		System.out.println(produitService);
//
//		if (!produitService.save(produit3))
//			System.out.println("Echec de l'ajout : produit identique d�j� pr�sent");
//		System.out.println(produitService);
//
//		if (!produitService.save(produit2))
//			System.out.println("Echec de l'ajout : produit identique d�j� pr�sent");
//		System.out.println(produitService);
//
//		if (!produitService.remove(produit1))
//			System.out.println("Echec de la suppression : ce produit n'est pas pr�sent dans la liste");
//		System.out.println(produitService);
//
//		if (!produitService.remove(produit4))
//			System.out.println("Echec de la suppression : ce produit n'est pas pr�sent dans la liste");
//		System.out.println(produitService);
//
//		produit3.setQuantiteEnStock(30);
//		if (!produitService.update(produit3))
//			System.out.println("Echec de la mise � jour : ce produit n'est pas pr�sent dans la liste");
//		System.out.println(produitService);
//
//		produit4.setPrixUnitaire(49.99);
//		if (!produitService.update(produit4))
//			System.out.println("Echec de la mise � jour : ce produit n'est pas pr�sent dans la liste");
//		System.out.println(produitService);
//
//		ArrayList<Produit> produitsAInstantT = produitService.findAll();
//		System.out.println(produitsAInstantT);
//
//		System.out.println("Le produit ayant pour id : 00000002 est : " + produitService.findById("00000002"));
//		System.out.println("Le produit ayant pour id : 00000004 est : " + produitService.findById("00000004"));
//
//		produitService.findById("00000002").setDescriptionProduit("Console neuve dans sa bo�te d'origine non ouverte");
//		System.out.println(produitService);
//	}
//
//}
