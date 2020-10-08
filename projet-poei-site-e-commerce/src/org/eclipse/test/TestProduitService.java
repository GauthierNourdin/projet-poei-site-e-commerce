package org.eclipse.test;

import java.util.ArrayList;
import org.eclipse.model.*;
import org.eclipse.service.*;

public class TestProduitService {

	public static void main(String[] args) {

		ArrayList<Produit> produitsInitiaux = new ArrayList<Produit>();
		ProduitService produitService = new ProduitService(produitsInitiaux);
		
		System.out.println(produitService);
		
		Adresse adresse = new Adresse("20", "Rue Morel", "Clichy", "92110", "France", "");
		ArrayList<Adresse> adresses = new ArrayList<Adresse>();
		adresses.add(adresse);
		ArrayList<Produit> produitsVendeur = new ArrayList<Produit>();
		Vendeur vendeur = new Vendeur("00000001", "Gildas", "Pelliet", "gildas.pelliet@sony.com", "0623775150", "GildasPelliet", "ViveLaPlaystation5", adresses, produitsVendeur);
		Produit produit1 = new Produit("00000001", "Playstation 5", 499.99, 500, "https.sony.presentation-produits.PS5.image1", "", vendeur);
		Produit produit2 = new Produit("00000002", "Playstation 4", 149.99, 100, "https.sony.presentation-produits.PS4.image1", "", vendeur);
		Produit produit3 = new Produit("00000003", "Playstation 3", 79.99, 20, "https.sony.presentation-produits.PS3.image1", "", vendeur);
		Produit produit4 = new Produit("00000004", "Manette PS5", 59.99, 300, "https.sony.presentation-produits.PS5.image3", "", vendeur);
		
		if(!produitService.save(produit1)) System.out.println("Echec de l'ajout : produit identique déjà présent");
		System.out.println(produitService);
		
		if(!produitService.save(produit2)) System.out.println("Echec de l'ajout : produit identique déjà présent");
		System.out.println(produitService);
		
		if(!produitService.save(produit3)) System.out.println("Echec de l'ajout : produit identique déjà présent");
		System.out.println(produitService);
		
		if(!produitService.save(produit2)) System.out.println("Echec de l'ajout : produit identique déjà présent");

		if(!produitService.remove(produit1)) System.out.println("Echec de la suppresion du produit : ce produit n'est pas présent dans la liste");
		System.out.println(produitService);
		
		if(!produitService.remove(produit4)) System.out.println("Echec de la suppresion du produit : ce produit n'est pas présent dans la liste");
		
		Produit produit5 = new Produit("00000003", "Playstation 3", 79.99, 30, "https.sony.presentation-produits.PS3.image1", "", vendeur);
		if(!produitService.update(produit5)) System.out.println("Echec de l'update du produit : ce produit n'est pas présent dans la liste");
		System.out.println(produitService);
		
		Produit produit6 = new Produit("00000004", "Manette PS5", 49.99, 300, "https.sony.presentation-produits.PS5.image3", "", vendeur);
		if(!produitService.update(produit6)) System.out.println("Echec de l'update du produit : ce produit n'est pas présent dans la liste");
		
		ArrayList<Produit> produitsAInstantT = produitService.findAll();
		System.out.println(produitsAInstantT);
		
		System.out.println("Le produit ayant pour id : 00000002 est : " + produitService.findById("00000002"));
		System.out.println("Le produit ayant pour id : 00000004 est : " + produitService.findById("00000004"));

	}

}
