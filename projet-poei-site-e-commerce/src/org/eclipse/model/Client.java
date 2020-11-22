package org.eclipse.model;

import java.util.ArrayList;

public class Client extends Utilisateur {
	/** Classe decrivant les methodes et attributs propres au client */

	// Attributs propres
	private ArrayList<Integer> idCommandes = new ArrayList<Integer>();
	private ArrayList<Integer> idLignesPanier = new ArrayList<Integer>();

	// Les constructeurs
	public Client() {
	}
	
	public Client(String nom, String prenom, String adresseMail, String numeroTelephone,
			String identifiantConnexion, String motDePasse, ArrayList<Integer> idAdresses) {
		super(nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, idAdresses);
	}

	// Les getters et les setters classiques
	public ArrayList<Integer> getIdCommandes() {
		return this.idCommandes;
	}

	public void setIdCommandes(ArrayList<Integer> idCommandes) {
		this.idCommandes = idCommandes;
	}
	
	public ArrayList<Integer> getIdLignesPanier() {
		return idLignesPanier;
	}

	public void setIdLignesPanier(ArrayList<Integer> idLignesPanier) {
		this.idLignesPanier = idLignesPanier;
	}

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "Client [idCommandes=" + this.idCommandes + ", idLignesPanier=" + this.idLignesPanier + ", id=" + getId() + ", nom=" + getNom()
				+ ", prenom=" + getPrenom() + ", adresseMail=" + getAdresseMail() + ", numeroTelephone="
				+ getNumeroTelephone() + ", identifiantConnexion=" + getIdentifiantConnexion()
				+ ", motDePasse=" + getMotDePasse() + ", idAdresses=" + getIdAdresses() + "]";
	}

}
