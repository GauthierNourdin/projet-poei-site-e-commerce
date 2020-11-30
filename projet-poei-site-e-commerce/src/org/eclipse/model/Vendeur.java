package org.eclipse.model;

import java.util.ArrayList;

public class Vendeur extends Utilisateur {
	/** Classe decrivant les methodes et attributs propres au vendeur */

	// Attributs propres
	private ArrayList<Integer> idProduits = new ArrayList<Integer>();

	// Les constructeurs
	// Constructeur vide
	public Vendeur() {
	}
	
	// Constructeur pour le delete
	public Vendeur(int idUtilisateur) {
		super(idUtilisateur);
	}

	// Constructeur pour le save
	public Vendeur(String nom, String prenom, String adresseMail, String numeroTelephone,
			String identifiantConnexion, String motDePasse, ArrayList<Integer> idAdresses) {
		super(nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, idAdresses);
	}
	
	// Constructeur pour l'update, le findById et le findAll
	public Vendeur(int idUtilisateur, String nom, String prenom, String adresseMail, String numeroTelephone,
			String identifiantConnexion, String motDePasse, ArrayList<Integer> idAdresses,
			ArrayList<Integer> idProduits) {
		super(idUtilisateur, nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, idAdresses);
		this.idProduits = idProduits;
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
		return "Vendeur [idProduits=" + idProduits + ", idUtilisateur=" + getIdUtilisateur() + ", nom=" + getNom()
				+ ", prenom=" + getPrenom() + ", adresseMail=" + getAdresseMail() + ", numeroTelephone="
				+ getNumeroTelephone() + ", identifiantConnexion=" + getIdentifiantConnexion()
				+ ", motDePasse=" + getMotDePasse() + ", idAdresses=" + getIdAdresses() + "]";
	}

}
