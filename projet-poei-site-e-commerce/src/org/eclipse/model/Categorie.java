package org.eclipse.model;

public class Categorie {

	int id;
	String categorie;

	public Categorie(String categorie) {
		this.id = GestionnaireId.giveNewIdCategorie();
		this.categorie = categorie;
	}

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
