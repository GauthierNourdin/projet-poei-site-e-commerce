package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.Categorie;

public class CategorieDao implements Dao<Categorie> {

	public Categorie save(Categorie categorie) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"INSERT INTO Categorie (categorie) VALUES (?);",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, categorie.getNom());			
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					categorie.setId(resultat.getInt(1));
					return categorie;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void remove(Categorie categorie) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM ProduitCategorie WHERE idCategorie=?;");
				ps.setInt(1, categorie.getId());
				ps.executeUpdate();

				ps = c.prepareStatement("DELETE FROM Categorie WHERE id=?;");
				ps.setInt(1, categorie.getId());
				int nbr = ps.executeUpdate();
				if (nbr != 1) {
					System.err.println("Erreur : Absence de suppression");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Categorie update(Categorie categorie) {
Connection c = MyConnection.getConnection();
		
		if (c != null) {
			try {				
				PreparedStatement ps = c.prepareStatement("UPDATE Categorie SET categorie=? WHERE id=?;");
				ps.setString(1, categorie.getNom());
				ps.setInt(2, categorie.getId());
				int nbr = ps.executeUpdate();
				if (nbr == 1) {
					return categorie;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Categorie findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Categorie WHERE id=?;");
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();
				
				if (result.next()) {
					String nom = result.getString("categorie");
					
					Categorie categorie = new Categorie(id, nom);
					return categorie;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Categorie> findAll() {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				ArrayList<Categorie> categories = new ArrayList<Categorie>();
				
				Statement statement = c.createStatement();
				String request = "SELECT * FROM Categorie;";
				ResultSet result = statement.executeQuery(request);
				
				if (result.next()) {
					int id = result.getInt("id");
					String nom = result.getString("categorie");
					
					Categorie categorie = new Categorie(id, nom);
					categories.add(categorie);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
