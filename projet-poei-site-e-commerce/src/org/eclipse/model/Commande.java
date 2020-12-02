package org.eclipse.model;

import java.sql.Date;
import java.util.ArrayList;

public class Commande {
	/** Classe permettant d'enregistrer les commandes passes par les utilisateurs */

	// Attributs
	private int id;
	private int idClient;
	private ArrayList<Integer> idLignesCommande = new ArrayList<Integer>();
	private Date dateDeCommande;

	// Les constructeurs
	// Constructeur vide
	public Commande() {
	}
	
	// Constructeur pour le delete
	public Commande(int id) {
		this.id = id;
	}	
	
	// Constructeur pour le save
	public Commande(int idClient, ArrayList<Integer> idLignesCommande, Date dateDeCommande) {
		this.idClient = idClient;
		this.idLignesCommande = idLignesCommande;
		this.dateDeCommande = dateDeCommande;
	}	
	
	// Constructeur pour l'update, le findById et le findAll
	public Commande(int id, int idClient, ArrayList<Integer> idLignesCommande, Date dateDeCommande) {
		this.id = id;
		this.idClient = idClient;
		this.idLignesCommande = idLignesCommande;
		this.dateDeCommande = dateDeCommande;
	}

	// Les getters et les setters classiques
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int client) {
		this.idClient = client;
	}

	public ArrayList<Integer> getIdLignesCommande() {
		return this.idLignesCommande;
	}

	public void setIdLignesCommande(ArrayList<Integer> idLignesCommande) {
		this.idLignesCommande = idLignesCommande;
	}

	public Date getDateDeCommande() {
		return this.dateDeCommande;
	}

	public void setDateDeCommande(Date dateDeCommande) {
		this.dateDeCommande = dateDeCommande;
	}

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "Commande [id=" + this.id + ", idClient" + this.idClient + ", idLignesCommande=" + this.idLignesCommande
				+ ", dateDeCommande=" + this.dateDeCommande + "]";
	}

}
