package org.eclipse.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.model.Produit;
import org.eclipse.model.Vendeur;

public class VendeurService {
	/*
	 * Cet attribut ne doit etre initialisequ'une seule fois. Le rendre
	 * statique permet de le generer au debut de l'execution.
	 */
	private static ArrayList<Vendeur> vendeurs = new ArrayList<Vendeur>(Arrays.asList(
			new Vendeur("Shepard", "John", "john.shepard@normandy.com", "0194102891",
					"CaptainSR2", "IHateCerberus", new ArrayList<Integer>(Arrays.asList(3))),
			new Vendeur("Dalton", "Joe", "joe.dalton@nevadahsp.us", "0614582185",
					"JoeDalton", "LuckyLuke", new ArrayList<Integer>(Arrays.asList(4))),
			new Vendeur("Wallace", "William", "william.wallace@scotland.sco", "0702616851",
					"TheScotlandGuardian", "Stirling", new ArrayList<Integer>(Arrays.asList(5)))
			));

	// Constructeur prive pour eviter de creer des instances.
	private VendeurService() {
	}

	// Le getter statique et le setter statique adaptes, ne servent qu'aux tests et au débuggage.
	public static ArrayList<Vendeur> getVendeurs() {
		return vendeurs;
	}

	public static void setVendeurs(ArrayList<Vendeur> argVendeurs) {
		vendeurs = argVendeurs;
	}

	// Methode statique pour ajouter un vendeur dans la liste
	public static void save(Vendeur vendeur) throws Exception {
		if (vendeurs.contains(vendeur)) {
			throw new Exception("Le vendeur appartient deja a la liste");
		} else {
			vendeurs.add(vendeur);
		}
	}

	// Methode statique pour retirer un vendeur de la liste
	public static void remove(Vendeur vendeur) throws Exception {
		if (vendeurs.contains(vendeur)) {
			vendeurs.remove(vendeur);
		} else {
			throw new Exception("Le vendeur n'appartient pas a la liste");
		}
	}

	// Methode statique pour mettre a jour un vendeur
	public static void update(Vendeur vendeur) throws Exception {
		for (Vendeur vend: vendeurs) {
			if (vend.getIdVendeur() == vend.getIdVendeur()) {
				vend = vendeur;
				return;
			}
		}
		throw new Exception("Le vendeur n'appartient pas a la liste");
	}
	
	// Methode statique pour rendre la liste complete (convention de nommage)
	public static ArrayList<Vendeur> findAll() {
		return vendeurs;
	}

	// Methode statique pour trouver dans la liste un vendeur d'id connu
	public static Vendeur findById(int id) {
		for (Vendeur vend: vendeurs) {
			if (vend.getIdVendeur() == id) {
				return vend;
			}
		}
		return null;
	}

	// Methode statique pour autoriser la connection d'un vendeur (en retournant son
	// objet associé)
	public static Vendeur connectionVendeur(String identifiantConnexion, String motDePasse) {
		/*
		 * La méthode retourne l'objet Vendeur si l'identifiant de connexion et le mot de
		 * passe donnés en entrée correspondent à ceux enregistrés. Sinon la méthode
		 * retourne null.
		 */
		for (Vendeur vend : vendeurs) {
			if (vend.getIdentifiantConnexion().equals(identifiantConnexion)
					&& vend.getMotDePasse().equals(motDePasse)) {
				return vend;
			}
		}
		return null;
	}

	// Methode statique pour nettoyer un vendeur et ses produits
	public static void retirerVendeur(Vendeur vendeur) throws Exception {
		/*
	     * La methode returne true si tout se déroule correctement, false sinon.
	     */
		ArrayList<Integer> idProduits = vendeur.getIdProduits();
		for (int idProduit : idProduits) {
			Produit produit = ProduitService.findById(idProduit);
			try {
			ProduitService.remove(produit);
			} catch (Exception e) {
				throw new Exception("Echec de la suppression d'un produit, abandon suppression vendeur");
			}
		}
		VendeurService.remove(vendeur);
	}
	
	// La methode sert uniquement au debuggage.
	public static String affichageDebuggage() {
		return "VendeurService [vendeurs=" + vendeurs + "]";
	}

}
