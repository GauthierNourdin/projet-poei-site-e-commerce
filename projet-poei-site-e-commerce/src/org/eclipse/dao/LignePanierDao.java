package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.LignePanier;

public class LignePanierDao implements Dao<LignePanier> {

	public LignePanier save(LignePanier lignePanier) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				/*
				 * Code de sécurité pour s"assurer que la quantité souhaitée ne dépasse la
				 * quantité en stock du produit
				 */
				PreparedStatement ps = c.prepareStatement("SELECT quantiteStock FROM Produit WHERE id=?;");
				ps.setInt(1, lignePanier.getIdProduit());
				ResultSet result = ps.executeQuery();

				if (result.next()) {
					int quantiteStock = result.getInt("quantiteStock");

					if (lignePanier.getQuantiteSouhaitee() > quantiteStock) {
						lignePanier.setQuantiteSouhaitee(quantiteStock);
					}

					ps = c.prepareStatement(
							"INSERT INTO LignePanier (quantiteSouhaitee,idUtilisateur,idProduit) VALUES (?,?,?);",
							PreparedStatement.RETURN_GENERATED_KEYS);
					ps.setInt(1, lignePanier.getQuantiteSouhaitee());
					ps.setInt(2, lignePanier.getIdClient());
					ps.setInt(3, lignePanier.getIdProduit());
					ps.executeUpdate();
					ResultSet resultat = ps.getGeneratedKeys();
					if (resultat.next()) {
						lignePanier.setId(resultat.getInt(1));
						return lignePanier;
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void remove(LignePanier lignePanier) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM LignePanier WHERE id=?;");
				ps.setInt(1, lignePanier.getId());
				int nbr = ps.executeUpdate();
				if (nbr != 1) {
					System.err.println("Erreur : Absence de suppression");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public LignePanier update(LignePanier lignePanier) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				/*
				 * Code de sécurité pour s"assurer que la quantité souhaitée ne dépasse la
				 * quantité en stock du produit
				 */
				PreparedStatement ps = c.prepareStatement("SELECT quantiteStock FROM Produit WHERE id=?;");
				ps.setInt(1, lignePanier.getIdProduit());
				ResultSet result = ps.executeQuery();

				if (result.next()) {
					int quantiteStock = result.getInt("quantiteStock");

					if (lignePanier.getQuantiteSouhaitee() > quantiteStock) {
						lignePanier.setQuantiteSouhaitee(quantiteStock);
					}

					ps = c.prepareStatement("UPDATE LignePanier SET quantiteSouhaitee=? WHERE id=?;");
					ps.setInt(1, lignePanier.getQuantiteSouhaitee());
					ps.setInt(2, lignePanier.getId());
					int nbr = ps.executeUpdate();
					if (nbr == 1) {
						return lignePanier;
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public LignePanier findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM LignePanier WHERE id=?;");
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();

				if (result.next()) {
					int quantiteSouhaitee = result.getInt("quantiteSouhaitee");
					int idClient = result.getInt("idUtilisateur");
					int idProduit = result.getInt("idProduit");

					LignePanier lignePanier = new LignePanier(id, quantiteSouhaitee, idClient, idProduit);
					return lignePanier;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<LignePanier> findAll() {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				ArrayList<LignePanier> lignesPanier = new ArrayList<LignePanier>();

				Statement statement = c.createStatement();
				String request = "SELECT * FROM LignePanier;";
				ResultSet result = statement.executeQuery(request);

				while (result.next()) {
					int id = result.getInt("id");
					int quantiteSouhaitee = result.getInt("quantiteSouhaitee");
					int idClient = result.getInt("idUtilisateur");
					int idProduit = result.getInt("idProduit");

					LignePanier lignePanier = new LignePanier(id, quantiteSouhaitee, idClient, idProduit);
					lignesPanier.add(lignePanier);
				}
				return lignesPanier;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// Méthode pour trouver toutes les lignes de panier d'un client
	public ArrayList<LignePanier> findByClient(int idClient) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				ArrayList<LignePanier> lignesPanier = new ArrayList<LignePanier>();

				PreparedStatement ps = c.prepareStatement("SELECT * FROM LignePanier WHERE idUtilisateur=?;");
				ps.setInt(1, idClient);
				ResultSet result = ps.executeQuery();

				while (result.next()) {
					int id = result.getInt("id");
					int quantiteSouhaitee = result.getInt("quantiteSouhaitee");
					int idProduit = result.getInt("idProduit");

					LignePanier lignePanier = new LignePanier(id, quantiteSouhaitee, idClient, idProduit);
					lignesPanier.add(lignePanier);
				}
				return lignesPanier;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// Méthode pour obtenir la ligne de panier d'un client concernant un produit
	public LignePanier findByClientAndProduit(int idClient, int idProduit) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c
						.prepareStatement("SELECT * FROM LignePanier WHERE idUtilisateur=? AND idProduit=?;");
				ps.setInt(1, idClient);
				ps.setInt(2, idProduit);
				ResultSet result = ps.executeQuery();

				if (result.next()) {
					int id = result.getInt("id");
					int quantiteSouhaitee = result.getInt("quantiteSouhaitee");

					LignePanier lignePanier = new LignePanier(id, quantiteSouhaitee, idClient, idProduit);
					return lignePanier;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * Méthode pour vérifier que la quantité souhaitée dans une ligne de panier ne
	 * dépasse pas la quantité en stock du produit correspondant
	 */
	public LignePanier checkQuantiteSouhaitee(LignePanier lignePanier) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT quantiteStock FROM Produit WHERE id=?;");
				ps.setInt(1, lignePanier.getIdProduit());
				ResultSet result = ps.executeQuery();

				if (result.next()) {
					int quantiteStock = result.getInt("quantiteStock");

					if (lignePanier.getQuantiteSouhaitee() > quantiteStock) {
						lignePanier.setQuantiteSouhaitee(quantiteStock);
						lignePanier = update(lignePanier);
					}

					return lignePanier;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// Méthode pour supprimer toutes les lignes de panier d'un client
	public void removeByClient(int idClient) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM LignePanier WHERE idUtilisateur=?;");
				ps.setInt(1, idClient);
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
