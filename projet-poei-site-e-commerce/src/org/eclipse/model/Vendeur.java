package org.eclipse.model;

import java.util.ArrayList;

public class Vendeur extends Utilisateur {
	/** Classe decrivant les methodes et attributs propres au vendeur */

	// Attributs propres
	private int idVendeur;
	private ArrayList<Integer> idProduits = new ArrayList<Integer>();

	// Le constructeur
	public Vendeur() {
		this.idVendeur = GestionnaireId.giveNewIdVendeur();
	}
	
	public Vendeur(String nom, String prenom, String adresseMail, String numeroTelephone,
			String identifiantConnexion, String motDePasse, ArrayList<Integer> idAdresses) {
		super(nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, idAdresses);
		this.idVendeur = GestionnaireId.giveNewIdVendeur();
	}

	// Les getters et les setters classiques
	public int getIdVendeur() {
		return this.idVendeur;
	}

	public void setIdVendeur(int idVendeur) {
		this.idVendeur = idVendeur;
	}

	public ArrayList<Integer> getIdProduits() {
		return this.idProduits;
	}
	
	public void setIdProduits(ArrayList<Integer> idProduits) {
		this.idProduits = idProduits;
	}

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "Vendeur [idProduits=" + idProduits + ", idVendeur=" + this.idVendeur + ", nom=" + getNom()
				+ ", prenom=" + getPrenom() + ", adresseMail=" + getAdresseMail() + ", numeroTelephone="
				+ getNumeroTelephone() + ", identifiantConnexion=" + getIdentifiantConnexion()
				+ ", motDePasse=" + getMotDePasse() + ", idAdresses=" + getIdAdresses() + "]";
	}

}
