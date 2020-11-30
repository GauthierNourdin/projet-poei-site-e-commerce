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

@WebServlet("/client/panier")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<LignePanierAffichage> lignesPanierAffichage = new ArrayList<LignePanierAffichage>();
		int nombreArticles = 0;
		double prixTotal = 0;

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
				Produit produit = ProduitService.findById(lignePanier.getIdProduit());
				if (produit != null) {
					LignePanierAffichage lignePanierAffichage = new LignePanierAffichage(lignePanier.getId(),
							lignePanier.getQuantiteSouhaitee(), produit.getPrixUnitaire(), produit.getDesignation(),
							produit.getUrlImage());
					lignesPanierAffichage.add(lignePanierAffichage);
					nombreArticles += lignePanier.getQuantiteSouhaitee();
					prixTotal += lignePanier.getQuantiteSouhaitee() * produit.getPrixUnitaire();
				}
			}
		}
		
		request.setAttribute("lignesPanier", lignesPanierAffichage);
		request.setAttribute("nombreArticles", nombreArticles);
		request.setAttribute("prixTotal", prixTotal);

		this.getServletContext().getRequestDispatcher("/WEB-INF/client/panier.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String viderPanier = request.getParameter("viderpanier");
		String validerPanier = request.getParameter("validerpanier");

		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("client");
		
		if (viderPanier != null) { // Condition pour vider le panier 
			
			try {
				ClientService.viderPanier(client);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (validerPanier != null) { // Condition pour valider le panier
			
			try {
				ClientService.validerPanier(client);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		response.sendRedirect("../home");
	}

}
