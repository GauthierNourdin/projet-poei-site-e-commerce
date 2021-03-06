package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.LignePanier;
import org.eclipse.service.LignePanierService;

@WebServlet("/panier/retirerligne")
public class PanierRetirerLigneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Méthode appelée par javax pour retirer dynamiquement une ligne du panier
		
		String confirmation = "true";
		int idLignePanier = Integer.parseInt(request.getParameter("idlignepanier"));

		LignePanierService lignePanierService = new LignePanierService();
		LignePanier lignePanier = lignePanierService.findById(idLignePanier);
		if (lignePanier != null) {
			try {
				lignePanierService.remove(lignePanier);
			} catch (Exception e) {
				confirmation = "false";
			}
		} else {
			confirmation = "false";
		}

		response.getWriter().write("<confirmation>" + confirmation + "</confirmation>");
	}

}
