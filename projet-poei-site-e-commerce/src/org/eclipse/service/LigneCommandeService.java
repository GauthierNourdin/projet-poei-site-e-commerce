package org.eclipse.service;

import java.util.ArrayList;
import org.eclipse.model.LigneCommande;

public class LigneCommandeService {

	// Attributs
	private ArrayList<LigneCommande> lignesCommande;

	// Le constructeur
	public LigneCommandeService(ArrayList<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	// Les getters et les setters classiques
	public ArrayList<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(ArrayList<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	// M�thode pour ajouter une ligne de commande dans la liste
	public boolean save(LigneCommande ligneCommande) {
		/*
		 * On v�rifie que la ligne de commande n'appartient pas d�j� � la liste avant de
		 * la rajouter. La m�thode retourne "true" si l'ajout a �t� accompli, "false"
		 * sinon.
		 */
		if (this.lignesCommande.contains(ligneCommande)) {
			return false;
		} else {
			return this.lignesCommande.add(ligneCommande);
		}
	}

	// M�thode pour retirer une ligne de commande de la liste
	public boolean remove(LigneCommande ligneCommande) {
		/*
		 * On v�rifie que la ligne de commande est bien pr�sente dans la liste avant de
		 * la supprimer. La m�thode retourne "true" si la suppression a �t� accomplie,
		 * "false" sinon.
		 */
		if (this.lignesCommande.contains(ligneCommande)) {
			return this.lignesCommande.remove(ligneCommande);
		} else {
			return false;
		}
	}

	// M�thode pour mettre � jour une ligne de commande (m�me ID !)
	public boolean update(LigneCommande ligneCommande) {
		/*
		 * On compare l'id de la ligne de commande dans la liste avec l'id de la ligne
		 * de commande que l'on a envoy� en entr�e. Si on obtient une correspondance, on
		 * enl�ve la ligne de commande avec cet id de la liste et on rajoute la ligne de
		 * commande en entr�e. Seul la premi�re ligne de panier ayant cet id sera
		 * �limin�. La fonction retourne "true" si on a pu proc�der au remplacement,
		 * "false" sinon.
		 */
		for (LigneCommande ligneCommandeIndividuelle : this.lignesCommande) {
			if (ligneCommandeIndividuelle.getId() == ligneCommande.getId()) {
				this.lignesCommande.remove(ligneCommandeIndividuelle);
				return this.save(ligneCommande);
			}
		}
		return false;
	}

	// M�thode pour rendre la liste compl�te (convention de nommage)
	public ArrayList<LigneCommande> findAll() {
		return this.lignesCommande;
	}

	// M�thode pour trouver dans la liste une ligne de commande d'id connu
	public LigneCommande findById(String id) {
		for (LigneCommande ligneCommandeIndividuelle : this.lignesCommande) {
			if (ligneCommandeIndividuelle.getId() == id) {
				return ligneCommandeIndividuelle;
			}
		}
		return null;
	}

	// La m�thode "toString" sert uniquement au d�buggage.
	public String toString() {
		return "LigneCommandeService [lignesCommande=" + lignesCommande + "]";
	}

}
