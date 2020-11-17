package org.eclipse.model;

import java.util.ArrayList;

public class Vendeur extends Utilisateur {
	/** Classe decrivant les methodes et attributs propres au vendeur */

	// Attributs propres
	private ArrayList<Integer> idProduits = new ArrayList<Integer>();

	// Le constructeur
	public Vendeur() {
	}
	
	public Vendeur(String nom, String prenom, String adresseMail, String numeroTelephone,
			String identifiantConnexion, String motDePasse, ArrayList<Integer> idAdresses) {
		super(nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, idAdresses);
	}

	// Les getters et les setters classiques
	public ArrayList<Integer> getIdProduits() {
		return this.idProduits;
	}

	public void setIdProduits(ArrayList<Integer> idProduits) {
		this.idProduits = idProduits;
	}

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "Vendeur [idProduits=" + idProduits + ", id=" + getId() + ", nom=" + getNom()
				+ ", prenom=" + getPrenom() + ", adresseMail=" + getAdresseMail() + ", numeroTelephone="
				+ getNumeroTelephone() + ", identifiantConnexion=" + getIdentifiantConnexion()
				+ ", motDePasse=" + getMotDePasse() + ", idAdresses=" + getIdAdresses() + "]";
	}

}
