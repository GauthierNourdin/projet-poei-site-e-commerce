package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Produit;
import org.eclipse.service.ProduitService;

@WebServlet({"/home", "/index", ""})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Produit> produits = ProduitService.findDisponibles();
		request.setAttribute("produits", produits);
		this.getServletContext().getRequestDispatcher("/WEB-INF/home/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Méthode pour rechercher par nom un produit
		String nom = request.getParameter("nom");
		
		ArrayList<Produit> produits = ProduitService.findDisponibles();
		produits = ProduitService.filterName(produits, nom);
		request.setAttribute("produits", produits);
		request.setAttribute("nomSaisi", nom);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/home/home.jsp").forward(request, response);
	}

}