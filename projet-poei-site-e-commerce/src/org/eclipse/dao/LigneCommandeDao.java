package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.LigneCommande;

public class LigneCommandeDao implements Dao<LigneCommande> {

	public LigneCommande save(LigneCommande ligneCommande) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"INSERT INTO LigneCommande (quantiteCommande,prixUnit,idCommande,idProduit) VALUES (?,?,?,?);",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(1, ligneCommande.getQuantiteCommandee());
				ps.setDouble(2, ligneCommande.getPrixUnitaire());
				ps.setInt(3, ligneCommande.getIdCommande());
				ps.setInt(4, ligneCommande.getIdProduit());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					ligneCommande.setId(resultat.getInt(1));
					return ligneCommande;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void remove(LigneCommande ligneCommande) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM LigneCommande WHERE id=?;");
				ps.setInt(1, ligneCommande.getId());
				int nbr = ps.executeUpdate();
				if (nbr != 1) {
					System.err.println("Erreur : Absence de suppression");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public LigneCommande update(LigneCommande ligneCommande) {
		Connection c = MyConnection.getConnection();
		
		if (c != null) {
			try {				
				PreparedStatement ps = c.prepareStatement("UPDATE LigneCommande SET quantiteCommande=?, prixUnit=? WHERE id=?;");
				ps.setInt(1, ligneCommande.getQuantiteCommandee());
				ps.setDouble(2, ligneCommande.getPrixUnitaire());
				ps.setInt(3, ligneCommande.getId());
				int nbr = ps.executeUpdate();
				if (nbr == 1) {
					return ligneCommande;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public LigneCommande findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM LigneCommande WHERE id=?;");
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();
				
				if (result.next()) {
					int quantiteCommandee = result.getInt("quantiteCommande");
					double prixUnitaire = result.getDouble("prixUnit");					
					int idCommande = result.getInt("idCommande");
					int idProduit = result.getInt("idProduit");
					
					LigneCommande ligneCommande = new LigneCommande(id, quantiteCommandee, idCommande, idProduit, prixUnitaire);
					return ligneCommande;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<LigneCommande> findAll() {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				ArrayList<LigneCommande> lignesCommande = new ArrayList<LigneCommande>();
				
				Statement statement = c.createStatement();
				String request = "SELECT * FROM LigneCommande;";
				ResultSet result = statement.executeQuery(request);
				
				while (result.next()) {
					int id = result.getInt("id");
					int quantiteCommandee = result.getInt("quantiteCommande");
					double prixUnitaire = result.getDouble("prixUnit");					
					int idCommande = result.getInt("idCommande");
					int idProduit = result.getInt("idProduit");
					
					LigneCommande ligneCommande = new LigneCommande(id, quantiteCommandee, idCommande, idProduit, prixUnitaire);
					lignesCommande.add(ligneCommande);
				}
				return lignesCommande;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
