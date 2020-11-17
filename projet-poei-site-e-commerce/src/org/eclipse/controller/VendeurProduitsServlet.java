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

@WebServlet("/vendeur/produits")
public class VendeurProduitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Vendeur vendeur = (Vendeur) session.getAttribute("vendeur");
		ArrayList<Produit> produits = ProduitService.findByVendeur(vendeur.getId());
		request.setAttribute("produits", produits);
		this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/produits.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
