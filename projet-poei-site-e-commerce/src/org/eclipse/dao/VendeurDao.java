package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.Vendeur;

public class VendeurDao implements Dao<Vendeur> {

	public Vendeur save(Vendeur vendeur) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"INSERT INTO Utilisateur (nom,prenom,adresseMail,numeroTelephone,identifiantConnexion,motDePasse,type) VALUES (?,?,?,?,?,?,'vendeur');",
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
				PreparedStatement ps = c.prepareStatement("DELETE FROM Adresse WHERE idUtilisateur=?;");
				ps.setInt(1, vendeur.getIdUtilisateur());
				ps.executeUpdate();

				ProduitDao produitDao = new ProduitDao();
				produitDao.removeByVendeur(vendeur.getIdUtilisateur());
				
				ps = c.prepareStatement("UPDATE Commentaire SET idUtilisateur=NULL WHERE idUtilisateur=?;");
				ps.setInt(1, vendeur.getIdUtilisateur());
				ps.executeUpdate();

				ps = c.prepareStatement("DELETE FROM Utilisateur WHERE id=?;");
				ps.setInt(1, vendeur.getIdUtilisateur());
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
				PreparedStatement ps = c.prepareStatement("UPDATE Vendeur SET nom=?, prenom=?, adresseMail=?, numeroTelephone=?, identifiantConnexion=?, motDePasse=? WHERE id=?;");
				ps.setString(1, vendeur.getNom());
				ps.setString(2, vendeur.getPrenom());
				ps.setString(3, vendeur.getAdresseMail());
				ps.setString(4, vendeur.getNumeroTelephone());
				ps.setString(5, vendeur.getIdentifiantConnexion());
				ps.setString(6, vendeur.getMotDePasse());
				ps.setInt(7, vendeur.getIdUtilisateur());
				int nbr = ps.executeUpdate();
				if (nbr == 1) {
					return vendeur;
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
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Utilisateur WHERE id=? AND typeU LIKE 'vendeur';");
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
					ArrayList<Integer> idProduits = new ArrayList<Integer>();
					
					PreparedStatement ps2 = c.prepareStatement("SELECT id FROM Adresse WHERE idUtilisateur=?;");
					ps2.setInt(1, id);
					ResultSet result2 = ps2.executeQuery();
					while(result2.next()) {
						int idAdresse = result2.getInt("id");
						idAdresses.add(idAdresse);
					}
					
					PreparedStatement ps3 = c.prepareStatement("SELECT id FROM Produit WHERE idUtilisateur=?;");
					ps3.setInt(1, id);
					ResultSet result3 = ps3.executeQuery();
					while(result3.next()) {
						int idProduit = result3.getInt("id");
						idProduits.add(idProduit);
					}
					
					Vendeur vendeur = new Vendeur(id, nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, idAdresses, idProduits);
					return vendeur;
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
				ArrayList<Vendeur> vendeurs = new ArrayList<Vendeur>();
				
				Statement statement = c.createStatement();
				String request = "SELECT * FROM Utilisateur WHERE typeU LIKE 'vendeur';";
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
					ArrayList<Integer> idProduits = new ArrayList<Integer>();
					
					PreparedStatement ps2 = c.prepareStatement("SELECT id FROM Adresse WHERE idUtilisateur=?;");
					ps2.setInt(1, id);
					ResultSet result2 = ps2.executeQuery();
					while(result2.next()) {
						int idAdresse = result2.getInt("id");
						idAdresses.add(idAdresse);
					}
					
					PreparedStatement ps3 = c.prepareStatement("SELECT id FROM Produit WHERE idUtilisateur=?;");
					ps3.setInt(1, id);
					ResultSet result3 = ps3.executeQuery();
					while(result3.next()) {
						int idProduit = result3.getInt("id");
						idProduits.add(idProduit);
					}
					
					Vendeur vendeur = new Vendeur(id, nom, prenom, adresseMail, numeroTelephone, identifiantConnexion, motDePasse, idAdresses, idProduits);
					vendeurs.add(vendeur);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
