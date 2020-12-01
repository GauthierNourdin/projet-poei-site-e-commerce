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
import org.eclipse.model.Commentaire;

public class CommentaireDao implements Dao<Commentaire> {

	public Commentaire save(Commentaire commentaire) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				PreparedStatement ps;

				if (commentaire.getIdPrecedent() == 0) {
					ps = c.prepareStatement(
							"INSERT INTO Commentaire (dateCommande,texte,idCommentairePrecedent,idUtilisateur,idProduit) VALUES (?,?,?,?,?);",
							PreparedStatement.RETURN_GENERATED_KEYS);
					ps.setDate(1, (Date) commentaire.getDate());
					ps.setString(2, commentaire.getTexte());
					ps.setInt(3, commentaire.getIdPrecedent());
					ps.setInt(4, commentaire.getIdUtilisateur());
					ps.setInt(5, commentaire.getIdProduit());
				} else {
					ps = c.prepareStatement(
							"INSERT INTO Commentaire (dateCommande,texte,idCommentairePrecedent,idUtilisateur,idProduit) VALUES (?,?,NULL,?,?);",
							PreparedStatement.RETURN_GENERATED_KEYS);
					ps.setDate(1, (Date) commentaire.getDate());
					ps.setString(2, commentaire.getTexte());
					ps.setInt(3, commentaire.getIdUtilisateur());
					ps.setInt(4, commentaire.getIdProduit());
				}
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					commentaire.setId(resultat.getInt(1));
					return commentaire;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void remove(Commentaire commentaire) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				/*
				 * Cet appel permet de supprimer les commentaires faisant référence à ce
				 * commentaire et ainsi de suite. Cela ne fonctionne que si les commentaires
				 * sont organisés en arbre avec une seule référence sur le commentaire auquel il
				 * répond.
				 */
				PreparedStatement ps = c.prepareStatement("SELECT id FROM Commentaire WHERE idCommentairePrecedent=?");
				ps.setInt(1, commentaire.getId());
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int id = result.getInt("id");
					Commentaire commentaireRepondant = new Commentaire(id);
					remove(commentaireRepondant);
				}

				ps = c.prepareStatement("DELETE FROM Commentaire WHERE id=?;");
				ps.setInt(1, commentaire.getId());
				int nbr = ps.executeUpdate();
				if (nbr != 1) {
					System.err.println("Erreur : Absence de suppression");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Commentaire update(Commentaire commentaire) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				PreparedStatement ps = c
						.prepareStatement("UPDATE Commentaire SET dateCommentaire=?, texte=? WHERE id=?;");
				ps.setDate(1, (Date) commentaire.getDate());
				ps.setString(2, commentaire.getTexte());
				ps.setInt(3, commentaire.getId());
				int nbr = ps.executeUpdate();
				if (nbr == 1) {
					return commentaire;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Commentaire findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Commentaire WHERE id=?;");
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();

				if (result.next()) {
					Date date = result.getDate("dateCommentaire");
					String texte = result.getString("texte");
					int idPrecedent = result.getInt("idCommentairePrecedent");
					int idUtilisateur = result.getInt("idUtilisateur");
					int idProduit = result.getInt("idProduit");

					Commentaire commentaire = new Commentaire(date, idUtilisateur, idProduit, id, idPrecedent, texte);
					return commentaire;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Commentaire> findAll() {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				ArrayList<Commentaire> commentaires = new ArrayList<Commentaire>();

				Statement statement = c.createStatement();
				String request = "SELECT * FROM Commentaire;";
				ResultSet result = statement.executeQuery(request);

				while (result.next()) {
					int id = result.getInt("id");
					Date date = result.getDate("dateCommentaire");
					String texte = result.getString("texte");
					int idPrecedent = result.getInt("idCommentairePrecedent");
					int idUtilisateur = result.getInt("idUtilisateur");
					int idProduit = result.getInt("idProduit");

					Commentaire commentaire = new Commentaire(date, idUtilisateur, idProduit, id, idPrecedent, texte);
					commentaires.add(commentaire);
				}

				return commentaires;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// Méthode pour supprimer tous les commentaires relatifs à un produit.
	public void removeByProduit(int idProduit) {
		Connection c = MyConnection.getConnection();

		if (c != null) {
			try {
				/*
				 * On parcourt la liste des commentaires de ce produit n'ayant pas de
				 * commentaires auxquels ils répondent et on applique le code du remove.
				 * Normalement cela permet de supprimer tous les commentaires de ce produit.
				 */
				PreparedStatement ps = c.prepareStatement("SELECT id FROM Commentaire WHERE idCommentairePrecedent IS NULL AND idProduit=?");
				ps.setInt(1, idProduit);
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int id = result.getInt("id");
					Commentaire commentaire = new Commentaire(id);
					remove(commentaire);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Retourne tous les commentaires d'un produit. Les commentaires sont complets.
	public ArrayList<Commentaire> findByProduit(int idProduit) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				ArrayList<Commentaire> commentaires = new ArrayList<Commentaire>();

				PreparedStatement ps = c.prepareStatement("SELECT * FROM Commentaire WHERE idProduit=?;");
				ps.setInt(1, idProduit);
				ResultSet result = ps.executeQuery();

				while (result.next()) {
					int id = result.getInt("id");
					Date date = result.getDate("dateCommentaire");
					String texte = result.getString("texte");
					int idPrecedent = result.getInt("idCommentairePrecedent");
					int idUtilisateur = result.getInt("idUtilisateur");

					Commentaire commentaire = new Commentaire(date, idUtilisateur, idProduit, id, idPrecedent, texte);
					commentaires.add(commentaire);
				}

				return commentaires;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
