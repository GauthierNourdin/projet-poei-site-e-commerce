package org.eclipse.model;

import java.util.ArrayList;

public class Vendeur extends Utilisateur {
	/** Classe decrivant les methodes et attributs propres au vendeur */

	// Attributs propres
	private ArrayList<Integer> idProduits;

	// Le constructeur
	public Vendeur(String nom, String prenom, String adresseMail, String numeroTelephone,
			String identifiantConnexion, String motDePasse, ArrayList<Adresse> adresses) {
		super(nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, adresses);
		this.idProduits = new ArrayList<Integer>();
		// Le tableau des produits commence vide.
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
		return "Vendeur [idProduits=" + idProduits + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getAdresseMail()=" + getAdresseMail() + ", getNumeroTelephone()="
				+ getNumeroTelephone() + ", getIdentifiantConnexion()=" + getIdentifiantConnexion()
				+ ", getMotDePasse()=" + getMotDePasse() + ", getAdresses()=" + getAdresses() + "]";
	}

}
