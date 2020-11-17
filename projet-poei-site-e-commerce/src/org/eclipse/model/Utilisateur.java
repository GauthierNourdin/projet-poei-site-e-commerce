package org.eclipse.model;

import java.util.ArrayList;

public class Utilisateur {
	/**
	 *  Classe de base commune a tous les utilisateurs du site.
	 */
	// Attributs
	private int id;
	private String nom;
	private String prenom;
	private String adresseMail;
	private String numeroTelephone;
	private String identifiantConnexion;
	private String motDePasse;
	private ArrayList<Integer> idAdresses = new ArrayList<Integer>();

	// Les constructeurs
	public Utilisateur() {
	}
	
	public Utilisateur(String nom, String prenom, String adresseMail, String numeroTelephone,
			String identifiantConnexion, String motDePasse, ArrayList<Integer> idAdresses) {
		this.id = GestionnaireId.giveNewIdUtilisateur();
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.numeroTelephone = numeroTelephone;
		this.identifiantConnexion = identifiantConnexion;
		this.motDePasse = motDePasse;
		this.idAdresses = idAdresses;
	}

	// Les getters et les setters classiques
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresseMail() {
		return this.adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getNumeroTelephone() {
		return this.numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public String getIdentifiantConnexion() {
		return this.identifiantConnexion;
	}

	public void setIdentifiantConnexion(String identifiantConnexion) {
		this.identifiantConnexion = identifiantConnexion;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public ArrayList<Integer> getIdAdresses() {
		return this.idAdresses;
	}

	public void setIdAdresses(ArrayList<Integer> idAdresses) {
		this.idAdresses = idAdresses;
	}

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "Utilisateur [id=" + this.id + ", nom=" + this.nom + ", prenom=" + this.prenom + ", adresseMail="
				+ this.adresseMail + ", numeroTelephone=" + this.numeroTelephone + ", identifiantConnexion="
				+ this.identifiantConnexion + ", motDePasse=" + this.motDePasse + ", adresses" + this.idAdresses + "]";
	}

}
