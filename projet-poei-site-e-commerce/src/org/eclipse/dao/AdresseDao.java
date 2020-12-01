package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.Adresse;

public class AdresseDao implements Dao<Adresse> {

	public Adresse save(Adresse adresse) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"INSERT INTO Adresse (numeroDansRue,rue,ville,codePostal,pays,complementAdresse,idUtilisateur) VALUES (?,?,?,?,?,?,?);",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, adresse.getNumeroDansRue());
				ps.setString(2, adresse.getRue());
				ps.setString(3, adresse.getVille());
				ps.setString(4, adresse.getCodePostal());
				ps.setString(5, adresse.getPays());
				ps.setString(6, adresse.getComplementAdresse());
				ps.setInt(7, adresse.getIdUtilisateur());				
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					adresse.setId(resultat.getInt(1));
					return adresse;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void remove(Adresse adresse) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM Adresse WHERE id=?;");
				ps.setInt(1, adresse.getId());
				int nbr = ps.executeUpdate();
				if (nbr != 1) {
					System.err.println("Erreur : Absence de suppression");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Adresse update(Adresse adresse) {
		Connection c = MyConnection.getConnection();
		
		if (c != null) {
			try {
				
				PreparedStatement ps = c.prepareStatement("UPDATE Adresse SET numeroDansRue=?, rue=?, ville=?, codePostal=?, pays=?, complementAdresse=? WHERE id=?;");
				ps.setString(1, adresse.getNumeroDansRue());
				ps.setString(2, adresse.getRue());
				ps.setString(3, adresse.getVille());
				ps.setString(4, adresse.getCodePostal());
				ps.setString(5, adresse.getPays());
				ps.setString(6, adresse.getComplementAdresse());
				ps.setInt(7, adresse.getId());
				int nbr = ps.executeUpdate();
				if (nbr == 1) {
					return adresse;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Adresse findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Adresse WHERE id=?;");
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();
				
				if (result.next()) {
					String numeroDansRue = result.getString("numeroDansRue");
					String rue = result.getString("rue");
					String ville = result.getString("ville");
					String codePostal = result.getString("codePostal");
					String pays = result.getString("pays");
					String complementAdresse = result.getString("complementAdresse");
					int idUtilisateur = result.getInt("idUtilisateur");
					
					Adresse adresse = new Adresse(numeroDansRue, rue, ville, codePostal, pays, complementAdresse, idUtilisateur, id);
					return adresse;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Adresse> findAll() {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				ArrayList<Adresse> adresses = new ArrayList<Adresse>();
				
				Statement statement = c.createStatement();
				String request = "SELECT * FROM Adresse;";
				ResultSet result = statement.executeQuery(request);
				
				while (result.next()) {
					int id = result.getInt("id");
					String numeroDansRue = result.getString("numeroDansRue");
					String rue = result.getString("rue");
					String ville = result.getString("ville");
					String codePostal = result.getString("codePostal");
					String pays = result.getString("pays");
					String complementAdresse = result.getString("complementAdresse");
					int idUtilisateur = result.getInt("idUtilisateur");
					
					Adresse adresse = new Adresse(numeroDansRue, rue, ville, codePostal, pays, complementAdresse, idUtilisateur, id);
					adresses.add(adresse);
				}
				return adresses;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// Recherche d'adresse d'un utilisateur. Renvoie une liste d'adresses complètes.
	public List<Adresse> findByUtilisateur(int idUtilisateur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				ArrayList<Adresse> adresses = new ArrayList<Adresse>();
				
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Adresse WHERE idUtilisateur=?;");
				ps.setInt(1, idUtilisateur);
				ResultSet result = ps.executeQuery();
				
				while (result.next()) {
					int id = result.getInt("id");
					String numeroDansRue = result.getString("numeroDansRue");
					String rue = result.getString("rue");
					String ville = result.getString("ville");
					String codePostal = result.getString("codePostal");
					String pays = result.getString("pays");
					String complementAdresse = result.getString("complementAdresse");
					
					Adresse adresse = new Adresse(numeroDansRue, rue, ville, codePostal, pays, complementAdresse, idUtilisateur, id);
					adresses.add(adresse);
				}
				return adresses;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
