package org.eclipse.model;

public class Categorie {
	/** Classe decrivant les categories utilisables*/
	
	// Les attributs
	int id;
	String categorie;

	// Les constructeurs
	public Categorie() {
	}
	
	public Categorie(String categorie) {
		this.id = GestionnaireId.giveNewIdCategorie();
		this.categorie = categorie;
	}

	// Les getters et les setters classiques
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "Categorie [id=" + this.id + ", categorie=" + this.categorie + "]";
	}

}
