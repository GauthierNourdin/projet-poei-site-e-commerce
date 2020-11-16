package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.model.Utilisateur;
import org.eclipse.model.Vendeur;
import org.eclipse.service.VendeurService;

@WebServlet("/vendeur/connexion")
public class AuthentificationVendeurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/vendeur/connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		Vendeur vendeur = VendeurService.connectionVendeur(identifiant, motDePasse);

		if (vendeur != null) {
			HttpSession session = request.getSession();
			session.setAttribute("vendeur", vendeur);
			this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/mesProduits.jsp").forward(request,
					response);
		} else {
			request.setAttribute("erreurConnexion", "L'identifiant ou le mot de passe est incorrect.");
			this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/connexion.jsp").forward(request, response);
		}

	}

}
