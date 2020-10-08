package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.Panier;

public class PanierService {

	// Attributs
	private ArrayList<Panier> paniers;

	// Le constructeur
	public PanierService(ArrayList<Panier> paniers) {
		this.paniers = paniers;
	}

	// Les getters et les setters classiques
	public ArrayList<Panier> getPaniers() {
		return this.paniers;
	}

	public void setPaniers(ArrayList<Panier> paniers) {
		this.paniers = paniers;
	}

	// M�thode pour ajouter un panier dans la liste
	public boolean save(Panier panier) {
		/*
		 * On v�rifie que le panier n'appartient pas d�j� � la liste avant de le
		 * rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (this.paniers.contains(panier)) {
			return false;
		} else {
			return this.paniers.add(panier);
		}
	}

	// M�thode pour retirer un panier de la liste
	public boolean remove(Panier panier) {
		/*
		 * On v�rifie que le panier est bien pr�sent dans la liste avant de le
		 * supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (this.paniers.contains(panier)) {
			return this.paniers.remove(panier);
		} else {
			return false;
		}
	}

	// M�thode pour mettre � jour un panier (m�me ID !)
	public boolean update(Panier panier) {
		/*
		 * On compare l'id du panier dans la liste avec l'id du panier que l'on a envoy�
		 * en entr�e. Si on obtient une correspondance, on enl�ve le panier avec cet id
		 * de la liste et on rajoute le panier en entr�e. Seul le premier panier ayant
		 * cet id sera �limin�. La fonction retourne "true" si on a pu proc�der au
		 * remplacement, "false" sinon.
		 */
		for (Panier panierIndividuel : this.paniers) {
			if (panierIndividuel.getId() == panier.getId()) {
				this.paniers.remove(panierIndividuel);
				return this.save(panier);
			}
		}
		return false;
	}

	// M�thode pour rendre la liste compl�te (convention de nommage)
	public ArrayList<Panier> findAll() {
		return this.paniers;
	}

	// M�thode pour trouver dans la liste un panier d'id connu
	public Panier findById(String id) {
		for (Panier panierIndividuel : this.paniers) {
			if (panierIndividuel.getId() == id) {
				return panierIndividuel;
			}
		}
		return null;
	}

	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "PanierService [paniers=" + this.paniers + "]";
	}

}
