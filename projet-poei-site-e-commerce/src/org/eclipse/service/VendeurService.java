package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.Vendeur;

public class VendeurService {

	// Attributs
	private ArrayList<Vendeur> vendeurs;

	// Le constructeur
	public VendeurService(ArrayList<Vendeur> vendeurs) {
		this.vendeurs = vendeurs;
	}

	// Les getters et les setters classiques
	public ArrayList<Vendeur> getVendeurs() {
		return this.vendeurs;
	}

	public void setVendeurs(ArrayList<Vendeur> vendeurs) {
		this.vendeurs = vendeurs;
	}

	// M�thode pour ajouter un vendeur dans la liste
	public boolean save(Vendeur vendeur) {
		/*
		 * On v�rifie que le vendeur n'appartient pas d�j� � la liste avant de le
		 * rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (this.vendeurs.contains(vendeur)) {
			return false;
		} else {
			return this.vendeurs.add(vendeur);
		}
	}

	// M�thode pour retirer un produit de la liste
	public boolean remove(Vendeur vendeur) {
		/*
		 * On v�rifie que le vendeur est bien pr�sent dans la liste avant de le
		 * supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (this.vendeurs.contains(vendeur)) {
			return this.vendeurs.remove(vendeur);
		} else {
			return false;
		}
	}

	// M�thode pour mettre � jour un produit (m�me ID !)
	public boolean update(Vendeur vendeur) {
		/*
		 * On compare l'id du vendeur dans la liste avec l'id du vendeur que
		 * l'on a envoy� en entr�e. Si on obtient une correspondance, on enl�ve
		 * le vendeur avec cet id de la liste et on rajoute le vendeur en entr�e.
		 * Seul le premier vendeur ayant cet id sera �limin�. La fonction retourne
		 * "true" si on a pu proc�der au remplacement, "false" sinon.
		 */
		for (Vendeur vendeurIndividuel : this.vendeurs) {
			if (vendeurIndividuel.getId() == vendeur.getId()) {
				this.vendeurs.remove(vendeurIndividuel);
				return this.save(vendeur);
			}
		}
		return false;
	}

	// M�thode pour rendre la liste compl�te (convention de nommage)
	public ArrayList<Vendeur> findAll() {
		return this.vendeurs;
	}

	// M�thode pour trouver dans la liste un vendeur d'id connu
	public Vendeur findById(String id) {
		for (Vendeur vendeurIndividuel : this.vendeurs) {
			if (vendeurIndividuel.getId() == id) {
				return vendeurIndividuel;
			}
		}
		return null;
	}

	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "VendeurService [vendeurs=" + this.vendeurs + "]";
	}

}
