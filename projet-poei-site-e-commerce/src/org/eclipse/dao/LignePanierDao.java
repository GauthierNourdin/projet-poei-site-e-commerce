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
				PreparedStatement ps = c.prepareStatement(
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
				PreparedStatement ps = c.prepareStatement("UPDATE LignePanier SET quantiteSouhaitee=? WHERE id=?;");
				ps.setInt(1, lignePanier.getQuantiteSouhaitee());
				ps.setInt(2, lignePanier.getId());
				int nbr = ps.executeUpdate();
				if (nbr == 1) {
					return lignePanier;
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

}
