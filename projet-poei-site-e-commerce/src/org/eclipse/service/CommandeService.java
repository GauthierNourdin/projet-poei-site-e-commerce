package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.Commande;

public class CommandeService {
	/*
	 * Cet attribut ne doit �tre initialis� qu'une seule fois. Le rendre
	 * statique permet de le g�n�rer au d�but de l'ex�cution.
	 */
	private static ArrayList<Commande> commandes;

	// Constructeur priv� pour �viter de cr�er des instances.
	private CommandeService() {
	}

	// Le getter statique et le setter statique adapt�s
	public static ArrayList<Commande> getCommandes() {
		return commandes;
	}

	public static void setCommandes(ArrayList<Commande> argCommandes) {
		commandes = argCommandes;
	}

	// M�thode statique pour ajouter une commande dans la liste
	public static boolean save(Commande commande) {
		/*
		 * On v�rifie que la commande n'appartient pas d�j� � la liste avant de la
		 * rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (commandes.contains(commande)) {
			return false;
		} else {
			return commandes.add(commande);
		}
	}

	// M�thode statique pour retirer une commande de la liste
	public static boolean remove(Commande commande) {
		/*
		 * On v�rifie que la commande est bien pr�sente dans la liste avant de la
		 * supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (commandes.contains(commande)) {
			return commandes.remove(commande);
		} else {
			return false;
		}
	}

	// M�thode statique pour mettre � jour une commande
	public static boolean update(Commande commande) {
		/*
		 * La m�thode retourne true si la commande � mettre � jour est dans la liste,
		 * false sinon.
		 */
		for (Commande comm : commandes) {
			if (comm.getId() == commande.getId()) {
				comm = commande;
				return true;
			}
		}
		return false;
	}

	// M�thode statique pour rendre la liste compl�te (convention de nommage)
	public static ArrayList<Commande> findAll() {
		return commandes;
	}

	// M�thode statique pour trouver dans la liste une commande d'id connu
	public static Commande findById(int id) {
		for (Commande comm : commandes) {
			if (comm.getId() == id) {
				return comm;
			}
		}
		return null;
	}

	// La m�thode sert uniquement au d�buggage.
	public static String affichageDebuggage() {
		return "ClientService [commandes=" + commandes + "]";
	}

}
