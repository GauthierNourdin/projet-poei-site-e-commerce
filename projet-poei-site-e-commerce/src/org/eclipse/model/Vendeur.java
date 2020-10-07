package org.eclipse.model;

import java.util.Arrays;

public class Vendeur extends Utilisateur {
	/** Classe décrivant les méthodes et attributs propres au vendeur */
	
	// Attributs propres
	private Produit [] produits;
	
	// Le constructeur
	public Vendeur(String id, String nom, String prenom, String adresseMail, String numeroTelephone,
			String identifiantConnexion, String motDePasse, Adresse[] adresses, Produit[] produits) {
		// Constructeur complet pour la création standard d'un nouveau vendeur
		super(id, nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, adresses);
		this.produits = new Produit [100];
		/*
		 * Le tableau des produits commence vide, limitation à 100 produits par vendeur
		 */
	}
	
	// Les getteurs et setteurs classiques
	public Produit[] getProduits() {
		return this.produits;
	}

	public void setProduits(Produit[] produits) {
		this.produits = produits;
	}

	// La méthode "toString" sert uniquement au débuggage
	public String toString() {
		return "Vendeur [produits=" + Arrays.toString(this.produits) + ", toString()=" + super.toString() + "]";
	}
	
}
