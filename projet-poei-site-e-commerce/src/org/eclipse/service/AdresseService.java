package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.Adresse;
import org.eclipse.model.Categorie;

public class AdresseService {
	/*
	 * Cet attribut ne doit etre initialise qu'une seule fois. Le rendre
	 * statique permet de le generer au debut de l'execution.
	 */
	private static ArrayList<Adresse> adresses = new ArrayList<Adresse>();

	// Constructeur prive pour eviter de creer des instances.
	private AdresseService() {
	}

	// Le getter statique et le setter statique adaptes, ne servent qu'aux tests et au débuggage.
	public static ArrayList<Adresse> getCategories() {
		return adresses;
	}

	public static void setCategories(ArrayList<Adresse> argAdresses) {
		adresses = argAdresses;
	}

	// Methode statique pour ajouter une adresse dans la liste
	public static void save(Adresse adresse) throws Exception {
		if (adresses.contains(adresse)) {
			throw new Exception("L'adresse appartient deja a la liste");
		} else {
			adresses.add(adresse);
		}
	}

	// Méthode statique pour retirer une adresse de la liste
	public static void remove(Adresse adresse) throws Exception {
		if (adresses.contains(adresse)) {
			adresses.remove(adresse);
		} else {
			throw new Exception("L'adresse n'appartient pas a la liste");
		}
	}

	// Methode statique pour mettre a jour une adresse
	public static void update(Adresse adresse) throws Exception {
		for (Adresse adre : adresses) {
			if (adre.getId() == adresse.getId()) {
				adre = adresse;
				return;
			}
		}
		throw new Exception("La categorie n'appartient pas a la liste");
	}

	// Méthode statique pour rendre la liste complete (convention de nommage)
	public static ArrayList<Adresse> findAll() {
		return adresses;
	}

	// Methode statique pour trouver dans la liste une adresse d'id connu
	public static Adresse findById(int id) {
		for (Adresse adre : adresses) {
			if (adre.getId() == id) {
				return adre;
			}
		}
		return null;
	}

	// Methode statique pour trouver les adresses d'un utilisateur
	public static ArrayList<Adresse> findByUtilisateur(int idUtilisateur) {
		ArrayList<Adresse> resAdresses = new ArrayList<Adresse>();
		for (Adresse adre : adresses) {
			if (adre.getIdUtilisateur() == idUtilisateur) {
				resAdresses.add(adre);
			}
		}
		return resAdresses;
	}
	
	// La methode sert uniquement au debuggage.
	public static String affichageDebuggage() {
		return "AdresseService [adresses=" + adresses + "]";
	}
	
}