package org.eclipse.controller;

import java.io.IOException;
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("idproduit") != null) {
			// Recherche des données produits
			int idProduit = Integer.parseInt(request.getParameter("idproduit"));
			Produit produit = ProduitService.findById(idProduit);
			request.setAttribute("produit", produit);
			
			/* Fonction pour vérifier qu'une ligne de produit du panier ne correspond pas au produit */
			HttpSession session = request.getSession();
			Client client = (Client) session.getAttribute("client");
			
			try {
				ClientService.verifierPanier(client);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			for (int idLignePanier : client.getIdLignesPanier()) {
				LignePanier lignePanier = LignePanierService.findById(idLignePanier);
				if (lignePanier != null) {
					Produit produitLignePanier = ProduitService.findById(lignePanier.getIdProduit());
					if (produit.getId() == produitLignePanier.getId()) {
						request.setAttribute("lignepanier", lignePanier);
					}
				}
			}
			
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/produit/produit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("client");
		
		String methode = request.getParameter("methode");
		String methode2 = request.getParameter("methode");
		
		if (methode2 != null) { // Condition pour supprimer la ligne de panier
			int idLignePanier = Integer.parseInt(request.getParameter("idLignePanier"));
			LignePanier lignePanier = LignePanierService.findById(idLignePanier);
			
			try {
				ClientService.supprimerLignePanier (client, lignePanier);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			if (methode.equals("ajouter")) { // Condition pour ajouter une ligne de panier
				
				int idProduit = Integer.parseInt(request.getParameter("idProduit"));
				Produit produit = ProduitService.findById(idProduit);
				int quantiteSouhaitee = Integer.parseInt(request.getParameter("quantite"));
				
				try {
					ClientService.ajouterLignePanier (client, produit, quantiteSouhaitee);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (methode.equals("modifier")) { // Condition pour modifier la ligne de panier
				int idLignePanier = Integer.parseInt(request.getParameter("idLignePanier"));
				LignePanier lignePanier = LignePanierService.findById(idLignePanier);
				int quantiteSouhaitee = Integer.parseInt(request.getParameter("quantite"));
				
				try {
					ClientService.modifierLignePanier (client, lignePanier, quantiteSouhaitee);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		response.sendRedirect("../home");
	}

}
