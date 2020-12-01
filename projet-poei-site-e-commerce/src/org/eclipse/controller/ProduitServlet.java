package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.model.Client;
import org.eclipse.model.LignePanier;
import org.eclipse.model.Produit;
import org.eclipse.service.ClientService;
import org.eclipse.service.LignePanierService;
import org.eclipse.service.ProduitService;

@WebServlet("/produit/produit")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("idproduit") != null) {
			// Recherche des données produits
			int idProduit = Integer.parseInt(request.getParameter("idproduit"));
			ProduitService produitService = new ProduitService();
			Produit produit = produitService.findById(idProduit);
			if (produit != null) {
				request.setAttribute("produit", produit);

				/*
				 * Fonction pour vérifier qu'une ligne de produit du panier ne correspond pas au
				 * produit
				 */
				HttpSession session = request.getSession();
				Client client = (Client) session.getAttribute("client");

				try {
					ClientService clientService = new ClientService();
					clientService.verifierPanier(client.getIdUtilisateur());
					
					LignePanierService lignePanierService = new LignePanierService();
					LignePanier lignePanierProduit = lignePanierService.findByClientAndProduit(client.getIdUtilisateur(), idProduit);
					if (lignePanierProduit != null) {
						request.setAttribute("lignepanier", lignePanierProduit);
					}

				} catch (Exception e) {
					e.printStackTrace();
					response.sendRedirect("../home");
				}

				this.getServletContext().getRequestDispatcher("/WEB-INF/produit/produit.jsp").forward(request,
						response);
			}
		}
		response.sendRedirect("../home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("client");

		String methode = request.getParameter("methode");
		String methode2 = request.getParameter("methode2");

		if (methode2 != null) { // Condition pour supprimer la ligne de panier
			int idLignePanier = Integer.parseInt(request.getParameter("idLignePanier"));
			LignePanierService lignePanierService = new LignePanierService();
			LignePanier lignePanier = lignePanierService.findById(idLignePanier);

			try {
				ClientService clientService = new ClientService();
				clientService.supprimerLignePanier(lignePanier);
				
				ArrayList<Integer> idLignesPanier = client.getIdLignesPanier();
				idLignesPanier.remove(lignePanier.getId());
				client.setIdLignesPanier(idLignesPanier);
				session.setAttribute("client", client);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			if (methode.equals("ajouter")) { // Condition pour ajouter une ligne de panier

				int idProduit = Integer.parseInt(request.getParameter("idProduit"));
				int quantiteSouhaitee = Integer.parseInt(request.getParameter("quantite"));

				try {
					ClientService clientService = new ClientService();
					LignePanier nouvelleLignePanier = clientService.ajouterLignePanier(client.getIdUtilisateur(), idProduit, quantiteSouhaitee);
					if (nouvelleLignePanier == null) {
						throw new Exception ("Erreur : absence de création de la nouvelle ligne de panier");
					}
					
					ArrayList<Integer> idLignesPanier = client.getIdLignesPanier();
					idLignesPanier.add(nouvelleLignePanier.getId());
					client.setIdLignesPanier(idLignesPanier);
					session.setAttribute("client", client);
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (methode.equals("modifier")) { // Condition pour modifier la ligne de panier
				int idLignePanier = Integer.parseInt(request.getParameter("idLignePanier"));
				LignePanierService lignePanierService = new LignePanierService();
				LignePanier lignePanier = lignePanierService.findById(idLignePanier);
				int quantiteSouhaitee = Integer.parseInt(request.getParameter("quantite"));

				try {
					ClientService clientService = new ClientService();
					LignePanier lignePanierMiseAJour = clientService.modifierLignePanier(lignePanier, quantiteSouhaitee);
					if (lignePanierMiseAJour == null) {
						throw new Exception ("Erreur : absence de création de la nouvelle ligne de panier");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

		response.sendRedirect("../home");
	}

}
