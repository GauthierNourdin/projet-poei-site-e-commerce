package org.eclipse.model;

import java.util.ArrayList;

public class Vendeur extends Utilisateur {
	/** Classe d�crivant les m�thodes et attributs propres au vendeur */

	// Attributs propres
	private ArrayList<Integer> idProduits;

	// Le constructeur
	public Vendeur(int id, String nom, String prenom, String adresseMail, String numeroTelephone,
			String identifiantConnexion, String motDePasse, ArrayList<Adresse> adresses) {
		// Constructeur complet pour la cr�ation standard d'un nouveau vendeur
		super(id, nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, adresses);
		this.idProduits = new ArrayList<Integer>();
		// Le tableau des produits commence vide.
	}

	// Les getters et les setters classiques

	public ArrayList<Integer> getProduits() {
		return this.idProduits;
	}

	public void setProduits(ArrayList<Integer> idProduits) {
		this.idProduits = idProduits;
	}

	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "Vendeur [idProduits=" + idProduits + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getAdresseMail()=" + getAdresseMail() + ", getNumeroTelephone()="
				+ getNumeroTelephone() + ", getIdentifiantConnexion()=" + getIdentifiantConnexion()
				+ ", getMotDePasse()=" + getMotDePasse() + ", getAdresses()=" + getAdresses() + "]";
	}

}
