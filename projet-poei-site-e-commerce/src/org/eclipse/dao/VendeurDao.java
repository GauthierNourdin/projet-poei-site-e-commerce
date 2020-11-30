package org.eclipse.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.Adresse;
import org.eclipse.model.Produit;
import org.eclipse.model.Vendeur;

public class VendeurDao implements Dao<Vendeur> {

	public Vendeur save(Vendeur vendeur) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				
				PreparedStatement ps = c.prepareStatement(
						"INSERT INTO Utilisateur (nom,prenom,adresseMail,numeroTelephone,identifiantConnexion,motDePasse,type) VALUES (?,?,?,?,?,?,'vendeur'); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, vendeur.getNom());
				ps.setString(2, vendeur.getPrenom());
				ps.setString(3, vendeur.getAdresseMail());
				ps.setString(4, vendeur.getNumeroTelephone());
				ps.setString(5, vendeur.getIdentifiantConnexion());
				ps.setString(6, vendeur.getMotDePasse());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					vendeur.setIdUtilisateur(resultat.getInt(1));
					return vendeur;
				}

				for (int idAdresse : vendeur.getIdAdresses()) {
					if (idAdresse != 0) {
						ps = c.prepareStatement("UPDATE Adresse (idUtilisateur) VALUES (?) WHERE id=?;");
						ps.setInt(1, vendeur.getIdUtilisateur());
						ps.setInt(2, idAdresse);
						ps.executeUpdate();
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void remove(Vendeur vendeur) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("UPDATE Adresse SET idUtilisateur=NULL WHERE idUtilisateur=?;");
				ps.setInt(1, vendeur.getIdUtilisateur());
				ps.executeUpdate();

				ps = c.prepareStatement("UPDATE Commande SET idUtilisateur=NULL WHERE idUtilisateur=?");
				ps.setInt(1, vendeur.getIdUtilisateur());
				ps.executeUpdate();

				ps = c.prepareStatement("DELETE FROM LignePanier WHERE idProduit=?");
				ps.setInt(1, produit.getId());
				ps.executeUpdate();

				ps = c.prepareStatement("UPDATE LigneCommande SET idProduit=NULL WHERE idProduit=? ");
				ps.setInt(1, produit.getId());
				ps.executeUpdate();

				ps = c.prepareStatement("DELETE FROM Adresse WHERE id=?;");
				ps.setInt(1, produit.getId());
				int nbr = ps.executeUpdate();
				if (nbr != 1) {
					System.err.println("Erreur : Absence de suppression");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Vendeur update(Vendeur vendeur) {
		Connection c = MyConnection.getConnection();
		
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM ProduitCategorie WHERE idProduit=?; ");
				ps.setInt(1, produit.getId());
				int nbr = ps.executeUpdate();
				if (nbr != produit.getIdCategories().size()) {
					System.err.println("Erreur : Absence de suppression dans la table ProduitCategorie");
				}
						
				for (int idCategorie : produit.getIdCategories()) {
					ps = c.prepareStatement("INSERT INTO ProduitCategorie (idProduit,idCategorie) VALUES (?,?);");
					ps.setInt(1, produit.getId());
					ps.setInt(2, idCategorie);
					nbr = ps.executeUpdate();
					if (nbr != 1) {
						System.err.println("Erreur : Absence d'ajout dans la table ProduitCategorie");
					}
				}
				
				ps = c.prepareStatement("SELECT id FROM LignePanier WHERE quantiteSouhaitee>?");
				ps.setInt(1, produit.getQuantiteEnStock());
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int idLignePanier = result.getInt("id");
					
					PreparedStatement ps2 = c.prepareStatement("UPDATE LignePanier SET quantiteSouhaitee=? WHERE id=?");
					ps2.setInt(1, produit.getQuantiteEnStock());
					ps2.setInt(2, idLignePanier);
					nbr = ps.executeUpdate();
					if (nbr != 1) {
						System.err.println("Erreur : Absence de modification dans la table LignePanier");
					}
				}
				
				ps = c.prepareStatement("UPDATE Produit SET designation=?, prixUnit=?, quantiteStock=?, urlImage=?, descriptionProduit=? WHERE id=?; ");
				ps.setString(1, produit.getDesignation());
				ps.setDouble(2, produit.getPrixUnitaire());
				ps.setInt(3, produit.getQuantiteEnStock());
				ps.setString(4, produit.getUrlImage());
				ps.setString(5, produit.getDescriptionProduit());
				ps.setInt(6, produit.getId());
				nbr = ps.executeUpdate();
				if (nbr == 1) {
					return produit;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Vendeur findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Produit WHERE id=?;");
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();
				
				if (result.next()) {
					String designation = result.getString("designation");
					double prixUnitaire = result.getDouble("prixUnit");
					int quantiteStock = result.getInt("quantiteStock");
					String urlImage = result.getString("urlImage");
					String descriptionProduit = result.getString("descriptionProduit");
					Date dateDebut = result.getDate("dateDebut");
					int idVendeur = result.getInt("idUtilisateur");
					
					ArrayList<Integer> idCategories = new ArrayList<Integer>(); 
					ArrayList<Integer> idLignesCommande = new ArrayList<Integer>();
					
					PreparedStatement ps2 = c.prepareStatement("SELECT idCategorie FROM ProduitCategorie WHERE idProduit=?;");
					ps2.setInt(1, id);
					ResultSet result2 = ps2.executeQuery();
					while(result.next()) {
						int idCategorie = result2.getInt("idCategorie");
						idCategories.add(idCategorie);
					}
					
					PreparedStatement ps3 = c.prepareStatement("SELECT id FROM LigneCommande WHERE idProduit=?;");
					ps3.setInt(1, id);
					ResultSet result3 = ps3.executeQuery();
					while(result.next()) {
						int idLigneCommande = result3.getInt("id");
						idLignesCommande.add(idLigneCommande);
					}
					
					Produit produit = new Produit(id, designation, prixUnitaire, quantiteStock, urlImage, descriptionProduit, idVendeur, dateDebut, idCategories, idLignesCommande);
					return produit;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Vendeur> findAll() {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				ArrayList<Produit> produits = new ArrayList<Produit>();
				
				Statement statement = c.createStatement();
				String request = "SELECT * FROM Produit;";
				ResultSet result = statement.executeQuery(request);
				
				while (result.next()) {
					int id = result.getInt("id");
					String designation = result.getString("designation");
					double prixUnitaire = result.getDouble("prixUnit");
					int quantiteStock = result.getInt("quantiteStock");
					String urlImage = result.getString("urlImage");
					String descriptionProduit = result.getString("descriptionProduit");
					Date dateDebut = result.getDate("dateDebut");
					int idVendeur = result.getInt("idUtilisateur");
					
					ArrayList<Integer> idCategories = new ArrayList<Integer>(); 
					ArrayList<Integer> idLignesCommande = new ArrayList<Integer>();
					
					PreparedStatement ps2 = c.prepareStatement("SELECT idCategorie FROM ProduitCategorie WHERE idProduit=?;");
					ps2.setInt(1, id);
					ResultSet result2 = ps2.executeQuery();
					while(result.next()) {
						int idCategorie = result2.getInt("idCategorie");
						idCategories.add(idCategorie);
					}
					
					PreparedStatement ps3 = c.prepareStatement("SELECT id FROM LigneCommande WHERE idProduit=?;");
					ps3.setInt(1, id);
					ResultSet result3 = ps3.executeQuery();
					while(result.next()) {
						int idLigneCommande = result3.getInt("id");
						idLignesCommande.add(idLigneCommande);
					}
					
					Produit produit = new Produit(id, designation, prixUnitaire, quantiteStock, urlImage, descriptionProduit, idVendeur, dateDebut, idCategories, idLignesCommande);
					produits.add(produit);
				}
				
				return produits;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
