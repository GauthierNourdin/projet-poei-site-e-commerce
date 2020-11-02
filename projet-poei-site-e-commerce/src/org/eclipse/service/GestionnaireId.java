package org.eclipse.service;

public class GestionnaireId {
	/*
	 * Ces attributs ne doivent �tre initialis�es qu'une seule fois. Les rendre
	 * statiques permet de les g�n�rer au d�but de l'ex�cution.
	 */
	private static int idCommande = 0;
	private static int idLigneCommande = 0;
	private static int idLignePanier = 0;
	private static int idProduit = 0;
	private static int idUtilisateur = 0;

	// Constructeur priv� pour �viter de cr�er des instances.
	private GestionnaireId() {
	}

	// M�thodes statiques pour donner de nouvelles id valides
	public static int giveNewIdCommande() {
		return ++idCommande;
	}

	public static int giveNewIdLigneCommande() {
		return ++idLigneCommande;
	}

	public static int giveNewIdLignePanier() {
		return ++idLignePanier;
	}

	public static int giveNewIdProduit() {
		return ++idProduit;
	}

	public static int giveNewIdUtilisateur() {
		return ++idUtilisateur;
	}

	// La m�thode sert uniquement au d�buggage.
	public static String affichageDebuggage() {
		return "GestionnaireId [idCommande=" + idCommande + ", idLigneCommande=" + idLigneCommande + ", idLignePanier="
				+ idLignePanier + ", idProduit=" + idProduit + ", idUtilisateur=" + idUtilisateur + " ]";
	}

}
