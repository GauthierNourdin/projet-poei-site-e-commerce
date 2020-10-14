package org.eclipse.service;

public class GestionnaireId {

	private int idCommande;
	private int idLigneCommande;
	private int idLignePanier;
	private int idProduit;
	private int idUtilisateur;
	
	public GestionnaireId() {
		this.idCommande = 1;
		this.idLigneCommande = 1;
		this.idLignePanier = 1;
		this.idProduit = 1;
		this.idUtilisateur = 1;
	}

	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getIdLigneCommande() {
		return this.idLigneCommande;
	}

	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public int getIdLignePanier() {
		return this.idLignePanier;
	}

	public void setIdLignePanier(int idLignePanier) {
		this.idLignePanier = idLignePanier;
	}

	public int getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String giveNewIdCommande() {
		String newIdCommande = convertIntToStringWithFormatId(idCommande);
		if(newIdCommande != null) {
			idCommande++;
			return newIdCommande;
		} else {
			return null;
		}
	}
	
	public String giveNewIdLigneCommande() {
		String newIdLigneCommande = convertIntToStringWithFormatId(idLigneCommande);
		if(newIdLigneCommande != null) {
			idLigneCommande++;
			return newIdLigneCommande;
		} else {
			return null;
		}
	}
	
	public String giveNewIdLignePanier() {
		String newIdLignePanier = convertIntToStringWithFormatId(idLignePanier);
		if(newIdLignePanier != null) {
			idLignePanier++;
			return newIdLignePanier;
		} else {
			return null;
		}
	}

	public String giveNewIdProduit() {
		String newIdProduit = convertIntToStringWithFormatId(idProduit);
		if(newIdProduit != null) {
			idProduit++;
			return newIdProduit;
		} else {
			return null;
		}
	}

	public String giveNewIdUtilisateur() {
		String newIdUtilisateur = convertIntToStringWithFormatId(idUtilisateur);
		if(newIdUtilisateur != null) {
			idUtilisateur++;
			return newIdUtilisateur;
		} else {
			return null;
		}
	}
	
	public String convertIntToStringWithFormatId (int id) {
		int formatId = 8; // Nombre de chiffres des id
		if (id < 100000000) {
			String idString = Integer.toString(id);
			for (int i = 0 ; i < formatId - idString.length() ; i++) {
				idString = "0" + idString;
			}
			return idString;
		} else {
			return null;
		}
	}
	
	// La méthode "toString" sert uniquement au débuggage.
	public String toString() {
		return "GestionnaireId [idCommande=" + this.idCommande + ", idLigneCommande=" + this.idLigneCommande + ", idLignePanier="
				+ this.idLignePanier + ", idProduit=" + this.idProduit + ", idUtilisateur="
				+ this.idUtilisateur + " ]";
	}
	
}
