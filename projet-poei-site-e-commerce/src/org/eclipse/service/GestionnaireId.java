package org.eclipse.service;

public class GestionnaireId {
	/*
	 * Ces attributs ne doivent être initialisées qu'une seule fois. Les rendre
	 * statiques permet de les générer au début de l'exécution.
	 */
	private static int idCommande = 0;
	private static int idLigneCommande = 0;
	private static int idLignePanier = 0;
	private static int idProduit = 0;
	private static int idUtilisateur = 0;

	// Constructeur privé pour éviter de créer des instances.
	private GestionnaireId() {
	}

	// Méthodes statiques pour donner de nouvelles id valides
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

	// La méthode sert uniquement au débuggage.
	public static String affichageDebuggage() {
		return "GestionnaireId [idCommande=" + idCommande + ", idLigneCommande=" + idLigneCommande + ", idLignePanier="
				+ idLignePanier + ", idProduit=" + idProduit + ", idUtilisateur=" + idUtilisateur + " ]";
	}

}
