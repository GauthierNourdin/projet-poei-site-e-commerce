package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.Vendeur;

public class VendeurService {
	/*
	 * Cet attribut ne doit �tre initialis� qu'une seule fois. Le rendre
	 * statique permet de le g�n�rer au d�but de l'ex�cution.
	 */
	private static ArrayList<Vendeur> vendeurs;

	// Constructeur priv� pour �viter de cr�er des instances.
	private VendeurService() {
	}

	// Le getter statique et le setter statique adapt�s
	public static ArrayList<Vendeur> getVendeurs() {
		return vendeurs;
	}

	public static void setVendeurs(ArrayList<Vendeur> argVendeurs) {
		vendeurs = argVendeurs;
	}

	// M�thode statique pour ajouter un vendeur dans la liste
	public static boolean save(Vendeur vendeur) {
		/*
		 * On v�rifie que le vendeur n'appartient pas d�j� � la liste avant de le
		 * rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (vendeurs.contains(vendeur)) {
			return false;
		} else {
			return vendeurs.add(vendeur);
		}
	}

	// M�thode statique pour retirer un vendeur de la liste
	public static boolean remove(Vendeur vendeur) {
		/*
		 * On v�rifie que le vendeur est bien pr�sent dans la liste avant de le
		 * supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (vendeurs.contains(vendeur)) {
			return vendeurs.remove(vendeur);
		} else {
			return false;
		}
	}

	// M�thode statique pour mettre � jour un vendeur
	public static boolean update(Vendeur vendeur) {
		/*
		 * La m�thode retourne true si le client � mettre � jour est dans la liste,
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
	
	// M�thode statique pour rendre la liste compl�te (convention de nommage)
	public static ArrayList<Vendeur> findAll() {
		return vendeurs;
	}

	// M�thode statique pour trouver dans la liste un vendeur d'id connu
	public static Vendeur findById(int id) {
		for (Vendeur vend: vendeurs) {
			if (vend.getId() == id) {
				return vend;
			}
		}
		return null;
	}
	
	// La m�thode sert uniquement au d�buggage.
	public static String affichageDebuggage() {
		return "VendeurService [vendeurs=" + vendeurs + "]";
	}

}
