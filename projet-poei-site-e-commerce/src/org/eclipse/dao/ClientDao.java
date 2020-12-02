package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.Client;

public class ClientDao implements Dao<Client> {

	public Client save(Client client) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"INSERT INTO Utilisateur (nom,prenom,adresseMail,numeroTelephone,identifiantConnexion,motDePasse,typeU) VALUES (?,?,?,?,?,?,'client');",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, client.getNom());
				ps.setString(2, client.getPrenom());
				ps.setString(3, client.getAdresseMail());
				ps.setString(4, client.getNumeroTelephone());
				ps.setString(5, client.getIdentifiantConnexion());
				ps.setString(6, client.getMotDePasse());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					client.setIdUtilisateur(resultat.getInt(1));
					return client;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void remove(Client client) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM Adresse WHERE idUtilisateur=?;");
				ps.setInt(1, client.getIdUtilisateur());
				ps.executeUpdate();

				ps = c.prepareStatement("UPDATE Commande SET idUtilisateur=NULL WHERE idUtilisateur=?;");
				ps.setInt(1, client.getIdUtilisateur());
				ps.executeUpdate();
				
				ps = c.prepareStatement("DELETE FROM LignePanier WHERE idUtilisateur=?;");
				ps.setInt(1, client.getIdUtilisateur());
				ps.executeUpdate();
				
				ps = c.prepareStatement("UPDATE Commentaire SET idUtilisateur=NULL WHERE idUtilisateur=?;");
				ps.setInt(1, client.getIdUtilisateur());
				ps.executeUpdate();

				ps = c.prepareStatement("DELETE FROM Utilisateur WHERE id=?;");
				ps.setInt(1, client.getIdUtilisateur());
				int nbr = ps.executeUpdate();
				if (nbr != 1) {
					System.err.println("Erreur : Absence de suppression");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Client update(Client client) {
		Connection c = MyConnection.getConnection();
		
		if (c != null) {
			try {
				
				PreparedStatement ps = c.prepareStatement("UPDATE Vendeur SET nom=?, prenom=?, adresseMail=?, numeroTelephone=?, identifiantConnexion=?, motDePasse=? WHERE id=?;");
				ps.setString(1, client.getNom());
				ps.setString(2, client.getPrenom());
				ps.setString(3, client.getAdresseMail());
				ps.setString(4, client.getNumeroTelephone());
				ps.setString(5, client.getIdentifiantConnexion());
				ps.setString(6, client.getMotDePasse());
				ps.setInt(7, client.getIdUtilisateur());
				int nbr = ps.executeUpdate();
				if (nbr == 1) {
					return client;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Client findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Utilisateur WHERE id=? AND typeU LIKE 'client';");
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();
				
				if (result.next()) {
					String nom = result.getString("nom");
					String prenom = result.getString("prenom");
					String adresseMail = result.getString("adresseMail");
					String numeroTelephone = result.getString("numeroTelephone");
					String identifiantConnexion = result.getString("identifiantConnexion");
					String motDePasse = result.getString("motDePasse");
					
					ArrayList<Integer> idAdresses = new ArrayList<Integer>(); 
					ArrayList<Integer> idCommandes = new ArrayList<Integer>();
					ArrayList<Integer> idLignesPanier = new ArrayList<Integer>();
					
					PreparedStatement ps2 = c.prepareStatement("SELECT id FROM Adresse WHERE idUtilisateur=?;");
					ps2.setInt(1, id);
					ResultSet result2 = ps2.executeQuery();
					while(result2.next()) {
						int idAdresse = result2.getInt("id");
						idAdresses.add(idAdresse);
					}
					
					PreparedStatement ps3 = c.prepareStatement("SELECT id FROM Commande WHERE idUtilisateur=?;");
					ps3.setInt(1, id);
					ResultSet result3 = ps3.executeQuery();
					while(result3.next()) {
						int idCommande = result3.getInt("id");
						idCommandes.add(idCommande);
					}
					
					PreparedStatement ps4 = c.prepareStatement("SELECT id FROM LignePanier WHERE idUtilisateur=?;");
					ps4.setInt(1, id);
					ResultSet result4 = ps4.executeQuery();
					while(result4.next()) {
						int idLignePanier = result4.getInt("id");
						idLignesPanier.add(idLignePanier);
					}
					
					Client client = new Client(id, nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, idAdresses, idCommandes, idLignesPanier);
					return client;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Client> findAll() {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				ArrayList<Client> clients = new ArrayList<Client>();
				
				Statement statement = c.createStatement();
				String request = "SELECT * FROM Utilisateur WHERE typeU LIKE 'client';";
				ResultSet result = statement.executeQuery(request);
				
				while (result.next()) {
					int id = result.getInt("idUtilisateur");
					String nom = result.getString("nom");
					String prenom = result.getString("prenom");
					String adresseMail = result.getString("adresseMail");
					String numeroTelephone = result.getString("numeroTelephone");
					String identifiantConnexion = result.getString("identifiantConnexion");
					String motDePasse = result.getString("motDePasse");
					
					ArrayList<Integer> idAdresses = new ArrayList<Integer>(); 
					ArrayList<Integer> idCommandes = new ArrayList<Integer>();
					ArrayList<Integer> idLignesPanier = new ArrayList<Integer>();
					
					PreparedStatement ps2 = c.prepareStatement("SELECT id FROM Adresse WHERE idUtilisateur=?;");
					ps2.setInt(1, id);
					ResultSet result2 = ps2.executeQuery();
					while(result2.next()) {
						int idAdresse = result2.getInt("id");
						idAdresses.add(idAdresse);
					}
					
					PreparedStatement ps3 = c.prepareStatement("SELECT id FROM Commande WHERE idUtilisateur=?;");
					ps3.setInt(1, id);
					ResultSet result3 = ps3.executeQuery();
					while(result3.next()) {
						int idCommande = result3.getInt("id");
						idCommandes.add(idCommande);
					}
					
					PreparedStatement ps4 = c.prepareStatement("SELECT id FROM LignePanier WHERE idUtilisateur=?;");
					ps4.setInt(1, id);
					ResultSet result4 = ps4.executeQuery();
					while(result4.next()) {
						int idLignePanier = result4.getInt("id");
						idLignesPanier.add(idLignePanier);
					}
					
					Client client = new Client(id, nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, idAdresses, idCommandes, idLignesPanier);
					clients.add(client);
				}
				return clients;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// Recherche d'utilisateur par identifiant de connexion. Renvoie un client avec seulement un id.
	public Client findByIdentifiantConnexion(String identifiantConnexion) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				
				PreparedStatement ps = c.prepareStatement("SELECT id FROM Utilisateur WHERE identifiantConnexion = BINARY ?;");
				ps.setString(1, identifiantConnexion);
				ResultSet result = ps.executeQuery();
				
				if (result.next()) {
					int idUtilisateur = result.getInt("id");
				
					Client client = new Client(idUtilisateur);
					return client;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// Recherche de client par identifiant de connexion et mot de passe. Renvoie un client complet.
	public Client findByIdentifiantConnexionAndMotDePasse(String identifiantConnexion, String motDePasse) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Utilisateur WHERE identifiantConnexion = BINARY ? AND motDePasse = BINARY ? AND typeU LIKE 'client';");
				ps.setString(1, identifiantConnexion);
				ps.setString(2, motDePasse);
				ResultSet result = ps.executeQuery();
				
				if (result.next()) {
					int id = result.getInt("id");
					String nom = result.getString("nom");
					String prenom = result.getString("prenom");
					String adresseMail = result.getString("adresseMail");
					String numeroTelephone = result.getString("numeroTelephone");
					
					ArrayList<Integer> idAdresses = new ArrayList<Integer>(); 
					ArrayList<Integer> idCommandes = new ArrayList<Integer>();
					ArrayList<Integer> idLignesPanier = new ArrayList<Integer>();
					
					PreparedStatement ps2 = c.prepareStatement("SELECT id FROM Adresse WHERE idUtilisateur=?;");
					ps2.setInt(1, id);
					ResultSet result2 = ps2.executeQuery();
					while(result2.next()) {
						int idAdresse = result2.getInt("id");
						idAdresses.add(idAdresse);
					}
					
					PreparedStatement ps3 = c.prepareStatement("SELECT id FROM Commande WHERE idUtilisateur=?;");
					ps3.setInt(1, id);
					ResultSet result3 = ps3.executeQuery();
					while(result3.next()) {
						int idCommande = result3.getInt("id");
						idCommandes.add(idCommande);
					}
					
					PreparedStatement ps4 = c.prepareStatement("SELECT id FROM LignePanier WHERE idUtilisateur=?;");
					ps4.setInt(1, id);
					ResultSet result4 = ps4.executeQuery();
					while(result4.next()) {
						int idLignePanier = result4.getInt("id");
						idLignesPanier.add(idLignePanier);
					}
					
					Client client = new Client(id, nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, idAdresses, idCommandes, idLignesPanier);
					return client;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
