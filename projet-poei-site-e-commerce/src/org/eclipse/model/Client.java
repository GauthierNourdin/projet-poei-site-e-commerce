package org.eclipse.model;

import java.util.ArrayList;

public class Client extends Utilisateur {
	/** Classe d�crivant les m�thodes et attributs propres au client */

	// Attributs propres
	private ArrayList<Integer> idCommandes;

	// Le constructeur
	public Client(int id, String nom, String prenom, String adresseMail, String numeroTelephone,
			String identifiantConnexion, String motDePasse, ArrayList<Adresse> adresses) {
		super(id, nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, adresses);
		this.idCommandes = new ArrayList<Integer>();
		// La liste des commandes commence vide.
	}

	// Les getters et les setters classiques
	public ArrayList<Integer> getIdCommandes() {
		return this.idCommandes;
	}

	public void setIdCommandes(ArrayList<Integer> idCommandes) {
		this.idCommandes = idCommandes;
	}

	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "Client [idCommandes=" + idCommandes + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getAdresseMail()=" + getAdresseMail() + ", getNumeroTelephone()="
				+ getNumeroTelephone() + ", getIdentifiantConnexion()=" + getIdentifiantConnexion()
				+ ", getMotDePasse()=" + getMotDePasse() + ", getAdresses()=" + getAdresses() + "]";
	}

}
