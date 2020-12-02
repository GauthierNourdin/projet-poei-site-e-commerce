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
import org.eclipse.model.Commande;

public class CommandeDao implements Dao<Commande> {

	public Commande save(Commande commande) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"INSERT INTO Commande (dateCommande,idUtilisateur) VALUES (?,?);",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setDate(1, commande.getDateDeCommande());
				ps.setInt(2, commande.getIdClient());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					commande.setId(resultat.getInt(1));
					return commande;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void remove(Commande commande) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM LigneCommande WHERE idCommande=?;");
				ps.setInt(1, commande.getId());
				ps.executeUpdate();

				ps = c.prepareStatement("DELETE FROM Commande WHERE id=?;");
				ps.setInt(1, commande.getId());
				int nbr = ps.executeUpdate();
				if (nbr != 1) {
					System.err.println("Erreur : Absence de suppression");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Commande update(Commande commande) {
Connection c = MyConnection.getConnection();
		
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("UPDATE Commande SET dateCommande=? WHERE id=?;");
				ps.setDate(1, (Date) commande.getDateDeCommande());
				ps.setInt(2, commande.getId());
				int nbr = ps.executeUpdate();
				if (nbr == 1) {
					return commande;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Commande findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Commande WHERE id=?;");
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();
				
				if (result.next()) {
					Date dateDeCommande = result.getDate("dateCommande");
					int idClient = result.getInt("idUtilisateur");
					
					ArrayList<Integer> idLignesCommande = new ArrayList<Integer>();
					
					PreparedStatement ps2 = c.prepareStatement("SELECT id FROM LigneCommande WHERE idCommande=?;");
					ps2.setInt(1, id);
					ResultSet result2 = ps2.executeQuery();
					while(result2.next()) {
						int idLigneCommande = result2.getInt("id");
						idLignesCommande.add(idLigneCommande);
					}
					
					Commande commande = new Commande(id, idClient, idLignesCommande, dateDeCommande);
					return commande;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Commande> findAll() {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				ArrayList<Commande> commandes = new ArrayList<Commande>();
				
				Statement statement = c.createStatement();
				String request = "SELECT * FROM Commande;";
				ResultSet result = statement.executeQuery(request);
				
				while (result.next()) {
					int id = result.getInt("id");
					Date dateDeCommande = result.getDate("dateCommande");
					int idClient = result.getInt("idUtilisateur");
					
					ArrayList<Integer> idLignesCommande = new ArrayList<Integer>();
					
					PreparedStatement ps2 = c.prepareStatement("SELECT id FROM LigneCommande WHERE idCommande=?;");
					ps2.setInt(1, id);
					ResultSet result2 = ps2.executeQuery();
					while(result2.next()) {
						int idLigneCommande = result2.getInt("id");
						idLignesCommande.add(idLigneCommande);
					}
					
					Commande commande = new Commande(id, idClient, idLignesCommande, dateDeCommande);
					commandes.add(commande);
				}
				return commandes;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<Commande> findByClient(int idClient) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				ArrayList<Commande> commandes = new ArrayList<Commande>();
				
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Commande WHERE idUtilisateur=?;");
				ps.setInt(1, idClient);
				ResultSet result = ps.executeQuery();
				
				while (result.next()) {
					int id = result.getInt("id");
					Date dateDeCommande = result.getDate("dateCommande");
					
					ArrayList<Integer> idLignesCommande = new ArrayList<Integer>();
					
					PreparedStatement ps2 = c.prepareStatement("SELECT id FROM LigneCommande WHERE idCommande=?;");
					ps2.setInt(1, id);
					ResultSet result2 = ps2.executeQuery();
					while(result2.next()) {
						int idLigneCommande = result2.getInt("id");
						idLignesCommande.add(idLigneCommande);
					}
					
					Commande commande = new Commande(id, idClient, idLignesCommande, dateDeCommande);
					commandes.add(commande);
				}
				return commandes;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
