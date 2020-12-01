package org.eclipse.model;

public class Adresse {
	/** Classe permettant d'enregistrer l'adresse des utilisateurs */
	
	// Attributs
	private String numeroDansRue;
	private String rue;
	private String ville;
	private String codePostal;
	private String pays;
	private String complementAdresse;
	private int idUtilisateur;
	private int id;
	
	// Les constructeurs
	// Constructeur vide
	public Adresse() {
	}
	
	// Constructeur pour le delete
	public Adresse(int id) {
		this.id = id;
	}
	
	// Constructeur pour le save
	public Adresse(String numeroDansRue, String rue, String ville, String codePostal, String pays,
			String complementAdresse, int idUtilisateur) {
		this.numeroDansRue = numeroDansRue;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays = pays;
		this.complementAdresse = complementAdresse;
		this.idUtilisateur = idUtilisateur;
	}
	
	// Constructeur pour l'update, le findById et le findAll	
	public Adresse(String numeroDansRue, String rue, String ville, String codePostal, String pays,
			String complementAdresse, int idUtilisateur, int id) {
		this.numeroDansRue = numeroDansRue;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays = pays;
		this.complementAdresse = complementAdresse;
		this.idUtilisateur = idUtilisateur;
		this.id = id;
	}

	// Les getters et les setters classiques
	public String getNumeroDansRue() {
		return this.numeroDansRue;
	}

	public void setNumeroDansRue(String numeroDansRue) {
		this.numeroDansRue = numeroDansRue;
	}

	public String getRue() {
		return this.rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getComplementAdresse() {
		return this.complementAdresse;
	}

	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}
	
	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idClient) {
		this.idUtilisateur = idClient;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// La methode "toString" sert uniquement au debuggage.
	public String toString() {
		return "Adresse [numeroDansRue=" + this.numeroDansRue + ", rue=" + this.rue + ", ville=" + this.ville + ", codePostal="
				+ this.codePostal + ", pays=" + this.pays + ", complementAdresse=" + this.complementAdresse + ", idClient=" + this.idUtilisateur + ", id=" + this.id + "]";
	}
	
}
