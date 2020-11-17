package org.eclipse.model;

public class GestionnaireId {
	/**
	 * Cette classe à attributs et méthodes statiques sert en absence de base de
	 * données MySQL à générer des id valides
	 */

	/*
	 * Ces attributs ne doivent etre initialisees qu'une seule fois. Les rendre
	 * statiques permet de les generer au debut de l'execution.
	 */
	private static int idAdresse = 0;
	private static int idCommande = 0;
	private static int idLigneCommande = 0;
	private static int idLignePanier = 0;
	private static int idProduit = 0;
	private static int idUtilisateur = 0;
	private static int idCategorie = 0;
	private static int idCommentaire = 0;

	// Constructeur prive pour eviter de creer des instances.
	private GestionnaireId() {
	}

	// Methodes statiques pour donner de nouvelles id valides
	public static int giveNewIdAdresse() {
		return ++idAdresse;
	}
	
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
	
	public static int giveNewIdCategorie() {
		return ++idCategorie;
	}
	
	public static int giveNewIdCommentaire() {
		return ++idCommentaire;
	}

	// La methode sert uniquement au debuggage.
	public static String affichageDebuggage() {
		return "GestionnaireId [idCommande=" + idCommande + ", idLigneCommande=" + idLigneCommande + ", idLignePanier="
				+ idLignePanier + ", idProduit=" + idProduit + ", idUtilisateur=" + idUtilisateur + " ]";
	}

}
