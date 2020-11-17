package org.eclipse.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.model.Categorie;

public class CategorieService {
	/*
	 * Cet attribut ne doit etre initialise qu'une seule fois. Le rendre
	 * statique permet de le generer au debut de l'execution.
	 */
	private static ArrayList<Categorie> categories = new ArrayList<Categorie>(Arrays.asList(
			new Categorie("figurine"),
			new Categorie("jeu video"),
			new Categorie("livre"),
			new Categorie("poster"),
			new Categorie("bande dessinee"),
			new Categorie("film"),
			new Categorie("reproduction d'arme")
			));

	// Constructeur prive pour eviter de creer des instances.
	private CategorieService() {
	}

	// Le getter statique et le setter statique adaptes, ne servent qu'aux tests et au débuggage.
	public static ArrayList<Categorie> getCategories() {
		return categories;
	}

	public static void setCategories(ArrayList<Categorie> argCategories) {
		categories = argCategories;
	}

	// Methode statique pour ajouter une categorie dans la liste
	public static void save(Categorie categorie) throws Exception {
		if (categories.contains(categorie)) {
			throw new Exception("La categorie appartient deja a la liste");
		} else {
			categories.add(categorie);
		}
	}

	// Méthode statique pour retirer une commande de la liste
	public static void remove(Categorie categorie) throws Exception {
		if (categories.contains(categorie)) {
			categories.remove(categorie);
		} else {
			throw new Exception("La categorie n'appartient pas a la liste");
		}
	}

	// Methode statique pour mettre a jour une commande
	public static void update(Categorie categorie) throws Exception {
		for (Categorie cate : categories) {
			if (cate.getId() == categorie.getId()) {
				cate = categorie;
				return;
			}
		}
		throw new Exception("La categorie n'appartient pas a la liste");
	}

	// Méthode statique pour rendre la liste complete (convention de nommage)
	public static ArrayList<Categorie> findAll() {
		return categories;
	}

	// Methode statique pour trouver dans la liste une categorie d'id connu
	public static Categorie findById(int id) {
		for (Categorie cate : categories) {
			if (cate.getId() == id) {
				return cate;
			}
		}
		return null;
	}

	// La methode sert uniquement au debuggage.
	public static String affichageDebuggage() {
		return "ClientService [categories=" + categories + "]";
	}
	
}
