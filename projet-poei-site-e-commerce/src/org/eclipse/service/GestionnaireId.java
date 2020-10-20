package org.eclipse.service;

public class GestionnaireId {
	/*
	 *  Les attributs statiques ne doivent �tre initialis�es qu'� la premi�re instance de la classe;
	 */
	private static int idCommande = 1;
	private static int idLigneCommande = 1;
	private static int idLignePanier = 1;
	private static int idProduit = 1;
	private static int idUtilisateur = 1;
	
	public GestionnaireId() {
		/*
		 *  Constructeur vide pour �viter de r�initialiser les attributs en cas de cr�ation d'autres instances. 
		 */
	}

	public int giveNewIdCommande() {
		int newIdCommande = idCommande;
		idCommande++;
		return newIdCommande;
	}
	
	public int giveNewIdLigneCommande() {
		int newIdCommande = idCommande;
		idCommande++;
		return newIdCommande;
	}
	
	public int giveNewIdLignePanier() {
		int newIdCommande = idCommande;
		idCommande++;
		return newIdCommande;
	}

	public int giveNewIdProduit() {
		int newIdCommande = idCommande;
		idCommande++;
		return newIdCommande;
	}

	public int giveNewIdUtilisateur() {
		int newIdCommande = idCommande;
		idCommande++;
		return newIdCommande;
	}
	
	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "GestionnaireId [idCommande=" + idCommande + ", idLigneCommande=" + idLigneCommande + ", idLignePanier="
				+ idLignePanier + ", idProduit=" + idProduit + ", idUtilisateur="
				+ idUtilisateur + " ]";
	}
	
}
