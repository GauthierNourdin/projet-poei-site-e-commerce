package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.model.Panier;
import org.eclipse.model.Produit;
import org.eclipse.service.ProduitService;

@WebServlet({"/home"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("panier") == null && session.getAttribute("vendeur") == null) {
			Panier panier = new Panier();
			session.setAttribute("panier", panier);
		}
		ArrayList<Produit> produits = ProduitService.findDisponibles();
		request.setAttribute("produits", produits);
		this.getServletContext().getRequestDispatcher("/home/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Méthode pour rechercher par nom un produit
	}

}
