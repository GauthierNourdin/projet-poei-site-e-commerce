package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.model.Produit;
import org.eclipse.model.Vendeur;
import org.eclipse.service.ProduitService;

@WebServlet("/vendeur/produit/suppression")
public class VendeurProduitSuppressionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("idproduit") != null) {
			int idProduit = Integer.parseInt(request.getParameter("idproduit"));
			ProduitService produitService = new ProduitService();
			Produit produit = produitService.findById(idProduit);
			request.setAttribute("produit", produit);
			this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/produit/modification.jsp").forward(request, response);
			return;
		}
		response.sendRedirect("../produits");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		HttpSession session = request.getSession();
		Vendeur vendeur = (Vendeur) session.getAttribute("vendeur");
		int idProduit = Integer.parseInt(request.getParameter("idproduit"));
		ProduitService produitService = new ProduitService();
		Produit produit = produitService.findById(idProduit);
		request.setAttribute("produit", produit);
		
		if(vendeur.getIdentifiantConnexion().equals(identifiant) && vendeur.getMotDePasse().equals(motDePasse) ) {
			try {
				produitService.remove(produit);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("erreurSuppression", e.getMessage());
				request.setAttribute("produit", produit);
				this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/produit/suppression.jsp").forward(request, response);
			}	
			try {
				ArrayList<Integer> idProduits = vendeur.getIdProduits();
				idProduits.remove(Integer.valueOf(produit.getId()));
				vendeur.setIdProduits(idProduits);
				session.setAttribute("vendeur", vendeur);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("erreurSuppression", e.getMessage());
				request.setAttribute("produit", produit);
				this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/produit/suppression.jsp").forward(request, response);
			}
			response.sendRedirect("../produits");
		} else {
			request.setAttribute("erreurConnexion", "L'identifiant ou le mot de passe est incorrect.");
			request.setAttribute("produit", produit);
			this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/produit/suppression.jsp").forward(request, response);
		}
		
	}

}
