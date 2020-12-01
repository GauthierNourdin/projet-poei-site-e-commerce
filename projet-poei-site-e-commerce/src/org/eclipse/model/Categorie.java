package org.eclipse.model;

public class Categorie {
	/** Classe decrivant les categories utilisables*/
	
	// Les attributs
	int id;
	String nom;

	// Les constructeurs
	// Constructeur vide
	public Categorie() {
	}
	
	// Constructeur pour le delete
	public Categorie(int id) {
		this.id = id;
	}

	// Constructeur pour le save
	public Categorie(String nom) {
		this.nom = nom;
	}	
	
	// Constructeur pour le delete, le findById et le findAll 
	public Categorie(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	// Les getters et les setters classiques
	public int getId() {
		return this.id;
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

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "Categorie [id=" + this.id + ", nom=" + this.nom + "]";
	}

}
