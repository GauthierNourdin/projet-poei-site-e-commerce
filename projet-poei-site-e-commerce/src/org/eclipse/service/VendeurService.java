package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.Vendeur;

public class VendeurService {
	/*
	 * Cet attribut ne doit être initialisé qu'une seule fois. Le rendre
	 * statique permet de le générer au début de l'exécution.
	 */
	private static ArrayList<Vendeur> vendeurs;

	// Constructeur privé pour éviter de créer des instances.
	private VendeurService() {
	}

	// Le getter statique et le setter statique adaptés
	public static ArrayList<Vendeur> getVendeurs() {
		return vendeurs;
	}

	public static void setVendeurs(ArrayList<Vendeur> argVendeurs) {
		vendeurs = argVendeurs;
	}

	// Méthode statique pour ajouter un vendeur dans la liste
	public static boolean save(Vendeur vendeur) {
		/*
		 * On vérifie que le vendeur n'appartient pas déjà à la liste avant de le
		 * rajouter. La méthode retourne "true" si l'ajout a été accompli, "false"
		 * sinon.
		 */
		if (vendeurs.contains(vendeur)) {
			return false;
		} else {
			return vendeurs.add(vendeur);
		}
	}

	// Méthode statique pour retirer un vendeur de la liste
	public static boolean remove(Vendeur vendeur) {
		/*
		 * On vérifie que le vendeur est bien présent dans la liste avant de le
		 * supprimer. La méthode retourne "true" si la suppression a été accomplie,
		 * "false" sinon.
		 */
		if (vendeurs.contains(vendeur)) {
			return vendeurs.remove(vendeur);
		} else {
			return false;
		}
	}

	// Méthode statique pour mettre à jour un vendeur
	public static boolean update(Vendeur vendeur) {
		/*
		 * La méthode retourne true si le client à mettre à jour est dans la liste,
		 * false sinon.
		 */
		for (Vendeur vend: vendeurs) {
			if (vend.getId() == vend.getId()) {
				vend = vendeur;
				return true;
			}
		}
		return false;
	}
	
	// Méthode statique pour rendre la liste complète (convention de nommage)
	public static ArrayList<Vendeur> findAll() {
		return vendeurs;
	}

	// Méthode statique pour trouver dans la liste un vendeur d'id connu
	public static Vendeur findById(int id) {
		for (Vendeur vend: vendeurs) {
			if (vend.getId() == id) {
				return vend;
			}
		}
		return null;
	}
	
	// La méthode sert uniquement au débuggage.
	public static String affichageDebuggage() {
		return "VendeurService [vendeurs=" + vendeurs + "]";
	}

}
