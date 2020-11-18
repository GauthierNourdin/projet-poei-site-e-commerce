package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Produit;
import org.eclipse.service.ProduitService;

@WebServlet("/produit/produit")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("idproduit") != null) {
			int idProduit = Integer.parseInt(request.getParameter("idproduit"));
			Produit produit = ProduitService.findById(idProduit);
			request.setAttribute("produit", produit);
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/produit/produit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Méthode pour ajouter un produit au panier puis le mettre a jour
		response.sendRedirect("../panier/panier");
	}

}
