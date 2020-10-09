package org.eclipse.model;

import java.util.ArrayList;

public class Vendeur extends Utilisateur {
	/** Classe d�crivant les m�thodes et attributs propres au vendeur */

	// Attributs propres
	private ArrayList<Produit> produits;

	// Le constructeur
	public Vendeur(String id, String nom, String prenom, String adresseMail, String numeroTelephone,
			String identifiantConnexion, String motDePasse, ArrayList<Adresse> adresses) {
		// Constructeur complet pour la cr�ation standard d'un nouveau vendeur
		super(id, nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, adresses);
		this.produits = new ArrayList<Produit>();
		// Le tableau des produits commence vide.
	}

	// Les getters et les setters classiques

	public ArrayList<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}

	/*
	 * La m�thode "toString" sert uniquement au d�buggage. Pour �viter les boucles
	 * d'affichage infinies on n'�crit pas directement les produits mais on �crit
	 * juste leur id.
	 */
	public String toString() {
		String idProduits = "";
		if (this.produits.size() != 0) {
			idProduits += " [";
			int i;
			for (i = 0; i < this.produits.size() - 1; i++) {
				idProduits += this.produits.get(i).getId() + ", ";
			}
			idProduits += this.produits.get(i).getId() + " ]";
		} else {
			idProduits += " [ ]";
		}
		return "Vendeur [produits.id=" + idProduits + ", toString()=" + super.toString() + "]";
	}

}
